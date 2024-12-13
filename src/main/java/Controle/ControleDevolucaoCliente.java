/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Controle.Helpers.DevolucaoClienteHelper;
import Modelo.DAO.EmprestimoDAO;
import Modelo.Emprestimo;
import Modelo.Livro;
import Modelo.Session;
import Visao.DevolucaoCliente;
import Visao.DevolveLivro;
import Visao.MenuPrincipalCliente;
import com.mysql.cj.conf.ConnectionUrlParser.Pair;
import java.util.List;
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
        dv.setVisible(true);
    }
    
    public void inicia(DefaultTableModel tableModel){
        EmprestimoDAO ed = new EmprestimoDAO();
        List<Emprestimo> emprestimos = ed.buscaEmprestimosCliente(Session.getCliente());
        this.helper.preencheTabela(emprestimos, tableModel);
    }
}
