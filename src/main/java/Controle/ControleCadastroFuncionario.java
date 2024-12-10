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

    private final CadastroFuncionario view;

    public ControleCadastroFuncionario(CadastroFuncionario view){
        this.view = view;
    }
    
    public ControleCadastroFuncionario(CadastroFuncionario view, Funcionario funcionario){
        this.view = view;
    }

    public void navegaTelaPrincipal(){
        InterfaceGeral ig = new InterfaceGeral();
        ig.setVisible(true);
        this.view.dispose();
    }
    
    public void navegaTelaPrincipalFuncionario(){
        MenuLivroFuncionario mlf = new MenuLivroFuncionario();
        mlf.setVisible(true);
        this.view.dispose();
    }

    public void printaMensagemTeste() {
        System.out.println("Opa");

        this.view.exibeMensagem("Executei o teste pintamsg");
    }
    
    public boolean cadastraFuncionario(){
        String nome = this.view.getNomeTextField().getText();
        String email = this.view.getEmailTextField().getText();
        String cpf = this.view.getCpfTextField().getText();
        char[] senha = this.view.getSenhaField().getPassword();
        char[] confirmaSenha = this.view.getConfirmaSenhaField().getPassword();
        if(!Arrays.equals(senha, confirmaSenha)){
            JOptionPane.showMessageDialog(this.view, "Senha e confirmacao de senha devem ser a mesma");
            return false;
        }
        String eAdm = String.valueOf(this.view.geteAdmComboBox().getSelectedItem());
        boolean adm = false;
        if(eAdm.equalsIgnoreCase("administrador"))
            adm = true;
        else if(eAdm.equalsIgnoreCase("funcionario"))
            adm = false;
        Funcionario funcionario = new Funcionario(nome, cpf, email, String.valueOf(senha), adm);
        FuncionarioDAO fd = new FuncionarioDAO();
        if(fd.insereFuncionario(funcionario)){
            JOptionPane.showMessageDialog(this.view, "Funcionario inserido com sucesso");
            return true;
        }
        return false;
    }
}
