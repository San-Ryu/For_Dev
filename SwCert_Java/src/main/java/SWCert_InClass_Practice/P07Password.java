package SWCert_InClass_Practice;

import java.util.*;

public class P07Password {

	static int SIZE = 1000;
	static int[] data = new int[SIZE];
	static int top;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Stack<Character> S = new Stack<Character>();
		
		for (int tc = 1; tc <= 10; tc++)
		{
			S.clear();
			
			int num = sc.nextInt();			
			String str = sc.next();		
			
			for (int i = 0; i < num; i++)
			{
				if (S.isEmpty()) S.push(str.charAt(i));
				else if (S.peek() == str.charAt(i)) S.pop();
				else S.push(str.charAt(i));
			}
			System.out.print("#" + tc + " ");
			for (char c: S)
				System.out.print(c);
			System.out.println();
		}
		sc.close();
	}
}
