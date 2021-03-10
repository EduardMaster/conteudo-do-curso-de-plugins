package net.eduard.curso.projeto.permissao.objetos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PermissaoUsuario {
    private String player;
    private Set<String> groupsNames = new HashSet<>();
    private Set<String> permissoes = new HashSet<>();
    private final Map<String, Boolean> permissoesCalculadas = new HashMap<>();

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public Set<String> getGroupsNames() {
        return groupsNames;
    }

    public void setGroupsNames(Set<String> groupsNames) {
        this.groupsNames = groupsNames;
    }

    public Set<String> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(Set<String> permissoes) {
        this.permissoes = permissoes;
    }

    public Map<String, Boolean> getPermissoesCalculadas() {
        return permissoesCalculadas;
    }


    public boolean hasPermission(String permission){
        if (permissoesCalculadas.containsKey("*")){
            return true;
        }
        return permissoesCalculadas.getOrDefault(permission.toLowerCase()
                , false);

    }

    public void calcularPermissoes(){
        for (String permissao : permissoes){
            if (permissao.startsWith("-")){
                permissoesCalculadas.put(permissao
                        .replaceFirst("-",""), false);
            }else{
                permissoesCalculadas.put(permissao, true);
            }
        }
    }

}
