package mc.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;

import mc.main.Main;
import mc.methods.Teams;
import net.md_5.bungee.api.ChatColor;

public class Chat implements Listener {

	private Plugin plugin;
	Teams teams = new Teams();

	public Chat(Main main) {
		this.plugin = plugin;
	}
	
	/*
	 * Chat system event.
	 * 
	 *  ---------- NEEDS A GLOBAL COMMAND. ---------------
	 */

	@EventHandler
	public void aSyncPlayerChatEvent(AsyncPlayerChatEvent e) {
		Player player = e.getPlayer();

		switch (teams.checkPlayer(e.getPlayer().getName().toLowerCase())) {
		case "blue":
			teams.addPlayerTeam(e.getPlayer().getName(), "blue");
			e.getRecipients().clear();
			e.getRecipients().addAll(Teams.getPlayerBlueListTeam());
			e.setFormat(ChatColor.DARK_BLUE + "[E] " + ChatColor.GRAY + player.getDisplayName() + ":" + " "
					+ e.getMessage());
			break;
		case "red":
			teams.addPlayerTeam(e.getPlayer().getName(), "red");
			e.getRecipients().clear();
			e.getRecipients().addAll(Teams.getPlayerRedListTeam());
			e.setFormat(ChatColor.RED + "[E] " + ChatColor.GRAY + player.getDisplayName() + ":" + " " + e.getMessage());
			break;
		case "yellow":
			teams.addPlayerTeam(e.getPlayer().getName(), "yellow");
			e.getRecipients().clear();
			e.getRecipients().addAll(Teams.getPlayerYellowListTeam());
			e.setFormat(
					ChatColor.YELLOW + "[E] " + ChatColor.GRAY + player.getDisplayName() + ":" + " " + e.getMessage());
			
			break;
		case "green":
			teams.addPlayerTeam(e.getPlayer().getName(), "green");
			e.getRecipients().clear();
			e.getRecipients().addAll(Teams.getPlayerGreenListTeam());
			e.setFormat(ChatColor.DARK_GREEN + "[E] " + ChatColor.GRAY + player.getDisplayName() + ":" + " "
					+ e.getMessage());
			break;
		default:
			e.setFormat(ChatColor.GOLD + "[GLOBAL] " + ChatColor.GRAY + player.getDisplayName() + ":" + " "
					+ e.getMessage());
			break;
		}
	}
}
