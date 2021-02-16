package net.eduard.curso.projeto.cash;

import net.eduard.api.lib.modules.Extra;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoCash implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // /cash setar [jogador] [quantidade]
        // /cash remover
        // /cash dar
        // /cash

        if (args.length == 0) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                double cashAtual = ProjetoCash.getManager().getCash(player.getName());

                player.sendMessage("§aSeu cash §: §2" + cashAtual);

            } else {
                sender.sendMessage("§cPrecisa ser um jogador!");
            }

        } else {
            String subcomando = args[0];
            // /cash setar [jogador] [quantidade]
            if (subcomando.equalsIgnoreCase("setar")) {

                if (args.length < 3) {
                    sender.sendMessage("§cUtilize /cash setar <jogador> <quantidade>");
                } else {
                    String nomeJogador = args[1];
                    double quantidade = Extra.toDouble(args[2]);

                    ProjetoCash.getManager().setCash(nomeJogador, quantidade);
                    sender.sendMessage("§aVoce alterou o cash do " +
                            nomeJogador + " para " + quantidade);
                }
            }

        }


        return false;
    }

}
