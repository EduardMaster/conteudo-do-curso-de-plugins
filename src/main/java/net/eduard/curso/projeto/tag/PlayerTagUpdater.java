package net.eduard.curso.projeto.tag;

import org.bukkit.scheduler.BukkitRunnable;

public class PlayerTagUpdater extends BukkitRunnable {

    @Override
    public void run() {
        ProjetoTags.getManager().updateTags();
    }
}
