package net.eduard.curso;

import net.md_5.bungee.api.plugin.Plugin;

public class CursoBungee  extends Plugin {


    private static CursoBungee instance;

    public static CursoBungee getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;


    }

    @Override
    public void onDisable() {

    }
}
