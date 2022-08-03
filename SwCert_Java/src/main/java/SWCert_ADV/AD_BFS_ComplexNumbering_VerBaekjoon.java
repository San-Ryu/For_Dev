/* Jung 1695 단지 번호 붙이기
[문제]
정사각형 모양의 지도가 있다.
1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다

철수는 이 지도를 가지고 연결된 집들의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다.
여기서 연결되었다는 것은 어떤 집이 좌우 혹은 아래위로 다른 집이 있는 경우를 말한다.
대각선상에 있는 경우에는 연결된 것이 아니다.

[입력] 
최초 Test Case의 개수 T가 주어지며,
다음 줄부터 T개의 Test Case가 주어진다.
Test Case의 첫 줄에는 지도의 크기 N이 주어지며,
그 다음 N줄에는 N개의 자료(0 혹은 1)가 입력된다.
(단, 5 <= N <= 25)

[출력]
각 Test Case에 대하여, #T를 출력하고, 공백을 하나 둔 다음,
총 단지 수를 출력하시오.
그리고, 두번째 줄에는 각 단지 내 집의 수를 오름차순으로 정렬하여 하나씩 공백을 두어 출력하시오.

[입력 예시]
1
6
101100
101111
001001
100000
101110
101010

[출력 예시]
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
			
			// 단순 정렬 (오름차순)
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
