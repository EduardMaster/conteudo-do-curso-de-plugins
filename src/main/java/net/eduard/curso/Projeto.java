package net.eduard.curso;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

public abstract class Projeto {

    public abstract void onEnable();
    public abstract void onDisable();
    public void registerEvents(Listener listener){
        Bukkit.getPluginManager().registerEvents(listener , Curso.getInstance());
    }
    public void registerCommand(String name, CommandExecutor executor){
        Curso.getInstance().getCommand(name).setExecutor(executor);
    }


}

