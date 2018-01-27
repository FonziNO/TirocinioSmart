package storage;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.PreparedStatement;
/**
 * la classe AccettazioneDao aggiorna lo stato della richiesta
 */
public class AccettazioneDao {
	
	int res = 0;
	/**
	 * Metodo che permette l'aggiornamento dello stato di accettazione da parte dell'azienda
	 * di una determinata richiesra
	 * @param id - codice univoco della richiesta
	 * @param stato - lo stato di accettazione da parte dell'azienda
	 * @param statoTutor - lo stato di accettazione da parte del tutor
	 * @param statoUfficio - lo stato di accettazione da parte dell'ufficio stage
	 * @param studEmail - email dello studente che ha inviato la richiesta
	 * @param azEmail - email dell'azienda a cui è stata inviata la richiesta
	 * @return il numero di righe che sono state aggiornate
	 * @throws SQLException
	 */
	public synchronized int accetta(String id, boolean stato, boolean statoTutor, boolean statoUfficio, String studEmail, String azEmail) throws SQLException{
		Connection conn=null;
		PreparedStatement prep=null;

		try{
			//System.out.println("Sono in AccettazioneDao");
			String richieste="UPDATE Richiesta SET Stato=true WHERE StudenteEmail='"+studEmail+"'AND AziendaEmail='"+azEmail+"';";

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

				DriverManagerConnectionPool.releaseConnection(conn);
			}
		}
		return res;

	}
	/**
	 * Metodo che permette di non visualizzare la richiesta nel momento in cui viene accettata
	 * @param emailS - email dello studente a cui è stata accettata la richiesta
	 * @return il numero di righe eliminate
	 * @throws SQLException
	 */
	public synchronized int deleteRichieste(String emailS) throws SQLException {
		Connection conn = null;
		PreparedStatement prep = null;

		try{
			String listaRichieste = "delete from Richiesta where Richiesta.StudenteEmail='"+emailS+"' and Richiesta.Stato=false;";

			conn = DriverManagerConnectionPool.getConnection();
			prep = conn.prepareStatement(listaRichieste);

			res=prep.executeUpdate();
			//System.out.println(listaRichieste);
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

				DriverManagerConnectionPool.releaseConnection(conn);
			}
		}
		return res;
	}

}
