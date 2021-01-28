package net.eduard.curso.projeto.essentials;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.eduard.curso.Main;

public class ComandoSetSpawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {

		if (sender instanceof Player) {
			Player player = (Player) sender;

			Main.getConfigs().set("spawn", player.getLocation());
			Main.getConfigs().saveConfig();
			player.sendMessage(ChatColor.GREEN + "O spawn foi setado");

		}
		return false;
	}

}
