package net.eduard.curso.warp;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ComandoWarps implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		List<String> warps = WarpAPI.getWarps();
		if (warps.isEmpty()) {
			sender.sendMessage("§cnao tem warps setadas");
		} else {
			sender.sendMessage("§aWarps disponiveis: " + warps);
		}

		return true;
	}


}
