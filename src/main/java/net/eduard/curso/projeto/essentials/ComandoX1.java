package net.eduard.curso.projeto.essentials;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoX1 implements CommandExecutor {

    public static HashMap<Player, Player> convites = new HashMap<>();
    public static HashMap<Player, Player> batalhas = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        Player player = (Player) sender;
        if (args.length == 0) {
            player.sendMessage("§a/x1 convidar <jogador>");
            player.sendMessage("§a/x1 aceitar <jogador>");
            player.sendMessage("§a/x1 recusar <jogador>");
        } else {
            String sub = args[0];
            if (sub.equalsIgnoreCase("aceitar")) {
                // x1 aceitar Micael
                if (args.length == 1) {
                    player.sendMessage("§c/x1 aceitar <jogador>");
                } else {
                    String nome = args[1];
                    Player jogador = Bukkit.getPlayer(nome);
                    if (jogador == null) {
                        player.sendMessage("§cJogador offline.");
                    } else {
                        if (convites.containsKey(jogador)) {
                            Player convidadoPeloJogador = convites.get(jogador);
                            if (convidadoPeloJogador.equals(player)) {
                                batalhas.put(player, jogador);
                                batalhas.put(jogador, player);
                            }
                        }
                    }
                }
            } else if (sub.equalsIgnoreCase("recusar")) {

            } else if (sub.equalsIgnoreCase("convidar")) {
                // x1 convidar Edu
                if (args.length == 1) {
                    player.sendMessage("§c/x1 convidar <jogador>");
                } else {
                    String nome = args[1];
                    Player jogador = Bukkit.getPlayer(nome);
                    if (jogador == null) {
                        player.sendMessage("§cJogador offline.");
                    } else {
                        convites.put(player, jogador);

                    }
                }

            } else {
                player.sendMessage("§a/x1 convidar <jogador>");
                player.sendMessage("§a/x1 aceitar <jogador>");
                player.sendMessage("§a/x1 recusar <jogador>");
            }
        }


        return false;
    }

}
