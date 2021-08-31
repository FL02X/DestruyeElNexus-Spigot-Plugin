package mc.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.Scoreboard;

import mc.main.Main;
import mc.methods.Scoreboards;
import mc.methods.Teams;
import net.md_5.bungee.api.ChatColor;

public class RespawnEvent implements Listener {
	
	@SuppressWarnings("unused")
	private Plugin plugin;
	Scoreboards score = new Scoreboards();	
	Teams teams = new Teams();
	Location lobby = new Location(Bukkit.getWorld("lobby"), 191.424, 38, 195.590);
	Location spawnBlue = new Location(Bukkit.getWorld("world"), 445, 87, 162);
	Location spawnRed = new Location(Bukkit.getWorld("world"), 157, 87, 163);
	Location spawnYellow = new Location(Bukkit.getWorld("world"), 157, 87, 450);
	Location spawnGreen = new Location(Bukkit.getWorld("world"), 445, 87, 449);
	
	public RespawnEvent(Main plugin) {
		this.plugin = plugin;
	}
	
	/*
	 * Used to respawn the player to his team base after he dies.
	 * 
	 * ------------- NEEDS MORE RESPAWN POINTS -------------------
	 */
	
	@EventHandler
	public void playerRespawnEvent(PlayerRespawnEvent e) {
		Player player = e.getPlayer();		
		
		if(teams.getLosePlayer(e.getPlayer().getName().toLowerCase()) == true) {
			e.getPlayer().sendMessage(ChatColor.RED + "Tu equipo ha sido eliminado. Ya no puedes respawnear.");
			player.setPlayerListName(ChatColor.GRAY + "" + ChatColor.ITALIC + player.getName());
			player.teleport(lobby);
		}
		
		
		if (Teams.isStartGame() == true) {
			switch (teams.checkPlayer(e.getPlayer().getName().toLowerCase())) {
			case "null":
				player.teleport(lobby);
				break;
			case "blue":
				e.setRespawnLocation(spawnBlue);
				player.setScoreboard(score.denScoreboard(player));
				player.setPlayerListName(ChatColor.BLUE + player.getName());
				break;
			case "red":
				e.setRespawnLocation(spawnRed);
				player.setScoreboard(score.denScoreboard(player));
				player.setPlayerListName(ChatColor.RED + player.getName());
				break;
			case "yellow":
				e.setRespawnLocation(spawnYellow);
				player.setScoreboard(score.denScoreboard(player));
				player.setPlayerListName(ChatColor.YELLOW + player.getName());
				break;
			case "green":
				e.setRespawnLocation(spawnGreen);
				player.setScoreboard(score.denScoreboard(player));
				player.setPlayerListName(ChatColor.GREEN + player.getName());
				break;
			}				
		} else {
				e.setRespawnLocation(lobby);
				player.setScoreboard(score.denWaiting());
		}
		
	}
	
}
