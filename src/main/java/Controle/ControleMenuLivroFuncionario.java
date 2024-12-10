
package Controle;

import Controle.Helpers.MenuLivroFuncionarioHelper;
import Modelo.DAO.LivroDAO;
import Modelo.Livro;
import Visao.MenuPerfilFuncionario;
import Visao.LoginFuncionario;
import Visao.MenuLivroFuncionario;
import Visao.MenuClienteFuncionario;
import Visao.MenuFuncionariosAdm;
import Visao.CadastroLivro;
import java.util.ArrayList;
import java.util.List;
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

    public void inicia() {
        LivroDAO cd = new LivroDAO();
        List<Livro> livros = cd.listarLivros();
        this.helper.preencheTabela(livros);
    }

    public void pesquisaLivro() {
        LivroDAO cd = new LivroDAO();
        List<Livro> livros = new ArrayList<>();
        List<Livro> todosOsLivros = cd.listarLivros();
        String pesquisa = this.view.getFieldPesquisa().getText().toLowerCase();
        
        if(pesquisa != null && !pesquisa.equalsIgnoreCase("")){
            pesquisa = pesquisa.toLowerCase();

            for(Livro livro : todosOsLivros){
                if(livro.getNome().toLowerCase().contains(pesquisa) || livro.getNome().equalsIgnoreCase(pesquisa))
                    livros.add(livro);
                else if(livro.getEditora().toLowerCase().contains(pesquisa) || livro.getEditora().equalsIgnoreCase(pesquisa))
                    livros.add(livro);
                else if(livro.getAutor().toLowerCase().contains(pesquisa) || livro.getAutor().equalsIgnoreCase(pesquisa))
                    livros.add(livro);
                else if(String.valueOf(livro.getAnoPubli()).equals(pesquisa)) 
                    livros.add(livro);
            }
        }
        if(livros.isEmpty())
            this.helper.preencheTabela(todosOsLivros);
        else
            this.helper.preencheTabela(livros);
        
    }
}
