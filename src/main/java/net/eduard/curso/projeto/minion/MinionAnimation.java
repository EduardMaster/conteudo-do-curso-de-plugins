package net.eduard.curso.projeto.minion;

import org.bukkit.Bukkit;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class MinionAnimation extends BukkitRunnable {

    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            MinionPlayer conta = ProjetoMinion.getManager().getUser(player.getName());
            for (MinionSpawned minionSpawned : conta.getMinions().values()) {
                ArmorStand stand = minionSpawned.getStand();
                if (minionSpawned.getMinion().getMinionJob()== MinionJob.MINER){

                }
            }
        }
    }
}
