/*	장기_JO1106_CX3546(CodeEx)
[문제]
N x M 장기판에 졸 한개와 말 한개가 놓여있다.
말의 이동 방향이 다음과 같다고 할 때,
말이 최소의 이동 횟수로 졸을 잡으려 한다.

000000000
000000000
000101000
001000100
0000H0000
001000100
000101000
000000000
000000000
말이 졸을 잡기 위한 최소 이동 횟수를 구하는 프로그램을 작성하시오.

[제약사항]
1) 시간 제한 : 1.0 [Sec]
2) 메모리 제한 : 128 [MB]

[입력]
첫 줄은 장기판의 행의 수(N)와 열의 수(M)를 받는다.
둘째 줄은 말이 있는 위치의 행(R), 열(C)의 수와 졸이 있는 위치의 행(S), 열(K)의 수를 입력 받는다.
단, 장기판의 제일 왼쪽 위의 위치가 (1, 1)이다.
(단, 1<= N, M <= 100
 1 <= R <= N
 1 <= C <= M
 1 <= K <= M)

[출력]
말이 졸을 잡기 위한 최소 이동 횟수를 출력한다.

[입력 예시]
2
9 9
3 5 2 8 
9 9 
3 5 3 5 

[출력 예시]
#1 2
#2 0
 */
/*
2D Array 선언을 하지 않고 풀어볼 수 있을까?
 */
package SWCert_ADV;

import java.io.*;
import java.util.*;

public class AD_JO1106_Janggi {
	static int N, M;	//	판의 크기
	static int hx, hy;	//	Horse(말)의 좌표
	static int tx, ty;	//	Target(졸)의 좌표
	static int Degree;	//	결과값 (움직임 횟수)
	
	static int dx[] = {1, 2, 2, 1, -1, -2, -2, -1};	//	말의 움직임 (1-2-4-5-7-8-10-11)
	static int dy[] = {-2, -1, 1, 2, 2, 1, -1, -2};	//	(상단 좌측으로부터 시계방향)
	
	static class Point{
		int x, y, Degree;	//	Axis X, Axis Y, Degree
		
		public Point(int x, int y, int Degree) {
			this.x = x;
			this.y = y;
			this.Degree = Degree;
		}
	}	//	End Class Point
	
	public static void main(String args[]) throws Exception{		
		System.setIn(new FileInputStream(""));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= T; tc++) {
		//	Init. & Ipt.
			Degree = 0;
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			hx = Integer.parseInt(st.nextToken());
			hy = Integer.parseInt(st.nextToken());
			tx = Integer.parseInt(st.nextToken());
			ty = Integer.parseInt(st.nextToken());
			
			Queue<Point> q = new LinkedList<>();
		//	Init. & Ipt.			
			
		//	Oper.
		//	Degree를 어디서 ++해야할까?
			q.add(new Point(hx, hy, Degree));
			while(true) {
				int Curx = q.peek().x;
				int Cury = q.peek().y;
				int Degree = q.peek().Degree;
				q.poll();
				
				if(Curx == tx && Cury == ty)	break;
				
				for(int i = 0; i < 8; i++) {
					int nx = Curx + dx[i];
					int ny = Cury + dy[i];
					int nd = Degree + 1;
					
					if(nx < 1 || ny < 1 || N < nx || M < ny)	continue;
					
					q.add(new Point(nx, ny, nd));
					
					if(nx == tx && ny == ty)	break;	// While 종료조건에 달아도 된다.
				}
			}
		//	Oper.
		//	Opt.
			System.out.println("#" + tc + " " + Degree);
		//	Opt.
		}	//	End Test Case
	}	//	End Main
}	//	End Class