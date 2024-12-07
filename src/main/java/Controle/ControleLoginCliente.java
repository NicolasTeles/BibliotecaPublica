package Controle;

import Visao.InterfaceCliente;
import Visao.LoginCliente;

public class ControleLoginCliente {

    private final LoginCliente view;

    public ControleLoginCliente(LoginCliente view){
        this.view = view;
    }

    public void navegaTelaCliente(){
        InterfaceCliente ic = new InterfaceCliente();
        ic.setVisible(true);
        this.view.dispose();
    }
}
