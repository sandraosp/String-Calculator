package is.ru.stringcalculator;


// 1. CreateaStringcalculatorwithamethodintAdd(stringnumbers) 
	//   i. The method can take 0, 1, or 2 numbers and will return their sum.
	//  ii. An empty string will return 0.
	// iii. Example inputs: “”, “1”, or “1,2”
	//  iv. Start with the simplest test case of an empty string. Then 1 number. Then 2 numbers.
	//   v. Remember to solve things as simply as possible, forcing yourself to write tests for things you didn’t think about.
	//  vi. Remember to refactor after each passing test.

public class Calculator 
{

	public static int add(String numbers)
	{
		String newline = System.getProperty("line.separator");

		if(numbers.equals(""))
		{
			return 0;
		}

		else if(numbers.contains("//"))
		{
			String delimiter = numbers.substring(numbers.indexOf("//") + 2, numbers.indexOf(newline));

			return sum(splitNumbers(numbers, delimiter), delimiter);
		}
		
		else if(numbers.contains(",") || numbers.contains(newline))
		{
			return sum(splitNumbers(numbers, null), null);
		}
		
		else if(numbers.contains(",\n") || numbers.contains("\n,")) //Can not be both seperators at once
		{
			return 0;
		}

		else
			return toInt(numbers);
	}

	private static int toInt(String number)
	{
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers, String delimiter)
	{
		String newString[] = new String[0];
		String newline = System.getProperty("line.separator");

		if(delimiter != null)
		{
			newString = numbers.substring(numbers.indexOf(newline) + 1, numbers.length()).split(delimiter);
		}
		else
			newString = numbers.split(",|\n");

		return newString;
	}
      
    private static int sum(String[] numbers, String delimiter)
    {
 	    int total = 0;
 	    String negatives = "";

        for(String number : numbers)
        {
        	if (toInt(number) < 0)
			{
				if(negatives != "")
				{
					negatives = negatives + "," + number;
				}
				
				else
					negatives += number;

			} 

			else if((toInt(number) < 1001) && (toInt(number) >= 0))
			{
				total += toInt(number);
			}

		}

		if(negatives != "")
		{
			throw new IllegalArgumentException(negatives);
		}

		else if(delimiter != null)
		{
			System.out.println(total + " (the delimiter is " + delimiter + ")");
		}
		
		return total;
    }

}