
package net.eduard.curso.comandos;

import org.bukkit.command.Command;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.eduard.curso.Assunto;
/**
 * Comando de ativar e desativar o Fly de si mesmo
 * @author Eduard
 *
 */
@Assunto(subnivel=1)
public class ComandoFlyBasico implements CommandExecutor {

	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label,
		String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.getAllowFlight()) {
				p.setFlying(false);
				p.setAllowFlight(false);
				p.sendMessage("§6Fly desativado!");
			}else {
				p.setAllowFlight(true);
				p.sendMessage("§6Fly ativado!");
			}
			
		}
		return true;
	}

}
