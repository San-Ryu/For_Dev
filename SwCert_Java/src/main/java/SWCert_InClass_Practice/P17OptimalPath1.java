package SWCert_InClass_Practice;

import java.util.Scanner;

public class P17OptimalPath1 {
	static int min;
	static int sx, sy, ex, ey;
	static int[] x = new int[10];
	static int[] y = new int[10];
	static int[] order = new int[10];	
	static int N;
	
	static void findPath(int k, int n, int visit)
	{
		if (k == n){ // 단말노드에 도착, 모든 선택이 이루어짐.
			int dist = Math.abs(sx - x[order[0]]) + Math.abs(sy - y[order[0]]);

			for (int i = 1; i < n; i++)
				dist += Math.abs(x[order[i - 1]] - x[order[i]]) + Math.abs(y[order[i - 1]] - y[order[i]]);
			
			dist += Math.abs(x[order[n - 1]] - ex) + Math.abs(y[order[n - 1]] - ey);	
			
			min = Math.min(min, dist);
			return;
		}
	
		for (int i = 0; i < n; i++)
		{
			if ((visit & (1 << i)) != 0) continue;
			order[k] = i;
			findPath(k + 1, n, visit | (1 << i));
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++)
		{
			N = sc.nextInt();
			sx = sc.nextInt();
			sy =  sc.nextInt();
			ex =  sc.nextInt();
			ey = sc.nextInt();
			
			for (int i = 0; i < N; i++)
			{
				x[i] =  sc.nextInt();
				y[i] =  sc.nextInt();
			}
			
			min = 0xffffff;
			findPath(0, N, 0);
		
			System.out.println("#" + tc + " " + min);
		}
		sc.close();
	}
}
