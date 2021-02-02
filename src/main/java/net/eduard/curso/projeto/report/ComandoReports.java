package net.eduard.curso.projeto.report;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoReports implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)){

            return true;
        }
        Player player = (Player)sender;
        MenuReports.abrirMenu(player);
        player.sendMessage("§aAbrindo menu dos reportes.");
        return true;
    }
}
