package net.company;

import java.io.IOException;
import net.company.pojos.CatFact;
import net.company.services.DemoService;

/**
 * The entry point to the application. Users must instantiate a DemoControler 
 * instance.
 * @author dmitrilc
 *
 */
public class App {
    public static void main(String[] args) throws IOException, InterruptedException {   	   	
    	DemoService service = new DemoService();
    	
    	CatFact catFact = service.getRandomCatFact(40);
    	
    	System.out.println(catFact);
    }

}