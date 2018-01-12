package application;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import storage.RegistratiDao;
import storage.Studente;


public class Registra extends HttpServlet
{	
	RegistratiDao registra = new RegistratiDao(); // creo un costruttore
	int res=0;
	private static final long serialVersionUID = 1L;


	public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 


		response.setContentType("text/html");


		String email = (String)request.getParameter("email");
		String nome = (String)request.getParameter("nome");
		String cognome = (String)request.getParameter("cognome");
		String  matricola = (String)request.getParameter("matricola");
		String password = (String)request.getParameter("password");
		String datanascita = (String)request.getParameter("datanascita");
		String cellulare = (String)request.getParameter("cellulare");
		
		System.out.println(email + nome + cognome + matricola + password + datanascita + cellulare);
		
		HttpSession session = request.getSession();

		
		session.setAttribute("email", email);
		session.setAttribute("nome", nome);
		session.setAttribute("cognome", cognome);
		session.setAttribute("matricola", matricola);
		session.setAttribute("password", password);
		session.setAttribute("datanascita", datanascita);
		session.setAttribute("cellulare", cellulare);

		//Aggiorno i dati dello studente
		Studente stud = new Studente();
		stud.setEmailS(email);
		stud.setNomeS(nome);
		stud.setCognomeS(cognome);
		stud.setMatricolaS(matricola);
		stud.setPassword(password);
		GregorianCalendar data = new GregorianCalendar();
		try{
			data.setTime(sdf.parse(datanascita));
		}catch(ParseException e){
			e.printStackTrace();
		}
		stud.setDataNascita(data);
		stud.setCellulare(cellulare);
		session.setAttribute("Studente", stud);
		
		// verifico se i dati immessi sono confermati dal client
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

	}
}