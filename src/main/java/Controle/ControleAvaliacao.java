package Controle;

import Persistencia.LivroDAO;
import Modelo.Livro;


/**
 *
 * @author nicol
 */
public class ControleAvaliacao {

    
   public ControleAvaliacao(){
   }
    
   
   public boolean avalia(Livro livro){
       LivroDAO ld = LivroDAO.getInstancia();
       Livro livroBanco = ld.consultaLivro(livro.getID());
       return ld.atualizaAvaliacao(livroBanco.getNumAvaliacoes(), livroBanco.getTotalAvaliacao(), livroBanco.getID());
   }
}
