package SWCert_InClass_Practice;

import java.util.Scanner;

public class P03Harvest {
	static int[][] map = new int[50][50];
	static int N, T;
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++)
		{
			N = sc.nextInt();
			
			for (int i = 1; i <= N; i++)
			{
				String str = sc.next();
				
				for (int j = 1; j <= N; j++)
					map[i][j] = str.charAt(j - 1) - '0';
			}

			int mid = (N + 1) / 2;
			int s = mid, e = mid;
			int sum = 0;
			for (int i = 1; i <= N; i++)
			{
				for (int j = s; j <= e; j++)
					sum += map[i][j];
				if (i < mid) {
					s--; e++;				
				}
				else {
					s++; e--;
				}
			}
			System.out.printf("#%d %d\n", tc, sum);
		}
		sc.close();
	}
}
