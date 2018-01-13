package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import storage.DriverManagerConnectionPool;
import storage.LoginDao;
import storage.RegistratiDao;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PreparedStatement prep = null;
		Connection conn = null;
		String user = request.getParameter("email");
		String password = request.getParameter("password");
		String nomeStudente = "SELECT Nome , Cognome FROM Studente WHERE Email=?";
		String n = null;
		String c = null;
		ResultSet rs = null;
		LoginDao registrato = new LoginDao();
		
		try {
			conn = DriverManagerConnectionPool.getConnection();
			prep = conn.prepareStatement(nomeStudente);
			prep.setString(1, user);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			rs = prep.executeQuery();
			rs.next();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			int i = registrato.doLogin(user, password);
			System.out.println(i);
			n = rs.getString("Nome");
			c = rs.getString("Cognome");
			if (i == 1) {
				HttpSession session = request.getSession();
				session.setAttribute("email", user);
				RequestDispatcher dashboardUfficioStage = request.getRequestDispatcher("DashboardStage.jsp");
				dashboardUfficioStage.forward(request, response);

			} else if (i == 2) {
				HttpSession session = request.getSession();
				session.setAttribute("email", user);
				RequestDispatcher dashboardTutor = request.getRequestDispatcher("DashboardTutor.jsp");
				dashboardTutor.forward(request, response);
			} else if (i == 3) {
				HttpSession session = request.getSession();
				session.setAttribute("email", user);
				RequestDispatcher dashboardAzienda = request.getRequestDispatcher("DashboardAzienda.jsp");
				dashboardAzienda.forward(request, response);
			} else if (i == 4) {
				HttpSession session = request.getSession();
				session.setAttribute("email", user);
				session.setAttribute("Nome", n);
				session.setAttribute("Cognome", c);
				RequestDispatcher dashboardStudente = request.getRequestDispatcher("DashboardStudente.jsp");
				dashboardStudente.forward(request, response);
				System.out.println(n + " " + c);
			} else {
				RequestDispatcher login = request.getRequestDispatcher("accedi.jsp");
				login.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
