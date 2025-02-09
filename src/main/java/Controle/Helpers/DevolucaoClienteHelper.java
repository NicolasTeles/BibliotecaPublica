/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle.Helpers;

import Modelo.DAO.EmprestimoDAO;
import Modelo.DAO.LivroDAO;
import Modelo.Emprestimo;
import Modelo.Livro;
import com.mysql.cj.conf.ConnectionUrlParser.Pair;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nicol
 */
public class DevolucaoClienteHelper {
    
    public Pair<Emprestimo,Livro> leLinha(int indexLinha, DefaultTableModel tableModel){
        Vector linha = (Vector)tableModel.getDataVector().get(indexLinha);
        LivroDAO ld = LivroDAO.getInstancia();
        Livro livro = ld.consultaLivroNome(String.valueOf(linha.get(0)));
        EmprestimoDAO ed = EmprestimoDAO.getInstancia();
        Emprestimo emprestimo = ed.consultaEmprestimoLivro(livro.getID());
        Pair<Emprestimo, Livro> tupla = new Pair<>(emprestimo, livro);
        return tupla;
    }
    
    public void preencheTabela(List<Emprestimo> emprestimos, DefaultTableModel tableModel){
        tableModel.setNumRows(0);
        for(Emprestimo emprestimo : emprestimos){
            tableModel.addRow(new Object[]{
                emprestimo.getLivro().getNome(),
                emprestimo.getDataInicial(),
                emprestimo.getVencimento()
            });
        }
    }
}
