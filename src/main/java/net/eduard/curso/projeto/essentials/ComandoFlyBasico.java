
package net.eduard.curso.projeto.essentials;

import org.bukkit.command.Command;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


/**
 * Comando de ativar e desativar o Fly de si mesmo
 * @author Eduard
 *
 */
public class ComandoFlyBasico implements CommandExecutor {

	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label,
		String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (player.getAllowFlight()) {
				player.setFlying(false);
				player.setAllowFlight(false);
				player.sendMessage("§6Fly desativado!");
			}else {
				player.setAllowFlight(true);
				player.sendMessage("§6Fly ativado!");
			}
			
		}
		return true;
	}

}
