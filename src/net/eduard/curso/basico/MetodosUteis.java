package net.eduard.curso.basico;

import java.util.Random;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import net.eduard.api.util.particle.ParticleEffect;

public class MetodosUteis {
	public static ItemStack pegarItemAleatorio(ItemStack... itens) {

		return itens[new Random().nextInt(itens.length - 1)];
	}

	public static void fazerEfeito(Player player) {
		ParticleEffect.displayBlockCrack(player.getLocation(), 1, (byte) 0, 0, 0, 0, 10);
	}

	public static void fazerEfeito2(Player player) {
		ParticleEffect.displayBlockCrack(player.getLocation(), 2, (byte) 0, 2, 3, 3, 10);
	}

	public static void fazerEfeito3(Player player) {
		ParticleEffect.ANGRY_VILLAGER.display(player.getLocation(), 1, 1, 1, 0.5F, 15);
	}
}
