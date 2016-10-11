package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest 
{

	public static void main(String args[]) 
	{
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() //An empty string will return 0.
	{
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber()
	{
		assertEquals(1, Calculator.add("1"));
		assertEquals(2, Calculator.add("2"));
		assertEquals(3, Calculator.add("3"));
		assertEquals(4, Calculator.add("4"));
	}

	@Test
	public void testTwoNumbers() 
	{
		assertEquals(3, Calculator.add("1,2"));
		assertEquals(4, Calculator.add("2,2"));
		assertEquals(5, Calculator.add("2,3"));
	}	

	@Test
    public void testMultipleNumbers()
    {
    	assertEquals(6, Calculator.add("1,2,3"));
    	assertEquals(6, Calculator.add("2,2,2"));
    	assertEquals(4, Calculator.add("1,1,1,1"));
    	assertEquals(10, Calculator.add("1,2,3,4"));
    }

}