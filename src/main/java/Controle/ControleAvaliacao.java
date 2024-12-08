/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Visao.Avaliacao;

/**
 *
 * @author nicol
 */
public class ControleAvaliacao {

    private final Avaliacao view;
    
   public ControleAvaliacao(Avaliacao view){
       this.view = view;
   }
    
   
   public void avalia(){
       //logica da avaliacao
       this.view.dispose();
   }
}
