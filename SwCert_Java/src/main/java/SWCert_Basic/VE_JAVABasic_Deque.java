/*

 */
package SWCert_Basic;

import java.io.*;
import java.util.*;

public class VE_JAVABasic_Deque {
	static ArrayDeque<Integer> dq;
	static ArrayDeque<Integer> dq2;
	static Deque<LinkedList> dq3;
	static int a[];
	
	public static void main(String args[]) throws Exception{
		dq = new ArrayDeque<>();
		dq2 = new ArrayDeque<>();
		dq3 = new ArrayDeque<>();
		
		dq.add(10);
		dq.add(20);
		dq.add(10);
		dq.add(30);
		dq.add(40);
		dq.add(10);
		dq.add(50);
		dq.add(10);
		System.out.println(dq.toString());
		System.out.println();
		
		int tmp = dq.pop();
		System.out.println(tmp);
		System.out.println(dq.toString());
		System.out.println();
		
		tmp = dq.peek();
		dq.add(2);
		System.out.println(dq.toString());
		System.out.println();
		
		dq.push(1);
		dq.add(2);
		System.out.println(dq.toString());
		System.out.println();
		
		System.out.println(dq2.toString());
		dq2 = dq.clone();
		System.out.println(dq2.toString());
		System.out.println();
		
		dq2.pollFirst();
		System.out.println(dq2.toString());
		System.out.println();
		
		tmp = dq.element();
		System.out.println(tmp);
		System.out.println(dq.toString());
	}	//	End Main Method
}	//	End Class