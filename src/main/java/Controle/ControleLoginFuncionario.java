package Controle;

import Visao.InterfaceGeral;
import Visao.LoginFuncionario;

public class ControleLoginFuncionario {

    private final LoginFuncionario view;

    public ControleLoginFuncionario(LoginFuncionario view){
        this.view = view;
    }

    public void navegaTelaPrincipal(){
        InterfaceGeral ig = new InterfaceGeral();
        ig.setVisible(true);
        this.view.dispose();
    }

    public void printaMensagemTeste() {
        System.out.println("Opa");

        this.view.exibeMensagem("Executei o teste pintamsg");
    }
}
