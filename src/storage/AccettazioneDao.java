package storage;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class AccettazioneDao {
	
	private static final String TABLE_NAME="Richiesta";
	int res = 0;
	public synchronized int accetta(String id, boolean stato, String studEmail, String azEmail) throws SQLException{
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs = null;
		
		try{
			System.out.println("Sono in AccettazioneDao");
			String richieste="UPDATE Richiesta SET Stato=true WHERE StudenteEmail='"+studEmail+"';";
			
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
