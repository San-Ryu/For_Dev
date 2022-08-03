/*
입력> 8(정점수), 10(간선수)
-----------------------------------------
8 10
1 2
1 3
2 4
2 5
3 6
4 7
5 6
5 7
6 8
7 8
-----------------------------------------
 */
package SWCert_InClass_ExampleCode02;

import java.util.*;
public class BFSDemo {

	static int[][] G;			// 인접 행렬
	static boolean[] visited;	// 방문 정보
	static int V, E;			// 정점수, 간선수
	static void BFS(int v)
	{
		visited = new boolean[V + 1];
		Queue<Integer> Q = new LinkedList<Integer>();
		
		visited[v] = true; System.out.print(v + " ");
		Q.add(v);
		
		while(!Q.isEmpty())
		{
			v = Q.poll();
			for(int i = 1; i <= V; i++)
			{
				if(G[v][i] == 1 && visited[i] == false)
				{
					visited[i] = true;
					System.out.print(i + " ");
					Q.add(i);
				}
			}
		}
	}	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
			
		V = sc.nextInt();
		E = sc.nextInt();
		
		G = new int[V + 1][V + 1];		
		
		int u, v;
		for(int i = 0; i < E; i++)
		{
			u = sc.nextInt();
			v = sc.nextInt();
			
			G[u][v] = G[v][u] = 1;
		}
		BFS(1);
		sc.close();		
	}	
}
