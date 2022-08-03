//package samsung01;
package Etc;

import java.io.*;
import java.util.*;

public class Source_BFS {
	static int V, E, S;
	
	static boolean Stat[];
	static ArrayList<Integer> Arr[];
	static Queue<Integer> q;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		Stat = new boolean[V];
		
		Arr = new ArrayList[V];
		for(int i = 0; i < V; i++){
			Arr[i] = new ArrayList<Integer>(); 
		}
		
		for(int i = 0; i < E; i++){
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			Arr[u - 1].add(v);
			Arr[v - 1].add(u);
		}
		
		q = new LinkedList<>();
		q.add(S);
		
		while(!q.isEmpty()){
			int Start = q.poll();
			Stat[Start - 1] = true;
			
			System.out.print(Start + " ");
			
			for(int i : Arr[Start - 1]){
				if(Stat[i - 1])	continue;
				q.add(i);
				Stat[i - 1] = true;
			}
		}
	}
}
