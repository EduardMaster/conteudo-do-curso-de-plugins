package net.eduard.curso.sistemas.com_eventos;

import java.util.Map.Entry;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;


public class JuntarEncantamento implements Listener {
    @SuppressWarnings("deprecation")
    @EventHandler
    public void enchantItem(InventoryClickEvent e) {
        if (!(e.getWhoClicked() instanceof Player)) return;
        if (e.getCursor() == null) return;
        if (e.getCursor().getType() != Material.ENCHANTED_BOOK) return;
        if (e.getCurrentItem() == null)
            return;
        if (e.getCurrentItem().getType() == Material.AIR)
            return;
        if (e.getCurrentItem().getType() == Material.ENCHANTED_BOOK) {
            EnchantmentStorageMeta meta1 = (EnchantmentStorageMeta) e.getCursor().getItemMeta();
            EnchantmentStorageMeta meta2 = (EnchantmentStorageMeta) e.getCurrentItem().getItemMeta();
            for (Entry<Enchantment, Integer> enchant : meta1.getStoredEnchants().entrySet()) {
                meta2.addStoredEnchant(enchant.getKey(), enchant.getValue(), true);
            }

            ItemStack clone = e.getCurrentItem();
            clone.setItemMeta(meta2);
            e.setCurrentItem(clone);
            e.setCursor(null);
            e.setCancelled(true);

        }else {
            EnchantmentStorageMeta meta = (EnchantmentStorageMeta) e.getCursor().getItemMeta();
            ItemStack clone = e.getCurrentItem();
            clone.addUnsafeEnchantments(meta.getStoredEnchants());
            e.setCurrentItem(clone);
            e.setCursor(null);
            e.setCancelled(true);
        }

    }
}
