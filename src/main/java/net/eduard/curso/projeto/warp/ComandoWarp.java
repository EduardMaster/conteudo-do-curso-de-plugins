package net.eduard.curso.projeto.warp;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoWarp implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {

			Player p = (Player) sender;

			if (args.length == 0) {
				p.sendMessage("§cdigite /warp <nome>");
			} else {
				String nome = args[0];
				if (!p.hasPermission("warp." + nome)) {
					p.sendMessage("§cVoce nao tem permiss§o para ir a este Warp");
					return true;
				}

				if (WarpAPI.hasWarp(nome)) {

					p.teleport(WarpAPI.getWarp(nome));
					p.sendMessage("§aVoce foi ate o warp " + nome);

				} else {
					p.sendMessage("§cEste warp nao foi setado!");
				}

			}

		}

		return true;
	}

}
