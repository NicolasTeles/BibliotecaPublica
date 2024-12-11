
package Controle;

import Controle.Helpers.MenuLivroFuncionarioHelper;
import Modelo.DAO.LivroDAO;
import Modelo.Livro;
import Modelo.Session;
import Visao.MenuPerfilFuncionario;
import Visao.LoginFuncionario;
import Visao.MenuClienteFuncionario;
import Visao.MenuFuncionariosAdm;
import Visao.CadastroLivro;
import Visao.InterfaceGeral;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pichau
 */
public class ControleMenuLivroFuncionario {

    private final MenuLivroFuncionarioHelper helper;
    
    public ControleMenuLivroFuncionario(){
        this.helper = new MenuLivroFuncionarioHelper();
    }
    
    public void irPerfilFuncionario(){
        MenuPerfilFuncionario perfil = new MenuPerfilFuncionario();
        perfil.setVisible(true);
    }
    
    public void retornarTelaLogin(){
        LoginFuncionario login = new LoginFuncionario();
        login.setVisible(true);
    }
 
    public void irMenuCliente(){
        MenuClienteFuncionario cliente = new MenuClienteFuncionario();
        cliente.setVisible(true);
    }
    
    public void irMenuFuncionarios(){
       //logica para verificar se eh adm
       MenuFuncionariosAdm funcionario = new MenuFuncionariosAdm();
       funcionario.setVisible(true);    
    }
    
    public void telaCadastroLivro(){
        //logica para cadastrar livro no banco de dados
        CadastroLivro cadastro = new CadastroLivro();
        cadastro.setVisible(true);       
    }
    
    public void acessaLivro(int indexLinha, DefaultTableModel tableModel){
        Livro livro = this.helper.leLinha(indexLinha, tableModel);
        //chama devolve livro com esse livro como parametro
        CadastroLivro dv = new CadastroLivro(livro);
        dv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void inicia(DefaultTableModel tableModel) {
        LivroDAO cd = new LivroDAO();
        List<Livro> livros = cd.listarLivros();
        this.helper.preencheTabela(livros, tableModel);
    }

    public void pesquisaLivro(String pesquisa, DefaultTableModel tableModel) {
        LivroDAO cd = new LivroDAO();
        List<Livro> livros = new ArrayList<>();
        List<Livro> todosOsLivros = cd.listarLivros();
        //String pesquisa = this.view.getFieldPesquisa().getText().toLowerCase();
        
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
            this.helper.preencheTabela(todosOsLivros, tableModel);
        else
            this.helper.preencheTabela(livros, tableModel);
        
    }
    
    public void irInterfaceGeral(){
       InterfaceGeral ig = new InterfaceGeral();
       ig.setVisible(true);
    }
    
    public void logoutFuncionario(){
        Session.destroiFuncionario();
    }
}
