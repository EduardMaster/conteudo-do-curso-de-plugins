package net.eduard.curso.chat.simples_api;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.Plugin;

import net.eduard.api.lib.modules.Mine;
import net.eduard.api.lib.modules.Extra;

/**
 * Mine de manipulacao de Cores e CHAT do Minecraft
 * 
 * @author Eduard
 *
 */
public final class SimpleChatAPI {

	public static void enable(Plugin plugin) {
		disable();
		Bukkit.getPluginManager().registerEvents(listener, plugin);
		listener.setRegistred(true);
		listener.setPlugin(plugin);
	}

	public static void disable() {
		HandlerList.unregisterAll(listener);
		listener.setRegistred(false);
		listener.setPlugin(null);
	}

	public static boolean isActive() {
		return listener.isRegistred();
	}

	private static boolean enabled = true;

	public static boolean isEnabled() {
		return enabled;
	}

	public static void setEnabled(boolean enabled) {
		SimpleChatAPI.enabled = enabled;
	}

	private static String messageChatDisabled = "&cChat desabilitado temporiamente!";
	private static String messageChatPermission = "§cVoce nao tem permissao para falar neste Chat!";
	private static SimpleChatChannel chatDefault = new SimpleChatChannel("local", "", "§e§l(L) ", "", "l");
	private static boolean useSpigot = true;
	private static Map<String, SimpleChatChannel> channels = new HashMap<>();

	public static void register(SimpleChatChannel channel) {
		channels.put(channel.getName().toLowerCase(), channel);
	}

	public static void unregister(SimpleChatChannel channel) {
		channels.remove(channel.getName().toLowerCase());
	}

	public static class SimpleChatMessageListener implements Listener {
		private Plugin plugin;
		private boolean registred;

		public boolean isRegistred() {
			return registred;
		}

		public void setRegistred(boolean registred) {
			this.registred = registred;
		}

		@EventHandler(priority = EventPriority.HIGHEST)
		public void onChat(AsyncPlayerChatEvent event) {
			event.setCancelled(true);
			chatDefault.chat(event.getPlayer(), event.getMessage());
		}

		@EventHandler
		public void onCommand(PlayerCommandPreprocessEvent event) {
			String msg = event.getMessage();
			String cmd = Extra.getCommandName(msg);
			for (SimpleChatChannel channel : channels.values()) {
				if (Mine.startWith(cmd, "/" + channel.getName())) {
					channel.chat(event.getPlayer(), msg.replaceFirst(cmd, ""));
					event.setCancelled(true);
					break;
				}
				if (Mine.startWith(cmd, "/" + channel.getCommand())) {
					channel.chat(event.getPlayer(), msg.replaceFirst(cmd, ""));
					event.setCancelled(true);
					break;
				}
			}
		}

		public Plugin getPlugin() {
			return plugin;
		}

		public void setPlugin(Plugin plugin) {
			this.plugin = plugin;
		}
	}

	private static SimpleChatMessageListener listener = new SimpleChatMessageListener();

	public static SimpleChatChannel getChatDefault() {
		return chatDefault;
	}

	public static void setChatDefault(SimpleChatChannel chatDefault) {
		SimpleChatAPI.chatDefault = chatDefault;
	}

	public static Map<String, SimpleChatChannel> getChannels() {
		return channels;
	}

	public static void setChannels(Map<String, SimpleChatChannel> channels) {
		SimpleChatAPI.channels = channels;
	}

	public static String getMessageChatPermission() {
		return messageChatPermission;
	}

	public static void setMessageChatPermission(String messageChatPermission) {
		SimpleChatAPI.messageChatPermission = messageChatPermission;
	}

	public static String getMessageChatDisabled() {
		return messageChatDisabled;
	}

	public static void setMessageChatDisabled(String messageChatDisabled) {
		SimpleChatAPI.messageChatDisabled = messageChatDisabled;
	}

	public static boolean isUseSpigot() {
		return useSpigot;
	}

	public static void setUseSpigot(boolean useSpigot) {
		SimpleChatAPI.useSpigot = useSpigot;
	}

}
