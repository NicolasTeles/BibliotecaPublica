package Modelo.DAO;

import Conexao.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Modelo.Emprestimo;

public class EmprestimoDAO {
    public boolean criaEmprestimo(Emprestimo emprestimo){
        int retorno = 0;
        try(Connection conexao = Conexao.getConexao()){
            String SQL = "INSERT INTO bibliotecapublica.emprestimo(data_inicial, vencimento, devolvido, cpf_ocupante, id, id_livro)" +
                    " VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement comando = conexao.prepareStatement(SQL);
            comando.setDate(1, Date.valueOf(emprestimo.getDataInicial()));
            comando.setDate(2, Date.valueOf(emprestimo.getVencimento()));
            comando.setBoolean(3, emprestimo.getDevolvido());
            comando.setString(4, emprestimo.getCliente().getCpf());
            comando.setInt(5, emprestimo.getId());
            comando.setInt(6, emprestimo.getLivro().getID());
            retorno = comando.executeUpdate();
        }catch (SQLException e){
            System.out.println("Erro ao emprestar livro");
            e.printStackTrace();
        }
        return (retorno > 0);
    }

    public boolean deletaEmprestimo(Emprestimo emprestimo){
        int retorno = 0;
        try(Connection conexao = Conexao.getConexao()){
            String SQL = "DELETE FROM bibliotecapublica.emprestimo WHERE id=?";
            PreparedStatement comando = conexao.prepareStatement(SQL);
            comando.setInt(1, emprestimo.getId());
            retorno = comando.executeUpdate();
        }catch(SQLException e){
            System.out.println("Erro ao deletar emprestimo");
            e.printStackTrace();
        }
        return (retorno > 0);
    }

    public boolean atualizaEmprestimo(Emprestimo emprestimo){
        int retorno = 0;
        try(Connection conexao = Conexao.getConexao()){
            String SQL = "UPDATE bibliotecapublica.emprestimo SET data_inicial=?, vencimento=?, devolvido=?, " +
                    "cpf_ocupante=?, id_livro=? WHERE id=?";
            PreparedStatement comando = conexao.prepareStatement(SQL);
            comando.setDate(1, Date.valueOf(emprestimo.getDataInicial()));
            comando.setDate(2, Date.valueOf(emprestimo.getVencimento()));
            comando.setBoolean(3, emprestimo.getDevolvido());
            comando.setString(4, emprestimo.getCliente().getCpf());
            comando.setInt(5, emprestimo.getLivro().getID());
            comando.setInt(6, emprestimo.getId());
            retorno = comando.executeUpdate();
        }catch(SQLException e){
            System.out.println("Erro ao atualizar emprestimo");
            e.printStackTrace();
        }
        return (retorno > 0);
    }

    public Emprestimo pegaDadosEmprestimo(ResultSet resultado){
        try{
            Emprestimo emprestimo = new Emprestimo();

            //emprestimo.setCliente(resultado.getString("cpf_ocupante"));
            //buscar cliente pelo cpf

            emprestimo.setId(resultado.getInt("id"));
            emprestimo.setDevolvido(resultado.getBoolean("devolvido"));
            emprestimo.setDataInicial(resultado.getDate("data_inicial").toLocalDate());
            emprestimo.setVencimento(resultado.getDate("vencimento").toLocalDate());

            //emprestimo.setLivro(resultado.getInt("id_livro"));
            //buscar livro pelo id
        }catch (SQLException e){
            System.out.println("Erro ao pegar os dados de emprestimo");
            e.printStackTrace();
        }
        return null;
    }

    public List<Emprestimo> pegaListaEmprestimo(){
        try(Connection conexao = Conexao.getConexao()){
            String SQL = "SELECT * FROM bibliotecapublica.emprestimo";
            List<Emprestimo> listaEmprestimo = new ArrayList<>();
            PreparedStatement comando = conexao.prepareStatement(SQL);
            ResultSet resultado = comando.executeQuery();
            while(resultado.next()){
                Emprestimo emprestimo = this.pegaDadosEmprestimo(resultado);
                listaEmprestimo.add(emprestimo);
            }
            return listaEmprestimo;
        }catch (SQLException e){
            System.out.println("Erro ao pegar lista de emprestimo");
            e.printStackTrace();
        }
        return null;
    }

    public Emprestimo consultaEmprestimo(String id){
        try(Connection conexao = Conexao.getConexao()){
            String SQL = "SELECT * FROM emprestimo WHERE id=?";
            PreparedStatement comando = conexao.prepareStatement(SQL);
            comando.setInt(1, Integer.valueOf(id));
            ResultSet resultado = comando.executeQuery();
            if(resultado.next()){
                return this.pegaDadosEmprestimo(resultado);
            }
        }catch (SQLException e){
            System.out.println("Erro ao consultar emprestimo");
            e.printStackTrace();
        }
        return null;
    }

    public Emprestimo consultaEmprestimo(Emprestimo emprestimo){
        try(Connection conexao = Conexao.getConexao()){
            String SQL = "SELECT * FROM bibliotecapublica.emprestimo";
            String filtro = "";

            if(emprestimo != null){
                if(emprestimo.getId() > 0){
                    filtro = "WHERE id = "+emprestimo.getId();
                }
                if(emprestimo.getCliente() != null && !emprestimo.getCliente().getCpf().equalsIgnoreCase("")){
                    if(filtro.equalsIgnoreCase("")){
                        filtro = "WHERE cpf_ocupante ilike '%"+emprestimo.getCliente()+"%'";
                    }else{
                        filtro += " AND cpf_ocupante ilike '%"+emprestimo.getCliente()+"%'";
                    }
                }
                if(emprestimo.getDataInicial() != null && !emprestimo.getDataInicial().equals("")){
                    if(filtro.equalsIgnoreCase("")){
                        filtro = "WHERE data_inicial ilike '%"+emprestimo.getDataInicial()+"%'";
                    }else{
                        filtro += " AND data_inicial ilike '%"+emprestimo.getDataInicial()+"%'";
                    }
                }
                if(emprestimo.getVencimento() != null && !emprestimo.getVencimento().equals("")){
                    if(filtro.equalsIgnoreCase("")){
                        filtro = "WHERE vencimento ilike '%"+emprestimo.getVencimento()+"%'";
                    }else{
                        filtro += " AND vencimento ilike '%"+emprestimo.getVencimento()+"%'";
                    }
                }
            }
            PreparedStatement comando = conexao.prepareStatement(SQL+filtro);
            ResultSet resultado = comando.executeQuery();
            if(resultado.next()){
                Emprestimo emprestimo1 = new Emprestimo();
                emprestimo1 = this.pegaDadosEmprestimo(resultado);
                return emprestimo1;
            }
        }catch (SQLException e){
            System.out.println("Erro ao consultar emprestimo");
            e.printStackTrace();
        }
        return null;
    }
}
