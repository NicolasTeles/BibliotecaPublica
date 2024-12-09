
package Controle;

import Controle.Helpers.MenuLivroFuncionarioHelper;
import Modelo.Livro;
import Visao.MenuPerfilFuncionario;
import Visao.LoginFuncionario;
import Visao.MenuLivroFuncionario;
import Visao.MenuClienteFuncionario;
import Visao.MenuFuncionariosAdm;
import Visao.CadastroLivro;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author pichau
 */
public class ControleMenuLivroFuncionario {

    private final MenuLivroFuncionario view;
    private final MenuLivroFuncionarioHelper helper;
    
    public ControleMenuLivroFuncionario(MenuLivroFuncionario view){
        this.view = view;
        this.helper = new MenuLivroFuncionarioHelper(view);
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
    
    public void acessaLivro(int indexLinha){
        Livro livro = this.helper.leLinha(indexLinha);
        //chama devolve livro com esse livro como parametro
        CadastroLivro dv = new CadastroLivro(livro);
        dv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
