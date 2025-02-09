package Controle.Helpers;

import Modelo.DAO.FuncionarioDAO;
import Modelo.Funcionario;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;


public class MenuFuncionarioAdmHelper {
    
    public Funcionario leLinha(int indexLinha, DefaultTableModel tableModel){
        Vector linha = (Vector)tableModel.getDataVector().get(indexLinha);
        FuncionarioDAO fd =FuncionarioDAO.getInstancia();
        Funcionario funcionario = fd.consultaFuncionario(String.valueOf(linha.get(2)));
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
