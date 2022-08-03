/*	너비 우선 탐색
[문제]
그래프를 순회하는 방법 중 하나인 BFS(너비 우선 탐색, Breadth First Search)의 방문 순서를 출력하시오.
방문 순서가 여러개인 경우에는 아무거나 출력하시오.

[제한 조건]
1) 시간 제한 2.0 Sec
2) 매모리 제한 512 MB

[입력]
첫번째 줄에 그래프의 정점 개수 V, 간선 개수 E, 그리고 시작 점점의 번호 S가 공백으로 분리되어 주어진다.
(1 <= S <= V <= 100,000 / 1 <= E <= 300,000)
두번쨰 줄부터 E개의 줄에 걸쳐 각 간선의 정보인 x, y가 공백으로 분리되어 주어진다.
이는 x와 y를 잇는 간선(양방향)이 존재한다는 것을 의미한다.
(1 <= x, y <= V, x != y)

[출력]
첫번쨰 줄에 정점 S에서 시작한 너비 우선 탐색의 결과를 출력하시오.
(마지막에 New Line을 출력하세요.)

[부분 문제]
Num	Grade	N, M 제한
1	20		1 <= V <= 10
2	30		1 <= V <= 3,000
3	50		1 <= V <= 300,000

[입력 예시]
5 6 2
1 2
1 3
2 4
3 4
3 5
4 5

5 4 1
1 2
1 3
2 5
3 4

[출력 예시]
2 1 4 3 5

1 2 3 4 5	또는
1 2 3 5 4
 */
package SWCert_ADV;

import java.io.*;
import java.util.*;

//	koitp 제출시 Class명
//	public class source{
public class AD_Edu181031_BFS {
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
