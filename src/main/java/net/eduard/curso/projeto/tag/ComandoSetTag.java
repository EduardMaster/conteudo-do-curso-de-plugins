package net.eduard.curso.projeto.tag;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoSetTag implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length < 3) {
            sender.sendMessage("§a/settag <nick> <prefix> <suffix>");
            return true;
        }
        String nick = args[0];
        String prefix = args[1];
        String suffix = args[2];
        if (prefix.length() > 16) {
            sender.sendMessage("§cPrefixo esta muito grande maximo 16 letras");
            return true;
        }
        if (suffix.length() > 16) {
            sender.sendMessage("§cSuffixo esta muito grande maximo 16 letras");
            return true;
        }
        Player alvo = Bukkit.getPlayer(nick);
        if (alvo == null) {
            sender.sendMessage("§Cjogador offline");
            return true;
        }
        PlayerTag.setTag(alvo, prefix, suffix);
        return true;
    }
}
