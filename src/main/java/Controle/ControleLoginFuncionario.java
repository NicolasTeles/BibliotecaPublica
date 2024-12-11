package Controle;

import Modelo.DAO.FuncionarioDAO;
import Modelo.Funcionario;
import Modelo.Session;
import Visao.InterfaceGeral;
import Visao.LoginFuncionario;
import Visao.MenuLivroFuncionario;
import javax.swing.JOptionPane;

public class ControleLoginFuncionario {

    

    public ControleLoginFuncionario(){
        
    }

    public void navegaTelaPrincipal(){
        InterfaceGeral ig = new InterfaceGeral();
        ig.setVisible(true);
    }

    
    public boolean logaFuncionario(String email, char[] senha){
        FuncionarioDAO fd = new FuncionarioDAO();
        Funcionario funcionario = fd.consultaLoginFuncionario(email);
        if(funcionario == null){
            JOptionPane.showMessageDialog(null, "Usuario incorreto");
            return false;
        }
        if(!funcionario.getSenha().equals(String.valueOf(senha))){
            JOptionPane.showMessageDialog(null, "Senha incorreta");
            return false;
        }
        JOptionPane.showMessageDialog(null, "Login feito com sucesso!");
        Session.criaFuncionario(funcionario);
        return true;
    }
    
    public void navegaTelaPrincipalFuncionario(){
        MenuLivroFuncionario mlf = new MenuLivroFuncionario();
        mlf.setVisible(true);
    }
}
