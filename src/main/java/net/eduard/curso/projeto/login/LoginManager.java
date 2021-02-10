package net.eduard.curso.projeto.login;

import net.eduard.api.lib.config.BukkitConfigs;
import net.eduard.curso.Curso;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class LoginManager {

    private final HashMap<UUID, String> registrados = new HashMap<>();
    private final HashMap<Player, Long> logados = new HashMap<>();
    private final BukkitConfigs config =
            new BukkitConfigs("contas.yml", Curso.getInstance());

    public BukkitConfigs getConfig() {
        return config;
    }

    public void register(Player player, String senha) {
        config.set("Contas." + player.getUniqueId() + ".senha", senha);
        registrados.put(player.getUniqueId(), senha);
        config.saveConfig();
    }


    public void login(Player player) {
        logados.put(player, System.currentTimeMillis());

    }

    public long getTempoLogado(Player player) {
        return System.currentTimeMillis() - logados.get(player);
    }

    public String getSenha(Player player) {
        return config.getString("Contas." + player.getUniqueId() + ".senha");
    }

    public void logout(Player player) {

        logados.remove(player);
    }

    public boolean isRegistred(Player player) {
        return registrados.containsKey(player.getUniqueId());
    }

    public HashMap<UUID, String> getRegistrados() {
        return registrados;
    }

    public HashMap<Player, Long> getLogados() {
        return logados;
    }


}
