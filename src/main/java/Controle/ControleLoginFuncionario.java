package Controle;

import Modelo.DAO.FuncionarioDAO;
import Modelo.Funcionario;
import Visao.InterfaceGeral;
import Visao.LoginFuncionario;
import Visao.MenuLivroFuncionario;
import javax.swing.JOptionPane;

public class ControleLoginFuncionario {

    private final LoginFuncionario view;

    public ControleLoginFuncionario(LoginFuncionario view){
        this.view = view;
    }

    public void navegaTelaPrincipal(){
        InterfaceGeral ig = new InterfaceGeral();
        ig.setVisible(true);
        this.view.dispose();
    }

    public void printaMensagemTeste() {
        System.out.println("Opa");

        this.view.exibeMensagem("Executei o teste pintamsg");
    }
    
    public boolean logaFuncionario(){
        String email = this.view.getEmailTextField().getText();
        char[] senha = this.view.getSenhaPassField().getPassword();
        FuncionarioDAO fd = new FuncionarioDAO();
        Funcionario funcionario = fd.consultaLoginFuncionario(email);
        if(funcionario == null){
            JOptionPane.showMessageDialog(this.view, "Usuario incorreto");
            return false;
        }
        if(!funcionario.getSenha().equals(String.valueOf(senha))){
            JOptionPane.showMessageDialog(this.view, "Senha incorreta");
            return false;
        }
        JOptionPane.showMessageDialog(this.view, "Login feito com sucesso!");
        return true;
    }
    
    public void navegaTelaPrincipalFuncionario(){
        MenuLivroFuncionario mlf = new MenuLivroFuncionario();
        mlf.setVisible(true);
        this.view.dispose();
    }
}
