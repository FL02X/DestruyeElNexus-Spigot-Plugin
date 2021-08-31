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

import mc.main.Main;
import net.md_5.bungee.api.ChatColor;

public class MenuPotions{

	@SuppressWarnings("unused")
	private Main plugin;

	public MenuPotions(Main plugin) {
		this.plugin = plugin;
	}
	
	public Inventory getInventoryPotions() {
		Inventory invPotion = Bukkit.createInventory(null, 54, ChatColor.RED + "Potions");

		ItemStack BlazeRod = new ItemStack(Material.BLAZE_ROD);
		ItemStack GlassBottle = new ItemStack(Material.GLASS_BOTTLE);
		ItemStack NetherWarts = new ItemStack(372);
		ItemStack Sugar = new ItemStack(Material.SUGAR);
		ItemStack Redstone = new ItemStack(Material.REDSTONE);
		ItemStack GlowstoneDust = new ItemStack(Material.GLOWSTONE_DUST);
		ItemStack Sulphur = new ItemStack(Material.SULPHUR);
		ItemStack RabbitFoot = new ItemStack(Material.RABBIT_FOOT);
		ItemStack FermentedSpiderEye = new ItemStack(Material.FERMENTED_SPIDER_EYE);
		ItemStack GhastTear = new ItemStack(Material.GHAST_TEAR);
		ItemStack MagmaCream = new ItemStack(Material.MAGMA_CREAM);
		ItemStack GoldenCarrot = new ItemStack(Material.GOLDEN_CARROT);
		ItemStack SpiderEye = new ItemStack(Material.SPIDER_EYE);
		ItemStack BrewingStand = new ItemStack(Material.BREWING_STAND_ITEM);

		ItemMeta BlazeRodMeta = BlazeRod.getItemMeta();
		ItemMeta GlassBottleMeta = GlassBottle.getItemMeta();
		ItemMeta NetherWartsMeta = NetherWarts.getItemMeta();
		ItemMeta SugarMeta = Sugar.getItemMeta();
		ItemMeta RedstoneMeta = Redstone.getItemMeta();
		ItemMeta GlowstoneDustMeta = GlowstoneDust.getItemMeta();
		ItemMeta SulphurMeta = Sulphur.getItemMeta();
		ItemMeta RabbitFootMeta = RabbitFoot.getItemMeta();
		ItemMeta FermentedSpiderEyeMeta = FermentedSpiderEye.getItemMeta();
		ItemMeta GhastTearMeta = GhastTear.getItemMeta();
		ItemMeta MagmaCreamMeta = MagmaCream.getItemMeta();
		ItemMeta GoldenCarrotMeta = GoldenCarrot.getItemMeta();
		ItemMeta SpiderEyeMeta = SpiderEye.getItemMeta();
		ItemMeta BrewingStandMeta = BrewingStand.getItemMeta();

		ArrayList<String> loreBlazeRod = new ArrayList<String>();
		loreBlazeRod.add(ChatColor.GRAY + "Precio: " + ChatColor.GOLD + "16 de Oro");
		loreBlazeRod.add("");
		loreBlazeRod.add(ChatColor.YELLOW + "Click para comprar.");
		BlazeRodMeta.setLore(loreBlazeRod);
		BlazeRod.setItemMeta(BlazeRodMeta);

		ArrayList<String> loreGlassBottle = new ArrayList<String>();
		loreGlassBottle.add(ChatColor.GRAY + "Precio: " + ChatColor.GOLD + "3 de Oro");
		loreGlassBottle.add("");
		loreGlassBottle.add(ChatColor.YELLOW + "Click para comprar.");
		GlassBottleMeta.setLore(loreGlassBottle);
		GlassBottle.setItemMeta(GlassBottleMeta);

		ArrayList<String> loreNetherWarts = new ArrayList<String>();
		loreNetherWarts.add(ChatColor.GRAY + "Precio: " + ChatColor.GOLD + "5 de Oro");
		loreNetherWarts.add("");
		loreNetherWarts.add(ChatColor.YELLOW + "Click para comprar.");
		NetherWartsMeta.setLore(loreNetherWarts);
		NetherWarts.setItemMeta(NetherWartsMeta);

		ArrayList<String> loreSugar = new ArrayList<String>();
		loreSugar.add(ChatColor.GRAY + "Precio: " + ChatColor.GOLD + "3 de Oro");
		loreSugar.add("");
		loreSugar.add(ChatColor.YELLOW + "Click para comprar.");
		SugarMeta.setLore(loreSugar);
		Sugar.setItemMeta(SugarMeta);

		ArrayList<String> loreRedstone = new ArrayList<String>();
		loreRedstone.add(ChatColor.GRAY + "Precio: " + ChatColor.GOLD + "3 de Oro");
		loreRedstone.add("");
		loreRedstone.add(ChatColor.YELLOW + "Click para comprar.");
		RedstoneMeta.setLore(loreRedstone);
		Redstone.setItemMeta(RedstoneMeta);

		ArrayList<String> loreGlowstoneDust = new ArrayList<String>();
		loreGlowstoneDust.add(ChatColor.GRAY + "Precio: " + ChatColor.GOLD + "5 de Oro");
		loreGlowstoneDust.add("");
		loreGlowstoneDust.add(ChatColor.YELLOW + "Click para comprar.");
		GlowstoneDustMeta.setLore(loreGlowstoneDust);
		GlowstoneDust.setItemMeta(GlowstoneDustMeta);

		ArrayList<String> loreSulphur = new ArrayList<String>();
		loreSulphur.add(ChatColor.GRAY + "Precio: " + ChatColor.GOLD + "5 de Oro");
		loreSulphur.add("");
		loreSulphur.add(ChatColor.YELLOW + "Click para comprar.");
		SulphurMeta.setLore(loreSulphur);
		Sulphur.setItemMeta(SulphurMeta);

		ArrayList<String> loreRabbitFoot = new ArrayList<String>();
		loreRabbitFoot.add(ChatColor.GRAY + "Precio: " + ChatColor.GOLD + "2 de Oro");
		loreRabbitFoot.add("");
		loreRabbitFoot.add(ChatColor.YELLOW + "Click para comprar.");
		RabbitFootMeta.setLore(loreRabbitFoot);
		RabbitFoot.setItemMeta(RabbitFootMeta);

		ArrayList<String> loreFermentedSpiderEye = new ArrayList<String>();
		loreFermentedSpiderEye.add(ChatColor.GRAY + "Precio: " + ChatColor.GOLD + "5 de Oro");
		loreFermentedSpiderEye.add("");
		loreFermentedSpiderEye.add(ChatColor.YELLOW + "Click para comprar.");
		FermentedSpiderEyeMeta.setLore(loreFermentedSpiderEye);
		FermentedSpiderEye.setItemMeta(FermentedSpiderEyeMeta);

		ArrayList<String> loreGhastTear = new ArrayList<String>();
		loreGhastTear.add(ChatColor.GRAY + "Precio: " + ChatColor.GOLD + "2 de Oro");
		loreGhastTear.add("");
		loreGhastTear.add(ChatColor.YELLOW + "Click para comprar.");
		GhastTearMeta.setLore(loreGhastTear);
		GhastTear.setItemMeta(GhastTearMeta);

		ArrayList<String> loreMagmaCream = new ArrayList<String>();
		loreMagmaCream.add(ChatColor.GRAY + "Precio: " + ChatColor.GOLD + "2 de Oro");
		loreMagmaCream.add("");
		loreMagmaCream.add(ChatColor.YELLOW + "Click para comprar.");
		MagmaCreamMeta.setLore(loreMagmaCream);
		MagmaCream.setItemMeta(MagmaCreamMeta);

		ArrayList<String> loreGoldenCarrot = new ArrayList<String>();
		loreGoldenCarrot.add(ChatColor.GRAY + "Precio: " + ChatColor.GOLD + "3 de Oro");
		loreGoldenCarrot.add("");
		loreGoldenCarrot.add(ChatColor.YELLOW + "Click para comprar.");
		GoldenCarrotMeta.setLore(loreGoldenCarrot);
		GoldenCarrot.setItemMeta(GoldenCarrotMeta);

		ArrayList<String> loreSpiderEye = new ArrayList<String>();
		loreSpiderEye.add(ChatColor.GRAY + "Precio: " + ChatColor.GOLD + "3 de Oro");
		loreSpiderEye.add("");
		loreSpiderEye.add(ChatColor.YELLOW + "Click para comprar.");
		SpiderEyeMeta.setLore(loreSpiderEye);
		SpiderEye.setItemMeta(SpiderEyeMeta);

		ArrayList<String> loreBrewingStand = new ArrayList<String>();
		loreBrewingStand.add(ChatColor.GRAY + "Precio: " + ChatColor.DARK_GREEN + "10 esmeraldas");
		loreBrewingStand.add("");
		loreBrewingStand.add(ChatColor.YELLOW + "Click para comprar.");
		BrewingStandMeta.setLore(loreBrewingStand);
		BrewingStand.setItemMeta(BrewingStandMeta);

		invPotion.setItem(10, BlazeRod);
		invPotion.setItem(11, GlassBottle);
		invPotion.setItem(12, NetherWarts);
		invPotion.setItem(13, Sugar);
		invPotion.setItem(14, Redstone);
		invPotion.setItem(15, GlowstoneDust);
		invPotion.setItem(16, Sulphur);
		invPotion.setItem(19, RabbitFoot);
		invPotion.setItem(20, FermentedSpiderEye);
		invPotion.setItem(21, GhastTear);
		invPotion.setItem(22, MagmaCream);
		invPotion.setItem(23, GoldenCarrot);
		invPotion.setItem(24, SpiderEye);
		invPotion.setItem(25, BrewingStand);

		return invPotion;
	}

}
