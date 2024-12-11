/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Modelo.DAO.LivroDAO;
import Modelo.Livro;

/**
 *
 * @author felip
 */
public class ControleReservaLivro {

    public ControleReservaLivro() {}
    
    public void reserva(Livro livro){
        LivroDAO ld = new LivroDAO();
        ld.emprestaDevolve(false, livro.getID());
        //criaria um emprestimo quando se tiver acesso à session
    }
}
