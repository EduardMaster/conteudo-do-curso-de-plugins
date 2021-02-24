package net.eduard.curso.projeto.permissao;


import java.util.HashMap;
import java.util.Map;

public class PermissaoManager {


    public PermissaoManager(){
        gruposPadroes();
    }

    private Map<String, PermissaoGrupo> grupos = new HashMap<>();
    private Map<String, PermissaoUsuario> usuarios = new HashMap<>();

    public void gruposPadroes(){
        PermissaoGrupo membro = new PermissaoGrupo();
        membro.setNome("Membro");
        membro.setPrefix("§2[Membro]§7");
        membro.setSuffix("");
        membro.getPermissoes().add("comando.warp");
        grupos.put(membro.getNome().toLowerCase() , membro);

    }
    public PermissaoUsuario getUsuario(String player){
        if (usuarios.containsKey(player.toLowerCase())){
            return usuarios
                    .get(player.toLowerCase());

        }
        PermissaoUsuario usuario = new PermissaoUsuario();
        usuario.getGroupsNames().add("membro");
        usuario.setPlayer(player);
        usuarios.put(player.toLowerCase() , usuario);
        return usuario;

    }


    public Map<String, PermissaoGrupo> getGrupos() {
        return grupos;
    }

    public Map<String, PermissaoUsuario> getUsuarios() {
        return usuarios;
    }
}
