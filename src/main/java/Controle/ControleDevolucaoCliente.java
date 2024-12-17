/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Controle.Helpers.DevolucaoClienteHelper;
import Modelo.DAO.EmprestimoDAO;
import Modelo.Emprestimo;
import Modelo.Livro;
import Modelo.Session;
import com.mysql.cj.conf.ConnectionUrlParser.Pair;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nicol
 */
public class ControleDevolucaoCliente {
    private final DevolucaoClienteHelper helper;
    
    public ControleDevolucaoCliente(){
        this.helper = new DevolucaoClienteHelper();
    }
    
    public Pair<Emprestimo, Livro> acessaLivro(int indexLinha, DefaultTableModel tableModel){
        return this.helper.leLinha(indexLinha, tableModel);
    }
    
    public void inicia(DefaultTableModel tableModel){
        EmprestimoDAO ed = new EmprestimoDAO();
        List<Emprestimo> emprestimos = ed.buscaEmprestimosCliente(Session.getCliente());
        this.helper.preencheTabela(emprestimos, tableModel);
    }
}
