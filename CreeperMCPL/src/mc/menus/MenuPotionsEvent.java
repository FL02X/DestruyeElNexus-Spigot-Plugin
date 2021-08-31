package mc.menus;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import mc.main.Main;
import mc.methods.Teams;
import net.md_5.bungee.api.ChatColor;

public class MenuPotionsEvent implements Listener {

	Plugin plugin;
	Teams teams = new Teams();

	public MenuPotionsEvent(Main plugin) {
		this.plugin = plugin;
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void inventoryClickEvent(InventoryClickEvent e) {
		Player player = (Player) e.getWhoClicked();
		ItemStack Gold = new ItemStack(Material.GOLD_INGOT);
		ItemStack Emerald = new ItemStack(Material.EMERALD);
		ItemStack BlazeGoldBuy = new ItemStack(Material.GOLD_INGOT, 16);
		ItemStack GlassBottleBuy = new ItemStack(Material.GOLD_INGOT, 3);
		ItemStack NetherWartsBuy = new ItemStack(Material.GOLD_INGOT, 5);
		ItemStack SugarBuy = new ItemStack(Material.GOLD_INGOT, 3);
		ItemStack RedstoneBuy = new ItemStack(Material.GOLD_INGOT, 3);
		ItemStack GlowstoneDustBuy = new ItemStack(Material.GOLD_INGOT, 5);
		ItemStack SulphurBuy = new ItemStack(Material.GOLD_INGOT, 5);
		ItemStack RabbitFootBuy = new ItemStack(Material.GOLD_INGOT, 2);
		ItemStack FermentedSpiderEyeBuy = new ItemStack(Material.GOLD_INGOT, 5);
		ItemStack GhastTearBuy = new ItemStack(Material.GOLD_INGOT, 2);
		ItemStack MagmaCreamBuy = new ItemStack(Material.GOLD_INGOT, 2);
		ItemStack GoldenCarrotBuy = new ItemStack(Material.GOLD_INGOT, 5);
		ItemStack SpiderEyeBuy = new ItemStack(Material.GOLD_INGOT, 2);
		ItemStack BrewingStandBuy = new ItemStack(Material.EMERALD, 10);

		if (e.getInventory().getName().equalsIgnoreCase(ChatColor.RED + "Potions")) {
			
			switch (e.getCurrentItem().getType()) {
			case BLAZE_ROD:
				if (player.getInventory().containsAtLeast(Gold, 16)) {
					player.getInventory().removeItem(BlazeGoldBuy);
					player.getInventory().addItem(new ItemStack(Material.BLAZE_ROD));
					player.sendMessage(ChatColor.BLUE + "¡Compra finalizada!");
					player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1, 1);
					e.setCancelled(true);
				} else {
					player.sendMessage(ChatColor.RED + "¡No tienes suficiente oro!");
					player.playSound(player.getLocation(), Sound.EAT, 1, 1);
					player.closeInventory();
					e.setCancelled(true);
				}
				break;
			case GLASS_BOTTLE:
				if (player.getInventory().containsAtLeast(Gold, 3)) {
					player.getInventory().removeItem(GlassBottleBuy);
					player.getInventory().addItem(new ItemStack(Material.GLASS_BOTTLE));
					player.sendMessage(ChatColor.BLUE + "¡Compra finalizada!");
					player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1, 1);
					e.setCancelled(true);
				} else {
					player.sendMessage(ChatColor.RED + "¡No tienes suficiente oro!");
					player.playSound(player.getLocation(), Sound.EAT, 1, 1);
					player.closeInventory();
					e.setCancelled(true);
				}
				break;
			case SUGAR:
				if (player.getInventory().containsAtLeast(Gold, 3)) {
					player.getInventory().removeItem(SugarBuy);
					player.getInventory().addItem(new ItemStack(Material.SUGAR));
					player.sendMessage(ChatColor.BLUE + "¡Compra finalizada!");
					player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1, 1);
					e.setCancelled(true);
				} else {
					player.sendMessage(ChatColor.RED + "¡No tienes suficiente oro!");
					player.playSound(player.getLocation(), Sound.EAT, 1, 1);
					player.closeInventory();
					e.setCancelled(true);
				}
				break;
			case REDSTONE:
				if (player.getInventory().containsAtLeast(Gold, 3)) {
					player.getInventory().removeItem(RedstoneBuy);
					player.getInventory().addItem(new ItemStack(Material.REDSTONE));
					player.sendMessage(ChatColor.BLUE + "¡Compra finalizada!");
					player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1, 1);
					e.setCancelled(true);
				} else {
					player.sendMessage(ChatColor.RED + "¡No tienes suficiente oro!");
					player.playSound(player.getLocation(), Sound.EAT, 1, 1);
					player.closeInventory();
					e.setCancelled(true);
				}
				break;
			case GLOWSTONE_DUST:
				if (player.getInventory().containsAtLeast(Gold, 5)) {
					player.getInventory().removeItem(GlowstoneDustBuy);
					player.getInventory().addItem(new ItemStack(Material.GLOWSTONE_DUST));
					player.sendMessage(ChatColor.BLUE + "¡Compra finalizada!");
					player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1, 1);
					e.setCancelled(true);
				} else {
					player.sendMessage(ChatColor.RED + "¡No tienes suficiente oro!");
					player.playSound(player.getLocation(), Sound.EAT, 1, 1);
					player.closeInventory();
					e.setCancelled(true);
				}
				break;
			case SULPHUR:
				if (player.getInventory().containsAtLeast(Gold, 5)) {
					player.getInventory().removeItem(SulphurBuy);
					player.getInventory().addItem(new ItemStack(Material.SULPHUR));
					player.sendMessage(ChatColor.BLUE + "¡Compra finalizada!");
					player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1, 1);
					e.setCancelled(true);
				} else {
					player.sendMessage(ChatColor.RED + "¡No tienes suficiente oro!");
					player.playSound(player.getLocation(), Sound.EAT, 1, 1);
					player.closeInventory();
					e.setCancelled(true);
				}
				break;
			case RABBIT_FOOT:
				if (player.getInventory().containsAtLeast(Gold, 2)) {
					player.getInventory().removeItem(RabbitFootBuy);
					player.getInventory().addItem(new ItemStack(Material.RABBIT_FOOT));
					player.sendMessage(ChatColor.BLUE + "¡Compra finalizada!");
					player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1, 1);
					e.setCancelled(true);
				} else {
					player.sendMessage(ChatColor.RED + "¡No tienes suficiente oro!");
					player.playSound(player.getLocation(), Sound.EAT, 1, 1);
					player.closeInventory();
					e.setCancelled(true);
				}
				break;
			case FERMENTED_SPIDER_EYE:
				if (player.getInventory().containsAtLeast(Gold, 5)) {
					player.getInventory().removeItem(FermentedSpiderEyeBuy);
					player.getInventory().addItem(new ItemStack(Material.FERMENTED_SPIDER_EYE));
					player.sendMessage(ChatColor.BLUE + "¡Compra finalizada!");
					player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1, 1);
					e.setCancelled(true);
				} else {
					player.sendMessage(ChatColor.RED + "¡No tienes suficiente oro!");
					player.playSound(player.getLocation(), Sound.EAT, 1, 1);
					player.closeInventory();
					e.setCancelled(true);
				}
				break;
			case GHAST_TEAR:
				if (player.getInventory().containsAtLeast(Gold, 2)) {
					player.getInventory().removeItem(GhastTearBuy);
					player.getInventory().addItem(new ItemStack(Material.GHAST_TEAR));
					player.sendMessage(ChatColor.BLUE + "¡Compra finalizada!");
					player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1, 1);
					e.setCancelled(true);
				} else {
					player.sendMessage(ChatColor.RED + "¡No tienes suficiente oro!");
					player.playSound(player.getLocation(), Sound.EAT, 1, 1);
					player.closeInventory();
					e.setCancelled(true);
				}
				break;
			case MAGMA_CREAM:
				if (player.getInventory().containsAtLeast(Gold, 2)) {
					player.getInventory().removeItem(MagmaCreamBuy);
					player.getInventory().addItem(new ItemStack(Material.MAGMA_CREAM));
					player.sendMessage(ChatColor.BLUE + "¡Compra finalizada!");
					player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1, 1);
					e.setCancelled(true);
				} else {
					player.sendMessage(ChatColor.RED + "¡No tienes suficiente oro!");
					player.playSound(player.getLocation(), Sound.EAT, 1, 1);
					player.closeInventory();
					e.setCancelled(true);
				}
				break;
			case GOLDEN_CARROT:
				if (player.getInventory().containsAtLeast(Gold, 5)) {
					player.getInventory().removeItem(GoldenCarrotBuy);
					player.getInventory().addItem(new ItemStack(Material.GOLDEN_CARROT));
					player.sendMessage(ChatColor.BLUE + "¡Compra finalizada!");
					player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1, 1);
					e.setCancelled(true);
				} else {
					player.sendMessage(ChatColor.RED + "¡No tienes suficiente oro!");
					player.playSound(player.getLocation(), Sound.EAT, 1, 1);
					player.closeInventory();
					e.setCancelled(true);
				}
				break;
			case SPIDER_EYE:
				if (player.getInventory().containsAtLeast(Gold, 2)) {
					player.getInventory().removeItem(SpiderEyeBuy);
					player.getInventory().addItem(new ItemStack(Material.SPIDER_EYE));
					player.sendMessage(ChatColor.BLUE + "¡Compra finalizada!");
					player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1, 1);
					e.setCancelled(true);
				} else {
					player.sendMessage(ChatColor.RED + "¡No tienes suficiente oro!");
					player.playSound(player.getLocation(), Sound.EAT, 1, 1);
					player.closeInventory();
					e.setCancelled(true);
				}
				break;
			case BREWING_STAND_ITEM:
				if (player.getInventory().containsAtLeast(Emerald, 10)) {
					player.getInventory().removeItem(BrewingStandBuy);
					player.getInventory().addItem(new ItemStack(Material.BREWING_STAND_ITEM));
					player.sendMessage(ChatColor.BLUE + "¡Compra finalizada!");
					player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1, 1);
					e.setCancelled(true);
				} else {
					player.sendMessage(ChatColor.RED + "¡No tienes suficientes esmeraldas!");
					player.playSound(player.getLocation(), Sound.EAT, 1, 1);
					player.closeInventory();
					e.setCancelled(true);
				}
				break;
			default:
				e.setCancelled(true);
				break;
			} 
		} 

		switch (e.getCurrentItem().getTypeId()) {
		case 372:
			if (player.getInventory().containsAtLeast(Gold, 5)) {
				player.getInventory().removeItem(NetherWartsBuy);
				player.getInventory().addItem(new ItemStack(372));
				player.sendMessage(ChatColor.BLUE + "¡Compra finalizada!");
				player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1, 1);
				e.setCancelled(true);
			} else {
				player.sendMessage(ChatColor.RED + "¡No tienes suficiente oro!");
				player.playSound(player.getLocation(), Sound.EAT, 1, 1);
				player.closeInventory();
				e.setCancelled(true);
			}
			break;
		}

	}

}
