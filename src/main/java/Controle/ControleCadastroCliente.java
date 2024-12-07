package Controle;

import Visao.CadastroCliente;
import Visao.InterfaceGeral;

public class ControleCadastroCliente {
    private final CadastroCliente view;

    public ControleCadastroCliente(CadastroCliente view) {
        this.view = view;
    }

    public void entrarNoSistema(){
        //logica que envolve o banco aqui
    }

    public void retornaInterfaceGeral(){
        InterfaceGeral ig = new InterfaceGeral();
        ig.setVisible(true);
        this.view.dispose();
    }

    public void printaMensagemTeste() {
        System.out.println("Opa");

        this.view.exibeMensagem("Executei o teste pintamsg");
    }
}
