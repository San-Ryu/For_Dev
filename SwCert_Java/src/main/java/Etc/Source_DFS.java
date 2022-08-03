package Etc;

import java.io.*;
import java.util.*;

public class Source_DFS {
	static int V, E, S;
	
	static int cnt;
	static boolean Stat[];
	static ArrayList<Integer> Arr[];
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
			Arr[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < E; i++){
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			Arr[u - 1].add(v);
			Arr[v - 1].add(u);
		}
		
		for(int i = 0; i < V; i++){
			Collections.sort(Arr[i]);
		}
		
		cnt = 1;
		DFS(S);
		
	}
	
	public static void DFS(int n){
		if(cnt == V){
			System.out.print(n + " ");
			return;
		}
		
		System.out.print(n + " ");
		Stat[n - 1] = true;
		
		for(int i : Arr[n - 1]){
			if(Stat[i - 1])	continue;
			
			Stat[i - 1] = true;
			cnt++;
			DFS(i);
		}
	}
}