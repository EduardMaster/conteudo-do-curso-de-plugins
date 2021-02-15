package net.eduard.curso.sistemas.nao_revisados;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * Sistema de player mutado
 *
 * @author Eduard
 */
public class BloquearChat implements Listener {
    public final static ArrayList<Player> MUTEDS = new ArrayList<>();

    @EventHandler
    public void Mutado(AsyncPlayerChatEvent e) {

        Player player = e.getPlayer();
        if (!MUTEDS.contains(player)) {
            return;
        }
        e.setCancelled(true);
        player.sendMessage("§cVoce foi silenciado!");

    }

}
