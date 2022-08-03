/*
3(케이스 수), 2(NxN 크기)
-----------------------------
3
2
0 2
3 4
3
0 2 3
4 5 6
7 8 9
4
0 2 3 4
5 6 7 8
9 0 0 2
3 4 5 6
-----------------------------
 */
package SWCert_InClass_ExampleCode00_Input;

import java.util.Scanner;

public class IOTest3 {
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
				for(int j = 0; j < N; j++)
				{
					System.out.print(sc.nextInt() + " ");
				}
				System.out.print("\n");
			}
		}
		sc.close();
	}
}
