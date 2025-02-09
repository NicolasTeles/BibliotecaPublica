/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Modelo.Cliente;
import DAO.EmprestimoDAO;
import DAO.LivroDAO;
import Modelo.Emprestimo;
import Modelo.Livro;
import Modelo.Session;
import javax.swing.JOptionPane;

/**
 *
 * @author felip
 */
public class ControleReservaLivro {

    public ControleReservaLivro() {}
    
    public void reserva(Livro livro){
        Cliente cliente = Session.getCliente();
        if(cliente.getStatusCliente()){
            LivroDAO ld = LivroDAO.getInstancia();
            ld.emprestaDevolve(false, livro.getID());
            Emprestimo emprestimo = new Emprestimo(cliente, false, livro);
            EmprestimoDAO emp = EmprestimoDAO.getInstancia();
            emp.criaEmprestimo(emprestimo);
            return;
        }
        JOptionPane.showMessageDialog(null,"Livro não reservado, você está banido!");
    }
}
