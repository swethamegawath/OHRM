package javaProgram;

public class PrintOutNumbersInReverseOrderInTriangleFormat {

	public static void main(String[] args) {
		/*Print Out the numbers in reverse in triangle format
		 * ouput is 
		 * 4 4 4 4 4
		 * 3 3 3 3
		 * 2 2 2
		 * 1 1
		 * 0
		 */
		
		for(int i=3;i>=0;i--)
		{
			for (int j=0;j<=i;j++)
			{
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}

}
