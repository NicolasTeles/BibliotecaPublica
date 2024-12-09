package Controle.Helpers;

import Modelo.Funcionario;
import Visao.MenuFuncionariosAdm;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;


public class MenuFuncionarioAdmHelper {
    private final MenuFuncionariosAdm view;
    
    public MenuFuncionarioAdmHelper(MenuFuncionariosAdm view) { 
        this.view = view;
    }
    
    public Funcionario leLinha(int indexLinha){
        DefaultTableModel tableModel = (DefaultTableModel)this.view.getListaFuncionarios().getModel();
        Vector linha = (Vector)tableModel.getDataVector().get(indexLinha);
        Funcionario funcionario = new Funcionario();
        //logica bd
        return funcionario;
    }
    
}
