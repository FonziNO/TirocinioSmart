package storage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * la classe AccettazioneUfficioDao aggiorna lo stato di accettazione della richiesta
 * da parte dell'ufficio stage
 */
public class AccettazioneUfficioDao {
	int res = 0;
	/**
	 * Metodo che permette di aggiornare lo stato di accettazione da parte dell'ufficio stage 
	 * di una determinata richiesta accettata dall'azienda e dal tutor
	 * @param id - codice della richiesta
	 * @param stato - lo stato di accettazione da parte dell'azienda
	 * @param statoTutor - lo stato di accettazione da parte del tutor
	 * @param statoUfficio - lo stato di accettazione da parte dell'ufficio stage
	 * @param studEmail - email dello studente che ha inviato la richiesta
	 * @param azEmailA - email dell'azienda a cui è stata inviata la richiesta
	 * @return il numero di righe aggiornate
	 * @throws SQLException
	 */
	public synchronized int accettaUfficio(String id, boolean stato, boolean statoTutor, boolean statoUfficio, String studEmail, String azEmailA) throws SQLException{
		Connection conn=null;
		PreparedStatement prep=null;
		
		try{
			//System.out.println("Sono in AccettazioneUfficioDao");

			String richieste="UPDATE Richiesta SET StatoUfficio=true WHERE StudenteEmail='"+studEmail+"'AND StatoTutor=true AND Stato=true;";
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
	 * Metodo che restituisce la lista delle aziende
	 * @return lista delle aziende convenzionate
	 * @throws SQLException
	 */
	public synchronized ArrayList<Richiesta> doListaAziende() throws SQLException {
		Connection conn = null;
		PreparedStatement s1 = null;

		List<Richiesta> listaA = new ArrayList<Richiesta>();

		String listaAziende = "SELECT * FROM Richiesta;";

		conn = DriverManagerConnectionPool.getConnection();
		s1 = conn.prepareStatement(listaAziende);

		ResultSet risultato1 = s1.executeQuery();
		conn.commit();

		try {
			while (risultato1.next()) {
				Richiesta richiesta = new Richiesta();
				
				richiesta.setEmailA(risultato1.getString("AziendaEmail"));

				listaA.add(richiesta);


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
		return (ArrayList<Richiesta>) listaA;
	}
}
