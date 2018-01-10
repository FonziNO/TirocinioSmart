package storage;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {

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
			while(risultato1.next()){
				if(risultato1.getString("Email").equals(email) && risultato1.getString("Password").equals(password) && risultato1.getString("Tipo").equals("1")){
					return i=1;
				}
			}
			
			while(risultato2.next()){
				if(risultato2.getString("Email").equals(email) && risultato2.getString("Password").equals(password) && risultato2.getString("Tipo").equals("2")){
					return i=2;
				}
			}
			
			while(risultato3.next()){
				if(risultato3.getString("Email").equals(email) && risultato3.getString("Password").equals(password) && risultato3.getString("Tipo").equals("3")){
					return i=3;
				}
			}
			
			while(risultato4.next()){
				if(risultato4.getString("Email").equals(email) && risultato4.getString("Password").equals(password)){
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
