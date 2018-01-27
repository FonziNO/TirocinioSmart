package storage;

import java.util.GregorianCalendar;
/**
 * lo Studente ha nome, cognome, matricola, email, password, data di nascita, cellulare
 */
public class Studente {

	private String nomeS;
	private String cognomeS;
	private String matricolaS;
	private String emailS;
	private String password;
	private GregorianCalendar dataNascita;
	private String cellulare;

	/**
	 * Metodo che restituisce il nome dello studente
	 * @return nome dello studente
	 */
	public String getNomeS() {
		return nomeS;
	}
	/**
	 * Metodo che modifica il nome dello studente
	 * @param nomeS - nome dello studente
	 */
	public void setNomeS(String nomeS) {
		this.nomeS = nomeS;
	}
	/**
	 * Metodo che restituisce il cognome dello studente
	 * @return cognome dello studente
	 */
	public String getCognomeS() {
		return cognomeS;
	}
	/**
	 * Metodo che modifica il cognome dello studente
	 * @param cognomeS - cognome dello studente
	 */
	public void setCognomeS(String cognomeS) {
		this.cognomeS = cognomeS;
	}
	/**
	 * Metodo che restituisce la matricola dello studente
	 * @return matricola dello studente
	 */
	public String getMatricolaS() {
		return matricolaS;
	}
	/**
	 * Metodo che modifica la matricola dello studente
	 * @param matricolaS - matricola dello studente
	 */
	public void setMatricolaS(String matricolaS) {
		this.matricolaS = matricolaS;
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
	 * Metodo che restituisce la password dello studente
	 * @return password dello studente
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Metodo che modifica la password dello studente
	 * @param password - password dello studente
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * Metodo che restituisce la data di nascita dello studente
	 * @return data di nascita dello studente
	 */
	public GregorianCalendar getDataNascita() {
		return dataNascita;
	}
	/**
	 * Metodo che modifica la data di nascita dello studente
	 * @param dataNascita - data di nascita dello studente
	 */
	public void setDataNascita(GregorianCalendar dataNascita) {
		this.dataNascita = dataNascita;
	}
	/**
	 * Metodo che restituisce il numero di cellulare dello studente
	 * @return numero di cellulare dello studente
	 */
	public String getCellulare() {
		return cellulare;
	}
	/**
	 * Metodo che modifica il numero di cellulare dello studente
	 * @param cellulare - numero di cellulare
	 */
	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
	}
}
