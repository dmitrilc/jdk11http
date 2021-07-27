package net.company;

import java.io.IOException;

import net.company.controllers.DemoController;
import net.company.pojos.CatFact;

/**
 * The entry point to the application. Users must instantiate a DemoControler 
 * instance.
 * @author dmitrilc
 *
 */
public class App {
    public static void main(String[] args) throws IOException, InterruptedException {   	
    	var controller = new DemoController();
    	
    	CatFact catFact = controller.getRandomCatFact(40);
    	
    	System.out.println(catFact);
    }

}