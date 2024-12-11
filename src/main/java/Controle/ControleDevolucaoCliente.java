/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Controle.Helpers.DevolucaoClienteHelper;
import Modelo.Emprestimo;
import Modelo.Livro;
import Visao.DevolucaoCliente;
import Visao.DevolveLivro;
import Visao.MenuPrincipalCliente;
import com.mysql.cj.conf.ConnectionUrlParser.Pair;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
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

    public void navegaTelaCliente() {
        MenuPrincipalCliente mc = new MenuPrincipalCliente();
        mc.setVisible(true);
    }
    
    public void acessaLivro(int indexLinha, DefaultTableModel tableModel){
        Pair<Emprestimo, Livro> tupla = this.helper.leLinha(indexLinha, tableModel);
        DevolveLivro dv = new DevolveLivro(tupla.left, tupla.right);
        dv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
