package abstraction;

import org.junit.Test;

public class Customer
{
	@Test
	public void calcOperations()
	{
		CalculatorImpl calc = new CalculatorImpl();
		int sum = calc.addition(34, 23);
		System.out.println("Sum :" + sum);
		calc.sendMail();
		calc.deleteMail();
		//WebDriver driver = new ChromeDriver();
		Calculator calc2 = new CalculatorImpl();
		calc2.addition(553, 234);	
		int[] myarr = {45,23,7,23,13,78};
		int avg = calc2.average(myarr);
		System.out.println("Average :" + avg);
	}

}
