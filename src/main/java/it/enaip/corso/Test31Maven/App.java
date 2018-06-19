package it.enaip.corso.Test31Maven;

import org.apache.log4j.Logger;

import it.enaip.corso.Test31Maven.dto.Employee;
import it.enaip.corso.Test31Maven.service.HrService;

/**
 * Hello world!
 *
 */
public class App {
	
	private static Logger logger = Logger.getLogger(App.class);
	
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
    	String user = "Michele";
    	logger.info("Ho registrato l'utente: " + user);
    	
    	HrService hr = HrService.getInstance();
    	Employee emp = hr.getEmployee(135);
    	System.out.println(emp);
    	logger.info("Ho estratto employee: " + emp.toString());
    	
    }
}
