/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Visao.MenuPrincipalCliente;
import Visao.PerfilCliente;

/**
 *
 * @author felip
 */
public class ControlePerfilCliente {
       private final PerfilCliente view;

    public ControlePerfilCliente(PerfilCliente view) {
        this.view = view;
    }

    public void retornaMenu() {
        MenuPrincipalCliente ig = new MenuPrincipalCliente();
        ig.setVisible(true);
        this.view.dispose();
    }
}
