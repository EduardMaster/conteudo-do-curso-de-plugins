package net.eduard.curso.projeto.permissao.cmd;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public class PermissaoComandoBukkit extends Command {
    private IPermissaoComando comando;

    public PermissaoComandoBukkit(IPermissaoComando comando) {
        super("permissao", "permissao.admin", "minipex");
        this.comando = comando;
    }


    @Override
    public void execute(CommandSender sender, String[] args) {
        comando.onCommand(new PermissaoCommandSendeBungee(sender) , args);

    }
}
