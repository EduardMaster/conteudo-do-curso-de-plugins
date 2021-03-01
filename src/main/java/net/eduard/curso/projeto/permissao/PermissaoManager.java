package net.eduard.curso.projeto.permissao;


import net.eduard.curso.Armazenamento;

import java.util.HashMap;
import java.util.Map;

public class PermissaoManager {


    public PermissaoManager() {
        gruposPadroes();
    }

    private Armazenamento<PermissaoUsuario , ?> usuariosArmazenamento;

    private Map<String, PermissaoGrupo> grupos = new HashMap<>();

    public void saveUsuario(PermissaoUsuario usuario){
        usuariosArmazenamento.save(usuario);
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
        return usuariosArmazenamento.loadOrGet(player);

    }

    public Map<String, PermissaoGrupo> getGrupos() {
        return grupos;
    }

    public Armazenamento<PermissaoUsuario, ?> getUsuariosArmazenamento() {
        return usuariosArmazenamento;
    }

    public void setUsuariosArmazenamento(Armazenamento<PermissaoUsuario, ?> usuariosArmazenamento) {
        this.usuariosArmazenamento = usuariosArmazenamento;
    }
}
