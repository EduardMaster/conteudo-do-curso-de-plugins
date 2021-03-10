package net.eduard.curso.projeto.permissao.cmd;

import net.eduard.curso.projeto.permissao.ProjetoPermissao;
import net.eduard.curso.projeto.permissao.objetos.PermissaoManager;
import net.eduard.curso.projeto.permissao.objetos.PermissaoUsuario;

public class PermissaoComando implements IPermissaoComando {
    @Override
    public void onCommand(IPermissaoComandoSender sender, String... args) {
        PermissaoManager manager = ProjetoPermissao.getManager();
        if (args.length == 0){
            if (!(sender.isPlayer())){
                return;
            }
            PermissaoUsuario usuario = manager
                    .getUsuario(sender.getName());

            sender.sendMessage("Você tem: "+ usuario.getGroupsNames().size() + " cargos");

            sender.sendMessage("Você tem: "+ usuario.getPermissoes().size()
                    + " permissões direto no seu perfil");

            sender.sendMessage("Você tem: "+ usuario.getPermissoesCalculadas().size()
                    + " permissões ativadas no momento");



        }
    }



}
