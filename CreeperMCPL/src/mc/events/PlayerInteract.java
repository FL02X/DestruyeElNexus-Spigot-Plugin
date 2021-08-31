package mc.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

import mc.main.Main;
import mc.menus.MenuTeams;
import net.md_5.bungee.api.ChatColor;

public class PlayerInteract implements Listener {

	private Plugin plugin;
	MenuTeams teams = new MenuTeams(Main.getPlugin(Main.class));
	

	public PlayerInteract(Main main) {
		this.plugin = plugin;
	}

	/*
	 * Used to interact with the items in the Lobby.
	 * The items content is in mc.events.Lobby
	 */
	
	@EventHandler
	public void playerInteractEvent(PlayerInteractEvent e) {
		
		Player player = e.getPlayer();
		
		if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (player.getItemInHand().getItemMeta().getDisplayName()
					.equals(ChatColor.BLUE + "Equipo " + ChatColor.GRAY + "(Click derecho)")) {
				player.openInventory(teams.getInventoryTeams());
			}
		}
		
		if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (player.getItemInHand().getItemMeta().getDisplayName()
					.equals(ChatColor.GOLD + "Kits " + ChatColor.GRAY + "(Click derecho)")) {
				player.performCommand("kit");
			}
		}
	}

}
