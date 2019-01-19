package javaProgram;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

	public static void main(String[] args) {
		
		/*ArrayList is used to overcome with declaration of an array
		 * Syntax:
		 * List<Datatype> ArrayName= new ArrayList<>();
		 */
		
		
		List<String> a = new ArrayList <>();
		a.add("Selenium");
		a.add("Testing");
		a.add("Tools");
		
		
		for(int i=0;i<a.size();i++)
		{
			System.out.println(a.get(i));
		}
		

	}

}
