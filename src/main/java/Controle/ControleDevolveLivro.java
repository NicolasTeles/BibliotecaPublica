/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Modelo.Emprestimo;
import Modelo.Livro;
import Visao.DevolveLivro;

/**
 *
 * @author nicol
 */
public class ControleDevolveLivro {

    
    public ControleDevolveLivro(){}
    
    
    public boolean devolve(Emprestimo emprestimo){
        if(emprestimo == null)
            return false;
        emprestimo.setDevolvido(true);
        return true;
    }
}
