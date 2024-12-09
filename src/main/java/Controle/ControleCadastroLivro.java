package Controle;

import Modelo.Livro;
import Visao.CadastroLivro;
import Visao.InterfaceGeral;

public class ControleCadastroLivro {

    private final CadastroLivro view;

    public ControleCadastroLivro(CadastroLivro view){
        this.view = view;
    }
    
    public ControleCadastroLivro(CadastroLivro view, Livro livro){
        this.view = view;
        this.view.getTextNome().setText(livro.getNome());
        this.view.getTextAutor().setText(livro.getAutor());
        this.view.getTextEditora().setText(livro.getEditora());
        this.view.getTextAnoPubli().setText(Integer.toString(livro.getAnoPubli()));
    }

    public void navegaInterfaceGeral(){
        InterfaceGeral ig = new InterfaceGeral();
        ig.setVisible(true);
        this.view.dispose();
    }

    public void printaMensagemTeste() {
        System.out.println("Opa");

        this.view.exibeMensagem("Executei o teste pintamsg");
    }
}
