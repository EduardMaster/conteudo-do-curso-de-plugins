package net.eduard.curso.projeto.report;

import net.eduard.api.lib.config.BukkitConfigs;
import org.bukkit.configuration.ConfigurationSection;

import java.util.ArrayList;
import java.util.List;

public class ReportManager {

    private BukkitConfigs config =
            new BukkitConfigs("reports.yml");

    private final List<Report> reports = new ArrayList<>();

    public List<Report> getReports() {
        return reports;
    }

    public void saveReports() {
        config.remove("reports");
        int id = 1;
        for (Report report : reports) {
            ConfigurationSection secao = config.create("reports.report-" + id);
            report.save(secao);
            id++;
        }
        config.saveConfig();
    }

    public void reloadReports() {
        config.reloadConfig();
        reports.clear();
        for (String chave : config.getSection("reports").getKeys(false)) {
            ConfigurationSection secao = config.getSection("reports." + chave);
            Report reportNovo = new Report();
            reportNovo.reload(secao);
            reports.add(reportNovo);


        }


    }


}
