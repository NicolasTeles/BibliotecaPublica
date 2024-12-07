package Modelo.DAO;

import Conexao.Conexao;
import Modelo.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FuncionarioDAO {
    public boolean insereFuncionario(Funcionario funcionario){
        int retorno = 0;
        try(Connection conexao = Conexao.getConexao()){
            String SQL = "INSERT INTO bibliotecapublica.funcionario(nome, cpf, login, senha, e_adm) " +
                    "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement comando = conexao.prepareStatement(SQL);
            comando.setString(1, funcionario.getNome());
            comando.setString(2, funcionario.getCpf());
            comando.setString(3, funcionario.getLogin());
            comando.setString(4, funcionario.getSenha());
            comando.setBoolean(5, funcionario.getEadm());
            retorno = comando.executeUpdate();
        }catch(SQLException e){
            System.out.println("Erro ao inserir funcionario");
            e.printStackTrace();
        }
        return (retorno > 0);
    }

    public boolean deletaFuncionario(Funcionario funcionario){
        int retorno = 0;
        try(Connection conexao = Conexao.getConexao()){
            String SQL = "DELETE FROM bibliotecapublica.funcionario WHERE cpf = ?";
            PreparedStatement comando = conexao.prepareStatement(SQL);
            comando.setString(1, funcionario.getCpf());
            retorno = comando.executeUpdate();
        }catch (SQLException e){
            System.out.println("Erro ao deletar funcionario");
            e.printStackTrace();
        }
        return (retorno > 0);
    }

    public boolean atualizaFuncionario(Funcionario funcionario){
        int retorno = 0;
        try(Connection conexao = Conexao.getConexao()){
            String SQL = "UPDATE bibliotecapublica.funcionario SET nome=?, login = ?, senha=?, e_adm=? " +
                    "WHERE cpf = ?";
            PreparedStatement comando = conexao.prepareStatement(SQL);
            comando.setString(1, funcionario.getNome());
            comando.setString(2, funcionario.getLogin());
            comando.setString(3, funcionario.getSenha());
            comando.setBoolean(4, funcionario.getEadm());
            comando.setString(5, funcionario.getCpf());
            retorno = comando.executeUpdate();
        }catch (SQLException e){
            System.out.println("Erro ao atualizar funcionario");
            e.printStackTrace();
        }
        return (retorno > 0);
    }
}
