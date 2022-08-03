/* 입력>
------------------------
8 10
1 2 2
1 3 2
2 4 3
2 5 5
3 6 1
4 7 4
5 6 2
5 7 1
6 8 6
7 8 2
------------------------
*/
package SWCert_InClass_ExampleCode02;

import java.util.Scanner;

public class ShortestPathDFS {
	static int[][] G = new int[100][100];				// 인접 행렬
	static int[] D = new int[100];						// 거리 저장
	static int[] P = new int[100];						// 최단 경로 트리
	static int V, E;
		
	// BFS + 인접 행렬
	public static void DFS(int v)
	{
		for(int i = 1; i <= V; i++)
		{
			if(G[v][i] != 0 && D[i] > D[v] + G[v][i])
			{
				D[i] = D[v] + G[v][i];		
				P[i] = v;
				DFS(i);
			}	
		}
	}	
	public static void main(String[] args) {		

		Scanner sc = new Scanner(System.in);		
		
		V = sc.nextInt();
		E = sc.nextInt();
		
		int u, v, w;
		for(int i = 0; i < E; i++)
		{
			u = sc.nextInt();
			v = sc.nextInt();
			w = sc.nextInt();				
			G[u][v] = G[v][u] = w;
		}		
				
		System.out.println("최단 경로 - DFS(인접행렬)");
		// D[], P[] 배열 초기화
		for(int i = 1; i <= V; i++)
			D[i] = 0xffffff;
		D[1] = 0; P[1] = 1;
		
		DFS(1); 
		printResult();		
		sc.close();
	}
	// D[], P[] 배열 출력 하기
	public static void printResult()
	{
		for(int i = 1; i <= V; i++)
			System.out.printf("%2d ", i);
		
		System.out.println("\n------------------------------------------");
		for(int i = 1; i <= V; i++)
			System.out.printf("%2d ", D[i]);
		System.out.println("\n------------------------------------------");		
		for(int i = 1; i <= V; i++)
			System.out.printf("%2d ", P[i]);		
		System.out.printf("\n");
	}		
}
