package net.eduard.curso.sistemas;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Sistema simples para você poder ver todos efeitos sonoros existentes e também os efeitos
 * @author Eduard
 *
 */
public class VerEfeitosSonoros implements Listener{
	@EventHandler
	public void event(PlayerJoinEvent e) {
		 Player p = e.getPlayer();
		 
		 
		 new BukkitRunnable() {
			 int v  = 35;
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				if (v+1 >Effect.values().length) {
					v = 0;
				}
				Effect effect = Effect.values()[v];
				Bukkit.getConsoleSender().sendMessage("§cMonstrano efeito "+effect.name()+" para o "+p.getName()+" id "+v);
				if (effect == Effect.ITEM_BREAK) {
					p.sendMessage("§cInvalido");
					v++;
					return;
				}
				Location loc = p.getLocation();
				p.playEffect(loc.add(0, 2, 0),effect , 0);
				p.sendMessage("§aMostrando efeito "+effect.name());
				v++;
			}
		}.runTaskTimer(JavaPlugin.getProvidingPlugin(VerEfeitosSonoros.class), 20*3, 20*3);
	}
}
