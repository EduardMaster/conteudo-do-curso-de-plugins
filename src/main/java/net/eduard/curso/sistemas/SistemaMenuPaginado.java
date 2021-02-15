package net.eduard.curso.sistemas;

import java.util.Arrays;

import net.eduard.curso.Sistema;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class SistemaMenuPaginado extends Sistema {

    @Override
    public void onEnable() {
        registerEvents();
    }

    @Override
    public void onDisable() {

    }

    @EventHandler
    public void aoClicar(PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_AIR) {
            if (e.getMaterial() == Material.DIAMOND) {
                abrirPagina(e.getPlayer(), 1);
            }
        }

    }

    public SistemaMenuPaginado() {
        items[11] = new ItemStack(Material.DIAMOND, 64);
    }

    @EventHandler
    public void controleDasPaginas(InventoryClickEvent e) {
        if (!(e.getWhoClicked() instanceof Player)) return;
        Player p = (Player) e.getWhoClicked();
        if (!e.getInventory().getName().startsWith("Pag ")) return;
        Integer pagina = Integer.valueOf(
                e.getInventory().getName().replace("Pag ", ""));
        if (pagina == 1) {
            e.setCancelled(true);
            p.sendMessage("§cBloqueado!");
        }


    }

    private ItemStack[] items = new ItemStack[6 * 9 * 10];

    public void abrirPagina(Player player, int page) {
        Inventory inventory = Bukkit.createInventory(null, 6 * 9,
                "Pag " + page);

        int min = (page * 1) - 1;
        int max = min + (6 * 9) - 1;
        ItemStack[] conteudo = Arrays.copyOfRange(items, min, max);
        inventory.setContents(conteudo);
        player.openInventory(inventory);
    }

}
