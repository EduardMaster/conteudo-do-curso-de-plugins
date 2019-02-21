package net.eduard.curso.hg_kitpvp_kits;

import java.util.Map;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import net.eduard.api.lib.game.Jump;
import net.eduard.api.lib.game.SoundEffect;
import net.eduard.api.lib.manager.LaunchPadManager;
import net.eduard.api.server.kits.KitAbility;

@SuppressWarnings("unused")
public class Launcher extends KitAbility {

	private LaunchPadManager pad= new LaunchPadManager(-1,19, new Jump(SoundEffect.create("BAT_TAKEOFF"), new Vector(0, 2.5, 0)));
	

	public Launcher() {
		setIcon(Material.SPONGE, "§fGanhe 20 esponjas especiais");
		add(new ItemStack(Material.SPONGE, 20));
	};
	@Override
	public void register(Plugin plugin) {
		pad.register(plugin);
		 super.register(plugin);
	}
	@Override
	public Object restore(Map<String, Object> map) {
		pad.register(getPluginInstance());
		return null;
	}

}
