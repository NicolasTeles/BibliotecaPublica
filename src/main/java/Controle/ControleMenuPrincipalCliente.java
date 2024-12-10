/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Controle.Helpers.MenuPrincipalClienteHelper;
import Modelo.DAO.LivroDAO;
import Modelo.Livro;
import Visao.DevolucaoCliente;
import Visao.LoginCliente;
import Visao.MenuPrincipalCliente;
import Visao.PerfilCliente;
import Visao.ReservaLivro;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author felip
 */
public class ControleMenuPrincipalCliente {
    private final MenuPrincipalCliente view;
    private final MenuPrincipalClienteHelper helper;

    public ControleMenuPrincipalCliente(MenuPrincipalCliente view) {
        this.view = view;
        this.helper = new MenuPrincipalClienteHelper(view);
    }

    public void navegaPerfil() {
        PerfilCliente ig = new PerfilCliente();
        ig.setVisible(true);
        this.view.dispose();
    }

    public void logout() {
        LoginCliente ig = new LoginCliente();
        ig.setVisible(true);
        this.view.dispose();
    }

    public void navegaDevolucao() {
        DevolucaoCliente ig = new DevolucaoCliente();
        ig.setVisible(true);
        this.view.dispose();
    }

    public void acessaLivro(int indexLinha) {
        Livro livro = this.helper.leLinha(indexLinha);
        ReservaLivro rl = new ReservaLivro(livro);
        rl.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void inicia() {
        LivroDAO cd = new LivroDAO();
        List<Livro> livros = cd.listarLivrosCliente();
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
