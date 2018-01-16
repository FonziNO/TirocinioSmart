package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;


import storage.DriverManagerConnectionPool;
import storage.Richiesta;
import storage.Studente;

public class AccettaRichieste {
	public synchronized ArrayList<Richiesta> doListaRichieste() throws SQLException{
		Connection conn = null;
		PreparedStatement s = null;
		PreparedStatement s1 = null;
	
		List<Richiesta> listaR = new ArrayList<Richiesta>();
		List<Studente> listaS = new ArrayList<Studente>();
		List<Richiesta> studentiAccettati = new ArrayList<Richiesta>();
		String richieste = "select *" + "from Richiesta;";
		String studenti = "select Studente.Email" + "from Studente;";
		
		conn = DriverManagerConnectionPool.getConnection();
		s = conn.prepareStatement(richieste);
		s1 = conn.prepareStatement(studenti);
		ResultSet risultato = s.executeQuery();
		ResultSet risultato1 = s1.executeQuery();
		
		conn.commit();
		
		try{
			while (risultato.next()){
				Richiesta richiesta = new Richiesta();
				richiesta.setIdR(risultato.getString("ID"));
				richiesta.setStatoR(risultato.getString("Stato"));
				richiesta.setEmailS(risultato.getString("StudenteEmail"));
				richiesta.setEmailA(risultato.getString("AziendaEmail"));
				listaR.add(richiesta);
			}
			
			while (risultato1.next()){
				Studente studente = new Studente();
				studente.setEmailS(risultato1.getString("Email"));
				studente.setNomeS(risultato1.getString("Nome"));
				studente.setCognomeS(risultato1.getString("Cognome"));
				studente.setMatricolaS(risultato1.getString("Matricola"));
				listaS.add(studente);
			}
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		
		finally{
			if(risultato != null){
				try{
					risultato.close();
				} 
				
				catch (Exception e){
					e.printStackTrace();
				}
				
				if (risultato1 != null){
					try{
						risultato1.close();
					}
					catch (Exception e){
						e.printStackTrace();
					}
				}
			}
			
			if(s != null){
				try{
					s.close();
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return AttayList<>;
	
	}
	}

