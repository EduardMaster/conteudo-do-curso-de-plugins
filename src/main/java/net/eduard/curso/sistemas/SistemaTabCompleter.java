package net.eduard.curso.sistemas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.eduard.curso.Sistema;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


/**
 * TabComplete criado para um Comando simples
 *
 * @author Eduard
 */

public class SistemaTabCompleter extends Sistema {

    @Override
    public void onEnable() {
        registerCommand("tabcomplete");
        registerTabcompleter("tabcomplete");
    }

    @Override
    public void onDisable() {

    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (!(sender instanceof Player)) {
            return null;

        }


        Player player = (Player) sender;
        player.sendMessage("§aVoce esta apertando o Tab");
        if (args.length == 0) {
            return null;
        }

        if (args.length == 1) {

            if (args[0].equalsIgnoreCase("usar")) {
                return Arrays.asList("comando", "subcomando");
            }
        } else {
            if (args[1].equalsIgnoreCase("comando")) {
                List<String> lista = new ArrayList<>();
                lista.add("outrosubcomando");
                return lista;
            }
        }


        return null;
    }


}
