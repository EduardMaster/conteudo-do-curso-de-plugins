package net.eduard.curso.homes;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.eduard.curso.CursoEduard;

public class CommandHomeList implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		sender.sendMessage("Suas homes são: " + CursoEduard.getConfigs().getSection("home." + sender.getName()).getKeys(false));
		return false;
	}

}
