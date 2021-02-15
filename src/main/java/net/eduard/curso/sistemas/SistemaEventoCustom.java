package net.eduard.curso.sistemas;

import net.eduard.curso.Sistema;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Criar um Evento apartir de outro evento
 *
 * @author Eduard
 */
public class SistemaEventoCustom extends Sistema {

    @Override
    public void onEnable() {
        registerEvents();
    }

    @Override
    public void onDisable() {

    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        JoinMessageEvent event = new JoinMessageEvent("Mensagem a ser Enviada");
        Bukkit.getPluginManager().callEvent(event);
        if (!event.isCancelled()) {
            player.sendMessage(event.getMessage());
        }
    }
    public static class JoinMessageEvent extends Event implements  Cancellable {
        private static final HandlerList handlers = new HandlerList();
        private String message;
        private boolean cancelled;

        public JoinMessageEvent(String example) {
            message = example;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public boolean isCancelled() {
            return cancelled;
        }

        @Override
        public void setCancelled(boolean cancel) {
            cancelled = cancel;
        }

        @Override
        public HandlerList getHandlers() {
            return handlers;
        }

        public static HandlerList getHandlerList() {
            return handlers;
        }
    }




}
