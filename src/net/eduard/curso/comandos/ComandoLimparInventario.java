package net.eduard.curso.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.eduard.curso.Assunto;
/**
 * Comando que limpa todo o inventario do jogador desde a armadura até os itens normais
 * @author Eduard
 *
 */
@Assunto(subnivel=5)
public class ComandoLimparInventario implements CommandExecutor{
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			Player jogador = (Player) sender;
			if (command.getName().equalsIgnoreCase("clearinventory")) {
				jogador.getInventory().clear();
				jogador.getInventory().setArmorContents(null);
				jogador.sendMessage("§aInventario Limpo!");
			}
		}
		
		return false;
	}

}
