package com.Inheritance;

public class Accessmethods extends Base
{
	public void test3()
	{
		System.out.println("test3 executed successfully");
	}
	
	public static void main(String[] args)
	{
		Accessmethods a = new Accessmethods();
		a.test3();
		a.Addition();
		a.Subtraction();
		a.Division();
		
	}
	
}
