package Controle;

import Modelo.Session;
import Visao.CadastroFuncionario;
import Visao.InterfaceGeral;
import Visao.LoginFuncionario;
import Visao.MenuLivroFuncionario;
import Visao.MenuClienteFuncionario;
import Visao.MenuFuncionariosAdm;

public class ControleMenuPerfilFuncionario {

    
    public void retornarTelaLogin(){}
    
    public void irMenuLivro(){}
    
    public void irEditarFuncionario(){}
    
    public void irMenuCliente(){}
    
    public void irMenuFuncionarios(){
       //logica para verificar se eh adm
    }
    
    public void irInterfaceGeral(){}
    
    public void logoutFuncionario(){
        Session.destroiFuncionario();
    }

}
