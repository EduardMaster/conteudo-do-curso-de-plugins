package net.eduard.curso.tempo;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import net.eduard.curso.AssuntoDoCurso;
import net.eduard.curso.CursoEduard;

public class ComandoTimer implements CommandExecutor, AssuntoDoCurso<CommandExecutor> {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		sender.sendMessage("§aO timer iniciou");
		new BukkitRunnable() {
			int contagem = 60;

			@Override
			public void run() {
				contagem = contagem - 1;
				if (contagem == 0) {
					sender.sendMessage("§aTimer acabou");
					cancel();
				} else {
					sender.sendMessage("§aO tempo do timer esta passando " + contagem);
				}
			}
		}.runTaskTimer(CursoEduard.getInstance(), 20, 20);

		return true;
	}

	@Override
	public CommandExecutor aoLigar(JavaPlugin plugin) {
		plugin.getCommand("timer").setExecutor(this);
		return this;
	}

}
