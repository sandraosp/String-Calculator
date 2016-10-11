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
		if(numbers.equals(""))
		{
			return 0;
		}
		
		else if(numbers.contains(",") || numbers.contains("\n"))
		{
			return sum(splitNumbers(numbers));
		}
		
		else if(numbers.contains(",\n") || numbers.contains("\n,")) //Can not be both seperators at once
		{
			return null;
		}

		else
			return 1;
	}

	private static int toInt(String number)
	{
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers)
	{
		if(numbers.contains(","))
		{
			return numbers.split(",");
		}

		else if(numbersText.contains("\n"))
		{
			return numbers.split("\n");
		}
	    
	}
      
    private static int sum(String[] numbers)
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
				
				//break;
			} 

			else if(toInt(number) >= 0)
			{
				total += toInt(number);
			}

		}

		if(negatives != "")
		{
			throw new Exception("Negatives not allowed: " + negatives);
		}
		
		return total;
    }

}