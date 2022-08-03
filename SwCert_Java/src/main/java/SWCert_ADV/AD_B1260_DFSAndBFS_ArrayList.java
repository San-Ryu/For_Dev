/*	DFS와 BFS
[문제]
그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
단, 방문할 수 있느 ㄴ정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고,
더이상 방문할 수 있는 점이 없는 경우 종료한다.
정점 번호는 1번부터 N번까지이다.

[입력]
첫 줄에는 Test Case의 개수 T가 주어지고,
각 Test Case의 첫째 줄에 
정점의 개수 N(1 <= N <= 1,000), 
간선의 개수 M (1 <= M <= 10,000), 
탐색을 시작할 정점의 번호 V
가 주어진다.

다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다.
한 간선이 여러번 주어질 수도 있는데, 간선이 하나만 있는 것으로 생각하면 된다.
입력으로 주어지는 간선은 양방향이다.

[출력]
첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다.
V부터 방문된 점을 순서대로 출력하면 된다.

[입력 예시]
1
4 5 1 
1 2
1 3
1 4
2 4
3 4

[출력 예시]
#1
1 2 4 3
1 2 3 4
 */
/*	해석
입력값 / 필요값

절차
백트래킹 (시작정보)
- DFS
종료조건 (현재 지점이 사용중?)
Y : 리턴
N : 사용중 처리, 현재값 대입 & 솔루션 처리
         재귀 호출
         되돌아가기 or 중복불가 처리 (미사용 처리)
         
- BFS
Queue 선언
초기 좌표 저장, 해당 좌표에 대한 사용 처리
While - 기준 좌표 입력
      - 좌표 출력 (값 출력, Print)
        For -> 배열 내를 돌아서 (현재 Node 배열)
                                 사용중이지 않은 수를 Queue에 저장 (탐색 좌표 저장)
                                 탐색 좌표 사용 처리
 */
package SWCert_ADV;

import java.io.*;
import java.util.*;

public class AD_B1260_DFSAndBFS_ArrayList {
	static int N, M, V;
	
	static ArrayList<Integer> adj[];
	static boolean Stat[];	//	정점에 대한 방문 여부 확인
	
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream(""));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= T; tc++) {
		//	Init. & Ipt.
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());
			
			Stat = new boolean[N];
					
			adj = new ArrayList[N];
			for(int i = 0, u, v; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				u = Integer.parseInt(st.nextToken());
				v = Integer.parseInt(st.nextToken());
				adj[u - 1].add(v);
				adj[v - 1].add(u);
			}
			
			for(int i = 0; i <= N; i++) {
				Collections.sort(adj[i]);
			}
		//	Init. & Ipt.
		
		//	Oper.
			Stat = new boolean[N];
			DFS(V);
			Stat = new boolean[N];
			BFS(V);
			System.out.println();
		//	Oper.
		
		//	Opt.
			for(int i = 0; i <= N; i++) {
				System.out.println(adj[i].toString());
			}
		//	Opt.
		}	//	End Test Case
	}	//	End Main Method
	
	public static void DFS(int n) {
		if(!Stat[n])	return;
		
		Stat[n] = true;
		
		System.out.println(n + " ");
		
		for(int i : adj[n]) {
			if(!Stat[i]) {
				DFS(i);
			}
		}
	}	//	End DFS Method
	
	public static void BFS(int n) {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		Stat[n] = true;
		
		while(!q.isEmpty()){
			int x = q.remove();
			System.out.println(x + " ");
			for(int i : adj[x]) {
				if(Stat[i] == false) {
					Stat[i] = true;
					q.add(i);
				}
			}
		}
	}	//	End BFS Method
}	//	End Class