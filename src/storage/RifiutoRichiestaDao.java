package storage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 * la classe RifiutoRichiestaDao elimina dal database la richiesta che è stata rifiutata
 */
public class RifiutoRichiestaDao {

	int res = 0;
	/**
	 * Metodo che elimina la richiesta che è stata rifiutata dal database
	 * @param id - codice della richiesta
	 * @param stato - stato di accettazione da parte dell'azienda
	 * @param statoTutor - stato di accettazione da parte del tutor
	 * @param statoUfficioStage - stato di accettazione da parte dell'ufficio stage
	 * @param studEmail - email dello studente
	 * @param azEmail - email dell'azienda
	 * @return numero di righe eliminate
	 * @throws SQLException
	 */
	public synchronized int rifiuta(String id, boolean stato, boolean statoTutor, boolean statoUfficioStage,
			String studEmail, String azEmail) throws SQLException {
		Connection conn = null;

		PreparedStatement prep = null;
		PreparedStatement prep2 = null;

		try {
			//System.out.println("Sono in NEGAZIONEDao");
			String richieste = "DELETE FROM Richiesta WHERE Richiesta.AziendaEmail='" + azEmail
					+ "' AND Richiesta.StudenteEmail='" + studEmail + "' AND Stato=false;";

			conn = DriverManagerConnectionPool.getConnection();

			prep = conn.prepareStatement(richieste);

			res = prep.executeUpdate();
			//System.out.println(richieste);

			String update = "UPDATE studente SET notifica = CONCAT(COALESCE(notifica, ''), '<br>', ?) WHERE Email='"
					+ studEmail + "'";
			prep2 = null;
			prep2 = conn.prepareStatement(update);
			String notifica = "<div class=\"desc\"><div class=\"thumb\"><span class=\"badge bg-theme\"><i class=\"fa fa-clock-o\"></i></span></div><div class=\"details\"><p>L'azienda: <a>"
					+ azEmail + "</a> ha rifiutato la tua richiesta.</p></div></div>";
			prep2.setString(1, notifica);

			prep2.executeUpdate();

		} finally {
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
