package net.eduard.curso.projeto.login;

import java.util.HashMap;
import java.util.UUID;

import net.eduard.api.lib.config.BukkitConfigs;
import net.eduard.curso.Curso;
import org.bukkit.entity.Player;


public class LoginSystem {
    private static final HashMap<UUID, String> registrados = new HashMap<>();
    private static final HashMap<Player, Long> logados = new HashMap<>();
    private static final BukkitConfigs config =
            new BukkitConfigs("contas.yml", Curso.getInstance());

    public static BukkitConfigs getConfig() {
        return config;
    }
    public static void register(Player player, String senha) {
        config.set("Contas." + player.getUniqueId() + ".senha", senha);
        registrados.put(player.getUniqueId(), senha);

    }

    public static void reload() {
        registrados.clear();
        for (String uuid : config.getSection("Contas").getKeys(false)) {
            UUID id = UUID.fromString(uuid);
            String senha = config.getString("Contas." + uuid+".senha");
            registrados.put(id, senha);
        }
    }

    public static void login(Player player) {
        logados.put(player, System.currentTimeMillis());

    }

    public static long getTempoLogado(Player player) {
        return System.currentTimeMillis() - logados.get(player);
    }

    public static String getSenha(Player player) {
        return config.getString("Contas." + player.getUniqueId() + ".senha");
    }

    public static void logout(Player player) {

        logados.remove(player);
    }

    public static boolean isRegistred(Player player) {
        return registrados.containsKey(player.getUniqueId());
    }




    public static HashMap<UUID, String> getRegistrados() {
        return registrados;
    }

    public static HashMap<Player, Long> getLogados() {
        return logados;
    }

}
