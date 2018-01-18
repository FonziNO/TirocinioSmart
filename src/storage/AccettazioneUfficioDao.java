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

			String richieste="UPDATE Richiesta SET StatoUfficio=true WHERE StatoTutor = true;";

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
	public synchronized ArrayList<UfficioStage> doListaUfficio() throws SQLException {
		Connection conn = null;
		PreparedStatement s1 = null;

		List<UfficioStage> lista = new ArrayList<UfficioStage>();

		String listaUfficio = "SELECT * FROM UfficioStage;";

		conn = DriverManagerConnectionPool.getConnection();
		s1 = conn.prepareStatement(listaUfficio);

		ResultSet risultato1 = s1.executeQuery();
		conn.commit();

		try {
			while (risultato1.next()) {
				UfficioStage ufficio = new UfficioStage();
				
				ufficio.setEmailU(risultato1.getString("Email"));

				lista.add(ufficio);


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
		return (ArrayList<UfficioStage>) lista;
	}




}
