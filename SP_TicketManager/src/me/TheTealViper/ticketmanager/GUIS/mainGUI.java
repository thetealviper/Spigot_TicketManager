package me.TheTealViper.ticketmanager.GUIS;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import me.TheTealViper.ticketmanager.GuiClick;
import me.TheTealViper.ticketmanager.TicketManager;
import me.TheTealViper.ticketmanager.itemHandler;
import me.TheTealViper.ticketmanager.utils.StringUtils;

public class mainGUI implements Listener{
	public static String MAINIDENTIFIER = StringUtils.convertToInvisibleString("TSz");//Have to use S because M is glitched in 1.13
	
	public static void open(Player p){
		Inventory inv = Bukkit.createInventory(null, 9, StringUtils.makeColors(TicketManager.plugin.getConfig().getString("PlayerTicketGUI_Name")) + MAINIDENTIFIER);
		for(int i = 0;i < 9;i++)
			inv.setItem(i, itemHandler.getPlayerTicketFiller());
		inv.setItem(0, itemHandler.getPlayerTicketCreateTicket());
		inv.setItem(4, itemHandler.getPlayerTicketOpenTickets());
		inv.setItem(8, itemHandler.getPlayerTicketClosedTickets());
//		Bukkit.broadcastMessage(ChatColor.stripColor(inv.getTitle()) + " ::: " +ChatColor.stripColor(MAINIDENTIFIER));
		p.openInventory(inv);
		return;
	}
	
	@EventHandler
	public void onInvClick(InventoryClickEvent e){
		if(e.getClickedInventory() != null && e.getClickedInventory().equals(e.getInventory()) && ChatColor.stripColor(e.getView().getTitle()).contains(ChatColor.stripColor(MAINIDENTIFIER))){
//			Bukkit.broadcastMessage("mainGUI");
			e.setCancelled(true);
			if(e.getCurrentItem() == null)
				return;
			if(TicketManager.debug == true)
				Bukkit.broadcastMessage("9");
			if(e.getCurrentItem().isSimilar(itemHandler.getPlayerTicketCreateTicket()) && 
					(!e.getWhoClicked().hasPermission("ticketmanager.bancreation") || e.getWhoClicked().isOp() || e.getWhoClicked().hasPermission("ticketmanager.admin"))){
				createTicketGUI.open((Player) e.getWhoClicked());
				if(TicketManager.GUIClick)
					GuiClick.playClick((Player) e.getWhoClicked(), 1);
			}else if(e.getCurrentItem().isSimilar(itemHandler.getPlayerTicketOpenTickets())){
				openTicketsGUI.pageMap.put((Player) e.getWhoClicked(), 1);
				openTicketsGUI.open((Player) e.getWhoClicked(), 1);
				if(TicketManager.GUIClick)
					GuiClick.playClick((Player) e.getWhoClicked(), 1);
			}else if(e.getCurrentItem().isSimilar(itemHandler.getPlayerTicketClosedTickets())){
				closedTicketsGUI.pageMap.put((Player) e.getWhoClicked(), 1);
				closedTicketsGUI.open((Player) e.getWhoClicked(), 1);
				if(TicketManager.GUIClick)
					GuiClick.playClick((Player) e.getWhoClicked(), 1);
			}
		}
	}
}
