package mc.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

import mc.main.Main;
import mc.menus.MenuKit;
import mc.methods.Teams;

public class NetherPortal implements Listener {

	private Plugin plugin;
	Teams teams = new Teams();
	MenuKit kit = new MenuKit(Main.getPlugin(Main.class));
	Location spawnBlue = new Location(Bukkit.getWorld("world"), 445, 87, 162);
	Location spawnRed = new Location(Bukkit.getWorld("world"), 157, 87, 163);
	Location spawnYellow = new Location(Bukkit.getWorld("world"), 157, 87, 450);
	Location spawnGreen = new Location(Bukkit.getWorld("world"), 445, 87, 449);

	public NetherPortal(Main main) {
		this.plugin = plugin;
	}

	@EventHandler
	public void playerPortalEvent(PlayerPortalEvent e) {
		e.setCancelled(true);
		
		Player p = e.getPlayer();
		if (Teams.getBlueListTeam().contains(p.getName().toLowerCase())) {
			p.teleport(spawnBlue);
			p.openInventory(kit.getKitInventory());
			p.sendMessage("u");
		}
		
	}
}
