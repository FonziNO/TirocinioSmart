package storage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccettazioneUfficioDao {
	
	private static final String TABLE_NAME="Richiesta";
	int res = 0;
	public synchronized int accettaUfficio(String id, boolean stato, boolean statoTutor, boolean statoUfficio, String studEmail, String azEmailT) throws SQLException{
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs = null;
		
		try{
			System.out.println("Sono in AccettazioneUfficioDao");

			String richieste="UPDATE Richiesta SET StatoUfficio=true WHERE StudenteEmail='"+studEmail+"'AND AziendaEmail='"+azEmailT+"' AND StatoTutor=true AND Stato=true;";
			conn = DriverManagerConnectionPool.getConnection();

			prep = conn.prepareStatement(richieste);

			res=prep.executeUpdate();
			System.out.println(richieste);


		}finally {
			try {
				if (prep != null) {
					prep.close();
					System.out.print("ho modificato" + res);
					System.out.println("");
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
	public synchronized ArrayList<Azienda> doListaAziende() throws SQLException {
		Connection conn = null;
		PreparedStatement s1 = null;

		List<Azienda> listaA = new ArrayList<Azienda>();

		String listaAziende = "SELECT * FROM Azienda;";

		conn = DriverManagerConnectionPool.getConnection();
		s1 = conn.prepareStatement(listaAziende);

		ResultSet risultato1 = s1.executeQuery();
		conn.commit();

		try {
			while (risultato1.next()) {
				Azienda azienda = new Azienda();
				
				azienda.setEmailA(risultato1.getString("Email"));

				listaA.add(azienda);


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
		return (ArrayList<Azienda>) listaA;
	}
	
	public synchronized int cambiaStatoPF(String emailAzienda, String emailTutor, boolean stato) throws SQLException{
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs = null;
		try{
			System.out.println("Sono in AccettazioneUfficioDao");

			String richieste="UPDATE ProgettoFormativo SET StatoP=true WHERE AziendaEmail='"+emailAzienda+"' AND TutorEmail='"+emailTutor+"';";
			conn = DriverManagerConnectionPool.getConnection();

			prep = conn.prepareStatement(richieste);

			res=prep.executeUpdate();
			System.out.println(richieste);


		}finally {
			try {
				if (prep != null) {
					prep.close();
					System.out.print("ho modificato" + res);
					System.out.println("");
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


}
