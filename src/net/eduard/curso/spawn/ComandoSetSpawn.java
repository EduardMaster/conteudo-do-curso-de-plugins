package net.eduard.curso.spawn;

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
			Player p = (Player) sender;

			Main.getConfigs().set("spawn", p.getLocation());
			Main.getConfigs().saveConfig();
			p.sendMessage(ChatColor.GREEN + "O spawn foi setado");

		}
		return false;
	}

}
