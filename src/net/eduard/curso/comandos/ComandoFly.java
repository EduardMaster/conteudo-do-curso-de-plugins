package net.eduard.curso.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
/**
 * Comando de ativar e desativar o Fly de si mesmo e de outros jogadores
 * @author Eduard
 *
 */

public class ComandoFly implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage("§aApenas para players!");
		} else {

			Player p = (Player) sender;
			// /fly NOME
			if (args.length == 0) {

				if (p.getAllowFlight()) {

					p.setAllowFlight(false);
					p.sendMessage("§cVoce desativou o modo voo!");

				} else {

					p.setAllowFlight(true);

					p.sendMessage("§aVoce ativou o modo voo!");

				}

			} else {
				Player alvo = Bukkit.getPlayerExact(args[0]);
				if (alvo == null) {
					p.sendMessage("§aJogador nao encontrado!");
				} else {
					if (alvo.getAllowFlight()) {
						alvo.setAllowFlight(false);
						alvo.sendMessage("§cVoce desativou o modo voo!");
					} else {
						alvo.setAllowFlight(true);
						alvo.sendMessage("§aVoce ativou o modo voo!");
					}
				}
			}

		}

		return true;
	}

}
