package Controle;

import Visao.CadastroFuncionario;
import Visao.CadastroLivro;
import Visao.InterfaceGeral;

public class ControleCadastroFuncionario {

    private final CadastroFuncionario view;

    public ControleCadastroFuncionario(CadastroFuncionario view){
        this.view = view;
    }

    public void navegaTelaPrincipal(){
        InterfaceGeral ig = new InterfaceGeral();
        ig.setVisible(true);
        this.view.dispose();
    }
}
