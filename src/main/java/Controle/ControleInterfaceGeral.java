package Controle;

import Visao.InterfaceCliente;
import Visao.InterfaceGeral;
import Visao.LoginFuncionario;

public class ControleInterfaceGeral {
    private final InterfaceGeral view;

    public ControleInterfaceGeral(InterfaceGeral view){
        this.view = view;
    }

    public void navegaTelaClientes(){
        InterfaceCliente ic = new InterfaceCliente();
        ic.setVisible(true);
        this.view.dispose();
    }

    public void navegaTelaFuncionarios(){
        LoginFuncionario loginFuncionario = new LoginFuncionario();
        loginFuncionario.setVisible(true);
        this.view.dispose();
    }

    public void printaMensagemTeste() {
        System.out.println("Opa");

        this.view.exibeMensagem("Executei o teste pintamsg");
    }
}