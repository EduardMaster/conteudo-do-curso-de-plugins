package net.eduard.curso.sistemas.com_tempo;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Calendar;

public class InicioAutomatico extends BukkitRunnable {


    public InicioAutomatico(JavaPlugin plugin){
        runTaskTimerAsynchronously(plugin, 20,20);
    }

    public static int diaDaSemana = 5;
    public static int horarioDoDia = 12;
    public static int minutoDaHora = 30;

    public static void start(){

    }

    @Override
    public void run() {
        Calendar calendar = Calendar.getInstance();
        if (calendar.get(Calendar.DAY_OF_WEEK) != diaDaSemana)return;
        if (calendar.get(Calendar.HOUR_OF_DAY)!= horarioDoDia)return;
        if (calendar.get(Calendar.MINUTE) != minutoDaHora)return;

        // executo
        start();



    }
}
