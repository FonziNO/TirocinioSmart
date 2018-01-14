package storage;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RichiestaDao {
 private static final String TABLE_NAME= "Richiesta";
 int res=0;
 public synchronized int richiedi(String id, boolean stato, String studEmail, String azEmail) throws SQLException {
	 	Connection conn = null; // istanzio la connessione
		PreparedStatement prep = null; // oggetto per inviare query parametriche
		try {
			System.out.println("Sono in RichiestaDao");
			String richiest = "INSERT INTO " + RichiestaDao.TABLE_NAME+"(ID, Stato, StudenteEmail, AziendaEmail) values(?,?,?,?)";
			
			
			// formulo la stringa

			conn = DriverManagerConnectionPool.getConnection();
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

				} finally {
					prep.close();
					DriverManagerConnectionPool.releaseConnection(conn);
				}
			}
			return res;

	}
}

