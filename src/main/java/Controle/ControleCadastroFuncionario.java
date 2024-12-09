package Controle;

import Modelo.Funcionario;
import Visao.CadastroFuncionario;
import Visao.CadastroLivro;
import Visao.InterfaceGeral;

public class ControleCadastroFuncionario {

    private final CadastroFuncionario view;

    public ControleCadastroFuncionario(CadastroFuncionario view){
        this.view = view;
    }
    
    public ControleCadastroFuncionario(CadastroFuncionario view, Funcionario funcionario){
        this.view = view;
    }

    public void navegaTelaPrincipal(){
        InterfaceGeral ig = new InterfaceGeral();
        ig.setVisible(true);
        this.view.dispose();
    }

    public void printaMensagemTeste() {
        System.out.println("Opa");

        this.view.exibeMensagem("Executei o teste pintamsg");
    }
}
