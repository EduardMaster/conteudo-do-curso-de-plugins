package net.eduard.curso.projeto.permissao;

import net.eduard.api.lib.config.BukkitConfigs;
import net.eduard.curso.Curso;
import net.eduard.curso.Projeto;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;


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
      manager.saveUsuario(manager.getUsuario(player.getName()));
    }

    public void reloadPlayers(){
        manager.getUsuariosModel().loadAll();

    }




    public void sistemaDePermissaoDoBukkit(Player player){

        // adiciona regra
        PermissionAttachment permissaoDada = player.addAttachment(Curso.getInstance(), "permissao", true);

        // remove regra
        player.removeAttachment(permissaoDada);
    }
}
