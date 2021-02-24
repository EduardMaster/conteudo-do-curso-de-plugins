package net.eduard.curso;

import org.bukkit.configuration.ConfigurationSection;

public interface DadoConfig {

     void save(ConfigurationSection section);
     void reload(ConfigurationSection section);
}
