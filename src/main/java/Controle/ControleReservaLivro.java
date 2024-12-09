/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Modelo.Livro;
import Visao.ReservaLivro;

/**
 *
 * @author felip
 */
public class ControleReservaLivro {
    private final ReservaLivro view;

    public ControleReservaLivro(ReservaLivro view) {
        this.view = view;
    }
    
    public ControleReservaLivro(ReservaLivro view, Livro livro){
        this.view = view;
        this.view.getTextNome().setText(livro.getNome());
        this.view.getTextAutor().setText(livro.getAutor());
        this.view.getTextEditora().setText(livro.getEditora());
        this.view.getTextAno().setText(Integer.toString(livro.getAnoPubli()));
    }
    
    public void reserva(){
        //acessa banco
        this.view.dispose();
    }
}
