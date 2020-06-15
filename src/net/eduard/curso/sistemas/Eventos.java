package net.eduard.curso.sistemas;

import java.util.Arrays;
import java.util.Random;

import net.eduard.api.lib.game.EnchantGlow;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;

import net.eduard.api.lib.modules.Mine;
import net.eduard.api.lib.modules.VaultAPI;


/**
 * Esta classe contem eventos alterados de varios tipos e comentados
 * 
 * @author Eduard
 *
 */

public class Eventos implements Listener {

	@EventHandler
	public void event(ServerListPingEvent e) {
		e.setMotd("Linha 1\n linha2");
	}

	@EventHandler
	public void event(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		if (!p.hasPermission("permissao.de.colocar")) {
			e.setCancelled(true);
		}

	}

	@EventHandler
	public void event(BlockBreakEvent e) {

		Player p = e.getPlayer();
		e.setCancelled(true);
		if (p.getGameMode() == GameMode.CREATIVE && p.hasPermission("permissao.de.quebrar")) {
			e.setCancelled(false);
		}
		e.setExpToDrop(3);
	}

	/**
	 * Remover a chuva
	 * 
	 * @author Eduard
	 *
	 */
	@EventHandler
	public void removerChuva(WeatherChangeEvent e) {
		// verificar se vai chover
		if (e.toWeatherState()) {

			// canvela a chuva
			e.setCancelled(true);
		}
	}

	/**
	 * Fazer a bedrock ser quebravel
	 * 
	 * @author Eduard
	 *
	 */
	@EventHandler
	public void event(BlockDamageEvent e) {
		if (e.getBlock().getType() == Material.BEDROCK) {
			Player p = e.getPlayer();
			if (p.getItemInHand() != null) {
				if (p.getItemInHand().getType().name().contains("PICKAXE")) {
					if (p.getItemInHand().containsEnchantment(Enchantment.SILK_TOUCH)) {
						e.setInstaBreak(true);
					}
				}
			}
		}
	}

	/**
	 * Ao fazer um comando qualquer será feito um som expecifico
	 * 
	 * @author Eduard
	 *
	 */
	@EventHandler
	public void aplicarSomQuandoQualquerComandoForFeitoPeloJogador(PlayerCommandPreprocessEvent e) {
		e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.NOTE_PLING, 5.0F, 5.0F);

	}

	/**
	 * Remover a fome e restaurar ela pra o Inicio
	 * 
	 * @author Eduard
	 *
	 */
	public class RemoverFome implements Listener {
		@EventHandler
		public void removerFome(FoodLevelChangeEvent e) {
			if (e.getEntity() instanceof Player) {
				Player p = (Player) e.getEntity();
				e.setFoodLevel(20);
				p.setSaturation(20);
				p.setExhaustion(0);
			}
		}
	}

	/**
	 * MOTD significa Mensagem de entrada do servidor quando atulizamos a lista de
	 * servidores aparece uma mensagem de 2 linhas
	 * 
	 * @author Eduard
	 *
	 */

	public class EditarMotd implements Listener {

		@EventHandler
		public void aoVerMOTD(ServerListPingEvent e) {
			e.setMotd("§6Parabens Por Jogar Primeira linha\n§bAQUI Segunda Linha");
		}
	}

	// ganhar um item ao entrar
	@EventHandler
	public void event(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		@SuppressWarnings("deprecation")
		ItemStack item = new ItemStack(19);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("titulo");
		meta.setLore(Arrays.asList("linha1"));
		item.setItemMeta(meta);
		EnchantGlow.addGlow(item);
		p.getInventory().addItem(item);
		// criar uma cabeça de um jogador
		p.getInventory().addItem(Mine.newHead("Display", "EduardKIllerPro", 1, Arrays.asList("linha1")));
	}

	// fazer efeitos por um item
	@EventHandler
	public void efeitosEmGeral(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		@SuppressWarnings("deprecation")
		ItemStack item = new ItemStack(19);
		ItemMeta meta1 = item.getItemMeta();
		meta1.setDisplayName("titulo");
		meta1.setLore(Arrays.asList("linha1"));
		item.setItemMeta(meta1);
		EnchantGlow.addGlow(item);
		if (e.getAction() == Action.RIGHT_CLICK_AIR | e.getAction() == Action.RIGHT_CLICK_BLOCK) {

			if (e.getMaterial() == Material.AIR)
				return;
			if (e.getItem().isSimilar(item)) {

				// Se o item tiver efeito proprio fazer este comando abaixo
				e.setCancelled(true);
				Mine.remove(p.getInventory(), item, 1);

				// tocar um som
				p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 2, 1);

				{
					// criar o fogo de artificio
					Firework fire = (Firework) p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);

					// pegar meta
					FireworkMeta meta = fire.getFireworkMeta();

					// setar distancia de voo
					meta.setPower(5);

					// adicionar um efeito
					meta.addEffect(FireworkEffect.builder().trail(true).flicker(true).with(Type.BALL)
							.withColor(Color.GREEN).withFade(Color.OLIVE).build());

					// setar meta
					fire.setFireworkMeta(meta);

				}

				// aqui vai o efeito
				// fazer comando
				p.chat("/comando");

				// mandar mensagem
				p.sendMessage("");

				// dar um item
				p.getInventory().addItem(new ItemStack(Material.DIAMOND, 64));

				// setar um item em uma posi§§o
				p.getInventory().setItem(Mine.getPosition(1, 5), new ItemStack(Material.GOLD_INGOT, 64));

				// dar dinheiro
				double quantidade = 300;
				VaultAPI.getEconomy().bankDeposit(p.getName(), quantidade);

				// tirar dinheiro
				VaultAPI.getEconomy().bankWithdraw(p.getName(), quantidade);

				// dar teleporte em um local
				p.teleport(new Location(p.getWorld(), 1500, 300, 1500));

				// dar teleporte em um mundo diferente
				p.teleport(new Location(Bukkit.getWorld("nomedomundo"), 1500, 300, 1500));

				// efeito por pocertagem
				int porcentagem = 25;
				if (Math.random() <= porcentagem / 100) {

					// efeito

				}

				// quantidades aleatorias de qualquer coisa
				int random = 5 + new Random().nextInt(10);
				ItemStack item2 = new ItemStack(Material.EMERALD, random);
				p.getInventory().addItem(item2);

				// encher o inventario de algum item
				Mine.fill(p.getInventory(), new ItemStack(Material.MUSHROOM_SOUP));

			}
		}

	}

}
