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
/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PreparedStatement prep = null;
		PreparedStatement prep1 = null;
		PreparedStatement prep2 = null;
		Connection conn = null;
		String user = request.getParameter("email");
		String password = request.getParameter("password");
		String nomeStudente = "SELECT Nome , Cognome, notifica FROM Studente WHERE Studente.Email=?";
		String nomeAzienda = "SELECT Nome FROM Azienda WHERE Azienda.Email=?";
		String nomeTutor = "SELECT Nome, Cognome FROM Tutor WHERE Tutor.Email=?";
		String n = null;
		String c = null;
		String azienda = null;
		String tutorN = null;
		String tutorC = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		LoginDao registrato = new LoginDao();

		try {
			conn = DriverManagerConnectionPool.getConnection();
			prep = conn.prepareStatement(nomeStudente);
			prep.setString(1, user);

			prep1 = conn.prepareStatement(nomeAzienda);
			prep1.setString(1, user);

			prep2 = conn.prepareStatement(nomeTutor);
			prep2.setString(1, user);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {
			rs = prep.executeQuery();
			rs.next();

			rs1 = prep1.executeQuery();
			rs1.next();

			rs2 = prep2.executeQuery();
			rs2.next();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			int i = registrato.doLogin(user, password);
			//System.out.println(i);

			if (i == 1) {
				HttpSession session = request.getSession();
				session.setAttribute("email", user);
				RequestDispatcher dashboardUfficioStage = request.getRequestDispatcher("DashboardStage.jsp");
				dashboardUfficioStage.forward(request, response);

			} else if (i == 2) {
				tutorN = rs2.getString("Nome");
				tutorC = rs2.getString("Cognome");
				HttpSession session = request.getSession();
				session.setAttribute("email", user);
				session.setAttribute("Nome", tutorN);
				session.setAttribute("Cognome", tutorC);
				RequestDispatcher dashboardTutor = request.getRequestDispatcher("DashboardTutor.jsp");
				dashboardTutor.forward(request, response);
			} else if (i == 3) {
				azienda = rs1.getString("Nome");
				HttpSession session = request.getSession();
				session.setAttribute("email", user);
				session.setAttribute("Nome", azienda);
				RequestDispatcher dashboardAzienda = request.getRequestDispatcher("DashboardAzienda.jsp");
				dashboardAzienda.forward(request, response);
			} else if (i == 4) {
				n = rs.getString("Nome");
				c = rs.getString("Cognome");
				String not = rs.getString("notifica");
				HttpSession session = request.getSession();
				session.setAttribute("email", user);
				session.setAttribute("Nome", n);
				session.setAttribute("Cognome", c);
				request.setAttribute("notifica", not);
				RequestDispatcher dashboardStudente = request.getRequestDispatcher("DashboardStudente.jsp");
				dashboardStudente.forward(request, response);
				//System.out.println(n + " " + c);
			} else {
				RequestDispatcher login = request.getRequestDispatcher("accedi.jsp");
				request.setAttribute("ErroreLogin", "Username e/o password non corretti");
				login.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
