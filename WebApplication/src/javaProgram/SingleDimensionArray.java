package javaProgram;

public class SingleDimensionArray {

	public static void main(String[] args) {
		
		/*Array index will start always with 0
		 * Array can store only one datatype value
		 * once the size of array is declared them we cannot change the size of an array
		 * if the value is not stored in an array index then it will save with the defau;t value0  
		 */
		
		
		
		/*Syntax of array
		datatype arrayname[] = new datatype[];
		datatype[] arrayname = new datatype[];*/
		
		int i[]=new int[3];
		
		i[0]=10;
		i[1]=20;
		i[2]=30;
		
		//System.out.println(i[0]);
		for(int j=0;j<i.length;j++)
		{
			System.out.println(i[j]);
		}

	}

}
