package Controle;

import Modelo.Cliente;
import Modelo.DAO.ClienteDAO;
import Visao.InterfaceCliente;
import Visao.LoginCliente;
import Visao.MenuPrincipalCliente;
import javax.swing.JOptionPane;

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

    public void printaMensagemTeste() {
        System.out.println("Opa");

        this.view.exibeMensagem("Executei o teste pintamsg");
    }
    
    public boolean logaCliente(){
        String email = this.view.getEmailTextField().getText();
        char[] senha = this.view.getSenhaPassField().getPassword();
        ClienteDAO cd = new ClienteDAO();
        Cliente cliente = cd.consultaEmailCliente(email);
        if(cliente == null){
            JOptionPane.showMessageDialog(this.view, "Usuario incorreto");
            return false;
        }
        if(!cliente.getSenha().equals(String.valueOf(senha))){
            JOptionPane.showMessageDialog(this.view, "Senha incorreta");
            return false;
        }
        JOptionPane.showMessageDialog(this.view, "Login feito com sucesso!");
        return true;
    }
    
    public void navegaTelaPrincipalCliente(){
        MenuPrincipalCliente mpc = new MenuPrincipalCliente();
        mpc.setVisible(true);
        this.view.dispose();
    }
}
