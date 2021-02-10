package net.eduard.curso.projeto.tag;

import net.eduard.curso.Projeto;

public class ProjetoTags extends Projeto {
    public static TagManager getManager() {
        return manager;
    }

    @Override
    public void onEnable() {
        registerCommand("settag", new ComandoSetTag());
        registerAsyncTimer(new PlayerTagUpdater(), 20, 20);
    }

    @Override
    public void onDisable() {
    }
    private static final TagManager manager = new TagManager();
}
