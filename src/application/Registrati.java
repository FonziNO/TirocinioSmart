package application;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import storage.RegistratiDao;
import storage.Studente;

/**
 * Servlet implementation class Registrati
 */
public class Registrati extends HttpServlet {
	RegistratiDao registra = new RegistratiDao(); // creo un costruttore
	int res=0;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Registrati() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// o con i beans o attraverso la sessione o la request ( a secondo dell'occorrenza).
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			response.setContentType("text/html");
			HttpSession session = request.getSession();

			String email = (String) request.getAttribute("Email");
			String nome = (String) request.getAttribute("Nome");
			String cognome = (String) request.getAttribute("Cognome");
			String  matricola = (String) request.getAttribute("Matricola");
			String password= (String) request.getAttribute("Password");
			String datanascita = (String) request.getAttribute("DataNascita");
			Date data = (Date) format.parse(datanascita);
			String cellulare = (String) request.getAttribute("Cellulare");

			// Qui i dati saranno gia integri, percio devo solo salvarmi sul database ( in quanto ho fatto gia il controllo con javascript)

			res=registra.salva(email,  nome, cognome, matricola, password, data, cellulare);

			RequestDispatcher view = request.getRequestDispatcher("index.jsp");
			view.forward(request, response);

		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
