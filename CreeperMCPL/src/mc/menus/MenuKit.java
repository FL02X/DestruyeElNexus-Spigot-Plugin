package mc.menus;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import mc.main.Main;
import mc.methods.Teams;
import net.md_5.bungee.api.ChatColor;

public class MenuKit implements CommandExecutor {

	@SuppressWarnings("unused")
	private Main plugin;
	Teams teams = new Teams();

	/*-
	 * Sets the inventory interface for the command /Kit. 
	 * The event that handles his functionality is in mc.menus.MenuKitEvent
	 */

	public MenuKit(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("kit".toLowerCase()).setExecutor(this);
	}

	public Inventory getKitInventory() {
		Inventory invKit = Bukkit.createInventory(null, 54, ChatColor.GRAY + "Elige un Kit");

		ItemStack civilItem = new ItemStack(Material.WORKBENCH);
		ItemStack minerItem = new ItemStack(Material.STONE_PICKAXE);
		ItemStack woodcuterItem = new ItemStack(Material.GOLD_AXE);
		ItemStack warriorItem = new ItemStack(Material.STONE_SWORD);
		ItemStack archerItem = new ItemStack(Material.BOW);

		// __________________________________________________________________

		ItemMeta civilItemMeta = civilItem.getItemMeta();
		ItemMeta minerItemMeta = minerItem.getItemMeta();
		ItemMeta woodcuterItemMeta = woodcuterItem.getItemMeta();
		ItemMeta warriorItemMeta = warriorItem.getItemMeta();
		ItemMeta archerItemMeta = archerItem.getItemMeta();

		// __________________________________________________________________

		civilItemMeta.setDisplayName(ChatColor.GREEN + "Civil");
		ArrayList<String> loreCivilItem = new ArrayList<String>();
		loreCivilItem.add(ChatColor.GRAY + "Espada de madera");
		loreCivilItem.add(ChatColor.GRAY + "Pico de madera");
		loreCivilItem.add(ChatColor.DARK_GRAY + "■ Eficiencia 1");
		loreCivilItem.add(ChatColor.GRAY + "Hacha de madera");
		loreCivilItem.add(ChatColor.DARK_GRAY + "■ Eficiencia 2");
		loreCivilItem.add(ChatColor.GRAY + "Mesa de trabajo");
		loreCivilItem.add(ChatColor.GRAY + "Pan " + ChatColor.DARK_GRAY + "x16");
		civilItemMeta.setLore(loreCivilItem);
		civilItem.setItemMeta(civilItemMeta);

		minerItemMeta.setDisplayName(ChatColor.GREEN + "Minero");
		ArrayList<String> loreMinerItem = new ArrayList<String>();
		loreMinerItem.add(ChatColor.GRAY + "Espada de madera");
		loreMinerItem.add(ChatColor.DARK_GREEN + "Pico de piedra");
		loreMinerItem.add(ChatColor.DARK_GRAY + "■ Eficiencia 1");
		loreMinerItem.add(ChatColor.GRAY + "Hacha de madera");
		minerItemMeta.setLore(loreMinerItem);
		minerItem.setItemMeta(minerItemMeta);

		woodcuterItemMeta.setDisplayName(ChatColor.GREEN + "Leñador");
		ArrayList<String> loreWoodcuterItem = new ArrayList<String>();
		loreWoodcuterItem.add(ChatColor.GRAY + "Espada de madera");
		loreWoodcuterItem.add(ChatColor.GRAY + "Pico de madera");
		loreWoodcuterItem.add(ChatColor.DARK_GREEN + "Hacha de oro");
		loreWoodcuterItem.add(ChatColor.DARK_GRAY + "■ Eficiencia 3");
		loreWoodcuterItem.add(ChatColor.DARK_GRAY + "■ Irrompibilidad 4");
		woodcuterItemMeta.setLore(loreWoodcuterItem);
		woodcuterItem.setItemMeta(woodcuterItemMeta);

		warriorItemMeta.setDisplayName(ChatColor.GREEN + "Guerrero");
		ArrayList<String> loreWarriorItem = new ArrayList<String>();
		loreWarriorItem.add(ChatColor.DARK_GREEN + "Espada de piedra");
		loreWarriorItem.add(ChatColor.GRAY + "Pico de madera");
		loreWarriorItem.add(ChatColor.GRAY + "Hacha de madera");
		warriorItemMeta.setLore(loreWarriorItem);
		warriorItem.setItemMeta(warriorItemMeta);

		archerItemMeta.setDisplayName(ChatColor.GREEN + "Arquero");
		ArrayList<String> lorearcherItem = new ArrayList<String>();
		lorearcherItem.add(ChatColor.GRAY + "Espada de madera");
		lorearcherItem.add(ChatColor.GRAY + "Pico de madera");
		lorearcherItem.add(ChatColor.GRAY + "Hacha de madera");
		lorearcherItem.add(ChatColor.DARK_GREEN + "Arco");
		lorearcherItem.add(ChatColor.DARK_GREEN + "Flechas " + ChatColor.DARK_GRAY + "x32");
		archerItemMeta.setLore(lorearcherItem);
		archerItem.setItemMeta(archerItemMeta);

		// __________________________________________________________________

		invKit.setItem(11, civilItem);
		invKit.setItem(12, minerItem);
		invKit.setItem(14, woodcuterItem);
		invKit.setItem(13, warriorItem);
		invKit.setItem(15, archerItem);

		// _____________________________________________________
		
		return invKit;

	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player player = (Player) sender;
		MenuKit kit = new MenuKit(plugin);

		if (label.equalsIgnoreCase("kit")) {
			if (args.length == 0) {
				player.openInventory(kit.getKitInventory());
			} else {

				if (args[0].equalsIgnoreCase("civil")) {
					teams.setKit(player.getName().toLowerCase(), "Civil");
					player.sendMessage(ChatColor.YELLOW + "Tendras este kit despues de morir.");
					player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1, 1);
					return true;
				}

				else if (args[0].equalsIgnoreCase("minero")) {
					teams.setKit(player.getName().toLowerCase(), "Minero");
					player.sendMessage(ChatColor.YELLOW + "Tendras este kit despues de morir.");
					player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1, 1);
					return true;
				}

				else if (args[0].equalsIgnoreCase("leñador")) {
					teams.setKit(player.getName().toLowerCase(), "Leñador");
					player.sendMessage(ChatColor.YELLOW + "Tendras este kit despues de morir.");
					player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1, 1);
					return true;
				}
				
				else if (args[0].equalsIgnoreCase("guerrero")) {
					teams.setKit(player.getName().toLowerCase(), "Guerrero");
					player.sendMessage(ChatColor.YELLOW + "Tendras este kit despues de morir.");
					player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1, 1);
					return true;
				}
				
				else if (args[0].equalsIgnoreCase("arquero")) {
					teams.setKit(player.getName().toLowerCase(), "Arquero");
					player.sendMessage(ChatColor.YELLOW + "Tendras este kit despues de morir.");
					player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1, 1);
					return true;
				}
			}
		}
		return false;
	}

}
