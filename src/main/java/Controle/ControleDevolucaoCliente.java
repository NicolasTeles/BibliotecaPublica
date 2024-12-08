/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Visao.DevolucaoCliente;
import Visao.MenuPrincipalCliente;

/**
 *
 * @author nicol
 */
public class ControleDevolucaoCliente {

    private final DevolucaoCliente view;
    
    public ControleDevolucaoCliente(DevolucaoCliente view){
        this.view = view;
    }

    public void navegaTelaCliente() {
        MenuPrincipalCliente mc = new MenuPrincipalCliente();
        mc.setVisible(true);
        this.view.dispose();
    }
}
