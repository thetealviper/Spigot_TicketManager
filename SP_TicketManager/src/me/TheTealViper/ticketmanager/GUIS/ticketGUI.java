package me.TheTealViper.ticketmanager.GUIS;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.TheTealViper.ticketmanager.GuiClick;
import me.TheTealViper.ticketmanager.Ticket;
import me.TheTealViper.ticketmanager.TicketManager;
import me.TheTealViper.ticketmanager.itemHandler;
import me.TheTealViper.ticketmanager.messageHandler;

public class ticketGUI implements Listener{
	public static TicketManager plugin = null;
	public static Map<Player, Ticket> messageListener = new HashMap<Player, Ticket>();
	public static Map<Player, Ticket> whisperListener = new HashMap<Player, Ticket>();
	public static Map<Player, String> whisperData = new HashMap<Player, String>();
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInventory(InventoryClickEvent e){
		if(e.getClickedInventory() != null && e.getClickedInventory().equals(e.getInventory())){
			if(ChatColor.stripColor(e.getView().getTitle()).contains(ChatColor.stripColor(Ticket.TICKETPLAYERIDENTIFIER))){
//				Bukkit.broadcastMessage("ticket");
				e.setCancelled(true);
				if(e.getCurrentItem() == null)
					return;
				if(TicketManager.debug == true)
					Bukkit.broadcastMessage("d");
				String ticketID = e.getView().getTitle().replace(Ticket.TICKETPLAYERIDENTIFIER, "");
				Ticket t = null;
				for(Ticket tick : TicketManager.tickets){
					if(tick.ticketID.equals(ticketID)){
						t = tick;
						break;
					}
				}
				if(t == null)
					return;
				if(e.getCurrentItem().isSimilar(itemHandler.getTicketViewPlayerClosedClosed(t))
						|| e.getCurrentItem().isSimilar(itemHandler.getTicketViewPlayerClosedUnclosed(t))){
					if(t.closed.equals("false")){
						t.closed = "true";
						t.save();
						t.openPlayerGUI((Player) e.getWhoClicked());
						for(String s : messageHandler.getPlayerClosedTicket((Player) e.getWhoClicked(), t))
							e.getWhoClicked().sendMessage(s);
						for(Player oP : Bukkit.getOnlinePlayers()){
							if(oP.hasPermission("ticketmanager.notify") && !e.getWhoClicked().getName().equals(oP.getName())){
								for(String s : messageHandler.getPlayerClosedTicketStaffNotification((Player) e.getWhoClicked(), t))
									oP.sendMessage(s);
							}
						}
						if(TicketManager.GUIClick)
							GuiClick.playClick((Player) e.getWhoClicked(), 1);
					}
				}else if(e.getCurrentItem().isSimilar(itemHandler.getTicketViewPlayerBackUnclosed(t))
						|| e.getCurrentItem().isSimilar(itemHandler.getTicketViewPlayerBackClosed(t))){
					mainGUI.open((Player) e.getWhoClicked());
					if(TicketManager.GUIClick)
						GuiClick.playClick((Player) e.getWhoClicked(), 1);
				}
			}else if(ChatColor.stripColor(e.getView().getTitle()).contains(ChatColor.stripColor(Ticket.TICKETSTAFFIDENTIFIER))){
				e.setCancelled(true);
				if(e.getCurrentItem() == null)
					return;
				if(TicketManager.debug == true)
					Bukkit.broadcastMessage("e");
				String ticketID = e.getView().getTitle().replace(Ticket.TICKETSTAFFIDENTIFIER, "");
				Ticket t = null;
				for(Ticket tick : TicketManager.tickets){
					if(tick.ticketID.equals(ticketID)){
						t = tick;
						break;
					}
				}
				if(t == null)
					return;
				if(e.getCurrentItem().isSimilar(itemHandler.getTicketViewStaffClosedUnclosed(t))
						|| e.getCurrentItem().isSimilar(itemHandler.getTicketViewStaffClosedClosed(t))){
					if(t.closed.equals("false")){
						t.closed = "true";
						t.save();
						t.openStaffGUI((Player) e.getWhoClicked());
						OfflinePlayer offPlayer = Bukkit.getOfflinePlayer(t.submittedBy);
						if(offPlayer.isOnline()) {
							for(String s : messageHandler.getNotifyPlayerStaffClosedTicket((Player) e.getWhoClicked(), t)){
								offPlayer.getPlayer().sendMessage(s);
							}
						}
						for(String s : messageHandler.getStaffClosedTicket((Player) e.getWhoClicked(), t))
							e.getWhoClicked().sendMessage(s);
						for(Player oP : Bukkit.getOnlinePlayers()){
							if(oP.hasPermission("ticketmanager.notify") && !e.getWhoClicked().getName().equals(oP.getName())){
								for(String s : messageHandler.getStaffClosedTicketStaffNotification((Player) e.getWhoClicked(), t))
									oP.sendMessage(s);
							}
						}
						if(TicketManager.GUIClick)
							GuiClick.playClick((Player) e.getWhoClicked(), 1);
					}
				}else if(e.getCurrentItem().isSimilar(itemHandler.getTicketViewStaffMessagesUnclosed(t))
						|| e.getCurrentItem().isSimilar(itemHandler.getTicketViewStaffMessagesClosed(t))){
					messageListener.put((Player) e.getWhoClicked(), t);
					e.getWhoClicked().closeInventory();
					for(String s : messageHandler.getStaffAddMessage((Player) e.getWhoClicked(), t))
						e.getWhoClicked().sendMessage(s);
					if(TicketManager.GUIClick)
						GuiClick.playClick((Player) e.getWhoClicked(), 1);
				}else if(e.getCurrentItem().isSimilar(itemHandler.getTicketViewStaffSubmittedByUnclosed(t))
						|| e.getCurrentItem().isSimilar(itemHandler.getTicketViewStaffSubmittedByClosed(t))){
					if(Bukkit.getOfflinePlayer(t.submittedBy).isOnline()){
						whisperListener.put((Player) e.getWhoClicked(), t);
						whisperData.put((Player) e.getWhoClicked(), t.submittedBy);
						e.getWhoClicked().closeInventory();
						for(String s : messageHandler.getStaffPromptWhisper((Player) e.getWhoClicked(), t))
							e.getWhoClicked().sendMessage(s);
					}else{
						for(String s : messageHandler.getStaffPromptWhisperOffline((Player) e.getWhoClicked(), t))
							e.getWhoClicked().sendMessage(s);
					}
					if(TicketManager.GUIClick)
						GuiClick.playClick((Player) e.getWhoClicked(), 1);
				}else if(e.getCurrentItem().isSimilar(itemHandler.getTicketViewStaffBackUnclosed(t))
						|| e.getCurrentItem().isSimilar(itemHandler.getTicketViewStaffBackClosed(t))){
					mainAdminGUI.open((Player) e.getWhoClicked());
					if(TicketManager.GUIClick)
						GuiClick.playClick((Player) e.getWhoClicked(), 1);
				}
			}
		}
	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e){
		if(messageListener.keySet().contains(e.getPlayer())){
			e.setCancelled(true);
			Ticket t = messageListener.get(e.getPlayer());
			t.messages.add("[" + e.getPlayer().getName() + "] " + TicketManager.makeColors(e.getMessage().replaceAll(";", "")));
			t.save();
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {public void run() {
				t.openStaffGUI(e.getPlayer());
			}}, 0);
			@SuppressWarnings("deprecation")
			OfflinePlayer offPlayer = Bukkit.getOfflinePlayer(t.submittedBy);
			if(offPlayer.isOnline()){
				for(String s : messageHandler.getNotifyPlayerStaffAddMessage(e.getPlayer(), t)){
					offPlayer.getPlayer().sendMessage(s);
				}
			}
			messageListener.remove(e.getPlayer());
		}else if(whisperListener.keySet().contains(e.getPlayer())){
			e.setCancelled(true);
			final Ticket ticket = whisperListener.get(e.getPlayer());
			final String cmd = plugin.getConfig().getString("Whisper_Command") + " " + whisperData.get(e.getPlayer()) + " " + e.getMessage();
			whisperData.remove(e.getPlayer());
			whisperListener.remove(e.getPlayer());
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {public void run() {
				Bukkit.dispatchCommand(e.getPlayer(), cmd);
				ticket.openStaffGUI(e.getPlayer());
//				e.getPlayer().performCommand(plugin.getConfig().getString(plugin.getConfig().getString("Whisper_Command") + " " + whisperData.get(e.getPlayer()) + " " + e.getMessage()));
			}}, 0);
//			e.getPlayer().chat("/" + plugin.getConfig().getString("Whisper_Command") + " " + whisperData.get(e.getPlayer()) + " " + e.getMessage()); //Deprecated with stupid MC 1.19 chat update
		}
	}
	
}
