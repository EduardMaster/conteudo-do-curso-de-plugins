package net.eduard.curso.projeto.login;

import java.util.UUID;

import net.eduard.curso.Projeto;


public class ProjetoLogin extends Projeto {

    @Override
    public void onEnable() {
        registerCommand("register", new ComandoRegister());
        registerCommand("login" , new ComandoLogin());

        reload();
    }
    private static final LoginManager manager = new LoginManager();
    public static LoginManager getManager() {
        return manager;
    }
    @Override
    public void onDisable() {

    }

    public void reload() {
        getManager().getRegistrados().clear();
        for (String uuid : getManager().getConfig()
                .getSection("Contas").getKeys(false)) {
            UUID id = UUID.fromString(uuid);
            String senha = getManager().getConfig()
                    .getString("Contas." + uuid+".senha");
            getManager().getRegistrados().put(id, senha);
        }
    }




}
