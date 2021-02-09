package net.eduard.curso.projeto.minion;


import net.eduard.curso.Curso;
import net.eduard.curso.Projeto;

public class ProjetoMinion extends Projeto {

    private static MinionManager manager = new MinionManager();


    public static MinionManager getManager() {
        return manager;
    }


    @Override
    public void onEnable() {
        manager.loadMinions();
        new MinionAnimation()
                .runTaskTimerAsynchronously(Curso.getInstance(), 20,20);
        registerEvents(new MinionController());
    }

    @Override
    public void onDisable() {
        manager.despawnMinions();
        manager.saveMinions();
    }
}
