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
    
    public Livro leLinha(int indexLinha, DefaultTableModel tableModel){
        Vector linha = (Vector)tableModel.getDataVector().get(indexLinha);
        //System.out.println(linha);
        Livro livro = new Livro();
        //acessaria o emprestimo no banco usando nome do vetor
        return livro;
    }
}
