package net.eduard.curso.projeto.essentials;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.eduard.curso.Curso;

public class ComandoSpawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (Curso.getConfigs().contains("spawn")) {
				player.teleport(Curso.getConfigs().getLocation("spawn"));
				player.sendMessage("§aVoce foi teleportado para o Spawn.");

			} else {
				player.sendMessage("§cO spawn nao foi setado.");
			}

		}
		return false;
	}

}
