package Controle;

import Modelo.Cliente;
import DAO.ClienteDAO;

/**
 *
 * @author nicol
 */
public class ControleAlteraEstadoCliente {

    
    public ControleAlteraEstadoCliente() {
        
    }
    
    public void alteraEstado(String statusString, String cpf){
        Cliente cliente = new Cliente();
        ClienteDAO cd = ClienteDAO.getInstancia();
        boolean status = false;
        if(statusString.equalsIgnoreCase("ativo"))
            status = true;
        else if(statusString.equalsIgnoreCase("banido"))
            status = false;
        cliente.setStatusCliente(status);
        cliente.setCpf(cpf);
        cd.atualizaStatus(cliente);
    }
}
