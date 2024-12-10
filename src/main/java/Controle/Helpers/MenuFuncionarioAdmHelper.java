package Controle.Helpers;

import Modelo.Funcionario;
import Visao.MenuFuncionariosAdm;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;


public class MenuFuncionarioAdmHelper {
    
    public Funcionario leLinha(int indexLinha, DefaultTableModel tableModel){
        Vector linha = (Vector)tableModel.getDataVector().get(indexLinha);
        Funcionario funcionario = new Funcionario();
        //logica bd
        return funcionario;
    }
    
    
    public void preencheTabela(List<Funcionario> funcionarios, DefaultTableModel tableModel){
       tableModel.setNumRows(0);
       for(Funcionario funcionario : funcionarios){
           tableModel.addRow(new Object[]{
               funcionario.getNome(),
               funcionario.getLogin(),
               funcionario.getCpf(),
               funcionario.getEadm()
           });
       }
    }
    
}
