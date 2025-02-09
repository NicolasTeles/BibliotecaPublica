package Controle;

import Modelo.DAO.FuncionarioDAO;
import Modelo.Funcionario;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class ControleCadastroFuncionario {

    public ControleCadastroFuncionario(){
    }
    
    public ControleCadastroFuncionario(Funcionario funcionario){
        
    }
    
    public boolean atualizaFuncionario(String nome, String email, String cpf, char[] senha, char[] confirmaSenha, boolean cargo){
        FuncionarioDAO fd = FuncionarioDAO.getInstancia();
        Funcionario funcionario = new Funcionario(nome, cpf, email, String.valueOf(senha), cargo);
        if(!Arrays.equals(senha, confirmaSenha)){
            JOptionPane.showMessageDialog(null, "Senha e confirma senha nao coincidem");
            return false;
        }
        if(String.valueOf(senha).equals("")){
            return fd.atualizaFuncionarioSemSenha(funcionario);
        }else{
            return fd.atualizaFuncionario(funcionario);
        }
    }
    
    public boolean cadastraFuncionario(String nome, String email, String cpf, char[] senha, char[] confirmaSenha, String eAdm){
        FuncionarioDAO fd = FuncionarioDAO.getInstancia();
        
        if(fd.consultaLoginFuncionario(email) != null){
            JOptionPane.showMessageDialog(null, "Este email ja existe");
            return false;
        }        
        if(fd.consultaFuncionario(cpf) != null){
            JOptionPane.showMessageDialog(null, "Este cpf ja existe");
            return false;
        }
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
        
        if(fd.insereFuncionario(funcionario)){
            JOptionPane.showMessageDialog(null, "Funcionario inserido com sucesso");
            return true;
        }
        return false;
    }
}
