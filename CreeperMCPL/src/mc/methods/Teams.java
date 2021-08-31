package mc.methods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Teams {

	String playerName;
	String color;
	Player player;
	String kit;

	private static boolean StartGame = false;
	private static boolean endGame = false;
	private static int phase = 0;

	public static int timerH = 0, timerM = 0, timerM2 = 0, timerS = 0, timerS2 = 0;

	final private Location locaBlue = new Location(Bukkit.getWorld("world"), 465, 71, 142);
	final private Location locaRed = new Location(Bukkit.getWorld("world"), 137, 71, 142);
	final private Location locaYellow = new Location(Bukkit.getWorld("world"), 137, 71, 470);
	final private Location locaGreen = new Location(Bukkit.getWorld("world"), 465, 71, 470);

	private static int nexusLifeBlue = 75;
	private static int nexusLifeRed = 75;
	private static int nexusLifeYellow = 75;
	private static int nexusLifeGreen = 75;

	private static List<String> allTeams = new ArrayList<String>();
	private static List<String> losePlayers = new ArrayList<String>();
	private static List<String> blueListTeam = new ArrayList<String>();
	private static List<String> redListTeam = new ArrayList<String>();
	private static List<String> yellowListTeam = new ArrayList<String>();
	private static List<String> greenListTeam = new ArrayList<String>();

	private static Map<String, String> Kits = new HashMap<String, String>();

	// For mc.events.TeamEvents in aSyncPlayerChatEvent.
	private static List<Player> playerBlueListTeam = new ArrayList<Player>();
	private static List<Player> playerRedListTeam = new ArrayList<Player>();
	private static List<Player> playerYellowListTeam = new ArrayList<Player>();
	private static List<Player> playerGreenListTeam = new ArrayList<Player>();

	/*
	 * Used to add a player to a specific team.
	 */

	public void addPlayerTeam(String playerName, String color) {
		this.playerName = playerName;
		this.color = color;
		String convertName = playerName.toLowerCase();
		player = Bukkit.getPlayer(convertName);

		allTeams.add(convertName);

		if (color.equalsIgnoreCase("blue") || color.equalsIgnoreCase("azul")) {
			blueListTeam.add(convertName);
			allTeams.add(convertName);
			playerBlueListTeam.add(player);
		}
		if (color.equalsIgnoreCase("red") || color.equalsIgnoreCase("rojo")) {
			redListTeam.add(convertName);
			allTeams.add(convertName);
			playerRedListTeam.add(player);
		}
		if (color.equalsIgnoreCase("yellow") || color.equalsIgnoreCase("amarillo")) {
			yellowListTeam.add(convertName);
			allTeams.add(convertName);
			playerYellowListTeam.add(player);
		}
		if (color.equalsIgnoreCase("green") || color.equalsIgnoreCase("verde")) {
			greenListTeam.add(convertName);
			allTeams.add(convertName);
			playerGreenListTeam.add(player);
		}
	}

	/*
	 * Sets the player kit
	 */

	public void setKit(String playerName, String kit) {
		this.playerName = playerName;
		this.kit = kit;
		String convertName = playerName.toLowerCase();

		Kits.put(convertName, kit);
	}
	
	public void removeKit(String playerName) {
		this.playerName = playerName;
		String convertName = playerName.toLowerCase();

		Kits.remove(convertName);
	}

	/*-
	 * Returns the player kit name in lower case. Returns null if he doesn't have one.
	 */

	public String getKit(String playerName) {
		this.playerName = playerName;
		String convertName = playerName.toLowerCase();

		if (Kits.get(convertName) == null) {
			return "null";
		}

		return Kits.get(convertName);
	}

	/*
	 * Used to add a player to a list of losers when a nexus goes to zero.
	 */

	public void addLosePlayer(String playerName) {
		this.playerName = playerName;
		String convertName = playerName.toLowerCase();

		allTeams.remove(convertName);
		blueListTeam.remove(convertName);
		redListTeam.remove(convertName);
		yellowListTeam.remove(convertName);
		redListTeam.remove(convertName);

		losePlayers.add(convertName);

	}
	
	/*
	 * Used to check if a player in the list of losers.
	 */

	public boolean getLosePlayer(String playerName) {
		this.playerName = playerName;
		String convertName = playerName.toLowerCase();
		
		if(losePlayers.contains(convertName)) {
			return true;
		} else {
			return false;
		}

	}

	/*
	 * Checks if the player is in a team and returns his color in form of a String.
	 */

	public String checkPlayer(String playerName) {
		this.playerName = playerName;
		String convertName = playerName.toLowerCase();

		if (blueListTeam.contains(convertName)) {
			return "blue";
		} else if (redListTeam.contains(convertName)) {
			return "red";
		} else if (yellowListTeam.contains(convertName)) {
			return "yellow";
		} else if (greenListTeam.contains(convertName)) {
			return "green";
		} else {
			return "false";
		}
	}

	/*
	 * Removes the player from whatever team he is in.
	 */

	public String removePlayer(String playerName) {
		this.playerName = playerName;
		String convertName = playerName.toLowerCase();

		player = Bukkit.getPlayer(convertName);

		allTeams.remove(convertName);
		if (blueListTeam.contains(convertName)) {
			blueListTeam.remove(convertName);
			playerBlueListTeam.remove(player);
			allTeams.remove(convertName);
			return "blue";
		}
		if (redListTeam.contains(convertName)) {
			redListTeam.remove(convertName);
			playerRedListTeam.remove(player);
			allTeams.remove(convertName);
			return "red";
		}
		if (yellowListTeam.contains(convertName)) {
			yellowListTeam.remove(convertName);
			playerYellowListTeam.remove(player);
			allTeams.remove(convertName);
			return "yellow";
		}
		if (greenListTeam.contains(convertName)) {
			greenListTeam.remove(convertName);
			playerGreenListTeam.remove(player);
			allTeams.remove(convertName);
			return "green";
		} else {
			return "null";
		}

	}
	/*-
	 * Set the nexus location with the command /setNexusLocation --- Get the command
	 * in mc.command.DenCommands 
	 * --- IT DOESN'T WORK, ¡¡¡DONT USE ULTIL FIXED!!!
	 */

	@SuppressWarnings("static-access")
	public String setNexusLocation(Location loca, String color) {

		if (color.equalsIgnoreCase("blue") || color.equalsIgnoreCase("azul")) {
			return locaBlue.toString();
		}
		if (color.equalsIgnoreCase("red") || color.equalsIgnoreCase("rojo")) {
			return locaRed.toString();
		}
		if (color.equalsIgnoreCase("yellow") || color.equalsIgnoreCase("amarillo")) {
			return locaYellow.toString();
		}
		if (color.equalsIgnoreCase("green") || color.equalsIgnoreCase("verde")) {
			return locaGreen.toString();
		}
		return "null";
	}

	/*
	 * Changes the nexus life.
	 */

	public boolean setNexusLife(String color, int life) {

		if (color.equalsIgnoreCase("blue") || color.equalsIgnoreCase("azul")) {
			Teams.setNexusLifeBlue(life);
			return true;
		}
		if (color.equalsIgnoreCase("red") || color.equalsIgnoreCase("rojo")) {
			Teams.setNexusLifeRed(life);
			return true;
		}
		if (color.equalsIgnoreCase("yellow") || color.equalsIgnoreCase("amarillo")) {
			Teams.setNexusLifeYellow(life);
			return true;
		}
		if (color.equalsIgnoreCase("green") || color.equalsIgnoreCase("verde")) {
			Teams.setNexusLifeGreen(life);
			return true;
		}
		return false;
	}

	// GETTERS AND SETTERS

	public static List<Player> getPlayerBlueListTeam() {
		return playerBlueListTeam;
	}

	public static List<Player> getPlayerRedListTeam() {
		return playerRedListTeam;
	}

	public static List<Player> getPlayerYellowListTeam() {
		return playerYellowListTeam;
	}

	public static List<Player> getPlayerGreenListTeam() {
		return playerGreenListTeam;
	}

	// --------------------------------------------------
	public static List<String> getBlueListTeam() {
		return blueListTeam;
	}

	public static List<String> getRedListTeam() {
		return redListTeam;
	}

	public static List<String> getYellowListTeam() {
		return yellowListTeam;
	}

	public static List<String> getGreenListTeam() {
		return greenListTeam;
	}

	public static List<String> getAllTeams() {
		return allTeams;
	}

	public static List<String> getDeathPlayers() {
		return losePlayers;
	}

	// --------------------------------------------------

	public Location getLocaBlue() {
		return locaBlue;
	}

	public Location getLocaRed() {
		return locaRed;
	}

	public Location getLocaYellow() {
		return locaYellow;
	}

	public Location getLocaGreen() {
		return locaGreen;
	}

	// --------------------------------------------------

	public static int getNexusLifeBlue() {
		return nexusLifeBlue;
	}

	public static void setNexusLifeBlue(int nexusLifeBlue) {
		Teams.nexusLifeBlue = nexusLifeBlue;
	}

	public static int getNexusLifeRed() {
		return nexusLifeRed;
	}

	public static void setNexusLifeRed(int nexusLifeRed) {
		Teams.nexusLifeRed = nexusLifeRed;
	}

	public static int getNexusLifeYellow() {
		return nexusLifeYellow;
	}

	public static void setNexusLifeYellow(int nexusLifeYellow) {
		Teams.nexusLifeYellow = nexusLifeYellow;
	}

	public static int getNexusLifeGreen() {
		return nexusLifeGreen;
	}

	public static void setNexusLifeGreen(int nexusLifeGreen) {
		Teams.nexusLifeGreen = nexusLifeGreen;
	}

	// --------------------------------------------------

	public static boolean isStartGame() {
		return StartGame;
	}

	public static void setStartGame(boolean startGame) {
		StartGame = startGame;
	}

	public int getPhase() {
		return phase;
	}

	public void setPhase(int phase) {
		Teams.phase = phase;
	}
	
	public static boolean isEndGame() {
		return endGame;
	}

	public static void setEndGame(boolean endGame) {
		Teams.endGame = endGame;
	}

	public static List<String> getLosePlayers() {
		return losePlayers;
	}
}
