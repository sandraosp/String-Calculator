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

    @Test
    public void testNewLineBetweenNumbers() //A new line can come in betewwn numbers in stead of a comma.
    {
    	assertEquals(6, Calculator.add("1\n2,3"));
    	assertEquals(6, Calculator.add("1,2\n3"));
    }

    @Test
    public void testNegativeNumbers()
    {
    	assertEquals(Exception, Calculator.add("-1,-2,-3"));
    	assertEquals(Exception, Calculator.add("-1,2"));
    	assertEquals(Exception, Calculator.add("2,-4,3,-5"));
    }

        @Test
    public void testBiggerNumbers() //Should ignore numbers bigger than 1000.
    {
    	assertEquals(2, Calculator.add("1001,2"));
    	assertEquals(0, Calculator.add("2000,1000"));
    	assertEquals(1, Calculator.add("1,5000"));
    }


}