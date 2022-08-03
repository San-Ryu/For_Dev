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

public class AD_B1260_DFSAndBFS_2DArrayMatching {
	static int N, M, V;
	
	static int Line[][];
	static int Stat[];	//	������ ���� �湮 ���� Ȯ��
	
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream(""));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int i = 1; i <= T; i++) {
		//	Init. & Ipt.
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());
			
			Stat = new int[N];
					
			Line = new int [M][2];
			for(int ii = 0; ii < M; ii++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 2; j++) {
					Line[ii][j] = Integer.parseInt(st.nextToken());
				}
			}
		//	Init. & Ipt.
		
		//	Oper.
			DFS(1);
			BFS(1);
		//	Oper.
		
		//	Opt.
		//	Opt.
		}	//	End Test Case
	}	//	End Main Method
	
	public static void DFS(int n) {
		
	}	//	End DFS Method
	
	public static void BFS(int n) {
		
	}	//	End BFS Method
}	//	End Class