package mc.menus;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import mc.main.Main;
import mc.methods.Teams;
import net.md_5.bungee.api.ChatColor;

public class MenuTeamsEvent implements Listener {

	Plugin plugin;
	Teams teams = new Teams();

	public MenuTeamsEvent(Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void inventoryClickEvent(InventoryClickEvent e) {
		Player player = (Player) e.getWhoClicked();
		ItemStack blueWool = new ItemStack(Material.WOOL, 1, (byte) 3);
		ItemStack redWool = new ItemStack(Material.WOOL, 1, (byte) 14);
		ItemStack yellowWool = new ItemStack(Material.WOOL, 1, (byte) 4);
		ItemStack greenWool = new ItemStack(Material.WOOL, 1, (byte) 13);

		if (e.getInventory().getName().equalsIgnoreCase(ChatColor.GRAY + "Elige un equipo")) {
			if (!(Teams.getAllTeams().contains(player.getName().toLowerCase())) || Teams.isStartGame() == false) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "Equipo Azul")) {
					if (teams.checkPlayer(player.getName().toLowerCase()) == "blue") {
						player.sendMessage(ChatColor.RED + "Ya estas en este equipo");
						player.playSound(player.getLocation(), Sound.EAT, 1, 1);
						player.closeInventory();
						e.setCancelled(true);
					} else {
						teams.removePlayer(player.getName().toLowerCase());
						teams.addPlayerTeam(player.getName().toLowerCase(), "blue");
						player.sendMessage(ChatColor.GRAY + "Has entrado al equipo " + ChatColor.DARK_BLUE + "Azul");
						if (Teams.isStartGame() == true) {
							player.setHealth(0);
						}
						player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
						player.closeInventory();
						e.setCancelled(true);
					}
				} else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "Equipo Rojo")) {
					if (teams.checkPlayer(player.getName().toLowerCase()) == "red") {
						player.sendMessage(ChatColor.RED + "Ya estas en este equipo");
						player.playSound(player.getLocation(), Sound.EAT, 1, 1);
						player.closeInventory();
						e.setCancelled(true);
					} else {
						teams.removePlayer(player.getName().toLowerCase());
						teams.addPlayerTeam(player.getName().toLowerCase(), "red");
						player.sendMessage(ChatColor.GRAY + "Has entrado al equipo " + ChatColor.RED + "Rojo");
						if (Teams.isStartGame() == true) {
							player.setHealth(0);
						}
						player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
						player.closeInventory();
						e.setCancelled(true);
					}
				} else if (e.getCurrentItem().getItemMeta().getDisplayName()
						.equals(ChatColor.YELLOW + "Equipo Amarillo")) {
					if (teams.checkPlayer(player.getName().toLowerCase()) == "yellow") {
						player.sendMessage(ChatColor.RED + "Ya estas en este equipo");
						player.playSound(player.getLocation(), Sound.EAT, 1, 1);
						player.closeInventory();
						e.setCancelled(true);
					} else {
						teams.removePlayer(player.getName().toLowerCase());
						teams.addPlayerTeam(player.getName().toLowerCase(), "yellow");
						player.sendMessage(ChatColor.GRAY + "Has entrado al equipo " + ChatColor.YELLOW + "Amarillo");
						if (Teams.isStartGame() == true) {
							player.setHealth(0);
						}
						player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
						player.closeInventory();
						e.setCancelled(true);
					}
				} else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Equipo Verde")) {
					if (teams.checkPlayer(player.getName().toLowerCase()) == "green") {
						player.sendMessage(ChatColor.RED + "Ya estas en este equipo");
						player.playSound(player.getLocation(), Sound.EAT, 1, 1);
						player.closeInventory();
						e.setCancelled(true);
					} else {
						teams.removePlayer(player.getName().toLowerCase());
						teams.addPlayerTeam(player.getName().toLowerCase(), "green");
						player.sendMessage(ChatColor.GRAY + "Has entrado al equipo " + ChatColor.DARK_GREEN + "Verde");
						if (Teams.isStartGame() == true) {
							player.setHealth(0);
						}
						player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
						player.closeInventory();
						e.setCancelled(true);
					}
				} else if (e.getCurrentItem().getItemMeta().getDisplayName()
						.equals(ChatColor.GOLD + "Equipo aleatorio")) {

					Random random = new Random();
					int rand = 1 + random.nextInt((4 - 1) + 1);

					if (rand == 1) {
						teams.removePlayer(player.getName().toLowerCase());
						teams.addPlayerTeam(player.getName().toLowerCase(), "blue");
						player.sendMessage(ChatColor.GRAY + "Has entrado al equipo " + ChatColor.DARK_BLUE + "Azul");
						if (Teams.isStartGame() == true) {
							player.setHealth(0);
						}
						player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
						player.closeInventory();
						e.setCancelled(true);
					}

					if (rand == 2) {
						teams.removePlayer(player.getName().toLowerCase());
						teams.addPlayerTeam(player.getName().toLowerCase(), "red");
						player.sendMessage(ChatColor.GRAY + "Has entrado al equipo " + ChatColor.RED + "Rojo");
						if (Teams.isStartGame() == true) {
							player.setHealth(0);
						}
						player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
						player.closeInventory();
						e.setCancelled(true);
					}

					if (rand == 3) {
						teams.removePlayer(player.getName().toLowerCase());
						teams.addPlayerTeam(player.getName().toLowerCase(), "yellow");
						player.sendMessage(ChatColor.GRAY + "Has entrado al equipo " + ChatColor.YELLOW + "Amarillo");
						if (Teams.isStartGame() == true) {
							player.setHealth(0);
						}
						player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
						player.closeInventory();
						e.setCancelled(true);
					}

					if (rand == 4) {
						teams.removePlayer(player.getName().toLowerCase());
						teams.addPlayerTeam(player.getName().toLowerCase(), "green");
						player.sendMessage(ChatColor.GRAY + "Has entrado al equipo " + ChatColor.DARK_GREEN + "Verde");
						if (Teams.isStartGame() == true) {
							player.setHealth(0);
						}
						player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
						player.closeInventory();
						e.setCancelled(true);
					}

				} else {
					e.setCancelled(true);
				}
			} else {
				e.setCancelled(true);
				player.playSound(player.getLocation(), Sound.EAT, 1, 1);
				player.closeInventory();
				player.sendMessage(ChatColor.RED + "¡No puedes cambiar de equipo una vez empezada la partida!");
			}

		}
	}

}
