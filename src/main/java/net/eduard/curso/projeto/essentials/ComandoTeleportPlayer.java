package net.eduard.curso.projeto.essentials;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class ComandoTeleportPlayer implements CommandExecutor {


    public static HashMap<Player,Player> tpaConvidados = new HashMap<>();


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }

        Player player = (Player) sender;
        // /tpa nick
        if (args.length == 0){
            player.sendMessage("§cDigite /tpa <nick>");
            return true;
        }
        String nick = args[0];
        Player alvo = Bukkit.getPlayer(nick);
        if (alvo == null){
            player.sendMessage("§cJogador offline.");
            return true;
        }
        TextComponent json = new TextComponent("§7                     ");
        TextComponent jsonAceitar = new TextComponent(" §a§lACEITAR   ");
        json.addExtra(jsonAceitar);
        TextComponent jsonNegar = new TextComponent(" §c§lNEGAR  ");
        json.addExtra(jsonNegar);

        ClickEvent forcarComando = new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tpaaceitar "+ player.getName());
        json.setClickEvent(forcarComando);

        alvo.spigot().sendMessage(json);
        player.sendMessage("§aVocê convidadou o jogador "+alvo.getName()+" para ir até você.");
        tpaConvidados.put(player, alvo);



        return true;
    }
}
