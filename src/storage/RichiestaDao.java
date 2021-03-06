package storage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * la classe RichiestaDao memorizza la richiesta inviata da uno studente a un'azienda
 */
public class RichiestaDao {
	public static final String TABLE_NAME = "Richiesta";
	int res = 0;

	/**
	 * Metodo che permette di memorizzare la richiesta nel database
	 * @param id - codice della richiesta
	 * @param stato - stato di accettazione della richiesta da parte dell'azienda
	 * @param statoTutor - stato di accettazione della richiesta da parte del tutor
	 * @param statoUfficio - stato di accettazione della richiesta da parte dell'ufficio stage
	 * @param studEmail - email dello studente
	 * @param azEmail - email dell'azienda
	 * @return numero di righe aggiornate
	 * @throws SQLException
	 */
	public synchronized int richiedi(String id, boolean stato, boolean statoTutor, boolean statoUfficio, String studEmail, String azEmail) throws SQLException {
		Connection conn = null; // istanzio la connessione

		PreparedStatement prep = null; // oggetto per inviare query parametriche
		PreparedStatement prep2 = null;

		ResultSet rs = null;

		try {
			//System.out.println("Sono in RichiestaDao");
			String richiest = "INSERT INTO " + RichiestaDao.TABLE_NAME
					+ "(ID, Stato, StatoTutor, StatoUfficio, StudenteEmail, AziendaEmail) values(?,?,?,?,?,?)";
			String contol = "SELECT COUNT(*) AS C FROM richiesta WHERE studenteEmail = ? AND aziendaEmail = ?";

			// formulo la stringa

			conn = DriverManagerConnectionPool.getConnection();

			prep2 = conn.prepareStatement(contol);

			prep2.setString(1, studEmail);
			prep2.setString(2, azEmail);

			rs = prep2.executeQuery();
			rs.next();

			if (!rs.getString("C").equals("0")) {
				return -1;
			}

			prep = conn.prepareStatement(richiest);
			prep.setString(1, id);
			prep.setBoolean(2, stato);
			prep.setBoolean(3,statoTutor);
			prep.setBoolean(4, statoUfficio);
			prep.setString(5, studEmail);
			prep.setString(6, azEmail);

			// eseguo la query
			res = prep.executeUpdate();// mi ritorna il numero di righe
			// aggiornate percio un intero

			conn.commit();
			//System.out.println("risultato: " + res);
		}
		finally {
			try {
				if (prep != null) {
					prep.close();
					//System.out.print("ho modificato" + res);
					//System.out.println("");
				}
				if (prep2 != null) {
					prep2.close();
				}
			} finally {
				if (prep != null) {
					prep.close();
				}
				if (prep2 != null) {
					prep2.close();
				}
				DriverManagerConnectionPool.releaseConnection(conn);
			}
		}
		return res;

	}
}
