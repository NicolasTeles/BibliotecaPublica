package Controle;

import Visao.InterfaceCliente;
import Visao.InterfaceGeral;
import Visao.LoginFuncionario;

public class ControleInterfaceGeral {

    public ControleInterfaceGeral(InterfaceGeral view){
    }

    public void navegaTelaClientes(){
        InterfaceCliente ic = new InterfaceCliente();
        ic.setVisible(true);
    }

    public void navegaTelaFuncionarios(){
        LoginFuncionario loginFuncionario = new LoginFuncionario();
        loginFuncionario.setVisible(true);
    }

}