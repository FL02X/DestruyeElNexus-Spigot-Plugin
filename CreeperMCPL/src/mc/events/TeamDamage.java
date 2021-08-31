package mc.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.Plugin;

import mc.main.Main;
import mc.methods.Teams;

public class TeamDamage implements Listener {

	Plugin plugin;
	Teams teams = new Teams();

	public TeamDamage(Main plugin) {
		this.plugin = plugin;
	}

	/*
	 * Used to remove the friendly fire.
	 */

	@EventHandler
	public void entityDamageByEntityEvent(EntityDamageByEntityEvent e) {
		Entity damager = e.getDamager();
		
		if(damager.getWorld() == Bukkit.getWorld("lobby")) {
			e.setCancelled(true);
		}

		if (damager instanceof Player) {
			if (teams.checkPlayer(e.getDamager().getName()).equalsIgnoreCase("blue")
					&& teams.checkPlayer(e.getEntity().getName()).equalsIgnoreCase("blue")) {
				e.setCancelled(true);
			}

			else if (teams.checkPlayer(e.getDamager().getName()).equalsIgnoreCase("red")
					&& teams.checkPlayer(e.getEntity().getName()).equalsIgnoreCase("red")) {
				e.setCancelled(true);
			}

			else if (teams.checkPlayer(e.getDamager().getName()).equalsIgnoreCase("yellow")
					&& teams.checkPlayer(e.getEntity().getName()).equalsIgnoreCase("yellow")) {
				e.setCancelled(true);
			}

			else if (teams.checkPlayer(e.getDamager().getName()).equalsIgnoreCase("green")
					&& teams.checkPlayer(e.getEntity().getName()).equalsIgnoreCase("green")) {
				e.setCancelled(true);
			} else {
				e.setCancelled(false);
			}
		}
	}

}
