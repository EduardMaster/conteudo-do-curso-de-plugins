package net.eduard.curso.armazenamento;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandDeleteHome implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (args.length == 0) {
				sender.sendMessage("Utilize /deletehome <home>.");
			} else {
				String nomedahome = args[0];
//				CursoEduard.getConfigs().remove("home." + p.getName() + "." + nomedahome);
//				CursoEduard.getConfigs().saveConfig();
				if (HomesAPI.existsHome(p, nomedahome)) {
					HomesAPI.deleteHome(p, nomedahome);
					p.sendMessage("§a§lHOME §aVocê deletou a home: " + nomedahome);
				} else {
					p.sendMessage("§a§lHOME §cNão existe esta home: " + nomedahome);
				}
			}

		}
		return false;
	}

}
