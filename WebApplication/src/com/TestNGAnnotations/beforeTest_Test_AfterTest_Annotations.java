package com.TestNGAnnotations;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class beforeTest_Test_AfterTest_Annotations {
	
	public class Annotations
	{
		@BeforeTest 
		public void login() {
			System.out.println("gmail login functionality test");
		}
		
		@Test (priority=0)
		public void inbox()
		{
			System.out.println("gmail inbox functionality test");
		}
		
		@Test (priority=1)
		public void Composemail()
		{
			System.out.println("gmail composemail functionality test");
		}
		
		@AfterTest
		public void drafts()
		{
			System.out.println("gmail drafts functionality test");
		}
		
	}

}
