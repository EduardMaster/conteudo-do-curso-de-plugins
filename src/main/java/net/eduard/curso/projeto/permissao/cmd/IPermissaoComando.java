package net.eduard.curso.projeto.permissao.cmd;

public interface IPermissaoComando {

    void onCommand(IPermissaoComandoSender sender, String... args);

}
