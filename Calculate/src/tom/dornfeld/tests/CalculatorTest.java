package tom.dornfeld.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import tom.dornfeld.Calculator;

public class CalculatorTest {

	Calculator calculator;
	
	
	@Before public void setUp() {
		calculator = new Calculator();
	}
	
	
	@Test public void  testAdd() {
		assertEquals(0, calculator.add(0, 0), 0);
	}
	
}
