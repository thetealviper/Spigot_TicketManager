package me.TheTealViper.ticketmanager;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.TheTealViper.ticketmanager.GUIS.categoryBugGUI;
import me.TheTealViper.ticketmanager.GUIS.categoryChatAbuseGUI;
import me.TheTealViper.ticketmanager.GUIS.categoryOtherGUI;
import me.TheTealViper.ticketmanager.GUIS.categoryStaffAbuseGUI;
import me.TheTealViper.ticketmanager.GUIS.categorySuggestionGUI;
import me.TheTealViper.ticketmanager.GUIS.closedTicketsGUI;
import me.TheTealViper.ticketmanager.GUIS.createTicketGUI;
import me.TheTealViper.ticketmanager.GUIS.mainAdminGUI;
import me.TheTealViper.ticketmanager.GUIS.mainGUI;
import me.TheTealViper.ticketmanager.GUIS.openTicketsGUI;
import me.TheTealViper.ticketmanager.GUIS.staffClosedTicketsGUI;
import me.TheTealViper.ticketmanager.GUIS.staffOpenTicketsGUI;
import me.TheTealViper.ticketmanager.GUIS.ticketGUI;
import me.TheTealViper.ticketmanager.utils.PluginFile;
import me.TheTealViper.ticketmanager.utils.UtilityEquippedJavaPlugin;

public class TicketManager extends UtilityEquippedJavaPlugin implements Listener{
	public static String prefix = makeColors("[&cTM&r] ");
	public static List<Ticket> tickets = new ArrayList<Ticket>();
	public static TicketManager plugin = null;
	public static boolean GUIClick;
	public static boolean debug = false;
	
	/*TODO
	 * Add in methods of sorting ----------------------------
	 * Add in alerts on ticket creation / closing ---------------------
	 * Add back button to ticket ------------------------
	 * Add gui clicks ----------------------
	 * Make players not be able to add ; to messages ----------------
	 * Handle current pages -----------------------
	 * Handle syntax --------------------
	 * Add custom categories -------------------
	 */
	
	public static boolean useSQL = false;
	public static SQLShit sql = null;
	public static PluginFile data = null;
	
	public void onEnable(){
		plugin = this;
		StartupPlugin(this, "50392");
		useSQL = getConfig().getBoolean("Use_SQL");
		GUIClick = getConfig().getBoolean("GUI_Click");
		itemHandler.plugin = this;
		createTicketGUI.plugin = this;
		ticketGUI.plugin = this;
		
		if(useSQL){
			sql = new SQLShit(getConfig().getString("SQL_Host"), getConfig().getString("SQL_Port"), getConfig().getString("SQL_Database"), getConfig().getString("SQL_Username"), getConfig().getString("SQL_Password"));
			sql.testTable("TicketManager", getConfig().getString("SQL_Database"));
		}else{
			data = new PluginFile(this, "tickets.data");
		}
		
		//Register event handlers
		Bukkit.getPluginManager().registerEvents(new categoryBugGUI(), this);
		Bukkit.getPluginManager().registerEvents(new categoryChatAbuseGUI(), this);
		Bukkit.getPluginManager().registerEvents(new categoryOtherGUI(), this);
		Bukkit.getPluginManager().registerEvents(new categoryStaffAbuseGUI(), this);
		Bukkit.getPluginManager().registerEvents(new categorySuggestionGUI(), this);
		Bukkit.getPluginManager().registerEvents(new closedTicketsGUI(), this);
		Bukkit.getPluginManager().registerEvents(new createTicketGUI(), this);
		Bukkit.getPluginManager().registerEvents(new mainAdminGUI(), this);
		Bukkit.getPluginManager().registerEvents(new mainGUI(), this);
		Bukkit.getPluginManager().registerEvents(new openTicketsGUI(), this);
		Bukkit.getPluginManager().registerEvents(new staffOpenTicketsGUI(), this);
		Bukkit.getPluginManager().registerEvents(new staffClosedTicketsGUI(), this);
		Bukkit.getPluginManager().registerEvents(new ticketGUI(), this);
		//Register command aliases
		try {
			final Field bukkitCommandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");
		    bukkitCommandMap.setAccessible(true);
		    CommandMap commandMap = (CommandMap) bukkitCommandMap.get(Bukkit.getServer());
			List<Command> commands = new ArrayList<>();
			for (String cmd : plugin.getConfig().getStringList("Command_Aliases")) {
				commands.add(new Command(cmd) {public boolean execute(CommandSender arg0, String arg1, String[] arg2) {
					return plugin.onCommand(arg0, this, arg1, arg2);
				}});
			}
		    commandMap.registerAll("TicketManager", commands);
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		loadTickets();
		
		try {
			File f = new File("plugins/TicketManager/messages.yml");
			if(!f.exists())
				Files.copy(getResource("messages.yml"), f.toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onDisable(){
		Bukkit.getLogger().info(makeColors("TicketManager from TheTealViper shutting down. Bshzzzzzz"));
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if(sender instanceof Player){
            Player p = (Player) sender;
            boolean explain = false;
//            boolean perms = false;
            if(label.equalsIgnoreCase("ticket") || true){ //There is only one label of importance so any commands running this function should pass
                if(args.length == 0){
                    mainGUI.open(p);
                }else if(args.length == 1){
                	if(args[0].equalsIgnoreCase("admin")){
                		if(p.hasPermission("ticketmanager.admin")){
                			mainAdminGUI.open(p);
                		}else{
                			mainGUI.open(p);
                		}
                	}else if(args[0].equalsIgnoreCase("reload")){
                		if(p.hasPermission("ticketmanager.admin")){
                			reload();
                			p.sendMessage("Reloaded");
                		}else{
                			mainGUI.open(p);
                		}
                	}else{
                		if(p.hasPermission("ticketmanager.admin")){
                			explain = true;
                		}else{
                			mainGUI.open(p);
                		}
                	}
                }else{
                	if(p.hasPermission("ticketmanager.admin")){
                		explain = true;
                	}else{
                		mainGUI.open(p);
                	}
                }
            }
            if(explain){
            	for(String s : messageHandler.getHelp(p))
            		p.sendMessage(s);
            }
        }
        return false;
    }
	
	public void reload(){
		reloadConfig();
		useSQL = getConfig().getBoolean("Use_SQL");
		GUIClick = getConfig().getBoolean("GUI_Click");
		
		if(useSQL){
			sql = new SQLShit(getConfig().getString("SQL_Host"), getConfig().getString("SQL_Port"), getConfig().getString("SQL_Database"), getConfig().getString("SQL_Username"), getConfig().getString("SQL_Password"));
			sql.testTable("TicketManager", getConfig().getString("SQL_Database"));
		}else{
			data = new PluginFile(this, "tickets.data");
		}
		
		tickets.clear();
		loadTickets();
	}
	
	public static void loadTickets(){
		if(useSQL){
			try {
				Statement statement = sql.connection.createStatement();
				ResultSet result = statement.executeQuery("SELECT * FROM TicketManager");
				int index = 0;
				while(result.next()){
//					System.out.println("WOWOWOWOWOWOWOWOWOWOWOWOWOWOWOW");
					tickets.add(Ticket.loadTicket("t" + index));
					index++;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else{
			for(String ticketID : data.getKeys(false)){
				tickets.add(Ticket.loadTicket(data, ticketID));
			}
		}
	}
	
	public static String makeColors(String s){
        String replaced = s
                .replaceAll("&0", "" + ChatColor.BLACK)
                .replaceAll("&1", "" + ChatColor.DARK_BLUE)
                .replaceAll("&2", "" + ChatColor.DARK_GREEN)
                .replaceAll("&3", "" + ChatColor.DARK_AQUA)
                .replaceAll("&4", "" + ChatColor.DARK_RED)
                .replaceAll("&5", "" + ChatColor.DARK_PURPLE)
                .replaceAll("&6", "" + ChatColor.GOLD)
                .replaceAll("&7", "" + ChatColor.GRAY)
                .replaceAll("&8", "" + ChatColor.DARK_GRAY)
                .replaceAll("&9", "" + ChatColor.BLUE)
                .replaceAll("&a", "" + ChatColor.GREEN)
                .replaceAll("&b", "" + ChatColor.AQUA)
                .replaceAll("&c", "" + ChatColor.RED)
                .replaceAll("&d", "" + ChatColor.LIGHT_PURPLE)
                .replaceAll("&e", "" + ChatColor.YELLOW)
                .replaceAll("&f", "" + ChatColor.WHITE)
                .replaceAll("&r", "" + ChatColor.RESET)
                .replaceAll("&l", "" + ChatColor.BOLD)
                .replaceAll("&o", "" + ChatColor.ITALIC)
                .replaceAll("&k", "" + ChatColor.MAGIC)
                .replaceAll("&m", "" + ChatColor.STRIKETHROUGH)
                .replaceAll("&n", "" + ChatColor.UNDERLINE)
                .replaceAll("\\\\", " ");
        return replaced;
    }
	
}
