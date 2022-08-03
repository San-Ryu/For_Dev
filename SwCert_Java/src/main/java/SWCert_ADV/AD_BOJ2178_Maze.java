/*	BOJ2178 미로 탐색
[문제]
N × M 크기의 배열로 표현되는 미로가 있다.

1	0	1	1	1	1
1	0	1	0	1	0
1	0	1	0	1	1
1	1	1	0	1	1

미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 
이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오.
위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 

[제약 사항]
칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.

[입력]
첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 
다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 
각각의 수들은 붙어서 입력으로 주어진다.

[출력]
첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 
항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.

[입력 예시]
6
4 6
101111
101010
101011
111011
4 6
110110
110110
111111
111101
2 25
1011101110111011101110111
1110111011101110111011101
7 7
1011111
1110001
1000001
1000001
1000001
1000001
1111111
5 5
11100
10100
11111
00101
00111
5 5
11111
10001
10100
11100
01100

[출력 예시]

 */
/*	해석
입력값
- T : TestCase
- N, M : N X M 값
- Maze[][] : 미로 정보
- Ans : 결과값

필요값
- 방향배열 (상하좌우) 
  dx = {-1, 1, 0, 0}
  dy = {0, 0, -1, 1}
    대각선 포함시
  dx = {-1, -1, -1, 0, 0, 1, 1, 1}
  dy = {-1, 0, 1, -1, 1, -1, 0, 1}
- Stat[][] : 지나온 경로 체크를 위한 Stat 배열

절차
- 값 입력 및 초기화
- BFS를 위한 Queue 선언
 */
package SWCert_ADV;

import java.io.*;
import java.util.*;

public class AD_BOJ2178_Maze {
	static int N, M;
	static int Ans;
	
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	static int Map[][];
	static boolean Stat[][];
	
	static class Point{
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}	
	}	//	End Class Point
	
	public static void main(String args[])	throws Exception{
		System.setIn(new FileInputStream("Input (AD_BOJ2178_Maze).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= T; tc++) {
		//	Init. & Ipt
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			Ans = 0;
			
			Map = new int[N][M];
			Stat = new boolean[N][M];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				String tmp = st.nextToken();
				for(int j = 0; j < M; j++) {
					Map[i][j] = (int) tmp.charAt(j) - '0';
					if(Map[i][j] == 0)	Stat[i][j] = true;
				}
			}
		//	Init. & Ipt
			
		//	Oper
			Queue<Point> q = new LinkedList<>();
			q.add(new Point(0, 0));
			while(!q.isEmpty()) {
				int curx = q.peek().x;
				int cury = q.peek().y;
				q.poll();
				for(int i = 0; i < 4; i++) {
					int nx = curx + dx[i];
					int ny = cury + dy[i];
					
					if(nx < 0 || N <= nx || ny < 0 || M <= ny)	continue;
					
					if(Map[nx][ny] != 0 && !Stat[nx][ny]) {
						q.add(new Point(nx, ny));
						Map[nx][ny] = Map[curx][cury] + 1;
						Ans = Math.max(Ans, Map[nx][ny]);
						Stat[nx][ny] = true;
					}
				}
			}
		//	Oper
			
		//	Opt
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					System.out.print(Map[i][j] + "\t");
				}
				System.out.println();
			}
			System.out.println();
			System.out.println("#" + tc + " " + Ans);
		//	Opt
		}	//	End Test Case
		
		br.close();
		
	}	//	End Method Main	
}	//	End Class Main