package net.eduard.curso.sistemas;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;


/**
 * Sistema de ao clicar na sopa ira tomar ela duma vez, em vez de comer como é o tradicional
 *
 * @author Eduard
 */
public class TomarSopa implements Listener {

    @EventHandler
    public void event(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (e.getMaterial() != Material.MUSHROOM_SOUP) return;
        double soma = player.getHealth() + 7;
        if (player.getHealth() == player.getMaxHealth()) return;

        if (soma > player.getMaxHealth()) {
            soma = (player.getMaxHealth());
        }
        player.setHealth(soma);

        player.playSound(player.getLocation(), Sound.BURP, 2, 1);
        // p.setItemInHand(null);
        player.getItemInHand().setType(Material.BOWL);


    }
}
