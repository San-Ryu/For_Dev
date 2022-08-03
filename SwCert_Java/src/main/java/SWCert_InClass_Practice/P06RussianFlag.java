package SWCert_InClass_Practice;

import java.util.Scanner;

public class P06RussianFlag {

	static int N, M;
	static int[] W = new int[50];
	static int[] B = new int[50];
	static int[] R = new int[50];
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++)
		{
			N = sc.nextInt();
			M = sc.nextInt();

			int w, b, r;
			for (int i = 0; i < N; i++)
			{
				String str = sc.next();
				w = b = r = 0;
				for (int j = 0; j < M; j++)
				{
					if (str.charAt(j) == 'W') w++;
					else if (str.charAt(j) == 'B') b++;
					else r++;
				}
				W[i] = b + r;
				B[i] = w + r;
				R[i] = w + b;
			}
			int min = 0xfffffff;
			for (int i = 0; i < N - 2; i++)
			{
				for (int j = i + 1; j < N - 1; j++)
				{	
					int sum = 0;
					for (int k = 0; k <= i; k++) sum += W[k];
					for (int k = i + 1; k <= j; k++) sum += B[k];
					for (int k = j + 1; k < N; k++) sum += R[k];

					min = min > sum ? sum : min;					
				}
			}
			System.out.printf("#%d %d\n", tc, min);
		}

		sc.close();
	}
}
