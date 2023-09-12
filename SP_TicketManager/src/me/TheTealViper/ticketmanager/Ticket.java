package me.TheTealViper.ticketmanager;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.TheTealViper.ticketmanager.SQLShit.TableSlot;
import me.TheTealViper.ticketmanager.utils.StringUtils;

public class Ticket{
	public static String TICKETPLAYERIDENTIFIER = StringUtils.convertToInvisibleString("TSh"), TICKETSTAFFIDENTIFIER = StringUtils.convertToInvisibleString("TSg");
	public String submittedBy = null, submissionDate = null, category = null, server = null, closed = "false", ticketID = null;
	public int importance;
	public List<String> messages = null;
	
	public Ticket(String submittedBy, String submissionDate, String category, String server, String closed, String ticketID, int importance, List<String> messages){
		this.submittedBy = submittedBy;
		this.submissionDate = submissionDate;
		this.category = category;
		this.server = server;
		this.closed = closed;
		this.ticketID = ticketID;
		this.importance = importance;
		this.messages = messages;
	}
	
	public ItemStack getItemStack(){
		ItemStack item = new ItemStack(Material.PAPER);
		ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.STICK);
		meta.setDisplayName(TicketManager.makeColors("&r&lTicket " + ticketID));
		List<String> lore = new ArrayList<String>();
		lore.add(TicketManager.makeColors("&lSubmitted By: &r" + submittedBy));
		lore.add(TicketManager.makeColors("&lSubmission Date: &r" + submissionDate));
		lore.add(TicketManager.makeColors("&lServer: &r" + server));
		lore.add(TicketManager.makeColors("&lCategory: &r" + category));
		lore.add(TicketManager.makeColors("&lImportance: &r" + importance));
		lore.add(TicketManager.makeColors("&n&lMessages"));
		for(String s : messages)
			lore.add(TicketManager.makeColors("&r" + s));
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}
	
	public static Ticket loadTicket(ConfigurationSection sec, String ticketID){
		String submittedBy = sec.getString(ticketID + ".submittedBy");
		String submissionDate = sec.getString(ticketID + ".submissionDate");
		String category = sec.getString(ticketID + ".category");
		String server = sec.getString(ticketID + ".server");
		String closed = sec.getString(ticketID + ".closed");
		int importance = sec.getInt(ticketID + ".importance");
		String messagesDump = sec.getString(ticketID + ".messages");
		List<String> messages = new ArrayList<String>();
		for(String s : messagesDump.split(";"))
			messages.add(s);
		
		return new Ticket(submittedBy, submissionDate, category, server, closed, ticketID, importance, messages);
	}
	
	public static Ticket loadTicket(String ticketID){
		String submittedBy = (String) TicketManager.sql.get(TicketManager.sql.new TableSlot("TicketManager", ticketID + "", "submittedBy", "TEXT"), "ERROR");
		String submissionDate = (String) TicketManager.sql.get(TicketManager.sql.new TableSlot("TicketManager", ticketID + "", "submissionDate", "TEXT"), "ERROR");
		String category = (String) TicketManager.sql.get(TicketManager.sql.new TableSlot("TicketManager", ticketID + "", "category", "TEXT"), "ERROR");
		String server = (String) TicketManager.sql.get(TicketManager.sql.new TableSlot("TicketManager", ticketID + "", "server", "TEXT"), "ERROR");
		String closed = (String) TicketManager.sql.get(TicketManager.sql.new TableSlot("TicketManager", ticketID + "", "closed", "TEXT"), "ERROR");
		int importance = Integer.valueOf((String) TicketManager.sql.get(TicketManager.sql.new TableSlot("TicketManager", ticketID + "", "importance", "TEXT"), "ERROR"));
		String messagesDump = (String) TicketManager.sql.get(TicketManager.sql.new TableSlot("TicketManager", ticketID + "", "messages", "TEXT"), "ERROR");
		List<String> messages = new ArrayList<String>();
		for(String s : messagesDump.split(";"))
			messages.add(s);
		
		return new Ticket(submittedBy, submissionDate, category, server, closed, ticketID, importance, messages);
	}
	
	public void save(){
		if(TicketManager.useSQL){
			TableSlot slot = TicketManager.sql.new TableSlot("TicketManager", ticketID + "", "submittedBy", "TEXT");
			TicketManager.sql.set(slot, submittedBy, "ERROR");
			slot = TicketManager.sql.new TableSlot("TicketManager", ticketID + "", "submissionDate", "TEXT");
			TicketManager.sql.set(slot, submissionDate, "ERROR");
			slot = TicketManager.sql.new TableSlot("TicketManager", ticketID + "", "category", "TEXT");
			TicketManager.sql.set(slot, category, "ERROR");
			slot = TicketManager.sql.new TableSlot("TicketManager", ticketID + "", "server", "TEXT");
			TicketManager.sql.set(slot, server, "ERROR");
			slot = TicketManager.sql.new TableSlot("TicketManager", ticketID + "", "closed", "TEXT");
			TicketManager.sql.set(slot, closed, "ERROR");
			slot = TicketManager.sql.new TableSlot("TicketManager", ticketID + "", "importance", "TEXT");
			TicketManager.sql.set(slot, importance + "", "ERROR");
			slot = TicketManager.sql.new TableSlot("TicketManager", ticketID + "", "messages", "TEXT");
			String message = "";
			for(int i = 0;i < messages.size();i++){
				if(i == messages.size() - 1)
					message += messages.get(i);
				else
					message += messages.get(i) + ";";
			}
			TicketManager.sql.set(slot, message, "ERROR");
		}else{
			TicketManager.data.set(ticketID + ".submittedBy", submittedBy);
			TicketManager.data.set(ticketID + ".submissionDate", submissionDate);
			TicketManager.data.set(ticketID + ".category", category);
			TicketManager.data.set(ticketID + ".server", server);
			TicketManager.data.set(ticketID + ".closed", closed);
			TicketManager.data.set(ticketID + ".importance", importance);
			String message = "";
			for(int i = 0;i < messages.size();i++){
				if(i == messages.size() - 1)
					message += messages.get(i);
				else
					message += messages.get(i) + ";";
			}
			TicketManager.data.set(ticketID + ".messages", message);
			TicketManager.data.save();
		}
	}

	public void openPlayerGUI(Player p){
		Inventory inv = Bukkit.createInventory(null, 27, ticketID + TICKETPLAYERIDENTIFIER);
		if(closed.equals("false")){
			inv.setItem(0, itemHandler.getTicketViewPlayerSubmittedByUnclosed(this));
			inv.setItem(2, itemHandler.getTicketViewPlayerCategoryUnclosed(this));
			inv.setItem(4, itemHandler.getTicketViewPlayerServerUnclosed(this));
			inv.setItem(6, itemHandler.getTicketViewPlayerImportanceUnclosed(this));
			inv.setItem(8, itemHandler.getTicketViewPlayerMessagesUnclosed(this));
			inv.setItem(18, itemHandler.getTicketViewPlayerBackUnclosed(this));
			inv.setItem(22, itemHandler.getTicketViewPlayerClosedUnclosed(this));
		}else{
			inv.setItem(0, itemHandler.getTicketViewPlayerSubmittedByClosed(this));
			inv.setItem(2, itemHandler.getTicketViewPlayerCategoryClosed(this));
			inv.setItem(4, itemHandler.getTicketViewPlayerServerClosed(this));
			inv.setItem(6, itemHandler.getTicketViewPlayerImportanceClosed(this));
			inv.setItem(8, itemHandler.getTicketViewPlayerMessagesClosed(this));
			inv.setItem(18, itemHandler.getTicketViewPlayerBackClosed(this));
			inv.setItem(22, itemHandler.getTicketViewPlayerClosedClosed(this));
		}
		p.openInventory(inv);
	}
	
	public void openStaffGUI(Player p){
		Inventory inv = Bukkit.createInventory(null, 27, ticketID + TICKETSTAFFIDENTIFIER);
		if(closed.equals("false")){
			inv.setItem(0, itemHandler.getTicketViewStaffSubmittedByUnclosed(this));
			inv.setItem(2, itemHandler.getTicketViewStaffCategoryUnclosed(this));
			inv.setItem(4, itemHandler.getTicketViewStaffServerUnclosed(this));
			inv.setItem(6, itemHandler.getTicketViewStaffImportanceUnclosed(this));
			inv.setItem(8, itemHandler.getTicketViewStaffMessagesUnclosed(this));
			inv.setItem(18, itemHandler.getTicketViewStaffBackUnclosed(this));
			inv.setItem(22, itemHandler.getTicketViewStaffClosedUnclosed(this));
		}else{
			inv.setItem(0, itemHandler.getTicketViewStaffSubmittedByClosed(this));
			inv.setItem(2, itemHandler.getTicketViewStaffCategoryClosed(this));
			inv.setItem(4, itemHandler.getTicketViewStaffServerClosed(this));
			inv.setItem(6, itemHandler.getTicketViewStaffImportanceClosed(this));
			inv.setItem(8, itemHandler.getTicketViewStaffMessagesClosed(this));
			inv.setItem(18, itemHandler.getTicketViewStaffBackClosed(this));
			inv.setItem(22, itemHandler.getTicketViewStaffClosedClosed(this));
		}
		p.openInventory(inv);
	}
	
	
}
