package Modelo.DAO;

import Conexao.Conexao;
import Modelo.Funcionario;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    
    public boolean atualizaFuncionarioSemSenha(Funcionario funcionario) {
        int retorno = 0;
        try(Connection conexao = Conexao.getConexao()){
            String SQL = "UPDATE bibliotecapublica.funcionario SET nome=?, login = ?" +
                    "WHERE cpf = ?";
            PreparedStatement comando = conexao.prepareStatement(SQL);
            comando.setString(1, funcionario.getNome());
            comando.setString(2, funcionario.getLogin());
            comando.setString(3, funcionario.getCpf());
            retorno = comando.executeUpdate();
        }catch (SQLException e){
            System.out.println("Erro ao atualizar funcionario");
            e.printStackTrace();
        }
        return (retorno > 0);
    }

    public Funcionario pegaDados(ResultSet resultado){
        try{
            Funcionario atual = new Funcionario();
            atual.setCpf(resultado.getString("cpf"));
            atual.setNome(resultado.getString("nome"));
            atual.setLogin(resultado.getString("login"));
            atual.setSenha(resultado.getString("senha"));
            atual.setEadm(resultado.getBoolean("e_adm"));
            return atual;
        }catch (SQLException e){
            System.out.println("Erro ao pegar dados");
            e.printStackTrace();
        }
        return null;
    }

    public List<Funcionario> listaFuncionarios(){
        try(Connection conexao = Conexao.getConexao()){
            String SQL = "SELECT * FROM bibliotecapublica.funcionario";
            List<Funcionario> listaDeFuncionarios = new ArrayList<>();
            PreparedStatement comando = conexao.prepareStatement(SQL);
            ResultSet resultado = comando.executeQuery();
            while(resultado.next()){
                Funcionario atual = this.pegaDados(resultado);
                listaDeFuncionarios.add(atual);
            }
            return listaDeFuncionarios;
        }catch (SQLException e){
            System.out.println("Erro ao listar funcionarios");
            e.printStackTrace();
        }
        return null;
    }

    public Funcionario consultaFuncionario(String cpf){
        try(Connection conexao = Conexao.getConexao()){
            String SQL = "SELECT * FROM bibliotecapublica.funcionario WHERE cpf=?";
            PreparedStatement comando = conexao.prepareStatement(SQL);
            comando.setString(1, cpf);
            ResultSet resultado = comando.executeQuery();
            if(resultado.next()){
                Funcionario atual = this.pegaDados(resultado);
                return atual;
            }
        }catch (SQLException e){
            System.out.println("Erro ao consultar funcionario");
            e.printStackTrace();
        }
        return null;
    }
    
     
    public Funcionario consultaLoginFuncionario(String login){
        try(Connection conexao = Conexao.getConexao()){
            String SQL = "SELECT * FROM bibliotecapublica.funcionario WHERE login=?";
            PreparedStatement comando = conexao.prepareStatement(SQL);
            comando.setString(1, login);
            ResultSet resultado = comando.executeQuery();
            if(resultado.next()){
                Funcionario atual = this.pegaDados(resultado);
                return atual;
            }
        }catch (SQLException e){
            System.out.println("Erro ao consultar funcionario");
            e.printStackTrace();
        }
        return null;
    }

    public Funcionario consultaFuncionario(Funcionario dados){
        try(Connection conexao = Conexao.getConexao()){
            String SQL = "SELECT * FROM bibliotecapublica.funcionario ";
            String filtro = "";

            if(dados != null){
                if(dados.getCpf() != null && !dados.getCpf().equalsIgnoreCase("")){
                    filtro = "WHERE cpf = "+dados.getCpf();
                }
                if(dados.getNome() != null && !dados.getNome().equalsIgnoreCase("")){
                    if(filtro.equalsIgnoreCase("")){
                        filtro = "WHERE nome ilike '%"+ dados.getNome() +"%'";
                    }else{
                        filtro += " AND nome ilike '%" +dados.getNome()+ "%'";
                    }
                }
                if(dados.getLogin() != null && !dados.getLogin().equalsIgnoreCase("")){
                    if(filtro.equalsIgnoreCase("")){
                        filtro = "WHERE login ilike '%"+ dados.getLogin() +"%'";
                    }else{
                        filtro += " AND login ilike '%" +dados.getLogin()+ "%'";
                    }
                }
            }
            PreparedStatement comando = conexao.prepareStatement(SQL+filtro);
            ResultSet resultado = comando.executeQuery();
            if(resultado.next()){
                Funcionario atual = this.pegaDados(resultado);
                return atual;
            }
        }catch (SQLException e){
            System.out.println("Erro ao consultar funcionario");
            e.printStackTrace();
        }
        return null;
    }
    
    
    public boolean atualizaStatus(Funcionario funcionario){
        int retorno = 0;
        try(Connection conexao = Conexao.getConexao()){
            String SQL = "UPDATE bibliotecapublica.funcionario SET e_adm=? WHERE cpf=?";
            PreparedStatement comando = conexao.prepareStatement(SQL);
            comando.setBoolean(1, funcionario.getEadm());
            comando.setString(2, funcionario.getCpf());
            retorno = comando.executeUpdate();
        }catch(SQLException e){
            System.out.println("Erro ao mudar cargo do funcionario");
            e.printStackTrace();
        }
        return (retorno > 0);
    }
}
