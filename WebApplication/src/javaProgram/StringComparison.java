package javaProgram;

public class StringComparison {

	public static void main(String[] args)
	{
		String strVar1="hello";
		String strVar2="Hello";
		
		//if (strVar1.equals(strVar2)) 
		
		if (strVar1.equalsIgnoreCase(strVar2))
		{
			System.out.println("Both strings are same");
			
		}else {
			System.out.println("Both strings are not same ");
		}

	}

}
