package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import storage.DriverManagerConnectionPool;
import storage.Richiesta;
public class ListaRichieste {

	public synchronized ArrayList<Richiesta> doListaRichieste() throws SQLException {
		Connection conn = null;
		PreparedStatement s1 = null;

		List<Richiesta> listaR = new ArrayList<Richiesta>();

		String listaRichieste = "SELECT * FROM Richiesta INNER JOIN studente ON StudenteEmail = Email"+
		" INNER JOIN tutor ON tutor.AziendaEmail=richiesta.AziendaEmail"+
		" INNER JOIN azienda ON richiesta.AziendaEmail=azienda.Email"+
		" INNER JOIN UfficioStage";
		conn = DriverManagerConnectionPool.getConnection();
		s1 = conn.prepareStatement(listaRichieste);

		ResultSet risultato1 = s1.executeQuery();
		conn.commit();

		try {
			while (risultato1.next()) {
				Richiesta richiesta = new Richiesta();

				richiesta.setIdR(risultato1.getString("ID"));
				
				richiesta.setStatoR(risultato1.getBoolean("Stato"));
				richiesta.setStatoT(risultato1.getBoolean("StatoTutor"));
				richiesta.setStatoU(risultato1.getBoolean("StatoUfficio"));
				
				richiesta.setEmailS(risultato1.getString("StudenteEmail"));
				richiesta.setEmailA(risultato1.getString("AziendaEmail"));
				richiesta.setEmailT(risultato1.getString("tutor.Email"));
				richiesta.setEmailU(risultato1.getString("UfficioStage.Email"));
				
				richiesta.setNomeA(risultato1.getString("Azienda.Nome"));
				richiesta.setNomeT(risultato1.getString("Tutor.Nome"));
				richiesta.setCognomeT(risultato1.getString("Tutor.Cognome"));

				richiesta.setNomeS(risultato1.getString("Nome"));
				richiesta.setCognomeS(risultato1.getString("Cognome"));
				richiesta.setMatricolaS(risultato1.getString("Matricola"));
				richiesta.setNotifica(risultato1.getString("notifica"));
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
