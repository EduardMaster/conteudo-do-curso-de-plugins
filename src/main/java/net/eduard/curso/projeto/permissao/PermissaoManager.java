package net.eduard.curso.projeto.permissao;



import net.eduard.curso.data.Model;

import java.util.HashMap;
import java.util.Map;

public class PermissaoManager {


    public PermissaoManager() {
        gruposPadroes();
    }
    private Model<PermissaoUsuario ,String ,Object> usuariosModel;
    private Map<String, PermissaoGrupo> grupos = new HashMap<>();


    public void saveUsuario(PermissaoUsuario usuario){
        usuariosModel.save(usuario);


    }


    public void gruposPadroes() {
        PermissaoGrupo membro = new PermissaoGrupo();
        membro.setNome("Membro");
        membro.setPrefix("§2[Membro]§7");
        membro.setSuffix("");
        membro.getPermissoes().add("comando.warp");
        grupos.put(membro.getNome().toLowerCase(), membro);

    }

    public PermissaoUsuario getUsuario(String player) {
        return usuariosModel.getOrLoad(player);

    }


    public Map<String, PermissaoGrupo> getGrupos() {
        return grupos;
    }

    public Model<PermissaoUsuario, String, Object> getUsuariosModel() {
        return usuariosModel;
    }

    public void setUsuariosModel(Model<PermissaoUsuario, String, Object> usuariosModel) {
        this.usuariosModel = usuariosModel;
    }
}
