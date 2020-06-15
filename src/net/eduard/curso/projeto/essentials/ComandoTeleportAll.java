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
			Player p = (Player) sender;
			if (p.hasPermission("tp.all")) {
				for (Player d : Bukkit.getOnlinePlayers()) {
					d.teleport(p);
				}
				Bukkit.broadcastMessage("§aO Master "+p.getName()+ " puxou os jogadores!");
			}
			
		}
		return true;
	}

}
