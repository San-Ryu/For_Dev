/* Jung 1695 ���� ��ȣ ���̱�
[����]
���簢�� ����� ������ �ִ�.
1�� ���� �ִ� ����, 0�� ���� ���� ���� ��Ÿ����

ö���� �� ������ ������ ����� ������ ������ ������ �����ϰ�, ������ ��ȣ�� ���̷� �Ѵ�.
���⼭ ����Ǿ��ٴ� ���� � ���� �¿� Ȥ�� �Ʒ����� �ٸ� ���� �ִ� ��츦 ���Ѵ�.
�밢���� �ִ� ��쿡�� ����� ���� �ƴϴ�.

[�Է�] 
���� Test Case�� ���� T�� �־�����,
���� �ٺ��� T���� Test Case�� �־�����.
Test Case�� ù �ٿ��� ������ ũ�� N�� �־�����,
�� ���� N�ٿ��� N���� �ڷ�(0 Ȥ�� 1)�� �Էµȴ�.
(��, 5 <= N <= 25)

[���]
�� Test Case�� ���Ͽ�, #T�� ����ϰ�, ������ �ϳ� �� ����,
�� ���� ���� ����Ͻÿ�.
�׸���, �ι�° �ٿ��� �� ���� �� ���� ���� ������������ �����Ͽ� �ϳ��� ������ �ξ� ����Ͻÿ�.

[�Է� ����]
1
6
101100
101111
001001
100000
101110
101010

[��� ����]
#1 7 
1 1 1 3 4 4 5
*/
package SWCert_ADV;

import java.io.*;
import java.util.*;

public class AD_BFS_ComplexNumbering_VerBaekjoon {
	static class Pair{
		int x;
		int y;
		
		Pair(int a, int b){
			y = a;
			x = b;
		}
	}	//	End Class st
	
	public class Main{
		public static final int[] dx = {0, 0, 1, -1};
		public static final int[] dy = {1, -1, 0, 0};
		public void BFS(int[][] a, int[][] group, int x, int y, int cnt, int n) {
			Queue<Pair> q = new LinkedList<Pair>();
			q.add(new Pair(x, y));
			group[x][y] = cnt;
			while(!q.isEmpty()) {
				Pair p = q.remove();
				x = p.x;
				y = p.y;
				
				for(int k = 0; k < 4; k++) {
					int nx = x + dx[k];
					int ny = x + dy[k];
					
					if(0 <= nx && nx < n && 0 <= ny && ny < n) {
						if(a[nx][ny] == 1 && group[nx][ny] == 0) {
							q.add(new Pair(nx, ny));
						}
					}
				}
			}
			
		}
	}
	
	public static void main(String args[]) throws Exceptions{
	}
		System.setIn(new FileInputStream("Input (AD_Complex).txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			char Cpx[][] = new char[N + 10][N + 10];
			Queue<st> Queue = new st[(N*10) + (N * 10)];
			int AnsN[] = new int[N * N];
			
			for(int i = 1; i <= N; i++) {
				Cpx[i] = ("\0" + sc.next()).toCharArray();
			}
			
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(Cpx[i][j] == '0') continue;
					AnsN[region] = BFS(i, j);
					region++;
				}
			}
			
			// �ܼ� ���� (��������)
			for(int i = 0; i < region; i++) {
				for(int j = i + 1; j < region; j++) {
					if(AnsN[i] > AnsN[j]) {
						int tmp = AnsN[i];
						AnsN[i] = AnsN[j];
						AnsN[j] = tmp;
					}
				}
			}
			
			System.out.println("#" + test_case + " " + region);
			for(int i = 0; i < region; i++) {
				System.out.print(AnsN[i] + " ");
			}
		}
	}
}	//	End Main
