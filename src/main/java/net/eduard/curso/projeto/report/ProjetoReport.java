package net.eduard.curso.projeto.report;

import net.eduard.curso.Projeto;

public class ProjetoReport extends Projeto {
    public static ReportManager getManager() {
        return manager;
    }

    @Override
    public void onEnable() {
        registerCommand("report", new ComandoReport());
        registerCommand("reports", new ComandoReports());
        registerEvents(new MenuReports());
        getManager().reloadReports();
    }

    @Override
    public void onDisable() {

        getManager().saveReports();
    }

    private static final ReportManager manager = new ReportManager();
}
