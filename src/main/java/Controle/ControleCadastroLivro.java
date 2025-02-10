package Controle;

import Persistencia.LivroDAO;
import Modelo.Livro;
import javax.swing.JOptionPane;

public class ControleCadastroLivro {

    public ControleCadastroLivro(){}

    public boolean cadastraLivro(String nome, String autor, String editora, Integer anoPubli){
        Livro livro = new Livro(nome, editora, autor, anoPubli);
        LivroDAO ld = LivroDAO.getInstancia();
        if(ld.consultaLivroNome(nome) != null){
            JOptionPane.showMessageDialog(null, "Esse livro ja esta cadastrado");
            return false;
        }
        if(ld.inserirLivro(livro)){
            JOptionPane.showMessageDialog(null, "Livro inserido com sucesso!");
            return true;
        }
        return false;
    }
}
