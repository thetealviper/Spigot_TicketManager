package me.TheTealViper.ticketmanager;

import java.io.File;
import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.TheTealViper.ticketmanager.utils.StringUtils;

public class messageHandler {
	static YamlConfiguration message = YamlConfiguration.loadConfiguration(new File("plugins/TicketManager/messages.yml"));
	
	public static List<String> getHelp(Player p){
		String dood = "Help";
		List<String> messages = message.getStringList(dood);
		for(int i = 0;i < messages.size();i++)
			messages.set(i, formatString(p, messages.get(i)));
		return messages;
	}
	
	public static List<String> getPlayerClosedTicket(Player p, Ticket t){
		String dood = "Player_Closed_Ticket";
		List<String> messages = message.getStringList(dood);
		for(int i = 0;i < messages.size();i++)
			messages.set(i, formatString(p, messages.get(i), t));
		return messages;
	}
	
	public static List<String> getPlayerClosedTicketStaffNotification(Player p, Ticket t){
		String dood = "Player_Closed_Ticket_Staff_Notification";
		List<String> messages = message.getStringList(dood);
		for(int i = 0;i < messages.size();i++)
			messages.set(i, formatString(p, messages.get(i), t));
		return messages;
	}
	
	public static List<String> getStaffClosedTicket(Player p, Ticket t){
		String dood = "Staff_Closed_Ticket";
		List<String> messages = message.getStringList(dood);
		for(int i = 0;i < messages.size();i++)
			messages.set(i, formatString(p, messages.get(i), t));
		return messages;
	}
	
	public static List<String> getStaffClosedTicketStaffNotification(Player p, Ticket t){
		String dood = "Staff_Closed_Ticket_Staff_Notification";
		List<String> messages = message.getStringList(dood);
		for(int i = 0;i < messages.size();i++)
			messages.set(i, formatString(p, messages.get(i), t));
		return messages;
	}
	
	public static List<String> getCreateTicketMessagePrompt(Player p){
		String dood = "Create_Ticket_Message_Prompt";
		List<String> messages = message.getStringList(dood);
		for(int i = 0;i < messages.size();i++)
			messages.set(i, formatString(p, messages.get(i)));
		return messages;
	}
	
	public static List<String> getCreateTicketSuccessful(Player p, Ticket t){
		String dood = "Create_Ticket_Successful";
		List<String> messages = message.getStringList(dood);
		for(int i = 0;i < messages.size();i++)
			messages.set(i, formatString(p, messages.get(i), t));
		return messages;
	}
	
	public static List<String> getCreateTicketStaffNotification(Player p, Ticket t){
		String dood = "Create_Ticket_Staff_Notification";
		List<String> messages = message.getStringList(dood);
		for(int i = 0;i < messages.size();i++)
			messages.set(i, formatString(p, messages.get(i), t));
		return messages;
	}
	
	public static List<String> getStaffAddMessage(Player p, Ticket t){
		String dood = "Staff_Add_Message";
		List<String> messages = message.getStringList(dood);
		for(int i = 0;i < messages.size();i++) {
			messages.set(i, formatString(p, messages.get(i), t));
		}
		return messages;
	}
	
	public static List<String> getStaffPromptWhisper(Player p, Ticket t){
		String dood = "Staff_Prompt_Whisper";
		List<String> messages = message.getStringList(dood);
		for(int i = 0;i < messages.size();i++)
			messages.set(i, formatString(p, messages.get(i), t));
		return messages;
	}
	
	public static List<String> getStaffPromptWhisperOffline(Player p, Ticket t){
		String dood = "Staff_Prompt_Whisper_Offline";
		List<String> messages = message.getStringList(dood);
		for(int i = 0;i < messages.size();i++)
			messages.set(i, formatString(p, messages.get(i), t));
		return messages;
	}
	
	public static List<String> getNotifyPlayerStaffAddMessage(Player p, Ticket t){
		String dood = "Notify_Player_Staff_Add_Message";
		List<String> messages = message.getStringList(dood);
		for(int i = 0;i < messages.size();i++)
			messages.set(i, formatString(p, messages.get(i), t));
		return messages;
	}
	
	public static List<String> getNotifyPlayerStaffClosedTicket(Player p, Ticket t){
		String dood = "Notify_Player_Staff_Closed_Ticket";
		List<String> messages = message.getStringList(dood);
		for(int i = 0;i < messages.size();i++)
			messages.set(i, formatString(p, messages.get(i), t));
		return messages;
	}
	
	private static String formatString(Player p, String s, Ticket t){
		String dood = "";
		dood = "%submittedby%";
		while(s.contains(dood))
			s = s.replace(dood, t.submittedBy);
		dood = "%submissiondate%";
		while(s.contains(dood))
			s = s.replace(dood, t.submissionDate);
		dood = "%category%";
		while(s.contains(dood))
			s = s.replace(dood, t.category);
		dood = "%server%";
		while(s.contains(dood))
			s = s.replace(dood, t.server);
		dood = "%importance%";
		while(s.contains(dood))
			s = s.replace(dood, t.importance + "");
		dood = "%closed%";
		while(s.contains(dood))
			s = s.replace(dood, t.closed);
		dood = "%id%";
		while(s.contains(dood))
			s = s.replace(dood, t.ticketID);
		return formatString(p, s);
	}
	
	private static String formatString(Player p, String s){
		String dood = "%player%";
		while(s.contains(dood))
			s = s.replace(dood, p.getName());
		return StringUtils.makeColors(s);
	}
}
