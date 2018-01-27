package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import storage.DriverManagerConnectionPool;
import storage.Richiesta;
/**
 * la classe ListaStudentiUfficio permette di visualizzare gli studenti accettati dall'azienda e dal tutor
 */
public class ListaStudentiUfficio {
	
	/**
	 * Metodo che permette all'ufficio stage di accettare la richiesta 
	 * accettata prima dall'azienda e dal tutor
	 * @return
	 * @throws SQLException
	 */
	
	public synchronized ArrayList<Richiesta> doListaStudenteUfficio() throws SQLException {
		Connection conn = null;
		PreparedStatement s = null;
		
		List<Richiesta> lista = new ArrayList<Richiesta>();

		String query = "SELECT * FROM Richiesta, Studente, UfficioStage WHERE Richiesta.StudenteEmail = Studente.Email AND Richiesta.Stato = true AND Richiesta.StatoTutor = true;";
		
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
				richiesta.setStatoU(risultato.getBoolean("StatoUfficio"));
				
				richiesta.setNomeS(risultato.getString("Nome"));
				richiesta.setCognomeS(risultato.getString("Cognome"));
				richiesta.setMatricolaS(risultato.getString("Matricola"));
				
				richiesta.setEmailU(risultato.getString("UfficioStage.Email"));
				
				
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