
package net.eduard.curso;


import net.eduard.api.lib.config.BukkitConfigs;
import net.eduard.curso.projeto.login.ComandoLogin;
import net.eduard.curso.projeto.login.ComandoRegister;
import net.eduard.curso.projeto.login.LoginSystem;
import net.eduard.curso.projeto.report.ComandoReport;
import net.eduard.curso.projeto.report.ComandoReports;
import net.eduard.curso.projeto.report.MenuReports;
import net.eduard.curso.projeto.report.Report;
import net.eduard.curso.projeto.tag.PlayerTagUpdater;
import net.eduard.curso.sistemas.com_tempo.InicioAutomatico;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import net.eduard.api.lib.config.BukkitConfig;

/**
 * Classe principal na criação de plugin ela é uma extenção de
 * {@link JavaPlugin}<br>
 * <b>API</b> é o nome dado a um certo código ou métodos que facilitam a criação
 * de algo
 *
 * @author Eduard
 */
public class Curso extends JavaPlugin {
    /**
     * Instancia do Plugin (Básicamente guarda o plugin em uma variavel)
     */
    private static Curso instance;
    /**
     * Método que retorna a instancia do Plugin
     *
     * @return o Plugin
     */
    public static Curso getInstance() {
        return instance;
    }

    /**
     * Config principal do Plugin feita usando api {@link BukkitConfig}
     */
    private static BukkitConfigs config;

    public static BukkitConfigs getConfigs() {
        return config;
    }



    /**
     * Evento de quando o plugin é ativado
     */
    public void onEnable() {
        // iniciando a variavel instance
        instance = this;
        getDataFolder().mkdirs();
        config = new BukkitConfigs("config.yml");

        new InicioAutomatico(this);
        getCommand("report").setExecutor(new ComandoReport());
        getCommand("reports").setExecutor(new ComandoReports());
        getCommand("register").setExecutor(new ComandoRegister());
        getCommand("login").setExecutor(new ComandoLogin());
        Bukkit.getPluginManager().registerEvents(new MenuReports() , this);
        new PlayerTagUpdater().runTaskTimerAsynchronously(this, 20 , 20);

        Report.reloadReports();
        LoginSystem.reload();

    }

    /**
     * Registra uma classe com Eventos
     *
     * @param classeComEventos Classe com Eventos
     */
    public void registrarEventos(Listener classeComEventos) {
        Bukkit.getPluginManager().registerEvents(classeComEventos, this);
    }

    public void onDisable() {
//		CaixaAPI.save();
//		RankAPI.save();
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Plugin desativado do curso");
    }




}
