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
		

	@Test public void testSingleAdd() {
		calculator.operand(3);
		calculator.operator('+');
		calculator.operand(1.5);
		
		assertEquals(4.5, calculator.equals(), 0.00001);
	}

	@Test public void testMultipleAdd() {
		calculator.operand(3);
		calculator.operator('+');
		calculator.operand(1.5);
		calculator.operator('+');
		calculator.operand(2);
		
		assertEquals(6.5, calculator.equals(), 0.00001);
	}
	
	@Test public void testSinglemul() {
		calculator.operand(3);
		calculator.operator('*');
		calculator.operand(1.5);
		
		assertEquals(4.5, calculator.equals(), 0.00001);
	}
	
//	@Test public void testpunktvorstrich() {
//		calculator.operand1(2);
//		calculator.operator('+');
//		calculator.operand2(1.5);
//		calculator.operator('*');
//		calculator.operand2(3);
//
//		
//		assertEquals(6.5, calculator.equals(), 0.00001);
//	}

}
