package Controle;

import Visao.CadastroCliente;
import Visao.InterfaceCliente;
import Visao.InterfaceGeral;
import Visao.LoginCliente;

public class ControleInterfaceCliente {

    private final InterfaceCliente view;

    public ControleInterfaceCliente(InterfaceCliente view){
        this.view = view;
    }

    public void navegaTelaPrincipal(){
        InterfaceGeral ig = new InterfaceGeral();
        ig.setVisible(true);
        this.view.dispose();
    }

    public void navegaCadastroCliente(){
        CadastroCliente cadastroCliente = new CadastroCliente();
        cadastroCliente.setVisible(true);
        this.view.dispose();
    }

    public void navegaLoginCliente(){
        LoginCliente loginCliente = new LoginCliente();
        loginCliente.setVisible(true);
        this.view.dispose();
    }
}
