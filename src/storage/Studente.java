package storage;

import java.util.Date;
import java.util.GregorianCalendar;

public class Studente {
	
	private String nomeS;
	private String cognomeS;
	private String matricolaS;
	private String emailS;
	private String password;
	private GregorianCalendar dataNascita;
	private String cellulare;
	
	
	public String getNomeS() {
		return nomeS;
	}
	public void setNomeS(String nomeS) {
		this.nomeS = nomeS;
	}
	public String getCognomeS() {
		return cognomeS;
	}
	public void setCognomeS(String cognomeS) {
		this.cognomeS = cognomeS;
	}
	public String getMatricolaS() {
		return matricolaS;
	}
	public void setMatricolaS(String matricolaS) {
		this.matricolaS = matricolaS;
	}
	public String getEmailS() {
		return emailS;
	}
	public void setEmailS(String emailS) {
		this.emailS = emailS;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public GregorianCalendar getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(GregorianCalendar dataNascita) {
		this.dataNascita = dataNascita;
	}
	public String getCellulare() {
		return cellulare;
	}
	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
	}
	
	
	
	
}
