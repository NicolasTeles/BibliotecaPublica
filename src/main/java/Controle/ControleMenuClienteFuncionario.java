package Controle;

import Controle.Helpers.MenuClienteFuncionarioHelper;
import Modelo.Cliente;
import Persistencia.ClienteDAO;
import Modelo.Session;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pichau
 */
public class ControleMenuClienteFuncionario {

    private final MenuClienteFuncionarioHelper helper;
    
    public ControleMenuClienteFuncionario(){
        this.helper = new MenuClienteFuncionarioHelper();
    }

    public void inicia(DefaultTableModel tableModel) {
        ClienteDAO cd = ClienteDAO.getInstancia();
        List<Cliente> clientes = cd.listarContas();
        this.helper.preencheTabela(clientes, tableModel);
    }
    
    public void pesquisaCliente(String pesquisa, DefaultTableModel tableModel){
        ClienteDAO cd = ClienteDAO.getInstancia();
        List<Cliente> clientes = new ArrayList<>();
        List<Cliente> todosOsClientes = cd.listarContas();

        if(pesquisa != null && !pesquisa.equalsIgnoreCase("")){

            for(Cliente cliente : todosOsClientes){
                if(cliente.getNome().toLowerCase().contains(pesquisa) || cliente.getNome().equalsIgnoreCase(pesquisa))
                    clientes.add(cliente);
                else if(cliente.getEmail().toLowerCase().contains(pesquisa) || cliente.getEmail().equalsIgnoreCase(pesquisa))
                    clientes.add(cliente);
                else if(cliente.getCpf().toLowerCase().contains(pesquisa) || cliente.getCpf().equalsIgnoreCase(pesquisa))
                    clientes.add(cliente);
            }
        }
        if(clientes.isEmpty())
            this.helper.preencheTabela(todosOsClientes, tableModel);
        else
            this.helper.preencheTabela(clientes, tableModel);
    }
    
    public Cliente alteraCliente(int indexLinha, DefaultTableModel tableModel){
        return this.helper.leLinha(indexLinha, tableModel);
    }
    public void logoutFuncionario(){
        Session.destroiFuncionario();
    }
}
