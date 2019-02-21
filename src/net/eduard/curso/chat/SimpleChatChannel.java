package net.eduard.curso.chat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.bukkit.entity.Player;

import net.eduard.api.lib.Mine;
import net.eduard.api.lib.storage.Storable;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

/**
 * Canal de Chat
 * 
 * @author Eduard-PC
 *
 */
public  class SimpleChatChannel implements Storable {

	private String name;
	private String format;
	private String prefix = "";
	private String suffix = "";
	private int distance = 100;
	private boolean global = true;
	private String permission;
	private String command;

	public SimpleChatChannel() {
	}

	public SimpleChatChannel(String name, String format, String prefix, String suffix, String command) {
		this.format = format;
		this.name = name;
		this.prefix = prefix;
		this.suffix = suffix;
		this.command = command;
		this.permission = "chat." + name;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}



	public void chat(Player player, String message) {
		if (SimpleChatAPI.isEnabled()) {
			if (!player.hasPermission(permission)) {
				player.sendMessage(message);
				return;
			}
			SimpleChatMessageEvent event = new SimpleChatMessageEvent(player, this, message);
			Mine.callEvent(event);
			if (event.isCancelled())
				return;
			List<Player> players = event.getPlayersInChannel();
			String msg = event.getMessage();
			String form = event.getFormat();
			form = form.replace("{msg}", msg);
			for (Entry<String, String> entry : event.getTags().entrySet()) {
				form = form.replace("{" + entry.getKey().toLowerCase() + "}", entry.getValue());
			}
			if (SimpleChatAPI.isUseSpigot()) {
				TextComponent text = new TextComponent(form);
				if (event.getOnClickCommand() != null) {
					ClickEvent clickEvent = new ClickEvent(ClickEvent.Action.RUN_COMMAND, event.getOnClickCommand());
					text.setClickEvent(clickEvent);
				}
				if (!event.getOnHoverText().isEmpty()) {

					ComponentBuilder textBuilder = new ComponentBuilder("");
					for (String line : event.getOnHoverText()) {
						textBuilder.append(line + "\n");
					}

					HoverEvent hoverEvent = new HoverEvent(HoverEvent.Action.SHOW_TEXT, textBuilder.create());
					text.setHoverEvent(hoverEvent);
				}
				for (Player p : Mine.getPlayers()) {
					p.spigot().sendMessage(text);
				}
			} else {
				for (Player p : players) {
					p.sendMessage(form);
				}
			}
			
		} else {
			player.sendMessage(SimpleChatAPI.getMessageChatDisabled());
		}
	}

	public List<Player> getPlayers(Player player) {
		List<Player> list = new ArrayList<>();
		for (Player p : Mine.getPlayers()) {
			if (!global) {
				if (!p.getWorld().equals(player.getWorld())) {
					continue;
				}
				if (distance > 0) {
					double newDistance = p.getLocation().distance(player.getLocation());
					if (newDistance > distance)
						continue;
				}
			}
			list.add(p);
		}
		return list;
	}

	@Override
	public Object restore(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void store(Map<String, Object> map, Object object) {
		// TODO Auto-generated method stub

	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public boolean isGlobal() {
		return global;
	}

	public void setGlobal(boolean global) {
		this.global = global;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

}