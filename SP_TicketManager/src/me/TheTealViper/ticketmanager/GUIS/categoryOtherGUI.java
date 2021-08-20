package me.TheTealViper.ticketmanager.GUIS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import me.TheTealViper.ticketmanager.Ticket;
import me.TheTealViper.ticketmanager.TicketManager;
import me.TheTealViper.ticketmanager.itemHandler;
import me.TheTealViper.ticketmanager.Utils.GuiClick;
import me.TheTealViper.ticketmanager.Utils.StringUtils;

public class categoryOtherGUI implements Listener{
	public static String OPENIDENTIFIER = StringUtils.convertToInvisibleString("TSw");
	static Map<Player, Integer> pageMap = new HashMap<Player, Integer>();
	
	public static void open(Player p, int page){
		if(!pageMap.containsKey(p))
			pageMap.put(p, page);
		Inventory inv = Bukkit.createInventory(null, 54, StringUtils.makeColors(TicketManager.plugin.getConfig().getString("StaffCategoryFiveTicketsGUI_Name")) + OPENIDENTIFIER);
		for(int i = 36;i < 45;i++)
			inv.setItem(i, itemHandler.getStaffCategoryThreeTicketsFiller());
		inv.setItem(45, itemHandler.getStaffCategoryThreeTicketsBack());
		if(getCurrentPage(p) != 1)
			inv.setItem(48, itemHandler.getStaffCategoryThreeTicketsPreviousPage());
		inv.setItem(49, itemHandler.getStaffCategoryThreeTicketsCurrentPage(p));
		if(getCurrentPage(p) != getTotalPages())
			inv.setItem(50, itemHandler.getStaffCategoryThreeTicketsNextPage());
		inv.setItem(53, itemHandler.getStaffCategoryThreeTicketsBook());
		//Set Tickets
		List<Ticket> userTickets = new ArrayList<Ticket>();
		for(Ticket t : TicketManager.tickets){
			if(t.category.equals("Other"))
				userTickets.add(t);
		}
		int index = 0;
		if(userTickets.size() != 0){
			for(int i = (page - 1) * 36;i < page * 36;i++){
				if(userTickets.size() - 1 >= i){
					inv.setItem(index, userTickets.get(i).getItemStack());
					index++;
				}
			}
		}
		p.openInventory(inv);
	}
	
	@EventHandler
	public void onInvClick(InventoryClickEvent e){
		if(e.getClickedInventory() != null && e.getClickedInventory().equals(e.getInventory()) && ChatColor.stripColor(e.getView().getTitle()).contains(ChatColor.stripColor(OPENIDENTIFIER))){
//			Bukkit.broadcastMessage("categoryOther");
			e.setCancelled(true);
			if(e.getCurrentItem() == null || e.getCurrentItem().getType().equals(Material.AIR))
				return;
			if(TicketManager.debug == true)
				Bukkit.broadcastMessage("3");
			Player p = (Player) e.getWhoClicked();
			if(e.getCurrentItem().isSimilar(itemHandler.getStaffCategoryThreeTicketsBack())){
				mainAdminGUI.open(p);
				if(TicketManager.GUIClick)
					GuiClick.playClick((Player) e.getWhoClicked(), 1);
			}else if(e.getCurrentItem().isSimilar(itemHandler.getStaffCategoryThreeTicketsPreviousPage())){
				pageMap.put(p, getCurrentPage(p) - 1);
				open(p, getCurrentPage(p));
				if(TicketManager.GUIClick)
					GuiClick.playClick((Player) e.getWhoClicked(), 1);
			}else if(e.getCurrentItem().isSimilar(itemHandler.getStaffCategoryThreeTicketsNextPage())){
				pageMap.put(p, getCurrentPage(p) + 1);
				open(p, getCurrentPage(p));
				if(TicketManager.GUIClick)
					GuiClick.playClick((Player) e.getWhoClicked(), 1);
			}else if(e.getCurrentItem().isSimilar(itemHandler.getStaffCategoryThreeTicketsCurrentPage(p)) || e.getCurrentItem().isSimilar(itemHandler.getStaffCategoryThreeTicketsBook()))
				return;
			else{
				if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().hasDisplayName()){
					String ticketID = e.getCurrentItem().getItemMeta().getDisplayName().replace(TicketManager.makeColors("&r&lTicket "), "");
					for(Ticket t : TicketManager.tickets){
						if(t.ticketID.equals(ticketID)){
							t.openStaffGUI(p);
							if(TicketManager.GUIClick)
								GuiClick.playClick((Player) e.getWhoClicked(), 1);
						}
					}
				}
			}
		}
	}
	
	public static int getCurrentPage(Player p){
		if(!pageMap.containsKey(p))
			pageMap.put(p, 1);
		return pageMap.get(p);
	}
	
	public static int getTotalPages(){
		int totalTickets = 0;
		for(Ticket t : TicketManager.tickets){
			if(t.category.equals("Other"))
				totalTickets++;
		}
		int pages = totalTickets / 36;
		if(totalTickets % 36 != 0)
			pages++;
		if(pages == 0)
			pages = 1;
		return pages;
	}
}