package net.eduard.curso.projeto.essentials;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoTeleportAceitar implements CommandExecutor {



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }

        Player player = (Player) sender;
        // /tpa nick
        if (args.length == 0){
            player.sendMessage("§cDigite /tpaaceitar <nick>");
            return true;
        }
        String nick = args[0];
        Player alvo = Bukkit.getPlayer(nick);
        if (alvo == null){
            player.sendMessage("§cJogador offline.");
            return true;
        }
        if (!ComandoTeleportPlayer.tpaConvidados.containsKey(alvo)){

        player.sendMessage("§cEste jogador não convidou ninguem");
            return true;
        }
        Player convidadoDoAlvo = ComandoTeleportPlayer.tpaConvidados.get(alvo);
        if (!convidadoDoAlvo.equals(player)){
            player.sendMessage("§cVocê não foi convidado por ele.");
            return true;
        }
        alvo.teleport(player);
        alvo.sendMessage("§aO jogador "+player.getName()+
                " aceitou seu convite de TPA.");
        player.sendMessage("§aVocê aceitou o convite de TPA do jogador "+ alvo.getName());
        ComandoTeleportPlayer.tpaConvidados.remove(alvo);

        return true;
    }
}
