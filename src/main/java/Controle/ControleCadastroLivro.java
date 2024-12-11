package Controle;

import Modelo.DAO.LivroDAO;
import Modelo.Livro;
import Visao.InterfaceGeral;
import javax.swing.JOptionPane;

public class ControleCadastroLivro {

    public ControleCadastroLivro(){}

    public void navegaInterfaceGeral(){
        InterfaceGeral ig = new InterfaceGeral();
        ig.setVisible(true);
    }
    
    public boolean cadastraLivro(String nome, String autor, String editora, Integer anoPubli){
        Livro livro = new Livro(nome, editora, autor, anoPubli);
        LivroDAO cd = new LivroDAO();
        if(cd.inserirLivro(livro)){
            JOptionPane.showMessageDialog(null, "Livro inserido com sucesso!");
            return true;
        }
        return false;
    }
}
