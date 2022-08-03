/*
4(케이스 수), 5(길이)
----------------------------
4
5
abcde
00
abcdefghij
20
aaaaabbbbbcccccddddd
5
abcde
----------------------------
 */
package SWCert_InClass_ExampleCode00_Input;

import java.util.Scanner;

public class IOTest2 {
	public static void main(String[] args)
	{		
		Scanner sc = new Scanner(System.in);			

		int case_num = sc.nextInt();
		System.out.println(case_num);

		for(int tc = 1; tc <= case_num ; tc++)
		{
			int N = sc.nextInt();
			System.out.println(N);
			String line = sc.next();
			System.out.println(line);
		}
		sc.close();
	}
}
