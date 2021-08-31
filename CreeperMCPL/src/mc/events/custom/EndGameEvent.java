package mc.events.custom;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.scheduler.BukkitRunnable;

import mc.main.Main;
import mc.methods.Teams;
import net.md_5.bungee.api.ChatColor;

public class EndGameEvent extends Event{

	Teams teams = new Teams();
	private static HandlerList handlers = new HandlerList();
	
	public EndGameEvent(String team) {
		Teams.setEndGame(true);
		Bukkit.getWorld("world").getBlockAt(teams.getLocaBlue()).setType(Material.BEDROCK);
		Bukkit.getWorld("world").getBlockAt(teams.getLocaRed()).setType(Material.BEDROCK);
		Bukkit.getWorld("world").getBlockAt(teams.getLocaYellow()).setType(Material.BEDROCK);
		Bukkit.getWorld("world").getBlockAt(teams.getLocaGreen()).setType(Material.BEDROCK);	
		
		switch(team) {
		case "blue":
			Bukkit.broadcastMessage(ChatColor.DARK_GRAY + "¡El " + ChatColor.DARK_BLUE + "equipo azul " + ChatColor.DARK_GRAY + "es el ganador!");
			for(Player p : Bukkit.getOnlinePlayers()) {
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
			}
			break;
		case "red":
			Bukkit.broadcastMessage(ChatColor.DARK_GRAY + "¡El " + ChatColor.RED + "equipo rojo " + ChatColor.DARK_GRAY + "es el ganador!");
			for(Player p : Bukkit.getOnlinePlayers()) {
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
			}
			break;
		case "yellow":
			Bukkit.broadcastMessage(ChatColor.DARK_GRAY + "¡El " + ChatColor.YELLOW + "equipo amarillo " + ChatColor.DARK_GRAY + "es el ganador!");
			for(Player p : Bukkit.getOnlinePlayers()) {
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
			}
			break;
		case "green":
			Bukkit.broadcastMessage(ChatColor.DARK_GRAY + "¡El " + ChatColor.GREEN + "equipo verde " + ChatColor.DARK_GRAY + "es el ganador!");
			for(Player p : Bukkit.getOnlinePlayers()) {
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
			}
			break;
		}
		
		new BukkitRunnable() {
			@Override
			public void run() {
				Bukkit.getServer().shutdown();
			}			
		}.runTaskLater(Main.getPlugin(Main.class), 600L);
	}
	
	
	
	
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
	
	public static HandlerList getHandlerList() {
		return handlers;
	}

}
