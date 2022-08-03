// 부분집합 - 재귀
package SWCert_InClass_Practice;

import java.util.Scanner;

public class P15Chef3 {
	static int MAXN = 16;
	static int[][] S = new int[MAXN][MAXN];
	static int N, R;
	static int[] A = new int[MAXN];
	static int[] B = new int[MAXN];       // 두 그룹의 재료들 저장	
	static int min;

	static void calcDiff()
	{
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

		int diff = Math.abs(Asum - Bsum);
		min = Math.min(min, diff);
	}
	static void subset(int k, int acnt, int bcnt)    // 조합 생성하기
	{
		if (acnt == R) {
			for (int i = k; i < N; i++)
				B[bcnt++] = i;		
			calcDiff();		
			return;
		}else if (bcnt == R) {
			for (int i = k; i < N; i++)
				A[acnt++] = i;
			calcDiff();		
			return;
		}
		
		A[acnt] = k; 
		subset(k + 1, acnt + 1, bcnt);
		
		B[bcnt] = k;
		subset(k + 1, acnt, bcnt + 1);	
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
			subset(0, 0, 0);

			System.out.printf("#%d %d\n", tc, min);
		}
		sc.close();
	}
}
