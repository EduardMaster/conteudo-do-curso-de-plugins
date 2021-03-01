package net.eduard.curso;

import net.eduard.curso.projeto.permissao.ArmazenamentoPermissaoUsuarioBungee;
import net.eduard.curso.projeto.permissao.PermissaoBungeeListener;
import net.eduard.curso.projeto.permissao.PermissaoManager;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

public class CursoBungee  extends Plugin {


    private static CursoBungee instance;

    public static PermissaoManager getManager() {
        return manager;
    }

    private static PermissaoManager manager;

    public static CursoBungee getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        manager = new PermissaoManager();
        manager.setUsuariosArmazenamento(new ArmazenamentoPermissaoUsuarioBungee());

        ProxyServer.getInstance().getPluginManager().registerListener(
                this,new PermissaoBungeeListener());

    }

    @Override
    public void onDisable() {

    }
}
