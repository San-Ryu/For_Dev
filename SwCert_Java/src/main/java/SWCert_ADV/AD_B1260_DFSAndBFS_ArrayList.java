/*	DFS�� BFS
[����]
�׷����� DFS�� Ž���� ����� BFS�� Ž���� ����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
��, �湮�� �� �ִ� �������� ���� ���� ��쿡�� ���� ��ȣ�� ���� ���� ���� �湮�ϰ�,
���̻� �湮�� �� �ִ� ���� ���� ��� �����Ѵ�.
���� ��ȣ�� 1������ N�������̴�.

[�Է�]
ù �ٿ��� Test Case�� ���� T�� �־�����,
�� Test Case�� ù° �ٿ� 
������ ���� N(1 <= N <= 1,000), 
������ ���� M (1 <= M <= 10,000), 
Ž���� ������ ������ ��ȣ V
�� �־�����.

���� M���� �ٿ��� ������ �����ϴ� �� ������ ��ȣ�� �־�����.
�� ������ ������ �־��� ���� �ִµ�, ������ �ϳ��� �ִ� ������ �����ϸ� �ȴ�.
�Է����� �־����� ������ ������̴�.

[���]
ù° �ٿ� DFS�� ������ �����, �� ���� �ٿ��� BFS�� ������ ����� ����Ѵ�.
V���� �湮�� ���� ������� ����ϸ� �ȴ�.

[�Է� ����]
1
4 5 1 
1 2
1 3
1 4
2 4
3 4

[��� ����]
#1
1 2 4 3
1 2 3 4
 */
/*	�ؼ�
�Է°� / �ʿ䰪

����
��Ʈ��ŷ (��������)
- DFS
�������� (���� ������ �����?)
Y : ����
N : ����� ó��, ���簪 ���� & �ַ�� ó��
         ��� ȣ��
         �ǵ��ư��� or �ߺ��Ұ� ó�� (�̻�� ó��)
         
- BFS
Queue ����
�ʱ� ��ǥ ����, �ش� ��ǥ�� ���� ��� ó��
While - ���� ��ǥ �Է�
      - ��ǥ ��� (�� ���, Print)
        For -> �迭 ���� ���Ƽ� (���� Node �迭)
                                 ��������� ���� ���� Queue�� ���� (Ž�� ��ǥ ����)
                                 Ž�� ��ǥ ��� ó��
 */
package SWCert_ADV;

import java.io.*;
import java.util.*;

public class AD_B1260_DFSAndBFS_ArrayList {
	static int N, M, V;
	
	static ArrayList<Integer> adj[];
	static boolean Stat[];	//	������ ���� �湮 ���� Ȯ��
	
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