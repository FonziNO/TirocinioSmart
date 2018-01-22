package storage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

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
	
	public String getNomeA() {
		return nomeA;
	}

	public void setNomeA(String nomeA) {
		this.nomeA = nomeA;
	}

	public String getNomeT() {
		return nomeT;
	}

	public void setNomeT(String nomeT) {
		this.nomeT = nomeT;
	}

	public String getCognomeT() {
		return cognomeT;
	}

	public void setCognomeT(String cognomeT) {
		this.cognomeT = cognomeT;
	}

	private String emailU;

	
	public boolean getStatoT() {
		return statoT;
	}

	public void setStatoT(boolean statoT) {
		this.statoT = statoT;
	}

	public boolean getStatoU() {
		return statoU;
	}

	public void setStatoU(boolean statoU) {
		this.statoU = statoU;
	}

	public String getEmailU() {
		return emailU;
	}

	public void setEmailU(String emailU) {
		this.emailU = emailU;
	}

	public String getEmailS() {
		return emailS;
	}

	public void setEmailS(String emailS) {
		this.emailS = emailS;
	}

	public String getEmailA() {
		return emailA;
	}

	public void setEmailA(String emailA) {
		this.emailA = emailA;
	}

	private static int counter = initialize();

	public Richiesta() {
		try {
			increaseCounter();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getIdR() {
		return IdR;
	}

	public void setIdR(String idR) {
		IdR = idR;
	}

	public boolean getStatoR() {
		return statoR;
	}

	public void setStatoR(boolean statoR) {
		this.statoR = statoR;
	}

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

	private void increaseCounter() throws FileNotFoundException {
		counter++;
		PrintWriter scrivi = new PrintWriter("Contatore");
		scrivi.println(counter);
		scrivi.close();
	}

	public static String getCounter() {
		return "R" + counter;
	}

	public void setNomeS(String nomeS) {
		this.nomeS = nomeS;

	}

	public String getNomeS() {
		return nomeS;
	}

	public void setCognomeS(String cognomeS) {
		this.cognomeS = cognomeS;

	}
	public String getCognomeS() {
		return cognomeS;
	}

	public void setMatricolaS(String matricolaS) {
		this.matricolaS = matricolaS;
		
	}
	public String getMatricolaS() {
		return matricolaS;
	}

	public String getEmailT() {
		return emailT;
	}

	public void setEmailT(String emailT) {
		this.emailT = emailT;
	}


}
