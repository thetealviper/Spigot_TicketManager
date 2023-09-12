package me.TheTealViper.ticketmanager;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class GuiClick {
	public static void playClick(Player p, float pitch){
		p.getWorld().playSound(p.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1, pitch);
	}
}
