package net.eduard.curso.sistemas.nao_revisados;

import net.eduard.curso.Curso;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Sistema simples para você poder ver todos efeitos sonoros existentes e também os efeitos
 *
 * @author Eduard
 */
public class VerEfeitosSonoros extends BukkitRunnable {
    private Player player;

    @EventHandler
    public void event(PlayerJoinEvent e) {
        player = e.getPlayer();
        runTaskTimer(Curso.getInstance(), 20 * 3, 20 * 3);

    }

    int current = 35;

    @Override
    public void run() {
        if (current + 1 > Effect.values().length) {
            current = 0;
        }
        Effect effect = Effect.values()[current];
        Bukkit.getConsoleSender().sendMessage("§cMonstrano efeito " + effect.name() + " para o " + player.getName() + " id " + current);
        if (effect == Effect.ITEM_BREAK) {
            player.sendMessage("§cInvalido");
            current++;
            return;
        }
        Location loc = player.getLocation();
        player.playEffect(loc.add(0, 2, 0), effect, 0);
        player.sendMessage("§aMostrando efeito " + effect.name());
        current++;
    }
}
