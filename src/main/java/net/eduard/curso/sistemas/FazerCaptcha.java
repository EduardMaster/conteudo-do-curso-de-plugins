package net.eduard.curso.sistemas;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashSet;
import java.util.Set;


public class FazerCaptcha implements Listener {

    private final static ItemStack vidroVerde;
    private final static ItemStack vidroCinza;
    private final static String name = "Resolva";
    private static final Set<Player> players=  new HashSet<>();



    static {

        vidroVerde = new ItemStack(Material.STAINED_GLASS_PANE,
                1, (short) 3);
        {
            ItemMeta meta = vidroVerde.getItemMeta();
            meta.setDisplayName("");
            vidroVerde.setItemMeta(meta);
        }

        vidroCinza = new ItemStack(Material.STAINED_GLASS_PANE,
                1, (short) 11);
        {
            ItemMeta meta = vidroCinza.getItemMeta();
            meta.setDisplayName("");
            vidroVerde.setItemMeta(meta);
        }
    }

    @EventHandler
    public void join(PlayerJoinEvent event){
        players.add(event.getPlayer());
        open(event.getPlayer());
    }
    @EventHandler
    public void event(InventoryCloseEvent e){
        Player player = (Player) e.getPlayer();
        if (players.contains(player)){
            open(player);

        }
    }

    public static void open(Player player) {
        Inventory menu = Bukkit.createInventory(null, 6 * 9, name);
        for (int id = 0; id < menu.getSize(); id++) {
            if (Math.random() < 0.05) {
                menu.setItem(id, vidroVerde);
            } else {
                menu.setItem(id, vidroCinza);
            }
        }
        player.openInventory(menu);
    }

    public static boolean completouCaptcha(Inventory menu) {
        for (ItemStack item : menu.getContents()) {
            if (item == null) continue;
            if (item.equals(vidroVerde)) return false;
        }
        return true;
    }


    @EventHandler
    public void click(InventoryClickEvent e) {
        if (!e.getInventory().getName().equals(name)) return;
        if (e.getCurrentItem() == null) return;
        Player player = (Player) e.getWhoClicked();
        e.setCancelled(true);
        if (e.getCurrentItem().equals(vidroCinza)) {
            player.kickPlayer("§cVocê clicou errado");
        } else if (e.getCurrentItem().equals(vidroVerde)) {
            player.sendMessage("§aVocê encontrou uma parte do Captcha");
            e.getInventory().setItem(e.getRawSlot(), vidroCinza);
            if (completouCaptcha(e.getInventory())) {
                player.sendMessage("§aParabéns captcha concluido.");
            }
        }

    }


}
