package storage;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 * la classe LoginDao controlla chi farà l'accesso al sistema 
 */
public class LoginDao {
	/**
	 * metodo che permette a un utente di effettuare il login
	 * @param email - email dell'utente
	 * @param password - password dell'utente
	 * @return tipo di utente loggato
	 * @throws SQLException
	 */

	public synchronized int doLogin(String email, String password)throws SQLException{ 
		Connection conn= null;
		PreparedStatement s1 = null;
		PreparedStatement s2 = null;
		PreparedStatement s3 = null;
		PreparedStatement s4 = null;

		String loginStud = "select *"+" from Studente";
		conn = DriverManagerConnectionPool.getConnection();
		s1 = conn.prepareStatement(loginStud);

		String loginTutor = "select *"+"from Tutor";
		conn = DriverManagerConnectionPool.getConnection();
		s2 = conn.prepareStatement(loginTutor);

		String loginAzienda = "select *"+"from Azienda";
		conn = DriverManagerConnectionPool.getConnection();
		s3 = conn.prepareStatement(loginAzienda);

		String loginUfficio = "select *"+"from UfficioStage";
		conn = DriverManagerConnectionPool.getConnection();
		s4 = conn.prepareStatement(loginUfficio);

		ResultSet risultato1 = s1.executeQuery();
		ResultSet risultato2 = s2.executeQuery();
		ResultSet risultato3 = s3.executeQuery();
		ResultSet risultato4 = s4.executeQuery();
		conn.commit();

		int i=0;

		try{
			while(risultato4.next()){
				if(risultato4.getString("UfficioStage.Email").equals(email) && risultato4.getString("UfficioStage.Password").equals(password) && risultato4.getString("Tipo").equals("1")){
					return i=1;
				}
			}

			while(risultato2.next()){
				if(risultato2.getString("Tutor.Email").equals(email) && risultato2.getString("Tutor.Password").equals(password) && risultato2.getString("Tipo").equals("2")){
					return i=2;
				}
			}

			while(risultato3.next()){
				if(risultato3.getString("Azienda.Email").equals(email) && risultato3.getString("Azienda.Password").equals(password) && risultato3.getString("Tipo").equals("3")){
					return i=3;
				}
			}

			while(risultato1.next()){
				if(risultato1.getString("Studente.Email").equals(email) && risultato1.getString("Studente.Password").equals(password)){
					return i=4;
				}
			}

		}catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{
				conn.close();

			} catch (SQLException e){
				e.printStackTrace();
			}
		}
		if(i==1)//ufficio stage
		{return 1;

		}
		if (i==2){ //tutor
			return 2;
		}
		if(i==3){//azienda
			return 3;
		}
		if(i==4){ //studente
			return 4;
		}

		return i;
	}
}
