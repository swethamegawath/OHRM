package javaProgram;

public class MethodExample1 {

	public void Method1()
	{
		System.out.println("Method1 is executed successfully");
	}
	
	public void Method2()
	{
		System.out.println("Method2 is executed successfully");
	}
	
	public static void main(String[] args) {
		
		MethodExample1 ME= new MethodExample1();
		ME.Method1();
		ME.Method2();
	}

}
