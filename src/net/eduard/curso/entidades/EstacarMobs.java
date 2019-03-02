package net.eduard.curso.entidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;

import net.eduard.curso.CursoEduard;

public class EstacarMobs implements Listener {
	public static void setStack(Entity entity, int amount) {
		entity.setMetadata("mob-stack", new FixedMetadataValue(CursoEduard.getInstance(), amount));
	}

	public static int getStack(Entity entity) {
		if (entity.hasMetadata("mob-stack"))

		{
			return entity.getMetadata("mob-stack").get(0).asInt();
		}
		return 0;

	}
	public static int rangeDoStack = 20;
	public static HashMap<Creature, Integer> entidadesStackadas = new HashMap<>();
	public static boolean killAll = false;

	@EventHandler
	public void aoUmaCriaturaSpawnar(CreatureSpawnEvent e) {
		if (e.getSpawnReason() == SpawnReason.CUSTOM) {
			return;
		}
		if (e.getEntity() instanceof Creature) {
			Creature creature = (Creature) e.getEntity();
			List<Entity> list = e.getEntity().getNearbyEntities(rangeDoStack, rangeDoStack, rangeDoStack);
			List<Creature> mobs = new ArrayList<>();
			for (Entity entity : list) {
				if (entity instanceof Creature) {
					mobs.add((Creature) entity);
				}
			}
			int stacks = 1;

			for (Creature mob : mobs) {
				if (mob.getType() == creature.getType()) {
					if (!mob.equals(creature)) {
						if (entidadesStackadas.containsKey(mob)) {
							stacks += entidadesStackadas.get(mob);
							entidadesStackadas.remove(mob);
							mob.remove();
						} else {
							Bukkit.broadcastMessage("§6N");
							stacks++;
						}
					}
				}
			}

			creature.setCustomName("§b" + creature.getType().name().toLowerCase().replace("_", " ") + " §ex" + stacks);
			creature.setCustomNameVisible(true);
			entidadesStackadas.put(creature, stacks);
		}

	}

	@EventHandler
	public void quandoUmaEntidadeMorrer(EntityDeathEvent e) {
		if (e.getEntity() instanceof Creature) {
			Creature creature = (Creature) e.getEntity();

			if (entidadesStackadas.containsKey(creature)) {
				Integer stacks = entidadesStackadas.get(creature);

				if (killAll) {
					List<ItemStack> drops = new ArrayList<>();
					for (ItemStack drop : e.getDrops()) {
						for (int id = 1; id <= stacks; id++) {
							drops.add(drop);
						}
					}
					e.getDrops().clear();
					e.getDrops().addAll(drops);
					e.setDroppedExp(e.getDroppedExp() * stacks);
					entidadesStackadas.remove(creature);
				} else {
					stacks--;
					LivingEntity newCreature = (LivingEntity) creature.getWorld().spawnEntity(creature.getLocation(),
							creature.getType());
					newCreature.setCustomName(
							"§b" + creature.getType().name().toLowerCase().replace("_", " ") + " §ex" + stacks);
					newCreature.setCustomNameVisible(true);
					entidadesStackadas.remove(creature);
					entidadesStackadas.put((Creature) newCreature, stacks);
				}
			}
		}
	}
}
