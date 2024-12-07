package Modelo.DAO;

import Conexao.Conexao;
import Modelo.Livro;
import com.mysql.cj.x.protobuf.MysqlxPrepare;

import javax.xml.transform.Result;
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

    public List<Livro> listarLivros(){
        try(Connection conexao = Conexao.getConexao()){
            String SQL = "SELECT * FROM bibliotecapublica.livro";
            List<Livro> listaDeLivros = new ArrayList<Livro>();
            PreparedStatement comando = conexao.prepareStatement(SQL);
            ResultSet resultado = comando.executeQuery();
            while(resultado.next()){
                Livro atual = new Livro();
                atual = this.pegaDados(resultado);
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
            atual.setAvaliacao(resultado.getDouble("avaliacao"));
            atual.setEditora(resultado.getString("editora"));
            atual.setNome(resultado.getString("nome"));
            atual.setID(resultado.getInt("id_livro"));
            atual.setStatus(resultado.getBoolean("status_emprestimo"));
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
                Livro atual = new Livro();
                atual = this.pegaDados(resultado);
                return atual;
            }
        }catch(SQLException e){
            System.out.println("Erro ao pesquisar");
            e.printStackTrace();
        }
        return null;
    }

    public Livro consultaLivro(Livro dados){
        try(Connection conexao = Conexao.getConexao()){
            String SQL = "SELECT * FROM bibliotecapublica.livro ";
            String filtro = "";

            if(dados != null){
                if(dados.getID() > 0){
                    filtro = "WHERE id_livro = "+dados.getID();
                }
                if(dados.getNome() != null && !dados.getNome().equalsIgnoreCase("")){
                    if(filtro.equalsIgnoreCase("")){
                        filtro = "WHERE nome ilike '%"+dados.getNome()+"%'";
                    }else{
                        filtro += "AND nome ilike '%"+dados.getNome()+"%'";
                    }
                }
                if(dados.getAutor() != null && !dados.getAutor().equalsIgnoreCase("")){
                    if(filtro.equalsIgnoreCase("")){
                        filtro = "WHERE autor ilike '%"+dados.getAutor()+"%'";
                    }else{
                        filtro += "AND autor ilike '%"+dados.getAutor()+"%'";
                    }
                }
                if(dados.getEditora() != null && !dados.getEditora().equalsIgnoreCase("")){
                    if(filtro.equalsIgnoreCase("")){
                        filtro = "WHERE editora ilike '%"+dados.getEditora()+"%'";
                    }else{
                        filtro += "AND editora ilike '%"+dados.getEditora()+"%'";
                    }
                }
                if(dados.getAnoPubli() > 0){
                    if(filtro.equalsIgnoreCase("")){
                        filtro = "WHERE ano_publicacao = "+dados.getAnoPubli();
                    }else{
                        filtro += "AND ano_publicacao = "+dados.getAnoPubli();
                    }
                }
                PreparedStatement comando = conexao.prepareStatement(SQL+filtro);
                ResultSet resultado = comando.executeQuery();
                if(resultado.next()){
                    Livro atual = new Livro();
                    atual = this.pegaDados(resultado);
                    return atual;
                }
            }
        }catch(SQLException e){
            System.out.println("Erro ao pesquisar");
            e.printStackTrace();
        }
        return null;
    }
}
