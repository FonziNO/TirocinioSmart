package storage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RifiutoRichiestaDao {

	private static final String TABLE_NAME = "Richiesta";
	int res = 0;

	public synchronized int rifiuta(String id, boolean stato, boolean statoTutor, boolean statoUfficioStage,
			String studEmail, String azEmail) throws SQLException {
		Connection conn = null;
		PreparedStatement prep = null;
		PreparedStatement prep2 = null;

		try {
			System.out.println("Sono in NEGAZIONEDao");
			String richieste = "DELETE FROM Richiesta WHERE Richiesta.AziendaEmail='" + azEmail
					+ "' AND Richiesta.StudenteEmail='" + studEmail + "' AND Stato=false;";

			conn = DriverManagerConnectionPool.getConnection();

			prep = conn.prepareStatement(richieste);

			res = prep.executeUpdate();
			System.out.println(richieste);

			String update = "UPDATE studente SET notifica = CONCAT(COALESCE(notifica, ''), '<br>', ?) WHERE Email='"
					+ studEmail + "'";
			prep2 = null;
			prep2 = conn.prepareStatement(update);
			prep2.setString(1, "L'azienda " + azEmail + " ha rifiutato la richiesta.");

			prep2.executeUpdate();

		} finally {
			try {
				if (prep != null) {
					prep.close();
					System.out.print("ho modificato" + res);
					System.out.println("");
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
