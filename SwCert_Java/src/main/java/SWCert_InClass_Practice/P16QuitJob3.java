package SWCert_InClass_Practice;

import java.util.Scanner;

public class P16QuitJob3 {
	static int[] T = new int[16];
	static int[] P = new int[16];
	static int N, max;
	
	static void solve(int day, int p)
	{
		max = Math.max(max, p);
		if (day > N) return;

		if (day + T[day] - 1 <= N)
			solve(day + T[day], p + P[day]);

		solve(day + 1, p);
	}
	public static void main(String[] args)
	{	
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for (int i = 1; i <= N; i++)
		{
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}
		max = 0;
		solve(1, 0);

		System.out.printf("%d\n", max);
		sc.close();
	}
}
