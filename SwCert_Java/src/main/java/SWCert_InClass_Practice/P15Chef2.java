// 조합
package SWCert_InClass_Practice;

import java.util.Scanner;

public class P15Chef2 {
	static int MAXN = 16;
	static int[][] S = new int[MAXN][MAXN];
	static int N, R;
	static int[] A = new int[MAXN];
	static int[] B = new int[MAXN];       // 두 그룹의 재료들 저장	
	static int min;
	static int calcDiff(){
		
		boolean[] used = new boolean[MAXN];
		for (int i = 0; i < R; i++)
			used[A[i]] = true;
		int idx = 0;
		for (int i = 0; i < N; i++)
			if (!used[i]) B[idx++] = i;
		
		int Asum = 0, Bsum = 0;

		for (int i = 0; i < R; i++)
		{
			for (int j = 0; j < R; j++)
			{
				if (i == j) continue;
				Asum += S[A[i]][A[j]];
				Bsum += S[B[i]][B[j]];
			}
		}
		
		return Math.abs(Asum - Bsum);
	}
	static void solve(int k, int start)
	{
		if (k == R){
			int ret = calcDiff();
			if (ret < min) 
				min = ret;
			return;
		}
		for (int i = start; i < N; i++)
		{
			A[k] = i;
			solve(k + 1, i + 1);
		}	
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++)
		{
			N = sc.nextInt();
			R = N / 2;

			for (int i = 0; i < N; i++)
			{
				for (int j = 0; j < N; j++)
					S[i][j] = sc.nextInt();
			}

			min = 0xffffff;
			solve(0, 0);
			System.out.printf("#%d %d\n", tc, min);
		}
		sc.close();
	}
}
