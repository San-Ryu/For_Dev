package SWCert_InClass_Practice;

import java.util.Scanner;

public class P12ConstructTrail1 {
	static int[][] map = new int[8][8];
	static int[][] visit = new int[8][8];
	static int N, K;
	static int dx[] = { 0, 0, 1, -1 };	// ©Л, аб, го, ╩С
	static int dy[] = { 1, -1, 0, 0 };
	static int maxLen;
	
	static void DFS(int x, int y, int len, int flag)
	{
		visit[x][y] = 1;	
		
		maxLen = Math.max(maxLen, len);

		for (int i = 0; i < 4; i++)
		{
			int tx = x + dx[i];
			int ty = y + dy[i];

			if (tx < 0 || tx == N || ty < 0 || ty == N) continue;

			if (visit[tx][ty] == 1) continue;

			if(map[tx][ty] >= map[x][y])			
			{
				if(flag == 1) continue;
				
				int diff = map[tx][ty] - map[x][y];

				if (diff >= K) continue;

				map[tx][ty] -= (diff + 1);

				DFS(tx, ty, len + 1, flag + 1);			

				map[tx][ty] += (diff + 1);
			}
			else {
				DFS(tx, ty, len + 1, flag);			
			}
		}
		visit[x][y] = 0;
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
			
			maxLen = 0;
			
			for (int x = 0; x < N; x++)
			{
				for (int y = 0; y < N; y++)
				{
					if (map[x][y] != maxH) continue;

					DFS(x, y, 1, 0);
				}
			}
			System.out.printf("#%d %d\n", tc, maxLen);
		}
		sc.close();
	}
}
