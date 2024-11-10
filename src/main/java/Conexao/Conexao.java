package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static String url = "jdbc:mysql://localhost:3306/BibliotecaPublica";
    private static String user = "root";
    private static String password = "root";

    private static Connection minhaConexao = null;

    public static Connection getConexao() {
        try{
            if(Conexao.minhaConexao == null)
                Conexao.minhaConexao = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco de dados.");
            System.out.println("Erro: " + e.getMessage());
        }
        return minhaConexao;
    }
}
