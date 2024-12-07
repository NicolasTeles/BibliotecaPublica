package Controle;

import Visao.CadastroLivro;
import Visao.InterfaceGeral;

public class ControleCadastroLivro {

    private final CadastroLivro view;

    public ControleCadastroLivro(CadastroLivro view){
        this.view = view;
    }

    public void navegaInterfaceGeral(){
        InterfaceGeral ig = new InterfaceGeral();
        ig.setVisible(true);
        this.view.dispose();
    }

    public void printaMensagemTeste() {
        System.out.println("Opa");

        this.view.exibeMensagem("Executei o teste pintamsg");
    }
}
