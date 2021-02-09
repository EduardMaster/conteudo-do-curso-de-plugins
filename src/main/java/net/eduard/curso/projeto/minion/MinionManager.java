package net.eduard.curso.projeto.minion;

import net.eduard.api.lib.config.BukkitConfigs;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MinionManager {

    private BukkitConfigs config = new BukkitConfigs("minions.yml");
    private Map<UUID, Minion > minions =new HashMap<>();
    private Map<String, MinionPlayer> users = new HashMap<>();


    public Minion getMinionByIcon(ItemStack item){

        for (Minion minion : minions.values()){
            if (minion.getIcon().isSimilar(item)){
                return minion;
            }
        }

        return null;
    }

    public MinionPlayer getUser(String player){

        MinionPlayer conta = users.get(player.toLowerCase());

        if (conta == null){
            conta = new MinionPlayer();
            conta.setPlayer(player);

            users.put(player.toLowerCase(), conta);

        }
        return conta;
    }

    private Connection connection;

    public void despawnMinions(){
        for (MinionPlayer minionPlayer : users.values()){
            for (MinionSpawned minion : minionPlayer.getMinions().values()){
                minion.despawn();
            }
        }
    }

    public void loadMinions(){
        minions.clear();
        users.clear();
        config.reloadConfig();
        for (String key : config.getKeys(false)){
            ConfigurationSection secao = config.getSection(key);
            Minion minion = new Minion();
            minion.reload(secao);
            minions.put(minion.getId() , minion);
        }
        loadMinionsInstalleds();


    }
    public void loadMinionsInstalleds(){
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM MINIONS;");
            ResultSet query = st.executeQuery();
            while(query.next()){
                String player = query.getString("dono");
                MinionPlayer conta = getUser(player);
                UUID id = UUID.fromString(query.getString("minion_id"));
                Minion minion = minions.get(id);

                Location location =  (Location) query.getObject("location");
                int vida = query.getInt("vida");
                MinionSpawned minionSpawned = new MinionSpawned();
                minionSpawned.setMinion(minion);
                minionSpawned.setLife(vida);
                minionSpawned.setLocation(location);
                minionSpawned.spawn();
                conta.getMinions().put(location , minionSpawned);
            }

        }catch (Exception ex){

        }
    }

    public void insert(MinionSpawned minionSpawned){

    }
    public void delete(MinionSpawned minionSpawned){

    }
    public void saveMinions(){
        for (Minion minion : minions.values()){
            ConfigurationSection secao = config.create(minion.getId().toString());
            minion.save(secao);
        }
        config.saveConfig();
    }

    public Map<UUID, Minion> getMinions() {
        return minions;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
