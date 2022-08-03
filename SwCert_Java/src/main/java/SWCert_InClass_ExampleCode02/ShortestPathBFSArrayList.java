/* �Է�>
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

import java.util.*;

public class ShortestPathBFSArrayList {
	static ArrayList<Vertex>[] G;
	static int[] D;		// ���������� �Ÿ� ����
	static int[] P;		// �ִ� ��� Ʈ�� ����	
	static int V, E;	// ������, ������
	
	private static class Vertex{
		int v, w;
		Vertex(int a, int b){ v= a; w = b;}
	}
	
	// BFS + ���� ����Ʈ
	public static void BFS(int v)
	{
		for(int i = 1; i <= V; i++)
			D[i] = 0xffffff;
		D[v] = 0; P[v] = v;
		
		Queue<Integer> Q = new LinkedList<Integer>();		
		Q.add(v);		
		while(!Q.isEmpty())
		{
			v = Q.remove();
			
			for(Vertex node: G[v])
			{
				if(D[node.v] > D[v] + node.w)
				{
					D[node.v] = D[v] + node.w;
					P[node.v] = v;
					Q.add(node.v);					
				}	
			}
		}
	}
	
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();
		
		G = new ArrayList[V + 1];
		for(int i = 0; i <= V; i++)
			G[i] = new ArrayList<Vertex>();
		
		D = new int[V + 1];
		P = new int[V + 1];
		
		int u, v, w;
		for(int i = 0; i < E; i++)
		{
			u = sc.nextInt();
			v = sc.nextInt();				
			w = sc.nextInt();
			
			G[u].add(new Vertex(v, w));
			G[v].add(new Vertex(u, w));
		}			
		sc.close();
		
		System.out.println("�ִ� ��� - BFS(��������Ʈ)>");		
		BFS(1); 
		printResult();
	}
	
	// D[], P[] �迭 ��� �ϱ�
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
