
package net.eduard.curso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import net.eduard.curso.entidades.MobsAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import net.eduard.api.lib.BukkitConfig;
import net.eduard.api.lib.Mine;
import net.eduard.curso.util.TutorialBukkitSearialization;

/**
 * Classe principal na criação de plugin ela é uma extenção de
 * {@link JavaPlugin}<br>
 * <b>API</b> é o nome dado a um certo código ou métodos que facilitam a criação
 * de algo
 * 
 * @author Eduard
 *
 */
public class Main extends JavaPlugin {
	/**
	 * Instancia do Plugin (Básicamente guarda o plugin em uma variavel)
	 */
	private static Main instance;
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
		MobsAPI.loadMobs();
//		TutorialCraftSimples.craftEspadaLonga();
//		TutorialCraftSimples.craftEspadaCurta();
//		usandoBukkitSerialization();
//
//		// iniciando a variavel config com uma nova config chamada 'config.yml' e
//		// salvada na pasta deste plugin
//		config = new BukkitConfig("config.yml", this);
////		new TimerBasico().ligar(this);
//		Bukkit.getPluginManager().registerEvents(new EditarDefesa(), this);
//		getCommand("cooldown1").setExecutor(new CooldownBasico());
//		getCommand("cooldown2").setExecutor(new CooldownIntermediario());
//		Bukkit.getPluginManager().registerEvents(new PegarDropsAutomaticoDeMineracao(), this);

//
//		
//		getCommand("login").setExecutor(new ComandoLogin());
//		getCommand("register").setExecutor(new ComandoRegister());
//		getCommand("delay").setExecutor(new ComandoDelay());
//		getCommand("cooldown").setExecutor(new ComandoCooldown());
//		getCommand("timer").setExecutor(new ComandoTimer());
//		getCommand("delwarp").setExecutor(new ComandoDeleteWarp());
//		getCommand("setwarp").setExecutor(new ComandoSetWarp());
//		getCommand("warp").setExecutor(new ComandoDeleteWarp());
//		getCommand("warps").setExecutor(new ComandoWarps());
//		Bukkit.getPluginManager().registerEvents(new MenuWarps(), this);
//		ScoreboardComDisplayboard.ligar(this);
//		CaixaAPI.reload();
//		getCommand("money").setExecutor(new ComandoEconomia());
//		CoinsSQL.abrirConexao();
//		CoinsSQL.criarTabelaContas();
//		Bukkit.getPluginManager().registerEvents(new CoinsEventos(), this);
//		getCommand("setspawn").setExecutor(new ComandoSetSpawn());
//		getCommand("spawn").setExecutor(new ComandoSpawn());
//		getCommand("rank").setExecutor(new ComandoRankup());
//		RankAPI.reload();
//		new SpawnEvents().register(this);
//		ScoreboardComDisplayboard.ligar(this);
//		Bukkit.getPluginManager().registerEvents(new Eventos(), this);
//		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Plugin ativado do curso");
	}
	public void usandoBukkitSerialization() {
		File arquivo = new File(getDataFolder(),"items.db");
		ItemStack itemEncantado = Mine.newItem(Material.DIAMOND_SWORD, "§aEspada longa",1,0,"Lorezita");
		itemEncantado.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 10);
		
		try {
			TutorialBukkitSearialization.salvarItems(arquivo,  itemEncantado);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ItemStack[] dadosLidos = TutorialBukkitSearialization.restaurarItems(arquivo);
			System.out.println("Item retornado "+dadosLidos[0]);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * Registra uma classe com Eventos
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

	/**
	 * Método que retorna a instancia do Plugin
	 * 
	 * @return o Plugin
	 */
	public static Main getInstance() {
		return instance;
	}
	
	public void configuracaoPadrao() {
		FileConfiguration config = getConfig();
		// teste do plugin: Sistema de nomeclatura de mensagem/op§§o
		// net.eduard.api.Teste do Plugin: Sistema de nomeclatura de mensagem/secao
		// teste-do-plugin: Sistema de nomeclatura de mensagem/op§§o
		// net.eduard.api.Teste-do-Plugin: Sistema de nomeclatura de mensagem/secao
		// TesteDoPlugin: Sistema de nomeclatura de classe
		// testeDoPlugin: Sistema de nomeclatura de variavel/pacote
		// teste_do_plugin: Sistema de nomeclatura de variavel/pacote
		// Teste_do_Plugin: Sistema de nomeclatura de variavel
		config.set("ALGO_NA_CONFIG", 1);
		config.set("algo_na_config", 1);
		config.set("AlgoNaConfig", 1);
		config.set("algoNaConfig", 1);
		config.set("algo-na-config", 1);
		config.set("algo na config", 1);
		config.set("Algo na Config", 1);
		config.set("Algo-na-Config", 1);
		config.set("$player", 1);
		config.set("$player$", 1);
		config.set("<player>", 1);
		config.set("%player%", 1);
		config.set("%player", 1);
		config.set("@player@", 1);
		config.set("@player", 1);
		config.set("{player}", 1);
		config.set("[player]", 1);
		config.set("(player)", 1);
	}


	public void mensagensColoridas() {
		Bukkit.broadcastMessage("§6Tudo bem amo §evoces");
		Bukkit.broadcastMessage("§eTudo bem amo §6voces");
		Bukkit.broadcastMessage(" ");
		Bukkit.broadcastMessage("§2Tudo bem amo §avoces");
		Bukkit.broadcastMessage("§aTudo bem amo §2voces");
		Bukkit.broadcastMessage(" ");
		Bukkit.broadcastMessage("§dTudo bem amo §5voces");
		Bukkit.broadcastMessage("§5Tudo bem amo §dvoces");
		Bukkit.broadcastMessage(" ");
		Bukkit.broadcastMessage("§bTudo bem amo §3voces");
		Bukkit.broadcastMessage("§3Tudo bem amo §bvoces");
		Bukkit.broadcastMessage(" ");
		Bukkit.broadcastMessage("§8Tudo bem amo §7voces");
		Bukkit.broadcastMessage("§7Tudo bem amo §8voces");
		Bukkit.broadcastMessage(" ");
		Bukkit.broadcastMessage("§cTudo bem amo §4voces");
		Bukkit.broadcastMessage("§4Tudo bem amo §cvoces");
		Bukkit.broadcastMessage(" ");
		Bukkit.broadcastMessage("§1Tudo bem amo §9voces");
		Bukkit.broadcastMessage("§9Tudo bem amo §1voces");
		Bukkit.broadcastMessage(" ");
		Bukkit.broadcastMessage("§0Tudo bem amo §Fvoces");
		Bukkit.broadcastMessage("§FTudo bem amo §0voces");
	}
}
