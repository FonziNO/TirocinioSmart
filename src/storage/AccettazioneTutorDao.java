package storage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccettazioneTutorDao {
	private static final String TABLE_NAME="Richiesta";
	int res = 0;
	public synchronized int accettaTutor(String id, boolean stato, boolean statoTutor, boolean statoUfficio, String studEmail, String azEmail) throws SQLException{
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs = null;
		
		try{
			System.out.println("Sono in AccettazioneTutorDao");
			String richieste="SELECT Studente.Email, Studente.Nome, Studente.Cognome, Studente.Matricola, Richiesta.AziendaEmail,"+
					"Richiesta.StudenteEmail, Tutor.AziendaEmail"+
					"FROM Studente, Richiesta, Tutor"+
					"WHERE Studente.Email='"+studEmail+"' AND Richiesta.AziendaEmail='"+azEmail+"' AND Richiesta.Stato=true;";
			
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
				
				DriverManagerConnectionPool.releaseConnection(conn);
			}
		}
		return res;

	}

}
