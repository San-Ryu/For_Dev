/*	���� ����
[����]
DAG(Directed Acyclic Graph)�� ���׼��� �ִ� �������� �̷���� �׷��� ��, ����Ŭ�� ���� �׷����� �ǹ��Ѵ�. 
DAG������ �׻� ���� ������ �� �� �ִ�.

DAG�� �־��� ��, ���� ������ �ϴ� ���α׷��� �ۼ��Ͻÿ�.

[���� ����]
1) �ð� ���� 1.5 Sec
2) �޸� ���� 512 MB

[�Է�]
ù ��° �ٿ� �׷����� ���� ���� V, ���� ���� E�� �������� �и��Ǿ� �־�����. 
(1 <= V <= 50,000 / 1 <= E <= 100,000)
�ι�° �ٺ��� E���� �ٿ� ���� �� ������ ������ x, y�� �������� �и��Ǿ� �־�����.
�̴� x���� ����Ͽ� y�� �����ϴ� ���� ������ �����Ѵٴ� ���� �ǹ��Ѵ�.
(1 <= x, y <= V / x != y)

�־����� �׷����� �׻� DAG�̰�, 1������ ������ ������ ����.

[���]
ù��° �ٿ� ���� ������ ����� ����Ѵ�.
���� ���������� ���, �� �� �ƹ� ���̳� ����Ѵ�.

[�Է� ����]
4 4
1 2
1 3
2 4
3 4

[��� ����]
1 2 3 4 Ȥ��
1 3 2 4

 */
package SWCert_ADV;

import java.io.*;
import java.util.*;

//	koitp ����� Class��
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