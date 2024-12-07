package Modelo.DAO;

import Modelo.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conexao.Conexao;

public class ClienteDAO {
    public boolean criarConta(Cliente cliente){
        int retorno = 0;
        try(Connection conexao = Conexao.getConexao()){
            String SQL = "INSERT INTO bibliotecapublica.cliente(nome, email, senha, cpf) VALUES (?, ?, ?, ?)";
            PreparedStatement comando = conexao.prepareStatement(SQL);
            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getEmail());
            comando.setString(3, cliente.getSenha());
            comando.setString(4, cliente.getCpf());
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
            String SQL = "UPDATE bibliotecapublica.cliente SET nome=?, email=?, senha=? WHERE cpf=?";
            PreparedStatement comando = conexao.prepareStatement(SQL);
            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getEmail());
            comando.setString(3, cliente.getSenha());
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
            List<Cliente> listaDeclientes = new ArrayList<Cliente>();
            PreparedStatement comando = conexao.prepareStatement(SQL);
            ResultSet resultado = comando.executeQuery();
            while(resultado.next()){
                Cliente cliente = new Cliente();
                cliente = this.pegaDadosCliente(resultado);
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
                Cliente cliente = new Cliente();
                cliente = this.pegaDadosCliente(resultado);
                return cliente;
            }
        }catch (SQLException e){
            System.out.println("Erro ao consultar cliente");
            e.printStackTrace();
        }
        return null;
    }

    public Cliente consultaCliente(Cliente dados){
        try(Connection conexao = Conexao.getConexao()){
            String SQL = "SELECT * FROM bibliotecapublica.cliente";
            String filtro = "";

            if(dados != null){
                if(dados.getNome() != null && !dados.getNome().equalsIgnoreCase("")){
                    if(filtro.equalsIgnoreCase("")){
                        filtro = "WHERE nome ilike '%"+dados.getNome()+"%'";
                    }
                }
                if(dados.getCpf() != null && !dados.getCpf().equalsIgnoreCase("")){
                    if(filtro.equalsIgnoreCase("")){
                        filtro = "WHERE cpf ilike '%"+dados.getCpf()+"%'";
                    }else{
                        filtro = "AND cpf like '%"+dados.getCpf()+"%'";
                    }
                }
                if(dados.getEmail() != null && !dados.getEmail().equalsIgnoreCase("")){
                    if(filtro.equalsIgnoreCase("")){
                        filtro = "WHERE email ilike '%"+dados.getEmail()+"%'";
                    }else{
                        filtro = "AND email like '%"+dados.getEmail()+"%'";
                    }
                }
                if(dados.getSenha() != null && !dados.getSenha().equalsIgnoreCase("")){
                    if(filtro.equalsIgnoreCase("")){
                        filtro = "WHERE senha ilike '%"+dados.getSenha()+"%'";
                    }else{
                        filtro = "AND senha like '%"+dados.getSenha()+"%'";
                    }
                }
                PreparedStatement comando = conexao.prepareStatement(SQL+filtro);
                ResultSet resultado = comando.executeQuery();
                if(resultado.next()){
                    Cliente cliente = new Cliente();
                    cliente = this.pegaDadosCliente(resultado);
                    return cliente;
                }
            }
        }catch (SQLException e){
            System.out.println("Erro ao consultar cliente");
            e.printStackTrace();
        }
        return null;
    }
}
