package net.eduard.curso.projeto.report;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MenuReports implements Listener {


    private static String nome = "Reportes";
    // private static HashMap<Integer, Report> reportes = new HashMap<>();


    private static HashMap<Player, HashMap<Integer, Report>> playersReportes
            = new HashMap<>();

    private static HashMap<Player, Integer> paginaAberta = new HashMap<>();

    public static void exemplo() {
        HashMap<String, Double> contas = new HashMap<>();
        contas.put("Eduard", 10000.0);
        contas.put("Yonatan", 20000.0);
        contas.put("Yonatan", (contas.get("Yonatan") - 200.0));
        contas.get("Yonatan");// 20000.0
        HashMap<String, HashMap<String, Integer>> moedas = new HashMap<>();

        HashMap<String, Integer> cash = new HashMap<>();
        cash.put("Eduard", 100);
        cash.put("Yonatan", 200);

        moedas.put("Cash", cash);

        HashMap<String, Integer> coins = new HashMap<>();
        coins.put("Eduard", 100000000);
        coins.put("Yonatan", 200000000);

        moedas.put("Coins", coins);

        HashMap<String, Integer> moedaCash = moedas.get("Cash");
        moedaCash.put("Eduard", moedaCash.get("Eduard") + 200);

        HashMap<String, Integer> moedaCoins = moedas.get("Coins");
        moedaCoins.put("Eduard", moedaCoins.get("Eduard") - 1000000);
    }
    private static final int slotVoltar = 0;
    private static final int slotAvancar = 8;
    @EventHandler
    public void controle(InventoryClickEvent evento) {
        Player player = (Player) evento.getWhoClicked();
        if (!evento.getInventory().getName().equals(nome)) return;
        evento.setCancelled(true);
        if (evento.getCurrentItem() == null) return;
        int slotClicado = evento.getRawSlot();
        int paginaAtual = paginaAberta.get(player);

        if (paginaAtual > 1 && slotClicado == slotVoltar) {
            abrirMenu(player, paginaAtual - 1);
            return;
        }
        if (slotClicado == slotAvancar) {
            abrirMenu(player, paginaAtual + 1);
            return;
        }
        HashMap<Integer, Report> reportes = playersReportes.get(player);
        if (reportes == null) return;
        Report reporte = reportes.get(slotClicado);
        if (reporte == null) return;
        // player.sendMessage("§aVocê clicou no report do " + reporte.getReportedPlayer());
        if (evento.getClick() == ClickType.RIGHT) {
            Report.getReports().remove(reporte);
            reportes.remove(slotClicado);
            player.sendMessage("§AEste report foi removido.");
            abrirMenu(player);
        } else if (evento.getClick() == ClickType.LEFT) {
            Player alvo = Bukkit.getPlayer(reporte.getReportedPlayer());
            if (alvo == null) {
                return;
            }
            player.teleport(alvo);
            player.sendMessage("§aVocê esta agora verificando o reporte.");
            reporte.setVerified(true);
            reporte.setVerifierPlayer(player.getName());

        } else if (evento.getClick() == ClickType.SHIFT_RIGHT) {

        } else if (evento.getClick() == ClickType.SHIFT_LEFT) {

        } else if (evento.getClick() == ClickType.MIDDLE) {

        }
    }

    public static void abrirMenu(Player player) {
        abrirMenu(player, 1);
    }

    public static void abrirMenu(Player player, int pagina) {
        Inventory menu = Bukkit.createInventory(null, 6 * 9, nome);
        // argumentos [0]
        paginaAberta.put(player, pagina);
        int slotUsado = 10;
        int porPagina = 2;
        int fim = (pagina * porPagina);
        HashMap<Integer, Report> reports = new HashMap<>();
        int size = Report.getReports().size();
        if (pagina > 1) {
            ItemStack item = new ItemStack(Material.ARROW);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§aVoltar para pagina " + (pagina - 1));
            item.setItemMeta(meta);
            menu.setItem(slotVoltar, item);
        }
        {
            ItemStack item = new ItemStack(Material.ARROW);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§aAvançar para pagina " + (pagina + 1));
            item.setItemMeta(meta);
            menu.setItem(slotAvancar, item);
        }

        for (int atual = (pagina - 1) * porPagina; atual < fim; atual++) {
            if (atual >= size) break;
            Report reporte = Report.getReports().get(atual);
            if (reporte.isVerified()) {
                continue;
            }
            menu.setItem(slotUsado, reporte.getIcon());
            reports.put(slotUsado, reporte);
            slotUsado++;
        }

        playersReportes.put(player, reports);
        player.openInventory(menu);
    }

}
