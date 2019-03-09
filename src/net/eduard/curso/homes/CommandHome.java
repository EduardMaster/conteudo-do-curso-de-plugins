package net.eduard.curso.homes;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.eduard.curso.Main;

public class CommandHome implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (args.length == 0) {
				sender.sendMessage("Utilize /home <nome>.");
			} else {
				String nomedahome = args[0];
				if (HomesAPI.existsHome(p, nomedahome)) {
					Location home = Main.getConfigs().getLocation("home." + p.getName() + "." + nomedahome);
					p.teleport(home);
					p.sendMessage("§a§lHOME §aVoce foi teleportado para home: " + nomedahome);
				} else {
					p.sendMessage("§a§lHOME §cNão existe esta home: " + nomedahome);
					
				}
			}
		}
		return false;
	}

}
