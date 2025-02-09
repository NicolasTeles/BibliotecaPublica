/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle.Helpers;

import Modelo.DAO.LivroDAO;
import Modelo.Livro;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author felip
 */
public class MenuLivroFuncionarioHelper {
      
    public Livro leLinha(int indexLinha, DefaultTableModel tableModel){    
        LivroDAO ld = LivroDAO.getInstancia();
        //DefaultTableModel tableModel = (DefaultTableModel)this.view.getListaLivros().getModel();
        Vector linha = (Vector)tableModel.getDataVector().get(indexLinha);
        
        Livro livro = ld.consultaLivroNome(String.valueOf(linha.get(0)));
        //acessaria o emprestimo no banco usando nome do vetor
        return livro;
    }

    public void preencheTabela(List<Livro> livros,DefaultTableModel tableModel) {
        //DefaultTableModel tableModel = (DefaultTableModel)this.view.getListaLivros().getModel();
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
