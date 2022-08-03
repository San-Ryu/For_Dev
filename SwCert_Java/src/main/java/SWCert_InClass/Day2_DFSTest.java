package SWCert_InClass;

import java.util.Scanner;

/*
입력 > 8 (정점 수), 10 (간선 수)

8 10
1 2 1 3 2 4 2 5 3 6 4 7 5 6 5 7 6 8 7 8

 */
public class Day2_DFSTest {
	static int V, E;
	static boolean Stat[];
	static int G[][];
	
	public static void DFS(int Deg) {
		if(Deg == V)	return;
		
		for(int i = 0; i < V; i++) {
			if(G[Deg][i] == 1)	{
				Stat[i] = true;
				System.out.println(i);
				DFS(i);
				Stat[i] = false;
			}
		}
	}
	
	public static void main(String args[]) throws Exception{
	//	Ipt.
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		
		G = new int [V][V];
		for(int i = 0; i < E; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			G[u - 1][v - 1] = G[v - 1][u - 1] = 1;			
		}
		
		Stat = new boolean [V];
	//	Ipt.
		
		DFS(0);
		
	//	Opt.
		
	//	Opt.
	}	//	End Main
}	//	End Class