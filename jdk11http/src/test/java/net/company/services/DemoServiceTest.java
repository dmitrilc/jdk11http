package net.company.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import net.company.pojos.CatFact;

/**
 * Test class for the {@code DemoService} class
 * @author dmitrilc
 *
 */
public class DemoServiceTest {
	
	private final DemoService service = new DemoService();
	
	/**
	 * Tests the randomCatFact method.
	 * @throws IOException if an error occured while sending the request
	 * @throws InterruptedException if an illegal parameter was passed to theinternal HttpRequest builder.
	 */
	@Test
	public void getRandomCatFactTest() throws IOException, InterruptedException {
		int maxLength = 40;
		
		CatFact fact = this.service.getRandomCatFact(maxLength);
		
		assertNotNull(fact.getFact()); //assert that the fact must not be empty
		assertTrue(fact.getLength() <= maxLength); //assert that the length cannot be longer than maxLength
	}
}
