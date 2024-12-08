package Controle;


import Visao.MenuPerfilFuncionario;
import Visao.LoginFuncionario;
import Visao.MenuLivroFuncionario;
import Visao.MenuClienteFuncionario;
import Visao.MenuFuncionariosAdm;
import Visao.CadastroFuncionario;

/**
 *
 * @author pichau
 */
public class ControleMenuFuncionariosAdm {

    private final MenuFuncionariosAdm view;
    
    
    public ControleMenuFuncionariosAdm(MenuFuncionariosAdm view){
        this.view = view;
    }

    public ControleMenuFuncionariosAdm() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void irPerfilFuncionario(){
        MenuPerfilFuncionario perfil = new MenuPerfilFuncionario();
        perfil.setVisible(true);
        this.view.dispose();
    }
    
    public void retornarTelaLogin(){
        LoginFuncionario login = new LoginFuncionario();
        login.setVisible(true);
        this.view.dispose();
    }
    
    public void irMenuLivro(){
        MenuLivroFuncionario livro = new MenuLivroFuncionario();
        livro.setVisible(true);
        this.view.dispose();        
    }
    
    public void irMenuCliente(){
        MenuClienteFuncionario cliente = new MenuClienteFuncionario();
        cliente.setVisible(true);
        this.view.dispose();
    }
    
    public void irMenuFuncionarios(){
       //logica para verificar se eh adm
       MenuFuncionariosAdm funcionario = new MenuFuncionariosAdm();
       funcionario.setVisible(true);
       this.view.dispose();       
    }
    
    public void telaCadastroFuncionario(){
        //logica para cadastrar funcionario no banco de dados
        CadastroFuncionario cadastro = new CadastroFuncionario();
        cadastro.setVisible(true);
        this.view.dispose();        
    }
}
