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
	
	
	@Test public void  testAddOld() {
		
		assertEquals(3.14, calculator.add(3.14, 0), 0);
		assertEquals(4, calculator.add(1, 3), 0);

	}
	
	@Test public void  testMultiplyOld() {
		
		assertEquals(8, calculator.mul(2, 4), 0);

	}
	
	@Test public void  testDivideOld() {
		
		assertEquals(2, calculator.div(4, 2), 0);

	}
	

	@Test public void testSingleAdd() {
		calculator.operand1(3);
		calculator.operator('+');
		calculator.operand2(1.5);
		
		assertEquals(4.5, calculator.equals(), 0.00001);
	}

	@Test public void testMultipleAdd() {
		calculator.operand1(3);
		calculator.operator('+');
		calculator.operand2(1.5);
		calculator.operator('+');
		calculator.operand2(2);
		
		assertEquals(6.5, calculator.equals(), 0.00001);
	}
	
	@Test public void testSinglemul() {
		calculator.operand1(3);
		calculator.operator('*');
		calculator.operand2(1.5);
		
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
