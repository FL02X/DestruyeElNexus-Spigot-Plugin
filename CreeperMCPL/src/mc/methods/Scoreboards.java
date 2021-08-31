package mc.methods;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import mc.main.Main;
import net.md_5.bungee.api.ChatColor;

public class Scoreboards {
	
	Teams teams = new Teams();

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	LocalDateTime now = LocalDateTime.now();

	/*
	 * Display ingame user's scoreboard.
	 */

	public Scoreboard denScoreboard(Player player) {

		/*-
		 * The best way to make the scoreboards not flicker is making the score a "Team" and then
		 * reload his values changing the prefix o suffix instead of reload all the scoreboard
		 * with a "for" statement.
		 * 
		 * IMPORTANT! The name of the Entry must not be the same, instead, use the ChatColor's
		 * to make them different if the entry must be the same (like a space, in this case).
		 */

		Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective objective = scoreboard.registerNewObjective("scoreboard", "a");
		objective.setDisplayName(ChatColor.GOLD + "Destruye el nexus");
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);

		Score date = objective.getScore(ChatColor.DARK_GRAY + dtf.format(now));
		date.setScore(11);

		Score space = objective.getScore("    ");
		space.setScore(10);
		
		Team phase = scoreboard.registerNewTeam("phase");
		phase.addEntry(ChatColor.GOLD + "e: " + ChatColor.WHITE);
		phase.setPrefix(ChatColor.GOLD +  "Fas");
		phase.setSuffix(Integer.toString(teams.getPhase()));
		objective.getScore(ChatColor.GOLD + "e: " + ChatColor.WHITE).setScore(9);

		Team timer = scoreboard.registerNewTeam("timer");
		timer.addEntry(ChatColor.WHITE + ":");
		timer.setPrefix(ChatColor.GOLD + "Tiempo: " + ChatColor.WHITE + Teams.timerH);
		timer.setSuffix("" + Teams.timerM + Teams.timerM2 + ":" + Teams.timerS + Teams.timerS2);
		objective.getScore(ChatColor.WHITE + ":").setScore(8);

//		Team players = scoreboard.registerNewTeam("player");
//		players.addEntry(ChatColor.WHITE + "");
//		players.setPrefix(ChatColor.GOLD + "Jugadores: ");
//		players.setSuffix("" + Bukkit.getOnlinePlayers().size());
//		objective.getScore(ChatColor.WHITE + "").setScore(7);

		Score space2 = objective.getScore("      ");
		space2.setScore(7);

		Team blueNexus = scoreboard.registerNewTeam("blueNexus");
		blueNexus.addEntry(ChatColor.RED + " ");
		blueNexus.setPrefix(ChatColor.RED + "" + Teams.getNexusLifeBlue());
		blueNexus.setSuffix(ChatColor.DARK_BLUE + "Equipo azul");
		objective.getScore(ChatColor.RED + " ").setScore(6);

		// ---
		Team redNexus = scoreboard.registerNewTeam("redNexus");
		redNexus.addEntry(" E");
		redNexus.setPrefix(ChatColor.RED + "" + Teams.getNexusLifeRed());
		redNexus.setSuffix("quipo rojo");
		objective.getScore(" E").setScore(5);

		Team yellowNexus = scoreboard.registerNewTeam("yellowNexus");
		yellowNexus.addEntry(ChatColor.YELLOW + " E");
		yellowNexus.setPrefix(ChatColor.RED + "" + Teams.getNexusLifeYellow());
		yellowNexus.setSuffix("quipo amarillo");
		objective.getScore(ChatColor.YELLOW + " E").setScore(4);

		Team greenNexus = scoreboard.registerNewTeam("greenNexus");
		greenNexus.addEntry(ChatColor.GREEN + " E");
		greenNexus.setPrefix(ChatColor.RED + "" + Teams.getNexusLifeGreen());
		greenNexus.setSuffix("quipo verde");
		objective.getScore(ChatColor.GREEN + " E").setScore(3);

		Score space4 = objective.getScore("   ");
		//This one updates only when the player dies, implementation in mc.events.RespawnEvent
		Score kit = objective.getScore(ChatColor.GOLD + "Kit: " + ChatColor.WHITE + teams.getKit(player.getName()));
		Score space5 = objective.getScore(ChatColor.GOLD + "Asesinatos: " + ChatColor.WHITE + "0");

		kit.setScore(1);
		space4.setScore(2);
		space5.setScore(0);

		// This is where we change the values. Add only those parts who will change
		// all the time, not all the team entry.

		new BukkitRunnable() {
			@Override
			public void run() {
				phase.setSuffix(Integer.toString(teams.getPhase()));
				timer.setPrefix(ChatColor.GOLD + "Tiempo: " + ChatColor.WHITE + Teams.timerH);
				timer.setSuffix("" + Teams.timerM + Teams.timerM2 + ":" + Teams.timerS + Teams.timerS2);
				//players.setSuffix("" + Bukkit.getOnlinePlayers().size());
				blueNexus.setPrefix(ChatColor.RED + "" + Teams.getNexusLifeBlue());
				redNexus.setPrefix(ChatColor.RED + "" + Teams.getNexusLifeRed());
				yellowNexus.setPrefix(ChatColor.RED + "" + Teams.getNexusLifeYellow());
				greenNexus.setPrefix(ChatColor.RED + "" + Teams.getNexusLifeGreen());

			}
		}.runTaskTimer(Main.getPlugin(Main.class), 0L, 0L);

		return scoreboard;

	}

	public Scoreboard denWaiting() {

		Scoreboard denWelcome = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective objective = denWelcome.registerNewObjective("welcome", "b");

		objective.setDisplayName(ChatColor.YELLOW + "LOBBY");
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);

		Score date = objective.getScore(ChatColor.DARK_GRAY + dtf.format(now));
		Score space1 = objective.getScore("  ");
		Score mensaje = objective.getScore(ChatColor.GOLD + "Esperando jugadores...");
		Score space2 = objective.getScore(" ");

		Team players = denWelcome.registerNewTeam("players");
		players.addEntry(ChatColor.GREEN + " ");
		players.setPrefix(ChatColor.GOLD + "Jugadores:");
		players.setSuffix(Integer.toString(Bukkit.getOnlinePlayers().size()) + "/" + Bukkit.getServer().getMaxPlayers());
		objective.getScore(ChatColor.GREEN + " ").setScore(0);

		date.setScore(4);
		space1.setScore(3);
		mensaje.setScore(2);
		space2.setScore(1);

		new BukkitRunnable() {
			@Override
			public void run() {
				players.setSuffix(Integer.toString(Bukkit.getOnlinePlayers().size()) + "/" + Bukkit.getServer().getMaxPlayers());
			}
		}.runTaskTimer(Main.getPlugin(Main.class), 0L, 0L);

		return denWelcome;
	}
}
