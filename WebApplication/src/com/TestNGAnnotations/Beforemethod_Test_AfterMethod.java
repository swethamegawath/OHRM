package com.TestNGAnnotations;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Beforemethod_Test_AfterMethod 
{
	public class Annotation2
	{
		
		@BeforeMethod
		public void setup()
		{
			System.out.println("Application launched");
		}
		
		@Test(priority=0)
		public void login()
		{
			System.out.println("Gmail login functionality test");
		}
		
		@Test(priority=1)
		public void Composemail() 
		{
			System.out.println("gmail composemail functionality test");
		}
		
		@Test (enabled=false)
		public void spam()
		{
			System.out.println("gmail spam functionality test");
		}
		
		@AfterMethod
		public void drafts()
		{
			System.out.println("gmail drafts functionality test");
		}
	}
}
