package net.eduard.curso.eventos;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;


public class ChatComDelay implements Listener {

	public static int cooldownSeconds = 10;
	private static HashMap<UUID, Long> tempoArmazenado = new HashMap<>();

	@EventHandler
	private void chat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if (onCooldown(p)) {
			e.setCancelled(true);
		}
	}

	private boolean onCooldown(Player p) {
		if (tempoArmazenado.containsKey(p.getUniqueId())) {
			long before = tempoArmazenado.get(p.getUniqueId());
			long now = System.currentTimeMillis();
			int time = cooldownSeconds * 1000;
			// 10     7     15 =  -2
			long div = (-now+(before+time))/1000;
			if (now < (before + time)) {
				p.sendMessage("§cN§o pode conversar espere mais "+div+" segundos!");
				return true;
			} else {
				tempoArmazenado.remove(p.getUniqueId());
				return onCooldown(p);
			}
		} else {
			p.sendMessage("§fVoce n§o vai poder falar durante "+cooldownSeconds+" segundos!");
			setOnCooldown(p);
			return false;

		}

	}
	private void setOnCooldown(Player p) {
		tempoArmazenado.put(p.getUniqueId(), System.currentTimeMillis());
		
	}

}
