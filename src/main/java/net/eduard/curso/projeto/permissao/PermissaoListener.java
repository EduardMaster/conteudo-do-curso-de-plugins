package net.eduard.curso.projeto.permissao;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.concurrent.TimeUnit;

public class PermissaoListener implements Listener {

    @EventHandler
    public void saida(PlayerQuitEvent e){

        if (System.currentTimeMillis() - e.getPlayer().getFirstPlayed()
        < TimeUnit.MINUTES.toMillis(2))return;
        ProjetoPermissao.getInstance().saveUsuario(e.getPlayer());

    }


}
