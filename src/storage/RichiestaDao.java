package storage;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RichiestaDao {
	private static final String TABLE_NAME = "Richiesta";
	int res = 0;

	public synchronized int richiedi(String id, boolean stato, String studEmail, String azEmail) throws SQLException {
		Connection conn = null; // istanzio la connessione
		PreparedStatement prep = null; // oggetto per inviare query parametriche
		PreparedStatement prep2 = null;
		ResultSet rs = null;
		try {
			System.out.println("Sono in RichiestaDao");
			String richiest = "INSERT INTO " + RichiestaDao.TABLE_NAME
					+ "(ID, Stato, StudenteEmail, AziendaEmail) values(?,?,?,?)";
			String contol = "SELECT COUNT(*) AS C FROM richiesta WHERE studenteEmail = ? AND AziendaEmail = ?";

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
			if(rs.getString("C").equals("0")){
				return 1;
			}

			prep = conn.prepareStatement(richiest);
			prep.setString(1, id);
			prep.setBoolean(2, stato);
			prep.setString(3, studEmail);
			prep.setString(4, azEmail);

			// eseguo la query
			res = prep.executeUpdate();// mi ritorna il numero di righe
										// aggiornate percio un intero

			conn.commit();
			System.out.println("risultato: " + res);
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
