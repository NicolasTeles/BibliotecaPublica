/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Controle.Helpers.MenuPrincipalClienteHelper;
import Persistencia.ClienteDAO;
import Persistencia.EmprestimoDAO;
import Persistencia.LivroDAO;
import Modelo.Livro;
import Modelo.Session;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author felip
 */
public class ControleMenuPrincipalCliente {
    private final MenuPrincipalClienteHelper helper;
    
    public boolean validaContaCliente(){
        EmprestimoDAO ed = EmprestimoDAO.getInstancia();
        if(ed.buscaEmprestimosAtrasados(Session.getCliente().getCpf())){
            ClienteDAO cd = ClienteDAO.getInstancia();
            Session.getCliente().setStatusCliente(false);
            cd.atualizaStatus(Session.getCliente());
            return false;
        }
        return true;
    }

    public ControleMenuPrincipalCliente() {
       this.helper = new MenuPrincipalClienteHelper();
    }

    public void logout() {
        Session.destroiCliente();
    }
    public Livro acessaLivro(int indexLinha, DefaultTableModel tableModel) {
        if(!this.validaContaCliente()){
            JOptionPane.showMessageDialog(null, "Voce possui um emprestimo atrasado, devolva o livro!");
            return null;
        }
        return this.helper.leLinha(indexLinha, tableModel);
    }

    public void inicia(DefaultTableModel tableModel) {
        LivroDAO cd = LivroDAO.getInstancia();
        List<Livro> livros = cd.listarLivrosCliente();
        this.helper.preencheTabela(livros, tableModel);
    }

    public void pesquisaLivro(String pesquisa, DefaultTableModel tableModel) {
        LivroDAO cd = LivroDAO.getInstancia();
        List<Livro> livros = new ArrayList<>();
        List<Livro> todosOsLivros = cd.listarLivrosCliente();
        
        if(pesquisa != null && !pesquisa.equalsIgnoreCase("")){

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
}
