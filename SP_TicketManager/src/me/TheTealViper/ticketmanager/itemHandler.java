package me.TheTealViper.ticketmanager;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
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
import me.TheTealViper.ticketmanager.utils.StringUtils;

public class itemHandler {
	public static TicketManager plugin;
	//Player Ticket Setup
	
	public static ItemStack getPlayerTicketCreateTicket(){
		ItemStack item = plugin.getLoadItemstackFromConfig().getItem(plugin.getConfig().getConfigurationSection("PlayerTicketGUI_CreateTicket"));
		return item;
	}
	public static ItemStack getPlayerTicketOpenTickets(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerTicketGUI_OpenTickets"));
		return item;
	}
	public static ItemStack getPlayerTicketClosedTickets(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerTicketGUI_ClosedTickets"));
		return item;
	}
	public static ItemStack getPlayerTicketFiller(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerTicketGUI_Filler"));
		return item;
	}
	
//------------------------------------------------------
	//Player Create Ticket Setup
	
	public static ItemStack getPlayerCreateTicketCategoryOne(boolean selected){
		ItemStack item = null;
		if(selected){
			item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_CategoryOneSelected"));
		}else{
			item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_CategoryOneUnselected"));
		}
		return item;
	}
	public static ItemStack getPlayerCreateTicketCategoryTwo(boolean selected){
		ItemStack item = null;
		if(selected){
			item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_CategoryTwoSelected"));
		}else{
			item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_CategoryTwoUnselected"));
		}
		return item;
	}
	public static ItemStack getPlayerCreateTicketCategoryThree(boolean selected){
		ItemStack item = null;
		if(selected){
			item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_CategoryThreeSelected"));
		}else{
			item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_CategoryThreeUnselected"));
		}
		return item;
	}
	public static ItemStack getPlayerCreateTicketCategoryFour(boolean selected){
		ItemStack item = null;
		if(selected){
			item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_CategoryFourSelected"));
		}else{
			item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_CategoryFourUnselected"));
		}
		return item;
	}
	public static ItemStack getPlayerCreateTicketCategoryFive(boolean selected){
		ItemStack item = null;
		if(selected){
			item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_CategoryFiveSelected"));
		}else{
			item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_CategoryFiveUnselected"));
		}
		return item;
	}
	public static ItemStack getPlayerCreateTicketCategoryFiller(boolean selected){
		ItemStack item = null;
		if(selected){
			item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_CategoryFillerSelected"));
		}else{
			item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_CategoryFillerUnselected"));
		}
		return item;
	}
	
	public static ItemStack getPlayerCreateTicketImportanceOne(boolean selected){
		ItemStack item = null;
		if(selected){
			item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_ImportanceOneSelected"));
		}else{
			item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_ImportanceOneUnselected"));
		}
		return item;
	}
	public static ItemStack getPlayerCreateTicketImportanceTwo(boolean selected){
		ItemStack item = null;
		if(selected){
			item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_ImportanceTwoSelected"));
		}else{
			item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_ImportanceTwoUnselected"));
		}
		return item;
	}
	public static ItemStack getPlayerCreateTicketImportanceThree(boolean selected){
		ItemStack item = null;
		if(selected){
			item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_ImportanceThreeSelected"));
		}else{
			item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_ImportanceThreeUnselected"));
		}
		return item;
	}
	public static ItemStack getPlayerCreateTicketImportanceFour(boolean selected){
		ItemStack item = null;
		if(selected){
			item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_ImportanceFourSelected"));
		}else{
			item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_ImportanceFourUnselected"));
		}
		return item;
	}
	public static ItemStack getPlayerCreateTicketImportanceFive(boolean selected){
		ItemStack item = null;
		if(selected){
			item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_ImportanceFiveSelected"));
		}else{
			item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_ImportanceFiveUnselected"));
		}
		return item;
	}
	public static ItemStack getPlayerCreateTicketImportanceFiller(boolean selected){
		ItemStack item = null;
		if(selected){
			item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_ImportanceFillerSelected"));
		}else{
			item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_ImportanceFillerUnselected"));
		}
		return item;
	}
	
	public static ItemStack getPlayerCreateTicketFinalize(boolean ready){
		ItemStack item = null;
		if(ready){
			item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_FinalizeReady"));
		}else{
			item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerCreateTicketGUI_FinalizeUnready"));
		}
		return item;
	}

//--------------------------------------------------------------
	//Player Open Tickets
	
	public static ItemStack getPlayerOpenTicketsBack(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerOpenTicketsGUI_Back"));
		return item;
	}
	public static ItemStack getPlayerOpenTicketsPreviousPage(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerOpenTicketsGUI_PreviousPage"));
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
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerOpenTicketsGUI_NextPage"));
		return item;
	}
	public static ItemStack getPlayerOpenTicketsBook(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerOpenTicketsGUI_Book"));
		return item;
	}
	public static ItemStack getPlayerOpenTicketsFiller(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerOpenTicketsGUI_Filler"));
		return item;
	}
	
//--------------------------------------------------------------
	//Player Closed Tickets
	
	public static ItemStack getPlayerClosedTicketsBack(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerClosedTicketsGUI_Back"));
		return item;
	}
	public static ItemStack getPlayerClosedTicketsPreviousPage(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerClosedTicketsGUI_PreviousPage"));
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
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerClosedTicketsGUI_NextPage"));
		return item;
	}
	public static ItemStack getPlayerClosedTicketsBook(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerClosedTicketsGUI_Book"));
		return item;
	}
	public static ItemStack getPlayerClosedTicketsFiller(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("PlayerClosedTicketsGUI_Filler"));
		return item;
	}
	
//------------------------------------------------------------------
	//Staff Ticket
	
	public static ItemStack getStaffTicketOpenTickets(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffTicketGUI_OpenTickets"));
		return item;
	}
	public static ItemStack getStaffTicketClosedTickets(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffTicketGUI_ClosedTickets"));
		return item;
	}
	public static ItemStack getStaffTicketCategoryOneTickets(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffTicketGUI_CategoryOneTickets"));
		return item;
	}
	public static ItemStack getStaffTicketCategoryTwoTickets(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffTicketGUI_CategoryTwoTickets"));
		return item;
	}
	public static ItemStack getStaffTicketCategoryThreeTickets(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffTicketGUI_CategoryThreeTickets"));
		return item;
	}
	public static ItemStack getStaffTicketCategoryFourTickets(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffTicketGUI_CategoryFourTickets"));
		return item;
	}
	public static ItemStack getStaffTicketCategoryFiveTickets(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffTicketGUI_CategoryFiveTickets"));
		return item;
	}
	public static ItemStack getStaffTicketFiller(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffTicketGUI_Filler"));
		return item;
	}
	
//------------------------------------------------------------------
	//Staff Open Tickets
	
	public static ItemStack getStaffOpenTicketsBack(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffOpenTicketsGUI_Back"));
		return item;
	}
	public static ItemStack getStaffOpenTicketsPreviousPage(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffOpenTicketsGUI_PreviousPage"));
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
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffOpenTicketsGUI_NextPage"));
		return item;
	}
	public static ItemStack getStaffOpenTicketsBook(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffOpenTicketsGUI_Book"));
		return item;
	}
	public static ItemStack getStaffOpenTicketsFiller(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffOpenTicketsGUI_Filler"));
		return item;
	}
	
//-----------------------------------------------------------------
	//Staff Closed Tickets
	
	public static ItemStack getStaffClosedTicketsBack(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffClosedTicketsGUI_Back"));
		return item;
	}
	public static ItemStack getStaffClosedTicketsPreviousPage(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffClosedTicketsGUI_PreviousPage"));
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
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffClosedTicketsGUI_NextPage"));
		return item;
	}
	public static ItemStack getStaffClosedTicketsBook(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffClosedTicketsGUI_Book"));
		return item;
	}
	public static ItemStack getStaffClosedTicketsFiller(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffClosedTicketsGUI_Filler"));
		return item;
	}
	
//------------------------------------------------------------------
	//Staff Category One Tickets
	
	public static ItemStack getStaffCategoryOneTicketsBack(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryOneTicketsGUI_Back"));
		return item;
	}
	public static ItemStack getStaffCategoryOneTicketsPreviousPage(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryOneTicketsGUI_PreviousPage"));
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
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryOneTicketsGUI_NextPage"));
		return item;
	}
	public static ItemStack getStaffCategoryOneTicketsBook(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryOneTicketsGUI_Book"));
		return item;
	}
	public static ItemStack getStaffCategoryOneTicketsFiller(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryOneTicketsGUI_Filler"));
		return item;
	}
	
//---------------------------------------------------------------
	//Staff Category Two Tickets
	
	public static ItemStack getStaffCategoryTwoTicketsBack(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryTwoTicketsGUI_Back"));
		return item;
	}
	public static ItemStack getStaffCategoryTwoTicketsPreviousPage(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryTwoTicketsGUI_PreviousPage"));
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
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryTwoTicketsGUI_NextPage"));
		return item;
	}
	public static ItemStack getStaffCategoryTwoTicketsBook(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryTwoTicketsGUI_Book"));
		return item;
	}
	public static ItemStack getStaffCategoryTwoTicketsFiller(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryTwoTicketsGUI_Filler"));
		return item;
	}
	
//------------------------------------------------------------------
	//Staff Category Three Tickets
	
	public static ItemStack getStaffCategoryThreeTicketsBack(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryThreeTicketsGUI_Back"));
		return item;
	}
	public static ItemStack getStaffCategoryThreeTicketsPreviousPage(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryThreeTicketsGUI_PreviousPage"));
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
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryThreeTicketsGUI_NextPage"));
		return item;
	}
	public static ItemStack getStaffCategoryThreeTicketsBook(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryThreeTicketsGUI_Book"));
		return item;
	}
	public static ItemStack getStaffCategoryThreeTicketsFiller(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryThreeTicketsGUI_Filler"));
		return item;
	}
	
//------------------------------------------------------------------
	//Staff Category Four Tickets
	
	public static ItemStack getStaffCategoryFourTicketsBack(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryFourTicketsGUI_Back"));
		return item;
	}
	public static ItemStack getStaffCategoryFourTicketsPreviousPage(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryFourTicketsGUI_PreviousPage"));
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
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryFourTicketsGUI_NextPage"));
		return item;
	}
	public static ItemStack getStaffCategoryFourTicketsBook(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryFourTicketsGUI_Book"));
		return item;
	}
	public static ItemStack getStaffCategoryFourTicketsFiller(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryFourTicketsGUI_Filler"));
		return item;
	}
	
//------------------------------------------------------------------
	//Staff Category Five Tickets
	
	public static ItemStack getStaffCategoryFiveTicketsBack(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryFiveTicketsGUI_Back"));
		return item;
	}
	public static ItemStack getStaffCategoryFiveTicketsPreviousPage(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryFiveTicketsGUI_PreviousPage"));
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
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryFiveTicketsGUI_NextPage"));
		return item;
	}
	public static ItemStack getStaffCategoryFiveTicketsBook(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryFiveTicketsGUI_Book"));
		return item;
	}
	public static ItemStack getStaffCategoryFiveTicketsFiller(){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("StaffCategoryFiveTicketsGUI_Filler"));
		return item;
	}

//------------------------------------------------------------------
	//Ticket View
	
	public static ItemStack getTicketViewPlayerSubmittedByUnclosed(Ticket t){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_PlayerSubmittedByUnclosed"), t);
		return item;
	}
	public static ItemStack getTicketViewPlayerSubmittedByClosed(Ticket t){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_PlayerSubmittedByClosed"), t);
		return item;
	}
	public static ItemStack getTicketViewStaffSubmittedByUnclosed(Ticket t){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_StaffSubmittedByUnclosed"), t);
		return item;
	}
	public static ItemStack getTicketViewStaffSubmittedByClosed(Ticket t){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_StaffSubmittedByClosed"), t);
		return item;
	}
	
	public static ItemStack getTicketViewPlayerCategoryUnclosed(Ticket t){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_PlayerCategoryUnclosed"), t);
		return item;
	}
	public static ItemStack getTicketViewPlayerCategoryClosed(Ticket t){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_PlayerCategoryClosed"), t);
		return item;
	}
	public static ItemStack getTicketViewStaffCategoryUnclosed(Ticket t){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_StaffCategoryUnclosed"), t);
		return item;
	}
	public static ItemStack getTicketViewStaffCategoryClosed(Ticket t){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_StaffCategoryClosed"), t);
		return item;
	}
	
	public static ItemStack getTicketViewPlayerServerUnclosed(Ticket t){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_PlayerServerUnclosed"), t);
		return item;
	}
	public static ItemStack getTicketViewPlayerServerClosed(Ticket t){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_PlayerServerClosed"), t);
		return item;
	}
	public static ItemStack getTicketViewStaffServerUnclosed(Ticket t){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_StaffServerUnclosed"), t);
		return item;
	}
	public static ItemStack getTicketViewStaffServerClosed(Ticket t){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_StaffServerClosed"), t);
		return item;
	}
	
	public static ItemStack getTicketViewPlayerImportanceUnclosed(Ticket t){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_PlayerImportanceUnclosed"), t);
		return item;
	}
	public static ItemStack getTicketViewPlayerImportanceClosed(Ticket t){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_PlayerImportanceClosed"), t);
		return item;
	}
	public static ItemStack getTicketViewStaffImportanceUnclosed(Ticket t){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_StaffImportanceUnclosed"), t);
		return item;
	}
	public static ItemStack getTicketViewStaffImportanceClosed(Ticket t){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_StaffImportanceClosed"), t);
		return item;
	}
	
	public static ItemStack getTicketViewPlayerMessagesUnclosed(Ticket t){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_PlayerMessagesUnclosed"), t);
		return item;
	}
	public static ItemStack getTicketViewPlayerMessagesClosed(Ticket t){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_PlayerMessagesClosed"), t);
		return item;
	}
	public static ItemStack getTicketViewStaffMessagesUnclosed(Ticket t){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_StaffMessagesUnclosed"), t);
		return item;
	}
	public static ItemStack getTicketViewStaffMessagesClosed(Ticket t){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_StaffMessagesClosed"), t);
		return item;
	}
	
	public static ItemStack getTicketViewPlayerClosedUnclosed(Ticket t){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_PlayerClosedUnclosed"), t);
		return item;
	}
	public static ItemStack getTicketViewPlayerClosedClosed(Ticket t){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_PlayerClosedClosed"), t);
		return item;
	}
	public static ItemStack getTicketViewStaffClosedUnclosed(Ticket t){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_StaffClosedUnclosed"), t);
		return item;
	}
	public static ItemStack getTicketViewStaffClosedClosed(Ticket t){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_StaffClosedClosed"), t);
		return item;
	}
	
	public static ItemStack getTicketViewPlayerBackUnclosed(Ticket t){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_PlayerBackUnclosed"), t);
		return item;
	}
	public static ItemStack getTicketViewPlayerBackClosed(Ticket t){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_PlayerBackClosed"), t);
		return item;
	}
	public static ItemStack getTicketViewStaffBackUnclosed(Ticket t){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_StaffBackUnclosed"), t);
		return item;
	}
	public static ItemStack getTicketViewStaffBackClosed(Ticket t){
		ItemStack item = getTicketItemFromConfiguration(plugin.getConfig().getConfigurationSection("TicketViewGUI_StaffBackClosed"), t);
		return item;
	}
	

	public static ItemStack getTicketItemFromConfiguration(ConfigurationSection sec) {
		ItemStack item = plugin.getLoadItemstackFromConfig().getItem(sec);
		formatCategory(item);
		return item;
	}
	public static ItemStack getTicketItemFromConfiguration(ConfigurationSection sec, Ticket t) {
		ItemStack item = getTicketItemFromConfiguration(sec);
		// We use the ticket to replace the "%messages%" placeholder with the messages associated with the ticket
		if (t != null) {
			formatMessages(item, t);
			formatOneOffTicketPlaceholders(item, t);
		}
		return item;
	}
	public static void formatCategory(ItemStack item) {
		if (item != null && item.hasItemMeta() && item.getItemMeta().hasDisplayName()) {
			ItemMeta meta = item.getItemMeta();
			String target = meta.getDisplayName();
			String sub = "";
			sub = "%categoryone%";
			while(target.contains(sub))
				target = target.replace(sub, plugin.getConfig().getString("Category_One"));
			sub = "%categorytwo%";
			while(target.contains(sub))
				target = target.replace(sub, plugin.getConfig().getString("Category_Two"));
			sub = "%categorythree%";
			while(target.contains(sub))
				target = target.replace(sub, plugin.getConfig().getString("Category_Three"));
			sub = "%categoryfour%";
			while(target.contains(sub))
				target = target.replace(sub, plugin.getConfig().getString("Category_Four"));
			sub = "%categoryfive%";
			while(target.contains(sub))
				target = target.replace(sub, plugin.getConfig().getString("Category_Five"));
			sub = "%categoryone_lowercase%";
			while(target.contains(sub))
				target = target.replace(sub, plugin.getConfig().getString("Category_One").toLowerCase());
			sub = "%categorytwo_lowercase%";
			while(target.contains(sub))
				target = target.replace(sub, plugin.getConfig().getString("Category_Two").toLowerCase());
			sub = "%categorythree_lowercase%";
			while(target.contains(sub))
				target = target.replace(sub, plugin.getConfig().getString("Category_Three").toLowerCase());
			sub = "%categoryfour_lowercase%";
			while(target.contains(sub))
				target = target.replace(sub, plugin.getConfig().getString("Category_Four").toLowerCase());
			sub = "%categoryfive_lowercase%";
			while(target.contains(sub))
				target = target.replace(sub, plugin.getConfig().getString("Category_Five").toLowerCase());
			meta.setDisplayName(StringUtils.makeColors(target));
			item.setItemMeta(meta);
		}
		
		if (item != null && item.hasItemMeta() && item.getItemMeta().hasLore()) {
			ItemMeta meta = item.getItemMeta();
			List<String> lore = meta.getLore();
			for (int i = 0;i < lore.size();i++) {
				String target = lore.get(i);
				String sub = "";
				sub = "%categoryone%";
				while(target.contains(sub)) {
					target = target.replace(sub, plugin.getConfig().getString("Category_One"));
					lore.set(i, StringUtils.makeColors(target));
				}
				sub = "%categorytwo%";
				while(target.contains(sub)) {
					target = target.replace(sub, plugin.getConfig().getString("Category_Two"));
					lore.set(i, StringUtils.makeColors(target));
				}
				sub = "%categorythree%";
				while(target.contains(sub)) {
					target = target.replace(sub, plugin.getConfig().getString("Category_Three"));
					lore.set(i, StringUtils.makeColors(target));
				}
				sub = "%categoryfour%";
				while(target.contains(sub)) {
					target = target.replace(sub, plugin.getConfig().getString("Category_Four"));
					lore.set(i, StringUtils.makeColors(target));
				}
				sub = "%categoryfive%";
				while(target.contains(sub)) {
					target = target.replace(sub, plugin.getConfig().getString("Category_Five"));
					lore.set(i, StringUtils.makeColors(target));
				}
				sub = "%categoryone_lowercase%";
				while(target.contains(sub)) {
					target = target.replace(sub, plugin.getConfig().getString("Category_One").toLowerCase());
					lore.set(i, StringUtils.makeColors(target));
				}
				sub = "%categorytwo_lowercase%";
				while(target.contains(sub)) {
					target = target.replace(sub, plugin.getConfig().getString("Category_Two").toLowerCase());
					lore.set(i, StringUtils.makeColors(target));
				}
				sub = "%categorythree_lowercase%";
				while(target.contains(sub)) {
					target = target.replace(sub, plugin.getConfig().getString("Category_Three").toLowerCase());
					lore.set(i, StringUtils.makeColors(target));
				}
				sub = "%categoryfour_lowercase%";
				while(target.contains(sub)) {
					target = target.replace(sub, plugin.getConfig().getString("Category_Four").toLowerCase());
					lore.set(i, StringUtils.makeColors(target));
				}
				sub = "%categoryfive_lowercase%";
				while(target.contains(sub)) {
					target = target.replace(sub, plugin.getConfig().getString("Category_Five").toLowerCase());
					lore.set(i, StringUtils.makeColors(target));
				}
			}
			meta.setLore(lore);
			item.setItemMeta(meta);
		}
	}
	public static void formatMessages(ItemStack item, Ticket t) {
		if (item == null || !item.hasItemMeta() || !item.getItemMeta().hasLore() || t == null)
			return;
		
		ItemMeta meta = item.getItemMeta();
		List<String> lore = meta.getLore();
		//Sweep for %messages% placeholder
		for (int i = 0;i < lore.size();i++) {
			if(lore.get(i).contains("%messages%")) {
				lore.remove(i);
				int index = i;
				for(String s : t.messages){
					lore.add(index, StringUtils.makeColors(s));
					index++;
				}
				break;
			}
		}
		meta.setLore(lore);
		item.setItemMeta(meta);
	}
	public static void formatOneOffTicketPlaceholders(ItemStack item, Ticket t) {
		if (item != null && item.hasItemMeta() && item.getItemMeta().hasDisplayName() && t != null) {
			ItemMeta meta = item.getItemMeta();
			String target = meta.getDisplayName();
			String sub = "";
			sub = "%submittedby%";
			while(target.contains(sub))
				target = target.replace(sub, t.submittedBy);
			sub = "%submissiondate%";
			while(target.contains(sub))
				target = target.replace(sub, t.submissionDate);
			sub = "%category%";
			while(target.contains(sub))
				target = target.replace(sub, t.category);
			sub = "%server%";
			while(target.contains(sub))
				target = target.replace(sub, t.server);
			sub = "%importance%";
			while(target.contains(sub))
				target = target.replace(sub, t.importance + "");
			sub = "%closed%";
			while(target.contains(sub))
				target = target.replace(sub, t.closed);
			sub = "%id%";
			while(target.contains(sub))
				target = target.replace(sub, t.ticketID);
			meta.setDisplayName(StringUtils.makeColors(target));
			item.setItemMeta(meta);
		}
		
		if (item != null && item.hasItemMeta() && item.getItemMeta().hasLore() && t != null) {
			ItemMeta meta = item.getItemMeta();
			List<String> lore = meta.getLore();
			for (int i = 0;i < lore.size();i++) {
				String target = lore.get(i);
				String sub = "";
				sub = "%submittedby%";
				while(target.contains(sub)) {
					target = target.replace(sub, t.submittedBy);
					lore.set(i, StringUtils.makeColors(target));
				}
				sub = "%submissiondate%";
				while(target.contains(sub)) {
					target = target.replace(sub, t.submissionDate);
					lore.set(i, StringUtils.makeColors(target));
				}
				sub = "%category%";
				while(target.contains(sub)) {
					target = target.replace(sub, t.category);
					lore.set(i, StringUtils.makeColors(target));
				}
				sub = "%server%";
				while(target.contains(sub)) {
					target = target.replace(sub, t.server);
					lore.set(i, StringUtils.makeColors(target));
				}
				sub = "%importance%";
				while(target.contains(sub)) {
					target = target.replace(sub, t.importance + "");
					lore.set(i, StringUtils.makeColors(target));
				}
				sub = "%closed%";
				while(target.contains(sub)) {
					target = target.replace(sub, t.closed);
					lore.set(i, StringUtils.makeColors(target));
				}
				sub = "%id%";
				while(target.contains(sub)) {
					target = target.replace(sub, t.ticketID);
					lore.set(i, StringUtils.makeColors(target));
				}
			}
			meta.setLore(lore);
			item.setItemMeta(meta);
		}
	}
	
	
}
