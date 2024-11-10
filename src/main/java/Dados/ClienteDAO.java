package Dados;

import Modelo.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
