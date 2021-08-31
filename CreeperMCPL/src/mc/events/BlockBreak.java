package mc.events;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

import mc.events.custom.EndGameEvent;
import mc.main.Main;
import mc.methods.Scoreboards;
import mc.methods.Teams;
import net.md_5.bungee.api.ChatColor;

public class BlockBreak implements Listener {

	Plugin plugin;
	Teams teams;
	Scoreboards score;

	public BlockBreak(Main plugin) {
		this.plugin = plugin;
	}

	String ore;
	boolean laterBlock;
	boolean unbreakable;
	Location loca;

	ItemStack ironOre = new ItemStack(Material.IRON_ORE);
	ItemStack goldOre = new ItemStack(Material.GOLD_ORE);
	ItemStack diamondItem = new ItemStack(Material.DIAMOND);
	ItemStack lapisOre = new ItemStack(Material.LAPIS_ORE);
	ItemStack redstoneItem = new ItemStack(Material.REDSTONE, 6);
	ItemStack emeraldItem = new ItemStack(Material.EMERALD);
	ItemStack coalItem = new ItemStack(Material.COAL);
	ItemStack diamondPickaxe = new ItemStack(Material.DIAMOND_PICKAXE, 1);
	ItemStack ironPickaxe = new ItemStack(Material.IRON_PICKAXE);
	ItemStack stonePickaxe = new ItemStack(Material.STONE_PICKAXE);
	ItemStack goldPickaxe = new ItemStack(Material.GOLD_PICKAXE);

	boolean timer;
	ItemStack spruceLog = new ItemStack(Material.LOG, 1, (short) 1);

	String typeBlockAxe;
	ItemStack oakLog = new ItemStack(Material.LOG, 1);
	ItemStack melonItem = new ItemStack(Material.MELON, 4);

	boolean timer2;
	String typeBlockShovel;
	ItemStack string = new ItemStack(Material.STRING, 1);
	ItemStack feather = new ItemStack(Material.FEATHER, 1);
	ItemStack flint = new ItemStack(Material.FLINT, 1);
	ItemStack stick = new ItemStack(Material.STICK, 1);

	/*
	 * The event that handles the break and respawn of the ores in the game. And the
	 * nexus.
	 */

	@SuppressWarnings({ "incomplete-switch", "deprecation" })
	@EventHandler
	public void breakOreBlock(BlockBreakEvent e) {

		if (e.getPlayer().getGameMode() == GameMode.SURVIVAL) {
			if (e.getPlayer().getItemInHand() != null && e.getPlayer().getItemInHand().getType() != Material.AIR) {
				if (e.getBlock().getType() == Material.IRON_ORE || e.getBlock().getType() == Material.GOLD_ORE
						|| e.getBlock().getType() == Material.DIAMOND_ORE
						|| e.getBlock().getType() == Material.LAPIS_ORE
						|| e.getBlock().getType() == Material.REDSTONE_ORE
						|| e.getBlock().getType() == Material.EMERALD_ORE || e.getBlock().getType() == Material.COAL_ORE
						|| e.getBlock().getType() == Material.GLOWING_REDSTONE_ORE || e.getBlock().getTypeId() == 1
						|| e.getBlock().getTypeId() == 4 || e.getBlock().getTypeId() == 24
						|| e.getBlock().getTypeId() == 43 || e.getBlock().getTypeId() == 44
						|| e.getBlock().getTypeId() == 48 || e.getBlock().getTypeId() == 67
						|| e.getBlock().getTypeId() == 70 || e.getBlock().getTypeId() == 77
						|| e.getBlock().getTypeId() == 89 || e.getBlock().getTypeId() == 93
						|| e.getBlock().getTypeId() == 94 || e.getBlock().getTypeId() == 97
						|| e.getBlock().getTypeId() == 98 || e.getBlock().getTypeId() == 109
						|| e.getBlock().getTypeId() == 123 || e.getBlock().getTypeId() == 124
						|| e.getBlock().getTypeId() == 128 || e.getBlock().getTypeId() == 139
						|| e.getBlock().getTypeId() == 149 || e.getBlock().getTypeId() == 150
						|| e.getBlock().getTypeId() == 152 || e.getBlock().getTypeId() == 179
						|| e.getBlock().getTypeId() == 180 || e.getBlock().getTypeId() == 181
						|| e.getBlock().getTypeId() == 182 || e.getBlock().getTypeId() == 206
						|| e.getBlock().getTypeId() == 356 || e.getBlock().getTypeId() == 404
						|| e.getBlock().getTypeId() == 102 || e.getBlock().getTypeId() == 160
						|| e.getBlock().getTypeId() == 169 || e.getBlock().getTypeId() == 174
						|| e.getBlock().getTypeId() == 20 || e.getBlock().getTypeId() == 49
						|| e.getBlock().getTypeId() == 57 || e.getBlock().getTypeId() == 61
						|| e.getBlock().getTypeId() == 41 || e.getBlock().getTypeId() == 79
						|| e.getBlock().getTypeId() == 70 || e.getBlock().getTypeId() == 101
						|| e.getBlock().getTypeId() == 158 || e.getBlock().getTypeId() == 157
						|| e.getBlock().getTypeId() == 155 || e.getBlock().getTypeId() == 159
						|| e.getBlock().getTypeId() == 138 || e.getBlock().getTypeId() == 168
						|| e.getBlock().getTypeId() == 167 || e.getBlock().getTypeId() == 173
						|| e.getBlock().getTypeId() == 172 || e.getBlock().getTypeId() == 174
						|| e.getBlock().getTypeId() == 379 || e.getBlock().getTypeId() == 31) {

					if (e.getPlayer().getItemInHand().getType() == Material.DIAMOND_PICKAXE
							|| e.getPlayer().getItemInHand().getType() == Material.GOLD_PICKAXE
							|| e.getPlayer().getItemInHand().getType() == Material.IRON_PICKAXE
							|| e.getPlayer().getItemInHand().getType() == Material.WOOD_PICKAXE
							|| e.getPlayer().getItemInHand().getType() == Material.STONE_PICKAXE) {

						ore = "";
						laterBlock = false;
						unbreakable = false;

						switch (e.getBlock().getType()) {
						case IRON_ORE:
							e.getBlock().getWorld().playSound(e.getBlock().getLocation(), Sound.ORB_PICKUP, 1, 1);
							e.getPlayer().getInventory().addItem(ironOre);
							e.getPlayer().giveExp(2);
							ore = "iron";
							laterBlock = true;
							unbreakable = true;
							break;
						case GOLD_ORE:
							e.getBlock().getWorld().playSound(e.getBlock().getLocation(), Sound.ORB_PICKUP, 1, 1);
							e.getPlayer().getInventory().addItem(goldOre);
							e.getPlayer().giveExp(7);
							ore = "gold";
							laterBlock = true;
							unbreakable = true;
							break;
						case DIAMOND_ORE:
							e.getBlock().getWorld().playSound(e.getBlock().getLocation(), Sound.ORB_PICKUP, 1, 1);
							e.getPlayer().getInventory().addItem(diamondItem);
							e.getPlayer().giveExp(10);
							ore = "diamond";
							laterBlock = true;
							unbreakable = true;
							break;
						case LAPIS_ORE:
							e.getBlock().getWorld().playSound(e.getBlock().getLocation(), Sound.ORB_PICKUP, 1, 1);
							e.getPlayer().getInventory().addItem(lapisOre);
							e.getPlayer().giveExp(4);
							ore = "lapis";
							laterBlock = true;
							unbreakable = true;
							break;
						case REDSTONE_ORE:
							e.getBlock().getWorld().playSound(e.getBlock().getLocation(), Sound.ORB_PICKUP, 1, 1);
							e.getPlayer().getInventory().addItem(redstoneItem);
							e.getPlayer().giveExp(4);
							ore = "redstone";
							laterBlock = true;
							unbreakable = true;
							break;
						case GLOWING_REDSTONE_ORE:
							e.getBlock().getWorld().playSound(e.getBlock().getLocation(), Sound.ORB_PICKUP, 1, 1);
							e.getPlayer().getInventory().addItem(redstoneItem);
							e.getPlayer().giveExp(4);
							ore = "redstone";
							laterBlock = true;
							unbreakable = true;
							break;
						case EMERALD_ORE:
							e.getBlock().getWorld().playSound(e.getBlock().getLocation(), Sound.ORB_PICKUP, 1, 1);
							e.getPlayer().getInventory().addItem(emeraldItem);
							e.getPlayer().giveExp(10);
							ore = "emerald";
							laterBlock = true;
							unbreakable = true;
							break;
						case COAL_ORE:
							e.getBlock().getWorld().playSound(e.getBlock().getLocation(), Sound.ORB_PICKUP, 1, 1);
							e.getPlayer().getInventory().addItem(coalItem);
							e.getPlayer().giveExp(2);
							ore = "coal";
							laterBlock = true;
							unbreakable = true;
							break;
						}

						if (laterBlock == true) {
							new BukkitRunnable() {
								@Override
								public void run() {
									e.getBlock().setType(Material.BEDROCK);
								}
							}.runTaskLater(plugin, 0L); // 0L = Ticks. 20 Ticks son 20 segundos.
						}

						BukkitScheduler scheduler = Bukkit.getServer().getScheduler();

//						final int replacement = scheduler.scheduleSyncRepeatingTask(this.plugin, new Runnable() {
//							@Override
//							public void run() {
//								e.getBlock().setType(Material.COBBLESTONE);								
//							}
//						}, 0L, 0L);

						switch (ore) {
						case "iron":
							scheduler.scheduleSyncDelayedTask(this.plugin, new Runnable() {
								@Override
								public void run() {
									// Bukkit.getScheduler().cancelTask(replacement);
									e.getBlock().setType(Material.IRON_ORE);
									unbreakable = false;
								}
							}, 100L);
							break;
						case "gold":
							scheduler.scheduleSyncDelayedTask(this.plugin, new Runnable() {
								@Override
								public void run() {
									// Bukkit.getScheduler().cancelTask(replacement);
									e.getBlock().setType(Material.GOLD_ORE);
									unbreakable = false;
								}
							}, 100L);
							break;
						case "diamond":
							scheduler.scheduleSyncDelayedTask(this.plugin, new Runnable() {
								@Override
								public void run() {
									// Bukkit.getScheduler().cancelTask(replacement);
									e.getBlock().setType(Material.DIAMOND_ORE);
									unbreakable = false;
								}
							}, 100L);
							break;
						case "lapis":
							scheduler.scheduleSyncDelayedTask(this.plugin, new Runnable() {
								@Override
								public void run() {
									// Bukkit.getScheduler().cancelTask(replacement);
									e.getBlock().setType(Material.LAPIS_ORE);
									unbreakable = false;
								}
							}, 100L);
							break;
						case "redstone":
							scheduler.scheduleSyncDelayedTask(this.plugin, new Runnable() {
								@Override
								public void run() {
									// Bukkit.getScheduler().cancelTask(replacement);
									e.getBlock().setType(Material.REDSTONE_ORE);
									unbreakable = false;
								}
							}, 100L);
							break;
						case "emerald":
							scheduler.scheduleSyncDelayedTask(this.plugin, new Runnable() {
								@Override
								public void run() {
									// Bukkit.getScheduler().cancelTask(replacement);
									e.getBlock().setType(Material.EMERALD_ORE);
									unbreakable = false;
								}
							}, 100L);
							break;
						case "coal":
							scheduler.scheduleSyncDelayedTask(this.plugin, new Runnable() {
								@Override
								public void run() {
									// Bukkit.getScheduler().cancelTask(replacement);
									e.getBlock().setType(Material.COAL_ORE);
									unbreakable = false;
								}
							}, 100L);
							break;
						}
					} else {
						e.setCancelled(true);
					}
				}
			} else {
				e.setCancelled(true);
			}
		}
	}

	@SuppressWarnings({ "deprecation" })
	@EventHandler
	public void shearsBreakBlock(BlockBreakEvent e) {

		if (e.getPlayer().getGameMode() == GameMode.SURVIVAL) {
			if (e.getPlayer().getItemInHand() != null && e.getPlayer().getItemInHand().getType() != Material.AIR) {
				if (e.getBlock().getType() == Material.WOOL || e.getBlock().getType() == Material.LEAVES
						|| e.getBlock().getType() == Material.LEAVES_2 || e.getBlock().getTypeId() == 31) {
					if (e.getPlayer().getItemInHand().getType() == Material.SHEARS) {
					} else {
						e.setCancelled(true);
					}
				}
			}
		}
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void handBreakBlock(BlockBreakEvent e) {

		if (e.getPlayer().getGameMode() == GameMode.SURVIVAL) {
			if (e.getPlayer().getItemInHand() == null && e.getPlayer().getItemInHand().getType() == Material.AIR) {
				if (e.getBlock().getTypeId() == 6 || e.getBlock().getTypeId() == 31 || e.getBlock().getTypeId() == 37
						|| e.getBlock().getTypeId() == 38 || e.getBlock().getTypeId() == 39
						|| e.getBlock().getTypeId() == 40 || e.getBlock().getTypeId() == 50
						|| e.getBlock().getTypeId() == 76) {
				} else {
					e.setCancelled(true);
				}
			}
		}
	}

	@SuppressWarnings({ "deprecation" })
	@EventHandler
	public void axeBreakBlock(BlockBreakEvent e) {

		if (e.getPlayer().getGameMode() == GameMode.SURVIVAL) {
			if (e.getPlayer().getItemInHand() != null && e.getPlayer().getItemInHand().getType() != Material.AIR) {

				if (e.getBlock().getType() == Material.ACACIA_DOOR || e.getBlock().getType() == Material.ACACIA_FENCE
						|| e.getBlock().getType().getId() == 163 || e.getBlock().getType() == Material.ACACIA_FENCE_GATE
						|| e.getBlock().getType().getId() == 428 || e.getBlock().getType().getId() == 189
						|| e.getBlock().getType().getId() == 184 || e.getBlock().getType().getId() == 135
						|| e.getBlock().getType().getId() == 333 || e.getBlock().getType().getId() == 47
						|| e.getBlock().getType().getId() == 54 || e.getBlock().getType().getId() == 58
						|| e.getBlock().getType().getId() == 431 || e.getBlock().getType().getId() == 191
						|| e.getBlock().getType().getId() == 186 || e.getBlock().getType().getId() == 164
						|| e.getBlock().getType().getId() == 85 || e.getBlock().getType().getId() == 107
						|| e.getBlock().getType().getId() == 429 || e.getBlock().getType().getId() == 185
						|| e.getBlock().getType().getId() == 136 || e.getBlock().getType().getId() == 65
						|| e.getBlock().getType().getId() == 17 || e.getBlock().getType().getId() == 162
						|| e.getBlock().getType().getId() == 53 || e.getBlock().getType().getId() == 5
						|| e.getBlock().getType().getId() == 427 || e.getBlock().getType().getId() == 188
						|| e.getBlock().getType().getId() == 183 || e.getBlock().getType().getId() == 134
						|| e.getBlock().getType().getId() == 96 || e.getBlock().getType().getId() == 146
						|| e.getBlock().getType().getId() == 324 || e.getBlock().getType().getId() == 72
						|| e.getBlock().getType().getId() == 126 || e.getBlock().getType().getId() == 103
						|| e.getBlock().getTypeId() == 31) {

					if (e.getPlayer().getItemInHand().getType() == Material.DIAMOND_AXE
							|| e.getPlayer().getItemInHand().getType() == Material.GOLD_AXE
							|| e.getPlayer().getItemInHand().getType() == Material.IRON_AXE
							|| e.getPlayer().getItemInHand().getType() == Material.WOOD_AXE
							|| e.getPlayer().getItemInHand().getType() == Material.STONE_AXE) {

						typeBlockAxe = "";

						ItemStack item = e.getPlayer().getItemInHand();

						switch (e.getBlock().getType()) {
						case LOG:
							e.getBlock().setType(Material.AIR);
							e.getPlayer().getItemInHand()
									.setDurability((short) (e.getPlayer().getItemInHand().getDurability() + 1));
							e.getBlock().getWorld().playSound(e.getBlock().getLocation(), Sound.ORB_PICKUP, 1, 1);
							e.getPlayer().getInventory().addItem(oakLog);
							e.getPlayer().giveExp(2);
							typeBlockAxe = "log";
							break;
						case MELON_BLOCK:
							e.getBlock().setType(Material.AIR);
							e.getBlock().getWorld().playSound(e.getBlock().getLocation(), Sound.ORB_PICKUP, 1, 1);
							e.getPlayer().getInventory().addItem(melonItem);
							e.getPlayer().giveExp(1);
							typeBlockAxe = "melon";
							break;
						default:
							break;
						}

						BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
						BukkitScheduler scheduler2 = Bukkit.getServer().getScheduler();

						if (typeBlockAxe == "log") {
							scheduler.scheduleSyncDelayedTask(this.plugin, new Runnable() {
								@Override
								public void run() {
									e.getBlock().setType(Material.LOG);
								}
							}, 100L);
						} else if (typeBlockAxe == "melon") {
							scheduler2.scheduleSyncDelayedTask(this.plugin, new Runnable() {
								@Override
								public void run() {
									e.getBlock().setType(Material.MELON_BLOCK);
								}
							}, 100L);
						}
					} else {
						e.setCancelled(true);
					}
				}
			} else {
				e.setCancelled(true);
			}
		}
	}

	@SuppressWarnings({ "deprecation" })
	@EventHandler
	public void shovelBreakBlock(BlockBreakEvent e) {

		if (e.getPlayer().getGameMode() == GameMode.SURVIVAL) {
			if (e.getPlayer().getItemInHand() != null && e.getPlayer().getItemInHand().getType() != Material.AIR) {

				if (e.getBlock().getType().getId() == 13 || e.getBlock().getType().getId() == 3
						|| e.getBlock().getType().getId() == 2 || e.getBlock().getType().getId() == 110
						|| e.getBlock().getType().getId() == 184 || e.getBlock().getType().getId() == 12
						|| e.getBlock().getTypeId() == 31) {

					if (e.getPlayer().getItemInHand().getType() == Material.DIAMOND_SPADE
							|| e.getPlayer().getItemInHand().getType() == Material.GOLD_SPADE
							|| e.getPlayer().getItemInHand().getType() == Material.IRON_SPADE
							|| e.getPlayer().getItemInHand().getType() == Material.WOOD_SPADE
							|| e.getPlayer().getItemInHand().getType() == Material.STONE_SPADE) {

						typeBlockShovel = "";

						switch (e.getBlock().getType()) {
						case GRAVEL:
							e.getBlock().setTypeId(0);
							e.getBlock().getWorld().playSound(e.getBlock().getLocation(), Sound.ORB_PICKUP, 1, 1);
							e.getPlayer().getInventory().addItem(string);
							e.getPlayer().getInventory().addItem(feather);
							e.getPlayer().getInventory().addItem(flint);
							e.getPlayer().getInventory().addItem(stick);
							e.getPlayer().giveExp(3);
							typeBlockShovel = "gravel";
							break;
						default:
							break;
						}

						if (typeBlockShovel == "gravel") {
							new BukkitRunnable() {
								@Override
								public void run() {
									e.getBlock().setType(Material.GRAVEL);
								}
							}.runTaskLater(plugin, 0L);
						}

						/*
						 * BukkitScheduler scheduler = Bukkit.getServer().getScheduler(); if
						 * (typeBlockShovel == "gravel") {
						 * scheduler.scheduleSyncDelayedTask(this.plugin, new Runnable() {
						 * 
						 * @Override public void run() { e.getBlock().setType(Material.LOG); } }, 100L);
						 * }
						 */
					} else {
						e.setCancelled(true);
					}
				}
			} else {
				e.setCancelled(true);
			}
		}
	}

	@SuppressWarnings({ "incomplete-switch", "deprecation" })
	@EventHandler
	public void nexusBreak(BlockBreakEvent e) {
		score = new Scoreboards();
		teams = new Teams();
		loca = e.getPlayer().getLocation();

		if (e.getPlayer().getGameMode() == GameMode.SURVIVAL) {
			if (e.getPlayer().getItemInHand() != null && e.getPlayer().getItemInHand().getType() != Material.AIR) {
				if (e.getBlock().getTypeId() == 121) {

					if (e.getPlayer().getItemInHand().getType() == Material.DIAMOND_PICKAXE
							|| e.getPlayer().getItemInHand().getType() == Material.GOLD_PICKAXE
							|| e.getPlayer().getItemInHand().getType() == Material.IRON_PICKAXE
							|| e.getPlayer().getItemInHand().getType() == Material.WOOD_PICKAXE
							|| e.getPlayer().getItemInHand().getType() == Material.STONE_PICKAXE) {

						if (Teams.getNexusLifeBlue() > 1 && Teams.getNexusLifeRed() == 0
								&& Teams.getNexusLifeYellow() == 0 && Teams.getNexusLifeGreen() == 0) {
							Bukkit.getServer().getPluginManager().callEvent(new EndGameEvent("blue"));
						}

						if (Teams.getNexusLifeRed() > 1 && Teams.getNexusLifeBlue() == 0
								&& Teams.getNexusLifeYellow() == 0 && Teams.getNexusLifeGreen() == 0) {
							Bukkit.getServer().getPluginManager().callEvent(new EndGameEvent("red"));
						}

						if (Teams.getNexusLifeYellow() > 1 && Teams.getNexusLifeRed() == 0
								&& Teams.getNexusLifeBlue() == 0 && Teams.getNexusLifeGreen() == 0) {
							Bukkit.getServer().getPluginManager().callEvent(new EndGameEvent("yellow"));
						}

						if (Teams.getNexusLifeGreen() > 1 && Teams.getNexusLifeRed() == 0
								&& Teams.getNexusLifeYellow() == 0 && Teams.getNexusLifeBlue() == 0) {
							Bukkit.getServer().getPluginManager().callEvent(new EndGameEvent("green"));
						}

						// BLUE TEAM - Nexus block break.
						if (teams.checkPlayer(e.getPlayer().getName()) == "blue") {

							if (e.getBlock().getLocation().equals(teams.getLocaBlue())) {

								e.getPlayer().sendMessage(ChatColor.RED + "[DEN] No puedes romper tu propio nexo");
								e.getPlayer().playSound(loca, Sound.EAT, 1, 1);
								e.setCancelled(true);

							} else if (e.getBlock().getLocation().equals(teams.getLocaRed())
									&& Teams.getNexusLifeRed() > 0) {

								Teams.setNexusLifeRed(Teams.getNexusLifeRed() - 1);
								e.getPlayer().playSound(loca, Sound.IRONGOLEM_HIT, 1, 1);
								for (Player player : Teams.getPlayerRedListTeam()) {
									player.playSound(loca, Sound.ANVIL_LAND, 1, 1);
								}
								Bukkit.broadcastMessage(ChatColor.GOLD + "¡El Nexo " + ChatColor.RED + "rojo "
										+ ChatColor.GOLD + "esta siendo atacado! | Vida restante: " + ChatColor.YELLOW
										+ Teams.getNexusLifeRed());
								e.setCancelled(true);
								
								if (Teams.getNexusLifeRed() == 0) {
									Bukkit.getWorld("world").getBlockAt(teams.getLocaRed()).setType(Material.BEDROCK);
									for (Player player : Bukkit.getOnlinePlayers()) {
										player.playSound(player.getLocation(), Sound.ENDERDRAGON_GROWL, 1, 1);
									}
									Bukkit.broadcastMessage(ChatColor.DARK_RED + "¡El " + ChatColor.RED + "equipo rojo "
											+ ChatColor.DARK_RED + "ha sido eliminado!");
									for (Player player : Teams.getPlayerRedListTeam()) {
										teams.addLosePlayer(player.getName().toLowerCase());
									}
								}

							} else if (e.getBlock().getLocation().equals(teams.getLocaYellow())
									&& Teams.getNexusLifeYellow() > 0) {

								Teams.setNexusLifeYellow(Teams.getNexusLifeYellow() - 1);
								e.getPlayer().playSound(loca, Sound.IRONGOLEM_HIT, 1, 1);
								for (Player player : Teams.getPlayerYellowListTeam()) {
									player.playSound(loca, Sound.ANVIL_LAND, 1, 1);
								}
								Bukkit.broadcastMessage(ChatColor.GOLD + "¡El Nexo " + ChatColor.YELLOW + "amarillo "
										+ ChatColor.GOLD + "esta siendo atacado! | Vida restante: " + ChatColor.YELLOW
										+ Teams.getNexusLifeYellow());
								e.setCancelled(true);
								
								if (Teams.getNexusLifeYellow() == 0) {
									Bukkit.getWorld("world").getBlockAt(teams.getLocaYellow()).setType(Material.BEDROCK);
									for (Player player : Bukkit.getOnlinePlayers()) {
										player.playSound(player.getLocation(), Sound.ENDERDRAGON_GROWL, 1, 1);
									}
									Bukkit.broadcastMessage(ChatColor.DARK_RED + "¡El " + ChatColor.YELLOW + "equipo amarillo "
											+ ChatColor.DARK_RED + "ha sido eliminado!");
									for (Player player : Teams.getPlayerYellowListTeam()) {
										teams.addLosePlayer(player.getName().toLowerCase());
									}
								}

							} else if (e.getBlock().getLocation().equals(teams.getLocaGreen())
									&& Teams.getNexusLifeGreen() > 0) {

								Teams.setNexusLifeGreen(Teams.getNexusLifeGreen() - 1);
								e.getPlayer().playSound(loca, Sound.IRONGOLEM_HIT, 1, 1);
								for (Player player : Teams.getPlayerGreenListTeam()) {
									player.playSound(loca, Sound.ANVIL_LAND, 1, 1);
								}
								Bukkit.broadcastMessage(ChatColor.GOLD + "¡El Nexo " + ChatColor.GREEN + "verde "
										+ ChatColor.GOLD + "esta siendo atacado! | Vida restante: " + ChatColor.YELLOW
										+ Teams.getNexusLifeGreen());
								e.setCancelled(true);
								
								if (Teams.getNexusLifeGreen() == 0) {
									Bukkit.getWorld("world").getBlockAt(teams.getLocaGreen()).setType(Material.BEDROCK);
									for (Player player : Bukkit.getOnlinePlayers()) {
										player.playSound(player.getLocation(), Sound.ENDERDRAGON_GROWL, 1, 1);
									}
									Bukkit.broadcastMessage(ChatColor.DARK_RED + "¡El " + ChatColor.GREEN + "equipo verde "
											+ ChatColor.DARK_RED + "ha sido eliminado!");
									for (Player player : Teams.getPlayerGreenListTeam()) {
										teams.addLosePlayer(player.getName().toLowerCase());
									}
								}

							} else {
								e.getPlayer().sendMessage("u...");
								e.setCancelled(true);
							}
						}
						/*
						 * RED TEAM - Nexus block break.
						 */
						else if (teams.checkPlayer(e.getPlayer().getName()) == "red") {

							if (e.getBlock().getLocation().equals(teams.getLocaRed())) {
								e.setCancelled(true);
								e.getPlayer().sendMessage(ChatColor.RED + "[DEN] No puedes romper tu propio nexo");
							}

							if (e.getBlock().getLocation().equals(teams.getLocaBlue())
									&& Teams.getNexusLifeBlue() > 0) {

								e.getPlayer().playSound(loca, Sound.IRONGOLEM_HIT, 1, 1);
								Teams.setNexusLifeBlue(Teams.getNexusLifeBlue() - 1);
								for (Player player : Teams.getPlayerBlueListTeam()) {
									player.playSound(loca, Sound.ANVIL_LAND, 1, 1);
								}
								Bukkit.broadcastMessage(ChatColor.GOLD + "¡El Nexo " + ChatColor.DARK_BLUE + "azul "
										+ ChatColor.GOLD + "esta siendo atacado! | Vida restante: " + ChatColor.YELLOW
										+ Teams.getNexusLifeBlue());
								e.setCancelled(true);

								if (Teams.getNexusLifeBlue() == 0) {
									Bukkit.getWorld("world").getBlockAt(teams.getLocaBlue()).setType(Material.BEDROCK);
									for (Player player : Bukkit.getOnlinePlayers()) {
										player.playSound(player.getLocation(), Sound.ENDERDRAGON_GROWL, 1, 1);
									}
									Bukkit.broadcastMessage(ChatColor.DARK_RED + "¡El " + ChatColor.DARK_BLUE
											+ "equipo azul " + ChatColor.DARK_RED + "ha sido eliminado!");
									for (Player player : Teams.getPlayerBlueListTeam()) {
										teams.addLosePlayer(player.getName().toLowerCase());
									}
								}

							}
							
							if (e.getBlock().getLocation().equals(teams.getLocaYellow())
									&& Teams.getNexusLifeYellow() > 0) {

								e.getPlayer().playSound(loca, Sound.IRONGOLEM_HIT, 1, 1);
								Teams.setNexusLifeYellow(Teams.getNexusLifeYellow() - 1);
								for (Player player : Teams.getPlayerYellowListTeam()) {
									player.playSound(loca, Sound.ANVIL_LAND, 1, 1);
								}
								Bukkit.broadcastMessage(ChatColor.GOLD + "¡El Nexo " + ChatColor.YELLOW + "amarillo "
										+ ChatColor.GOLD + "esta siendo atacado! | Vida restante: " + ChatColor.YELLOW
										+ Teams.getNexusLifeYellow());
								e.setCancelled(true);
								
								if (Teams.getNexusLifeYellow() == 0) {
									Bukkit.getWorld("world").getBlockAt(teams.getLocaYellow()).setType(Material.BEDROCK);
									for (Player player : Bukkit.getOnlinePlayers()) {
										player.playSound(player.getLocation(), Sound.ENDERDRAGON_GROWL, 1, 1);
									}
									Bukkit.broadcastMessage(ChatColor.DARK_RED + "¡El " + ChatColor.YELLOW + "equipo amarillo "
											+ ChatColor.DARK_RED + "ha sido eliminado!");
									for (Player player : Teams.getPlayerYellowListTeam()) {
										teams.addLosePlayer(player.getName().toLowerCase());
									}
								}

							}
							if (e.getBlock().getLocation().equals(teams.getLocaGreen())
									&& Teams.getNexusLifeGreen() > 0) {

								e.getPlayer().playSound(loca, Sound.IRONGOLEM_HIT, 1, 1);
								Teams.setNexusLifeGreen(Teams.getNexusLifeGreen() - 1);
								for (Player player : Teams.getPlayerGreenListTeam()) {
									player.playSound(loca, Sound.ANVIL_LAND, 1, 1);
								}
								Bukkit.broadcastMessage(ChatColor.GOLD + "¡El Nexo " + ChatColor.GREEN + "verde "
										+ ChatColor.GOLD + "esta siendo atacado! | Vida restante: " + ChatColor.YELLOW
										+ Teams.getNexusLifeGreen());
								e.setCancelled(true);
								
								if (Teams.getNexusLifeGreen() == 0) {
									Bukkit.getWorld("world").getBlockAt(teams.getLocaGreen()).setType(Material.BEDROCK);
									for (Player player : Bukkit.getOnlinePlayers()) {
										player.playSound(player.getLocation(), Sound.ENDERDRAGON_GROWL, 1, 1);
									}
									Bukkit.broadcastMessage(ChatColor.DARK_RED + "¡El " + ChatColor.GREEN + "equipo verde "
											+ ChatColor.DARK_RED + "ha sido eliminado!");
									for (Player player : Teams.getPlayerGreenListTeam()) {
										teams.addLosePlayer(player.getName().toLowerCase());
									}
								}

							}
						}

						// YELLOW TEAM - Nexus block break.
						else if (teams.checkPlayer(e.getPlayer().getName()) == "yellow") {

							if (e.getBlock().getLocation().equals(teams.getLocaYellow())) {
								e.setCancelled(true);
								e.getPlayer().sendMessage(ChatColor.RED + "[DEN] No puedes romper tu propio nexo");
							}

							if (e.getBlock().getLocation().equals(teams.getLocaRed()) && Teams.getNexusLifeRed() > 0) {

								Teams.setNexusLifeRed(Teams.getNexusLifeRed() - 1);
								e.getPlayer().playSound(loca, Sound.IRONGOLEM_HIT, 1, 1);
								for (Player player : Teams.getPlayerRedListTeam()) {
									player.playSound(loca, Sound.ANVIL_LAND, 1, 1);
								}
								Bukkit.broadcastMessage(ChatColor.GOLD + "¡El Nexo " + ChatColor.RED + "rojo "
										+ ChatColor.GOLD + "esta siendo atacado! | Vida restante: " + ChatColor.YELLOW
										+ Teams.getNexusLifeRed());
								e.setCancelled(true);
								
								if (Teams.getNexusLifeRed() == 0) {
									Bukkit.getWorld("world").getBlockAt(teams.getLocaRed()).setType(Material.BEDROCK);
									for (Player player : Bukkit.getOnlinePlayers()) {
										player.playSound(player.getLocation(), Sound.ENDERDRAGON_GROWL, 1, 1);
									}
									Bukkit.broadcastMessage(ChatColor.DARK_RED + "¡El " + ChatColor.RED + "equipo rojo "
											+ ChatColor.DARK_RED + "ha sido eliminado!");
									for (Player player : Teams.getPlayerRedListTeam()) {
										teams.addLosePlayer(player.getName().toLowerCase());
									}
								}

							}
							if (e.getBlock().getLocation().equals(teams.getLocaBlue())
									&& Teams.getNexusLifeBlue() > 0) {

								Teams.setNexusLifeBlue(Teams.getNexusLifeBlue() - 1);
								e.getPlayer().playSound(loca, Sound.IRONGOLEM_HIT, 1, 1);
								for (Player player : Teams.getPlayerBlueListTeam()) {
									player.playSound(loca, Sound.ANVIL_LAND, 1, 1);
								}
								Bukkit.broadcastMessage(ChatColor.GOLD + "¡El Nexo " + ChatColor.DARK_BLUE + "azul "
										+ ChatColor.GOLD + "esta siendo atacado! | Vida restante: " + ChatColor.YELLOW
										+ Teams.getNexusLifeBlue());
								e.setCancelled(true);
								
								if (Teams.getNexusLifeBlue() == 0) {
									Bukkit.getWorld("world").getBlockAt(teams.getLocaBlue()).setType(Material.BEDROCK);
									for (Player player : Bukkit.getOnlinePlayers()) {
										player.playSound(player.getLocation(), Sound.ENDERDRAGON_GROWL, 1, 1);
									}
									Bukkit.broadcastMessage(ChatColor.DARK_RED + "¡El " + ChatColor.DARK_BLUE + "equipo azul "
											+ ChatColor.DARK_RED + "ha sido eliminado!");
									for (Player player : Teams.getPlayerBlueListTeam()) {
										teams.addLosePlayer(player.getName().toLowerCase());
									}
								}

							}
							if (e.getBlock().getLocation().equals(teams.getLocaGreen())
									&& Teams.getNexusLifeGreen() > 0) {

								Teams.setNexusLifeGreen(Teams.getNexusLifeGreen() - 1);
								e.getPlayer().playSound(loca, Sound.IRONGOLEM_HIT, 1, 1);
								for (Player player : Teams.getPlayerGreenListTeam()) {
									player.playSound(loca, Sound.ANVIL_LAND, 1, 1);
								}
								Bukkit.broadcastMessage(ChatColor.GOLD + "¡El Nexo " + ChatColor.GREEN + "verde "
										+ ChatColor.GOLD + "esta siendo atacado! | Vida restante: " + ChatColor.YELLOW
										+ Teams.getNexusLifeGreen());
								e.setCancelled(true);
								
								if (Teams.getNexusLifeGreen() == 0) {
									Bukkit.getWorld("world").getBlockAt(teams.getLocaGreen()).setType(Material.BEDROCK);
									for (Player player : Bukkit.getOnlinePlayers()) {
										player.playSound(player.getLocation(), Sound.ENDERDRAGON_GROWL, 1, 1);
									}
									Bukkit.broadcastMessage(ChatColor.DARK_RED + "¡El " + ChatColor.GREEN + "equipo verde "
											+ ChatColor.DARK_RED + "ha sido eliminado!");
									for (Player player : Teams.getPlayerGreenListTeam()) {
										teams.addLosePlayer(player.getName().toLowerCase());
									}
								}

							}
						}

						// GREEN TEAM - Nexus block break.
						else if (teams.checkPlayer(e.getPlayer().getName()) == "green") {

							if (e.getBlock().getLocation().equals(teams.getLocaGreen())) {
								e.setCancelled(true);
								e.getPlayer().sendMessage(ChatColor.RED + "[DEN] No puedes romper tu propio nexo");
							}

							if (e.getBlock().getLocation().equals(teams.getLocaRed()) && Teams.getNexusLifeRed() > 0) {

								Teams.setNexusLifeRed(Teams.getNexusLifeRed() - 1);
								e.getPlayer().playSound(loca, Sound.IRONGOLEM_HIT, 1, 1);
								for (Player player : Teams.getPlayerRedListTeam()) {
									player.playSound(loca, Sound.ANVIL_LAND, 1, 1);
								}
								Bukkit.broadcastMessage(ChatColor.GOLD + "¡El Nexo " + ChatColor.RED + "rojo "
										+ ChatColor.GOLD + "esta siendo atacado! | Vida restante: " + ChatColor.YELLOW
										+ Teams.getNexusLifeRed());
								e.setCancelled(true);
								
								if (Teams.getNexusLifeRed() == 0) {
									Bukkit.getWorld("world").getBlockAt(teams.getLocaRed()).setType(Material.BEDROCK);
									for (Player player : Bukkit.getOnlinePlayers()) {
										player.playSound(player.getLocation(), Sound.ENDERDRAGON_GROWL, 1, 1);
									}
									Bukkit.broadcastMessage(ChatColor.DARK_RED + "¡El " + ChatColor.RED + "equipo rojo "
											+ ChatColor.DARK_RED + "ha sido eliminado!");
									for (Player player : Teams.getPlayerRedListTeam()) {
										teams.addLosePlayer(player.getName().toLowerCase());
									}
								}

							}
							if (e.getBlock().getLocation().equals(teams.getLocaYellow())
									&& Teams.getNexusLifeYellow() > 0) {

								Teams.setNexusLifeYellow(Teams.getNexusLifeYellow() - 1);
								e.getPlayer().playSound(loca, Sound.IRONGOLEM_HIT, 1, 1);
								for (Player player : Teams.getPlayerYellowListTeam()) {
									player.playSound(loca, Sound.ANVIL_LAND, 1, 1);
								}
								Bukkit.broadcastMessage(ChatColor.GOLD + "¡El Nexo " + ChatColor.YELLOW + "amarillo "
										+ ChatColor.GOLD + "esta siendo atacado! | Vida restante: " + ChatColor.YELLOW
										+ Teams.getNexusLifeYellow());
								e.setCancelled(true);
								
								if (Teams.getNexusLifeYellow() == 0) {
									Bukkit.getWorld("world").getBlockAt(teams.getLocaYellow()).setType(Material.BEDROCK);
									for (Player player : Bukkit.getOnlinePlayers()) {
										player.playSound(player.getLocation(), Sound.ENDERDRAGON_GROWL, 1, 1);
									}
									Bukkit.broadcastMessage(ChatColor.DARK_RED + "¡El " + ChatColor.YELLOW + "equipo amarillo "
											+ ChatColor.DARK_RED + "ha sido eliminado!");
									for (Player player : Teams.getPlayerYellowListTeam()) {
										teams.addLosePlayer(player.getName().toLowerCase());
									}
								}

							}
							if (e.getBlock().getLocation().equals(teams.getLocaBlue())
									&& Teams.getNexusLifeBlue() > 0) {

								Teams.setNexusLifeBlue(Teams.getNexusLifeBlue() - 1);
								e.getPlayer().playSound(loca, Sound.IRONGOLEM_HIT, 1, 1);
								for (Player player : Teams.getPlayerBlueListTeam()) {
									player.playSound(loca, Sound.ANVIL_LAND, 1, 1);
								}
								Bukkit.broadcastMessage(ChatColor.GOLD + "¡El Nexo " + ChatColor.DARK_BLUE + "azul "
										+ ChatColor.GOLD + "esta siendo atacado! | Vida restante: " + ChatColor.YELLOW
										+ Teams.getNexusLifeBlue());
								e.setCancelled(true);
								
								if (Teams.getNexusLifeBlue() == 0) {
									Bukkit.getWorld("world").getBlockAt(teams.getLocaBlue()).setType(Material.BEDROCK);
									for (Player player : Bukkit.getOnlinePlayers()) {
										player.playSound(player.getLocation(), Sound.ENDERDRAGON_GROWL, 1, 1);
									}
									Bukkit.broadcastMessage(ChatColor.DARK_RED + "¡El " + ChatColor.DARK_BLUE + "equipo azul "
											+ ChatColor.DARK_RED + "ha sido eliminado!");
									for (Player player : Teams.getPlayerBlueListTeam()) {
										teams.addLosePlayer(player.getName().toLowerCase());
									}
								}

							}
						} else {
							e.getPlayer().sendMessage(ChatColor.RED + "[DEN] No tienes ningun equipo.");
							e.setCancelled(true);
						}

						// ------------------------------------------

						

					} else {
						e.getPlayer().sendMessage(ChatColor.RED + "[DEN] Necesitas usar un " + ChatColor.GOLD + "pico"
								+ ChatColor.RED + " para romper un nexus.");
						e.setCancelled(true);
					}
				}
			}
		}
	}

}
