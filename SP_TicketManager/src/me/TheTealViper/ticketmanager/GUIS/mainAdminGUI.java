package me.TheTealViper.ticketmanager.GUIS;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import me.TheTealViper.ticketmanager.TicketManager;
import me.TheTealViper.ticketmanager.itemHandler;
import me.TheTealViper.ticketmanager.Utils.GuiClick;
import me.TheTealViper.ticketmanager.Utils.StringUtils;

public class mainAdminGUI implements Listener{
	public static String ADMINIDENTIFIER = StringUtils.convertToInvisibleString("TSt");
	
	public static void open(Player p){
		Inventory inv = Bukkit.createInventory(null, 9, StringUtils.makeColors(TicketManager.plugin.getConfig().getString("StaffTicketGUI_Name")) + ADMINIDENTIFIER);
		for(int i = 0;i < 9;i++)
			inv.setItem(i, itemHandler.getStaffTicketFiller());
		inv.setItem(0, itemHandler.getStaffTicketOpenTickets());
		inv.setItem(1, itemHandler.getStaffTicketClosedTickets());
		inv.setItem(4, itemHandler.getStaffTicketCategoryOneTickets());
		inv.setItem(5, itemHandler.getStaffTicketCategoryTwoTickets());
		inv.setItem(6, itemHandler.getStaffTicketCategoryThreeTickets());
		inv.setItem(7, itemHandler.getStaffTicketCategoryFourTickets());
		inv.setItem(8, itemHandler.getStaffTicketCategoryFiveTickets());
		p.openInventory(inv);
		return;
	}
	
	@EventHandler
	public void onInvClick(InventoryClickEvent e){
		if(e.getClickedInventory() != null && e.getClickedInventory().equals(e.getInventory()) && ChatColor.stripColor(e.getView().getTitle()).contains(ChatColor.stripColor(ADMINIDENTIFIER))){
//			Bukkit.broadcastMessage("mainAdmin");
			e.setCancelled(true);
			if(e.getCurrentItem() == null)
				return;
			if(TicketManager.debug == true)
				Bukkit.broadcastMessage("8");
			Player p = (Player) e.getWhoClicked();
			if(e.getCurrentItem().isSimilar(itemHandler.getStaffTicketOpenTickets())){
				staffOpenTicketsGUI.open(p, 1);
				if(TicketManager.GUIClick)
					GuiClick.playClick((Player) e.getWhoClicked(), 1);
			}else if(e.getCurrentItem().isSimilar(itemHandler.getStaffTicketClosedTickets())){
				staffClosedTicketsGUI.open(p, 1);
				if(TicketManager.GUIClick)
					GuiClick.playClick((Player) e.getWhoClicked(), 1);
			}else if(e.getCurrentItem().isSimilar(itemHandler.getStaffTicketCategoryOneTickets())){
				categoryBugGUI.open(p, 1);
				if(TicketManager.GUIClick)
					GuiClick.playClick((Player) e.getWhoClicked(), 1);
			}else if(e.getCurrentItem().isSimilar(itemHandler.getStaffTicketCategoryTwoTickets())){
				categoryChatAbuseGUI.open(p, 1);
				if(TicketManager.GUIClick)
					GuiClick.playClick((Player) e.getWhoClicked(), 1);
			}else if(e.getCurrentItem().isSimilar(itemHandler.getStaffTicketCategoryThreeTickets())){
				categoryStaffAbuseGUI.open(p, 1);
				if(TicketManager.GUIClick)
					GuiClick.playClick((Player) e.getWhoClicked(), 1);
			}else if(e.getCurrentItem().isSimilar(itemHandler.getStaffTicketCategoryFourTickets())){
				categorySuggestionGUI.open(p, 1);
				if(TicketManager.GUIClick)
					GuiClick.playClick((Player) e.getWhoClicked(), 1);
			}else if(e.getCurrentItem().isSimilar(itemHandler.getStaffTicketCategoryFiveTickets())){
				categoryOtherGUI.open(p, 1);
				if(TicketManager.GUIClick)
					GuiClick.playClick((Player) e.getWhoClicked(), 1);
			}
		}
	}
}
