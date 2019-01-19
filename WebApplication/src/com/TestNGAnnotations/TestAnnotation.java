package com.TestNGAnnotations;

import org.testng.annotations.Test;

public class TestAnnotation 
{
	public class Annotations1
	{
		
		@Test (priority=0)
		public void login()
		{
			System.out.println("Gmail login functionality Test");
		}
		
		@Test (priority=2)
		public void Composemail()
		{
			System.out.println("gmail composemail functionality test");
		}
		
		@Test (priority=3)
		public void drafts()
		{
			System.out.println("gmail draft functionality test");
		}
		
		@Test (enabled=false)
		public void inbox()
		{
			System.out.println("gmail inbox functionality test");
		}
	}
}
