package initializer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Application Lifecycle Listener implementation class PruebaListener
 *
 */
public class PruebaListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public PruebaListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
        System.out.println("liiiiiiiiisten");
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(arg0.getServletContext());
    	InitSIU i=context.getBean(InitSIU.class);
    	System.out.println(" pre i.init LISTEEN" );
    	i.init();
    	System.out.println(" post i.init LISTEEN" );
    }
	
}
