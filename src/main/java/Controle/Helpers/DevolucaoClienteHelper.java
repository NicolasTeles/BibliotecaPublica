/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle.Helpers;

import Modelo.DAO.EmprestimoDAO;
import Modelo.DAO.LivroDAO;
import Modelo.Emprestimo;
import Modelo.Livro;
import Visao.DevolucaoCliente;
import com.mysql.cj.conf.ConnectionUrlParser.Pair;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nicol
 */
public class DevolucaoClienteHelper {
    
    public Pair<Emprestimo,Livro> leLinha(int indexLinha, DefaultTableModel tableModel){
        Vector linha = (Vector)tableModel.getDataVector().get(indexLinha);
        LivroDAO ld = new LivroDAO();
        Livro livro = ld.consultaLivroNome(String.valueOf(linha.get(0)));
        EmprestimoDAO ed = new EmprestimoDAO();
        Emprestimo emprestimo = ed.consultaEmprestimoLivro(livro.getID());
        Pair<Emprestimo, Livro> tupla = new Pair<>(emprestimo, livro);
        return tupla;
    }
}
