
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestMysql1 {
    public static void main(String[] args) {
        // Informazioni di connessione al database MySQL
        String url = "jdbc:mysql://localhost:3306/"; // URL del database
        String dbName = "mydb"; // Nome del database
        String user = "root"; // Nome utente
        String password = "Ilfoggia1"; // Password

        // Tentativo di connessione al database
        try {
            // Caricamento del driver JDBC per MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Creazione della connessione
            Connection conn = DriverManager.getConnection(url + dbName, user, password);

            // Verifica della connessione
            if (conn != null) {
                System.out.println("Connessione a MySQL riuscita!");
                conn.close(); // Chiudi la connessione
            } else {
                System.out.println("Connessione a MySQL fallita.");
            }

        } catch (ClassNotFoundException e) {
            // Gestione dell'eccezione per il caricamento del driver JDBC
            System.out.println("Impossibile trovare il driver JDBC.");
            e.printStackTrace();
        } catch (SQLException e) {
            // Gestione dell'eccezione per la connessione al database
            System.out.println("Connessione a MySQL fallita.");
            e.printStackTrace();
        }
    }
}

