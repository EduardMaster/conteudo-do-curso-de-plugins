package net.eduard.curso.projeto.warp;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoSetWarp implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (args.length == 0) {
				p.sendMessage("/setwrap <warp>");

			} else {
				String nome = args[0];
				WarpAPI.setWarp(nome, p.getLocation());
				p.sendMessage("§aSua Warp Foi Setada");

			}
		}
		return true;
	}

}
