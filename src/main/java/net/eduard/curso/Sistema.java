package net.eduard.curso;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Sistema extends BukkitRunnable implements Listener, CommandExecutor, TabCompleter {
    public Sistema(){
        sistemas.add(this);
    }
    private static final Set<Sistema> sistemas= new HashSet<>();

    public static Set<Sistema> getSistemas() {
        return sistemas;
    }


    public abstract void onEnable();

    public abstract void onDisable();

    public void registerEvents() {
        Bukkit.getPluginManager().registerEvents(this, Curso.getInstance());
    }

    public void registerCommand(String name) {
        Curso.getInstance().getCommand(name).setExecutor(this);
    }
    public void registerTabcompleter(String name) {
        Curso.getInstance().getCommand(name).setTabCompleter(this);
    }
    public void registerAsyncTimer(long startDelay, long cycleTicks) {
        this.runTaskTimerAsynchronously(Curso.getInstance(), startDelay, cycleTicks);
    }

    public void registerTimer(long startDelay, long cycleTicks) {
        this.runTaskTimer(Curso.getInstance(), startDelay, cycleTicks);
    }

    public void registerDelay(long delayTicks) {
        this.runTaskLater(Curso.getInstance(), delayTicks);
    }

    public void registerAsyncDelay(long delayTicks) {
        this.runTaskLaterAsynchronously(Curso.getInstance(), delayTicks);
    }

    public void unregisterEvents(){
        HandlerList.unregisterAll(this);
    }


    @Override
    public void run() {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return null;
    }

    public JavaPlugin getPlugin() {
        return Curso.getInstance();
    }

}
