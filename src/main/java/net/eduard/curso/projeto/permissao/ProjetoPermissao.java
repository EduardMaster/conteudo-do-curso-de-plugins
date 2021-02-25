package net.eduard.curso.projeto.permissao;

import net.eduard.api.lib.config.BukkitConfigs;
import net.eduard.curso.Curso;
import net.eduard.curso.Projeto;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

import java.io.File;

public class ProjetoPermissao extends Projeto {
    private static ProjetoPermissao instance;


    private static PermissaoManager manager;

    public static PermissaoManager getManager() {
        return manager;
    }

    public static ProjetoPermissao getInstance() {
        return instance;
    }

    private BukkitConfigs config;



    @Override
    public void onEnable() {
        manager = new PermissaoManager();
        registerCommand("permissao" , new PermissaoComando());
        registerEvents(new PermissaoListener());
        config = new BukkitConfigs("grupos.yml");
        reload();
        reloadPlayers();

    }

    @Override
    public void onDisable() {
        save();
    }

    public void reload(){
        for (String grupoName  : config.getKeys(false)){
            PermissaoGrupo grupo = new PermissaoGrupo();
            ConfigurationSection secao = config.getSection(grupoName);
            grupo.setNome(secao.getString("nome"));
            manager.getGrupos().put(grupo.getNome().toLowerCase() , grupo);
        }
    }


    public void save(){
        for (PermissaoGrupo grupo : manager.getGrupos().values()){
            String grupoName = grupo.getNome();
            ConfigurationSection secao = config.getSection(grupoName);
            secao.set("nome" , grupo.getNome());
        }
        config.saveConfig();
    }

    public void saveUsuario(Player player){
        saveUsuario(manager.getUsuario(player.getName()));
    }
    public void saveUsuario(PermissaoUsuario usuario){
        String nick = usuario.getPlayer().toLowerCase();
        BukkitConfigs playerConfig = new BukkitConfigs("jogadores/" + nick + ".yml");
        playerConfig.set("nome" , usuario.getPlayer());
        playerConfig.set("permissoes", usuario.getPermissoes());
        playerConfig.set("grupos",usuario.getGroupsNames());
        playerConfig.saveConfig();
    }
    public void reloadPlayers(){
        File pasta = new File(Curso.getInstance().getDataFolder(), "jogadores/");
        pasta.mkdirs();

        for (File arquivo : pasta.listFiles()){
            String nick = arquivo.getName().replace(".yml","");
            BukkitConfigs playerConfig = new BukkitConfigs("jogadores/" + nick + ".yml");
            PermissaoUsuario usuario = new PermissaoUsuario();
            usuario.setPlayer(playerConfig.getString("nome"));
            usuario.getGroupsNames().addAll( playerConfig.getStringList("grupos"));
            usuario.getPermissoes().addAll(playerConfig.getStringList("permissoes"));
            manager.getUsuarios().put(usuario.getPlayer().toLowerCase() , usuario);
        }

    }




    public void sistemaDePermissaoDoBukkit(Player player){

        // adiciona regra
        PermissionAttachment permissaoDada = player.addAttachment(Curso.getInstance(), "permissao", true);

        // remove regra
        player.removeAttachment(permissaoDada);
    }
}
