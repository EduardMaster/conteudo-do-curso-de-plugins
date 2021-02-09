package net.eduard.curso.projeto.minion;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class MinionController implements Listener {


    @EventHandler
    public void event(PlayerInteractEvent e) {
        if (e.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        if (e.getItem() == null) return;
        Minion minion = ProjetoMinion.getManager().getMinionByIcon(e.getItem());
        if (minion == null) return;

        MinionSpawned spawned = new MinionSpawned();
        spawned.setDono(e.getPlayer().getName());
        spawned.setMinion(minion);
        spawned.setLocation(e.getClickedBlock().getLocation());
        spawned.setLife(50);
        spawned.setFood(50);
        spawned.spawn();
        e.getPlayer().sendMessage("§aMinion spawnado");
        ProjetoMinion.getManager().insert(spawned);

    }


}
