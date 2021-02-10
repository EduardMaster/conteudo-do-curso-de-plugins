package net.eduard.curso;

import org.bukkit.configuration.ConfigurationSection;

public interface ConfigData {

    void save(ConfigurationSection section);

    void reload(ConfigurationSection section);


}
