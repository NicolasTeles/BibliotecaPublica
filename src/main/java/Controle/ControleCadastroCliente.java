package Controle;

import Modelo.Cliente;
import Modelo.DAO.ClienteDAO;
import Visao.InterfaceGeral;
import Visao.MenuPrincipalCliente;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class ControleCadastroCliente {

    public ControleCadastroCliente() {   
    }

    public void retornaInterfaceGeral(){
        InterfaceGeral ig = new InterfaceGeral();
        ig.setVisible(true);
    }
    
    public void navegaMenuCliente(){
        MenuPrincipalCliente ig = new MenuPrincipalCliente();
        ig.setVisible(true);
    }
    
    public boolean cadastraCliente(String nome, String cpf, String email, char senha[], char confirmaSenha[]){ 
        System.out.println(senha);
        System.out.println(confirmaSenha);
        
        if(!Arrays.equals(senha, confirmaSenha)){
            JOptionPane.showMessageDialog(null, "Senha nao bate com confirma senha");
            return false;
        }
        Cliente cliente = new Cliente(nome, cpf, email, String.valueOf(senha));
        ClienteDAO cd = new ClienteDAO();
        if(cd.criarConta(cliente)){
            JOptionPane.showMessageDialog(null, "Cliente inserido com sucesso!");
            return true;
        }
        return false;
    }
}
