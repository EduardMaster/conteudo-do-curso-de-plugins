package net.eduard.curso.ban;

import java.util.Calendar;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;

import net.eduard.curso.Assunto;
import net.eduard.curso.AssuntoNivel;

/**
 * Sistema de banimento completo
 * @author Eduard
 *
 */
@Assunto(nivel=AssuntoNivel.INTERMEDIARIO,subnivel=15)
public class SistemaBanimento implements CommandExecutor, Listener {

	public static Map<String, Banimento> banimentos = new HashMap<>();

	public static void banir(String nome, String autor, String motivo, UUID autorID, UUID banidoId, int diasBanido) {
		Banimento ban = new Banimento();
		ban.setAlvo(nome);
		ban.setAlvoId(banidoId);
		ban.setAutor(autor);
		ban.setAutorID(banidoId);
		ban.setDia(Calendar.getInstance().getTime());
		ban.setDuracaoEmDias(diasBanido);
		ban.setMotivo(motivo);
		banimentos.put(nome, ban);
	}

	public static boolean estaBanido(String nome) {
		return banimentos.containsKey(nome);
	}

	public static void desbanir(String name) {
		banimentos.remove(name);
	}

	@EventHandler
	public void evento(PlayerKickEvent e) {
		Player p = e.getPlayer();
		if (estaBanido(p.getName())) {
			Banimento ban = banimentos.get(p.getName());
			e.setLeaveMessage("§cVoce foi banido por " + ban.getAlvo());

		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (args.length <= 1) {
			sender.sendMessage("§c/ban <jogador> <motivo> [dias]");
		} else {
			String alvoNome = args[0];
			int diasBanido = 1;
			if (args.length >= 3) {
				diasBanido = Integer.valueOf(args[2]);
			}
			OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(alvoNome);
			OfflinePlayer autorOffline = Bukkit.getOfflinePlayer(sender.getName());
			String motivo = args[1];
			if (estaBanido(alvoNome)) {
				sender.sendMessage("§cJa foi banido!");
			} else {

				banir(alvoNome, sender.getName(), motivo, autorOffline.getUniqueId(),
						offlinePlayer.getUniqueId(), diasBanido);
				if (offlinePlayer.isOnline()) {
					offlinePlayer.getPlayer().kickPlayer("§cVoc§ foi banido!");
				}
			}

		}

		return true;
	}

}
