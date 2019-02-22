package net.eduard.curso.eventos;

import org.bukkit.plugin.java.JavaPlugin;

public interface GetBukkitPlugin {

	public default JavaPlugin getPlugin() {
		return JavaPlugin.getProvidingPlugin(getClass());
	}
	public default JavaPlugin getPluginMain() {
		@SuppressWarnings("unchecked")
		Class<JavaPlugin> clz = (Class<JavaPlugin>) getClass();
		return JavaPlugin.getPlugin(clz);
	}
}
