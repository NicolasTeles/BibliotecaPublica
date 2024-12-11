package Controle;


import Controle.Helpers.MenuFuncionarioAdmHelper;
import Modelo.DAO.FuncionarioDAO;
import Modelo.Funcionario;
import Visao.AlterarCargoFuncionario;
import Visao.MenuPerfilFuncionario;
import Visao.LoginFuncionario;
import Visao.MenuLivroFuncionario;
import Visao.MenuClienteFuncionario;
import Visao.MenuFuncionariosAdm;
import Visao.CadastroFuncionario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pichau
 */
public class ControleMenuFuncionariosAdm {
    private final MenuFuncionarioAdmHelper helper;
   
    
    
    public ControleMenuFuncionariosAdm(){
        this.helper = new MenuFuncionarioAdmHelper();
    }
    
    public void irPerfilFuncionario(){
        MenuPerfilFuncionario perfil = new MenuPerfilFuncionario();
        perfil.setVisible(true);
    }
    
    public void retornarTelaLogin(){
        LoginFuncionario login = new LoginFuncionario();
        login.setVisible(true);
    }
    
    public void irMenuLivro(){
        MenuLivroFuncionario livro = new MenuLivroFuncionario();
        livro.setVisible(true);   
    }
    
    public void irMenuCliente(){
        MenuClienteFuncionario cliente = new MenuClienteFuncionario();
        cliente.setVisible(true);
    }
    
   
    public void telaCadastroFuncionario(){
        //logica para cadastrar funcionario no banco de dados
        CadastroFuncionario cadastro = new CadastroFuncionario();
        cadastro.setVisible(true);     
    }
    
    public void acessaFuncionario(int indexLinha, DefaultTableModel tableModel){
        Funcionario funcionario = this.helper.leLinha(indexLinha, tableModel);
        AlterarCargoFuncionario  cargo = new AlterarCargoFuncionario(funcionario);
        cargo.setVisible(true);
        cargo.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    public void inicia(DefaultTableModel tableModel){
        FuncionarioDAO fd = new FuncionarioDAO();
        List<Funcionario> funcionarios = fd.listaFuncionarios();
        this.helper.preencheTabela(funcionarios, tableModel);
    }
    
    public void pesquisaFuncionario(String pesquisa, DefaultTableModel tableModel){
        FuncionarioDAO fd = new FuncionarioDAO();
        List<Funcionario> todosFuncionarios = fd.listaFuncionarios();
        List<Funcionario> funcionarios = new ArrayList<>();
        
        if(pesquisa != null && !pesquisa.equalsIgnoreCase("")){
            pesquisa = pesquisa.toLowerCase();
            
            for(Funcionario funcionario : todosFuncionarios){
                if(funcionario.getNome().toLowerCase().contains(pesquisa) || funcionario.getNome().equalsIgnoreCase(pesquisa))
                    funcionarios.add(funcionario);
                else if(funcionario.getLogin().toLowerCase().contains(pesquisa) || funcionario.getLogin().equalsIgnoreCase(pesquisa))
                    funcionarios.add(funcionario);
                else if(funcionario.getCpf().toLowerCase().contains(pesquisa) || funcionario.getCpf().equalsIgnoreCase(pesquisa))
                    funcionarios.add(funcionario);
                
            }
        }
        
        if(funcionarios.isEmpty()){
            this.helper.preencheTabela(todosFuncionarios, tableModel);
        }else{
            this.helper.preencheTabela(funcionarios, tableModel);
        }
        
    }
}
