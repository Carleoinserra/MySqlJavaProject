import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestMySql4 {
    public static void main(String[] args) {
        // Informazioni di connessione al database MySQL
        String url = "jdbc:mysql://localhost:3306/"; // URL del database
        String dbName = "mydb"; // Nome del database
        String user = "root"; // Nome utente
        String password = "Ilfoggia1"; // Password

        // Lista per memorizzare i prodotti
        List<Prodotto> listaProdotti = new ArrayList<>();

        // Query SQL per selezionare tutti i prodotti dalla tabella "prodotti"
        String selectQuery = "SELECT * FROM prodotti";

        // Tentativo di connessione al database e lettura dei dati dalla tabella
        try (Connection conn = DriverManager.getConnection(url + dbName, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(selectQuery)) {

            // Iterazione sui risultati e lettura dei dati
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                double prezzo = rs.getDouble("prezzo");
                int quantita = rs.getInt("quantita");
                
                // Creazione di un nuovo oggetto Prodotto e aggiunta alla lista
                Prodotto prodotto = new Prodotto(id, nome, prezzo, quantita);
                listaProdotti.add(prodotto);
            }

            // Stampa dei prodotti nella lista
            for (Prodotto prodotto : listaProdotti) {
                System.out.println(prodotto);
            }

        } catch (SQLException e) {
            // Gestione delle eccezioni per la connessione al database o la lettura dei dati
            System.out.println("Errore durante la lettura dei dati dalla tabella 'prodotti':");
            e.printStackTrace();
        }
    }
}

