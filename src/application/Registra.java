package application;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		response.setContentType("text/html");

		try {
			String email = request.getParameter("Email");
			String nome = request.getParameter("Nome");
			String cognome = request.getParameter("Cognome");
			String  matricola =request.getParameter("Matricola");
			String password= request.getParameter("Password");
			String datanascita = request.getParameter("DataNascita");
			String cellulare = request.getParameter("Cellulare");

			HttpSession session = request.getSession();

			String id= session.getId();
			session.setAttribute("id", id);
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
			java.util.Date data = format.parse(datanascita);
			stud.setDataNascita(data);
			stud.setCellulare(cellulare);
			session.setAttribute("Studente", stud);

			// verifico se i dati immessi sono confermati dal client
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}


