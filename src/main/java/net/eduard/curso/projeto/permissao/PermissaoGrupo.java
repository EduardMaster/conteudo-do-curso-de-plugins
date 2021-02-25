package net.eduard.curso.projeto.permissao;



import java.util.*;

public class PermissaoGrupo  {

    private String nome;
    private String prefix;
    private String suffix;
    private Set<String> subGroupsNames = new HashSet<>();
    private Set<String> permissoes = new HashSet<>();
    private Map<String, Boolean> permissoesCalculadas = new HashMap();

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public Set<String> getSubGroupsNames() {
        return subGroupsNames;
    }

    public void setSubGroupsNames(Set<String> subGroupsNames) {
        this.subGroupsNames = subGroupsNames;
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

    public void setPermissoesCalculadas(Map<String, Boolean> permissoesCalculadas) {
        this.permissoesCalculadas = permissoesCalculadas;
    }

    public boolean hasPermission(String permission){
        return permissoesCalculadas.getOrDefault(permission.toLowerCase()
                , false);

    }

}
