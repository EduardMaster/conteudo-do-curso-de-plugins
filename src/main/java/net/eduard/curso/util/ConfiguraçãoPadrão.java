package net.eduard.curso.util;

import net.eduard.curso.Curso;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfiguraçãoPadrão {
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
}
