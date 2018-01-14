package storage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Richiesta {
	
	private String IdR;
	private String statoR;
	private static int counter = initialize();
	
	public Richiesta(){
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
	public String getStatoR() {
		return statoR;
	}
	public void setStatoR(String statoR) {
		this.statoR = statoR;
	}
	
	private static int initialize(){
		int cont=0;
		Scanner in=null;
		FileReader reader = null;
		if(counter==0){
			try{
				reader = new FileReader("Contatore");
				in = new Scanner(reader);
				String c=in.nextLine();
				
				cont = Integer.parseInt(c);
			}catch(FileNotFoundException e){
				e.printStackTrace();
			}finally{
				if(in!=null){
					in.close();
				}
			}
		}
		return cont;
	}
	
	private void increaseCounter() throws FileNotFoundException{
		counter++;
		PrintWriter scrivi= new PrintWriter("Contatore");
		scrivi.println(counter);
		scrivi.close();
	}
	
	public static String getCounter(){
		return "R"+counter;
	}
	
	
}
