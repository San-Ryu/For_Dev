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

public class ShortestPathDijkstra {
	static ArrayList<Vertex>[] G;	// ���� ����Ʈ
	static int[] D;					// �ִ� �Ÿ� ����	
	static int[] P;					// �ִ� �Ÿ� ����
	static int V, E;				// ����������, ������
	
	// �켱 ���� ť�� �����ϱ� ���� ��ü 
	private static class Vertex implements Comparable<Vertex>{
		int v, d;	// ����, �Ÿ�		
		Vertex(int a, int b) {
			v = a; d = b; 
		}
		public int compareTo(Vertex arg) {			 
			return d - arg.d;
		}		
	}
	
	public static void dijkstra(int v)
	{
		for(int i = 0; i <= V; i++)
			D[i] = 0xffffff;		// D[] �ʱ�ȭ 
		D[v] = 0;					// ������ �Ÿ� �ʱ�ȭ
		
		PriorityQueue<Vertex> Q = new PriorityQueue<Vertex>();		
		Q.add(new Vertex(v, D[v]));
		
		while(!Q.isEmpty())
		{
			Vertex from = Q.poll();
			if(from.d > D[from.v]) continue;
			
			for(Vertex to: G[from.v])
			{
				if(D[to.v] > D[from.v] + to.d)
				{
					D[to.v] = D[from.v] + to.d;				
					P[to.v] = from.v;
					Q.add(new Vertex(to.v, D[to.v]));
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
		dijkstra(1);	
		printResult();
		sc.close();
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