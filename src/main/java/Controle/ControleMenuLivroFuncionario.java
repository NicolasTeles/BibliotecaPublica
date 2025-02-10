
package Controle;

import Controle.Helpers.MenuLivroFuncionarioHelper;
import Persistencia.LivroDAO;
import Modelo.Livro;
import Modelo.Session;
import java.util.ArrayList;
import java.util.List;
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
    
    public Livro acessaLivro(int indexLinha, DefaultTableModel tableModel){
        return this.helper.leLinha(indexLinha, tableModel);
    }
    
    public void inicia(DefaultTableModel tableModel) {
        LivroDAO cd = LivroDAO.getInstancia();
        List<Livro> livros = cd.listarLivros();
        this.helper.preencheTabela(livros, tableModel);
    }

    public void pesquisaLivro(String pesquisa, DefaultTableModel tableModel) {
        LivroDAO cd = LivroDAO.getInstancia();
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
       
    }
    
    public void logoutFuncionario(){
        Session.destroiFuncionario();
    }
}
