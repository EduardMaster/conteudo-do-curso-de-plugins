package net.eduard.curso.projeto.cash;

import net.eduard.curso.Projeto;

public class ProjetoCash extends Projeto {
    private final static CashManager manager = new CashManager();

    public static CashManager getManager() {
        return manager;
    }

    @Override
    public void onEnable() {
        registerCommand("cash", new ComandoCash());
        manager.setUseSQL(true);
        manager.getSql().setDatabase("minecraft");
        manager.getSql().abrirMySQL();
        manager.getSql().criarTabela();
        manager.reloadFromSQL();
    }

    @Override
    public void onDisable() {
        manager.getSql().fechar();
    }
}
