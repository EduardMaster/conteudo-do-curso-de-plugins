package net.eduard.curso.projeto.essentials;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


/**
 * Comando de trocar o gamemode seu e de outros jogadores
 *
 * @author Eduard
 */

public class ComandoGamemode implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
        if (!(sender instanceof Player)) {

            return true;
        }
        Player player = (Player) sender;
        if (args.length == 0) {
            if (player.getGameMode().equals(GameMode.CREATIVE)) {
                player.setGameMode(GameMode.SURVIVAL);
                player.sendMessage("§eSeu modo de jogo foi mudado sobrevivencia");
            } else {
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage("§eSeu modo de jogo foi mudado criativo");
            }
        } else if (args.length == 1) {
            String subComando = args[0];
            if (subComando.equalsIgnoreCase("0")) {
                player.setGameMode(GameMode.SURVIVAL);
                player.sendMessage("§eSeu modo de jogo foi mudado Sobrevivencia");
            } else if (subComando.equalsIgnoreCase("1")) {
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage("§eSeu modo de jogo foi mudado Criativo");
            } else if (subComando.equalsIgnoreCase("2")) {
                player.setGameMode(GameMode.ADVENTURE);
                player.sendMessage("§eSeu modo de jogo foi mudado Aventura");
            }
        } else {
            Player alvo = Bukkit.getPlayer(args[1]);
            if (alvo != null) {
                if (args[0].equalsIgnoreCase("0")) {
                    alvo.setGameMode(GameMode.SURVIVAL);
                    sender.sendMessage("§eO modo de jogo de " + alvo.getName() + "foi mudado para sobrevivencia");
                } else if (args[0].equalsIgnoreCase("1")) {
                    alvo.setGameMode(GameMode.CREATIVE);
                    sender.sendMessage("§eO modo de jogo de " + alvo.getName() + "foi mudado para sobrevivencia");
                }
            } else {
                sender.sendMessage("§cEste jogador nao esta online, ou nao existe.");
            }
        }

        return false;
    }

}
