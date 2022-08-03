// 부분집합 - 바이너리 카운팅
package SWCert_InClass_Practice;

import java.util.Scanner;

public class P16QuitJob1 {
	
	static int[] T = new int[16];
	static int[] P = new int[16];
	static int N;
	
	static boolean isPossible(int day, int cnt[])
	{
		if (day + T[day] - 1 > N) return false;
		for (int i = day; i < day + T[day]; i++)
			if (cnt[i] == 1) return false;
		return true;
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

		int max = 0;
		for (int i = 1; i < (1 << (N + 1)); i++)
		{
			int[] cnt = new int[16];
			int sum = 0;
			for (int j = 1; j <= N; j++)
			{
				if ((i & (1 << j)) == 0) continue;

				if (!isPossible(j, cnt)) break;

				for (int k = j; k < j + T[j]; k++)
					cnt[k] = 1;
				sum += P[j];
			}
			max = Math.max(max, sum);
		}
		System.out.printf("%d\n", max);
		sc.close();
	}
}
