/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Modelo.DAO.EmprestimoDAO;
import Modelo.DAO.LivroDAO;
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
        EmprestimoDAO ed = new EmprestimoDAO();
        LivroDAO ld = new LivroDAO();
        ld.emprestaDevolve(true, emprestimo.getLivro().getID());
        ed.devolve(emprestimo.getId());
        emprestimo.setDevolvido(true);
        return true;
    }
}
