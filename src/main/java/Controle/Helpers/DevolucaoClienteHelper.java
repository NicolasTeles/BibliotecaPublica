/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle.Helpers;

import Modelo.Emprestimo;
import Modelo.Livro;
import Visao.DevolucaoCliente;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nicol
 */
public class DevolucaoClienteHelper {
    private final DevolucaoCliente view;
    
    public DevolucaoClienteHelper(DevolucaoCliente view){
        this.view = view;
    }
    
    public Livro leLinha(int indexLinha){
        DefaultTableModel tableModel = (DefaultTableModel)this.view.getTabelaDevolucao().getModel();
        Vector linha = (Vector)tableModel.getDataVector().get(indexLinha);
        //System.out.println(linha);
        Livro livro = new Livro();
        //acessaria o emprestimo no banco usando nome do vetor
        return livro;
    }
}
