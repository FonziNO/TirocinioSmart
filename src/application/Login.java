package application;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;

import storage.Azienda;
import storage.Studente;
import storage.Tutor;
import storage.UfficioStage;

@WebServlet("/Login")
public class Login extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	int i=0;
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		String user= request.getParameter()
		doGet(request,response);
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		boolean flag = false;
		
		Studente stud = new Studente();
		
		stud.setEmailS(request.getParameter("login"));
		stud.setPassword(request.getParameter("password"));
		
		Azienda azienda= new Azienda();
		
		azienda.setEmailA(request.getParameter("login"));
		azienda.setPasswordA(request.getParameter("password"));
		
		Tutor tutor=new Tutor();
		
		tutor.setEmailT(request.getParameter("login"));
		tutor.setPasswordT(request.getParameter("password"));
		
		UfficioStage ufficio = new UfficioStage();
		
		ufficio.setEmailU(request.getParameter("login"));
		ufficio.setPasswordU(request.getParameter("password"));
		
		try{
			DatabaseManager dbMan = new DatabaseManager();
			dbMan.connect();
			
			dbMan.loginuser(stud.getEmailS(), stud.getPassword());
			dbMan.loginuser(azienda.getEmailA(), azienda.getPasswordA());
			dbMan.loginuser(tutor.getEmailT(), tutor.getPasswordT());
			dbMan.loginuser(ufficio.getEmailU(), ufficio.getPasswordU());
			
			dbMan.disconnect();
			
			flag = true;
		}
		catch (MySQLSyntaxErrorException mysqlse){
			System.err.println("Errore n. " + mysqlse.getErrorCode() + ": " + mysqlse.getLocalizedMessage());
		}
		catch (SQLException sqle){
			System.err.println("Errore n. " + sqle.getErrorCode() + ": " + sqle.getLocalizedMessage());
		}
		catch (Exception e){
			System.err.println("Errore " + e.getClass().getSimpleName() + ": " + e.getLocalizedMessage());
			e.printStackTrace();
		}
		
		System.out.println("accesso riuscito: " + flag);
		
		if(flag){
			
			HttpSession session = request.getSession();
			System.out.println("email" +stud.getEmailS());
			session.setAttribute("login", stud.getEmailS());
			System.out.println("studente: " +(String) session.getAttribute("login"));
			//session.setAttribute("password", stud.getPassword());
			session.setAttribute("log", "ok");
			
			System.out.println("email" +azienda.getEmailA());
			session.setAttribute("login", azienda.getEmailA());
			System.out.println("azienda: " +(String) session.getAttribute("login"));
			//session.setAttribute("password", azienda.getPasswordA());
			session.setAttribute("log", "ok");
			
			System.out.println("email" +tutor.getEmailT());
			session.setAttribute("login", tutor.getPasswordT());
			System.out.println("azienda: " +(String) session.getAttribute("login"));
			//session.setAttribute("password", tutor.getPasswordT());
			session.setAttribute("log", "ok");
			
			System.out.println("email" +ufficio.getEmailU());
			session.setAttribute("login", ufficio.getPasswordU());
			System.out.println("azienda: " +(String) session.getAttribute("login"));
			//session.setAttribute("password", ufficio.getPasswordU());
			session.setAttribute("log", "ok");
		}
		
		RequestDispatcher view = request.getRequestDispatcher("ind.html");
		view.forward(request, response);
	}

}
