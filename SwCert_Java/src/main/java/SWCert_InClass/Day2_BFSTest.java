/*
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
 */
package SWCert_InClass;

import java.io.*;
import java.util.*;

public class Day2_BFSTest {
	static int G[][];
	static boolean Stat[];
	static int V, E;
	
	static Queue<Integer> q;
	static int D[];
	static int P[];
	
	static void BFS(int v) {
		for(int i = 1; i <= V; i++) {
			D[i] = 0xFFFFFF;
			P[i] = i;
		}
		q = new LinkedList<>();
		
		D[v] = 0;
		Stat[v] = true;
		q.add(v);
		while(!q.isEmpty()){
			v = q.poll();
			for(int i = 1; i <= V; i++) {
				if(G[v][i] == 1 && Stat[i] == false) {
					Stat[i] = true;
					q.add(i);
				}
			}
		}
	}	//	End BFS
	
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
		
		BFS(0);
		
	//	Opt.
		
	//	Opt.		
	}	//	End Main
}	//	End Class