package Controle;

import Modelo.Cliente;
import Persistencia.ClienteDAO;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class ControleCadastroCliente {

    public ControleCadastroCliente() {   
    }
    
    public boolean cadastraCliente(String nome, String cpf, String email, char senha[], char confirmaSenha[]){ 
        System.out.println(senha);
        System.out.println(confirmaSenha);
        
        if(!Arrays.equals(senha, confirmaSenha)){
            JOptionPane.showMessageDialog(null, "Senha nao bate com confirma senha");
            return false;
        }
        Cliente cliente = new Cliente(nome, cpf, email, String.valueOf(senha));
        ClienteDAO cd = ClienteDAO.getInstancia();
        if(cd.criarConta(cliente)){
            JOptionPane.showMessageDialog(null, "Cliente inserido com sucesso!");
            return true;
        }
        return false;
    }
    
    public boolean atualizaCliente(String nome, String email, String cpf, char[] senha, char[] confirmaSenha){
        if(!Arrays.equals(senha, confirmaSenha)){
            JOptionPane.showMessageDialog(null, "Senha e confirma senha nao coincidem");
            return false;
        }
        Cliente cliente = new Cliente(nome, cpf, email, String.valueOf(senha));
        ClienteDAO cd = ClienteDAO.getInstancia();
        cliente.setStatusCliente(cd.consultaCliente(cpf).getStatusCliente());
        if(String.valueOf(senha).equals("")){
            return cd.atualizaContaSemSenha(cliente);
        }else{
            return cd.atualizaConta(cliente);
        }
    }
}
