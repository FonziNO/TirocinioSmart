package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import storage.DriverManagerConnectionPool;
import storage.Richiesta;

public class ListaStudentiUfficio {
	
	public synchronized ArrayList<Richiesta> doListaStudenteTutor() throws SQLException {
		Connection conn = null;
		PreparedStatement s = null;
		List<Richiesta> lista = new ArrayList<Richiesta>();

		String query = "SELECT * FROM Richiesta, Studente WHERE Richiesta.StudenteEmail = Studente.Email AND Richiesta.Stato = true AND Richiesta.StatoTutor = true;";
		
		conn = DriverManagerConnectionPool.getConnection();
		s = conn.prepareStatement(query);
		
		ResultSet risultato = s.executeQuery();
		conn.commit();
		
		try{
			while (risultato.next()) {
				Richiesta richiesta = new Richiesta();
				
				richiesta.setIdR(risultato.getString("ID"));
				richiesta.setEmailA(risultato.getString("AziendaEmail"));
				richiesta.setEmailS(risultato.getString("StudenteEmail"));
				richiesta.setNomeS(risultato.getString("Nome"));
				richiesta.setCognomeS(risultato.getString("Cognome"));
				richiesta.setMatricolaS(risultato.getString("Matricola"));
				
				
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