package in.lifelink.dbutil;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class DBListener implements ServletContextListener{
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc=sce.getServletContext();
		String url=sc.getInitParameter("url");
		String username=sc.getInitParameter("username");
		String pass=sc.getInitParameter("password");
		DBConnection.openConnection(url,username,pass);
		
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		DBConnection.closeConnection();
	}

}
