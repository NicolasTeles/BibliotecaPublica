/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Modelo.Cliente;
import Modelo.DAO.ClienteDAO;
import Modelo.DAO.EmprestimoDAO;
import Modelo.DAO.LivroDAO;
import Modelo.Emprestimo;

/**
 *
 * @author nicol
 */
public class ControleDevolveLivro {

    
    public ControleDevolveLivro(){}
    
    
    public boolean devolve(Emprestimo emprestimo){
        if(emprestimo == null)
            return false;
        EmprestimoDAO ed = EmprestimoDAO.getInstancia();
        Cliente cliente = emprestimo.getCliente();
        ClienteDAO cd = ClienteDAO.getInstancia();
        LivroDAO ld = new LivroDAO();
        ld.emprestaDevolve(true, emprestimo.getLivro().getID());
        ed.devolve(emprestimo.getId());
        if(cliente.getStatusCliente() == false){
            cliente.setStatusCliente(true);
            cd.atualizaStatus(cliente);
        }
        emprestimo.setDevolvido(true);
        return true;
    }
}
