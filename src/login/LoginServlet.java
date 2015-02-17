package login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet({"/","/login"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("username") != null){
			RequestDispatcher dispatch = request.getRequestDispatcher("userhomeJSP.jsp");
			dispatch.forward(request, response);
			return;
		}
		if(request.getAttribute("errors") == null){
			//There are no errors
			request.setAttribute("title","Welcome to Homework 5");
			request.setAttribute("message","Please log in.");
		}else{
			//There was an error logging in
			request.setAttribute("title","Please Try Again");
			request.setAttribute("message","Either your username or password is incorrect. Please try again.");
		}
		RequestDispatcher dispatch = request.getRequestDispatcher("loginJSP.jsp");
		dispatch.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("username") != null){
			//Already logged in, send to user page
		}
		ServletContext sc = getServletContext();
		AccountManager am = (AccountManager)sc.getAttribute("accountManager");
		String username = (String)request.getAttribute("username");
		String password = (String)request.getAttribute("password");
		if(am.checkCredentials(username,password)){
			session.setAttribute("username",username);
			request.removeAttribute("errors");
			//Correct username and password, send to user page
			RequestDispatcher dispatch = request.getRequestDispatcher("userhomeJSP.jsp");
			dispatch.forward(request, response);
		}else{
			request.setAttribute("errors","Bad username password combo");
			//Incorrect username and password
			doGet(request,response);
		}
	}

}
