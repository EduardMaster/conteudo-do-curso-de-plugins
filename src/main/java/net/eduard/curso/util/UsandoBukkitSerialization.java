package net.eduard.curso.util;

import net.eduard.api.lib.modules.Mine;
import net.eduard.curso.Curso;
import net.eduard.curso.sistemas.TutorialBukkitSearialization;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.io.File;

public class UsandoBukkitSerialization {
    public void usandoBukkitSerialization() {
        File arquivo = new File(Curso.getInstance().getDataFolder(), "items.db");
        ItemStack itemEncantado = Mine.newItem(Material.DIAMOND_SWORD, "§aEspada longa", 1, 0, "Lorezita");
        itemEncantado.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 10);

        try {
            TutorialBukkitSearialization.salvarItems(arquivo, itemEncantado);
        } catch (Exception e) {


            e.printStackTrace();
        }
        try {
            ItemStack[] dadosLidos = TutorialBukkitSearialization.restaurarItems(arquivo);
            System.out.println("Item retornado " + dadosLidos[0]);

        } catch (Exception e) {

            e.printStackTrace();
        }

    }
}
