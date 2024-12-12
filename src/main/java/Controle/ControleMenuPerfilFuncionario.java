package Controle;

import Modelo.Session;
import Visao.CadastroFuncionario;
import Visao.InterfaceGeral;
import Visao.LoginFuncionario;
import Visao.MenuLivroFuncionario;
import Visao.MenuClienteFuncionario;
import Visao.MenuFuncionariosAdm;

public class ControleMenuPerfilFuncionario {

    
    public void retornarTelaLogin(){
        LoginFuncionario login = new LoginFuncionario();
        login.setVisible(true);
    }
    
    public void irMenuLivro(){
        MenuLivroFuncionario livro = new MenuLivroFuncionario();
        livro.setVisible(true);     
    }
    
    public void irEditarFuncionario(){
        CadastroFuncionario editar = new CadastroFuncionario(Session.getFuncionario());
        editar.setVisible(true);
    }
    
    public void irMenuCliente(){
        MenuClienteFuncionario cliente = new MenuClienteFuncionario();
        cliente.setVisible(true);
    }
    
    public void irMenuFuncionarios(){
       //logica para verificar se eh adm
       MenuFuncionariosAdm funcionario = new MenuFuncionariosAdm();
       funcionario.setVisible(true);     
    }
    
    public void irInterfaceGeral(){
       InterfaceGeral ig = new InterfaceGeral();
       ig.setVisible(true);
    }
    
    public void logoutFuncionario(){
        Session.destroiFuncionario();
    }
    
    
}
