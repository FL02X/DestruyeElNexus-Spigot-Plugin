package mc.menus;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

import mc.main.Main;
import mc.methods.Teams;
import net.md_5.bungee.api.ChatColor;

public class MenuTeams{

	@SuppressWarnings("unused")
	private Main plugin;
	
	/*
	 * Sets the menu inventory and his event is in mc.events
	 */

	public MenuTeams(Main plugin) {
		this.plugin = plugin;
	}
	
	/*
	 * Sets the inventory funtionality and returns a Inventory type.
	 */
	
	public Inventory getInventoryTeams() {
		Inventory invTeams = Bukkit.createInventory(null, 54, ChatColor.GRAY + "Elige un equipo");

		ItemStack blueWool = new ItemStack(Material.WOOL, 1, (byte) 3);
		ItemStack redWool = new ItemStack(Material.WOOL, 1, (byte) 14);
		ItemStack yellowWool = new ItemStack(Material.WOOL, 1, (byte) 4);
		ItemStack greenWool = new ItemStack(Material.WOOL, 1, (byte) 13);
		
		ItemStack random1 = new ItemStack(Material.WOOL, 1, (byte) 3);
		ItemStack random2 = new ItemStack(Material.WOOL, 1, (byte) 14);
		ItemStack random3 = new ItemStack(Material.WOOL, 1, (byte) 4);
		ItemStack random4 = new ItemStack(Material.WOOL, 1, (byte) 13);
		
		//__________________________________________________________________

		ItemMeta blueWoolMeta = blueWool.getItemMeta();
		ItemMeta redWoolMeta = redWool.getItemMeta();
		ItemMeta yellowWoolMeta = yellowWool.getItemMeta();
		ItemMeta greenWoolMeta = greenWool.getItemMeta();
		
		ItemMeta randomMeta = random1.getItemMeta();	
		
		//__________________________________________________________________
		
		blueWoolMeta.setDisplayName(ChatColor.BLUE + "Equipo Azul");
		ArrayList<String> loreBlueWool = new ArrayList<String>();
		loreBlueWool.add(ChatColor.GRAY + "Click para unirte.");
		loreBlueWool.add("");
		loreBlueWool.add(ChatColor.YELLOW + "Jugadores: " + ChatColor.WHITE + Teams.getBlueListTeam().size());
		blueWoolMeta.setLore(loreBlueWool);
		blueWool.setItemMeta(blueWoolMeta);

		redWoolMeta.setDisplayName(ChatColor.RED + "Equipo Rojo");
		ArrayList<String> loreRedWool = new ArrayList<String>();
		loreRedWool.add(ChatColor.GRAY + "Click para unirte.");
		loreRedWool.add("");
		loreRedWool.add(ChatColor.YELLOW + "Jugadores: " + ChatColor.WHITE + Teams.getRedListTeam().size());
		redWoolMeta.setLore(loreRedWool);
		redWool.setItemMeta(redWoolMeta);

		yellowWoolMeta.setDisplayName(ChatColor.YELLOW + "Equipo Amarillo");
		ArrayList<String> loreYellowWool = new ArrayList<String>();
		loreYellowWool.add(ChatColor.GRAY + "Click para unirte.");
		loreYellowWool.add("");
		loreYellowWool.add(ChatColor.YELLOW + "Jugadores: " + ChatColor.WHITE + Teams.getYellowListTeam().size());
		yellowWoolMeta.setLore(loreYellowWool);
		yellowWool.setItemMeta(yellowWoolMeta);

		greenWoolMeta.setDisplayName(ChatColor.GREEN + "Equipo Verde");
		ArrayList<String> loreGreenWool = new ArrayList<String>();
		loreGreenWool.add(ChatColor.GRAY + "Click para unirte.");
		loreGreenWool.add("");
		loreGreenWool.add(ChatColor.YELLOW + "Jugadores: " + ChatColor.WHITE + Teams.getGreenListTeam().size());
		greenWoolMeta.setLore(loreGreenWool);
		greenWool.setItemMeta(greenWoolMeta);
		
		//__________________________________________________________________
		
		randomMeta.setDisplayName(ChatColor.GOLD + "Equipo aleatorio");
		
		random1.setItemMeta(randomMeta);
		random2.setItemMeta(randomMeta);
		random3.setItemMeta(randomMeta);
		random4.setItemMeta(randomMeta);
		
		//__________________________________________________________________
		
		BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
		scheduler.scheduleSyncRepeatingTask(this.plugin, new Runnable() {
			@Override
			public void run() {			
				new BukkitRunnable() {
					@Override
					public void run() {
						invTeams.setItem(40, random1);
					}					
				}.runTaskLater(plugin, 2L);	
				
				new BukkitRunnable() {
					@Override
					public void run() {
						invTeams.setItem(40, random2);
					}					
				}.runTaskLater(plugin, 4L);	
				
				new BukkitRunnable() {
					@Override
					public void run() {
						invTeams.setItem(40, random3);
					}					
				}.runTaskLater(plugin, 6L);	
				
				new BukkitRunnable() {
					@Override
					public void run() {
						invTeams.setItem(40, random4);
					}					
				}.runTaskLater(plugin, 8L);	
				
				
			}			
		}, 0L, 9L);
		
		
		invTeams.setItem(19, blueWool);
		invTeams.setItem(21, redWool);
		invTeams.setItem(23, yellowWool);
		invTeams.setItem(25, greenWool);
		
		return invTeams;
	}
	

//	@SuppressWarnings("deprecation")
//	@Override
//	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
//		Player player = (Player) sender;
//		MenuTeams menut = new MenuTeams(plugin);
//		
//		if (label.equalsIgnoreCase("teams")) {
//				player.openInventory(menut.getInventoryTeams());
//				return true;			
//		}
//		return false;
//	}

}
