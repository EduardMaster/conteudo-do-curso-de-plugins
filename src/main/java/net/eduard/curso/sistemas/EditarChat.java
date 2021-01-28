package net.eduard.curso.sistemas;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class EditarChat implements Listener{

	@EventHandler
	public void aoDigitarAlgo(AsyncPlayerChatEvent e) {
		Player player = e.getPlayer();
		String format = "<tag> <player> > <message>";
		format = format.replace("<message>", e.getMessage());
		format = format.replace("<player>", player.getDisplayName());
		if (player.hasPermission("tag.adm")) {
			format = format.replace("<tag>", "§cADM");
		}else if (player.hasPermission("tag.mod")) {
			format = format.replace("<tag>", "§cMOD");
		}
		e.setFormat(format);
	}
}
