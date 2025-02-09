/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Modelo.Cliente;
import Modelo.DAO.ClienteDAO;

/**
 *
 * @author felip
 */
public class ControlePerfilCliente {
       
    public ControlePerfilCliente() {        
    }

    public boolean deletaCliente(String cpf){
        ClienteDAO cd = ClienteDAO.getInstancia();
        Cliente cliente = cd.consultaCliente(cpf);;
        boolean confere = cd.deletarConta(cliente);       
        return confere;        
    }
}
