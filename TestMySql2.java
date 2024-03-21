import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestMySql2 {
    public static void main(String[] args) {
        // Informazioni di connessione al database MySQL
        String url = "jdbc:mysql://localhost:3306/"; // URL del database
        String dbName = "mydb"; // Nome del database
        String user = "root"; // Nome utente
        String password = "Ilfoggia1"; // Password

        // Dichiarazione della query per la creazione della tabella
        String createTableQuery = "CREATE TABLE IF NOT EXISTS prodotti (" // Creazione della tabella "prodotti"
                                + "id INT AUTO_INCREMENT PRIMARY KEY," // Colonna "id" con chiave primaria auto-incrementata
                                + "nome VARCHAR(255)," // Colonna "nome" di tipo stringa con lunghezza massima di 255 caratteri
                                + "prezzo DECIMAL(10, 2)," // Colonna "prezzo" di tipo DECIMAL con 10 cifre totali e 2 cifre decimali
                                + "quantita INT" // Colonna "quantita" di tipo INT per la quantità dei prodotti
                                + ")";

        // Tentativo di connessione al database e creazione della tabella
        try (Connection conn = DriverManager.getConnection(url + dbName, user, password); // Connessione al database
             Statement stmt = conn.createStatement()) { // Creazione di un'istanza di Statement per eseguire le query SQL

            // Esecuzione della query per la creazione della tabella
            stmt.executeUpdate(createTableQuery);

            System.out.println("Tabella 'prodotti' creata con successo!"); // Stampa un messaggio di conferma

        } catch (SQLException e) {
            // Gestione dell'eccezione per la connessione al database o l'esecuzione della query
            System.out.println("Errore durante la creazione della tabella 'prodotti':");
            e.printStackTrace(); // Stampa l'errore nell'output della console
        }
    }
}
