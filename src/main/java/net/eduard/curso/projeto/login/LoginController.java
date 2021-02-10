package net.eduard.curso.projeto.login;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class LoginController implements Listener {


    @EventHandler
    public void bloquearAndar(PlayerMoveEvent e){
        if (e.getFrom().getBlock().equals(e.getTo().getBlock()))return;
        if (!ProjetoLogin.getManager().isLogado(e.getPlayer())){
            e.setTo(e.getFrom());

        }
    }
}
