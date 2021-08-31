package mc.menus;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.Plugin;

import mc.main.Main;
import mc.methods.Teams;
import net.md_5.bungee.api.ChatColor;

public class MenuKitEvent implements Listener {

	Plugin plugin;
	Teams teams = new Teams();

	public MenuKitEvent(Main plugin) {
		this.plugin = plugin;
	}

	/*
	 * This event is fired when the player tries to select one Kit from the menu
	 * /kits, check mc.menus.MenuKit to change the menu appearance.
	 */

	@EventHandler
	public void inventoryClickEvent(InventoryClickEvent e) {
		Player player = (Player) e.getWhoClicked();

		if (e.getInventory().getName().equals(ChatColor.GRAY + "Elige un Kit")) {

			/*
			 * KIT CIVIL.
			 */

			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Civil")) {
				// This code is to know if the player is in the game.
				if (!(teams.checkPlayer(player.getName()) == "false") && Teams.isStartGame() == true) {

					teams.removeKit(player.getName());
					teams.setKit(player.getName(), "Civil");
					player.sendMessage(ChatColor.YELLOW + "Tendras este kit despues de morir.");
					player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
					player.closeInventory();
					e.setCancelled(true);

				} else {

					teams.removeKit(player.getName());
					teams.setKit(player.getName().toLowerCase(), "Civil");
					player.sendMessage(ChatColor.YELLOW + "Has seleccionado el kit: " + ChatColor.GREEN + "Civil"
							+ ChatColor.YELLOW + ".");
					player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
					player.closeInventory();
					e.setCancelled(true);

				}

			/*
			 * KIT MINERO.
			 */

			} else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Minero")) {
				if (!(teams.checkPlayer(player.getName()) == "false") && Teams.isStartGame() == true) {

					teams.removeKit(player.getName());
					teams.setKit(player.getName().toLowerCase(), "Minero");
					player.sendMessage(ChatColor.YELLOW + "Tendras este kit despues de morir.");
					player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
					player.closeInventory();
					e.setCancelled(true);

				} else {

					teams.removeKit(player.getName());
					teams.setKit(player.getName().toLowerCase(), "Minero");
					player.sendMessage(ChatColor.YELLOW + "Has seleccionado el kit: " + ChatColor.GREEN + "Minero"
							+ ChatColor.YELLOW + ".");
					player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
					player.closeInventory();
					e.setCancelled(true);

				}

			/*
			 * KIT LEÑADOR.
			 */

			} else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Leñador")) {
				if (!(teams.checkPlayer(player.getName()) == "false") && Teams.isStartGame() == true) {

					teams.removeKit(player.getName());
					teams.setKit(player.getName().toLowerCase(), "Leñador");
					player.sendMessage(ChatColor.YELLOW + "Tendras este kit despues de morir.");
					player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
					player.closeInventory();
					e.setCancelled(true);

				} else {

					teams.removeKit(player.getName());
					teams.setKit(player.getName().toLowerCase(), "Leñador");
					player.sendMessage(ChatColor.YELLOW + "Has seleccionado el kit: " + ChatColor.GREEN + "Leñador"
							+ ChatColor.YELLOW + ".");
					player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
					player.closeInventory();
					e.setCancelled(true);

				}
				
			/*
			 * KIT GUERRERO
			 */
			
			} else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Guerrero")) {
				if (!(teams.checkPlayer(player.getName()) == "false") && Teams.isStartGame() == true) {

					teams.removeKit(player.getName());
					teams.setKit(player.getName().toLowerCase(), "Guerrero");
					player.sendMessage(ChatColor.YELLOW + "Tendras este kit despues de morir.");
					player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
					player.closeInventory();
					e.setCancelled(true);

				} else {

					teams.removeKit(player.getName());
					teams.setKit(player.getName().toLowerCase(), "Guerrero");
					player.sendMessage(ChatColor.YELLOW + "Has seleccionado el kit: " + ChatColor.GREEN + "Guerrero"
							+ ChatColor.YELLOW + ".");
					player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
					player.closeInventory();
					e.setCancelled(true);

				}
				
			/*
			 * KIT ARQUERO.
			 */
				
			} else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Arquero")) {
				if (!(teams.checkPlayer(player.getName()) == "false") && Teams.isStartGame() == true) {

					teams.removeKit(player.getName());
					teams.setKit(player.getName().toLowerCase(), "Arquero");
					player.sendMessage(ChatColor.YELLOW + "Tendras este kit despues de morir.");
					player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
					player.closeInventory();
					e.setCancelled(true);

				} else {

					teams.removeKit(player.getName());
					teams.setKit(player.getName().toLowerCase(), "Arquero");
					player.sendMessage(ChatColor.YELLOW + "Has seleccionado el kit: " + ChatColor.GREEN + "Arquero"
							+ ChatColor.YELLOW + ".");
					player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
					player.closeInventory();
					e.setCancelled(true);

				}
				
			} else {
				e.setCancelled(true);
			}

		}
	}

}
