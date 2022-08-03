/*
5(케이스 수), 2(자료수)
---------------------------
5
2
0 2
3
0 2 3
4
0 2 3 4
5
0 2 3 4 5
6
0 2 3 4 5 6
---------------------------
 */
package SWCert_InClass_ExampleCode00_Input;

import java.util.Scanner;

public class IOTest1 {
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
				
				System.out.print(sc.nextInt() + " ");
			}
			System.out.print("\n");
		}
		sc.close();
	}
}
