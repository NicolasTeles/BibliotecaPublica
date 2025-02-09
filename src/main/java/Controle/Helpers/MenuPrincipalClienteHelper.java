/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle.Helpers;

import DAO.LivroDAO;
import Modelo.Livro;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nicol
 */
public class MenuPrincipalClienteHelper {
    
    public Livro leLinha(int indexLinha, DefaultTableModel tableModel){
        Vector linha = (Vector) tableModel.getDataVector().get(indexLinha);
        LivroDAO ld = LivroDAO.getInstancia();
        Livro livro = ld.consultaLivroNome(String.valueOf(linha.get(0)));
        return livro;
    }

    public void preencheTabela(List<Livro> livros, DefaultTableModel tableModel) {
        tableModel.setNumRows(0);
        for(Livro livro : livros){
            tableModel.addRow(new Object[]{
               livro.getNome(),
               livro.getEditora(),
               livro.getAutor(),
               livro.getAnoPubli(),
               (livro.getNumAvaliacoes() > 0) 
                ? (double)livro.getTotalAvaliacao() / (double)livro.getNumAvaliacoes()
                : "Sem avaliações",
               livro.getStatus()
            });
        }
    }
}
