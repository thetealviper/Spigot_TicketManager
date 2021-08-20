package me.TheTealViper.ticketmanager.GUIS;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.Inventory;

import me.TheTealViper.ticketmanager.Ticket;
import me.TheTealViper.ticketmanager.TicketManager;
import me.TheTealViper.ticketmanager.itemHandler;
import me.TheTealViper.ticketmanager.messageHandler;
import me.TheTealViper.ticketmanager.Utils.GuiClick;
import me.TheTealViper.ticketmanager.Utils.StringUtils;

public class createTicketGUI implements Listener{
	public static String CREATEIDENTIFIER = StringUtils.convertToInvisibleString("TSq");
	public static Map<Player, Integer> categoryMap = new HashMap<Player, Integer>();
	public static Map<Player, Integer> importanceMap = new HashMap<Player, Integer>();
	public static List<Player> messageListener = new ArrayList<Player>();
	public static List<Player> ignoreClose = new ArrayList<Player>();
	public static TicketManager plugin;
	
	public static void open(Player p){
		Inventory inv = Bukkit.createInventory(null, 45, StringUtils.makeColors(TicketManager.plugin.getConfig().getString("PlayerCreateTicketGUI_Name")) + CREATEIDENTIFIER);
		if(categoryMap.containsKey(p)){
			for(int i = 0;i < 9;i++)
				inv.setItem(i, itemHandler.getPlayerCreateTicketCategoryFiller(true));
			int selected = categoryMap.get(p);
			boolean select = selected == 1 ? true : false;
			inv.setItem(0, itemHandler.getPlayerCreateTicketCategoryOne(select));
			select = selected == 2 ? true : false;
			inv.setItem(2, itemHandler.getPlayerCreateTicketCategoryTwo(select));
			select = selected == 3 ? true : false;
			inv.setItem(4, itemHandler.getPlayerCreateTicketCategoryThree(select));
			select = selected == 4 ? true : false;
			inv.setItem(6, itemHandler.getPlayerCreateTicketCategoryFour(select));
			select = selected == 5 ? true : false;
			inv.setItem(8, itemHandler.getPlayerCreateTicketCategoryFive(select));
		}else{
			for(int i = 0;i < 9;i++)
				inv.setItem(i, itemHandler.getPlayerCreateTicketCategoryFiller(false));
			inv.setItem(0, itemHandler.getPlayerCreateTicketCategoryOne(false));
			inv.setItem(2, itemHandler.getPlayerCreateTicketCategoryTwo(false));
			inv.setItem(4, itemHandler.getPlayerCreateTicketCategoryThree(false));
			inv.setItem(6, itemHandler.getPlayerCreateTicketCategoryFour(false));
			inv.setItem(8, itemHandler.getPlayerCreateTicketCategoryFive(false));
		}
		if(importanceMap.containsKey(p)){
			for(int i = 0;i < 9;i++)
				inv.setItem(i + 18, itemHandler.getPlayerCreateTicketImportanceFiller(true));
			int selected = importanceMap.get(p);
			boolean select = selected == 1 ? true : false;
			inv.setItem(0 + 18, itemHandler.getPlayerCreateTicketImportanceOne(select));
			select = selected == 2 ? true : false;
			inv.setItem(2 + 18, itemHandler.getPlayerCreateTicketImportanceTwo(select));
			select = selected == 3 ? true : false;
			inv.setItem(4 + 18, itemHandler.getPlayerCreateTicketImportanceThree(select));
			select = selected == 4 ? true : false;
			inv.setItem(6 + 18, itemHandler.getPlayerCreateTicketImportanceFour(select));
			select = selected == 5 ? true : false;
			inv.setItem(8 + 18, itemHandler.getPlayerCreateTicketImportanceFive(select));
		}else{
			for(int i = 0;i < 9;i++)
				inv.setItem(i + 18, itemHandler.getPlayerCreateTicketImportanceFiller(false));
			inv.setItem(0 + 18, itemHandler.getPlayerCreateTicketImportanceOne(false));
			inv.setItem(2 + 18, itemHandler.getPlayerCreateTicketImportanceTwo(false));
			inv.setItem(4 + 18, itemHandler.getPlayerCreateTicketImportanceThree(false));
			inv.setItem(6 + 18, itemHandler.getPlayerCreateTicketImportanceFour(false));
			inv.setItem(8 + 18, itemHandler.getPlayerCreateTicketImportanceFive(false));
		}
		
		if(categoryMap.containsKey(p) && importanceMap.containsKey(p))
			inv.setItem(22 + 18, itemHandler.getPlayerCreateTicketFinalize(true));
		else
			inv.setItem(22 + 18, itemHandler.getPlayerCreateTicketFinalize(false));
		
		p.openInventory(inv);
	}
	
	@EventHandler
	public void onInventory(InventoryClickEvent e){
		if(e.getClickedInventory() != null && e.getClickedInventory().equals(e.getInventory())){
			if(ChatColor.stripColor(e.getView().getTitle()).contains(ChatColor.stripColor(CREATEIDENTIFIER))){
//				Bukkit.broadcastMessage("createTicket");
				e.setCancelled(true);
				if(e.getCurrentItem() == null)
					return;
				if(TicketManager.debug == true)
					Bukkit.broadcastMessage("7");
				Player p = (Player) e.getWhoClicked();
				if(e.getCurrentItem().isSimilar(itemHandler.getPlayerCreateTicketCategoryOne(false))){
					categoryMap.put(p, 1);
					ignoreClose.add(p);
					open(p);
					ignoreClose.remove(p);
					if(TicketManager.GUIClick)
						GuiClick.playClick((Player) e.getWhoClicked(), 1);
				}else if(e.getCurrentItem().isSimilar(itemHandler.getPlayerCreateTicketCategoryTwo(false))){
					categoryMap.put(p, 2);
					ignoreClose.add(p);
					open(p);
					ignoreClose.remove(p);
					if(TicketManager.GUIClick)
						GuiClick.playClick((Player) e.getWhoClicked(), 1);
				}else if(e.getCurrentItem().isSimilar(itemHandler.getPlayerCreateTicketCategoryThree(false))){
					categoryMap.put(p, 3);
					ignoreClose.add(p);
					open(p);
					ignoreClose.remove(p);
					if(TicketManager.GUIClick)
						GuiClick.playClick((Player) e.getWhoClicked(), 1);
				}else if(e.getCurrentItem().isSimilar(itemHandler.getPlayerCreateTicketCategoryFour(false))){
					categoryMap.put(p, 4);
					ignoreClose.add(p);
					open(p);
					ignoreClose.remove(p);
					if(TicketManager.GUIClick)
						GuiClick.playClick((Player) e.getWhoClicked(), 1);
				}else if(e.getCurrentItem().isSimilar(itemHandler.getPlayerCreateTicketCategoryFive(false))){
					categoryMap.put(p, 5);
					ignoreClose.add(p);
					open(p);
					ignoreClose.remove(p);
					if(TicketManager.GUIClick)
						GuiClick.playClick((Player) e.getWhoClicked(), 1);
				}else if(e.getCurrentItem().isSimilar(itemHandler.getPlayerCreateTicketImportanceOne(false))){
					importanceMap.put(p, 1);
					ignoreClose.add(p);
					open(p);
					ignoreClose.remove(p);
					if(TicketManager.GUIClick)
						GuiClick.playClick((Player) e.getWhoClicked(), 1);
				}else if(e.getCurrentItem().isSimilar(itemHandler.getPlayerCreateTicketImportanceTwo(false))){
					importanceMap.put(p, 2);
					ignoreClose.add(p);
					open(p);
					ignoreClose.remove(p);
					if(TicketManager.GUIClick)
						GuiClick.playClick((Player) e.getWhoClicked(), 1);
				}else if(e.getCurrentItem().isSimilar(itemHandler.getPlayerCreateTicketImportanceThree(false))){
					importanceMap.put(p, 3);
					ignoreClose.add(p);
					open(p);
					ignoreClose.remove(p);
					if(TicketManager.GUIClick)
						GuiClick.playClick((Player) e.getWhoClicked(), 1);
				}else if(e.getCurrentItem().isSimilar(itemHandler.getPlayerCreateTicketImportanceFour(false))){
					importanceMap.put(p, 4);
					ignoreClose.add(p);
					open(p);
					ignoreClose.remove(p);
					if(TicketManager.GUIClick)
						GuiClick.playClick((Player) e.getWhoClicked(), 1);
				}else if(e.getCurrentItem().isSimilar(itemHandler.getPlayerCreateTicketImportanceFive(false))){
					importanceMap.put(p, 5);
					ignoreClose.add(p);
					open(p);
					ignoreClose.remove(p);
					if(TicketManager.GUIClick)
						GuiClick.playClick((Player) e.getWhoClicked(), 1);
				}else if(e.getCurrentItem().isSimilar(itemHandler.getPlayerCreateTicketFinalize(true))){
					messageListener.add(p);
					p.closeInventory();
					for(String s : messageHandler.getCreateTicketMessagePrompt(p))
						p.sendMessage(s);
					if(TicketManager.GUIClick)
						GuiClick.playClick((Player) e.getWhoClicked(), 1);
				}
			}
		}
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onChat(AsyncPlayerChatEvent e){
		if(messageListener.contains(e.getPlayer())){
			messageListener.remove(e.getPlayer());
			e.setCancelled(true);
			String submittedBy = e.getPlayer().getName();
			String submissionDate = DateFormat.getDateTimeInstance().format(new Date(System.currentTimeMillis()));
			String category = "ERROR";
			switch(categoryMap.get(e.getPlayer())){
			case 1:
				category = plugin.getConfig().getString("Category_One");
				break;
			case 2:
				category = plugin.getConfig().getString("Category_Two");
				break;
			case 3:
				category = plugin.getConfig().getString("Category_Three");
				break;
			case 4:
				category = plugin.getConfig().getString("Category_Four");
				break;
			case 5:
				category = plugin.getConfig().getString("Category_Five");
				break;
			default:
				category = plugin.getConfig().getString("Category_Five");
				break;
			}
			int importance = 0;
			switch(importanceMap.get(e.getPlayer())){
			case 1:
				importance = 1;
				break;
			case 2:
				importance = 2;
				break;
			case 3:
				importance = 3;
				break;
			case 4:
				importance = 4;
				break;
			case 5:
				importance = 5;
				break;
			default:
				importance = 0;
				break;
			}
			String server = e.getPlayer().getWorld().getName() + " (" + e.getPlayer().getLocation().getBlockX() + "," + e.getPlayer().getLocation().getBlockY() + "," + e.getPlayer().getLocation().getBlockZ() + ")";
			String closed = "false";
			String ticketID = "t" + TicketManager.tickets.size();
			List<String> messages = new ArrayList<String>();
			messages.add("[" + e.getPlayer().getName() + "] " + e.getMessage());
			Ticket t = new Ticket(submittedBy, submissionDate, category, server, closed, ticketID, Integer.valueOf(importance), messages);
			TicketManager.tickets.add(t);
			t.save();
			for(String s : messageHandler.getCreateTicketSuccessful(e.getPlayer(), t))
				e.getPlayer().sendMessage(s);
			for(Player oP : Bukkit.getOnlinePlayers()){
				if(oP.hasPermission("ticketmanager.notify") && !e.getPlayer().getName().equals(oP.getName())){
					for(String s : messageHandler.getCreateTicketStaffNotification(e.getPlayer(), t))
						oP.sendMessage(s);
				}
			}
		}
	}
	
	@EventHandler
	public void onClose(InventoryCloseEvent e){
		if(!ignoreClose.contains(e.getPlayer()) && e.getView().getTitle().contains(CREATEIDENTIFIER) && !messageListener.contains(e.getPlayer())){
			if(TicketManager.debug)
				Bukkit.broadcastMessage("reset");
			if(categoryMap.containsKey(e.getPlayer()))
				categoryMap.remove(e.getPlayer());
			if(importanceMap.containsKey(e.getPlayer()))
				importanceMap.remove(e.getPlayer());
		}
	}
	
}
