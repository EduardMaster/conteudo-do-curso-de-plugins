package net.eduard.curso.projeto.login;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoLogin implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {

		if (sender instanceof Player) {
			Player p = (Player) sender;

			if (LoginAPI.isRegistred(p)) {

				// login senha

				if (args.length == 0) {
					// login
					sender.sendMessage("§c/login SENHA");

				} else {
					String digitou = args[0];
					String senha = LoginAPI.getSenha(p);
					if (digitou.equals(senha)) {

						LoginAPI.login(p);
						p.sendMessage("§aAutentica§§o feita com sucesso!");

					} else {
						p.kickPlayer(
								"§cVoce deve acertar a senha de primeira por motivos de seguran§a!");
					}

				}

			} else {
				p.sendMessage("§cVoce nao esta registrado ainda por "
						+ "favor digite /register senha confirmar");
			}

		}

		return true;
	}

}
