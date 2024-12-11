package Controle;

import Modelo.DAO.FuncionarioDAO;
import Modelo.Funcionario;
import Visao.CadastroFuncionario;
import Visao.CadastroLivro;
import Visao.InterfaceGeral;
import Visao.MenuLivroFuncionario;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class ControleCadastroFuncionario {

    public ControleCadastroFuncionario(){
    }
    
    public ControleCadastroFuncionario(Funcionario funcionario){
    }
    
    public void navegaTelaPrincipalFuncionario(){
        MenuLivroFuncionario mlf = new MenuLivroFuncionario();
        mlf.setVisible(true);
    }
    
    public boolean cadastraFuncionario(String nome, String email, String cpf, char[] senha, char[] confirmaSenha, String eAdm){
        if(!Arrays.equals(senha, confirmaSenha)){
            JOptionPane.showMessageDialog(null, "Senha e confirmacao de senha devem ser a mesma");
            return false;
        }
        boolean adm = false;
        if(eAdm.equalsIgnoreCase("administrador"))
            adm = true;
        else if(eAdm.equalsIgnoreCase("funcionario"))
            adm = false;
        Funcionario funcionario = new Funcionario(nome, cpf, email, String.valueOf(senha), adm);
        FuncionarioDAO fd = new FuncionarioDAO();
        if(fd.insereFuncionario(funcionario)){
            JOptionPane.showMessageDialog(null, "Funcionario inserido com sucesso");
            return true;
        }
        return false;
    }
}
