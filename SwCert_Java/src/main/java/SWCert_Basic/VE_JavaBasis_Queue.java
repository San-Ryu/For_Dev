package SWCert_Basic;

import java.io.*;
import java.util.*;

public class VE_JavaBasis_Queue {
	public static void main(String args[]) throws Exception{
		Queue<Integer> q = new LinkedList<>();
		
		q.add(1);
		System.out.println(q.toString());
		q.add(2);
		q.add(3);
		System.out.println(q.toString());
		
		System.out.println(q.peek());
		System.out.println(q.toString());

		int tmp = q.poll();
		System.out.println(tmp);
		System.out.println(q.peek());
		System.out.println(q.toString());
		System.out.println();
		
		System.out.println("q is Empty?");
		q.poll();
		System.out.println(q.isEmpty());
		q.poll();
		System.out.println(q.isEmpty());
		System.out.println("q is Empty?");
		System.out.println();
		///////////////////////////////////////////////////////
		
		System.out.println("Element Revolving");
		q.add(1);
		q.add(2);
		q.add(3);
		System.out.println(q.toString());
		q.add(q.poll());
		System.out.println(q.toString());
		q.add(q.poll());
		System.out.println(q.toString());
		q.add(q.poll());
		System.out.println(q.toString());
		System.out.println("Element Revolving");
	}
}
