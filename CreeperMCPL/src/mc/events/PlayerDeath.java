package mc.events;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import mc.events.kits.Civil;
import mc.main.Main;
import mc.methods.Teams;
import net.md_5.bungee.api.ChatColor;

public class PlayerDeath implements Listener {

	Plugin plugin;
	Teams teams;
	Civil civil = new Civil(Main.getPlugin(Main.class));

	public PlayerDeath(Main main) {
		this.plugin = plugin;
	}

	/*
	 * Called when a player dies. ONLY called in the time between the "Game Over"
	 * screen. NOT after it.
	 * 
	 * I used it to announce the dead in the chat, and remove Kit items.
	 * 
	 * ---------- NEEDS TO SHOW THE KIT OF THE KILLER AND KILLED -------------
	 */

	@EventHandler
	public void playerDeathEvent(PlayerDeathEvent e) {
		e.setDeathMessage("");
		Player killed = e.getEntity().getPlayer();
		Player killer = e.getEntity().getKiller();
		
		if(killed.getWorld().equals(Bukkit.getWorld("lobby"))) {
			e.getDrops().clear();
		}

		// https://bukkit.org/threads/drop-only-certain-items-on-death.227742/
		ListIterator<ItemStack> lit = e.getDrops().listIterator();
		List<ItemStack> list = new ArrayList<ItemStack>();	
		
		while (lit.hasNext()) {
			ItemStack is = lit.next();
			if (is.getItemMeta().getDisplayName().startsWith(ChatColor.DARK_BLUE + "[] ")
					|| is.getItemMeta().getDisplayName().startsWith(ChatColor.RED + "[] ")
					|| is.getItemMeta().getDisplayName().startsWith(ChatColor.YELLOW + "[] ")
					|| is.getItemMeta().getDisplayName().startsWith(ChatColor.GREEN + "[] ")) {
				lit.remove();
			} 
		}
		
		Bukkit.broadcastMessage("a");
		Bukkit.broadcastMessage(e.getDrops().toString());

		switch (teams.checkPlayer(e.getEntity().getPlayer().getName().toLowerCase())) {

		case "blue":
			switch (teams.checkPlayer(killer.getName().toLowerCase())) {
			case "red":
				e.setDeathMessage(
						ChatColor.DARK_BLUE + killed.getName().toString() + ChatColor.GOLD + " ha sido asesinado por "
								+ ChatColor.RED + killer.getName().toString() + ChatColor.GOLD + ".");
				break;
			case "yellow":
				e.setDeathMessage(
						ChatColor.DARK_BLUE + killed.getName().toString() + ChatColor.GOLD + " ha sido asesinado por "
								+ ChatColor.YELLOW + killer.getName().toString() + ChatColor.GOLD + ".");
				break;
			case "green":
				e.setDeathMessage(
						ChatColor.DARK_BLUE + killed.getName().toString() + ChatColor.GOLD + " ha sido asesinado por "
								+ ChatColor.GREEN + killer.getName().toString() + ChatColor.GOLD + ".");
				break;
			}
			break;

		case "red":
			switch (teams.checkPlayer(killer.getName().toLowerCase())) {
			case "blue":
				e.setDeathMessage(
						ChatColor.RED + killed.getName().toString() + ChatColor.GOLD + " ha sido asesinado por "
								+ ChatColor.DARK_BLUE + killer.getName().toString() + ChatColor.GOLD + ".");
				break;
			case "yellow":
				e.setDeathMessage(
						ChatColor.RED + killed.getName().toString() + ChatColor.GOLD + " ha sido asesinado por "
								+ ChatColor.YELLOW + killer.getName().toString() + ChatColor.GOLD + ".");
				break;
			case "green":
				e.setDeathMessage(
						ChatColor.RED + killed.getName().toString() + ChatColor.GOLD + " ha sido asesinado por "
								+ ChatColor.GREEN + killer.getName().toString() + ChatColor.GOLD + ".");
				break;
			}
			break;

		case "yellow":
			switch (teams.checkPlayer(killer.getName().toLowerCase())) {
			case "blue":
				e.setDeathMessage(
						ChatColor.YELLOW + killed.getName().toString() + ChatColor.GOLD + " ha sido asesinado por "
								+ ChatColor.DARK_BLUE + killer.getName().toString() + ChatColor.GOLD + ".");
				break;
			case "red":
				e.setDeathMessage(
						ChatColor.YELLOW + killed.getName().toString() + ChatColor.GOLD + " ha sido asesinado por "
								+ ChatColor.RED + killer.getName().toString() + ChatColor.GOLD + ".");
				break;
			case "green":
				e.setDeathMessage(
						ChatColor.YELLOW + killed.getName().toString() + ChatColor.GOLD + " ha sido asesinado por "
								+ ChatColor.GREEN + killer.getName().toString() + ChatColor.GOLD + ".");
				break;
			}
			break;

		case "green":
			switch (teams.checkPlayer(killer.getName().toLowerCase())) {
			case "blue":
				e.setDeathMessage(
						ChatColor.DARK_GREEN + killed.getName().toString() + ChatColor.GOLD + " ha sido asesinado por "
								+ ChatColor.DARK_BLUE + killer.getName().toString() + ChatColor.GOLD + ".");
				break;
			case "red":
				e.setDeathMessage(
						ChatColor.DARK_GREEN + killed.getName().toString() + ChatColor.GOLD + " ha sido asesinado por "
								+ ChatColor.RED + killer.getName().toString() + ChatColor.GOLD + ".");
				break;
			case "yellow":
				e.setDeathMessage(
						ChatColor.DARK_GREEN + killed.getName().toString() + ChatColor.GOLD + " ha sido asesinado por "
								+ ChatColor.YELLOW + killer.getName().toString() + ChatColor.GOLD + ".");
				break;
			}
			break;
		}

	}
}
