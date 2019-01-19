package javaProgram;

public class PrintOutNumbersInTriangleFormat {

	public static void main(String[] args) {
		
		/*Print numbers in triangle format
		 * 0
		 * 1 1
		 * 2 2 2
		 * 3 3 3 3
		 * 4 4 4 4 4
		 */
		
		for(int i=0;i<=4;i++)
		{
			for(int j=0;j<=i;j++)
			{
				System.out.print(i+" ");
			}
			System.out.println();
		}

	}

}
