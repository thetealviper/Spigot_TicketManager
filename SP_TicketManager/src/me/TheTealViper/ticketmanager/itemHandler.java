package me.TheTealViper.ticketmanager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.TheTealViper.ticketmanager.GUIS.categoryBugGUI;
import me.TheTealViper.ticketmanager.GUIS.categoryChatAbuseGUI;
import me.TheTealViper.ticketmanager.GUIS.categoryOtherGUI;
import me.TheTealViper.ticketmanager.GUIS.categoryStaffAbuseGUI;
import me.TheTealViper.ticketmanager.GUIS.categorySuggestionGUI;
import me.TheTealViper.ticketmanager.GUIS.closedTicketsGUI;
import me.TheTealViper.ticketmanager.GUIS.openTicketsGUI;
import me.TheTealViper.ticketmanager.GUIS.staffClosedTicketsGUI;
import me.TheTealViper.ticketmanager.GUIS.staffOpenTicketsGUI;
import me.TheTealViper.ticketmanager.Utils.ItemCreator;

public class itemHandler {
	public static TicketManager plugin;
	//Player Ticket Setup
	
	public static ItemStack getPlayerTicketCreateTicket(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerTicketGUI_CreateTicket"));
		return item;
	}
	public static ItemStack getPlayerTicketOpenTickets(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerTicketGUI_OpenTickets"));
		return item;
	}
	public static ItemStack getPlayerTicketClosedTickets(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerTicketGUI_ClosedTickets"));
		return item;
	}
	public static ItemStack getPlayerTicketFiller(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerTicketGUI_Filler"));
		return item;
	}
	
//------------------------------------------------------
	//Player Create Ticket Setup
	
	public static ItemStack getPlayerCreateTicketCategoryOne(boolean selected){
		ItemStack item = null;
		if(selected){
			item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_CategoryOneSelected"));
		}else{
			item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_CategoryOneUnselected"));
		}
		return item;
	}
	public static ItemStack getPlayerCreateTicketCategoryTwo(boolean selected){
		ItemStack item = null;
		if(selected){
			item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_CategoryTwoSelected"));
		}else{
			item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_CategoryTwoUnselected"));
		}
		return item;
	}
	public static ItemStack getPlayerCreateTicketCategoryThree(boolean selected){
		ItemStack item = null;
		if(selected){
			item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_CategoryThreeSelected"));
		}else{
			item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_CategoryThreeUnselected"));
		}
		return item;
	}
	public static ItemStack getPlayerCreateTicketCategoryFour(boolean selected){
		ItemStack item = null;
		if(selected){
			item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_CategoryFourSelected"));
		}else{
			item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_CategoryFourUnselected"));
		}
		return item;
	}
	public static ItemStack getPlayerCreateTicketCategoryFive(boolean selected){
		ItemStack item = null;
		if(selected){
			item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_CategoryFiveSelected"));
		}else{
			item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_CategoryFiveUnselected"));
		}
		return item;
	}
	public static ItemStack getPlayerCreateTicketCategoryFiller(boolean selected){
		ItemStack item = null;
		if(selected){
			item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_CategoryFillerSelected"));
		}else{
			item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_CategoryFillerUnselected"));
		}
		return item;
	}
	
	public static ItemStack getPlayerCreateTicketImportanceOne(boolean selected){
		ItemStack item = null;
		if(selected){
			item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_ImportanceOneSelected"));
		}else{
			item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_ImportanceOneUnselected"));
		}
		return item;
	}
	public static ItemStack getPlayerCreateTicketImportanceTwo(boolean selected){
		ItemStack item = null;
		if(selected){
			item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_ImportanceTwoSelected"));
		}else{
			item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_ImportanceTwoUnselected"));
		}
		return item;
	}
	public static ItemStack getPlayerCreateTicketImportanceThree(boolean selected){
		ItemStack item = null;
		if(selected){
			item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_ImportanceThreeSelected"));
		}else{
			item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_ImportanceThreeUnselected"));
		}
		return item;
	}
	public static ItemStack getPlayerCreateTicketImportanceFour(boolean selected){
		ItemStack item = null;
		if(selected){
			item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_ImportanceFourSelected"));
		}else{
			item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_ImportanceFourUnselected"));
		}
		return item;
	}
	public static ItemStack getPlayerCreateTicketImportanceFive(boolean selected){
		ItemStack item = null;
		if(selected){
			item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_ImportanceFiveSelected"));
		}else{
			item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_ImportanceFiveUnselected"));
		}
		return item;
	}
	public static ItemStack getPlayerCreateTicketImportanceFiller(boolean selected){
		ItemStack item = null;
		if(selected){
			item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_ImportanceFillerSelected"));
		}else{
			item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_ImportanceFillerUnselected"));
		}
		return item;
	}
	
	public static ItemStack getPlayerCreateTicketFinalize(boolean ready){
		ItemStack item = null;
		if(ready){
			item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_FinalizeReady"));
		}else{
			item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_FinalizeUnready"));
		}
		return item;
	}

//--------------------------------------------------------------
	//Player Open Tickets
	
	public static ItemStack getPlayerOpenTicketsBack(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerOpenTicketsGUI_Back"));
		return item;
	}
	public static ItemStack getPlayerOpenTicketsPreviousPage(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerOpenTicketsGUI_PreviousPage"));
		return item;
	}
	public static ItemStack getPlayerOpenTicketsCurrentPage(Player p){
		ItemStack item = new ItemStack(Material.CHEST);
		ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.STICK);
		meta.setDisplayName(TicketManager.makeColors("&rPage: " + openTicketsGUI.getCurrentPage(p) + "/" + openTicketsGUI.getTotalPages(p)));
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack getPlayerOpenTicketsNextPage(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerOpenTicketsGUI_NextPage"));
		return item;
	}
	public static ItemStack getPlayerOpenTicketsBook(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerOpenTicketsGUI_Book"));
		return item;
	}
	public static ItemStack getPlayerOpenTicketsFiller(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerOpenTicketsGUI_Filler"));
		return item;
	}
	
//--------------------------------------------------------------
	//Player Closed Tickets
	
	public static ItemStack getPlayerClosedTicketsBack(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerClosedTicketsGUI_Back"));
		return item;
	}
	public static ItemStack getPlayerClosedTicketsPreviousPage(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerClosedTicketsGUI_PreviousPage"));
		return item;
	}
	public static ItemStack getPlayerClosedTicketsCurrentPage(Player p){
		ItemStack item = new ItemStack(Material.CHEST);
		ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.STICK);
		meta.setDisplayName(TicketManager.makeColors("&rPage: " + closedTicketsGUI.getCurrentPage(p) + "/" + openTicketsGUI.getTotalPages(p)));
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack getPlayerClosedTicketsNextPage(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerClosedTicketsGUI_NextPage"));
		return item;
	}
	public static ItemStack getPlayerClosedTicketsBook(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerClosedTicketsGUI_Book"));
		return item;
	}
	public static ItemStack getPlayerClosedTicketsFiller(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerClosedTicketsGUI_Filler"));
		return item;
	}
	
//------------------------------------------------------------------
	//Staff Ticket
	
	public static ItemStack getStaffTicketOpenTickets(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffTicketGUI_OpenTickets"));
		return item;
	}
	public static ItemStack getStaffTicketClosedTickets(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffTicketGUI_ClosedTickets"));
		return item;
	}
	public static ItemStack getStaffTicketCategoryOneTickets(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffTicketGUI_CategoryOneTickets"));
		return item;
	}
	public static ItemStack getStaffTicketCategoryTwoTickets(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffTicketGUI_CategoryTwoTickets"));
		return item;
	}
	public static ItemStack getStaffTicketCategoryThreeTickets(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffTicketGUI_CategoryThreeTickets"));
		return item;
	}
	public static ItemStack getStaffTicketCategoryFourTickets(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffTicketGUI_CategoryFourTickets"));
		return item;
	}
	public static ItemStack getStaffTicketCategoryFiveTickets(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffTicketGUI_CategoryFiveTickets"));
		return item;
	}
	public static ItemStack getStaffTicketFiller(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffTicketGUI_Filler"));
		return item;
	}
	
//------------------------------------------------------------------
	//Staff Open Tickets
	
	public static ItemStack getStaffOpenTicketsBack(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffOpenTicketsGUI_Back"));
		return item;
	}
	public static ItemStack getStaffOpenTicketsPreviousPage(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffOpenTicketsGUI_PreviousPage"));
		return item;
	}
	public static ItemStack getStaffOpenTicketsCurrentPage(Player p){
		ItemStack item = new ItemStack(Material.CHEST);
		ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.STICK);
		meta.setDisplayName(TicketManager.makeColors("&rPage: " + staffOpenTicketsGUI.getCurrentPage(p) + "/" + openTicketsGUI.getTotalPages(p)));
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack getStaffOpenTicketsNextPage(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffOpenTicketsGUI_NextPage"));
		return item;
	}
	public static ItemStack getStaffOpenTicketsBook(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffOpenTicketsGUI_Book"));
		return item;
	}
	public static ItemStack getStaffOpenTicketsFiller(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffOpenTicketsGUI_Filler"));
		return item;
	}
	
//-----------------------------------------------------------------
	//Staff Closed Tickets
	
	public static ItemStack getStaffClosedTicketsBack(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffClosedTicketsGUI_Back"));
		return item;
	}
	public static ItemStack getStaffClosedTicketsPreviousPage(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffClosedTicketsGUI_PreviousPage"));
		return item;
	}
	public static ItemStack getStaffClosedTicketsCurrentPage(Player p){
		ItemStack item = new ItemStack(Material.CHEST);
		ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.STICK);
		meta.setDisplayName(TicketManager.makeColors("&rPage: " + staffClosedTicketsGUI.getCurrentPage(p) + "/" + openTicketsGUI.getTotalPages(p)));
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack getStaffClosedTicketsNextPage(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffClosedTicketsGUI_NextPage"));
		return item;
	}
	public static ItemStack getStaffClosedTicketsBook(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffClosedTicketsGUI_Book"));
		return item;
	}
	public static ItemStack getStaffClosedTicketsFiller(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffClosedTicketsGUI_Filler"));
		return item;
	}
	
//------------------------------------------------------------------
	//Staff Category One Tickets
	
	public static ItemStack getStaffCategoryOneTicketsBack(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryOneTicketsGUI_Back"));
		return item;
	}
	public static ItemStack getStaffCategoryOneTicketsPreviousPage(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryOneTicketsGUI_PreviousPage"));
		return item;
	}
	public static ItemStack getStaffCategoryOneTicketsCurrentPage(Player p){
		ItemStack item = new ItemStack(Material.CHEST);
		ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.STICK);
		meta.setDisplayName(TicketManager.makeColors("&rPage: " + categoryBugGUI.getCurrentPage(p) + "/" + openTicketsGUI.getTotalPages(p)));
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack getStaffCategoryOneTicketsNextPage(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryOneTicketsGUI_NextPage"));
		return item;
	}
	public static ItemStack getStaffCategoryOneTicketsBook(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryOneTicketsGUI_Book"));
		return item;
	}
	public static ItemStack getStaffCategoryOneTicketsFiller(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryOneTicketsGUI_Filler"));
		return item;
	}
	
//---------------------------------------------------------------
	//Staff Category Two Tickets
	
	public static ItemStack getStaffCategoryTwoTicketsBack(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryTwoTicketsGUI_Back"));
		return item;
	}
	public static ItemStack getStaffCategoryTwoTicketsPreviousPage(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryTwoTicketsGUI_PreviousPage"));
		return item;
	}
	public static ItemStack getStaffCategoryTwoTicketsCurrentPage(Player p){
		ItemStack item = new ItemStack(Material.CHEST);
		ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.STICK);
		meta.setDisplayName(TicketManager.makeColors("&rPage: " + categoryChatAbuseGUI.getCurrentPage(p) + "/" + openTicketsGUI.getTotalPages(p)));
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack getStaffCategoryTwoTicketsNextPage(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryTwoTicketsGUI_NextPage"));
		return item;
	}
	public static ItemStack getStaffCategoryTwoTicketsBook(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryTwoTicketsGUI_Book"));
		return item;
	}
	public static ItemStack getStaffCategoryTwoTicketsFiller(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryTwoTicketsGUI_Filler"));
		return item;
	}
	
//------------------------------------------------------------------
	//Staff Category Three Tickets
	
	public static ItemStack getStaffCategoryThreeTicketsBack(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryThreeTicketsGUI_Back"));
		return item;
	}
	public static ItemStack getStaffCategoryThreeTicketsPreviousPage(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryThreeTicketsGUI_PreviousPage"));
		return item;
	}
	public static ItemStack getStaffCategoryThreeTicketsCurrentPage(Player p){
		ItemStack item = new ItemStack(Material.CHEST);
		ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.STICK);
		meta.setDisplayName(TicketManager.makeColors("&rPage: " + categoryStaffAbuseGUI.getCurrentPage(p) + "/" + openTicketsGUI.getTotalPages(p)));
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack getStaffCategoryThreeTicketsNextPage(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryThreeTicketsGUI_NextPage"));
		return item;
	}
	public static ItemStack getStaffCategoryThreeTicketsBook(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryThreeTicketsGUI_Book"));
		return item;
	}
	public static ItemStack getStaffCategoryThreeTicketsFiller(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryThreeTicketsGUI_Filler"));
		return item;
	}
	
//------------------------------------------------------------------
	//Staff Category Four Tickets
	
	public static ItemStack getStaffCategoryFourTicketsBack(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryFourTicketsGUI_Back"));
		return item;
	}
	public static ItemStack getStaffCategoryFourTicketsPreviousPage(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryFourTicketsGUI_PreviousPage"));
		return item;
	}
	public static ItemStack getStaffCategoryFourTicketsCurrentPage(Player p){
		ItemStack item = new ItemStack(Material.CHEST);
		ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.STICK);
		meta.setDisplayName(TicketManager.makeColors("&rPage: " + categorySuggestionGUI.getCurrentPage(p) + "/" + openTicketsGUI.getTotalPages(p)));
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack getStaffCategoryFourTicketsNextPage(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryFourTicketsGUI_NextPage"));
		return item;
	}
	public static ItemStack getStaffCategoryFourTicketsBook(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryFourTicketsGUI_Book"));
		return item;
	}
	public static ItemStack getStaffCategoryFourTicketsFiller(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryFourTicketsGUI_Filler"));
		return item;
	}
	
//------------------------------------------------------------------
	//Staff Category Five Tickets
	
	public static ItemStack getStaffCategoryFiveTicketsBack(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryFiveTicketsGUI_Back"));
		return item;
	}
	public static ItemStack getStaffCategoryFiveTicketsPreviousPage(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryFiveTicketsGUI_PreviousPage"));
		return item;
	}
	public static ItemStack getStaffCategoryFiveTicketsCurrentPage(Player p){
		ItemStack item = new ItemStack(Material.CHEST);
		ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.STICK);
		meta.setDisplayName(TicketManager.makeColors("&rPage: " + categoryOtherGUI.getCurrentPage(p) + "/" + openTicketsGUI.getTotalPages(p)));
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack getStaffCategoryFiveTicketsNextPage(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryFiveTicketsGUI_NextPage"));
		return item;
	}
	public static ItemStack getStaffCategoryFiveTicketsBook(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryFiveTicketsGUI_Book"));
		return item;
	}
	public static ItemStack getStaffCategoryFiveTicketsFiller(){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryFiveTicketsGUI_Filler"));
		return item;
	}

//------------------------------------------------------------------
	//Ticket View
	
	public static ItemStack getTicketViewPlayerSubmittedByUnclosed(Ticket t){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_PlayerSubmittedByUnclosed"), t);
		return item;
	}
	public static ItemStack getTicketViewPlayerSubmittedByClosed(Ticket t){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_PlayerSubmittedByClosed"), t);
		return item;
	}
	public static ItemStack getTicketViewStaffSubmittedByUnclosed(Ticket t){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_StaffSubmittedByUnclosed"), t);
		return item;
	}
	public static ItemStack getTicketViewStaffSubmittedByClosed(Ticket t){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_StaffSubmittedByClosed"), t);
		return item;
	}
	
	public static ItemStack getTicketViewPlayerCategoryUnclosed(Ticket t){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_PlayerCategoryUnclosed"), t);
		return item;
	}
	public static ItemStack getTicketViewPlayerCategoryClosed(Ticket t){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_PlayerCategoryClosed"), t);
		return item;
	}
	public static ItemStack getTicketViewStaffCategoryUnclosed(Ticket t){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_StaffCategoryUnclosed"), t);
		return item;
	}
	public static ItemStack getTicketViewStaffCategoryClosed(Ticket t){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_StaffCategoryClosed"), t);
		return item;
	}
	
	public static ItemStack getTicketViewPlayerServerUnclosed(Ticket t){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_PlayerServerUnclosed"), t);
		return item;
	}
	public static ItemStack getTicketViewPlayerServerClosed(Ticket t){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_PlayerServerClosed"), t);
		return item;
	}
	public static ItemStack getTicketViewStaffServerUnclosed(Ticket t){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_StaffServerUnclosed"), t);
		return item;
	}
	public static ItemStack getTicketViewStaffServerClosed(Ticket t){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_StaffServerClosed"), t);
		return item;
	}
	
	public static ItemStack getTicketViewPlayerImportanceUnclosed(Ticket t){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_PlayerImportanceUnclosed"), t);
		return item;
	}
	public static ItemStack getTicketViewPlayerImportanceClosed(Ticket t){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_PlayerImportanceClosed"), t);
		return item;
	}
	public static ItemStack getTicketViewStaffImportanceUnclosed(Ticket t){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_StaffImportanceUnclosed"), t);
		return item;
	}
	public static ItemStack getTicketViewStaffImportanceClosed(Ticket t){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_StaffImportanceClosed"), t);
		return item;
	}
	
	public static ItemStack getTicketViewPlayerMessagesUnclosed(Ticket t){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_PlayerMessagesUnclosed"), t);
		return item;
	}
	public static ItemStack getTicketViewPlayerMessagesClosed(Ticket t){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_PlayerMessagesClosed"), t);
		return item;
	}
	public static ItemStack getTicketViewStaffMessagesUnclosed(Ticket t){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_StaffMessagesUnclosed"), t);
		return item;
	}
	public static ItemStack getTicketViewStaffMessagesClosed(Ticket t){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_StaffMessagesClosed"), t);
		return item;
	}
	
	public static ItemStack getTicketViewPlayerClosedUnclosed(Ticket t){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_PlayerClosedUnclosed"), t);
		return item;
	}
	public static ItemStack getTicketViewPlayerClosedClosed(Ticket t){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_PlayerClosedClosed"), t);
		return item;
	}
	public static ItemStack getTicketViewStaffClosedUnclosed(Ticket t){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_StaffClosedUnclosed"), t);
		return item;
	}
	public static ItemStack getTicketViewStaffClosedClosed(Ticket t){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_StaffClosedClosed"), t);
		return item;
	}
	
	public static ItemStack getTicketViewPlayerBackUnclosed(Ticket t){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_PlayerBackUnclosed"), t);
		return item;
	}
	public static ItemStack getTicketViewPlayerBackClosed(Ticket t){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_PlayerBackClosed"), t);
		return item;
	}
	public static ItemStack getTicketViewStaffBackUnclosed(Ticket t){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_StaffBackUnclosed"), t);
		return item;
	}
	public static ItemStack getTicketViewStaffBackClosed(Ticket t){
		ItemStack item = ItemCreator.createItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_StaffBackClosed"), t);
		return item;
	}
	
////--------------------------------------------------------------------------------------------
//	
//	public static ItemStack getMainAdmin1(){
//		ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)13);
//		ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.STICK);
//		meta.setDisplayName(TicketManager.makeColors("&r&aAll Open Tickets"));
//		List<String> lore = new ArrayList<String>();
//		lore.add(TicketManager.makeColors("&r&7Click me to view all open tickets"));
//		meta.setLore(lore);
//		item.setItemMeta(meta);
//		return item;
//	}
//	public static ItemStack getMainAdmin2(){
//		ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)13);
//		ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.STICK);
//		meta.setDisplayName(TicketManager.makeColors("&r&aAll Closed Tickets"));
//		List<String> lore = new ArrayList<String>();
//		lore.add(TicketManager.makeColors("&r&7Click me to view all closed tickets"));
//		meta.setLore(lore);
//		item.setItemMeta(meta);
//		return item;
//	}
//	public static ItemStack getMainAdmin3(){
//		ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)13);
//		ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.STICK);
//		meta.setDisplayName(TicketManager.makeColors("&r&aView Bug Category"));
//		List<String> lore = new ArrayList<String>();
//		lore.add(TicketManager.makeColors("&r&7Click me to view open bug tickets by date"));
//		meta.setLore(lore);
//		item.setItemMeta(meta);
//		return item;
//	}
//	public static ItemStack getMainAdmin4(){
//		ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)13);
//		ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.STICK);
//		meta.setDisplayName(TicketManager.makeColors("&r&aView Chat Abuse Category"));
//		List<String> lore = new ArrayList<String>();
//		lore.add(TicketManager.makeColors("&r&7Click me to view open chat abuse tickets by date"));
//		meta.setLore(lore);
//		item.setItemMeta(meta);
//		return item;
//	}
//	public static ItemStack getMainAdmin5(){
//		ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)13);
//		ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.STICK);
//		meta.setDisplayName(TicketManager.makeColors("&r&aView Staff Abuse Category"));
//		List<String> lore = new ArrayList<String>();
//		lore.add(TicketManager.makeColors("&r&7Click me to view open staff abuse tickets by date"));
//		meta.setLore(lore);
//		item.setItemMeta(meta);
//		return item;
//	}
//	public static ItemStack getMainAdmin6(){
//		ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)13);
//		ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.STICK);
//		meta.setDisplayName(TicketManager.makeColors("&r&aView Suggestion Category"));
//		List<String> lore = new ArrayList<String>();
//		lore.add(TicketManager.makeColors("&r&7Click me to view open suggestion tickets by date"));
//		meta.setLore(lore);
//		item.setItemMeta(meta);
//		return item;
//	}
//	public static ItemStack getMainAdmin7(){
//		ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)13);
//		ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.STICK);
//		meta.setDisplayName(TicketManager.makeColors("&r&aView Other Category"));
//		List<String> lore = new ArrayList<String>();
//		lore.add(TicketManager.makeColors("&r&7Click me to view open other tickets by date"));
//		meta.setLore(lore);
//		item.setItemMeta(meta);
//		return item;
//	}
//	public static ItemStack getMainAdminFiller(){
//		ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)7);
//		ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.STICK);
//		meta.setDisplayName(TicketManager.makeColors(" "));
//		item.setItemMeta(meta);
//		return item;
//	}
//
//	//--------------------------------------------------------------------------------------------
//	
//	public static ItemStack getOpenTicketsBack(){
//		ItemStack item = new ItemStack(Material.BARRIER);
//		ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.STICK);
//		meta.setDisplayName(TicketManager.makeColors("&r&4Back"));
//		List<String> lore = new ArrayList<String>();
//		lore.add(TicketManager.makeColors("&r&7Click me to go back"));
//		meta.setLore(lore);
//		item.setItemMeta(meta);
//		return item;
//	}
//	
//	public static ItemStack getOpenTicketsPreviousPage(){
//		ItemStack item = new ItemStack(Material.PAPER);
//		ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.STICK);
//		meta.setDisplayName(TicketManager.makeColors("&rPrevious Page"));
//		List<String> lore = new ArrayList<String>();
//		lore.add(TicketManager.makeColors("&r&7Click me to open the previous page"));
//		meta.setLore(lore);
//		item.setItemMeta(meta);
//		return item;
//	}
//	
//	public static ItemStack getOpenTicketsCurrentPage(Player p){
//		ItemStack item = new ItemStack(Material.CHEST);
//		ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.STICK);
//		meta.setDisplayName(TicketManager.makeColors("&rPage: " + openTicketsGUI.getCurrentPage(p) + "/" + openTicketsGUI.getTotalPages(p)));
//		item.setItemMeta(meta);
//		return item;
//	}
//	
//	public static ItemStack getOpenTicketsNextPage(){
//		ItemStack item = new ItemStack(Material.PAPER);
//		ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.STICK);
//		meta.setDisplayName(TicketManager.makeColors("&rNext Page"));
//		List<String> lore = new ArrayList<String>();
//		lore.add(TicketManager.makeColors("&r&7Click me to open the next page"));
//		meta.setLore(lore);
//		item.setItemMeta(meta);
//		return item;
//	}
//	
//	public static ItemStack getOpenTicketsBook(){
//		ItemStack item = new ItemStack(Material.CHEST);
//		ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.STICK);
//		meta.setDisplayName(TicketManager.makeColors("&r&6&lExplanation"));
//		List<String> lore = new ArrayList<String>();
//		lore.add(TicketManager.makeColors("&r&7This GUI holds your tickets which are currently open."));
//		lore.add(TicketManager.makeColors("&r&7Click on any of them to make changes or view more details."));
//		lore.add(TicketManager.makeColors("&r&7You can also click the back button to return to the main menu."));
//		meta.setLore(lore);
//		item.setItemMeta(meta);
//		return item;
//	}
//	
//	public static ItemStack getOpenTicketsFiller(){
//		ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)7);
//		ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.STICK);
//		meta.setDisplayName(TicketManager.makeColors(" "));
//		item.setItemMeta(meta);
//		return item;
//	}
////--------------------------------------------------------------------------------------------
//	
//	public static ItemStack getClosedTicketsBack(){
//		ItemStack item = new ItemStack(Material.BARRIER);
//		ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.STICK);
//		meta.setDisplayName(TicketManager.makeColors("&r&4Back"));
//		List<String> lore = new ArrayList<String>();
//		lore.add(TicketManager.makeColors("&r&7Click me to go back"));
//		meta.setLore(lore);
//		item.setItemMeta(meta);
//		return item;
//	}
//	
//	public static ItemStack getClosedTicketsPreviousPage(){
//		ItemStack item = new ItemStack(Material.PAPER);
//		ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.STICK);
//		meta.setDisplayName(TicketManager.makeColors("&rPrevious Page"));
//		List<String> lore = new ArrayList<String>();
//		lore.add(TicketManager.makeColors("&r&7Click me to open the previous page"));
//		meta.setLore(lore);
//		item.setItemMeta(meta);
//		return item;
//	}
//	
//	public static ItemStack getClosedTicketsCurrentPage(Player p){
//		ItemStack item = new ItemStack(Material.CHEST);
//		ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.STICK);
//		meta.setDisplayName(TicketManager.makeColors("&rPage: " + closedTicketsGUI.getCurrentPage(p) + "/" + closedTicketsGUI.getTotalPages(p)));
//		item.setItemMeta(meta);
//		return item;
//	}
//	
//	public static ItemStack getClosedTicketsNextPage(){
//		ItemStack item = new ItemStack(Material.PAPER);
//		ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.STICK);
//		meta.setDisplayName(TicketManager.makeColors("&rNext Page"));
//		List<String> lore = new ArrayList<String>();
//		lore.add(TicketManager.makeColors("&r&7Click me to open the next page"));
//		meta.setLore(lore);
//		item.setItemMeta(meta);
//		return item;
//	}
//	
//	public static ItemStack getClosedTicketsBook(){
//		ItemStack item = new ItemStack(Material.CHEST);
//		ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.STICK);
//		meta.setDisplayName(TicketManager.makeColors("&r&6&lExplanation"));
//		List<String> lore = new ArrayList<String>();
//		lore.add(TicketManager.makeColors("&r&7This GUI holds your tickets which are currently closed."));
//		lore.add(TicketManager.makeColors("&r&7Click on any of them to make changes or view more details."));
//		lore.add(TicketManager.makeColors("&r&7You can also click the back button to return to the main menu."));
//		meta.setLore(lore);
//		item.setItemMeta(meta);
//		return item;
//	}
//	
//	public static ItemStack getClosedTicketsFiller(){
//		ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)7);
//		ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.STICK);
//		meta.setDisplayName(TicketManager.makeColors(" "));
//		item.setItemMeta(meta);
//		return item;
//	}
//
////--------------------------------------------------------------------------------------------
//	
//	public static ItemStack getCreateTicketCategory1(boolean selected){
//		ItemStack item;
//		if(selected)
//			item = new ItemStack(Material.JACK_O_LANTERN);
//		else
//			item = new ItemStack(Material.PUMPKIN);
//		ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.STICK);
//		if(selected)
//			meta.setDisplayName(TicketManager.makeColors("&r&lBug"));
//		else
//			meta.setDisplayName(TicketManager.makeColors("&rBug"));
//		item.setItemMeta(meta);
//		return item;
//	}
//	public static ItemStack getCreateTicketCategory2(boolean selected){
//		ItemStack item;
//		if(selected)
//			item = new ItemStack(Material.JACK_O_LANTERN);
//		else
//			item = new ItemStack(Material.PUMPKIN);
//		ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.STICK);
//		if(selected)
//			meta.setDisplayName(TicketManager.makeColors("&r&lChat Abuse"));
//		else
//			meta.setDisplayName(TicketManager.makeColors("&rChat Abuse"));
//		item.setItemMeta(meta);
//		return item;
//	}
//	public static ItemStack getCreateTicketCategory3(boolean selected){
//		ItemStack item;
//		if(selected)
//			item = new ItemStack(Material.JACK_O_LANTERN);
//		else
//			item = new ItemStack(Material.PUMPKIN);
//		ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.STICK);
//		if(selected)
//			meta.setDisplayName(TicketManager.makeColors("&r&lStaff Abuse"));
//		else
//			meta.setDisplayName(TicketManager.makeColors("&rStaff Abuse"));
//		item.setItemMeta(meta);
//		return item;
//	}
//	public static ItemStack getCreateTicketCategory4(boolean selected){
//		ItemStack item;
//		if(selected)
//			item = new ItemStack(Material.JACK_O_LANTERN);
//		else
//			item = new ItemStack(Material.PUMPKIN);
//		ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.STICK);
//		if(selected)
//			meta.setDisplayName(TicketManager.makeColors("&r&lSuggestion"));
//		else
//			meta.setDisplayName(TicketManager.makeColors("&rSuggestion"));
//		item.setItemMeta(meta);
//		return item;
//	}
//	public static ItemStack getCreateTicketCategory5(boolean selected){
//		ItemStack item;
//		if(selected)
//			item = new ItemStack(Material.JACK_O_LANTERN);
//		else
//			item = new ItemStack(Material.PUMPKIN);
//		ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.STICK);
//		if(selected)
//			meta.setDisplayName(TicketManager.makeColors("&r&lOther"));
//		else
//			meta.setDisplayName(TicketManager.makeColors("&rOther"));
//		item.setItemMeta(meta);
//		return item;
//	}
//	public static ItemStack getCreateTicketCategoryFiller(boolean selected){
//		ItemStack item;
//		if(selected)
//			item = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)13);
//		else
//			item = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)4);
//		ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.STICK);
//		meta.setDisplayName(TicketManager.makeColors("&r&lCategory"));
//		item.setItemMeta(meta);
//		return item;
//	}
//	
//	public static ItemStack getCreateTicketImportance1(boolean selected){
//		ItemStack item;
//		if(selected)
//			item = new ItemStack(Material.JACK_O_LANTERN);
//		else
//			item = new ItemStack(Material.PUMPKIN);
//		ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.STICK);
//		if(selected)
//			meta.setDisplayName(TicketManager.makeColors("&r&l1"));
//		else
//			meta.setDisplayName(TicketManager.makeColors("&r1"));
//		item.setItemMeta(meta);
//		return item;
//	}
//	public static ItemStack getCreateTicketImportance2(boolean selected){
//		ItemStack item;
//		if(selected)
//			item = new ItemStack(Material.JACK_O_LANTERN);
//		else
//			item = new ItemStack(Material.PUMPKIN);
//		ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.STICK);
//		if(selected)
//			meta.setDisplayName(TicketManager.makeColors("&r&l2"));
//		else
//			meta.setDisplayName(TicketManager.makeColors("&r2"));
//		item.setItemMeta(meta);
//		return item;
//	}
//	public static ItemStack getCreateTicketImportance3(boolean selected){
//		ItemStack item;
//		if(selected)
//			item = new ItemStack(Material.JACK_O_LANTERN);
//		else
//			item = new ItemStack(Material.PUMPKIN);
//		ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.STICK);
//		if(selected)
//			meta.setDisplayName(TicketManager.makeColors("&r&l3"));
//		else
//			meta.setDisplayName(TicketManager.makeColors("&r3"));
//		item.setItemMeta(meta);
//		return item;
//	}
//	public static ItemStack getCreateTicketImportance4(boolean selected){
//		ItemStack item;
//		if(selected)
//			item = new ItemStack(Material.JACK_O_LANTERN);
//		else
//			item = new ItemStack(Material.PUMPKIN);
//		ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.STICK);
//		if(selected)
//			meta.setDisplayName(TicketManager.makeColors("&r&l4"));
//		else
//			meta.setDisplayName(TicketManager.makeColors("&r4"));
//		item.setItemMeta(meta);
//		return item;
//	}
//	public static ItemStack getCreateTicketImportance5(boolean selected){
//		ItemStack item;
//		if(selected)
//			item = new ItemStack(Material.JACK_O_LANTERN);
//		else
//			item = new ItemStack(Material.PUMPKIN);
//		ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.STICK);
//		if(selected)
//			meta.setDisplayName(TicketManager.makeColors("&r&l5"));
//		else
//			meta.setDisplayName(TicketManager.makeColors("&r5"));
//		item.setItemMeta(meta);
//		return item;
//	}
//	public static ItemStack getCreateTicketImportanceFiller(boolean selected){
//		ItemStack item;
//		if(selected)
//			item = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)13);
//		else
//			item = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)4);
//		ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.STICK);
//		meta.setDisplayName(TicketManager.makeColors("&r&lImportance"));
//		item.setItemMeta(meta);
//		return item;
//	}
//	
//	public static ItemStack getCreateTicketFinalize(boolean ready){
//		ItemStack item;
//		if(ready)
//			item = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)13);
//		else
//			item = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)4);
//		ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.STICK);
//		meta.setDisplayName(TicketManager.makeColors("&r&lCreate Ticket"));
//		List<String> lore = new ArrayList<String>();
//		lore.add(TicketManager.makeColors("&r&7Click me to write your ticket message and complete creation."));
//		meta.setLore(lore);
//		item.setItemMeta(meta);
//		return item;
//	}
	
}
