/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle.Helpers;

import Modelo.Cliente;
import Modelo.DAO.ClienteDAO;
import Visao.MenuClienteFuncionario;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nicol
 */
public class MenuClienteFuncionarioHelper {

    private final MenuClienteFuncionario view;

    public MenuClienteFuncionarioHelper(MenuClienteFuncionario view) {
        this.view = view;
    }

    public void preencheTabela(List<Cliente> clientes) {
        DefaultTableModel tableModel = (DefaultTableModel) this.view.getListaClientes().getModel();
        tableModel.setNumRows(0);
        for (Cliente cliente : clientes) {
            tableModel.addRow(new Object[]{
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getCpf(),
                cliente.getStatusCliente()
            });
        }
    }
    
    public Cliente leLinha(int indexLinha){
        DefaultTableModel tableModel = (DefaultTableModel)this.view.getListaClientes().getModel();
        Vector vector = tableModel.getDataVector().get(indexLinha);
        ClienteDAO cd = new ClienteDAO();
        return cd.consultaCliente(String.valueOf(vector.get(2)));
    }
}
