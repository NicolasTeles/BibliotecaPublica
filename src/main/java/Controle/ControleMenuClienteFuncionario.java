package Controle;

import Controle.Helpers.MenuClienteFuncionarioHelper;
import Modelo.Cliente;
import Modelo.DAO.ClienteDAO;
import Modelo.Session;
import Visao.AlterarEstadoCliente;
import Visao.MenuPerfilFuncionario;
import Visao.LoginFuncionario;
import Visao.MenuLivroFuncionario;
import Visao.MenuClienteFuncionario;
import Visao.MenuFuncionariosAdm;
import Visao.CadastroCliente;
import Visao.InterfaceGeral;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
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
    
    public void irPerfilFuncionario(){
        MenuPerfilFuncionario perfil = new MenuPerfilFuncionario();
        perfil.setVisible(true);
    }
    
    public void retornarTelaLogin(){
        LoginFuncionario login = new LoginFuncionario();
        login.setVisible(true);
    }
 
    public void irMenuCliente(){
        MenuClienteFuncionario cliente = new MenuClienteFuncionario();
        cliente.setVisible(true);
    }
    
    public void irMenuLivro(){
        MenuLivroFuncionario livro = new MenuLivroFuncionario();
        livro.setVisible(true);  
    }
    
    public void irMenuFuncionarios(){
       //logica para verificar se eh adm
       MenuFuncionariosAdm funcionario = new MenuFuncionariosAdm();
       funcionario.setVisible(true);   
    }
    
    public void telaCadastroCliente(){
        //logica para cadastrar livro no banco de dados
        CadastroCliente cadastro = new CadastroCliente();
        cadastro.setVisible(true);   
    }

    public void inicia(DefaultTableModel tableModel) {
        ClienteDAO cd = new ClienteDAO();
        List<Cliente> clientes = cd.listarContas();
        this.helper.preencheTabela(clientes, tableModel);
    }
    
    public void pesquisaCliente(String pesquisa, DefaultTableModel tableModel){
        ClienteDAO cd = new ClienteDAO();
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
    
    public void alteraCliente(int indexLinha, DefaultTableModel tableModel){
        Cliente cliente = this.helper.leLinha(indexLinha, tableModel);
        AlterarEstadoCliente aec = new AlterarEstadoCliente(cliente);
        aec.setVisible(true);
        aec.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    public void irInterfaceGeral(){
       InterfaceGeral ig = new InterfaceGeral();
       ig.setVisible(true);
    }
    
    public void logoutFuncionario(){
        Session.destroiFuncionario();
    }
}
