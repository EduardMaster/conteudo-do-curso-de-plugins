package net.eduard.curso.projeto.permissao;

import net.eduard.api.lib.config.BukkitConfigs;
import net.eduard.curso.data.ModelBukkitConfigs;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PermissaoUsuarioModel extends ModelBukkitConfigs<PermissaoUsuario> {
    private Map<String,PermissaoUsuario> cache = new HashMap<>();
    private Map<String,BukkitConfigs> handlersCache = new HashMap<>();
    @Override
    public Map<String, PermissaoUsuario> getCache() {

        return cache;
    }

    @Override
    public Map<String, BukkitConfigs> getHandlersCache() {
        return handlersCache;
    }

    @Override
    public BukkitConfigs getMainHandler() {
        return null;
    }

    @Override
    public BukkitConfigs getHandlerBy(String playerName) {
        if (getHandlersCache().containsKey(playerName.toLowerCase()))
            return getHandlersCache().get(playerName.toLowerCase()) ;
        BukkitConfigs config = new BukkitConfigs("jogadores/"+playerName.toLowerCase()+".yml");
        getHandlersCache().put(playerName.toLowerCase() , config);
        return config;
    }

    @Override
    public boolean has(String playerName) {
        return getHandlerBy(playerName).exists();
    }

    @Override
    public void save(PermissaoUsuario permissaoUsuario) {
        BukkitConfigs config = getHandlerBy(permissaoUsuario.getPlayer());
        config.set("nome", permissaoUsuario.getPlayer());
        config.set("permissoes" , permissaoUsuario.getPermissoes());
        config.set("cargos" , permissaoUsuario.getGroupsNames());
        config.saveConfig();
    }

    @Override
    public void reload(PermissaoUsuario permissaoUsuario) {
        BukkitConfigs config = getHandlerBy(permissaoUsuario.getPlayer());
        permissaoUsuario.setPlayer( config.getString("nome"));
        permissaoUsuario.getPermissoes().clear();
        permissaoUsuario.getGroupsNames().clear();
        permissaoUsuario.getPermissoes().addAll(config.getStringList("permissoes"));
        permissaoUsuario.getGroupsNames().addAll(config.getStringList("cargod"));

    }

    @Override
    public PermissaoUsuario load(String playerName) {
        removeCache(playerName);
        PermissaoUsuario usuario = new PermissaoUsuario();
        reload(usuario);
        getCache().put(playerName.toLowerCase(), usuario);
        return usuario;
    }

    @Override
    public Collection<PermissaoUsuario> loadAll() {
        BukkitConfigs config = new BukkitConfigs("jogadores/");
        for (String fileName : config.getFile().list()){
            load(fileName.replace(".yml",""));
        }
        return cache.values();
    }


    @Override
    public void delete(String playerName) {
        getHandlerBy(playerName).delete();
        removeCache(playerName);
    }
}
