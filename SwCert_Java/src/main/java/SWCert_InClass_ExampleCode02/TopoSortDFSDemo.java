/*
�Է�> 6(������), 8(������)
���� ��ȣ�� 0 ~ 5 ����
-----------------------------------------
6 8
0 1
0 2
1 3
1 4
2 3
2 4
3 5
4 5
-----------------------------------------
*/
package SWCert_InClass_ExampleCode02;

import java.util.*;

public class TopoSortDFSDemo {
	static int[][] G;			// ���� ���
	static boolean[] visited;	// �湮 ����
	static int[] indeg;			// ���� ����
	static int[] order;			// ���ĵ� ���� ���� ����
	static int idx = -1;		// order[]�� ����� ������ �ڷ��� ��ġ
	static int V, E;			// ������, ������
	
	public static void printOrder()
	{
		for(int i = idx; i >= 0; i--)
			System.out.printf("%d ", order[i]);
		System.out.printf("\n");
	}
	public static void dfs(int v)
	{
		visited[v] = true;		
		for(int i = 0; i < V; i++)
		{
			if(G[v][i] == 1 && visited[i] == false)
				dfs(i);
		}
		order[++idx] = v;		// ���� �������� ���ư� �� ����
	}
	public static void solve_dfs()
	{
		for(int i = 0; i < V; i++)
		{
			if(indeg[i] == 0)	// ���� ���� 0�� ������ ����������
				dfs(i);			// ���� �켱 Ž�� 
		}
		printOrder(); 
	}
	
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
				
		V = sc.nextInt();
		E = sc.nextInt();
		G = new int[V][V];		// ���� ��ȣ�� 0 ~ (V-1)
		visited = new boolean[V];	
		indeg = new int[V];
		order = new int[V];
		
		int u, v;
		for(int i = 0; i < E; i++)
		{
			u = sc.nextInt();
			v = sc.nextInt();
							
			G[u][v] = 1;
			indeg[v]++;
		}
		solve_dfs();
		sc.close();		
	}
}
