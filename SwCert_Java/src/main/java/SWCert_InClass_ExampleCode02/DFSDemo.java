package SWCert_InClass_ExampleCode02;

import java.util.*;

public class DFSDemo{
	static int[][] G;			// ���� ���
	static boolean[] visited;	// �湮 ����
	static int V, E;
	static int N[][] = new int[100][2];// ������, ������\
	static int solution;
	public static void DFS(int v)
	{
		visited[v] = true; 

		for(int i = 1; i <= E; i++)		
		{								// ��湮 ���� ���� ã��
			if(G[v][i] == 1 && visited[i] == false)
			{
				DFS(i);
			}
			else if (G[v][i] == 99 && visited[i] == false)
			{
				solution = 1;
				break;
			}
		}
		solution = 0;
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		for(int i = 1 ; i < 10+1; i++)
		{
			E = sc.nextInt();  //����
			G = new int[200 + 1][200 + 1];
			visited = new boolean[200 + 1];
			
			int u, v;
			
			for(int j = 0; j < E; j++)
			{
				u = sc.nextInt();
				v = sc.nextInt();
				G[u][v] = 1;
			}
			DFS(1);
			System.out.println("#" + i + " " + solution);
		}
		sc.close();		
	}
}
