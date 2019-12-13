package net.eduard.curso.armazenamento;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSetHome implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(args.length == 0) {
				p.sendMessage("Utilize /sethome <nome>.");
			} else {
				String nomedahome = args[0];
//				CursoEduard.getConfigs().set("home." + p.getName() + "." + nomedahome, p.getLocation());
//				CursoEduard.getConfigs().saveConfig();
				HomesAPI.setHome(p, nomedahome);
				p.sendMessage("§a§lHOME §aHome setada com sucesso!");
			}
		}
		return false;
	}

}
