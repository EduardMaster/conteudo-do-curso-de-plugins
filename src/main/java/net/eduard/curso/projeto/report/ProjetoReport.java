package net.eduard.curso.projeto.report;

import net.eduard.curso.Projeto;

public class ProjetoReport extends Projeto {
    public static ReportManager getManager() {
        return manager;
    }
    private static  ReportManager manager;
    @Override
    public void onEnable() {
        manager =  new ReportManager();
        registerCommand("report", new ComandoReport());
        registerCommand("reports", new ComandoReports());
        registerEvents(new MenuReports());
        getManager().reloadReports();
    }

    @Override
    public void onDisable() {

        getManager().saveReports();
    }


}
