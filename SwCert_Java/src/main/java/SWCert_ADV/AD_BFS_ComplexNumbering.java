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

public class AD_BFS_ComplexNumbering {
	static int T, N;
	static char[][] Cpx;
	static int[] AnsN;
	static int region = 0;
	
	static class st{
		int x;
		int y;
		
		st(int a, int b){
			y = a;
			x = b;
		}
	}	//	End Class st
	
	static st Queue[];
	static int Wp, Rp;
	
	static void In_Queue(int y, int x) {
		Queue[Wp++] = new st(y, x);
	}	//	End in_Queue
	
	static st Out_Queue() {
		return Queue[Rp++];
	}	//	End Out_Queue
	
	
	static int BFS(int sY, int sX) {
		In_Queue(sY, sX);
		int count = 1;
		Cpx[sX][sY] = '0';
		
		while(Wp > Rp) {
			st out = Out_Queue();
			
			int dY[] = {1, 0, 0, -1};
			int dX[] = {0, 1, -1, 0};
			
			for(int k = 0; k < 4; k++) {
				int nY = out.y + dY[k];
				int nX = out.x + dX[k];
				
				if(nY > N || nY < 1 || nX > N || nX < 1) continue;
				if(Cpx[nY][nX] == '0') continue;
				
				In_Queue(nX, nY);
				count++;
				Cpx[nY][nX] = '0';
			}
		}
		return count;
	}	//	End BFS
	
	public static void main(String args[]) throws FileNotFoundException{
		System.setIn(new FileInputStream("Input (AD_Complex).txt"));
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			Cpx = new char[N + 10][N + 10];
			Queue = new st[(N*10) + (N * 10)];
			AnsN = new int[N * N];
			
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
