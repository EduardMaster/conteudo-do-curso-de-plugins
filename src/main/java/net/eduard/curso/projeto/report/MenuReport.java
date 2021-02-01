package net.eduard.curso.projeto.report;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;

public class MenuReport implements Listener {

    private static String nome = "Reportes";
    private static HashMap<Integer, Report> reportes = new HashMap<>();
    private static HashMap<String, Double> contas = new HashMap<>();

    public static void exemplo(){
        contas.put("Eduard", 10000.0);
        contas.put("Yonatan" , 20000.0);
        contas.put("Yonatan" , (contas.get("Yonatan") -  200.0));
        contas.get("Yonatan");// 20000.0

        Double saldoEdu = 300000.0;
        saldoEdu = 20000.0;
        Double saldoYonatan = 20000.0;
        saldoYonatan = 20000000.0;

    }

    @EventHandler
    public void controle(InventoryClickEvent evento){
        Player player = (Player)evento.getWhoClicked();
        if (!evento.getInventory().getName().equals(nome))return;
        evento.setCancelled(true);
        if (evento.getCurrentItem()==null)return;
        int slotClicado = evento.getRawSlot();
        Report reporte = reportes.get(slotClicado);
        if (reporte == null)return;
        player.sendMessage("§aVocê clicou no report do "+reporte.getReportedPlayer());

    }

    public static void abrirMenu(Player player){
        Inventory menu = Bukkit.createInventory(null , 6*9 , nome);
        int slotUsado = 10;


        for (Report reporte : Report.getReports()){
            menu.setItem(slotUsado , reporte.getIcon());
            reportes.put(slotUsado , reporte);
            slotUsado++;
        }
        player.openInventory(menu);
    }

}
