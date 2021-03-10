package net.eduard.curso.projeto.permissao;

import net.eduard.curso.CursoBungee;
import net.eduard.curso.projeto.permissao.objetos.PermissaoUsuario;
import net.md_5.bungee.api.event.PermissionCheckEvent;
import net.md_5.bungee.api.event.ServerConnectedEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class PermissaoBungeeListener implements Listener {

    @EventHandler
    public void join(ServerConnectedEvent e){
        String key = e.getPlayer().getName();
        PermissaoUsuario usuario = CursoBungee.getManager().getUsuario(key);
        usuario.getPermissoesCalculadas().put("*",true);

        if (e.getPlayer().hasPermission("permissao.admin")){
            e.getPlayer().sendMessage("§aVocê tem a permissão");
        }else{
            e.getPlayer().sendMessage("§cVocê não tem esta permissão");
        }


    }


    @EventHandler
    public void checkPermission(PermissionCheckEvent e){
        String key = e.getSender().getName();
        PermissaoUsuario usuario = ProjetoPermissao.getManager().getUsuario(key);
        e.setHasPermission(usuario.hasPermission(e.getPermission()));
    }
}
