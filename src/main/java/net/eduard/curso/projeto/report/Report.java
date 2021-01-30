package net.eduard.curso.projeto.report;

import net.eduard.api.lib.config.BukkitConfigs;
import org.bukkit.configuration.ConfigurationSection;

import java.util.ArrayList;
import java.util.List;

public class Report {
    private static BukkitConfigs config =
            new BukkitConfigs("reports.yml");

    private static final List<Report> reports = new ArrayList<>();

    public static List<Report> getReports() {
        return reports;
    }

    public static void saveReports(){
        config.remove("reports");
        int id = 1;
        for (Report report : reports){
            ConfigurationSection secao = config.create("reports.report-"+id);
            report.save(secao);
            id++;
        }
        config.saveConfig();
    }
    public static void reloadReports(){
        config.reloadConfig();
        reports.clear();
        for (String chave : config.getSection("reports").getKeys(false)){
            ConfigurationSection secao = config.getSection("reports."+chave);
            Report reportNovo = new Report();
            reportNovo.reload(secao);
            reports.add(reportNovo);


        }



    }


    public void save(ConfigurationSection section){
        section.set("reporterPlayer" , reporterPlayer);
        section.set("reportedPlayer" , reportedPlayer);
        section.set("cause" , cause);
        section.set("time" , time);
        section.set("verified" , verified);
        section.set("verifierPlayer" , verifierPlayer);
    }
    public void reload(ConfigurationSection section){
        this.reportedPlayer = section.getString("reporterPlayer");
        this.reportedPlayer = section.getString("reportedPlayer");
        this.cause = section.getString("cause");
        this.time = section.getLong("time");
        this.verified = section.getBoolean("verified");
        this.verifierPlayer = section.getString("verifierPlayer");
    }


    private String reporterPlayer;
    private String reportedPlayer;
    private String cause;
    private long time;
    private boolean verified;
    private String verifierPlayer;


    public String getReporterPlayer() {
        return reporterPlayer;
    }

    public void setReporterPlayer(String reporterPlayer) {
        this.reporterPlayer = reporterPlayer;
    }

    public String getReportedPlayer() {
        return reportedPlayer;
    }

    public void setReportedPlayer(String reportedPlayer) {
        this.reportedPlayer = reportedPlayer;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public String getVerifierPlayer() {
        return verifierPlayer;
    }

    public void setVerifierPlayer(String verifierPlayer) {
        this.verifierPlayer = verifierPlayer;
    }
}
