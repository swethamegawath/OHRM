package javaProgram;

public class NestedCondition {

	public static void main(String[] args)
	{
		int intVar1=10;
		int intVar2=50;
		int intVar3=40;
		
		if (intVar1>intVar2 & intVar1>intVar3) 
		{
			System.out.println("intVar1 is greater");
		}
		else if (intVar2>intVar3)
		{
			System.out.println("intVar2 is greater");
		} 
		else
		{	
			System.out.println("intVar3 is greater");
	}

}
}
