package net.eduard.curso.dependencia;

import net.eduard.curso.Curso;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import net.eduard.api.lib.game.Animation;

public class AnimacaoComAnimation implements Listener {

    @EventHandler
    public void clicar(PlayerInteractEvent e) {
        Player player = e.getPlayer();

        if (player.getItemInHand() == null)
            return;
        if (player.getItemInHand().getType() != Material.DIAMOND) return;

        ArmorStand stand = player.getWorld().spawn(player.getLocation(), ArmorStand.class);
        stand.setSmall(true);
        stand.setVisible(true);
        stand.setGravity(false);
        stand.setHelmet(new ItemStack(Material.DIAMOND_BLOCK));
        Animation animador = new Animation(stand);
        new BukkitRunnable() {
            int duracao = 100;

            @Override
            public void run() {

                duracao--;
                animador.moveHeadUp(10);
                if (duracao == 0) {
                    cancel();
                    stand.remove();
                }
            }
        }.runTaskTimer(Curso.getInstance(), 2, 2);


    }
}
