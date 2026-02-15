import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    public static Connection conectar() throws Exception {
        String url = "jdbc:mysql://localhost:3306/cadastro";
        String user = "root";
        String password = "SUA_SENHA";

        return DriverManager.getConnection(url, user, password);
    }
}
