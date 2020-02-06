package net.eduard.curso.economia;

import net.eduard.api.lib.modules.Extra;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.eduard.api.lib.modules.Mine;

public class ComandoCash implements CommandExecutor {


	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		// /cash setar [jogador] [quantidade]
		// /cash remover
		// /cash dar
		// /cash
 
		if (args.length == 0) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				double cashAtual = CashSqlite.getCash(p);
				
				p.sendMessage("§aSeu cash §: §2"+cashAtual);
				
			}else {
				sender.sendMessage("§cPrecisa ser um jogador!");
			}

		}else {
			
			String subcomando = args [0];
			// /cash setar [jogador] [quantidade]
			if (subcomando.equalsIgnoreCase("setar")) {
				
				if (args.length < 3) {
					sender.sendMessage("§cUtilize /cash setar <jogador> <quantidade>");
				}else {
					
					//cash setar cuzudo
					
					Player jogador = Bukkit.getPlayer(args[1]);
					
					if (jogador == null) {
						sender.sendMessage("§cJogador nao existe.");
					}else {
						
						double quantidade = Extra.toDouble(args[2]);
						
						CashSqlite.setCash(jogador, quantidade);
						sender.sendMessage("§aVoce alterou o cash do "+
						jogador.getName()+" para "+ quantidade);
						
						
					}
					
				}
			}
			
		}
		
		
		

		return false;
	}

}
