package net.eduard.curso;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;
import org.junit.internal.runners.statements.RunAfters;

public abstract class Projeto {

    public abstract void onEnable();
    public abstract void onDisable();
    public void reload(){

    }
    public void save(){

    }
    public void registerEvents(Listener listener){
        Bukkit.getPluginManager().registerEvents(listener , Curso.getInstance());
    }
    public void registerCommand(String name, CommandExecutor executor){
        Curso.getInstance().getCommand(name).setExecutor(executor);
    }
    public void registerAsyncTimer(BukkitRunnable runnable, long startDelay, long cycleTicks){
        runnable.runTaskTimerAsynchronously(Curso.getInstance(),startDelay,cycleTicks);
    }
    public void registerTimer(BukkitRunnable runnable, long startDelay, long cycleTicks){
        runnable.runTaskTimer(Curso.getInstance(),startDelay,cycleTicks);
    }
    public void registerDelay(BukkitRunnable runnable, long delayTicks){
        runnable.runTaskTimer(Curso.getInstance(),delayTicks);
    }

}

