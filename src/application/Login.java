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

import storage.LoginDao;

public class Login extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		String user= request.getParameter("email");
		String password = request.getParameter("password");
		
		LoginDao registrato = new LoginDao();
		
		try{
			int i = registrato.doLogin(user, password);
			System.out.println(i);
			if(i==1){
				HttpSession session = request.getSession();
				session.setAttribute("email", user);
				RequestDispatcher dashboardUfficioStage = request.getRequestDispatcher("DashboardUfficioStage.html");
				dashboardUfficioStage.forward(request, response);
			
			}
			else if(i==2){
				HttpSession session = request.getSession();
				session.setAttribute("email", user);
				RequestDispatcher dashboardTutor = request.getRequestDispatcher("DashboardTutor.html");
				dashboardTutor.forward(request, response);
			}
			else if(i==3){
				HttpSession session = request.getSession();
				session.setAttribute("email", user);
				RequestDispatcher dashboardAzienda = request.getRequestDispatcher("DashboardAzienda.html");
				dashboardAzienda.forward(request, response);
			}
			else if(i==4){
				HttpSession session = request.getSession();
				session.setAttribute("email", user);
				RequestDispatcher dashboardStudente = request.getRequestDispatcher("DashboardStudente.html");
				dashboardStudente.forward(request, response);
			}else{
				RequestDispatcher login = request.getRequestDispatcher("accedi.jsp");
				login.forward(request, response);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
	}
}
