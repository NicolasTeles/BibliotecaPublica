/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Controle.Helpers.MenuPrincipalClienteHelper;
import Modelo.Livro;
import Visao.DevolucaoCliente;
import Visao.LoginCliente;
import Visao.MenuPrincipalCliente;
import Visao.PerfilCliente;
import Visao.ReservaLivro;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author felip
 */
public class ControleMenuPrincipalCliente {
    private final MenuPrincipalCliente view;
    private final MenuPrincipalClienteHelper helper;

    public ControleMenuPrincipalCliente(MenuPrincipalCliente view) {
        this.view = view;
        this.helper = new MenuPrincipalClienteHelper(view);
    }

    public void navegaPerfil() {
        PerfilCliente ig = new PerfilCliente();
        ig.setVisible(true);
        this.view.dispose();
    }

    public void logout() {
        LoginCliente ig = new LoginCliente();
        ig.setVisible(true);
        this.view.dispose();
    }

    public void navegaDevolucao() {
        DevolucaoCliente ig = new DevolucaoCliente();
        ig.setVisible(true);
        this.view.dispose();
    }

    public void acessaLivro(int indexLinha) {
        Livro livro = this.helper.leLinha(indexLinha);
        ReservaLivro rl = new ReservaLivro(livro);
        rl.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
