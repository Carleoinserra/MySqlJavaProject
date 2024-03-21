import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestMySql5 {
    public static void main(String[] args) {
        // Informazioni di connessione al database MySQL
        String url = "jdbc:mysql://localhost:3306/"; // URL del database
        String dbName = "mydb"; // Nome del database
        String user = "root"; // Nome utente
        String password = "Ilfoggia1"; // Password

        // Dati da inserire nella tabella
        String nomeProdotto = "Prodotto3";
        double prezzoProdotto = 17.01;
        int quantitaProdotto = 18;
        String insertQuery1 = "INSERT INTO prodotti (nome, prezzo, quantita) VALUES (?, ?, ?)";


        // Query SQL per l'inserimento dei dati nella tabella "prodotti"
        String insertQuery = "INSERT INTO prodotti (nome, prezzo, quantita) " +
                             "VALUES ('" + nomeProdotto + "', " + prezzoProdotto + ", " + quantitaProdotto + ")";
        
    	
		
		

        // Tentativo di connessione al database e inserimento dei dati nella tabella
        try (Connection conn = DriverManager.getConnection(url + dbName, user, password);
        		PreparedStatement stmt = conn.prepareStatement(insertQuery1))
        		
        		
        		{
        	stmt.setString(1, nomeProdotto);
        	stmt.setDouble(2, prezzoProdotto);
        	stmt.setInt(3, quantitaProdotto);
        	
        	
        	
            // Esecuzione della query per l'inserimento dei dati
            int rowsAffected = stmt.executeUpdate();

            // Stampa il numero di righe aggiornate
            System.out.println("Numero di righe aggiornate: " + rowsAffected);

        } catch (SQLException e) {
            // Gestione dell'eccezione per la connessione al database o l'esecuzione della query
            System.out.println("Errore durante l'inserimento dei dati nella tabella 'prodotti':");
            e.printStackTrace();
        }
    }
}

