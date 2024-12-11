package Controle;

import Modelo.DAO.LivroDAO;
import Modelo.Livro;


/**
 *
 * @author nicol
 */
public class ControleAvaliacao {

    
   public ControleAvaliacao(){
   }
    
   
   public boolean avalia(Livro livro){
       LivroDAO ld = new LivroDAO();
       Livro livroBanco = ld.consultaLivro(livro.getID());
       if(ld.atualizaAvaliacao(livroBanco.getNumAvaliacoes(), livroBanco.getTotalAvaliacao(), livroBanco.getID())){
           return true;
       }
       return false;
   }
}
