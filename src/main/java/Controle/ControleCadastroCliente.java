package Controle;

import Modelo.Cliente;
import Modelo.DAO.ClienteDAO;
import Visao.CadastroCliente;
import Visao.InterfaceGeral;
import Visao.MenuPrincipalCliente;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class ControleCadastroCliente {
    private final CadastroCliente view;

    public ControleCadastroCliente(CadastroCliente view) {
        this.view = view;
    }

    public void entrarNoSistema(){
        //logica que envolve o banco aqui
    }

    public void retornaInterfaceGeral(){
        InterfaceGeral ig = new InterfaceGeral();
        ig.setVisible(true);
        this.view.dispose();
    }
    
    public void navegaMenuCliente(){
        MenuPrincipalCliente ig = new MenuPrincipalCliente();
        ig.setVisible(true);
        this.view.dispose();
    }

    public void printaMensagemTeste() {
        System.out.println("Opa");

        this.view.exibeMensagem("Executei o teste pintamsg");
    }
    
    public boolean cadastraCliente(){
        String nome = this.view.getNomeTextField().getText();
        String cpf = this.view.getCpfTextField().getText();
        String email = this.view.getEmailTextField().getText();
        char senha[] = this.view.getSenhaField().getPassword();
        char confirmaSenha[] = this.view.getSenhaField().getPassword();
        
        System.out.println(senha);
        System.out.println(confirmaSenha);
        
        if(!Arrays.equals(senha, confirmaSenha)){
            JOptionPane.showMessageDialog(view, "Senha nao bate com confirma senha");
            return false;
        }
        Cliente cliente = new Cliente(nome, cpf, email, String.valueOf(senha));
        ClienteDAO cd = new ClienteDAO();
        if(cd.criarConta(cliente)){
            JOptionPane.showMessageDialog(view, "Cliente inserido com sucesso!");
            return true;
        }
        return false;
    }
}
