package net.eduard.curso.projeto.permissao;

import net.eduard.api.lib.config.BukkitConfigs;
import net.eduard.curso.Armazenamento;
import net.eduard.curso.Curso;
import net.eduard.curso.projeto.permissao.objetos.PermissaoUsuario;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ArmazenamentoPermissaoUsuario implements
        Armazenamento<PermissaoUsuario, BukkitConfigs> {
    private HashMap<String, PermissaoUsuario> cacheamento = new HashMap<>();


    @Override
    public BukkitConfigs getBy(String key) {
        return new BukkitConfigs("jogadores/"+key.toLowerCase() +".yml");
    }

    @Override
    public Map<String, PermissaoUsuario> cache() {
        return cacheamento;
    }

    @Override
    public void save(PermissaoUsuario usuario) {

        BukkitConfigs config = getBy(usuario.getPlayer());
        config.set("nome", usuario.getPlayer());
        config.set("permissoes" , Arrays.asList( usuario.getPermissoes() ) );
        config.set("cargos" , Arrays.asList( usuario.getGroupsNames() ));
        config.saveConfig();


    }

    @Override
    public PermissaoUsuario loadOrGet(String key) {
        if (cache().containsKey(key.toLowerCase()) ){
            return cache().get(key.toLowerCase());
        };
        return load(key);
    }

    @Override
    public PermissaoUsuario load(String key) {
        PermissaoUsuario usuario = new PermissaoUsuario();
        reload(usuario);
        cache().put(key.toLowerCase() , usuario);
        return usuario;
    }

    @Override
    public Collection<PermissaoUsuario> loadAll() {
        cache().clear();
        File pasta = new File(Curso.getInstance().getDataFolder(),
                "jogadores/");
        pasta.mkdirs();
        for (String fileName : pasta.list()){
            String key = fileName.replace(".yml" , "");
            load(key);
        }
        return cacheamento.values();
    }

    @Override
    public void reload(PermissaoUsuario usuario) {
        BukkitConfigs config = getBy(usuario.getPlayer());
        usuario.setPlayer( config.getString("nome"));
        usuario.getPermissoes().clear();
        usuario.getGroupsNames().clear();
        usuario.getPermissoes().addAll(config.getStringList("permissoes"));
        usuario.getGroupsNames().addAll(config.getStringList("cargod"));

    }
}
