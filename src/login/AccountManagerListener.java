package login;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class AccountManagerListener
 *
 */
@WebListener
public class AccountManagerListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public AccountManagerListener() {
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce) {
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce) {
        AccountManager am = new AccountManager();
        ServletContext sc = sce.getServletContext();
        sc.setAttribute("accountManager",am);
    }
	
}
