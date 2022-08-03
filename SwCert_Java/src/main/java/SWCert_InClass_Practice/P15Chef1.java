// 부분집합 - 바이너리 카운팅
package SWCert_InClass_Practice;

import java.util.Scanner;

public class P15Chef1 {
	
	static int MAXN = 16;
	static int[][] S = new int[MAXN][MAXN];
	static int N, R;
	static int[] A = new int[MAXN];
	static int[] B = new int[MAXN];       // 두 그룹의 재료들 저장	
	
	static int calcDiff()
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
		return Math.abs(Asum - Bsum);	
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

			int min = 0xffffff;
			
			for (int set = 1; set < (1 << N); set++)
			{

				int acnt = 0, bcnt = 0;
				for (int i = 0; i < N; i++)
					if ((set & (1 << i)) == 0) A[acnt++] = i;
					else B[bcnt++] = i;

				if (acnt != bcnt) continue;

				int ret = calcDiff();

				min = ret < min ? ret : min;
			}
			System.out.printf("#%d %d\n", tc, min);
		}
		sc.close();
	}

}
