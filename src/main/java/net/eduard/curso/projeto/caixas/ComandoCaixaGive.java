package net.eduard.curso.projeto.caixas;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import net.eduard.api.lib.modules.Extra;

public class ComandoCaixaGive implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (args.length  < 3) {
			sender.sendMessage("§c/caixagive <caixa> <jogador> <quantidade>");
		}else {
			String caixanome = args[0];
			String jogadornome = args[1];
			int quantidade = Extra.toInt(args[2]);
			if (quantidade==0) {
				quantidade=1;
			}
			Player jogador = Bukkit.getPlayer(jogadornome);
			Caixa caixa = CaixaAPI.getManager().getCaixa(caixanome);
			if (caixa == null) {
				sender.sendMessage("§cNão exise esta caixa "+caixanome);
			}else {
				if(jogador == null) {
					sender.sendMessage("§cEste jogador não esta online "+jogadornome);
				}else {
					ItemStack item = caixa.getCaixa().clone();
					item.setAmount(quantidade);
					jogador.getInventory().addItem(item);
					jogador.sendMessage("§aVocê recebeu uma caixa de "+caixa.getNome());
					//
				}
			}
			
		}
		
		return false;
	}

}
