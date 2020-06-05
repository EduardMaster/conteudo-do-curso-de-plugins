package net.eduard.curso.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Comando de limpar o chat de todos os jogadores
 * @author Eduard
 *
 */
public class ComandoChatLimpo implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (command.getName().equalsIgnoreCase("clearchat")) {
			for (int i = 0; i < 30; i++) {
				Bukkit.broadcastMessage("");
			}
			Bukkit.broadcastMessage("§a                   Chat Limpo");
		}
		return false;
	}

	
}
