package net.eduard.curso.projeto.maquina;

import net.eduard.api.lib.modules.Extra;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ComandoCombustivelGive implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (args.length < 3) {
			sender.sendMessage("");
		}else {
			String maquinanome = args[0];
			String playernome = args[1];
			String quantidade = args[2];
			MaquinaManager manager = MaquinaAPI.getManager();
			Maquina maquina = manager.getMaquina(maquinanome);
			if (maquina == null) {
				sender.sendMessage("§c");
			}else {
				
				Player jogador = Bukkit.getPlayer(playernome);
				if (jogador == null) {
					sender.sendMessage("§c");
				}else {
					
					ItemStack maquinaitem = maquina.getIcon().clone();
					maquinaitem.setAmount(Extra.toInt(quantidade));
					jogador.getInventory().addItem(maquinaitem);
				}
				
				
			}
		}
		
		
		
		return false;
	}

}
