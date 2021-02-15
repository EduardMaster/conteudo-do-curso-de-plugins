
package net.eduard.curso;


import net.eduard.api.lib.config.BukkitConfigs;
import net.eduard.curso.projeto.login.ProjetoLogin;
import net.eduard.curso.projeto.minion.ProjetoMinion;
import net.eduard.curso.projeto.report.*;
import net.eduard.curso.projeto.tag.ProjetoTags;
import net.eduard.curso.sistemas.SistemaScoreboard;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;


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

        new SistemaScoreboard();



        new ProjetoMinion();
        new ProjetoLogin();
        new ProjetoReport();
        new ProjetoTags();


        for (Sistema sistema : Sistema.getSistemas()){
            sistema.onEnable();
        }

        for (Projeto projeto : Projeto.getProjetos()){
            projeto.onEnable();
        }

    }



    public void onDisable() {

        for (Projeto projeto : Projeto.getProjetos()){
            projeto.onDisable();
        }
        for (Sistema sistema : Sistema.getSistemas()){
            sistema.onDisable();
        }
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Plugin desativado do curso");
        Sistema.getSistemas().clear();
        Projeto.getProjetos().clear();
    }

}
