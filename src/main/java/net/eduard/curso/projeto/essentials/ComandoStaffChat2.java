package net.eduard.curso.projeto.essentials;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;


/**
 * Comando chat de staff adicionando o cara para lista de jogadores usando o chat staff
 * @author Eduard
 *
 */

public class ComandoStaffChat2 implements Listener,CommandExecutor{
	public static ArrayList<Player> players = new ArrayList<>();
	
	@EventHandler
	public void event(AsyncPlayerChatEvent e ) {
		Player player = e.getPlayer();
		if (players.contains(player)) {
			e.setFormat("§8[§bSTAFF§8] §r" + player.getDisplayName() + "§f:§r" + e.getMessage());
		}
	
		e.getRecipients().clear();
		e.getRecipients().addAll(players);
	}
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (players.contains(player)) {
				player.sendMessage("§aVoce saiu do chat da Staff");
			}else {
				players.add(player);
				player.sendMessage("§aVoce entrou no chat da Staff");
			}

		}
		return true;
	}
	
}
