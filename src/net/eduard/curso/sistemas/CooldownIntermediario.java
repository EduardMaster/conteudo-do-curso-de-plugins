package net.eduard.curso.sistemas;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import net.eduard.api.lib.modules.Extra;
import net.eduard.curso.Main;

public class CooldownIntermediario implements CommandExecutor {
	

	public static HashMap<Player, Long> jogadoresEmCooldown = new HashMap<>();

	public static void colocarEmCooldown(Player p,int segundos) {
		jogadoresEmCooldown.put(p, System.currentTimeMillis());
		new BukkitRunnable() {
			
			@Override
			public void run() {

			p.sendMessage("§aVocê saiu do tempo de espera.");	
			}
		}.runTaskLater(Main.getInstance(), 20 * segundos);
	}

	public static boolean estaEmCooldown(Player player, int segundos) {

		// segundos = 3

		if (jogadoresEmCooldown.containsKey(player)) {

			Long tempoArmazenado = jogadoresEmCooldown.get(player);

			// tempoarmazenado = 800000
			// tempoatual = 3000000
			// temqueesperar = 2000000
			// formula: tempoatual > tempoarmazenado + tempoquetemqueesesperar;

			long tempoAtual = System.currentTimeMillis();

			long segundoEmMilis = segundos * 1000L;
			// segundosEmMiliSegundos = 30000

			boolean naoEstaMaisEmCooldown = tempoAtual > tempoArmazenado + segundoEmMilis;
			
			if (!player.getAllowFlight()) {
				
			}
			if (!player.isSneaking()) {
				
			}
			
			
			return !naoEstaMaisEmCooldown;

		}

		return false;

	}

	public static long pegarTempoRestanteDoCooldown(Player player, int segundos) {

		// segundos = 3

		if (jogadoresEmCooldown.containsKey(player)) {

			Long tempoArmazenado = jogadoresEmCooldown.get(player);

			// tempoarmazenado = 800000
			// tempoatual = 3000000
			// temqueesperar = 2000000
			// formula: tempoatual > tempoarmazenado + tempoquetemqueesesperar;

			long tempoAtual = System.currentTimeMillis();

			long segundoEmMilis = segundos * 1000L;
			// segundosEmMiliSegundos = 30000

			long tempoRestante = tempoArmazenado + segundoEmMilis - tempoAtual;
			
			return tempoRestante;

		}

		return 0;

	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;

			if (estaEmCooldown(p, 15)) {
				long tempoRestante = pegarTempoRestanteDoCooldown(p, 15);
				String tempoFormatado = Extra.formatTime(tempoRestante);
				sender.sendMessage("§cVoce esta em cooldown e precisa esperar " + tempoFormatado);
			} else {

				colocarEmCooldown(p,15);
				sender.sendMessage("§aVoce executou o comando e agora esta em cooldown.");

			}

		}

		return true;
	}

}
