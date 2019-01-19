package javaProgram;

public class IfelseCondition {

	public static void main(String[] args) {
		
		//int a=10;   //Declaration of variable a and assigning value
		int a=10;
		int b=20;	//Declaration of variable b and assigning value
		
		//check which variable is greater
		
		if (a>b) 
		{
			System.out.println("a is greater");
			
		}
		else
		{
			System.out.println("b is greater");
		}
		
		String x="hello";
		String y=" hello";
		
		if (x.equals(y))
		{
			System.out.println("Both Strings are equal");
		}
		else
		{
			System.out.println("Both Strings are not equal");
		}
		
		String p="hello";
		String q="ello";
		
		if (p.contains(q)) 
		
		{
			System.out.println("ello exists in hello");
		}
		else
		{
			System.out.println("ello is not existing in hello");
		}
			
			
		
	}

}
