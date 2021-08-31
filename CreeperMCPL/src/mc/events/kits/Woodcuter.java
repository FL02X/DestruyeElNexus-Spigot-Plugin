package mc.events.kits;


import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import mc.main.Main;
import mc.methods.Teams;
import net.md_5.bungee.api.ChatColor;

public class Woodcuter implements Listener {

	@SuppressWarnings("unused")
	Main plugin;
	Teams teams = new Teams();

	public Woodcuter(Main plugin) {
		this.plugin = plugin;
	}
	
	/*
	 * Called after a player dies.
	 * Checks the player kit with the method in mc.methods.Teams and
	 * respawn him with his respective items.
	 */

	@EventHandler
	public void playerRespawnEvent(PlayerRespawnEvent e) {
		Player player = e.getPlayer();

		/*
		 * CIVIL KIT - BLUE TEAM.
		 */

		ItemStack helmetBlue = new ItemStack(Material.LEATHER_HELMET);
		LeatherArmorMeta helmetMetaBlue = (LeatherArmorMeta) helmetBlue.getItemMeta();
		helmetMetaBlue.setColor(Color.BLUE);
		helmetMetaBlue.setDisplayName(ChatColor.DARK_BLUE + "[] " + ChatColor.WHITE + "Armadura de Inicio");
		helmetBlue.setItemMeta(helmetMetaBlue);
		
		ItemStack chestplateBlue = new ItemStack(Material.LEATHER_CHESTPLATE);
		LeatherArmorMeta chestplateMetaBlue = (LeatherArmorMeta) chestplateBlue.getItemMeta();
		chestplateMetaBlue.setColor(Color.BLUE);
		chestplateMetaBlue.setDisplayName(ChatColor.DARK_BLUE + "[] " + ChatColor.WHITE + "Armadura de Inicio");
		chestplateBlue.setItemMeta(chestplateMetaBlue);

		ItemStack leggingsBlue = new ItemStack(Material.LEATHER_LEGGINGS);
		LeatherArmorMeta leggingsMetaBlue = (LeatherArmorMeta) leggingsBlue.getItemMeta();
		leggingsMetaBlue.setColor(Color.BLUE);
		leggingsMetaBlue.setDisplayName(ChatColor.DARK_BLUE + "[] " + ChatColor.WHITE + "Armadura de Inicio");
		leggingsBlue.setItemMeta(leggingsMetaBlue);

		ItemStack bootsBlue = new ItemStack(Material.LEATHER_BOOTS);
		LeatherArmorMeta bootsMetaBlue = (LeatherArmorMeta) bootsBlue.getItemMeta();
		bootsMetaBlue.setColor(Color.BLUE);
		bootsMetaBlue.setDisplayName(ChatColor.DARK_BLUE + "[] " + ChatColor.WHITE + "Armadura de Inicio");
		bootsBlue.setItemMeta(bootsMetaBlue);
		
		//Weapons.
		
		ItemStack woodSwordBlue = new ItemStack(Material.WOOD_SWORD);
		ItemMeta woodSwordBlueMeta = woodSwordBlue.getItemMeta();
		woodSwordBlueMeta.setDisplayName(ChatColor.DARK_BLUE + "[] " + ChatColor.WHITE + "Espada de madera");
		woodSwordBlue.setItemMeta(woodSwordBlueMeta);
		
		ItemStack woodPickaxeBlue = new ItemStack(Material.WOOD_PICKAXE);
		ItemMeta woodPickaxeBlueMeta = woodPickaxeBlue.getItemMeta();
		woodPickaxeBlueMeta.setDisplayName(ChatColor.DARK_BLUE + "[] " + ChatColor.WHITE + "Pico de madera");
		woodPickaxeBlue.setItemMeta(woodPickaxeBlueMeta);
		
		ItemStack woodAxeBlue = new ItemStack(Material.GOLD_AXE);
		ItemMeta woodAxeBlueMeta = woodAxeBlue.getItemMeta();
		woodAxeBlueMeta.setDisplayName(ChatColor.DARK_BLUE + "[] " + ChatColor.WHITE + "Hacha de oro");
		woodAxeBlueMeta.addEnchant(Enchantment.DURABILITY, 2, true);
		woodAxeBlue.setItemMeta(woodAxeBlueMeta);
		

		/*
		 * CIVIL KIT - RED TEAM.
		 */

		ItemStack helmetRed = new ItemStack(Material.LEATHER_HELMET);
		LeatherArmorMeta helmetMetaRed = (LeatherArmorMeta) helmetRed.getItemMeta();
		helmetMetaRed.setColor(Color.RED);
		helmetMetaRed.setDisplayName(ChatColor.RED+ "[] " + ChatColor.WHITE + "Armadura de Inicio");
		helmetRed.setItemMeta(helmetMetaRed);

		ItemStack chestplateRed = new ItemStack(Material.LEATHER_CHESTPLATE);
		LeatherArmorMeta chestplateMetaRed = (LeatherArmorMeta) chestplateRed.getItemMeta();
		chestplateMetaRed.setColor(Color.RED);
		chestplateMetaRed.setDisplayName(ChatColor.RED + "[] " + ChatColor.WHITE + "Armadura de Inicio");
		chestplateRed.setItemMeta(chestplateMetaRed);

		ItemStack leggingsRed = new ItemStack(Material.LEATHER_LEGGINGS);
		LeatherArmorMeta leggingsMetaRed = (LeatherArmorMeta) leggingsRed.getItemMeta();		
		leggingsMetaRed.setColor(Color.RED);
		leggingsMetaRed.setDisplayName(ChatColor.RED + "[] " + ChatColor.WHITE + "Armadura de Inicio");
		leggingsRed.setItemMeta(leggingsMetaRed);

		ItemStack bootsRed = new ItemStack(Material.LEATHER_BOOTS);
		LeatherArmorMeta bootsMetaRed = (LeatherArmorMeta) bootsRed.getItemMeta();
		bootsMetaRed.setColor(Color.RED);
		bootsMetaRed.setDisplayName(ChatColor.RED + "[] " + ChatColor.WHITE + "Armadura de Inicio");
		bootsRed.setItemMeta(bootsMetaRed);
		
		// Weapons.
		
		ItemStack woodSwordRed = new ItemStack(Material.WOOD_SWORD);
		ItemMeta woodSwordRedMeta = woodSwordRed.getItemMeta();
		woodSwordRedMeta.setDisplayName(ChatColor.RED + "[] " + ChatColor.WHITE + "Espada de madera");
		woodSwordRed.setItemMeta(woodSwordRedMeta);
		
		ItemStack woodPickaxeRed = new ItemStack(Material.WOOD_PICKAXE);
		ItemMeta woodPickaxeRedMeta = woodPickaxeRed.getItemMeta();
		woodPickaxeRedMeta.setDisplayName(ChatColor.RED + "[] " + ChatColor.WHITE + "Pico de madera");
		woodPickaxeRed.setItemMeta(woodPickaxeRedMeta);
		
		ItemStack woodAxeRed = new ItemStack(Material.GOLD_AXE);
		ItemMeta woodAxeRedMeta = woodAxeRed.getItemMeta();
		woodAxeRedMeta.setDisplayName(ChatColor.RED + "[] " + ChatColor.WHITE + "Hacha de oro");
		woodAxeRedMeta.addEnchant(Enchantment.DURABILITY, 2, true);
		woodAxeRed.setItemMeta(woodAxeRedMeta);

		/*
		 * CIVIL KIT - YELLOW TEAM.
		 */

		ItemStack helmetYellow = new ItemStack(Material.LEATHER_HELMET);
		LeatherArmorMeta helmetMetaYellow = (LeatherArmorMeta) helmetYellow.getItemMeta();
		helmetMetaYellow.setColor(Color.YELLOW);
		helmetMetaYellow.setDisplayName(ChatColor.YELLOW + "[] " + ChatColor.WHITE + "Armadura de Inicio");
		helmetYellow.setItemMeta(helmetMetaYellow);

		ItemStack chestplateYellow = new ItemStack(Material.LEATHER_CHESTPLATE);
		LeatherArmorMeta chestplateMetaYellow = (LeatherArmorMeta) chestplateYellow.getItemMeta();
		chestplateMetaYellow.setColor(Color.YELLOW);
		chestplateMetaYellow.setDisplayName(ChatColor.YELLOW + "[] " + ChatColor.WHITE + "Armadura de Inicio");
		chestplateYellow.setItemMeta(chestplateMetaYellow);

		ItemStack leggingsYellow = new ItemStack(Material.LEATHER_LEGGINGS);
		LeatherArmorMeta leggingsMetaYellow = (LeatherArmorMeta) leggingsYellow.getItemMeta();
		leggingsMetaYellow.setColor(Color.YELLOW);
		leggingsMetaYellow.setDisplayName(ChatColor.YELLOW + "[] " + ChatColor.WHITE + "Armadura de Inicio");
		leggingsYellow.setItemMeta(leggingsMetaYellow);

		ItemStack bootsYellow = new ItemStack(Material.LEATHER_BOOTS);
		LeatherArmorMeta bootsMetaYellow = (LeatherArmorMeta) bootsYellow.getItemMeta();
		bootsMetaYellow.setColor(Color.YELLOW);
		bootsMetaYellow.setDisplayName(ChatColor.YELLOW + "[] " + ChatColor.WHITE + "Armadura de Inicio");
		bootsYellow.setItemMeta(bootsMetaYellow);

		//Weapons.
		
		ItemStack woodSwordYellow = new ItemStack(Material.WOOD_SWORD);
		ItemMeta woodSwordYellowMeta = woodSwordYellow.getItemMeta();
		woodSwordYellowMeta.setDisplayName(ChatColor.YELLOW + "[] " + ChatColor.WHITE + "Espada de madera");
		woodSwordYellow.setItemMeta(woodSwordYellowMeta);
		
		ItemStack woodPickaxeYellow = new ItemStack(Material.WOOD_PICKAXE);
		ItemMeta woodPickaxeYellowMeta = woodPickaxeYellow.getItemMeta();
		woodPickaxeYellowMeta.setDisplayName(ChatColor.YELLOW + "[] " + ChatColor.WHITE + "Pico de madera");
		woodPickaxeYellow.setItemMeta(woodPickaxeYellowMeta);
		
		ItemStack woodAxeYellow = new ItemStack(Material.GOLD_AXE);
		ItemMeta woodAxeYellowMeta = woodAxeYellow.getItemMeta();
		woodAxeYellowMeta.setDisplayName(ChatColor.YELLOW + "[] " + ChatColor.WHITE + "Hacha de oro");
		woodAxeYellowMeta.addEnchant(Enchantment.DURABILITY, 2, true);
		woodAxeYellow.setItemMeta(woodAxeYellowMeta);
		
		/*
		 * CIVIL KIT - GREEN TEAM.
		 */

		ItemStack helmetGreen = new ItemStack(Material.LEATHER_HELMET);
		LeatherArmorMeta helmetMetaGreen = (LeatherArmorMeta) helmetGreen.getItemMeta();
		helmetMetaGreen.setColor(Color.GREEN);
		helmetMetaGreen.setDisplayName(ChatColor.GREEN + "[] " + ChatColor.WHITE + "Armadura de Inicio");
		helmetGreen.setItemMeta(helmetMetaGreen);

		ItemStack chestplateGreen = new ItemStack(Material.LEATHER_CHESTPLATE);
		LeatherArmorMeta chestplateMetaGreen = (LeatherArmorMeta) chestplateGreen.getItemMeta();
		chestplateMetaGreen.setColor(Color.GREEN);
		chestplateMetaGreen.setDisplayName(ChatColor.GREEN + "[] " + ChatColor.WHITE + "Armadura de Inicio");
		chestplateGreen.setItemMeta(chestplateMetaGreen);

		ItemStack leggingsGreen = new ItemStack(Material.LEATHER_LEGGINGS);
		LeatherArmorMeta leggingsMetaGreen = (LeatherArmorMeta) leggingsGreen.getItemMeta();
		leggingsMetaGreen.setColor(Color.GREEN);
		leggingsMetaGreen.setDisplayName(ChatColor.DARK_BLUE + "[] " + ChatColor.WHITE + "Armadura de Inicio");
		leggingsGreen.setItemMeta(leggingsMetaGreen);

		ItemStack bootsGreen = new ItemStack(Material.LEATHER_BOOTS);
		LeatherArmorMeta bootsMetaGreen = (LeatherArmorMeta) bootsGreen.getItemMeta();
		bootsMetaGreen.setColor(Color.GREEN);
		bootsMetaGreen.setDisplayName(ChatColor.GREEN + "[] " + ChatColor.WHITE + "Armadura de Inicio");
		bootsGreen.setItemMeta(bootsMetaGreen);
		
		//Weapons.
		
		ItemStack woodSwordGreen = new ItemStack(Material.WOOD_SWORD);
		ItemMeta woodSwordGreenMeta = woodSwordGreen.getItemMeta();
		woodSwordGreenMeta.setDisplayName(ChatColor.GREEN + "[] " + ChatColor.WHITE + "Espada de madera");
		woodSwordGreen.setItemMeta(woodSwordGreenMeta);
		
		ItemStack woodPickaxeGreen = new ItemStack(Material.WOOD_PICKAXE);
		ItemMeta woodPickaxeGreenMeta = woodPickaxeGreen.getItemMeta();
		woodPickaxeGreenMeta.setDisplayName(ChatColor.GREEN + "[] " + ChatColor.WHITE + "Pico de madera");
		woodPickaxeGreen.setItemMeta(woodPickaxeGreenMeta);
		
		ItemStack woodAxeGreen = new ItemStack(Material.GOLD_AXE);
		ItemMeta woodAxeGreenMeta = woodAxeGreen.getItemMeta();
		woodAxeGreenMeta.setDisplayName(ChatColor.GREEN + "[] " + ChatColor.WHITE + "Hacha de oro");
		woodAxeGreenMeta.addEnchant(Enchantment.DURABILITY, 2, true);
		woodAxeGreen.setItemMeta(woodAxeGreenMeta);
		
		

		if (teams.getKit(player.getName().toLowerCase()).equalsIgnoreCase("leñador")) {
			switch (teams.checkPlayer(player.getName().toLowerCase())) {
			case "blue":		
				player.getInventory().setHelmet(helmetBlue);
				player.getInventory().setChestplate(chestplateBlue);
				player.getInventory().setLeggings(leggingsBlue);
				player.getInventory().setBoots(bootsBlue);

				player.getInventory().addItem(woodSwordBlue);
				player.getInventory().addItem(woodPickaxeBlue);
				player.getInventory().addItem(woodAxeBlue);
				break;
			case "red":
				player.getInventory().setHelmet(helmetRed);
				player.getInventory().setChestplate(chestplateRed);
				player.getInventory().setLeggings(leggingsRed);
				player.getInventory().setBoots(bootsRed);

				player.getInventory().addItem(woodSwordRed);
				player.getInventory().addItem(woodPickaxeRed);
				player.getInventory().addItem(woodAxeRed);
				break;
			case "yellow":
				player.getInventory().setHelmet(helmetYellow);
				player.getInventory().setChestplate(chestplateYellow);
				player.getInventory().setLeggings(leggingsYellow);
				player.getInventory().setBoots(bootsYellow);

				player.getInventory().addItem(woodSwordYellow);
				player.getInventory().addItem(woodPickaxeYellow);
				player.getInventory().addItem(woodAxeYellow);
				break;
			case "green":
				player.getInventory().setHelmet(helmetGreen);
				player.getInventory().setChestplate(chestplateGreen);
				player.getInventory().setLeggings(leggingsGreen);
				player.getInventory().setBoots(bootsGreen);

				player.getInventory().addItem(woodSwordGreen);
				player.getInventory().addItem(woodPickaxeGreen);
				player.getInventory().addItem(woodAxeGreen);
				break;
			}
		}

	}
}
