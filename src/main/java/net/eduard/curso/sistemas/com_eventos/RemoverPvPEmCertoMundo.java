package net.eduard.curso.sistemas.com_eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class RemoverPvPEmCertoMundo implements Listener {

    public static String mundo = "plotme";
    public static long noite = 18000;
    public static long dia = 0;

    @EventHandler
    public void event(EntityDamageByEntityEvent e) {
        if (!(e.getEntity() instanceof Player)) return;
        Player player = (Player) e.getEntity();
        if (player.getWorld().getName().equals(mundo)) {
            if (player.getWorld().getTime() >= noite) {
                e.setCancelled(true);

                if (e.getDamager() instanceof Player) {
                    Player quembateu = (Player) e.getDamager();
                    quembateu.sendMessage("§cPVP de noite bloqueado");
                }
            }

        }
    }

}
