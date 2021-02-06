package net.eduard.curso.sistemas.com_eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

/**
 * Remover a fome e restaurar ela pra o Inicio
 *
 * @author Eduard
 *
 */
public class RemoverFome implements Listener {
    @EventHandler
    public void removerFome(FoodLevelChangeEvent e) {
        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            e.setFoodLevel(20);
            p.setSaturation(20);
            p.setExhaustion(0);
        }
    }
}

