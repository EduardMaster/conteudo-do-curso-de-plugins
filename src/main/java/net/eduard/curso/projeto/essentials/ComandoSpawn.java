package net.eduard.curso.projeto.essentials;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.eduard.curso.Main;

public class ComandoSpawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (Main.getConfigs().contains("spawn")) {
				player.teleport(Main.getConfigs().getLocation("spawn"));
				player.sendMessage("§aVoce foi teleportado para o Spawn.");

			} else {
				player.sendMessage("§cO spawn nao foi setado.");
			}

		}
		return false;
	}

}
