package storage;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * La classe AccettazioneTutorDao aggiorna lo stato 
 * di accettazione della richiesta da parte del tutor
 */
public class AccettazioneTutorDao {

	int res = 0;
	/**
	 * Metodo che permette di aggiornare lo stato di accettazione da parte del tutor 
	 * di una determinata richiesta accettata dall'azienda
	 * @param id - codice della richiesta
	 * @param stato - lo stato di accettazione da parte dell'azienda
	 * @param statoTutor - lo stato di accettazione da parte del tutor
	 * @param statoUfficio - lo stato di accettazione da parte dell'ufficio stage
	 * @param studEmail - email dello studente che ha inviato la richiesta
	 * @param azEmailT - email dell'azienda a cui è stata inviata la richiesta
	 * @return il numero di righe aggiornate
	 * @throws SQLException
	 */
	public synchronized int accettaTutor(String id, boolean stato, boolean statoTutor, boolean statoUfficio, String studEmail, String azEmailT) throws SQLException{
		Connection conn=null;
		PreparedStatement prep=null;

		try{
			//System.out.println("Sono in AccettazioneTutorDao");

			String richieste="UPDATE Richiesta SET StatoTutor=true WHERE StudenteEmail='"+studEmail+"'AND AziendaEmail='"+azEmailT+"';";

			conn = DriverManagerConnectionPool.getConnection();

			prep = conn.prepareStatement(richieste);

			res=prep.executeUpdate();
			//System.out.println(richieste);

		}finally {
			try {
				if (prep != null) {
					prep.close();
					//System.out.print("ho modificato" + res);
					//System.out.println("");
				}

			} finally {
				if (prep != null) {
					prep.close();
				}
			}
			DriverManagerConnectionPool.releaseConnection(conn);
		}
		return res;
	}

	/**
	 * Metodo che restituisce la lista dei tutor
	 * @return la lista dei tutor
	 * @throws SQLException
	 */
	public synchronized ArrayList<Tutor> doListaTutor() throws SQLException {
		Connection conn = null;
		PreparedStatement s1 = null;

		List<Tutor> listaT = new ArrayList<Tutor>();

		String listaTutor = "SELECT * FROM Tutor;";

		conn = DriverManagerConnectionPool.getConnection();
		s1 = conn.prepareStatement(listaTutor);

		ResultSet risultato1 = s1.executeQuery();
		conn.commit();

		try {
			while (risultato1.next()) {
				Tutor tutor = new Tutor();

				tutor.setEmailT(risultato1.getString("Email"));
				tutor.setEmailA(risultato1.getString("AziendaEmail"));

				listaT.add(tutor);

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
		return (ArrayList<Tutor>) listaT;
	}

}

