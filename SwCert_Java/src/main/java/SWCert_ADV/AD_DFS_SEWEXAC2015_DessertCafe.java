/*
1
4
9 8 9 8 
4 6 9 4
8 7 7 8
4 5 3 5

6

 */
package SWCert_ADV;

import java.io.*;
import java.util.*;

public class AD_DFS_SEWEXAC2015_DessertCafe {
	static int N;	//	���� �� �� ����
	static int Map[][];	//	��
	static int AnsN;	//	�����

	static int Flag;	//	������ ���� �Լ�
	static boolean DessertStat[], FlagStat[];	//	����Ʈ �ߺ� ����, �밢�� 4���⿡ ���� �ߺ� ����
	static int dx[] = {1, 1, -1, -1};	//	ī�� �̵��� ����
	static int dy[] = {-1, 1, 1, -1};
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream(""));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= T; tc++) {
		//	Init. & Ipt.
			AnsN = Flag = 0;
			FlagStat = new boolean [4];	//	�밢�� 4�����̹Ƿ�
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
		
			Map = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				for(int j = 0; j < N; j++) {
					Map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		//	Init. & Ipt.
			
		//	Oper.
			for(int x = 0; x < N; x++) {
				for(int y = 0; y < N; y++) {
					
					DessertStat[Map[x][y]] = true;
					DFS(x, y, Map[x][y]);
					DessertStat[Map[x][y]] = false;
				}
			}
		//	Oper.
			
		//	Opt.
		//	Opt.			
		}	//	End Test Case
	}	//	End Main
	
	public static void DFS(int x, int y, int n) {
		
		if(((x == 0) && (y == 0))	||	//	(0, 0)�̰ų� (N - 1, N - 1)�̰ų�
		   ((x == 0) && (y == (N - 1)))	||
		   ((x == (N - 1)) && (y == 0))	||
		   ((x == (N - 1)) && (y == (N - 1))))	continue;

		
		
	}	//	End DFS
}	//	End Class


/*
		for(int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
		}
*/