
package net.eduard.curso;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import net.eduard.api.lib.BukkitConfig;
import net.eduard.curso.caixas.CaixaAPI;
import net.eduard.curso.economia.CoinsEventos;
import net.eduard.curso.economia.CoinsSQL;
import net.eduard.curso.economia.ComandoEconomia;
import net.eduard.curso.eventos.Eventos;
import net.eduard.curso.login.ComandoLogin;
import net.eduard.curso.login.ComandoRegister;
import net.eduard.curso.rankup.ComandoRankup;
import net.eduard.curso.rankup.RankAPI;
import net.eduard.curso.scoreboard.ScoreboardComDisplayboard;
import net.eduard.curso.spawn.ComandoSetSpawn;
import net.eduard.curso.spawn.ComandoSpawn;
import net.eduard.curso.spawn.SpawnEvents;
import net.eduard.curso.tempo.ComandoCooldown;
import net.eduard.curso.tempo.ComandoDelay;
import net.eduard.curso.tempo.ComandoTimer;
import net.eduard.curso.tempo.TimerBasico;
import net.eduard.curso.warp.ComandoDeleteWarp;
import net.eduard.curso.warp.ComandoSetWarp;
import net.eduard.curso.warp.ComandoWarps;
import net.eduard.curso.warp.MenuWarps;

/**
 * Classe principal na criação de plugin ela é uma extenção de
 * {@link JavaPlugin}<br>
 * <b>API</b> é o nome dado a um certo código ou métodos que facilitam a criação
 * de algo
 * 
 * @author Eduard
 *
 */
public class CursoEduard extends JavaPlugin {
	/**
	 * Instancia do Plugin (Básicamente guarda o plugin em uma variavel)
	 */
	private static CursoEduard instance;
	/**
	 * Config principal do Plugin feita usando api {@link BukkitConfig}
	 */
	private static BukkitConfig config;

	public static BukkitConfig getConfigs() {
		return config;
	}

	/**
	 * Evento de quando plugin é carregado
	 */
	public void onLoad() {

	}

	/**
	 * Evento de quando o plugin é ativado
	 */
	public void onEnable() {
		// iniciando a variavel instance
		instance = this;

		// iniciando a variavel config com uma nova config chamada 'config.yml' e
		// salvada na pasta deste plugin
		config = new BukkitConfig("config.yml", this);
		new TimerBasico().ligar(this);

		
		getCommand("login").setExecutor(new ComandoLogin());
		getCommand("register").setExecutor(new ComandoRegister());
		getCommand("delay").setExecutor(new ComandoDelay());
		getCommand("cooldown").setExecutor(new ComandoCooldown());
		getCommand("timer").setExecutor(new ComandoTimer());
		getCommand("delwarp").setExecutor(new ComandoDeleteWarp());
		getCommand("setwarp").setExecutor(new ComandoSetWarp());
		getCommand("warp").setExecutor(new ComandoDeleteWarp());
		getCommand("warps").setExecutor(new ComandoWarps());
		Bukkit.getPluginManager().registerEvents(new MenuWarps(), this);
		ScoreboardComDisplayboard.ligar(this);
		CaixaAPI.reload();
		getCommand("money").setExecutor(new ComandoEconomia());
		CoinsSQL.abrirConexao();
		CoinsSQL.criarTabelaContas();
		Bukkit.getPluginManager().registerEvents(new CoinsEventos(), this);
		getCommand("setspawn").setExecutor(new ComandoSetSpawn());
		getCommand("spawn").setExecutor(new ComandoSpawn());
		getCommand("rank").setExecutor(new ComandoRankup());
		RankAPI.reload();
		new SpawnEvents().register(this);
		ScoreboardComDisplayboard.ligar(this);
		Bukkit.getPluginManager().registerEvents(new Eventos(), this);
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Plugin ativado do curso");
	}

	public void onDisable() {
		CaixaAPI.save();
		RankAPI.save();
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Plugin desativado do curso");
	}

	/**
	 * Método que retorna a instancia do Plugin
	 * 
	 * @return o Plugin
	 */
	public static CursoEduard getInstance() {
		return instance;
	}

}
