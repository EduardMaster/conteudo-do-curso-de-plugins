package net.eduard.curso.projeto.money;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoEconomia implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("money")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (args.length < 1) {
					p.sendMessage("§aSeu money § " + CoinsSQL.pegarSaldo(p.getName()));
					return true;
				}
				String sub = args[0];
				if (args[0].equalsIgnoreCase("setar") || sub.equalsIgnoreCase("set")) {
					if (args.length <= 2) {
						p.sendMessage("/money setar jogador");
						return true;
					} else {
						Double valor = Double.parseDouble(args[2]);
						String nome = p.getName();
						CoinsSQL.alterarSaldoConta(nome, valor);
						p.sendMessage("§aVoce alterou o money do " + nome);
					}
				}
				if (args[0].equalsIgnoreCase("add") || sub.equalsIgnoreCase("adicionar")) {
					if (args.length <= 2) {
						p.sendMessage("/money add jogador");
						return true;
					} else {
						double valor = Double.parseDouble(args[2]);
						String nome = p.getName();
						CoinsSQL.adicionarSaldoConta(nome, valor);
						p.sendMessage("§aVoce adicionou o money do " + nome);
					}
				}
				if (sub.equalsIgnoreCase("remove") || sub.equalsIgnoreCase("remover") || sub.equalsIgnoreCase("retirar")
						|| sub.equalsIgnoreCase("take")) {
					if (args.length <= 2) {
						p.sendMessage("/money remove jogador");
						return true;
					} else {
						double valor = Double.parseDouble(args[2]);
						String nome = p.getName();
						CoinsSQL.removerSaldoConta(nome, valor);
						p.sendMessage("§aVoce removeu o money do " + nome);
					}
				}
			}

		}
		return false;
	}

}
