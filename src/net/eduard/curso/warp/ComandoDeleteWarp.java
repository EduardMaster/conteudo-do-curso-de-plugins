package net.eduard.curso.warp;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ComandoDeleteWarp implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (args.length == 0) {

			sender.sendMessage("§c/deletewarp <nome>");
			//

		} else {

			String nome = args[0];
			if (WarpAPI.hasWarp(nome)) {

				WarpAPI.removeWarp(nome);
				sender.sendMessage("§aA warp " + nome + " foi deletada!");
			} else {
				sender.sendMessage("§cEste warp nao foi setado!");
			}
		}

		return true;
	}

}
