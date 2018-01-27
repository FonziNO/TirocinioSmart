package application;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import storage.RegistratiDao;
import storage.Studente;

/**
 * Servlet implementation class Registra
 */
public class Registra extends HttpServlet {
	RegistratiDao rdao = new RegistratiDao();
	int res = 0;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		try {
			SimpleDateFormat sdfjava = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat sdfsql = new SimpleDateFormat("yyyy-MM-dd");

			response.setContentType("text/html");

			String email = (String) request.getParameter("email");
			String nome = (String) request.getParameter("nome");
			String cognome = (String) request.getParameter("cognome");
			String matricola = (String) request.getParameter("matricola");
			String password = (String) request.getParameter("password");
			String datanascita = (String) request.getParameter("datanascita");
			String cellulare = (String) request.getParameter("cellulare");

			datanascita = sdfsql.format(sdfjava.parse(datanascita));
			/*System.out.println("Sono in Registra.java");
			System.out.println(email + " " + nome + " " + cognome + " " + matricola + " " + password + " " + datanascita
					+ " " + cellulare);*/

			res = rdao.salva(email, nome, cognome, matricola, password, datanascita, cellulare);

			HttpSession session = request.getSession();

			session.setAttribute("email", email);
			session.setAttribute("nome", nome);
			session.setAttribute("cognome", cognome);
			session.setAttribute("matricola", matricola);
			session.setAttribute("password", password);
			session.setAttribute("datanascita", datanascita);
			session.setAttribute("cellulare", cellulare);

			// Aggiorno i dati dello studente
			Studente stud = new Studente();
			stud.setEmailS(email);
			stud.setNomeS(nome);
			stud.setCognomeS(cognome);
			stud.setMatricolaS(matricola);
			stud.setPassword(password);
			GregorianCalendar dataN = new GregorianCalendar();
			try {
				dataN.setTime(sdfsql.parse(datanascita));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			stud.setDataNascita(dataN);
			stud.setCellulare(cellulare);
			session.setAttribute("Studente", stud);

			// verifico se i dati immessi sono confermati dal client
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

		} catch (Exception e1) {

			RequestDispatcher view = request.getRequestDispatcher("/registrati.jsp");
			request.setAttribute("ErroreRegistrazione", "Email già esistente!");
			view.forward(request, response);
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("registrati.jsp");
		view.forward(request, response);
	}

}
