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

    
    public ControleAlteraEstadoCliente() {
        
    }
    
    public void alteraEstado(String statusString, String cpf){
        Cliente cliente = new Cliente();
        ClienteDAO cd = new ClienteDAO();
        boolean status = false;
        if(statusString.equalsIgnoreCase("ativo"))
            status = true;
        else if(statusString.equalsIgnoreCase("banido"))
            status = false;
        cliente.setStatusCliente(status);
        cliente.setCpf(cpf);
    }
}
