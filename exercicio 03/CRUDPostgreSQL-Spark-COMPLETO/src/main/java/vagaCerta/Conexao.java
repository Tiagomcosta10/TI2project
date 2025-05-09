package vagaCerta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static Connection conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/vagacerta";
            String usuario = "postgres";
            String senha = "Biscoitao00.";
            Connection conn = DriverManager.getConnection(url, usuario, senha);
            System.out.println("✔ Conexão estabelecida com sucesso!");
            return conn;
        } catch (ClassNotFoundException e) {
            System.err.println("✘ Driver do PostgreSQL não encontrado!");
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            System.err.println("✘ Erro ao conectar ao banco de dados.");
            e.printStackTrace();
            return null;
        }
    }
}