package SWCert_InClass_Practice;

import java.util.Scanner;

public class P05WhereWord {
	static int MAXN = 15;
	static int[][] map = new int[MAXN][MAXN];
	static int N, K;

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();		

		for (int tc = 1; tc <= T; tc++)
		{
			N = sc.nextInt();
			K = sc.nextInt();
			
			for (int i = 0; i < N; i++)
			{
				for (int j = 0; j < N; j++)
					map[i][j] = sc.nextInt();
			}

			int ans = 0;
			// 가로
			for (int x = 0; x < N; x++)
			{
				for (int y = 0; y < N; y++)
				{
					if (map[x][y] == 0) continue;

					int cnt = 0;
					while (y < N && map[x][y] == 1){ 
						cnt++; y++;
					}
					if (cnt == K) ans++;				
				}
			}

			// 세로
			for (int y = 0; y < N; y++)
			{
				for (int x = 0; x < N; x++)
				{
					if (map[x][y] == 0) continue;

					int cnt = 0;
					while (x < N && map[x][y] == 1) {
						cnt++; x++;					
					}
					if (cnt == K) ans++;
				}
			}
			System.out.printf("#%d %d\n", tc, ans);
		}
	}
}
