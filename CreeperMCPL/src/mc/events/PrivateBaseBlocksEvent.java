package mc.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.metadata.LazyMetadataValue;
import org.bukkit.metadata.LazyMetadataValue.CacheStrategy;

import mc.main.Main;
import mc.menus.MenuKit;
import mc.methods.Teams;

public class PrivateBaseBlocksEvent implements Listener {

	private Main plugin;
	Teams teams = new Teams();
	MenuKit kit = new MenuKit(Main.getPlugin(Main.class));
	Location blueStand1 = new Location(Bukkit.getWorld("world"), 457.0, 87.0, 158.0);
	Location blueStand2 = new Location(Bukkit.getWorld("world"), 459.500, 87, 158.500);

	public PrivateBaseBlocksEvent(Main plugin) {

		this.plugin = plugin;
	}

	/*
	 * Private Brewing Stand.
	 */

	//@formatter:off
	
	@EventHandler
	public void privateBrewingStand(PlayerInteractEvent e) {
		if(e.getClickedBlock().getLocation().equals(blueStand1)) {
			e.getClickedBlock().setMetadata(e.getPlayer().getName(), new LazyMetadataValue(plugin, CacheStrategy.CACHE_AFTER_FIRST_EVAL, null));
		} else if(e.getClickedBlock().getLocation().equals(blueStand2)){
			e.getPlayer().sendMessage("2");
		}
	}
	
	//@formatter:on

	/*
	 * Private EnderChest.
	 */

	@EventHandler
	public void inventoryOpenEvent(InventoryOpenEvent e) {
		Player p = (Player) e.getPlayer();
		Inventory ender = p.getEnderChest();

//		if(e.getInventory().getType() == InventoryType.ENDER_CHEST) {
//			ItemStack GRAY_GLASS = new ItemStack(Material.GLASS, 1, (byte) 7);
//			
//			ender.setItem(0, GRAY_GLASS);
//			ender.setItem(1, GRAY_GLASS);
//			ender.setItem(2, GRAY_GLASS);
//			ender.setItem(3, GRAY_GLASS);
//			ender.setItem(4, GRAY_GLASS);
//			ender.setItem(5, GRAY_GLASS);
//			ender.setItem(6, GRAY_GLASS);
//			ender.setItem(7, GRAY_GLASS);
//			ender.setItem(8, GRAY_GLASS);			
//			ender.setItem(9, GRAY_GLASS);
//			
//			ender.setItem(11, GRAY_GLASS);
//			
//			ender.setItem(13, GRAY_GLASS);
//			
//			ender.setItem(15, GRAY_GLASS);
//			
//			ender.setItem(17, GRAY_GLASS);
//			ender.setItem(18, GRAY_GLASS);
//			ender.setItem(19, GRAY_GLASS);
//			ender.setItem(20, GRAY_GLASS);
//			
//			p.getEnderChest().clear();
//			p.closeInventory();
//			new BukkitRunnable() {
//
//				@Override
//				public void run() {		
//					p.openInventory(ender);
//					p.sendMessage("e");
//				}
//				
//			}.runTaskLater(plugin, 0L);

	}

}
