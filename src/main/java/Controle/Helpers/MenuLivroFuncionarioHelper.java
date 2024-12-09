/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle.Helpers;

import Modelo.Livro;
import Visao.MenuLivroFuncionario;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author felip
 */
public class MenuLivroFuncionarioHelper {
    
    private final MenuLivroFuncionario view;

    public MenuLivroFuncionarioHelper(MenuLivroFuncionario view) {
        this.view = view;
    }
    
    public Livro leLinha(int indexLinha){
        DefaultTableModel tableModel = (DefaultTableModel)this.view.getListaLivros().getModel();
        Vector linha = (Vector)tableModel.getDataVector().get(indexLinha);
        System.out.println(linha);
        Livro livro = new Livro();
        //acessaria o emprestimo no banco usando nome do vetor
        return livro;
    }
}
