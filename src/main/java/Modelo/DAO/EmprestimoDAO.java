package Modelo.DAO;

import Conexao.Conexao;
import Modelo.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Modelo.Emprestimo;
import java.time.LocalDate;

public class EmprestimoDAO {
    
    private static final EmprestimoDAO instancia = new EmprestimoDAO();
    
    private EmprestimoDAO() {}
    
    public static EmprestimoDAO getInstancia() {
        return instancia;
    }
    
    public boolean criaEmprestimo(Emprestimo emprestimo){
        int retorno = 0;
        try(Connection conexao = Conexao.getConexao()){
            String SQL = "INSERT INTO bibliotecapublica.emprestimo(data_inicial, vencimento, devolvido, cpf_ocupante, id_livro)" +
                    " VALUES (?, ?, ?, ?, ?)";
            PreparedStatement comando = conexao.prepareStatement(SQL);
            comando.setDate(1, Date.valueOf(emprestimo.getDataInicial()));
            comando.setDate(2, Date.valueOf(emprestimo.getVencimento()));
            comando.setBoolean(3, emprestimo.getDevolvido());
            comando.setString(4, emprestimo.getCliente().getCpf());
            comando.setInt(5, emprestimo.getLivro().getID());
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

            emprestimo.setId(resultado.getInt("id"));
            emprestimo.setDevolvido(resultado.getBoolean("devolvido"));
            emprestimo.setDataInicial(resultado.getDate("data_inicial").toLocalDate());
            emprestimo.setVencimento(resultado.getDate("vencimento").toLocalDate());
            
            return emprestimo;
        }catch (SQLException e){
            System.out.println("Erro ao pegar os dados de emprestimo");
            e.printStackTrace();
        }
        return null;
    }
    
    public Emprestimo pegaDadosEmprestimo(ResultSet resultado, List<Integer> ids, List<String> cpfs){
        try{
            Emprestimo emprestimo = new Emprestimo();

            emprestimo.setId(resultado.getInt("id"));
            emprestimo.setDevolvido(resultado.getBoolean("devolvido"));
            emprestimo.setDataInicial(resultado.getDate("data_inicial").toLocalDate());
            emprestimo.setVencimento(resultado.getDate("vencimento").toLocalDate());
            
            ids.add(resultado.getInt("id_livro"));
            cpfs.add(resultado.getString("cpf_ocupante"));
            
            return emprestimo;
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
    
    public Emprestimo consultaEmprestimoLivro(int idLivro){
        try(Connection conexao = Conexao.getConexao()){
            String SQL = "SELECT * FROM bibliotecapublica.emprestimo WHERE id_livro=?";
            PreparedStatement comando = conexao.prepareStatement(SQL);
            comando.setInt(1, idLivro);
            ResultSet resultado = comando.executeQuery();
            while(resultado.next()){
                Emprestimo atual = this.pegaDadosEmprestimo(resultado);
                if(atual.getDevolvido() == false)
                    return atual;
            }
        }catch (SQLException e){
            System.out.println("Erro ao consultar emprestimo");
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean devolve(int id){
        int retorno = 0;
        try(Connection conexao = Conexao.getConexao()){
            String SQL = "UPDATE bibliotecapublica.emprestimo SET devolvido=true WHERE id=?";
            PreparedStatement comando = conexao.prepareStatement(SQL);
            comando.setInt(1, id);
            retorno = comando.executeUpdate();
        }catch(SQLException e){
            System.out.println("Erro ao atualizar livro");
            e.printStackTrace();
        }
        return (retorno > 0);
    }
    
    public List<Emprestimo> buscaEmprestimosCliente(Cliente cliente){
        try(Connection conexao = Conexao.getConexao()){
            String SQL = "SELECT * FROM bibliotecapublica.emprestimo WHERE cpf_ocupante=?";
            PreparedStatement comando = conexao.prepareStatement(SQL);
            comando.setString(1, cliente.getCpf());
            List<Emprestimo> listaEmprestimos = new ArrayList<>();
            int i = 0;
            List<Integer> idLivros = new ArrayList<>();
            List<String> cpfOcupantes = new ArrayList<>();
            List<Integer> indexes = new ArrayList<>();
            ResultSet resultado = comando.executeQuery();
            while(resultado.next()){
                Emprestimo atual = this.pegaDadosEmprestimo(resultado, idLivros, cpfOcupantes);
                if(atual.getDevolvido() == false){
                    listaEmprestimos.add(atual);
                    indexes.add(i);
                }
                i++;
            }
            
            LivroDAO ld = new LivroDAO();
            ClienteDAO cd = ClienteDAO.getInstancia();
            i=0;
            
            for(int index : indexes){
                listaEmprestimos.get(i).setLivro(ld.consultaLivro(idLivros.get(index)));
                listaEmprestimos.get(i).setCliente(cd.consultaCliente(cpfOcupantes.get(index)));
                i++;
            }
            return listaEmprestimos;
        }catch(SQLException e){
            System.out.println("Erro ao buscar emprestimos");
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean buscaEmprestimosAtrasados(String cpfCliente){
        try(Connection conexao = Conexao.getConexao()){
            String SQL = "SELECT * FROM bibliotecapublica.emprestimo WHERE cpf_ocupante=?";
            PreparedStatement comando = conexao.prepareStatement(SQL);
            comando.setString(1, cpfCliente);
            ResultSet resultado = comando.executeQuery();
            while(resultado.next()){
                Emprestimo atual = this.pegaDadosEmprestimo(resultado);
                if(atual.getDevolvido() == true)
                    continue;
                if(LocalDate.now().isAfter(atual.getVencimento()))
                    return true;
            }
            return false;
        }catch(SQLException e){
            System.out.println("Erro ao buscar emprestimos atrasados");
            e.printStackTrace();
        }
        return false;
    }
}
