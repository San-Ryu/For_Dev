/*	위상 정렬
[문제]
DAG(Directed Acyclic Graph)는 방항셩이 있는 간선으로 이루어진 그래프 중, 사이클이 없는 그래프를 의미한다. 
DAG에서는 항상 위상 정렬을 할 수 있다.

DAG가 주어질 때, 위상 정렬을 하는 프로그램을 작성하시오.

[제한 조건]
1) 시간 제한 1.5 Sec
2) 메모리 제한 512 MB

[입력]
첫 번째 줄에 그래프의 정점 개수 V, 간선 개수 E가 공백으로 분리되어 주어진다. 
(1 <= V <= 50,000 / 1 <= E <= 100,000)
두번째 줄부터 E개의 줄에 걸쳐 각 간선의 정보인 x, y가 공백으로 분리되어 주어진다.
이는 x에서 출발하여 y에 도착하는 유항 간선이 존재한다는 것을 의미한다.
(1 <= x, y <= V / x != y)

주어지는 그래프는 항상 DAG이고, 1번으로 들어오는 간선은 없다.

[출력]
첫번째 줄에 위상 정렬의 결과를 출력한다.
답이 여러가지인 경우, 그 중 아무 것이나 출력한다.

[입력 예시]
4 4
1 2
1 3
2 4
3 4

[출력 예시]
1 2 3 4 혹은
1 3 2 4

 */
package SWCert_ADV;

import java.io.*;
import java.util.*;

//	koitp 제출시 Class명
//	public class source{
public class AD_Edu181031_DP_Topology_Sort {
	static int V, E;
	
	static boolean Stat[];
	static ArrayList<Integer> Arr[];
	static Queue<Integer> q;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int S = 1;
		
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
		}
		
		q = new LinkedList();
		q.add(S);
		Stat[S - 1] = true;
		
		while(!q.isEmpty()){
			int Start = q.poll();
			
			System.out.print(Start + " ");
			
			for(int i : Arr[Start - 1]){
				if(Stat[i - 1])	continue;
				
				q.add(i);
				Stat[i - 1] = true;
			}
		}
	}
}