package net.eduard.curso.nms;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class EnviandoTitleActionbar implements Listener {


    @EventHandler
    public void event(AsyncPlayerChatEvent e) {
        if (e.getMessage().startsWith("title")) {

            PacketPlayOutChat packet = new PacketPlayOutChat(
                    IChatBaseComponent.ChatSerializer.a("Olá")
                    , (byte) 2);
            ((CraftPlayer) e.getPlayer()).getHandle().playerConnection.
                    sendPacket(packet);

            e.getPlayer().sendTitle("Aew", "Aew");

        }
    }

}
