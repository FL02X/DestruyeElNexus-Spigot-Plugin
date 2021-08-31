package mc.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import mc.events.custom.StartGameEvent;
import mc.main.Main;
import mc.methods.Scoreboards;
import mc.methods.Teams;
import net.md_5.bungee.api.ChatColor;

public class Lobby implements Listener {

	Plugin plugin;
	Teams teams;
	Scoreboards score;

	public Lobby(Main plugin) {
		this.plugin = plugin;
	}

	/*
	 * This event is used to control the Lobby, aswell to the respawn in the game
	 * after it has started.
	 */

	@EventHandler
	public void playerJoinEvent(PlayerJoinEvent e) {
		teams = new Teams();
		score = new Scoreboards();
		Player player = e.getPlayer();

		ItemStack teamSelector = new ItemStack(Material.NETHER_STAR);
		ItemStack kitSelector = new ItemStack(Material.GOLD_AXE);
		ItemStack mapSelector = new ItemStack(Material.MAP);
		ItemStack leave = new ItemStack(Material.BED);
		ItemMeta teamSelectorMeta = teamSelector.getItemMeta();
		ItemMeta kitSelectorMeta = kitSelector.getItemMeta();
		ItemMeta mapSelectorMeta = mapSelector.getItemMeta();
		ItemMeta leaveMeta = leave.getItemMeta();
		teamSelectorMeta.setDisplayName(ChatColor.BLUE + "Equipo " + ChatColor.GRAY + "(Click derecho)");
		kitSelectorMeta.setDisplayName(ChatColor.GOLD + "Kits " + ChatColor.GRAY + "(Click derecho)");
		mapSelectorMeta.setDisplayName(ChatColor.GREEN + "Mapas " + ChatColor.GRAY + "(Click derecho)");
		leaveMeta.setDisplayName(ChatColor.RED + "Regresar al Lobby " + ChatColor.GRAY + "(Click derecho)");
		teamSelector.setItemMeta(teamSelectorMeta);
		kitSelector.setItemMeta(kitSelectorMeta);
		mapSelector.setItemMeta(mapSelectorMeta);
		leave.setItemMeta(leaveMeta);

		Location lobby = new Location(Bukkit.getWorld("lobby"), 191.424, 38, 195.590);

		if (Teams.isStartGame() == false) {
			e.setJoinMessage(ChatColor.GRAY + e.getPlayer().getName() + ChatColor.BLUE + " se ha unido al lobby "
					+ ChatColor.DARK_GRAY + "(" + ChatColor.DARK_GREEN + Bukkit.getOnlinePlayers().size()
					+ ChatColor.DARK_GRAY + "/" + ChatColor.DARK_GREEN + Bukkit.getServer().getMaxPlayers()
					+ ChatColor.DARK_GRAY + ")");
			player.setPlayerListName(ChatColor.WHITE + player.getName());
			teams.setKit(player.getName(), "Civil");
		} else {
			e.setJoinMessage("");
		}

		if (Bukkit.getOnlinePlayers().size() > 1 && Teams.isStartGame() == false) {
			Bukkit.getServer().getPluginManager().callEvent(new StartGameEvent());
		}

		if (Teams.isStartGame() == true) {
			switch (teams.checkPlayer(e.getPlayer().getName().toLowerCase())) {
			case "false":
				player.setScoreboard(score.denScoreboard(player));
				player.setPlayerListName(ChatColor.WHITE + player.getName());
				player.teleport(lobby);
				player.setBedSpawnLocation(lobby, true);
				player.getInventory().clear();
				player.getInventory().setHelmet(null);
				player.getInventory().setChestplate(null);
				player.getInventory().setLeggings(null);
				player.getInventory().setBoots(null);
				player.getInventory().setItem(0, teamSelector);
				player.getInventory().setItem(1, kitSelector);
				player.getInventory().setItem(2, mapSelector);
				player.getInventory().setItem(8, leave);
				break;
			case "blue":
				player.setScoreboard(score.denScoreboard(player));
				player.setPlayerListName(ChatColor.BLUE + player.getName());
				teams.removePlayer(e.getPlayer().getName());
				teams.addPlayerTeam(e.getPlayer().getName(), "blue");
				break;
			case "red":
				player.setScoreboard(score.denScoreboard(player));
				player.setPlayerListName(ChatColor.RED + player.getName());
				teams.removePlayer(e.getPlayer().getName());
				teams.addPlayerTeam(e.getPlayer().getName(), "red");
				break;
			case "yellow":
				player.setScoreboard(score.denScoreboard(player));
				player.setPlayerListName(ChatColor.YELLOW + player.getName());
				teams.removePlayer(e.getPlayer().getName());
				teams.addPlayerTeam(e.getPlayer().getName(), "yellow");
				break;
			case "green":
				player.setScoreboard(score.denScoreboard(player));
				player.setPlayerListName(ChatColor.GREEN + player.getName());
				teams.removePlayer(e.getPlayer().getName());
				teams.addPlayerTeam(e.getPlayer().getName(), "green");
				break;
			}
		} else {
			player.setScoreboard(score.denWaiting());
			player.teleport(lobby);
			player.setBedSpawnLocation(lobby, true);
			player.getInventory().setHelmet(null);
			player.getInventory().setChestplate(null);
			player.getInventory().setLeggings(null);
			player.getInventory().setBoots(null);
			player.getInventory().clear();
			player.getInventory().setItem(0, teamSelector);
			player.getInventory().setItem(1, kitSelector);
			player.getInventory().setItem(2, mapSelector);
			player.getInventory().setItem(8, leave);
			teams.setKit(player.getName(), "Civil");
		}

	}

	/*
	 * Used to remove the spawning of monsters in Lobby and overworld.
	 */

	@EventHandler
	public void creatureSpawnEvent(CreatureSpawnEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void blockBreakEvent(BlockBreakEvent e) {
		if(e.getBlock().getWorld() == Bukkit.getWorld("lobby")) {
			e.setCancelled(true);
		}
	}

}
