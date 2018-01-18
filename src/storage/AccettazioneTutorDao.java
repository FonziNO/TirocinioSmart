package storage;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccettazioneTutorDao {

	private static final String TABLE_NAME="Richiesta";
	int res = 0;
	public synchronized int accettaTutor(String id, boolean stato, boolean statoTutor, boolean statoUfficio, String studEmail, String azEmailT) throws SQLException{
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs = null;

		try{
			System.out.println("Sono in AccettazioneTutorDao");

			String richieste="UPDATE Richiesta SET StatoTutor=true WHERE StudenteEmail='"+studEmail+"'AND AziendaEmail='"+azEmailT+"';";

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

