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
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author nicol
 */
public class ControleDevolucaoCliente {

    private final DevolucaoCliente view;
    private final DevolucaoClienteHelper helper;
    
    public ControleDevolucaoCliente(DevolucaoCliente view){
        this.view = view;
        this.helper = new DevolucaoClienteHelper(view);
    }

    public void navegaTelaCliente() {
        MenuPrincipalCliente mc = new MenuPrincipalCliente();
        mc.setVisible(true);
        this.view.dispose();
    }
    
    public void acessaLivro(int indexLinha){
        Livro livro = this.helper.leLinha(indexLinha);
        //chama devolve livro com esse livro como parametro
        DevolveLivro dv = new DevolveLivro(livro);
        dv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
