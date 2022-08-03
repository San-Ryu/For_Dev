/*
3(케이스 수), 2(NxN 크기)
--------------------------
3
2
00
22
4
0000
2222
3333
4444
10
0000000000
0000000000
2222222222
3333333333
4444444444
5555555555
6666666666
7777777777
8888888888
9999999999
--------------------------
 */
package SWCert_InClass_ExampleCode00_Input;

import java.util.Scanner;

public class IOTest4 {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
			
		int case_num = sc.nextInt();
		System.out.println(case_num);

		for(int tc = 1; tc <= case_num ; tc++)
		{
			int N = sc.nextInt();
			System.out.println(N);
			for(int i = 0; i < N; i++)
			{
				String line = sc.next();
				for(int j = 0; j < line.length(); j++)
				{
					System.out.print(line.charAt(j));
				}
				System.out.print("\n");
			}
		}
		sc.close();
	}
}
