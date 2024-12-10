package Controle;

import Controle.Helpers.MenuClienteFuncionarioHelper;
import Modelo.Cliente;
import Modelo.DAO.ClienteDAO;
import Visao.MenuPerfilFuncionario;
import Visao.LoginFuncionario;
import Visao.MenuLivroFuncionario;
import Visao.MenuClienteFuncionario;
import Visao.MenuFuncionariosAdm;
import Visao.CadastroCliente;
import java.util.List;

/**
 *
 * @author pichau
 */
public class ControleMenuClienteFuncionario {

    private final MenuClienteFuncionario view;
    private final MenuClienteFuncionarioHelper helper;
    
    public ControleMenuClienteFuncionario(MenuClienteFuncionario view){
        this.view = view;
        this.helper = new MenuClienteFuncionarioHelper(view);
    }
    
    public void irPerfilFuncionario(){
        MenuPerfilFuncionario perfil = new MenuPerfilFuncionario();
        perfil.setVisible(true);
        this.view.dispose();
    }
    
    public void retornarTelaLogin(){
        LoginFuncionario login = new LoginFuncionario();
        login.setVisible(true);
        this.view.dispose();
    }
 
    public void irMenuCliente(){
        MenuClienteFuncionario cliente = new MenuClienteFuncionario();
        cliente.setVisible(true);
        this.view.dispose();
    }
    
    public void irMenuLivro(){
        MenuLivroFuncionario livro = new MenuLivroFuncionario();
        livro.setVisible(true);
        this.view.dispose();        
    }
    
    public void irMenuFuncionarios(){
       //logica para verificar se eh adm
       MenuFuncionariosAdm funcionario = new MenuFuncionariosAdm();
       funcionario.setVisible(true);
       this.view.dispose();       
    }
    
    public void telaCadastroCliente(){
        //logica para cadastrar livro no banco de dados
        CadastroCliente cadastro = new CadastroCliente();
        cadastro.setVisible(true);
        this.view.dispose();        
    }

    public void inicia() {
        ClienteDAO cd = new ClienteDAO();
        List<Cliente> clientes = cd.listarContas();
        this.helper.preencheTabela(clientes);
    }
}
