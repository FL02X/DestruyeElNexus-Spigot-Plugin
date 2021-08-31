package mc.events;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.Plugin;

import mc.main.Main;
import mc.methods.UtilMethods;
import net.md_5.bungee.api.ChatColor;

public class SpawnProtectedZone implements Listener {

	private Plugin plugin;
	UtilMethods util = new UtilMethods();

	/*
	 * Spawn teams protection.
	 */

	public SpawnProtectedZone(Main main) {
		this.plugin = plugin;
	}

	World coastal = Bukkit.getWorld("world");

	// Blue Zone
	Location blueProtectedZoneHigh = new Location(coastal, 444.502, 301.34547, 163.489);
	Location blueProtectedZoneLow = new Location(coastal, 475, 65, 132);
	List<Block> spawnBlue = util.blocksFromTwoPoints(blueProtectedZoneHigh, blueProtectedZoneLow);

	// Red zone
	Location redProtectedZoneHigh = new Location(coastal, 158.522, 301.34547, 163.489);
	Location redProtectedZoneLow = new Location(coastal, 127.500, 65, 132);
	List<Block> spawnRed = util.blocksFromTwoPoints(redProtectedZoneHigh, redProtectedZoneLow);

	// Yellow zone
	Location yellowProtectedZoneHigh = new Location(coastal, 158.522, 301.34547, 449.522);
	Location yellowProtectedZoneLow = new Location(coastal, 127.500, 65, 480);
	List<Block> spawnYellow = util.blocksFromTwoPoints(redProtectedZoneHigh, redProtectedZoneLow);

	// Green zone
	Location greenProtectedZoneHigh = new Location(coastal, 444.522, 301.34547, 449.489);
	Location greenProtectedZoneLow = new Location(coastal, 475.500, 65, 480);
	List<Block> spawnGreen = util.blocksFromTwoPoints(redProtectedZoneHigh, redProtectedZoneLow);

	@EventHandler
	public void blockBreakEvent(BlockBreakEvent e) {

		if (e.getPlayer().getGameMode() == GameMode.SURVIVAL) {
			if (e.getPlayer().getWorld() == Bukkit.getWorld("world")) {
				if (!(e.getBlock().getType() == Material.ENDER_STONE)) {
					if (spawnBlue.contains(e.getBlock())) {
						e.getPlayer().sendMessage(ChatColor.GRAY + "Esta zona esta protegida por el " + ChatColor.BLUE
								+ "equipo azul" + ChatColor.GRAY + ".");
						e.setCancelled(true);
					} else if (spawnRed.contains(e.getBlock())) {
						e.getPlayer().sendMessage(ChatColor.GRAY + "Esta zona esta protegida por el " + ChatColor.RED
								+ "equipo rojo" + ChatColor.GRAY + ".");
						e.setCancelled(true);
					} else if (spawnYellow.contains(e.getBlock())) {
						e.getPlayer().sendMessage(ChatColor.GRAY + "Esta zona esta protegida por el " + ChatColor.YELLOW
								+ "equipo amarillo" + ChatColor.GRAY + ".");
						e.setCancelled(true);
					} else if (spawnGreen.contains(e.getBlock())) {
						e.getPlayer().sendMessage(ChatColor.GRAY + "Esta zona esta protegida por el " + ChatColor.GREEN
								+ "equipo verde" + ChatColor.GRAY + ".");
						e.setCancelled(true);
					}
				}
			}
		}
	}

}
