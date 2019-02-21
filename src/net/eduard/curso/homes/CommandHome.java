package net.eduard.curso.homes;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.eduard.curso.CursoEduard;

public class CommandHome implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(args.length == 0) {
				sender.sendMessage("Utilize /home <nome>.");
			} else {
				String nomedahome = args[0];
				p.teleport(CursoEduard.getConfigs().getLocation("home." + p.getName() + "." + nomedahome));
				p.sendMessage("§a§lHOME §aVoce foi teleportado para home: " + nomedahome);
			}
		}
		return false;
	}

}
