package Controle;

import Modelo.Cliente;
import Modelo.DAO.ClienteDAO;
import Visao.InterfaceCliente;
import Visao.MenuPrincipalCliente;
import javax.swing.JOptionPane;

public class ControleLoginCliente {


    public ControleLoginCliente(){
    }

    public void navegaTelaCliente(){
        InterfaceCliente ic = new InterfaceCliente();
        ic.setVisible(true);
    }

    
    public boolean logaCliente(String email, char[] senha){
        ClienteDAO cd = new ClienteDAO();
        Cliente cliente = cd.consultaEmailCliente(email);
        if(cliente == null){
            JOptionPane.showMessageDialog(null, "Usuario incorreto");
            return false;
        }
        if(!cliente.getSenha().equals(String.valueOf(senha))){
            JOptionPane.showMessageDialog(null, "Senha incorreta");
            return false;
        }
        JOptionPane.showMessageDialog(null, "Login feito com sucesso!");
        return true;
    }
    
    public void navegaTelaPrincipalCliente(){
        MenuPrincipalCliente mpc = new MenuPrincipalCliente();
        mpc.setVisible(true);
    }
}
