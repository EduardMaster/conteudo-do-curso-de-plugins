package net.eduard.curso.armazenamento;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHomeList implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
//		Set<String> armazenamento = CursoEduard.getConfigs().getSection("home." + sender.getName()).getKeys(false);
		if (sender instanceof Player) {
			Player player = (Player) sender;

			sender.sendMessage("Suas armazenamento são: " + HomesAPI.getHomes(player));
		}else {
			sender.sendMessage("§cO console nao tem armazenamento");
		}
		return false;
	}

}
