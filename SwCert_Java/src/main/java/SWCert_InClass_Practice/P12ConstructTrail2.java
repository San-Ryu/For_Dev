package SWCert_InClass_Practice;

import java.util.Scanner;

public class P12ConstructTrail2 {
	static int[][] map = new int[8][8];
	static int[][] visit = new int[8][8];
	static int N, K;
	static int dx[] = { 0, 0, 1, -1 };	// ©Л, аб, го, ╩С
	static int dy[] = { 1, -1, 0, 0 };

	static int DFS(int x, int y, int flag)
	{
		visit[x][y] = 1;	

		int max = 1, ret = 0;

		for (int i = 0; i < 4; i++)
		{
			int tx = x + dx[i];
			int ty = y + dy[i];

			if (tx < 0 || tx == N || ty < 0 || ty == N) continue;

			if (visit[tx][ty] == 1) continue;

			if (map[tx][ty] >= map[x][y])
			{
				if (flag == 1) continue;
				
				int diff = map[tx][ty] - map[x][y];

				if (diff >= K) continue;

				map[tx][ty] -= (diff + 1);

				ret = DFS(tx, ty, flag + 1) + 1;			

				map[tx][ty] += (diff + 1);
			}
			else {
				ret = DFS(tx, ty, flag) + 1;			
			}
			max = ret > max ? ret : max;
		}
		visit[x][y] = 0;

		return max;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++)
		{
			N = sc.nextInt();
			K = sc.nextInt();
			
			int maxH = 0;
			for (int i = 0; i < N; i++)
			{
				for (int j = 0; j < N; j++)
				{
					map[i][j] = sc.nextInt();
					if (maxH < map[i][j])
						maxH = map[i][j];
				}
			}
			int maxLen = 0;
			for (int x = 0; x < N; x++)
			{
				for (int y = 0; y < N; y++)
				{
					if (map[x][y] != maxH) continue;

					int ret = DFS(x, y, 0);

					maxLen = ret > maxLen ? ret : maxLen;

				}
			}
			System.out.printf("#%d %d\n", tc, maxLen);
		}
		sc.close();
	}
}
