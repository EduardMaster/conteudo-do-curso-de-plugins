package net.eduard.curso.projeto.essentials;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.eduard.curso.Curso;

public class ComandoSetSpawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {

		if (sender instanceof Player) {
			Player player = (Player) sender;

			Curso.getConfigs().set("spawn", player.getLocation());
			Curso.getConfigs().saveConfig();
			player.sendMessage(ChatColor.GREEN + "O spawn foi setado");

		}
		return false;
	}

}
