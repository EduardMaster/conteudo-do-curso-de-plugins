package net.eduard.curso.projeto.essentials;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


/**
 * Comando de teleportar todo mundo até você
 * @author Eduard
 *
 */

public class ComandoTeleportAll implements CommandExecutor
{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label,
			String[] args) {
		if (sender instanceof Player ) {
			Player player = (Player) sender;
			if (player.hasPermission("tp.all")) {
				for (Player alvoLoop : Bukkit.getOnlinePlayers()) {
					alvoLoop.teleport(player);
				}
				Bukkit.broadcastMessage("§aO Master "+player.getName()+ " puxou os jogadores!");
			}
			
		}
		return true;
	}

}
