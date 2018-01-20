package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import storage.DriverManagerConnectionPool;
import storage.Richiesta;


public class ListaStudentiTutor {
	
	public synchronized ArrayList<Richiesta> doListaStudenteTutor() throws SQLException {
		Connection conn = null;
		PreparedStatement s = null;
		List<Richiesta> lista = new ArrayList<Richiesta>();
		
		
//		String query = "SELECT * FROM ((Richiesta INNER JOIN Studente ON Richiesta.StudenteEmail = Studente.Email)" + 
//						"INNER JOIN Tutor ON Richiesta.AziendaEmail = Tutor.AziendaEmail" +
//						" ON Richiesta.Stato = true);";
		
	String query = "SELECT * FROM Richiesta, Studente, Tutor WHERE Richiesta.AziendaEmail = Tutor.AziendaEmail AND Richiesta.StudenteEmail = Studente.Email AND Richiesta.Stato = true;";
		
		System.out.println(query);
		
		
//		SELECT Orders.OrderID, Customers.CustomerName, Shippers.ShipperName
//		FROM ((Orders
//		INNER JOIN Customers ON Orders.CustomerID = Customers.CustomerID)
//		INNER JOIN Shippers ON Orders.ShipperID = Shippers.ShipperID);
		
		conn = DriverManagerConnectionPool.getConnection();
		s = conn.prepareStatement(query);
		
		ResultSet risultato = s.executeQuery();
		conn.commit();
		
		try{
			while (risultato.next()) {
				Richiesta richiesta = new Richiesta();
				
				richiesta.setIdR(risultato.getString("ID"));
				
				richiesta.setEmailA(risultato.getString("AziendaEmail"));
				richiesta.setStatoT(risultato.getBoolean("StatoTutor"));
				
				richiesta.setEmailS(risultato.getString("StudenteEmail"));
				richiesta.setNomeS(risultato.getString("Nome"));
				richiesta.setCognomeS(risultato.getString("Cognome"));
				richiesta.setMatricolaS(risultato.getString("Matricola"));
				
				richiesta.setEmailT(risultato.getString("Tutor.Email"));
				
				
				lista.add(richiesta);
				
				
		}
	}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			if (risultato != null) {
				try {
					risultato.close();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (s != null) {
				try {
					s.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return (ArrayList<Richiesta>) lista;
		
}
	
}
