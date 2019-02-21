package net.eduard.curso.basico;

import org.bukkit.Material;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

@SuppressWarnings("deprecation")
public class MetodosBasicosDeBukkit {

	public static void criarMundo(String nome) {
		WorldCreator m = new WorldCreator(nome);
		m.createWorld();
	}

	public static void darLivro(Player player, String autor, String titulo, String... paginas) {

		ItemStack item = new ItemStack(Material.WRITTEN_BOOK);
		BookMeta meta = (BookMeta) item.getItemMeta();
		meta.setAuthor(autor);
		meta.setTitle(titulo);
		meta.setPages(paginas);
		item.setItemMeta(meta);
		player.getInventory().addItem(item);

	}

	public static void darPocao(Player p, int quantidade, PotionType pocao, int nivel, boolean tempoExtendido,
			boolean pocaoJogavel) {

//		ItemStack item = new Potion(PotionType.FIRE_RESISTANCE, 1,false,true).toItemStack(5);
		p.getInventory().addItem(new Potion(pocao, nivel, pocaoJogavel, tempoExtendido).toItemStack(quantidade));
	}
}
