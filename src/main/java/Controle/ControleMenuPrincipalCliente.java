/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Visao.DevolucaoCliente;
import Visao.LoginCliente;
import Visao.MenuPrincipalCliente;
import Visao.PerfilCliente;

/**
 *
 * @author felip
 */
public class ControleMenuPrincipalCliente {
    private final MenuPrincipalCliente view;

    public ControleMenuPrincipalCliente(MenuPrincipalCliente view) {
        this.view = view;
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
}
