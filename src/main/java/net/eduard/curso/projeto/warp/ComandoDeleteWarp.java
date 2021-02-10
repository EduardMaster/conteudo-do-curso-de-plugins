package net.eduard.curso.projeto.warp;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ComandoDeleteWarp implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 0) {

            sender.sendMessage("§c/deletewarp <nome>");
            //

            return true;
        }

        String nome = args[0];
        if (!WarpAPI.hasWarp(nome)) {
            sender.sendMessage("§cEste warp nao foi setado!");
            return true;
        }

        WarpAPI.removeWarp(nome);
        sender.sendMessage("§aA warp " + nome + " foi deletada!");


        return true;
    }

}
