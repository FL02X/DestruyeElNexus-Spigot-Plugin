package mc.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import mc.main.Main;
import mc.methods.Teams;
import net.md_5.bungee.api.ChatColor;

public class ItemDrop implements Listener {

	Plugin plugin;
	Teams teams;

	public ItemDrop(Main main) {
		this.plugin = plugin;
	}

	/*
	 * Used when the player drop items that are part of his Kit
	 * to removes them.
	 */
	
	@EventHandler
	public void playerDropItemEvent(PlayerDropItemEvent e) {

		/*
		 * For team armor and Kits.
		 */

		if (e.getItemDrop().getItemStack().getItemMeta().getDisplayName().startsWith(ChatColor.DARK_BLUE + "[] ")) {
			e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.FIRE_IGNITE, 1, 1);
			e.getItemDrop().remove();
		}

		if (e.getItemDrop().getItemStack().getItemMeta().getDisplayName().startsWith(ChatColor.DARK_BLUE + "[I] ")) {
			e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.FIRE_IGNITE, 1, 1);
			e.getItemDrop().remove();
		}

		// ------------

		if (e.getItemDrop().getItemStack().getItemMeta().getDisplayName().startsWith(ChatColor.RED + "[] ")) {
			e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.FIRE_IGNITE, 1, 1);
			e.getItemDrop().remove();
		}

		if (e.getItemDrop().getItemStack().getItemMeta().getDisplayName().startsWith(ChatColor.RED + "[I] ")) {
			e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.FIRE_IGNITE, 1, 1);
			e.getItemDrop().remove();
		}

		// ------------

		if (e.getItemDrop().getItemStack().getItemMeta().getDisplayName().startsWith(ChatColor.YELLOW + "[] ")) {
			e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.FIRE_IGNITE, 1, 1);
			e.getItemDrop().remove();
		}

		if (e.getItemDrop().getItemStack().getItemMeta().getDisplayName().startsWith(ChatColor.YELLOW + "[I] ")) {
			e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.FIRE_IGNITE, 1, 1);
			e.getItemDrop().remove();
		}

		// ------------

		if (e.getItemDrop().getItemStack().getItemMeta().getDisplayName().startsWith(ChatColor.GREEN + "[] ")) {
			e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.FIRE_IGNITE, 1, 1);
			e.getItemDrop().remove();
		}

		if (e.getItemDrop().getItemStack().getItemMeta().getDisplayName().startsWith(ChatColor.GREEN + "[I] ")) {
			e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.FIRE_IGNITE, 1, 1);
			e.getItemDrop().remove();
		}

		// __________________________________________________________________________

		/*
		 * For the items in the Lobby.
		 */

		//@formatter:off
		if(e.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "Equipo " + ChatColor.GRAY + "(Click derecho)")) {
			e.getItemDrop().remove();
			e.setCancelled(true);
		}
		
		if(e.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Kits " + ChatColor.GRAY + "(Click derecho)")) {
			e.setCancelled(true);
		}
		
		if(e.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Mapas " + ChatColor.GRAY + "(Click derecho)")) {
			e.setCancelled(true);
		}
		
		if(e.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals(ChatColor.RED + "Regresar al Lobby " + ChatColor.GRAY + "(Click derecho)")) {
			e.setCancelled(true);
		}	
		//@formatter:on
	}

}
