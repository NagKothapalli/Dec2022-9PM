package abstraction;
//class extends class  - A inherits B
//class implements interface   - A inherits B
public class CalculatorImpl implements Calculator // i2,i3,i4
{
	
 public void sendMail()
 {
	 
 }
 public void deleteMail()
 {
	 
 }
 public int addition(int a,int b)
 {
	 int sum = a+b;
	 return sum;
 }

@Override
public int subtraction(int a, int b) {
	int diff = a-b;
	 return diff;
}

@Override
public int multiplication(int a, int b) {
	int prod = a*b;
	 return prod;
}

@Override
public int division(int a, int b) {
	int div = a/b;
	 return div;
}
@Override
public int average(int[] arr) {
	int sum = 0;
	for(int i=0;i<arr.length;i++)
	{
		sum = sum + arr[i];
	}
	return (sum/arr.length);
}
}
