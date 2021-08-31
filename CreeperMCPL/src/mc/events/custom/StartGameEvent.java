package mc.events.custom;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

import mc.main.Main;
import mc.methods.Scoreboards;
import mc.methods.Teams;
import net.md_5.bungee.api.ChatColor;

public class StartGameEvent extends Event {

	private static final HandlerList handlers = new HandlerList();
	private boolean cancelled;
	private boolean state;
	Teams teams = new Teams();
	Scoreboards score = new Scoreboards();
	Location lobby = new Location(Bukkit.getWorld("world"), 301, 116, 310);
	Location spawnBlue = new Location(Bukkit.getWorld("world"), 445, 87, 162);
	Location spawnRed = new Location(Bukkit.getWorld("world"), 157, 87, 163);
	Location spawnYellow = new Location(Bukkit.getWorld("world"), 157, 87, 450);
	Location spawnGreen = new Location(Bukkit.getWorld("world"), 445, 87, 449);

	@SuppressWarnings("unused")
	public StartGameEvent() {
		boolean startChronometer;

		BukkitScheduler startTimer1 = Bukkit.getServer().getScheduler();
		BukkitScheduler startTimer2 = Bukkit.getServer().getScheduler();
		BukkitScheduler startTimer3 = Bukkit.getServer().getScheduler();
		BukkitScheduler startTimer4 = Bukkit.getServer().getScheduler();
		BukkitScheduler startTimer5 = Bukkit.getServer().getScheduler();
		BukkitScheduler startTimer6 = Bukkit.getServer().getScheduler();
		BukkitScheduler startTimer7 = Bukkit.getServer().getScheduler();
		BukkitScheduler startTimer8 = Bukkit.getServer().getScheduler();
		BukkitScheduler timer = Bukkit.getServer().getScheduler();

		/*-
		 * This custom event is made with the purpose of start the game and get used by
		 * the command in mc.command.DenCommands called "/den startGame" and the event
		 * "Lobby" in mc.events.Lobby.
		 * 
		 * THINGS THAT I NEED TO ADD: 
		 * - Reset the timer when the condition is not longer true. (Example: The lobby has one less player that the minimum).
		 * - Cancel the timer with a command.
		 */

		// @formatter:off
		if (this.cancelled == false) {
			Bukkit.broadcastMessage(ChatColor.GOLD + "La partida comenzara en 30 segundos.");
			for (Player player : Bukkit.getOnlinePlayers()) {
				player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1, 1); 			
			}
		// @formatter:on

//			final int stopTimer1 = startTimer1.scheduleSyncDelayedTask(Main.getPlugin(Main.class), new Runnable() {
//				@Override
//				public void run() {
//					Bukkit.broadcastMessage(ChatColor.GOLD + "La partida comenzara en 20 segundos.");
//					for (Player player : Bukkit.getOnlinePlayers()) {
//						player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1, 1);
//					}
//				}
//			}, 200L);
//
//			final int stopTimer2 = startTimer2.scheduleSyncDelayedTask(Main.getPlugin(Main.class), new Runnable() {
//				@Override
//				public void run() {
//					Bukkit.broadcastMessage(ChatColor.GOLD + "La partida comenzara en 10 segundos.");
//					for (Player player : Bukkit.getOnlinePlayers()) {
//						player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1, 1);
//					}
//				}
//			}, 400L);
//
//			final int stopTimer3 = startTimer3.scheduleSyncDelayedTask(Main.getPlugin(Main.class), new Runnable() {
//				@Override
//				public void run() {
//					Bukkit.broadcastMessage(ChatColor.GOLD + "La partida comenzara en 5 segundos.");
//					for (Player player : Bukkit.getOnlinePlayers()) {
//						player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1, 1);
//					}
//				}
//			}, 500L);
//
//			final int stopTimer4 = startTimer4.scheduleSyncDelayedTask(Main.getPlugin(Main.class), new Runnable() {
//				@Override
//				public void run() {
//					Bukkit.broadcastMessage(ChatColor.GOLD + "La partida comenzara en 4 segundos.");
//					for (Player player : Bukkit.getOnlinePlayers()) {
//						player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1, 1);
//					}
//				}
//			}, 520L);
//
//			final int stopTimer5 = startTimer5.scheduleSyncDelayedTask(Main.getPlugin(Main.class), new Runnable() {
//				@Override
//				public void run() {
//					Bukkit.broadcastMessage(ChatColor.GOLD + "La partida comenzara en 3 segundos.");
//					for (Player player : Bukkit.getOnlinePlayers()) {
//						player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1, 1);
//					}
//				}
//			}, 540L);
//
//			final int stopTimer6 = startTimer6.scheduleSyncDelayedTask(Main.getPlugin(Main.class), new Runnable() {
//				@Override
//				public void run() {
//					Bukkit.broadcastMessage(ChatColor.GOLD + "La partida comenzara en 2 segundos.");
//					for (Player player : Bukkit.getOnlinePlayers()) {
//						player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1, 1);
//					}
//				}
//			}, 560L);
//
//			final int stopTimer7 = startTimer7.scheduleSyncDelayedTask(Main.getPlugin(Main.class), new Runnable() {
//				@Override
//				public void run() {
//					Bukkit.broadcastMessage(ChatColor.GOLD + "La partida comenzara en 1 segundos.");
//					for (Player player : Bukkit.getOnlinePlayers()) {
//						player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1, 1);
//					}
//				}
//			}, 580L);

			final int stopTimer8 = startTimer8.scheduleSyncDelayedTask(Main.getPlugin(Main.class), new Runnable() {

				@Override
				public void run() {

					Teams.setStartGame(true);
					
					Bukkit.broadcastMessage(ChatColor.GOLD + "¡La partida ha comenzado!");
					for (Player player : Teams.getPlayerBlueListTeam()) {
						player.setHealth(0);
						player.setPlayerListName(ChatColor.DARK_BLUE + player.getName());
						player.teleport(spawnBlue);
					}
					for (Player player : Teams.getPlayerRedListTeam()) {
						player.setHealth(0);
						player.setPlayerListName(ChatColor.RED + player.getName());
						player.teleport(spawnRed);
					}
					for (Player player : Teams.getPlayerYellowListTeam()) {
						player.setHealth(0);
						player.setPlayerListName(ChatColor.YELLOW + player.getName());
						player.teleport(spawnYellow);
					}
					for (Player player : Teams.getPlayerGreenListTeam()) {
						player.setHealth(0);
						player.setPlayerListName(ChatColor.GREEN + player.getName());
						player.teleport(spawnGreen);
					}
					for (Player player : Bukkit.getOnlinePlayers()) {
						player.setScoreboard(score.denScoreboard(player));
						player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
						if (teams.getKit(player.getName().toLowerCase()).equals("null")) {
							teams.setKit(player.getName().toLowerCase(), "Civil");
						}
					}
				}
			}, 20L);

			/*
			 * Timer logic for the scoreboard. The static variables are in mc.methods.Teams
			 * and the scoreboard that used it is in mc.methods.Scoreboards
			 */

			new BukkitRunnable() {

				@Override
				public void run() {

					if (Teams.timerM == 6) {
						Teams.timerM = 0;
						Teams.timerH++;
					}

					if (Teams.timerM2 == 10) {
						Teams.timerM2 = 0;
						Teams.timerM++;
					}

					if (Teams.timerS == 5 && Teams.timerS2 == 9) {
						Teams.timerS = -1;
						Teams.timerM2++;
					}

					if (Teams.timerS2 == 9) {
						Teams.timerS2 = -1;
						Teams.timerS++;
					}

					Teams.timerS2++;
				}
			}.runTaskTimer(Main.getPlugin(Main.class), 20L, 20L); // Time to wait and delay between one task to
																	// another, in this case 20L = 1 second.
			
			
			new BukkitRunnable() {
				@Override
				public void run() {
					if(teams.getPhase() <= 4) {
					teams.setPhase(teams.getPhase() + 1);							
					}
					switch(teams.getPhase()) {
					case 1:
						Bukkit.getWorld("world").getBlockAt(teams.getLocaBlue()).setType(Material.BEDROCK);
						Bukkit.getWorld("world").getBlockAt(teams.getLocaRed()).setType(Material.BEDROCK);
						Bukkit.getWorld("world").getBlockAt(teams.getLocaYellow()).setType(Material.BEDROCK);
						Bukkit.getWorld("world").getBlockAt(teams.getLocaGreen()).setType(Material.BEDROCK);
						break;
					case 2:
						Bukkit.getWorld("world").getBlockAt(teams.getLocaBlue()).setType(Material.ENDER_STONE); 
						Bukkit.getWorld("world").getBlockAt(teams.getLocaRed()).setType(Material.ENDER_STONE);
						Bukkit.getWorld("world").getBlockAt(teams.getLocaYellow()).setType(Material.ENDER_STONE);
						Bukkit.getWorld("world").getBlockAt(teams.getLocaGreen()).setType(Material.ENDER_STONE);
					}
				}				
			}.runTaskTimer(Main.getPlugin(Main.class), 20L, 120L); //12000 = Wait 10 minutes to change phase. 
			
			
			
			
		}

	}
	

	public boolean isCancelled() {
		return cancelled;
	}

	public void setCancelled(boolean cancel) {
		cancelled = cancel;
	}

	public boolean isStarted() {
		return state;
	}

	// -------------------------------------

	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}

}
