package javaProgram;

public class ObjectArray {

	public static void main(String[] args) {
		//using object array we can overcome with declaration of single datatype value
		//Object datatype is used to store different datatype values
		
		Object a[] = new Object[3];
		
		a[0]=10;
		a[1]="Selenium";
		a[2]=10.123;
		
		for(int i=0;i<a.length;i++)
		{
			System.out.println(a[i]);
		}
		

	}

}
