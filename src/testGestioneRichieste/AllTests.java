package testGestioneRichieste;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import application.ListaRichieste;

@RunWith(Suite.class)
@SuiteClasses({InviaRichiestaTest.class, ListaRichiesteTest.class, AccettazioneRichiestaTest.class, ListaAccettatiTutorTest.class, AccettazioneTutorTest.class, ListaAccettatiUfficioTest.class, AccettazioneUfficioTest.class, RifiutaRichiestaTest.class })
public class AllTests {

}
