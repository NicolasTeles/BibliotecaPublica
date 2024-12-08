
package Controle;

import Visao.MenuPerfilFuncionario;
import Visao.LoginFuncionario;
import Visao.MenuLivroFuncionario;
import Visao.MenuClienteFuncionario;
import Visao.MenuFuncionariosAdm;
import Visao.CadastroLivro;

/**
 *
 * @author pichau
 */
public class ControleMenuLivroFuncionario {

    private final MenuLivroFuncionario view;
    
    public ControleMenuLivroFuncionario(MenuLivroFuncionario view){
        this.view = view;
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
    
    public void telaCadastroLivro(){
        //logica para cadastrar livro no banco de dados
        CadastroLivro cadastro = new CadastroLivro();
        cadastro.setVisible(true);
        this.view.dispose();        
    }
}
