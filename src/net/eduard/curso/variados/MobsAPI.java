package net.eduard.curso.variados;

import net.eduard.api.lib.config.Configs;
import net.eduard.curso.Main;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

import java.util.ArrayList;
import java.util.Set;

public class MobsAPI {

    private static MobManager manager = new MobManager();
    private static Configs config = new Configs("mobs.yml", Main.getInstance());

    public static void killMobs(){
        for (Mob mob : manager.getMobs()) {
            mob.despawn();
        }
    }
    public static void saveMobs(){

        for (Mob mob : manager.getMobs()) {

            ConfigurationSection secao = config.getSection(mob.getId());
            secao.set("nome",mob.getName());
            secao.set("vida",mob.getVidaMaxima());
            secao.set("tipo",mob.getTipo().name());
            secao.set("local",mob.getLocal());


        }

        config.saveConfig();

    }
    public static void loadMobs() {
        config.reloadConfig();
        killMobs();

        manager.getMobs().clear();
        Set<String> mobsIds = config.getKeys(false);
        for (String mobId : mobsIds) {
            ConfigurationSection secao = config.getSection(mobId);

            Mob mob = new Mob();
            mob.setId(mobId);

            mob.setName(secao.getString("nome"));
            mob.setVidaMaxima(secao.getDouble("vida"));
            mob.setLocal((Location) secao.get("local"));
            mob.setTipo(EntityType.valueOf(secao.getString("tipo").toUpperCase()));
            mob.spawn();

            manager.getMobs().add(mob);

        }


    }


    public static MobManager getManager() {
        return manager;
    }


    public static class MobManager {

        private ArrayList<Mob> mobs = new ArrayList<>();

        public ArrayList<Mob> getMobs() {
            return mobs;
        }
    }


    public static class Mob {

        private String id;
        private String name;
        private Location local;
        private EntityType tipo;
        private double vidaMaxima;

        private LivingEntity entity;
        private ArmorStand holograma;

        public void spawn(){
             entity = (LivingEntity) local.getWorld().spawnEntity(local, tipo);
             entity.setMaxHealth(this.vidaMaxima);
             entity.setHealth(this.vidaMaxima);
             holograma = local.getWorld().spawn(local, ArmorStand.class);
            setVisualName(this.name);

             holograma.setGravity(false);
             holograma.setSmall(true);
             holograma.setVisible(false);
             entity.setPassenger(holograma);
        }

        public Mob() {
        }
        public void setVisualName(String newName){
            newName = newName.replace('&','§' );
            holograma.setCustomName(newName);
            holograma.setCustomNameVisible(true);
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Location getLocal() {
            return local;
        }

        public void setLocal(Location local) {
            this.local = local;
        }

        public EntityType getTipo() {
            return tipo;
        }

        public void setTipo(EntityType tipo) {
            this.tipo = tipo;
        }

        public double getVidaMaxima() {
            return vidaMaxima;
        }

        public void setVidaMaxima(double vidaMaxima) {
            this.vidaMaxima = vidaMaxima;
        }

        public void despawn() {
            this.holograma.remove();
            this.entity.remove();
        }
    }

}
