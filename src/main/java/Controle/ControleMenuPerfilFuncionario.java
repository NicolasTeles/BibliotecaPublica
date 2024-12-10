package Controle;

import Visao.CadastroFuncionario;
import Visao.MenuPerfilFuncionario;
import Visao.LoginFuncionario;
import Visao.MenuLivroFuncionario;
import Visao.MenuClienteFuncionario;
import Visao.MenuFuncionariosAdm;

public class ControleMenuPerfilFuncionario {

    private final MenuPerfilFuncionario view;
    
    public ControleMenuPerfilFuncionario(MenuPerfilFuncionario view){
        this.view = view;
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
    
    public void irEditarFuncionario(){
        CadastroFuncionario editar = new CadastroFuncionario();
        editar.setVisible(true);
        this.view.dispose();
    }
    
    public void irMenuCliente(){
        MenuClienteFuncionario cliente = new MenuClienteFuncionario();
        cliente.setVisible(true);
        this.view.dispose();
    }
    
    public void irMenuFuncionarios(){
       //logica para verificar se eh adm
       MenuFuncionariosAdm funcionario = new MenuFuncionariosAdm();
       funcionario.setVisible(true);
       this.view.dispose();       
    }
    
    
}
