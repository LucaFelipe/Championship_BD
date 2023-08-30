package projetoBD_POO.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    protected Connection connection; // conexão
    protected Statement statement; // declaração(query) - código em sql
    protected ResultSet resultSet; // resposta do banco
    protected PreparedStatement pst; // declaração(query) preparada - código em sql
    
    static final String user = "usuario";
    static final String password = "postgres";
    static final String database = "postgres";

    static final String url = "jdbc:postgresql://localhost:5432/" + database;

    public void connect() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão feita com sucesso: " + connection);
        } catch (SQLException exception) {
            System.out.println("Erro de conexão: " + exception.getMessage());
        }
    }
}
