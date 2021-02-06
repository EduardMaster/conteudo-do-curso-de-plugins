package net.eduard.curso.util;

import net.eduard.curso.Curso;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigExtras {
    public void configuracaoPadrao() {
        FileConfiguration config = Curso.getInstance(). getConfig();

        config.set("ALGO_NA_CONFIG", 1);
        config.set("algo_na_config", 1);
        config.set("AlgoNaConfig", 1);
        config.set("algoNaConfig", 1);
        config.set("algo-na-config", 1);
        config.set("algo na config", 1);
        config.set("Algo na Config", 1);
        config.set("Algo-na-Config", 1);
        config.set("$player", 1);
        config.set("$player$", 1);
        config.set("<player>", 1);
        config.set("%player%", 1);
        config.set("%player", 1);
        config.set("@player@", 1);
        config.set("@player", 1);
        config.set("{player}", 1);
        config.set("[player]", 1);
        config.set("(player)", 1);
    }
    public void mensagensColoridas() {
        Bukkit.broadcastMessage("§6Tudo bem amo §evoces");
        Bukkit.broadcastMessage("§eTudo bem amo §6voces");
        Bukkit.broadcastMessage(" ");
        Bukkit.broadcastMessage("§2Tudo bem amo §avoces");
        Bukkit.broadcastMessage("§aTudo bem amo §2voces");
        Bukkit.broadcastMessage(" ");
        Bukkit.broadcastMessage("§dTudo bem amo §5voces");
        Bukkit.broadcastMessage("§5Tudo bem amo §dvoces");
        Bukkit.broadcastMessage(" ");
        Bukkit.broadcastMessage("§bTudo bem amo §3voces");
        Bukkit.broadcastMessage("§3Tudo bem amo §bvoces");
        Bukkit.broadcastMessage(" ");
        Bukkit.broadcastMessage("§8Tudo bem amo §7voces");
        Bukkit.broadcastMessage("§7Tudo bem amo §8voces");
        Bukkit.broadcastMessage(" ");
        Bukkit.broadcastMessage("§cTudo bem amo §4voces");
        Bukkit.broadcastMessage("§4Tudo bem amo §cvoces");
        Bukkit.broadcastMessage(" ");
        Bukkit.broadcastMessage("§1Tudo bem amo §9voces");
        Bukkit.broadcastMessage("§9Tudo bem amo §1voces");
        Bukkit.broadcastMessage(" ");
        Bukkit.broadcastMessage("§0Tudo bem amo §Fvoces");
        Bukkit.broadcastMessage("§FTudo bem amo §0voces");
    }


}
