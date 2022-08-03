package SWCert_Basic;

import java.io.*;
import java.util.*;

public class VE_JavaBasis_ArrayList {
	public static void main(String args[])	throws Exception{
		ArrayList<Integer> Numbers = new ArrayList<>();
		
		Numbers.add(10);
		System.out.println(Numbers);
		Numbers.add(20);
		Numbers.add(30);
		System.out.println(Numbers);
		
		Numbers.add(1, 50);
		System.out.println(Numbers);
		
		Numbers.remove(2);
		System.out.println(Numbers);
		
		System.out.println(Numbers.get(2));
		
		System.out.println(Numbers.size());
		
		System.out.println(Numbers.indexOf(10));
		
		for(int i : Numbers) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		for(int i = 0; i < Numbers.size(); i++) {
			System.out.print(Numbers.get(i) + " ");
		}
		System.out.println();
		

		Numbers.add(30);
		Numbers.add(30);
		Numbers.add(30);
		Iterator it = Numbers.iterator();
		//	왜 ADD를 중간에 하면 안될까?
//		Numbers.add(30);
//		Numbers.add(30);
//		Numbers.add(30);
		System.out.println("Iterator");
		System.out.println(Numbers.toString());
		while(it.hasNext()) {
			int value = (int) it.next();
			if(value == 30) {
				it.remove();
			}
			System.out.print(value + " ");
		}
		System.out.println();
		System.out.println(Numbers);
		
			
	}	//	End Main	
}	//	End Class
