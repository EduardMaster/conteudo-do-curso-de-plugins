package net.eduard.curso.projeto.permissao.cmd;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PermissaoCommandSenderBukkit implements  IPermissaoComandoSender{
    private CommandSender sender;

    public PermissaoCommandSenderBukkit(CommandSender sender) {
        this.sender = sender;
    }


    @Override
    public void sendMessage(String message) {
        sender.sendMessage(message);
    }

    @Override
    public boolean isPlayer() {
        return sender instanceof Player;
    }

    @Override
    public String getName() {
        return sender.getName();
    }
}
