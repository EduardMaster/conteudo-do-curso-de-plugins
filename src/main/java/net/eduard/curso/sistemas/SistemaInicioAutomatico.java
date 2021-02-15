package net.eduard.curso.sistemas;

import net.eduard.curso.Sistema;

import java.util.Calendar;

public class SistemaInicioAutomatico extends Sistema {



    public static int diaDaSemana = 5;
    public static int horarioDoDia = 12;
    public static int minutoDaHora = 30;

    public static void start(){

    }

    @Override
    public void onEnable() {
        registerAsyncTimer(20,20);
    }

    @Override
    public void onDisable() {

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
