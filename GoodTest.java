import static org.junit.Assert.*;

import org.junit.Test;

import calculator.Calculator;

public class GoodTest {

	@Test
public void additionTest(){
		Calculator calculator = new Calculator();
		assertEquals(4, calculator.add(2, 2));
		assertEquals(5, calculator.subtract(7, 2));
	}

}