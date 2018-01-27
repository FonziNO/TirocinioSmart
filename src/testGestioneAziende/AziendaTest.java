package testGestioneAziende;

import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.InviaRichiesta;
import application.ListaAziende;
import storage.AccettazioneDao;
import storage.AccettazioneTutorDao;
import storage.AccettazioneUfficioDao;
import storage.Azienda;
import storage.DriverManagerConnectionPool;
import storage.RichiestaDao;


public class AziendaTest{
	
	
	Connection conn;
	PreparedStatement prep = null; // oggetto per inviare query parametriche
	PreparedStatement prep2 = null;
	RichiestaDao richiesta;
	InviaRichiesta inviaric;
	AccettazioneDao accAz;
	AccettazioneTutorDao accTu;
	AccettazioneUfficioDao accUf;


	ResultSet rs = null;

	String iD;
	boolean stat;
	boolean statoTuto;
	boolean statoUffici;
	String studEmai;
	String azEmai;

	@Test
	public void testDoListaAziende() throws SQLException {

		ListaAziende lista= new ListaAziende();
		List<Azienda> aziende = new ArrayList<Azienda>();
		aziende=lista.doListaAziende();
	
		
		//l'azienda AF Soluzioni esiste nel database
		//verifichiamo che sia presente nella lista

		assertEquals("aziendaAFSoluzioni@gmail.it", aziende.get(0).getEmailA());
		assertEquals("AFSoluzioni", aziende.get(0).getPasswordA());
		assertEquals("AF Soluzioni srl", aziende.get(0).getNomeA());
		assertEquals("Salerno", aziende.get(0).getLocazioneA());
	}
	

	
	
	

}
