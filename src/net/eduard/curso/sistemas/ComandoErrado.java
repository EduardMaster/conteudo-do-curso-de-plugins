package net.eduard.curso.sistemas;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.help.HelpTopic;

/**
 * Alterar mensagem do quando executa um comando Errado
 * @author Eduard
 *
 */
public class ComandoErrado implements Listener {
	@EventHandler
	public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
		if (!event.isCancelled()) {
			Player player = event.getPlayer();
			String cmd = event.getMessage().split(" ")[0];
			HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(cmd);
			if (topic == null) {
				player.sendMessage("§7Ops... comando errado!");
				player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 1.0F, 1.0F);
				event.setCancelled(true);
			}
		}
	}
}