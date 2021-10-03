package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.api.server.HttpEndpoint;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Login() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("index.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PrintWriter printWriter = response.getWriter();
		final String USER = request.getParameter("user");
		final String PASSWORD = request.getParameter("password");
		
		// some check-method
		
		//Values for the JSP as attributes collected
		
		//printWriter.append("Hello "+USER+",\nyour password is \""+PASSWORD+"\"");
		
		request.setAttribute("user", USER);
		request.setAttribute("password", PASSWORD);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("welcome.jsp");
		requestDispatcher.forward(request, response);
		 

	}

}
