package net.eduard.curso.projeto.warp;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoWarp implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        Player player = (Player) sender;
        if (args.length == 0) {
            player.sendMessage("§cdigite /warp <nome>");
            return true;
        }
        String nome = args[0];
        if (!player.hasPermission("warp." + nome)) {
            player.sendMessage("§cVoce nao tem permiss§o para ir a este Warp");
            return true;
        }

        if (!WarpAPI.hasWarp(nome)) {
            player.sendMessage("§cEste warp nao foi setado!");
            return true;
        }
        player.teleport(WarpAPI.getWarp(nome));
        player.sendMessage("§aVoce foi ate o warp " + nome);


        return true;
    }

}
