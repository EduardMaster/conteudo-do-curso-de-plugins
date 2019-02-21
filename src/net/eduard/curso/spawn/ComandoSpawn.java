package net.eduard.curso.spawn;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.eduard.curso.CursoEduard;

public class ComandoSpawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (CursoEduard.getConfigs().contains("spawn")) {
				p.teleport(CursoEduard.getConfigs().getLocation("spawn"));

				p.sendMessage("§aVoce foi teleportado para o Spawn.");

			} else {
				p.sendMessage("§cO spawn nao foi setado.");
			}

		}
		return false;
	}

}
