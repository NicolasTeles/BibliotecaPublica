package Controle;

import Conexao.Conexao;
import Modelo.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ControleLivro {
    public boolean inserirLivro(Livro livro){
        int retorno = 0;
        try(Connection conexao = Conexao.getConexao()){
            String SQL = "INSERT INTO bibliotecapublica.livro(id_livro, nome, editora, autor, ano_publicacao, avaliacao, status_emprestimo) " +
                    "VALUES(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement comando = conexao.prepareStatement(SQL);
            comando.setInt(1, livro.getID());
            comando.setString(2, livro.getNome());
            comando.setString(3, livro.getEditora());
            comando.setString(4, livro.getAutor());
            comando.setInt(5, livro.getAnoPubli());
            comando.setDouble(6, livro.getAvaliacao());
            comando.setBoolean(7, livro.getStatus());
            retorno = comando.executeUpdate();
        }catch(SQLException e){
            System.out.println("Erro ao inserir livro");
            e.printStackTrace();
        }
        return (retorno > 0);
    }

    public boolean deletaLivro(Livro livro){
        int retorno = 0;
        try(Connection conexao = Conexao.getConexao()){
            String SQL = "DELETE FROM bibliotecapublica.livro WHERE id_livro=?";
            PreparedStatement comando = conexao.prepareStatement(SQL);
            comando.setInt(1, livro.getID());
            retorno = comando.executeUpdate();
        }catch(SQLException e){
            System.out.println("Erro ao deletar livro");
            e.printStackTrace();
        }
        return (retorno > 0);
    }

    public boolean atualizaLivro(Livro livro){
        int retorno = 0;
        try(Connection conexao = Conexao.getConexao()){
            String SQL = "UPDATE bibliotecapublica.livro SET nome=?, editora=?, autor=?, ano_publicacao=?, avaliacao=?, " +
                    "status_emprestimo=?, WHERE id_livro=? )";
            PreparedStatement comando = conexao.prepareStatement(SQL);
            comando.setInt(7, livro.getID());
            comando.setString(1, livro.getNome());
            comando.setString(2, livro.getEditora());
            comando.setString(3, livro.getAutor());
            comando.setInt(4, livro.getAnoPubli());
            comando.setDouble(5, livro.getAvaliacao());
            comando.setBoolean(6, livro.getStatus());
            retorno = comando.executeUpdate();
        }catch(SQLException e){
            System.out.println("Erro ao atualizar livro");
            e.printStackTrace();
        }
        return (retorno > 0);
    }
}
