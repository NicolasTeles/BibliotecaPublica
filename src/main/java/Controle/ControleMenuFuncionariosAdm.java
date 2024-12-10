package Controle;


import Controle.Helpers.MenuFuncionarioAdmHelper;
import Modelo.DAO.FuncionarioDAO;
import Modelo.Funcionario;
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

/**
 *
 * @author pichau
 */
public class ControleMenuFuncionariosAdm {

    private final MenuFuncionariosAdm view;
    private final MenuFuncionarioAdmHelper helper;
   
    
    
    public ControleMenuFuncionariosAdm(MenuFuncionariosAdm view){
        this.view = view;
        this.helper = new MenuFuncionarioAdmHelper(view);
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
    
    public void irMenuLivro(){
        MenuLivroFuncionario livro = new MenuLivroFuncionario();
        livro.setVisible(true);
        this.view.dispose();        
    }
    
    public void irMenuCliente(){
        MenuClienteFuncionario cliente = new MenuClienteFuncionario();
        cliente.setVisible(true);
        this.view.dispose();
    }
    
   
    public void telaCadastroFuncionario(){
        //logica para cadastrar funcionario no banco de dados
        CadastroFuncionario cadastro = new CadastroFuncionario();
        cadastro.setVisible(true);
        this.view.dispose();        
    }
    
    public void acessaFuncionario(int indexLinha){
        Funcionario funcionario = this.helper.leLinha(indexLinha);
        if(JOptionPane.showConfirmDialog(this.view, "Deseja deletar esse funcionario?") == 0){
            // deleta do banco
        }
    }
    
    public void inicia(){
        FuncionarioDAO fd = new FuncionarioDAO();
        List<Funcionario> funcionarios = fd.listaFuncionarios();
        this.helper.preencheTabela(funcionarios);
    }
    
    public void pesquisaFuncionario(){
        FuncionarioDAO fd = new FuncionarioDAO();
        List<Funcionario> todosFuncionarios = fd.listaFuncionarios();
        List<Funcionario> funcionarios = new ArrayList<>();
        String pesquisa = this.view.getFieldPesquisa().getText().toLowerCase();
        
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
            this.helper.preencheTabela(todosFuncionarios);
        }else{
            this.helper.preencheTabela(funcionarios);
        }
        
    }
}
