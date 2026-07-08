package in.kce.main;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("uname");
		String password=request.getParameter("pass");
		if(username.equalsIgnoreCase("shibi@kce.ac.in")) {
			RequestDispatcher rd=request.getRequestDispatcher("Admin.jsp");
			rd.forward(request,response);
		}
		else {
			HttpSession session=request.getSession();
			String splitted[]=username.split("@");
			session.setAttribute("username", splitted[0]);
			RequestDispatcher rd=request.getRequestDispatcher("User.jsp");
			rd.forward(request,response);
		}
		
	}   }
//HttpSession session=request.getSession();
//session.setAttribute("username", splitted[0]);