package net.eduard.curso.projeto.permissao.cmd;

public interface IPermissaoComandoSender {

    void sendMessage(String message);
    boolean isPlayer();
    String getName();

}
