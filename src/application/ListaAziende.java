package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import storage.Azienda;
import storage.DriverManagerConnectionPool;
/**
 * La classe ListaAziende permette di vedere la lista delle aziende
 */
public class ListaAziende{

	/**
	 * Metodo che restituisce la lista delle aziende
	 * @return lista delle aziende convenzionate
	 */

	public synchronized ArrayList<Azienda> doListaAziende()throws SQLException{ 
		Connection conn= null;
		PreparedStatement s1 = null;


		List<Azienda> listaA = new ArrayList<Azienda>();

		String listaAziende = "select *"+" from Azienda";
		conn = DriverManagerConnectionPool.getConnection();
		s1 = conn.prepareStatement(listaAziende);

		ResultSet risultato1 = s1.executeQuery();
		conn.commit();

		try{
			while(risultato1.next()){
				Azienda azienda= new Azienda();
				azienda.setEmailA(risultato1.getString("Email"));
				azienda.setPasswordA(risultato1.getString("Password"));
				azienda.setNomeA(risultato1.getString("Nome"));
				azienda.setLocazioneA(risultato1.getString("Locazione"));

				listaA.add(azienda);	
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(risultato1 != null){
				try{
					risultato1.close();

				} catch (Exception e){
					e.printStackTrace();
				}
			}
			if(s1 != null){
				try{
					s1.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return (ArrayList<Azienda>) listaA;
	}
}
