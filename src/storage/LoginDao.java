package storage;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {

	public synchronized int doLogin(String email, String password)throws SQLException{ 
		Connection conn= null;
		PreparedStatement statement = null;
		
		String login = "select *"+" from Studente";
		conn = DriverManagerConnectionPool.getConnection();
		statement = conn.prepareStatement(login);
		
		ResultSet risultato = statement.executeQuery();
		conn.commit();
		
		int i=0;
		
		try{
			while(risultato.next()){
				if(risultato.getString("Email").equals(email) && risultato.getString("Password").equals(password) && risultato.getString("Tipo").equals("1")){
					return i=1;
				}
				else
				{
					if(risultato.getString("Email").equals(email) && risultato.getString("Password").equals(password) && risultato.getString("Tipo").equals("2"))
				return i=2;
				}
				
			    if(risultato.getString("Email").equals(email) && risultato.getString("Password").equals(password) && risultato.getString("Tipo").equals("3"))
				return i=3;
				
			if(risultato.getString("Email").equals(email) && risultato.getString("Password").equals(password))
				return i=4;
				
			}
	
		}
		catch(SQLException e){
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
		if(i==3){
			return 3;
		}
		if(i==4){
			return 4;
		}
		
	return i;
	}
}
