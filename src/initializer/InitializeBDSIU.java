package initializer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Application Lifecycle Listener implementation class InitializeBDSIU
 *
 */
public class InitializeBDSIU implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public InitializeBDSIU() {
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
    	WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(arg0.getServletContext());
    	InitSIU i=context.getBean(InitSIU.class);
    	System.out.println(" pre i.init" );
    	//i.init();
    	System.out.println(" post i.init" );
    }
	
}
