package mc.command;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mc.events.custom.StartGameEvent;
import mc.main.Main;
import mc.methods.Teams;
import net.md_5.bungee.api.ChatColor;

public class DenCommands implements CommandExecutor {

	@SuppressWarnings("unused")
	private Main plugin;
	Teams teams = new Teams();

	public DenCommands(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("den".toLowerCase()).setExecutor(this);
	}
	
	/*
	 * This are the methods used for the command /den, which is the core to manipulate
	 * the game.
	 */

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player player = (Player) sender;

		/*-
		 * label = El comando.
		 * args = Lo que viene despues de escribir el comando ("args[0]" serie el primer input, "args[1]" el 2, etcetera).
		 */

		if (label.equalsIgnoreCase("den")) {
			switch (args.length) {
			case 0:
				player.sendMessage(ChatColor.DARK_GREEN + "[] " + ChatColor.GREEN + "Comandos disponibles: ");
				player.sendMessage(ChatColor.GREEN + "> /den addPlayerTeam <player> <team>");
				player.sendMessage(ChatColor.GREEN + "> /den removePlayer <player>");
				player.sendMessage(ChatColor.GREEN + "> /den checkPlayer <player>");
				player.sendMessage(ChatColor.GREEN + "> /den setNexusLife <team> <life>");
				player.sendMessage(ChatColor.GREEN + "> /den setNexusLocation <team>");
				player.sendMessage(ChatColor.GREEN + "> /den startGame");
				break;
			case 1:
				if (args[0].equalsIgnoreCase("help")) {
					player.sendMessage(ChatColor.DARK_GREEN + "[] " + ChatColor.GREEN + "Comandos disponibles: ");
					player.sendMessage(ChatColor.GREEN + "> /den addPlayerTeam <player> <team>");
					player.sendMessage(ChatColor.GREEN + "> /den removePlayer <player>");
					player.sendMessage(ChatColor.GREEN + "> /den checkPlayer <player>");
					player.sendMessage(ChatColor.GREEN + "> /den setNexusLife <team> <life>");
					player.sendMessage(ChatColor.GREEN + "> /den setNexusLocation <team>");
					player.sendMessage(ChatColor.GREEN + "> /den setNexusLocation <team>");
					player.sendMessage(ChatColor.GREEN + "> /den startGame");
				}
				if (args[0].equalsIgnoreCase("startGame")) {
					if (Teams.isStartGame() == false) {
						Bukkit.getServer().getPluginManager().callEvent(new StartGameEvent());
					} else {
						player.sendMessage(ChatColor.RED + "La partida ya ha iniciado.");
						player.playSound(player.getLocation(), Sound.EAT, 1, 1);
					}

				}
			case 2:
				if (args[0].equalsIgnoreCase("removePlayer")) {
					if (Bukkit.getServer().getPlayerExact(args[1].toLowerCase()).isOnline()) {
						String playerTeamRemoved = teams.removePlayer(args[1]);

						switch (playerTeamRemoved) {
						case "blue":
							player.sendMessage(ChatColor.GREEN + "[DEN] Jugador " + ChatColor.GOLD + args[1]
									+ ChatColor.GREEN + " eliminado del equipo: " + ChatColor.DARK_BLUE + "AZUL");
							break;
						case "red":
							player.sendMessage(ChatColor.GREEN + "[DEN] Jugador " + ChatColor.GOLD + args[1]
									+ ChatColor.GREEN + " eliminado del equipo: " + ChatColor.RED + "ROJO");
							break;
						case "yellow":
							player.sendMessage(ChatColor.GREEN + "[DEN] Jugador " + ChatColor.GOLD + args[1]
									+ ChatColor.GREEN + " eliminado del equipo: " + ChatColor.YELLOW + "AMARILLO");
							break;
						case "green":
							player.sendMessage(ChatColor.GREEN + "[DEN] Jugador " + ChatColor.GOLD + args[1]
									+ ChatColor.GREEN + " eliminado del equipo: " + ChatColor.GREEN + "VERDE");
							break;
						case "null":
							player.sendMessage(ChatColor.RED + "[DEN] Jugador no encontrado.");
							break;
						}
						return true;
					} else {
						player.sendMessage(ChatColor.RED + "[DEN] El jugador no esta en linea");
					}
				}

				if (args[0].equalsIgnoreCase("checkPlayer")) {

					if (teams.checkPlayer(args[1]) == "blue") {
						player.sendMessage(ChatColor.GREEN + "[DEN] !Jugador " + args[1] + " esta en el equipo "
								+ ChatColor.DARK_BLUE + "AZUL" + ChatColor.GREEN + "!");
						return true;

					} else if (teams.checkPlayer(args[1]) == "red") {
						player.sendMessage(ChatColor.GREEN + "[DEN] !Jugador " + args[1] + " esta en el equipo "
								+ ChatColor.RED + "ROJO" + ChatColor.GREEN + "!");
						return true;

					} else if (teams.checkPlayer(args[1]) == "yellow") {
						player.sendMessage(ChatColor.GREEN + "[DEN] !Jugador " + args[1] + " esta en el equipo "
								+ ChatColor.YELLOW + "AMARILLO" + ChatColor.GREEN + "!");
						return true;

					} else if (teams.checkPlayer(args[1]) == "green") {
						player.sendMessage(ChatColor.GREEN + "[DEN] !Jugador " + args[1] + " esta en el equipo "
								+ ChatColor.DARK_GREEN + "VERDE" + ChatColor.GREEN + "!");
						return true;

					} else {
						player.sendMessage(ChatColor.RED + "[Error] Este jugador no tiene equipo.");
						return false;
					}
				}

			case 3:
				if (args[0].equalsIgnoreCase("addPlayerTeam")) {
					if (Bukkit.getServer().getPlayerExact(args[1]).isOnline()) {
						if (teams.checkPlayer(args[1]) == "blue" || teams.checkPlayer(args[1]) == "red"
								|| teams.checkPlayer(args[1]) == "yellow" || teams.checkPlayer(args[1]) == "green") {
							String playerTeamRemoved = teams.removePlayer(args[1]);

							switch (playerTeamRemoved) {
							case "blue":
								player.sendMessage(ChatColor.GREEN + "[DEN] Jugador " + ChatColor.GOLD
										+ Bukkit.getPlayer(args[1]).getName().toString() + ChatColor.GREEN
										+ " eliminado del equipo: " + ChatColor.DARK_BLUE + "AZUL" + ChatColor.GREEN
										+ ".");
								break;
							case "red":
								player.sendMessage(ChatColor.GREEN + "[DEN] Jugador " + ChatColor.GOLD
										+ Bukkit.getPlayer(args[1]).getName().toString() + ChatColor.GREEN
										+ " eliminado del equipo: " + ChatColor.RED + "ROJO" + ChatColor.GREEN + ".");
								break;
							case "yellow":
								player.sendMessage(ChatColor.GREEN + "[DEN] Jugador " + ChatColor.GOLD
										+ Bukkit.getPlayer(args[1]).getName().toString() + ChatColor.GREEN
										+ " eliminado del equipo: " + ChatColor.YELLOW + "AMARILLO" + ChatColor.GREEN
										+ ".");
								break;
							case "green":
								player.sendMessage(ChatColor.GREEN + "[DEN] Jugador " + ChatColor.GOLD
										+ Bukkit.getPlayer(args[1]).getName().toString() + ChatColor.GREEN
										+ " eliminado del equipo: " + ChatColor.GREEN + "VERDE" + ChatColor.GREEN
										+ ".");
								break;
							case "null":
								player.sendMessage(ChatColor.RED + "[DEN] Jugador no encontrado.");
								break;
							}

							if (args[2].equalsIgnoreCase("blue") || args[2].equalsIgnoreCase("azul")) {

								teams.addPlayerTeam(args[1], "blue");
								player.sendMessage(ChatColor.GREEN + "[DEN] Jugador " + ChatColor.GOLD
										+ Bukkit.getPlayer(args[1]).getName().toString() + ChatColor.GREEN
										+ " agregado al equipo: " + ChatColor.DARK_BLUE + "AZUL" + ChatColor.GREEN
										+ ".");
								if (Teams.isStartGame() == true) {
									Bukkit.getPlayer(args[1]).setHealth(0);
								}
								return true;

							} else if (args[2].equalsIgnoreCase("red") || args[2].equalsIgnoreCase("rojo")) {

								teams.addPlayerTeam(args[1], "red");
								player.sendMessage(ChatColor.GREEN + "[DEN] Jugador " + ChatColor.GOLD
										+ Bukkit.getPlayer(args[1]).getName().toString() + ChatColor.GREEN
										+ " agregado al equipo: " + ChatColor.RED + "ROJO" + ChatColor.GREEN + ".");
								if (Teams.isStartGame() == true) {
									Bukkit.getPlayer(args[1]).setHealth(0);
								}
								return true;

							} else if (args[2].equalsIgnoreCase("yellow") || args[2].equalsIgnoreCase("amarillo")) {

								teams.addPlayerTeam(args[1], "yellow");
								player.sendMessage(ChatColor.GREEN + "[DEN] Jugador " + ChatColor.GOLD
										+ Bukkit.getPlayer(args[1]).getName().toString() + ChatColor.GREEN
										+ " agregado al equipo: " + ChatColor.YELLOW + "AMARILLO" + ChatColor.GREEN
										+ ".");
								if (Teams.isStartGame() == true) {
									Bukkit.getPlayer(args[1]).setHealth(0);
								}
								return true;

							} else if (args[2].equalsIgnoreCase("green") || args[2].equalsIgnoreCase("verde")) {

								teams.addPlayerTeam(args[1], "green");
								player.sendMessage(ChatColor.GREEN + "[DEN] Jugador " + ChatColor.GOLD
										+ Bukkit.getPlayer(args[1]).getName().toString() + ChatColor.GREEN
										+ " agregado al equipo: " + ChatColor.DARK_GREEN + "VERDE" + ChatColor.GREEN
										+ ".");
								if (Teams.isStartGame() == true) {
									Bukkit.getPlayer(args[1]).setHealth(0);
								}
								return true;

							} else {
								player.sendMessage(ChatColor.RED + "[Error] Introduce equipo valido.");
								return false;
							}

						} else {
							if (args[2].equalsIgnoreCase("blue") || args[2].equalsIgnoreCase("azul")) {

								teams.addPlayerTeam(args[1], "blue");
								player.sendMessage(ChatColor.GREEN + "[DEN] Jugador " + ChatColor.GOLD
										+ Bukkit.getPlayer(args[1]).getName().toString() + ChatColor.GREEN
										+ " agregado al equipo: " + ChatColor.DARK_BLUE + "AZUL" + ChatColor.GREEN
										+ ".");
								if (Teams.isStartGame() == true) {
									Bukkit.getPlayer(args[1]).setHealth(0);
								}
								return true;

							} else if (args[2].equalsIgnoreCase("red") || args[2].equalsIgnoreCase("rojo")) {

								teams.addPlayerTeam(args[1], "red");
								player.sendMessage(ChatColor.GREEN + "[DEN] Jugador " + ChatColor.GOLD
										+ Bukkit.getPlayer(args[1]).getName().toString() + ChatColor.GREEN
										+ " agregado al equipo: " + ChatColor.RED + "ROJO" + ChatColor.GREEN + ".");
								if (Teams.isStartGame() == true) {
									Bukkit.getPlayer(args[1]).setHealth(0);
								}
								return true;

							} else if (args[2].equalsIgnoreCase("yellow") || args[2].equalsIgnoreCase("amarillo")) {

								teams.addPlayerTeam(args[1], "yellow");
								player.sendMessage(ChatColor.GREEN + "[DEN] Jugador " + ChatColor.GOLD
										+ Bukkit.getPlayer(args[1]).getName().toString() + ChatColor.GREEN
										+ " agregado al equipo: " + ChatColor.YELLOW + "AMARILLO" + ChatColor.GREEN
										+ ".");
								if (Teams.isStartGame() == true) {
									Bukkit.getPlayer(args[1]).setHealth(0);
								}
								return true;

							} else if (args[2].equalsIgnoreCase("green") || args[2].equalsIgnoreCase("verde")) {

								teams.addPlayerTeam(args[1], "green");
								player.sendMessage(ChatColor.GREEN + "[DEN] Jugador " + ChatColor.GOLD
										+ Bukkit.getPlayer(args[1]).getName().toString() + ChatColor.GREEN
										+ " agregado al equipo: " + ChatColor.DARK_GREEN + "VERDE" + ChatColor.GREEN
										+ ".");
								if (Teams.isStartGame() == true) {
									Bukkit.getPlayer(args[1]).setHealth(0);
								}
								return true;

							} else {
								player.sendMessage(ChatColor.RED + "[Error] Introduce equipo valido.");
								return false;
							}
						}
					} else {
						player.sendMessage("no esta en linea");
						return false;
					}
				}

				if (args[0].equalsIgnoreCase("setNexusLife")) {
					if (args[1].equalsIgnoreCase("blue") || args[1].equalsIgnoreCase("azul")) {
						try {
							teams.setNexusLife("blue", Integer.parseInt(args[2]));
							player.sendMessage(ChatColor.GREEN + "[DEN] Vida del nexus " + ChatColor.DARK_BLUE + "Azul"
									+ ChatColor.GREEN + " modificada correctamente.");
							return true;
						} catch (Exception e) {
							e.printStackTrace();
							return false;
						}

					} else if (args[1].equalsIgnoreCase("red") || args[1].equalsIgnoreCase("rojo")) {
						try {
							teams.setNexusLife("red", Integer.parseInt(args[2]));
							player.sendMessage(ChatColor.GREEN + "[DEN] Vida del nexus " + ChatColor.RED + "Rojo"
									+ ChatColor.GREEN + " modificada correctamente.");
							return true;
						} catch (Exception e) {
							e.printStackTrace();
							return false;
						}

					} else if (args[1].equalsIgnoreCase("yellow") || args[1].equalsIgnoreCase("amarillo")) {
						try {
							teams.setNexusLife("yellow", Integer.parseInt(args[2]));
							player.sendMessage(ChatColor.GREEN + "[DEN] Vida del nexus " + ChatColor.YELLOW + "Amarillo"
									+ ChatColor.GREEN + " modificada correctamente.");
							return true;
						} catch (Exception e) {
							e.printStackTrace();
							return false;
						}

					} else if (args[1].equalsIgnoreCase("green") || args[1].equalsIgnoreCase("verde")) {
						try {
							teams.setNexusLife("green", Integer.parseInt(args[2]));
							player.sendMessage(ChatColor.GREEN + "[DEN] Vida del nexus " + ChatColor.DARK_GREEN
									+ "Verde" + ChatColor.GREEN + " modificada correctamente.");
							return true;
						} catch (Exception e) {
							e.printStackTrace();
							return false;
						}

					} else {
						player.sendMessage(ChatColor.RED + "[Error] Este color de nexo no existe.");
						return false;
					}
				}

			}

		}
		return false;
	}

}
