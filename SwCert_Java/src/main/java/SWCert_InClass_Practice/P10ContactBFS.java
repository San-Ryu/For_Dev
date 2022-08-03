package SWCert_InClass_Practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P10ContactBFS {
	static int N = 100;
	static int[][] G;
	static int[] D;			// 시작점에서 거리 저장
	static int[] visited;
	
	static int start, size; // start = 시작점, size = 간선 수

	static int contact(int s) {
		
		Queue<Integer> Q = new LinkedList<Integer>();
		visited[s] = 1;		
		Q.add(s);
		
		while (!Q.isEmpty())
		{
			int v = Q.poll();

			for (int i = 1; i <= N; i++)
			{
				if ( G[v][i] == 1 && visited[i] == 0)
				{
					visited[i] = 1;
					Q.add(i);
					D[i] = D[v] + 1;
				}
			}
		}

		int maxIdx = 1;
		for (int i = 2; i <= N; i++)
		{
			if (D[maxIdx] <= D[i]) maxIdx = i;

		}
		return maxIdx;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++)
		{
			G = new int[N + 1][N + 1];
			D = new int[N + 1];			// 시작점에서 거리 저장
			visited = new int[N + 1];
			
			size = sc.nextInt();
			start = sc.nextInt();			
			size /= 2;
			
			for (int i = 0; i < size; i++)
			{
				int from = sc.nextInt();
				int to = sc.nextInt();
				G[from][to] = 1;
			}
			
			System.out.printf("#%d %d\n", tc, contact(start));
		}
		sc.close();
	}
}
