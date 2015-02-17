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
 * Servlet implementation class AccountServlet
 */
@WebServlet("/signup")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountServlet() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("username") != null){
			//Already signed in
			RequestDispatcher dispatch = request.getRequestDispatcher("userhomeJSP.jsp");
			dispatch.forward(request, response);
			return;
		}
		if(request.getAttribute("errors") == null){
			//There are no errors
			request.setAttribute("title","Create New Account");
			request.setAttribute("message","Please enter proposed name and password.");
		}else{
			//There was an error logging in
			request.setAttribute("title","The Name " + request.getAttribute("name") + " Is Already In Use");
			request.setAttribute("message","Please enter another name and password.");
		}
		if(request.getAttribute("type") != null){
			//Validation errors
			request.setAttribute("title","Create New Account");
			request.setAttribute("message",request.getAttribute("type"));
		}
		RequestDispatcher dispatch = request.getRequestDispatcher("accountJSP.jsp");
		dispatch.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletContext sc = getServletContext();
		AccountManager am = (AccountManager)sc.getAttribute("accountManager");
		String username = (String)request.getParameter("username");
		String password = (String)request.getParameter("password");
		if(am.addUser(username,password)){
			//Username is not taken
			session.setAttribute("username",username);
			request.removeAttribute("errors");
			RequestDispatcher dispatch = request.getRequestDispatcher("userhomeJSP.jsp");
			dispatch.forward(request, response);
		}else{
			//Username is taken
			request.setAttribute("errors","Bad username password combo");
			request.setAttribute("name",username);
			if(username != null && username.trim().equals("")){
				request.setAttribute("type","Username and/or password can not be empty");
			}
			if(password != null && password.equals("")){
				request.setAttribute("type","Username and/or password can not be empty");
			}
			if(username == null || password == null){
				request.setAttribute("type","Username and/or password can not be empty");
			}
			doGet(request,response);
		}
	}

}
