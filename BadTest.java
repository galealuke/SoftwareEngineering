import static org.junit.Assert.*;

import org.junit.Test;


public class BadTest {

	@Test
	public void additionTest(){
		Calculator calculator = new Calculator();
		assertEquals(4, calculator.add(2, 2));
		assertEquals(8, calculator.subtract(7, 2));
	}
}
