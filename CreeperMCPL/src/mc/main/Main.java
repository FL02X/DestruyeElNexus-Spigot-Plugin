package mc.main;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.plugin.java.JavaPlugin;

import mc.command.DenCommands;
import mc.events.BlockBreak;
import mc.events.Chat;
import mc.events.ItemDrop;
import mc.events.Lobby;
import mc.events.NetherPortal;
import mc.events.PlayerDeath;
import mc.events.PlayerInteract;
import mc.events.PrivateBaseBlocksEvent;
import mc.events.RespawnEvent;
import mc.events.SpawnProtectedZone;
import mc.events.TeamDamage;
import mc.events.kits.Archer;
import mc.events.kits.Civil;
import mc.events.kits.Miner;
import mc.events.kits.Warrior;
import mc.events.kits.Woodcuter;
import mc.menus.MenuKit;
import mc.menus.MenuKitEvent;
import mc.menus.MenuPotions;
import mc.menus.MenuPotionsEvent;
import mc.menus.MenuTeams;
import mc.menus.MenuTeamsEvent;

/*
 * @author Fl02x
 */


public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		
		//Creates the lobby map. Used in mc.events.Lobby
		World lobby = Bukkit.getServer().createWorld(new WorldCreator("lobby"));
		lobby.setAutoSave(false);
		lobby.setWeatherDuration(0);
		World coastal = Bukkit.getWorld("world");
		coastal.setWeatherDuration(0);
		
		//mc.command
		new DenCommands(this);
		//mc.events
		Bukkit.getPluginManager().registerEvents(new BlockBreak(this), this);
		Bukkit.getPluginManager().registerEvents(new Chat(this), this);
		Bukkit.getPluginManager().registerEvents(new PrivateBaseBlocksEvent(this), this);
		Bukkit.getPluginManager().registerEvents(new NetherPortal(this), this);
		Bukkit.getPluginManager().registerEvents(new ItemDrop(this), this);
		Bukkit.getPluginManager().registerEvents(new Lobby(this), this);
		Bukkit.getPluginManager().registerEvents(new PlayerDeath(this), this);
		Bukkit.getPluginManager().registerEvents(new PlayerInteract(this), this);
		Bukkit.getPluginManager().registerEvents(new RespawnEvent(this), this);
		Bukkit.getPluginManager().registerEvents(new SpawnProtectedZone(this), this);
		Bukkit.getPluginManager().registerEvents(new TeamDamage(this), this);
		//mc.menus
		Bukkit.getPluginManager().registerEvents(new MenuPotionsEvent(this), this);
		Bukkit.getPluginManager().registerEvents(new MenuTeamsEvent(this), this);
		Bukkit.getPluginManager().registerEvents(new MenuKitEvent(this), this);
		new MenuKit(this);
		new MenuPotions(this);
		new MenuTeams(this);
		//nc.events.kits
		Bukkit.getPluginManager().registerEvents(new Civil(this), this);
		Bukkit.getPluginManager().registerEvents(new Miner(this), this);
		Bukkit.getPluginManager().registerEvents(new Woodcuter(this), this);
		Bukkit.getPluginManager().registerEvents(new Warrior(this), this);
		Bukkit.getPluginManager().registerEvents(new Archer(this), this);



	}

	public void onDisable() {

	}

}
