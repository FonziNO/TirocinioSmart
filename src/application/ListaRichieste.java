package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import storage.DriverManagerConnectionPool;
import storage.Richiesta;
import storage.Studente;

public class ListaRichieste {
	
	public synchronized ArrayList<Richiesta> doListaRichieste() throws SQLException {
		Connection conn = null;
		PreparedStatement s1 = null;
	
		List<Richiesta> listaR = new ArrayList<Richiesta>();

		String listaRichieste = "SELECT * FROM Richiesta INNER JOIN studente ON StudenteEmail = Email";

		conn = DriverManagerConnectionPool.getConnection();
		s1 = conn.prepareStatement(listaRichieste);

		ResultSet risultato1 = s1.executeQuery();
		conn.commit();

		try {
			while (risultato1.next()) {
				Richiesta richiesta = new Richiesta();
				
				richiesta.setIdR(risultato1.getString("ID"));
				richiesta.setStatoR(risultato1.getString("Stato"));
				richiesta.setStatoT(risultato1.getBoolean("StatoTutor"));
				richiesta.setStatoU(risultato1.getBoolean("StatoUfficio"));
				richiesta.setEmailS(risultato1.getString("StudenteEmail"));
				richiesta.setEmailA(risultato1.getString("AziendaEmail"));
				
				richiesta.setNomeS(risultato1.getString("Nome"));
				richiesta.setCognomeS(risultato1.getString("Cognome"));
				richiesta.setMatricolaS(risultato1.getString("Matricola"));
				
				listaR.add(richiesta);
				
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (risultato1 != null) {
				try {
					risultato1.close();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (s1 != null) {
				try {
					s1.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return (ArrayList<Richiesta>) listaR;
	}

}
