/*	토마토_BOJ7576
[문제]
철수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다. 
토마토는 아래의 그림과 같이 격자 모양 상자의 칸에 하나씩 넣어서 창고에 보관한다. 

창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 
아직 익지 않은 토마토들도 있을 수 있다. 
보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다. 
하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미한다. 
대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로 익는 경우는 없다고 가정한다. 
철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다.

토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때, 
며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라. 
단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.

[입력]
첫 줄에는 상자의 크기를 나타내는 두 정수 M,N이 주어진다. M은 상자의 가로 칸의 수, N 은 상자의 세로 칸의 수를 나타낸다. 단, 2 ≤ M,N ≤ 1,000 이다. 둘째 줄부터는 하나의 상자에 저장된 토마토들의 정보가 주어진다. 즉, 둘째 줄부터 N개의 줄에는 상자에 담긴 토마토의 정보가 주어진다. 하나의 줄에는 상자 가로줄에 들어있는 토마토의 상태가 M개의 정수로 주어진다. 정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다. 

[출력]
여러분은 토마토가 모두 익을 때까지의 최소 날짜를 출력해야 한다. 만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고, 토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.

[입력 예시]
7
6 4
1 1 0 1 1 1
0 1 0 1 0 1
0 1 0 1 0 1
0 1 1 1 0 1
6 4
0 -1 0 0 0 0
-1 0 0 -1 0 0
0 0 -1 0 0 0
0 -1 0 -1 0 1
6 4
1 -1 0 0 0 0
0 -1 0 0 0 0
0 0 0 0 -1 0
0 0 0 0 -1 1
5 5
-1	 1	 0	 0	0
 0	-1	-1	-1	0
 0	-1	-1	-1	0
 0	-1	-1	-1	0
 0	0	 0	 0	0
2 2
1 -1
-1 1
6 6
0 0 0 0 0 0
0 0 0 0 0 0
0 0 -1 0 0 0
0 0 0 -1 0 0
0 0 0 0 0 0
0 0 0 0 0 0
3 3
1 -1 0
-1 -1 0
0 0 1

[출력 예시]
#1 1
#2 -1
#3 6
#4 14
#5 0
#6 -1
#7 2
 */
/*
방향이 지정된 경우가 있을 수 있음 (오른쪽으로만 또는 아래쪽으로만 등등)
상하좌우 방향으로 지정된 경우
대각선까지 8방향 가능한 경우

8방향으로 X, Y좌표로 표현하는 방법
X - 1, Y - 1
X - 1, Y
X - 1, Y + 1 등...
은 코드가 너무 길어짐

x, y
(x, y + 1) -> 증가치 : (0 , 1)

static int x[] = {0, 1, 0, -1}
static int y[] = {1, 0, -1, 0}

이를	static int x[] = {0, 0, 1, -1}
	static int y[] = {1, -1, 0, 0}	으로 외워도 무관

static class Node{
	int x, y;
	public new(int x, int y){
		this.x = x;
		this.y = y;
	}
}

범위 제한
if(curx < 1 || cury < 1 || N < curx || n < cury)	continue;

for(int k = 0; k < 4; k++){
int nx = curx + dx[i];
int ny = cury + dy[i];
}
 */

/*	해석
입력값
- T : Test Case
- M, N : M X N 값
- Box[][] : 토마토 정보 (숙성 여부)
- Ans : 결과값

필요값
- 방향배열 (상하좌우) 
  dx = {-1, 1, 0, 0}
  dy = {0, 0, -1, 1}
    대각선 포함시
  dx = {-1, -1, -1, 0, 0, 1, 1, 1}
  dy = {-1, 0, 1, -1, 1, -1, 0, 1}
  
절차
- Ipt. & Init.
- BFS 선언
    안익은 토마토 위치를 Queue에 저장
- BFS 종료조건 선언 : q.isEmpty() -> 더이상 탐색할 숫자가 없는 경우
  q에 저장된 x, y값 호출 및 Head값 삭제
  -> 사방탐색 범위 내에 있는가?
     Box값이 유효한가? (안익음 = 0)
     -> 조건 만족시 만족하는 좌표의 값을 q에 추가한 후, 이동수치 +1 (탐색 기준점 +1)
                  불만족시 Pass & continue
 */
package SWCert_ADV;

import java.io.*;
import java.util.*;

public class AD_BFS_BOJ7576_Tomato {
	static int M, N;
	static int Box[][];
	static int Ans;
	
	static boolean Flag;
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	
	static class Point{
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("Input (AD_BFS_BOJ7576_Tomato).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= T; tc++) {
		//	Init. & Ipt.
			Ans = 0;
			Flag = false;
			
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			Box = new int[N][M];
			Queue<Point> q = new LinkedList<>();
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++) {
					Box[i][j] = Integer.parseInt(st.nextToken());
					if(Box[i][j] == 1)	q.add(new Point(i, j));
				}
			}
		//	Init. & Ipt.
			
		//	Oper.
			while(!q.isEmpty()) {
				int Curx = q.peek().x;
				int Cury = q.peek().y;
				q.poll();
				
				for(int i = 0; i < 4; i++) {
					int nx = Curx + dx[i];
					int ny = Cury + dy[i];
					
					if(nx < 0 || N <= nx || ny < 0 || M <= ny)	continue;
					
					if(Box[nx][ny] == 0) {
						q.add(new Point(nx, ny));
						Box[nx][ny] = Box[Curx][Cury] + 1;
					}
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					Ans = Math.max(Ans,  Box[i][j]);
					if(Box[i][j] == 0)	Flag = true;
				}
			}
			
			if(Flag)	Ans = -1;
			if(0 < Ans) Ans--;	//	일 수를 맞추기 위함.
		//	Oper.
			
		//	Opt.
			System.out.println("#" + tc + " " + Ans);
		//	Opt.
		}	//	End Test Case
	}	//	End Main
}	//	End Class