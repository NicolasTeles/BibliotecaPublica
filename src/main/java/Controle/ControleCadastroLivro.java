package Controle;

import Modelo.Livro;
import Visao.InterfaceGeral;

public class ControleCadastroLivro {

    public ControleCadastroLivro(){}
    
    public ControleCadastroLivro(){
        this.view = view;
        this.view.getTextNome().setText(livro.getNome());
        this.view.getTextAutor().setText(livro.getAutor());
        this.view.getTextEditora().setText(livro.getEditora());
        this.view.getTextAnoPubli().setText(Integer.toString(livro.getAnoPubli()));
    }

    public void navegaInterfaceGeral(){
        InterfaceGeral ig = new InterfaceGeral();
        ig.setVisible(true);
    }
}
