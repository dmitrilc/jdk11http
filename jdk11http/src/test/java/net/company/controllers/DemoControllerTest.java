package net.company.controllers;

import java.io.IOException;

import org.junit.jupiter.api.Test;

/**
 * Test class for the DemoController
 * @author dmitrilc
 *
 */
public class DemoControllerTest {
	
	private final DemoController controller = new DemoController(); 
	
	/**
	 * Tests the randomCatFact method.
	 * @throws IOException if an error occured while sending the request
	 * @throws InterruptedException if an illegal parameter was passed to theinternal HttpRequest builder.
	 */
	@Test
	public void getRandomCatFactTest() throws IOException, InterruptedException {
		controller.getRandomCatFact(40);
	}
}
