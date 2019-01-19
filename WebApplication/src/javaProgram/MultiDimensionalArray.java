package javaProgram;

public class MultiDimensionalArray {

	public static void main(String[] args) {

		String a[][] = new String[2][2];
		
		a[0][0]="Selenium";
		a[0][1]="Testing";
		a[1][0]="QTP/UFT";
		a[1][1]="Testing";
		
		
		for(int i=0;i<a.length;i++)
		 {
			for(int j=0;j<a.length;j++)
			{
				System.out.print(a[i][j]+" ");
			}
			System.out.println();			
		 }
		

	}

}
