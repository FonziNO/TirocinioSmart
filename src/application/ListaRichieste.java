package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import storage.DriverManagerConnectionPool;
import storage.Richiesta;
import storage.Studente;

public class ListaRichieste {
	public synchronized ArrayList<Studente> doListaStudenti(String sessione)throws SQLException{ 
		Connection conn= null;
		PreparedStatement s2=null;


		List<Studente> listaS = new ArrayList<Studente>();
		String studenti="select Studente.Email, Studente.Nome, Studente.Cognome, Studente.Matricola"+
		" from Richiesta, Studente where Richiesta.StudenteEmail=Studente.Email AND Richiesta.AziendaEmail=" + sessione;
		conn = DriverManagerConnectionPool.getConnection();
		s2 = conn.prepareStatement(studenti);
		ResultSet risultato2 = s2.executeQuery();
		
		conn.commit();

		try{
			while(risultato2.next()){
				Studente studente= new Studente();
				studente.setEmailS(risultato2.getString("Email"));
				studente.setNomeS(risultato2.getString("Nome"));
				studente.setCognomeS(risultato2.getString("Cognome"));
				studente.setMatricolaS(risultato2.getString("Matricola"));
				listaS.add(studente);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(risultato2 != null){
				try{
					risultato2.close();

				} catch (Exception e){
					e.printStackTrace();
				}
			}
			if(s2 != null){
				try{
					s2.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return (ArrayList<Studente>) listaS;
	}
	public synchronized ArrayList<Richiesta> doListaRichieste()throws SQLException{ 
		Connection conn= null;
		PreparedStatement s1 = null;


		List<Richiesta> listaR = new ArrayList<Richiesta>();

		String listaRichieste = "select * from Richiesta";
		
		conn = DriverManagerConnectionPool.getConnection();
		s1 = conn.prepareStatement(listaRichieste);
		
		
		ResultSet risultato1 = s1.executeQuery();
		conn.commit();

		try{
			while(risultato1.next()){
				Richiesta richiesta= new Richiesta();
				richiesta.setIdR(risultato1.getString("ID"));
				richiesta.setStatoR(risultato1.getString("Stato"));
				richiesta.setEmailS(risultato1.getString("StudenteEmail"));
				richiesta.setEmailA(risultato1.getString("AziendaEmail"));
				
				listaR.add(richiesta);	
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
		return (ArrayList<Richiesta>) listaR;
	}
	

}
