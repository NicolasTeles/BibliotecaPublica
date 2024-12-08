/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Modelo.Livro;
import Visao.DevolveLivro;

/**
 *
 * @author nicol
 */
public class ControleDevolveLivro {

    private final DevolveLivro view;
    
    public ControleDevolveLivro(DevolveLivro view){
        this.view = view;
    }
    
    public ControleDevolveLivro(DevolveLivro view, Livro livro){
        this.view = view;
        this.view.getTextNome().setText(livro.getNome());
        this.view.getTextAutor().setText(livro.getAutor());
        this.view.getTextEditora().setText(livro.getEditora());
        this.view.getTextAno().setText(Integer.toString(livro.getAnoPubli()));
    }
    
    public void devolve(){
        //logica do bd
        this.view.dispose();
    }
}
