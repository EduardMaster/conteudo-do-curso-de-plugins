package net.eduard.curso.sistemas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import net.eduard.curso.Curso;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;

/**
 * Tutorial básico de como usar a serialização Bukkit para salvar e restaurar items
 *
 * @author Eduard
 */
public class UsarBukkitSearialization {
    /**
     * Exemplo
     */
    public static void usandoBukkitSerialization() {
        File arquivo = new File(Curso.getInstance().getDataFolder(), "items.db");
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aEspada longa");
        meta.setLore(Arrays.asList("Lorezita"));
		item.setItemMeta(meta);

        item.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 10);

        try {
            salvarItems(arquivo, item);
        } catch (Exception e) {

            e.printStackTrace();
        }
        try {
            ItemStack[] dadosLidos = restaurarItems(arquivo);
            System.out.println("Item retornado " + dadosLidos[0]);

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

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
