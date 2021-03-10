package net.eduard.curso.projeto.permissao.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PermissaoComandoBungee implements CommandExecutor {
    private IPermissaoComando comando;

    public PermissaoComandoBungee(IPermissaoComando comando) {
        this.comando = comando;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        comando.onCommand(new PermissaoCommandSenderBukkit(sender) , args);
        return false;
    }
}
