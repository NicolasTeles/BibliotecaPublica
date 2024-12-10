/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Visao.AlterarCargoFuncionario;

/**
 *
 * @author pichau
 */
public class ControleAlteraCargoFuncionario {

    private final AlterarCargoFuncionario view;
    
    public ControleAlteraCargoFuncionario(AlterarCargoFuncionario view){
        this.view = view;        
    }
    
    
    public void alteraEstado(){
        //altera no banco
        this.view.printaMensagem("Cargo alterado com sucesso!");
        this.view.dispose();
    }
    
}
