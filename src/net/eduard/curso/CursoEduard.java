
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
import net.eduard.curso.outros.SimplesScore;
import net.eduard.curso.rankup.ComandoRankup;
import net.eduard.curso.rankup.RankAPI;
import net.eduard.curso.spawn.ComandoSetSpawn;
import net.eduard.curso.spawn.ComandoSpawn;
import net.eduard.curso.spawn.SpawnEvents;
import net.eduard.curso.tempo.ComandoCooldown;
import net.eduard.curso.tempo.ComandoDelay;
import net.eduard.curso.tempo.ComandoTimer;
import net.eduard.curso.warp.ComandoDeleteWarp;
import net.eduard.curso.warp.ComandoSetWarp;
import net.eduard.curso.warp.ComandoWarps;
import net.eduard.curso.warp.MenuWarps;

public class CursoEduard extends JavaPlugin {
	private static CursoEduard instance;
	private static BukkitConfig config;

	public static BukkitConfig getConfigs() {
		return config;
	}

	public void onEnable() {
		instance = this;
		config = new BukkitConfig("config.yml", this);

		basico();
		spawn();
		tempo();
		economia();
		eventos();

		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Plugin ativado do curso");
	}
	public void eventos() {
		Bukkit.getPluginManager().registerEvents(new MenuWarps() , this);
	}

	public void rankup() {
		getCommand("rank").setExecutor(new ComandoRankup());
		RankAPI.reload();
	}

	public void basico() {

		Bukkit.getPluginManager().registerEvents(new Eventos(), this);
	}

	public void login() {
		getCommand("login").setExecutor(new ComandoLogin());
		getCommand("register").setExecutor(new ComandoRegister());
	}

	public void tempo() {
		getCommand("delay").setExecutor(new ComandoDelay());
		getCommand("cooldown").setExecutor(new ComandoCooldown());
		getCommand("timer").setExecutor(new ComandoTimer());
	}

	public void spawn() {
		getCommand("setspawn").setExecutor(new ComandoSetSpawn());
		getCommand("spawn").setExecutor(new ComandoSpawn());
		new SpawnEvents().register(this);
	}

	public void warps() {
		getCommand("delwarp").setExecutor(new ComandoDeleteWarp());
		getCommand("setwarp").setExecutor(new ComandoSetWarp());
		getCommand("warp").setExecutor(new ComandoDeleteWarp());
		getCommand("warps").setExecutor(new ComandoWarps());
	}
	public void economia() {
		getCommand("money").setExecutor(new ComandoEconomia());
		CoinsSQL.abrirConexao();
		CoinsSQL.criarTabelaContas();
		Bukkit.getPluginManager().registerEvents(new CoinsEventos(), this);
	}

	public void extras() {
		
		SimplesScore.ligar(this);
		CaixaAPI.reload();
	}

	public void onDisable() {
		CaixaAPI.save();
		RankAPI.save();
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Plugin desativado do curso");
	}

	public static CursoEduard getInstance() {
		return instance;
	}

}
