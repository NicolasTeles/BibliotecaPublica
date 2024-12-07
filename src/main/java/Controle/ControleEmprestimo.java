package Controle;

import Conexao.Conexao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Modelo.Emprestimo;

public class ControleEmprestimo {
    public boolean criaEmprestimo(Emprestimo emprestimo){
        int retorno = 0;
        try(Connection conexao = Conexao.getConexao()){
            String SQL = "INSERT INTO bibliotecapublica.emprestimo(data_inicial, vencimento, devolvido, cpf_ocupante, id)" +
                    " VALUES (?, ?, ?, ?, ?)";
            PreparedStatement comando = conexao.prepareStatement(SQL);
            comando.setDate(1, Date.valueOf(emprestimo.getDataInicial()));
            comando.setDate(2, Date.valueOf(emprestimo.getVencimento()));
            comando.setBoolean(3, emprestimo.getDevolvido());
            comando.setString(4, emprestimo.getCpfOcupante());
            comando.setInt(5, emprestimo.getId());
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
}
