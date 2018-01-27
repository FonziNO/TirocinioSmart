package storage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * la Richiesta ha un id, stato accettazione dell'azienda, stato accettazione del tutor,
 * stato di accettazione dell'ufficio stage, email dello studente, dell'azienda, del tutor,
 * e dell'ufficio stage, il nome dello studente, dell'azienda e dell'ufficio stage, il cognome,
 * dello studente e del tutor, la notifica di rifiuto
 */
public class Richiesta {

	private String IdR;

	private boolean statoR;
	private boolean statoT;
	private boolean statoU;

	private String emailS;
	private String nomeS;
	private String cognomeS;
	private String matricolaS;

	private String nomeA;
	private String emailA;

	private String emailT;
	private String nomeT;
	private String cognomeT;
	private String notifica;

	private String emailU;

	private static int counter = initialize();

	public Richiesta() {
		try {
			increaseCounter();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo che restituisce il nome dell'azienda
	 * @return nome dell'azienda
	 */
	public String getNomeA() {
		return nomeA;
	}
	/**
	 * Metodo che modifica il nome dell'azienda
	 * @param nomeA - nome dell'azienda
	 */
	public void setNomeA(String nomeA) {
		this.nomeA = nomeA;
	}
	/**
	 * Metodo che restituisce il nome del tutor
	 * @return nome del tutor
	 */
	public String getNomeT() {
		return nomeT;
	}

	/**
	 * Metodo che cambia il nome del tutor
	 * @param nomeT - nome del tutor
	 */
	public void setNomeT(String nomeT) {
		this.nomeT = nomeT;
	}
	/**
	 * Metodo che restituisce il cognome del tutor
	 * @return cognome del tutor
	 */
	public String getCognomeT() {
		return cognomeT;
	}
	/**
	 * Metodo che modifica il cognome del tutor
	 * @param cognomeT - cognome del tutor
	 */
	public void setCognomeT(String cognomeT) {
		this.cognomeT = cognomeT;
	}
	/**
	 * metodo che restituisce lo stato di accettazione da parte del tutor
	 * @return stato di accettazione del tutor
	 */
	public boolean getStatoT() {
		return statoT;
	}
	/**
	 * Metodo che modifica lo stato del tutor
	 * @param statoT - stato di accettazione del tutor
	 */
	public void setStatoT(boolean statoT) {
		this.statoT = statoT;
	}
	/**
	 * Metodo che restituisce lo stato di accettazione dell'ufficio stage
	 * @return stato di accettazione dell'ufficio stage
	 */
	public boolean getStatoU() {
		return statoU;
	}
	/**
	 * Metodo che cambia lo stato di accettazione da parte dell'ufficio stage
	 * @param statoU - stato di accettazione dell'ufficio stage
	 */
	public void setStatoU(boolean statoU) {
		this.statoU = statoU;
	}
	/**
	 * Metodo che restituisce l'email dell'ufficio stage
	 * @return email dell'ufficio stage
	 */
	public String getEmailU() {
		return emailU;
	}
	/**
	 * Metodo che modifica l'email dell'ufficio stage
	 * @param emailU - email dell'ufficio stage
	 */
	public void setEmailU(String emailU) {
		this.emailU = emailU;
	}
	/**
	 * Metodo che restituisce l'email dello studente
	 * @return email dello studente
	 */
	public String getEmailS() {
		return emailS;
	}
	/**
	 * Metodo che modifica l'email dello studente
	 * @param emailS - email dello studente
	 */
	public void setEmailS(String emailS) {
		this.emailS = emailS;
	}
	/**
	 * Metodo che restituisce l'email dell'azienda
	 * @return email dell'azienda
	 */
	public String getEmailA() {
		return emailA;
	}
	/**
	 * Metodo che modifica l'email dell'azienda
	 * @param emailA - email dell'azienda
	 */
	public void setEmailA(String emailA) {
		this.emailA = emailA;
	}
	/**
	 * Metodo che restituisce l'id della richiesta
	 * @return id della richiesta
	 */
	public String getIdR() {
		return IdR;
	}
	/**
	 * Metodo che modifica l'id della richiesta
	 * @param idR - id della richiesta
	 */
	public void setIdR(String idR) {
		IdR = idR;
	}
	/**
	 * Metodo che restituisce lo stato di accettazione da parte dell'azienda
	 * @return stato di accettazione da parte dell'azienda
	 */
	public boolean getStatoR() {
		return statoR;
	}
	/**
	 * Metodo che modifica lo stato di accettazione da parte dell'azienda
	 * @param statoR - stato di accettazione da parte dell'azienda
	 */
	public void setStatoR(boolean statoR) {
		this.statoR = statoR;
	}
	/**
	 * Metodo che restituisce l'id della richiesta
	 * @return id della richiesta
	 */
	private static int initialize() {
		int cont = 0;
		Scanner in = null;
		FileReader reader = null;
		if (counter == 0) {
			try {
				reader = new FileReader("Contatore");
				in = new Scanner(reader);
				String c = in.nextLine();

				cont = Integer.parseInt(c);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} finally {
				if (in != null) {
					in.close();
				}
			}
		}
		return cont;
	}
	/**
	 * Metodo che modifica l'id della richiesta
	 * @throws FileNotFoundException
	 */
	private void increaseCounter() throws FileNotFoundException {
		counter++;
		PrintWriter scrivi = new PrintWriter("Contatore");
		scrivi.println(counter);
		scrivi.close();
	}
	/**
	 * Metodo che restituisce l'id della richiesta
	 * @return id della richiesta
	 */
	public static String getCounter() {
		return "R" + counter;
	}
	/**
	 * Metodo che modifica il nome dello studente
	 * @param nomeS - nome dello studente
	 */
	public void setNomeS(String nomeS) {
		this.nomeS = nomeS;

	}
	/**
	 * Metodo che restituisce il nome dello studente
	 * @return nome dello studente
	 */
	public String getNomeS() {
		return nomeS;
	}
	/**
	 * Metodo che modifica il cognome dello studente
	 * @param cognomeS - cognome dello studente
	 */
	public void setCognomeS(String cognomeS) {
		this.cognomeS = cognomeS;

	}
	/**
	 * Metodo che restituisce il cognome dello studente
	 * @return cognome dello studente
	 */
	public String getCognomeS() {
		return cognomeS;
	}
	/**
	 * Metodo che modifica la matricola dello studente
	 * @param matricolaS - matricola dello studente
	 */
	public void setMatricolaS(String matricolaS) {
		this.matricolaS = matricolaS;

	}
	/**
	 * Metodo che restituisce la matricola dello studente
	 * @return matricola dello studente
	 */
	public String getMatricolaS() {
		return matricolaS;
	}
	/**
	 * Metodo che restituisce l'email del tutor
	 * @return email del tutor
	 */
	public String getEmailT() {
		return emailT;
	}
	/**
	 * Metodo che modifica l'email del tutor
	 * @param emailT - email del tutor
	 */
	public void setEmailT(String emailT) {
		this.emailT = emailT;
	}
	/**
	 * Metodo che restituisce la notifica di rifiuto
	 * @return notifica di rifiuto
	 */
	public String getNotifica() {
		return notifica;
	}
	/**
	 * Metodo che modifica la notifica di rifiuto
	 * @param notifica - notifica di rifiuto
	 */
	public void setNotifica(String notifica) {
		this.notifica = notifica;
	}
}
