import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UtilizzaProdotti {
	
	public static void main(String[] args) {
		String insertQuery1 = "INSERT INTO prodotti (nome, prezzo, quantita) VALUES (?, ?, ?)";
		// Informazioni di connessione al database MySQL
	    String url = "jdbc:mysql://localhost:3306/"; // URL del database
	    String dbName = "mydb"; // Nome del database
	    String user = "root"; // Nome utente
	    String password = "Ilfoggia1"; //
		Scanner input = new Scanner (System.in);
		int scelta = 5;
		// Lista per memorizzare i prodotti
        List<Prodotto> listaProdotti = new ArrayList<>();
        String selectQuery = "SELECT * FROM prodotti";
        String query1 = "SELECT * FROM prodotti WHERE nome = (?)";
		do {
			scelta = input.nextInt();
			if (scelta == 1) {
				Scanner input1 = new Scanner (System.in);
				System.out.println("Scrivi il nome del prodotto: ");
				String nomeProdotto = input1.nextLine();
				System.out.println("Scrivi il prezzo del prodotto: ");
				double prezzoProdotto = input1.nextDouble();
				System.out.println("Quantità prodotto: ");
				int quantitaProdotto = input1.nextInt();
				
				
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
			else if (scelta == 2) {
				
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
			else if (scelta == 3) {
				System.out.println("inserisci il prodotto da ricercare");
				Scanner input3 = new Scanner (System.in);
				String prodotto = input3.nextLine();
				try (Connection conn = DriverManager.getConnection(url + dbName, user, password);
			    PreparedStatement stmt = conn.prepareStatement(query1))
				
				{
					stmt.setString(1, prodotto);
					ResultSet rs = stmt.executeQuery();
					 while (rs.next()) {
			                int id = rs.getInt("id");
			                String nome = rs.getString("nome");
			                double prezzo = rs.getDouble("prezzo");
			                int quantita = rs.getInt("quantita");
			                System.out.print(id);
			                System.out.print(nome);
			                System.out.print(prezzo);
			                System.out.print(quantita);
				
			}
			
		}catch (SQLException e) {
            // Gestione dell'eccezione per la connessione al database o l'esecuzione della query
            System.out.println("Errore durante l'inserimento dei dati nella tabella 'prodotti':");
            e.printStackTrace();
        }
				
			
			}}
		while(scelta != 0);
		
			}} 
