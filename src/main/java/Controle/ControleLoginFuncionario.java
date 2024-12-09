package Controle;

import Modelo.DAO.FuncionarioDAO;
import Modelo.Funcionario;
import Modelo.Session;
import Visao.InterfaceGeral;
import Visao.LoginFuncionario;
import Visao.MenuLivroFuncionario;
import Visao.MenuPerfilFuncionario;
import javax.swing.JOptionPane;

public class ControleLoginFuncionario {

    

    public ControleLoginFuncionario(){
        
    }

    public void navegaTelaPrincipal(){
        InterfaceGeral ig = new InterfaceGeral();
        ig.setVisible(true);
    }

    
    public boolean logaFuncionario(String login, char[] senha){
        FuncionarioDAO fd = new FuncionarioDAO();
        Funcionario funcionario = fd.consultaLoginFuncionario(login);
        if(funcionario == null)
            funcionario = fd.consultaFuncionario(login);
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
