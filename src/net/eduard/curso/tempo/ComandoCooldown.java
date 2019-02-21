package net.eduard.curso.tempo;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import net.eduard.curso.CursoEduard;

public class ComandoCooldown implements CommandExecutor {

	public static ArrayList<Player> jogadoresEmCooldown = new ArrayList<>();


	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;

			if (jogadoresEmCooldown.contains(p)) {
				sender.sendMessage("§cVoce esta em cooldown");
			} else {

				jogadoresEmCooldown.add(p);
				sender.sendMessage("§aVoce executou o comando e agora esta em cooldown.");
				new BukkitRunnable() {
					
					public void run() {

						sender.sendMessage("§cVoce pode usar o comando novamente.");
						jogadoresEmCooldown.remove(p);
					}
				}.runTaskLater(CursoEduard.getInstance(), 20 * 10);

			}

		}

		return true;
	}

}
