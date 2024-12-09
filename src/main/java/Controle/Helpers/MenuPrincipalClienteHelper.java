/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle.Helpers;

import Modelo.Livro;
import Visao.MenuPrincipalCliente;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nicol
 */
public class MenuPrincipalClienteHelper {
    private final MenuPrincipalCliente view;
    
    public MenuPrincipalClienteHelper(MenuPrincipalCliente view){
        this.view = view;
    }
    
    public Livro leLinha(int indexLinha){
        DefaultTableModel tableLivros = (DefaultTableModel)this.view.getListaLivros().getModel();
        Vector linha = (Vector) tableLivros.getDataVector().get(indexLinha);
        Livro livro = new Livro();
        //acessa livro no banco
        return livro;
    }
}
