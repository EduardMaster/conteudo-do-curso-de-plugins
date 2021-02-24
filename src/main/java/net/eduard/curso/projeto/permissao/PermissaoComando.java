package net.eduard.curso.projeto.permissao;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PermissaoComando implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        PermissaoManager manager = ProjetoPermissao.getManager();
        if (args.length == 0){
            if (!(sender instanceof Player)){
                return true;
            }

            Player player = (Player) sender;
            PermissaoUsuario usuario = manager
                    .getUsuario(player.getName());

            sender
                    .sendMessage("Você tem: "+ usuario.getGroupsNames().size() + " cargos");

            sender
                    .sendMessage("Você tem: "+ usuario.getPermissoes().size()
                            + " permissões direto no seu perfil");

            sender
                    .sendMessage("Você tem: "+ usuario.getPermissoesCalculadas().size()
                            + " permissões ativadas no momento");



        }

        return false;
    }
}
