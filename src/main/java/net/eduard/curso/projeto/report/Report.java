package net.eduard.curso.projeto.report;

import net.eduard.curso.ConfigData;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Report implements ConfigData {

    private static SimpleDateFormat formatador =
            new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

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

    public ItemStack getIcon(){
        String horarioFormatado = formatador.format(time);
        ItemStack item = new ItemStack(Material.SKULL_ITEM,1,(short)3);
        SkullMeta meta = (SkullMeta) item.getItemMeta();
        meta.setDisplayName("§a"+reportedPlayer);
        List<String> lore = new ArrayList<>();

        meta.setOwner(reportedPlayer);

        lore.add("");
        lore.add("§7Reportador: §e"+reporterPlayer);
        lore.add("§7Horario: §f"+ horarioFormatado);
        lore.add("§7Motivo: §c"+cause);
        lore.add("");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }


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
