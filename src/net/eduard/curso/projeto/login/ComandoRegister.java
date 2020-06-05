package net.eduard.curso.projeto.login;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoRegister implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		
		if (sender instanceof Player) {
			Player p = (Player) sender;

			if (!LoginAPI.isRegistred(p)) {

				if (args.length <= 2) {

					sender.sendMessage("§c/register SENHA CONFIRMAR-SENHA");

				} else {

					String senha = args[0];

					String confirmar = args[1];

					if (senha.equals(confirmar)) {
						sender.sendMessage("§aVoce registrou sua Conta!");
						LoginAPI.register(p, senha);
						sender.sendMessage(
								"§aVoce precisa Logar! digite /login senha");
						
					} else {
						sender.sendMessage("§cAs senhas nao s§o as mesmas!");
					}

				}

			} else {
				sender.sendMessage("§cVoce ja esta registrado!");
				
			}

			// register senha confirmasenha

		}

		return true;
	}

}
