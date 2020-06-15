package net.eduard.curso.projeto.essentials;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.bukkit.inventory.ItemStack;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;
/**
 * Tutorial básico de como usar a serialização Bukkit para salvar e restaurar items
 * @author Eduard
 *
 */
public class TutorialBukkitSearialization {

	public static void salvarItems(File arquivo, ItemStack... items) throws FileNotFoundException, IOException {

		BukkitObjectOutputStream armazenar = new BukkitObjectOutputStream(new FileOutputStream(arquivo));
		armazenar.writeObject(items);
		armazenar.close();
	}

	public static ItemStack[] restaurarItems(File arquivo) throws ClassNotFoundException, IOException {
		ItemStack[] items = null;
		BukkitObjectInputStream restaurador = new BukkitObjectInputStream(new FileInputStream(arquivo));
		items = (ItemStack[]) restaurador.readObject();
		restaurador.close();
		return items;
	}

}
