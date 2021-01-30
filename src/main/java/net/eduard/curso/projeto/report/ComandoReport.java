package net.eduard.curso.projeto.report;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoReport implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)){

            return true;
        }
        Player player = (Player)sender;

        if (args.length == 0 ){
            player.sendMessage("§c/report <player>");
            return true;
        }
        if (args.length == 1 ){
            player.sendMessage("§c/report <player> <motivo>");
            player.sendMessage("§aTipos: §fHACK, FLY");
            return true;
        }

        String nick = args[0];
        String motivo = args[1];
        Player alvo = Bukkit.getPlayer(nick);
        if (alvo == null){
            player.sendMessage("§cJogador offline.");
            return true;
        }

        Report novoReport = new Report();
        novoReport.setReporterPlayer(player.getName());
        novoReport.setReportedPlayer(alvo.getName());
        novoReport.setCause(motivo);
        novoReport.setTime(System.currentTimeMillis());
        Report.getReports().add(novoReport);
        player.sendMessage("§aJogador reportado.");
        Report.saveReports();

        return true;
    }
}
