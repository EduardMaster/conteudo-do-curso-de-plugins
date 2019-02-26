package net.eduard.curso.tempo;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import net.eduard.curso.AssuntoDoCurso;
import net.eduard.curso.CursoEduard;

public class ComandoDelay implements CommandExecutor, AssuntoDoCurso<BukkitRunnable> {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {

		sender.sendMessage("§aDelay iniciado");

		BukkitRunnable objeto = new BukkitRunnable() {

			public void run() {
				sender.sendMessage("§aDelay finalizado");
			}
		};

		objeto.runTaskLater(CursoEduard.getInstance(), 20 * 5);

		return true;
	}

	@Override
	public BukkitRunnable aoLigar(JavaPlugin plugin) {
		plugin.getCommand("delay").setExecutor(this);
		return new BukkitRunnable() {

			public void run() {
				Bukkit.getConsoleSender().sendMessage("§aAconteceu um atraso nesta mensagem");
			}
		};
	}

}
