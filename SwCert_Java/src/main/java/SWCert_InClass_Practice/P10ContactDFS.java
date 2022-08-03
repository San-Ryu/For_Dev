package SWCert_InClass_Practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P10ContactDFS {
	static int N = 100;
	static int[][] G;
	static int[] D;			// 시작점에서 거리 저장
	
	static int start, size; // start = 시작점, size = 간선 수

	static void contact(int v) 
	{		
		for (int i = 0; i <= N; i++)
		{
			if ( G[v][i] == 1 && D[i] > D[v] + 1)
			{
				D[i] = D[v] + 1;
				contact(i);
			}
		}
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++)
		{
			G = new int[N + 1][N + 1];
			D = new int[N + 1];			// 시작점에서 거리 저장	
			
			size = sc.nextInt();
			start = sc.nextInt();			
			size /= 2;
			
			for (int i = 0; i < size; i++)
			{
				int from = sc.nextInt();
				int to = sc.nextInt();
				G[from][to] = 1;
			}
			for(int i = 0; i < N; i++)
				D[i] = 0xffffff;
			D[start] = 0;
			contact(start);
			
			int maxIdx = 0;
			for (int i = 1; i < N; i++)
			{
				if (D[i] < 0xffffff && D[maxIdx] <= D[i]) 
					maxIdx = i;
			}
			
			System.out.printf("#%d %d\n", tc, maxIdx);
		}
		sc.close();
	}
}
