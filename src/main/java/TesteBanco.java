import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteBanco {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String user = "Felipe";
        String password = "FeLi2004Pe";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conexão bem-sucedida com o banco de dados!");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco de dados.");
            e.printStackTrace();
        }
    }
}
