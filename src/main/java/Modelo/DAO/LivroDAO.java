package Modelo.DAO;

import Conexao.Conexao;
import Modelo.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {
    public boolean inserirLivro(Livro livro){
        int retorno = 0;
        try(Connection conexao = Conexao.getConexao()){
            String SQL = "INSERT INTO bibliotecapublica.livro(nome, editora, autor, ano_publicacao, total_avaliacao, status_emprestimo, num_avaliacoes) " +
                    "VALUES(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement comando = conexao.prepareStatement(SQL);
            comando.setString(1, livro.getNome());
            comando.setString(2, livro.getEditora());
            comando.setString(3, livro.getAutor());
            comando.setInt(4, livro.getAnoPubli());
            comando.setInt(5, livro.getTotalAvaliacao());
            comando.setBoolean(6, livro.getStatus());
            comando.setInt(7, livro.getNumAvaliacoes());
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
            String SQL = "UPDATE bibliotecapublica.livro SET nome=?, editora=?, autor=?, ano_publicacao=?, total_avaliacao=?, " +
                    "status_emprestimo=?, num_avaliacoes=? WHERE id_livro=?";
            PreparedStatement comando = conexao.prepareStatement(SQL);
            comando.setString(1, livro.getNome());
            comando.setString(2, livro.getEditora());
            comando.setString(3, livro.getAutor());
            comando.setInt(4, livro.getAnoPubli());
            comando.setInt(5, livro.getTotalAvaliacao());
            comando.setBoolean(6, livro.getStatus());
            comando.setInt(7, livro.getNumAvaliacoes());
            comando.setInt(8, livro.getID());
            retorno = comando.executeUpdate();
        }catch(SQLException e){
            System.out.println("Erro ao atualizar livro");
            e.printStackTrace();
        }
        return (retorno > 0);
    }

    public List<Livro> listarLivros(){
        try(Connection conexao = Conexao.getConexao()){
            String SQL = "SELECT * FROM bibliotecapublica.livro";
            List<Livro> listaDeLivros = new ArrayList<>();
            PreparedStatement comando = conexao.prepareStatement(SQL);
            ResultSet resultado = comando.executeQuery();
            while(resultado.next()){
                Livro atual = this.pegaDados(resultado);
                listaDeLivros.add(atual);
            }
            return listaDeLivros;
        }catch(SQLException e){
            System.out.println("Erro ao listar livros");
            e.printStackTrace();
        }
        return null;
    }
    
    //if(this.pegaDados(resultado).getStatus() == true)
    
    public List<Livro> listarLivrosCliente(){
        try(Connection conexao = Conexao.getConexao()){
            String SQL = "SELECT * FROM bibliotecapublica.livro WHERE status_emprestimo = ?";
            List<Livro> listaDeLivros = new ArrayList<>();
            PreparedStatement comando = conexao.prepareStatement(SQL);
            comando.setBoolean(1, true);
            ResultSet resultado = comando.executeQuery();
            while(resultado.next()){        
                Livro atual = this.pegaDados(resultado);
                listaDeLivros.add(atual);             
            }
            return listaDeLivros;
        }catch(SQLException e){
            System.out.println("Erro ao listar livros");
            e.printStackTrace();
        }
        return null;
    }

    public Livro pegaDados(ResultSet resultado){
        try{
            Livro atual = new Livro();
            atual.setAnoPubli(resultado.getInt("ano_publicacao"));
            atual.setAutor(resultado.getString("autor"));
            atual.setTotalAvaliacao(resultado.getInt("total_avaliacao"));
            atual.setEditora(resultado.getString("editora"));
            atual.setNome(resultado.getString("nome"));
            atual.setID(resultado.getInt("id_livro"));
            atual.setStatus(resultado.getBoolean("status_emprestimo"));
            atual.setNumAvaliacoes(resultado.getInt("num_avaliacoes"));
            return atual;
        }catch (SQLException e){
            System.out.println("Erro ao pegar dados");
            e.printStackTrace();
        }
        return null;
    }

    public Livro consultaLivro(String idLivro){
        try(Connection conexao = Conexao.getConexao()){
            String SQL = "SELECT * FROM bibliotecapublica.livro WHERE id_livro=?";
            PreparedStatement comando = conexao.prepareStatement(SQL);
            comando.setInt(1, Integer.valueOf(idLivro));
            ResultSet resultado = comando.executeQuery();
            if(resultado.next()){
                Livro atual = this.pegaDados(resultado);
                return atual;
            }
        }catch(SQLException e){
            System.out.println("Erro ao pesquisar");
            e.printStackTrace();
        }
        return null;
    }
}
