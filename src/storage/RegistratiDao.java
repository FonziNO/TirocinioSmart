package storage;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 * la classe RegistratiDao aggiunge uno studente al database
 */
public class RegistratiDao {

	private static final String TABLE_NAME = "Studente";
	int res = 0;
	/**
	 * metodo che memorizza lo sudente nel database
	 * @param email - email dello studente
	 * @param nome - nome dello studente
	 * @param cognome - cognome dello studente
	 * @param matricola - matricola dello studente
	 * @param password - password dello studente
	 * @param datanascita - data di nascita dello studente
	 * @param cellulare - numero di cellulare dello studente
	 * @return il numero di righe modificate
	 * @throws SQLException
	 */
	public synchronized int salva(String email, String nome, String cognome, String matricola, String password,
			String datanascita, String cellulare) throws SQLException {
		Connection conn = null; // istanzio la connessione
		PreparedStatement prep = null; // oggetto per inviare query parametriche

		try {
			// System.out.println("Sono in RegistratiDao");
			String register = "INSERT INTO " + RegistratiDao.TABLE_NAME
					+ "(Email, Nome, Cognome, Matricola, Password, DataNascita, Cellulare, Tipo, notifica) VALUES (?,?,?,?,?,?,?,?,?)";
			// formulo la stringa

			conn = DriverManagerConnectionPool.getConnection();
			prep = conn.prepareStatement(register);

			if((email.indexOf("studenti.unisa.it")!=-1)&&(matricola.indexOf("05121")!=-1)&&(cellulare.length() <=10)){
				prep.setString(1, email);

				prep.setString(2, nome);
				prep.setString(3, cognome);
				prep.setString(4, matricola);
			
				prep.setString(5, password);
				prep.setDate(6, Date.valueOf(datanascita));
				
				prep.setString(7, cellulare);
				
				prep.setInt(8, 0);
				prep.setString(9, null);
			
			// eseguo la query
			res = prep.executeUpdate();// mi ritorna il numero di righe
			conn.commit();
			}
			// System.out.println("risultato: " + res);
		} finally {
			try {
				if (prep != null) {
					prep.close();
					// System.out.print("ho modificato" + res);
					// System.out.println("");
				}

			} finally {
				prep.close();
				DriverManagerConnectionPool.releaseConnection(conn);
			}
		}
		return res;

	}
}