package net.eduard.curso.gladiator;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoGladiador implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender,
			Command cmd, String lb,
			String[] args) {
		
		if (sender instanceof Player) {
			Player p = (Player) sender;
			
			
			
			if (args.length == 0	) { 
				p.sendMessage("§a/gladiador ajuda");
				
				
			}else if (args[0].equalsIgnoreCase("ajuda")) {
				
				p.sendMessage("§b/gladiador iniciar");
				p.sendMessage("§b/gladiador forcarinicio");
				p.sendMessage("§b/gladiador terminar");
				p.sendMessage("§b/gladiador camarote");
				p.sendMessage("§b/gladiador setcamarote");
				p.sendMessage("§b/gladiador setsaida");
				p.sendMessage("§b/gladiador setspawn");
				
				
				
				
				
			}
			
			
			
			
			
			
			
		}
		return true;
	}

}
