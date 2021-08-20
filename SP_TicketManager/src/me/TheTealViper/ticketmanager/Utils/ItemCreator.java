package me.TheTealViper.ticketmanager.Utils;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.material.MaterialData;

import me.TheTealViper.ticketmanager.Ticket;
import me.TheTealViper.ticketmanager.TicketManager;

public class ItemCreator implements Listener{
	public static TicketManager plugin = null;
	private static List<Material> durMats = new ArrayList<Material>();
	public static Map<ItemStack, Integer> damageInfo = new HashMap<ItemStack, Integer>();
	
	public static ItemStack createItemFromConfiguration(ConfigurationSection sec){
		if(durMats.isEmpty())
			loadDurMats();
		ItemStack item = (sec == null || !sec.contains("id")) ? null : new ItemStack(Material.getMaterial(sec.getString("id")));
		if(item == null)
			return null;
		List<String> tags = sec.contains("tags") ? sec.getStringList("tags") : new ArrayList<String>();
		for(String s : tags){
			if(s.startsWith("skulltexture") && item.getType().equals(Material.PLAYER_HEAD)){
				item = Skull.getCustomSkull("http://textures.minecraft.net/texture/" + s.replace("skulltexture:", ""));
			}
		}
		if(sec.contains("amount"))
			item.setAmount(sec.getInt("amount"));
		ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.STICK);
		if(sec.contains("name") && !sec.getString("name").equals("")){
			meta.setDisplayName(formatString(sec.getString("name")));
			item.setItemMeta(meta);
		}
		List<String> enchantmentStrings = sec.contains("enchantments") ? sec.getStringList("enchantments") : new ArrayList<String>();
		for(String enchantmentString : enchantmentStrings){
			String enchantment = enchantmentString.split(":")[0];
    		int level = Integer.valueOf(enchantmentString.split(":")[1]);
    		if(enchantment.equalsIgnoreCase("arrowdamage")){
                item.addEnchantment(Enchantment.ARROW_DAMAGE, level);
            }else if(enchantment.equalsIgnoreCase("arrowfire")){
                item.addUnsafeEnchantment(Enchantment.ARROW_FIRE, level);
            }else if(enchantment.equalsIgnoreCase("arrowinfinite")){
                item.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, level);
            }else if(enchantment.equalsIgnoreCase("arrowknockback")){
                item.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, level);
            }else if(enchantment.equalsIgnoreCase("damage")){
                item.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, level);
            }else if(enchantment.equalsIgnoreCase("digspeed")){
                item.addUnsafeEnchantment(Enchantment.DIG_SPEED, level);
            }else if(enchantment.equalsIgnoreCase("durability")){
                item.addUnsafeEnchantment(Enchantment.DURABILITY, level);
            }else if(enchantment.equalsIgnoreCase("fireaspect")){
                item.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, level);
            }else if(enchantment.equalsIgnoreCase("knockback")){
                item.addUnsafeEnchantment(Enchantment.KNOCKBACK, level);
            }else if(enchantment.equalsIgnoreCase("lootbonusblock")){
                item.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, level);
            }else if(enchantment.equalsIgnoreCase("lootbonusmob")){
                item.addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, level);
            }else if(enchantment.equalsIgnoreCase("luck")){
                item.addUnsafeEnchantment(Enchantment.LUCK, level);
            }else if(enchantment.equalsIgnoreCase("protectionfall")){
                item.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, level);
            }else if(enchantment.equalsIgnoreCase("protectionfire")){
                item.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, level);
            }else if(enchantment.equalsIgnoreCase("silktouch")){
                item.addUnsafeEnchantment(Enchantment.SILK_TOUCH, level);
            }
		}
		for(String s : tags){
    		if(s.startsWith("skullskin") && item.getType().equals(Material.PLAYER_HEAD)){
    			SkullMeta skull = (SkullMeta) item.getData();
    			skull.setOwner(s.replace("skullskin:", ""));
    			item.setData((MaterialData) skull);
    		}else if(s.startsWith("durability") && durMats.contains(item.getType())){
    			item.getData().setData(Byte.valueOf(s.replace("durability:", "")));
    			item.setDurability(Short.valueOf(s.replace("durability:", "")));
    		}else if(s.equalsIgnoreCase("unbreakable")){
    			meta = item.getItemMeta();
    			meta.setUnbreakable(true);
    			item.setItemMeta(meta);
    		}
    	}
		List<String> lore = sec.contains("lore") ? sec.getStringList("lore") : new ArrayList<String>();
		if(!lore.isEmpty()){
			for(int i = 0;i < lore.size();i++){
				lore.set(i, formatString(lore.get(i)));
			}
			meta = item.getItemMeta();
			meta.setLore(lore);
			item.setItemMeta(meta);
		}
		if(sec.contains("flags")){
			meta = item.getItemMeta();
			for(String s : sec.getStringList("flags")){
				meta.addItemFlags(ItemFlag.valueOf(s));
			}
			item.setItemMeta(meta);
		}
		for(String s : tags){
    		if(s.startsWith("damage")){
    			damageInfo.put(item, Integer.valueOf(s.replace("damage:", "")));
    		}
    	}
		return item;
	}
	
	public static String formatString(String s){
		String dood = "";
		dood = "%categoryone%";
		while(s.contains(dood))
			s = s.replace(dood, plugin.getConfig().getString("Category_One"));
		dood = "%categorytwo%";
		while(s.contains(dood))
			s = s.replace(dood, plugin.getConfig().getString("Category_Two"));
		dood = "%categorythree%";
		while(s.contains(dood))
			s = s.replace(dood, plugin.getConfig().getString("Category_Three"));
		dood = "%categoryfour%";
		while(s.contains(dood))
			s = s.replace(dood, plugin.getConfig().getString("Category_Four"));
		dood = "%categoryfive%";
		while(s.contains(dood))
			s = s.replace(dood, plugin.getConfig().getString("Category_Five"));
		dood = "%categoryone_lowercase%";
		while(s.contains(dood))
			s = s.replace(dood, plugin.getConfig().getString("Category_One").toLowerCase());
		dood = "%categorytwo_lowercase%";
		while(s.contains(dood))
			s = s.replace(dood, plugin.getConfig().getString("Category_Two").toLowerCase());
		dood = "%categorythree_lowercase%";
		while(s.contains(dood))
			s = s.replace(dood, plugin.getConfig().getString("Category_Three").toLowerCase());
		dood = "%categoryfour_lowercase%";
		while(s.contains(dood))
			s = s.replace(dood, plugin.getConfig().getString("Category_Four").toLowerCase());
		dood = "%categoryfive_lowercase%";
		while(s.contains(dood))
			s = s.replace(dood, plugin.getConfig().getString("Category_Five").toLowerCase());
		return StringUtils.makeColors(s);
	}
	
	public static ItemStack createItemFromConfiguration(ConfigurationSection sec, Ticket t){
		if(durMats.isEmpty())
			loadDurMats();
		ItemStack item = (sec == null || !sec.contains("id")) ? null : new ItemStack(Material.getMaterial(sec.getString("id")));
		if(item == null)
			return null;
		List<String> tags = sec.contains("tags") ? sec.getStringList("tags") : new ArrayList<String>();
		for(String s : tags){
			if(s.startsWith("skulltexture") && item.getType().equals(Material.PLAYER_HEAD)){
				item = Skull.getCustomSkull("http://textures.minecraft.net/texture/" + s.replace("skulltexture:", ""));
			}
		}
		if(sec.contains("amount"))
			item.setAmount(sec.getInt("amount"));
		ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.STICK);
		if(sec.contains("name") && !sec.getString("name").equals("")){
			meta.setDisplayName(formatString(sec.getString("name"), t));
			item.setItemMeta(meta);
		}
		List<String> enchantmentStrings = sec.contains("enchantments") ? sec.getStringList("enchantments") : new ArrayList<String>();
		for(String enchantmentString : enchantmentStrings){
			String enchantment = enchantmentString.split(":")[0];
    		int level = Integer.valueOf(enchantmentString.split(":")[1]);
    		if(enchantment.equalsIgnoreCase("arrowdamage")){
                item.addEnchantment(Enchantment.ARROW_DAMAGE, level);
            }else if(enchantment.equalsIgnoreCase("arrowfire")){
                item.addUnsafeEnchantment(Enchantment.ARROW_FIRE, level);
            }else if(enchantment.equalsIgnoreCase("arrowinfinite")){
                item.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, level);
            }else if(enchantment.equalsIgnoreCase("arrowknockback")){
                item.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, level);
            }else if(enchantment.equalsIgnoreCase("damage")){
                item.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, level);
            }else if(enchantment.equalsIgnoreCase("digspeed")){
                item.addUnsafeEnchantment(Enchantment.DIG_SPEED, level);
            }else if(enchantment.equalsIgnoreCase("durability")){
                item.addUnsafeEnchantment(Enchantment.DURABILITY, level);
            }else if(enchantment.equalsIgnoreCase("fireaspect")){
                item.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, level);
            }else if(enchantment.equalsIgnoreCase("knockback")){
                item.addUnsafeEnchantment(Enchantment.KNOCKBACK, level);
            }else if(enchantment.equalsIgnoreCase("lootbonusblock")){
                item.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, level);
            }else if(enchantment.equalsIgnoreCase("lootbonusmob")){
                item.addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, level);
            }else if(enchantment.equalsIgnoreCase("luck")){
                item.addUnsafeEnchantment(Enchantment.LUCK, level);
            }else if(enchantment.equalsIgnoreCase("protectionfall")){
                item.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, level);
            }else if(enchantment.equalsIgnoreCase("protectionfire")){
                item.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, level);
            }else if(enchantment.equalsIgnoreCase("silktouch")){
                item.addUnsafeEnchantment(Enchantment.SILK_TOUCH, level);
            }
		}
		for(String s : tags){
    		if(s.startsWith("skullskin") && item.getType().equals(Material.PLAYER_HEAD)){
    			SkullMeta skull = (SkullMeta) item.getData();
    			skull.setOwner(s.replace("skullskin:", ""));
    			item.setData((MaterialData) skull);
    		}else if(s.startsWith("durability") && durMats.contains(item.getType())){
    			item.getData().setData(Byte.valueOf(s.replace("durability:", "")));
    			item.setDurability(Short.valueOf(s.replace("durability:", "")));
    		}else if(s.equalsIgnoreCase("unbreakable")){
    			meta = item.getItemMeta();
    			meta.setUnbreakable(true);
    			item.setItemMeta(meta);
    		}
    	}
		List<String> lore = sec.contains("lore") ? sec.getStringList("lore") : new ArrayList<String>();
		if(!lore.isEmpty()){
			for(int i = 0;i < lore.size();i++){
				lore.set(i, formatString(lore.get(i), t));
			}
			for(int i = 0;i < lore.size();i++){
				if(lore.get(i).contains("%messages%")){
					lore.remove(i);
					int index = 0;
					for(String s : t.messages){
						lore.add(index, StringUtils.makeColors(s));
						index++;
					}
					i = lore.size();
				}
			}
			meta = item.getItemMeta();
			meta.setLore(lore);
			item.setItemMeta(meta);
		}
		if(sec.contains("flags")){
			meta = item.getItemMeta();
			for(String s : sec.getStringList("flags")){
				meta.addItemFlags(ItemFlag.valueOf(s));
			}
			item.setItemMeta(meta);
		}
		for(String s : tags){
    		if(s.startsWith("damage")){
    			damageInfo.put(item, Integer.valueOf(s.replace("damage:", "")));
    		}
    	}
		return item;
	}
	
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e){
		if(e.getDamager() instanceof Player){
			Player p = (Player) e.getDamager();
			ItemStack item = p.getItemInHand();
			if(p.getItemInHand() != null && !p.getItemInHand().getType().equals(Material.AIR)){
				for(ItemStack i : damageInfo.keySet()){
					if(item.isSimilar(i)){
						e.setDamage(damageInfo.get(i));
						return;
					}
				}
			}
		}
	}
	
	private static String formatString(String s, Ticket t){
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
		return StringUtils.makeColors(s);
	}
	
	private static int formatLore(int index, List<String> lore, Ticket t){
		lore.remove(index);
		for(int i = 0;i < t.messages.size();i++){
			lore.add(formatString(t.messages.get(i), t));
		}
		return index + t.messages.size() - 1;
	}
	
	private static void loadDurMats(){
		durMats.add(Material.DIAMOND_SHOVEL);durMats.add(Material.GOLDEN_SHOVEL);durMats.add(Material.IRON_SHOVEL);
    	durMats.add(Material.STONE_SHOVEL);durMats.add(Material.WOODEN_SHOVEL);
    	durMats.add(Material.DIAMOND_PICKAXE);durMats.add(Material.GOLDEN_PICKAXE);durMats.add(Material.IRON_PICKAXE);
    	durMats.add(Material.STONE_PICKAXE);durMats.add(Material.WOODEN_PICKAXE);
    	durMats.add(Material.DIAMOND_AXE);durMats.add(Material.GOLDEN_AXE);durMats.add(Material.IRON_AXE);
    	durMats.add(Material.STONE_AXE);durMats.add(Material.WOODEN_AXE);
    	durMats.add(Material.DIAMOND_HOE);durMats.add(Material.GOLDEN_HOE);durMats.add(Material.IRON_HOE);
    	durMats.add(Material.STONE_HOE);durMats.add(Material.WOODEN_AXE);
    	durMats.add(Material.DIAMOND_SWORD);durMats.add(Material.GOLDEN_SWORD);durMats.add(Material.IRON_SWORD);
    	durMats.add(Material.STONE_SWORD);durMats.add(Material.WOODEN_SWORD);
    	durMats.add(Material.CHAINMAIL_HELMET);durMats.add(Material.DIAMOND_HELMET);durMats.add(Material.GOLDEN_HELMET);
    	durMats.add(Material.IRON_HELMET);durMats.add(Material.LEATHER_HELMET);
    	durMats.add(Material.CHAINMAIL_CHESTPLATE);durMats.add(Material.DIAMOND_CHESTPLATE);durMats.add(Material.GOLDEN_CHESTPLATE);
    	durMats.add(Material.IRON_CHESTPLATE);durMats.add(Material.LEATHER_CHESTPLATE);
    	durMats.add(Material.CHAINMAIL_LEGGINGS);durMats.add(Material.DIAMOND_LEGGINGS);durMats.add(Material.LEATHER_LEGGINGS);
    	durMats.add(Material.IRON_LEGGINGS);durMats.add(Material.GOLDEN_LEGGINGS);
    	durMats.add(Material.CHAINMAIL_BOOTS);durMats.add(Material.DIAMOND_BOOTS);durMats.add(Material.GOLDEN_BOOTS);
    	durMats.add(Material.IRON_BOOTS);durMats.add(Material.LEATHER_BOOTS);
    	durMats.add(Material.BOW);
	}
}
