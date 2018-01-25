package testGestioneAziende;

import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import java.sql.SQLException;

import application.ListaAziende;
import storage.Azienda;


public class AziendaTest{


	@Test
	public void testDoListaAziende() throws SQLException {

		ListaAziende lista= new ListaAziende();
		List<Azienda> aziende = new ArrayList<Azienda>();
		aziende=lista.doListaAziende();

		//l'azienda azienda1 non esiste nel database
		//verifichiamo che non sia presente nella lista
		for(int i=0; i<aziende.size(); i++){

			assertNotEquals("azienda1", aziende.get(i).getNomeA());
		}
		
		//l'azienda AF Soluzioni esiste nel database
		//verifichiamo che sia presente nella lista

		assertEquals("aziendaAFSoluzioni@gmail.it", aziende.get(0).getEmailA());
		assertEquals("AFSoluzioni", aziende.get(0).getPasswordA());
		assertEquals("AF Soluzioni srl", aziende.get(0).getNomeA());
		assertEquals("Salerno", aziende.get(0).getLocazioneA());


	}

}
