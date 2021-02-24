package net.eduard.curso.projeto.permissao;

import net.eduard.curso.Curso;
import net.eduard.curso.Projeto;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

public class ProjetoPermissao extends Projeto {

    private static PermissaoManager manager;

    public static PermissaoManager getManager() {
        return manager;
    }

    public void sistemaDePermissaoDoBukkit(Player player){

        // adiciona regra
        PermissionAttachment permissaoDada = player.addAttachment(Curso.getInstance(), "permissao", true);

        // remove regra
        player.removeAttachment(permissaoDada);
    }

    @Override
    public void onEnable() {
        manager = new PermissaoManager();



    }
    public void reload(){

    }

    @Override
    public void onDisable() {

    }
}
