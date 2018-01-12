package storage;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class RegistratiDao 
{
	private static final String TABLE_NAME="Studente";
	int res;
	public synchronized int salva(String email, String nome, String cognome, String matricola, String password, Date dataNascita, String cellulare) throws SQLException
	{
		Connection conn = null; // istanzio la connessione
		PreparedStatement prep = null; // oggetto per inviare query parametriche


		try
		{

			String register ="INSERT INTO "+RegistratiDao.TABLE_NAME + "(Email, Nome, Cognome, Matricola, Password, DataNascita, Cellulare) VALUES (?,?,?,?,?,?,?)";
		// formulo la stringa
			
		conn= DriverManagerConnectionPool.getConnection();
		prep= conn.prepareStatement(register);
		prep.setString(1, email);
		prep.setString(2, nome);
		prep.setString(3, cognome);
		prep.setString(4, matricola);
		prep.setString(5, password);
		prep.setDate(6, dataNascita);
		prep.setString(7, cellulare);

		//eseguo la query
		res =prep.executeUpdate();// mi ritorna il  numero di righe aggiornate percio un intero
		conn.commit();
		System.out.println("risultato: " +res);
		}
	finally
	{
		try
		{
			if(prep!= null)
			{
				prep.close();
			System.out.print("ho modificato" + res);
			System.out.print("va bee");
			}


		}finally
		{
			prep.close();
			DriverManagerConnectionPool.releaseConnection(conn);
		}
	}
		return res;

}
}