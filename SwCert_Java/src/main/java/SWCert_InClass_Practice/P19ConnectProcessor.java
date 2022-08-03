package SWCert_InClass_Practice;

import java.util.Scanner;

public class P19ConnectProcessor {
	static int MAXN = 12;
	static int N;
	static int[][] map = new int[MAXN + 1][MAXN + 1];
	static int[] xarr = new int[MAXN + 1];
	static int[] yarr = new int[MAXN + 1];	
	static int min, max, end;	// end: 벽에 인접한 코어를 제외한 코어수
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = { 0, 0, -1, 1};
	static boolean isConnect(int n, int dir)
	{
		int x = xarr[n], y = yarr[n];
		while(true)
		{
			x += dx[dir]; y += dy[dir];
			if(x < 0 || y < 0 || x == N || y == N) break;
			if(map[x][y] != 0) return false;
		}		
		return true;
	}
	static void setVal(int n, int dir, int val)
	{
		int x = xarr[n], y = yarr[n];

		while(true)
		{
			x += dx[dir]; y += dy[dir];
			if(x < 0 || y < 0 || x == N || y == N) break;
			map[x][y] = val;
		}		
	}
	static int calcCnt()
	{
		int cnt = 0;
		for (int i = 0; i < N; i++){
			for (int j = 0; j < N; j++)
			{
				if(map[i][j] == 2) cnt++;
			}
		}
		return cnt;
	}
	static void DFS(int k, int n, int num)
	{
		if (k == n) {
			if (num > max) {
				max = num;
				min = calcCnt();
			}
			else if (num == max){
				int ret = calcCnt();
				if (ret < min) min = ret;
			}
			return;
		}
		
		// k번 코어 연결
		for (int dir = 0; dir < 4; dir++) //상,하,좌,우 연결
		{
			if (isConnect(k, dir))
			{
				setVal(k, dir, 2);
				DFS(k + 1, n, num + 1);
				setVal(k, dir, 0);
			}
		}
		// k번 코어 연결하지 않음.
		DFS(k + 1, n, num);
	}
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
	    int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++)
		{
			N = sc.nextInt();
			end = 0;
			
			for (int i = 0; i < N; i++)
			{
				for (int j = 0; j < N; j++)
				{
					map[i][j] = sc.nextInt();

					if (map[i][j] == 0) continue;
					if (i != 0 && i != N - 1 && j != 0 && j != N - 1)
					{
						xarr[end] = i; yarr[end] = j;
						end++;
					}
				}
			}
			min = 0xfffffff; max = 0;			
			DFS(0, end, 0);
			System.out.printf("#%d %d\n", tc, min);			
		}
		sc.close();
	}
}
