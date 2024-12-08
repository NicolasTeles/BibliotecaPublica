/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Visao.AlterarEstadoCliente;
import javax.swing.JOptionPane;

/**
 *
 * @author nicol
 */
public class ControleAlteraEstadoCliente {

    private final AlterarEstadoCliente view;

    public ControleAlteraEstadoCliente(AlterarEstadoCliente view) {
        this.view = view;
    }
    
    public void alteraEstado(){
        //muda no banco
        this.view.printaMensagem("Estado alterado com sucesso!");
        this.view.dispose();
    }
}
