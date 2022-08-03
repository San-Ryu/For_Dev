package SWCert_InClass_ExampleCode09_Library;

import java.util.*;

public class StackDemo {
	public static void main(String args[]) 
	{
		int[] arr = new int[]{1, 2, 3, 4, 5};		
		
		Stack<Integer> stack = new Stack<Integer>();

		for(int val: arr)
			stack.push(val);
		
		while(!stack.isEmpty())		 
			System.out.println(stack.pop());
	}
}
