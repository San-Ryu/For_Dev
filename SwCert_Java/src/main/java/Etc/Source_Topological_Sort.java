package Etc;

import java.io.*;
import java.util.*;

public class Source_Topological_Sort{
	static int V, E;
	
	static ArrayList<Integer> Arr[];
	static Queue<Integer> q;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int S = 1;
		
		Arr = new ArrayList[V];
		for(int i = 0; i < V; i++){
			Arr[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < E; i++){
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			Arr[u - 1].add(v);
		}
		
		
		q = new LinkedList();
		q.add(S);
		
		while(!q.isEmpty()){
			int Start = q.poll();
			
			System.out.print(Start + " ");
			
			for(int i : Arr[Start - 1]){
				q.add(i);
				
				
				
				
				
				
				
			}
		}
	}
}