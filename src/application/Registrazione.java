package application;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;

import storage.DatabaseManager;


/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registrazione")
public class Registrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registrazione() {
        super();
     
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email, nome, cognome, matricola, password, dataNascita, cellulare;
		
		System.out.println(request.getParameter("email"));
		email = (String)request.getParameter("email");
		System.out.println(email);
		
		System.out.println(request.getParameter("nome"));
		nome = (String) request.getParameter("nome");
		System.out.println(nome);
		
		System.out.println(request.getParameter("cognome"));
		cognome = (String) request.getParameter("cognome");
		System.out.println(cognome);
		
		System.out.println(request.getParameter("matricola"));
		matricola = (String) request.getParameter("matricola");
		System.out.println(matricola);
		
		System.out.println(request.getParameter("password"));
		password = (String) request.getParameter("password");
		System.out.println(password);
		
		System.out.println(request.getParameter("dataNascita"));
		dataNascita = (String) request.getParameter("dataNascita");
		System.out.println(dataNascita);
		
		System.out.println(request.getParameter("cellulare"));
		cellulare = (String) request.getParameter("cellulare");
		System.out.println(cellulare);
		
		//Blocco try
		try {
			DatabaseManager dbMan = new DatabaseManager();
			dbMan.connect();
			
			synchronized (dbMan)
			   {
				//istruzioni al db in "scrittura"
				dbMan.registeruser(email, nome, cognome, matricola, password, dataNascita, cellulare);
			}
			dbMan.disconnect();
			

		}
		
		catch (MySQLSyntaxErrorException mysqlse){
			System.err.println("Errore n. " + mysqlse.getErrorCode() + ": " + mysqlse.getLocalizedMessage());
		}
		catch (SQLException sqle) {
			System.err.println("Errore n. " + sqle.getErrorCode() + ": " + sqle.getLocalizedMessage());
			
		}
		
		catch (Exception e){
			System.err.println("Errore " + e.getClass().getSimpleName() + ": " + e.getLocalizedMessage());
			e.printStackTrace();
		}

		RequestDispatcher view = request.getRequestDispatcher("ind.html");
		view.forward(request, response);
	}
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

