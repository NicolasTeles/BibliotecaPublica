package Controle;

import Modelo.Cliente;
import Persistencia.ClienteDAO;
import Modelo.Session;
import javax.swing.JOptionPane;

public class ControleLoginCliente {


    public ControleLoginCliente(){
    }
    
    public boolean logaCliente(String login, char[] senha){
        ClienteDAO cd = ClienteDAO.getInstancia();
        Cliente cliente = cd.consultaEmailCliente(login);
        if(cliente == null)
            cliente = cd.consultaCliente(login);
        if(cliente == null){
            JOptionPane.showMessageDialog(null, "Usuario incorreto");
            return false;
        }
        if(!cliente.getSenha().equals(String.valueOf(senha))){
            JOptionPane.showMessageDialog(null, "Senha incorreta");
            return false;
        }
        JOptionPane.showMessageDialog(null, "Login feito com sucesso!");
        Session.criaCliente(cliente);
        return true;
    }
 
}