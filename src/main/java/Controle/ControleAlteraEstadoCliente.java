/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Modelo.Cliente;
import Modelo.DAO.ClienteDAO;
import Visao.AlterarEstadoCliente;
import javax.swing.JOptionPane;

/**
 *
 * @author nicol
 */
public class ControleAlteraEstadoCliente {

    private final AlterarEstadoCliente view;

    public ControleAlteraEstadoCliente(AlterarEstadoCliente view) {
        this.view = view;
    }
    
    public ControleAlteraEstadoCliente(AlterarEstadoCliente view, Cliente cliente) {
        this.view = view;
        this.view.getTextNome().setText(cliente.getNome());
        this.view.getTextCPF().setText(cliente.getCpf());
        this.view.getTextEmail().setText(cliente.getEmail());
        int selectedIndex = cliente.getStatusCliente() ? 0 : 1;
        this.view.getEstadoCliente().setSelectedIndex(selectedIndex);
    }
    
    public void alteraEstado(){
        Cliente cliente = new Cliente();
        ClienteDAO cd = new ClienteDAO();
        boolean status = false;
        String statusString = String.valueOf(this.view.getEstadoCliente().getSelectedItem());
        if(statusString.equalsIgnoreCase("ativo"))
            status = true;
        else if(statusString.equalsIgnoreCase("banido"))
            status = false;
        cliente.setStatusCliente(status);
        cliente.setCpf(this.view.getTextCPF().getText());
        if(cd.atualizaStatus(cliente)){
            this.view.printaMensagem("Estado alterado com sucesso!");
            this.view.dispose();
        }
    }
}
