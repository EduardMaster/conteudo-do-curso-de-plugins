package net.eduard.curso.outros;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Tutorial extends JavaPlugin {

	public void onEnable() {

		Bukkit.getConsoleSender().sendMessage("§aPlugin ativado");
	}

	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("§cPlugin desativado");
	}

	public void autoMensageiro(JavaPlugin plugin) {
		String mensagem = "§6Que mensagem foda!";
		// A cada 10 segundos | 20 ticks vezes 10 = 20 segundos
		int tempoQueRepete = 20 * 10;
		// Nosso repetidor
		new BukkitRunnable() {

			@Override
			public void run() {
				Bukkit.broadcastMessage(mensagem);
			}
		}.runTaskTimer(plugin, tempoQueRepete, tempoQueRepete);
	}
	/**
	 * 277:0-1,0-1;1-1,
	 */
	@SuppressWarnings({ "unused", "null", "deprecation" })
	public void reloadItens() {
		FileConfiguration config = getConfig();

		ConfigurationSection itensSecao = config.getConfigurationSection("kits");
		// for ( String kitNome : itensSecao.getKeys(false)) {

		List<String> itens = itensSecao.getStringList("nomekit");

		for (String conteudo : itens) {
			if (conteudo.contains(",")) {
				String[] splitInicial = conteudo.split(",");

				String itemInfo = splitInicial[0];

				String encantamentos = splitInicial[1];

				ItemStack item = null;

				if (encantamentos.contains(";")) {

					String[] splitEncantamentos = encantamentos.split(";");

					for (String encantamento : splitEncantamentos) {

						String[] splitEncantamento = encantamento.split("-");

						Enchantment ench = Enchantment.getById(Integer.valueOf(splitEncantamento[0]));
						Integer level = Integer.valueOf(splitEncantamento[1]);
						item.addUnsafeEnchantment(ench, level);

					}

				}
			}
			//additem
		}

		// }

	}

	public void configuracaoPadrao() {
		FileConfiguration config = getConfig();
		// teste do plugin: Sistema de nomeclatura de mensagem/op§§o
		// Teste do Plugin: Sistema de nomeclatura de mensagem/secao
		// teste-do-plugin: Sistema de nomeclatura de mensagem/op§§o
		// Teste-do-Plugin: Sistema de nomeclatura de mensagem/secao
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
