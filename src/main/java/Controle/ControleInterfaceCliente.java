package Controle;

import Visao.CadastroCliente;
import Visao.InterfaceCliente;
import Visao.InterfaceGeral;
import Visao.LoginCliente;

public class ControleInterfaceCliente {

    public void navegaTelaPrincipal(){
        InterfaceGeral ig = new InterfaceGeral();
        ig.setVisible(true);
    }

    public void navegaCadastroCliente(){
        CadastroCliente cadastroCliente = new CadastroCliente();
        cadastroCliente.setVisible(true);
    }

    public void navegaLoginCliente(){
        LoginCliente loginCliente = new LoginCliente();
        loginCliente.setVisible(true);

    }

    public void printaMensagemTeste() {
        System.out.println("Opa");

        //this.view.exibeMensagem("Executei o teste pintamsg");
    }
}
