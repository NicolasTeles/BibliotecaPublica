package Controle;


import Controle.Helpers.MenuFuncionarioAdmHelper;
import Modelo.DAO.FuncionarioDAO;
import Modelo.Funcionario;
import Modelo.Session;
import java.util.ArrayList;
import java.util.List;
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
        
    }
    
    public void retornarTelaLogin(){
        
    }
    
    public void irMenuLivro(){
          
    }
    
    public void irMenuCliente(){
        
    }
    
   
    public void telaCadastroFuncionario(){
        
           
    }
    
    public Funcionario acessaFuncionario(int indexLinha, DefaultTableModel tableModel){
        return this.helper.leLinha(indexLinha, tableModel);
        
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
    
    public void irInterfaceGeral(){
       
    }
    
    public void logoutFuncionario(){
        Session.destroiFuncionario();
    }
    
}
