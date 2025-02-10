package Persistencia;

import Modelo.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conexao.Conexao;

public class ClienteDAO {
    
    private static final ClienteDAO instancia = new ClienteDAO();
    
    private ClienteDAO() {}
    
    public static ClienteDAO getInstancia() {
        return instancia;
    }
  
    public boolean criarConta(Cliente cliente){
        int retorno = 0;
        try(Connection conexao = Conexao.getConexao()){
            String SQL = "INSERT INTO bibliotecapublica.cliente(nome, email, senha, cpf, status_cliente) " +
                    "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement comando = conexao.prepareStatement(SQL);
            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getEmail());
            comando.setString(3, cliente.getSenha());
            comando.setString(4, cliente.getCpf());
            comando.setBoolean(5, cliente.getStatusCliente());
            retorno = comando.executeUpdate();

        } catch (SQLException e){
            System.out.println("Erro ao criar conta");
            e.printStackTrace();
        }
        return (retorno > 0);
    }

    public boolean deletarConta(Cliente cliente){
        int retorno = 0;
        try(Connection conexao = Conexao.getConexao()){
            String SQL = "DELETE FROM bibliotecapublica.cliente WHERE cpf=?";
            PreparedStatement comando = conexao.prepareStatement(SQL);
            comando.setString(1, cliente.getCpf());
            retorno = comando.executeUpdate();

        } catch (SQLException e){
            System.out.println("Erro ao deletar conta");
            e.printStackTrace();
        }
        return (retorno > 0);
    }

    public boolean atualizaConta(Cliente cliente){
        int retorno = 0;
        try(Connection conexao = Conexao.getConexao()){
            String SQL = "UPDATE bibliotecapublica.cliente SET nome=?, email=?, senha=?, status_cliente=? " +
                    " WHERE cpf=?";
            PreparedStatement comando = conexao.prepareStatement(SQL);
            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getEmail());
            comando.setString(3, cliente.getSenha());
            comando.setBoolean(4, cliente.getStatusCliente());
            comando.setString(5, cliente.getCpf());
            retorno = comando.executeUpdate();

        } catch (SQLException e){
            System.out.println("Erro ao atualizar conta");
            e.printStackTrace();
        }
        return (retorno > 0);
    }
    
    public boolean atualizaContaSemSenha(Cliente cliente){
        int retorno = 0;
        try(Connection conexao = Conexao.getConexao()){
            String SQL = "UPDATE bibliotecapublica.cliente SET nome=?, email=?, status_cliente=? " +
                    " WHERE cpf=?";
            PreparedStatement comando = conexao.prepareStatement(SQL);
            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getEmail());
            comando.setBoolean(3, cliente.getStatusCliente());
            comando.setString(4, cliente.getCpf());
            retorno = comando.executeUpdate();

        } catch (SQLException e){
            System.out.println("Erro ao atualizar conta");
            e.printStackTrace();
        }
        return (retorno > 0);
    }

    public Cliente pegaDadosCliente(ResultSet resultado){
        try{
            Cliente cliente = new Cliente();
            cliente.setNome(resultado.getString("nome"));
            cliente.setEmail(resultado.getString("email"));
            cliente.setSenha(resultado.getString("senha"));
            cliente.setCpf(resultado.getString("cpf"));
            cliente.setStatusCliente(resultado.getBoolean("status_cliente"));
            return cliente;
        }catch (Exception e){
            System.out.println("Erro ao pegar dados de cliente");
            e.printStackTrace();
        }
        return null;
    }

    public List<Cliente> listarContas(){
        try(Connection conexao = Conexao.getConexao()){
            String SQL = "SELECT * FROM bibliotecapublica.cliente";
            List<Cliente> listaDeclientes = new ArrayList<>();
            PreparedStatement comando = conexao.prepareStatement(SQL);
            ResultSet resultado = comando.executeQuery();
            while(resultado.next()){
                Cliente cliente = this.pegaDadosCliente(resultado);
                listaDeclientes.add(cliente);
            }
            return listaDeclientes;
        }
        catch (SQLException e){
            System.out.println("Erro ao listar contas");
            e.printStackTrace();
        }
        return null;
    }

    public Cliente consultaCliente(String cpf){
        try(Connection conexao = Conexao.getConexao()){
            String SQL = "SELECT * FROM cliente WHERE cpf = ?";
            PreparedStatement comando = conexao.prepareStatement(SQL);
            comando.setString(1, cpf);
            ResultSet resultado = comando.executeQuery();
            if(resultado.next()){
                return this.pegaDadosCliente(resultado);
            }
        }catch (SQLException e){
            System.out.println("Erro ao consultar cliente");
            e.printStackTrace();
        }
        return null;
    }
    
    public Cliente consultaEmailCliente(String email){
        try(Connection conexao = Conexao.getConexao()){
            String SQL = "SELECT * FROM cliente WHERE email = ?";
            PreparedStatement comando = conexao.prepareStatement(SQL);
            comando.setString(1, email);
            ResultSet resultado = comando.executeQuery();
            if(resultado.next()){
                return this.pegaDadosCliente(resultado);
            }
        }catch (SQLException e){
            System.out.println("Erro ao consultar cliente");
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean atualizaStatus(Cliente cliente){
        int retorno = 0;
        try(Connection conexao = Conexao.getConexao()){
            String SQL = "UPDATE bibliotecapublica.cliente SET status_cliente=? WHERE cpf=?";
            PreparedStatement comando = conexao.prepareStatement(SQL);
            comando.setBoolean(1, cliente.getStatusCliente());
            comando.setString(2, cliente.getCpf());
            retorno = comando.executeUpdate();
        }catch(SQLException e){
            System.out.println("Erro ao mudar status do cliente");
            e.printStackTrace();
        }
        return (retorno > 0);
    }
}
