/*	유니콘과 나이트
[문제]
나이트를 이동하면 위와 같은 좌표로 이동하여 폰을 잡을 수 있다.
(K - 나이트, 0 - 빈칸, 1 - 나이트의 이동)
0000000
0010100
0100010
000K000
0100010
0010100
0000000
<나이트의 이동>
나이트를 유니콘으로 업그레이드하면, 같은 방향으로 세번까지 이동이 가능하다.

0000000
0000000
0000000
0000010
0001000
0K00000
0000000
나이트를 이동하면 2번 이동하여 폰을 잡을 수 있지만,
업그레이드된 유니콘을 이동하면 그림과 같이 1번 이동하여 폰을 잡을 수 있다.

나이트를 이동하여 폰을 잡는 것보다 유니콘을 이동하여 폰을 잡는게 몇 번 덜 움직이는 것인지 구하라.
(유니콘 이동과 나이트 이동의 차이를 구하시오.)

[입력]
테스트 케이스
체스판 크기 / 유니콘 행 / 유니콘 열 / 폰 행 / 폰 열

[출력]
유니콘 이동 수와 나이트 이동 수의 차이

[입력 예시]
4
3 3 3 1 3
5 2 5 4 1
3 3 3 3 1
7 3 1 6 7

[출력 예시]
#1 0
#2 1
#3 0
#4 2
 */

/*
유니콘 이동 Method / 나이트 이동 Method를 따로 생성하는 것
두 Method를 공통으로 만들어서 사용하는 것
 */
package SWCert_ADV;

import java.io.*;
import java.util.*;

public class AD_EX181025_KnightNUnicorn {
	static int N;	//	체스판 한 변의 길이
	static int X, Y;	//	Knight & Unicorn Axis X, Y
	static int tX, tY;	//	Pawn Axis X, Y
	static int Board[][];	//	보드판 정보
	static int AnsN;	//	Result (이동 차이)
	
	static int KCnt, UCnt;
	static int dx[] = {1, 2, 2, 1, -1, -2, -2, -1};	//	1, 2, 4, 5, 7, 8, 10, 11
	static int dy[] = {-2, -1, 1, 2, 2, 1, -1, -2};
	
	static int BrdStat[][];
	static Queue<Integer> qX;	//	좌표값 X 저장을 위한 Queue
	static Queue<Integer> qY;	//	좌표값 Y 저장을 위한 Queue
	
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("Input (AD_EX181025_KnightNUnicorn).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= T; tc++) {
		//	Init.
			AnsN = KCnt = UCnt = 0;
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			X = Integer.parseInt(st.nextToken()) - 1;
			Y = Integer.parseInt(st.nextToken()) - 1;
			tX = Integer.parseInt(st.nextToken()) - 1;
			tY = Integer.parseInt(st.nextToken()) - 1;
		//	Init.
			
		//	Oper.
			qX = new LinkedList<>();	//	Declaration
			qY = new LinkedList<>();
			
			qX.add(X);	//	Init. X
			qY.add(Y);	//	Init. Y
			
			BrdStat = new int[N][N];	//	Init.
			Knight();
			
			qX.add(X);	//	Init. X
			qY.add(Y);	//	Init. Y
			BrdStat = new int[N][N];	//	Init.
			Unicorn();
			
			AnsN = KCnt - UCnt;
		//	Oper.
			
		//	Opt.
			System.out.println("#" + tc + " " + AnsN);
		//	Opt.
		}	//	End Test Case
	}	//	End Main Method
	
	public static void Knight(){
		while(!(qX.isEmpty() && qY.isEmpty())) {
			int curx = qX.poll();
			int cury = qY.poll();
			
			for(int i = 0; i < dx.length; i++) {
				int nx = curx + dx[i];
				int ny = cury + dy[i];
				
				if((nx < 0) || ((N - 1) < nx) || (ny < 0) || ((N - 1) < ny 
					|| (BrdStat[nx][ny] != 0)))	
					continue;
				
				BrdStat[nx][ny] = BrdStat[curx][cury] + 1;
				qX.add(nx);
				qY.add(ny);
				
				if(nx == tX && ny == tY) {
					KCnt = BrdStat[nx][ny];
					qX.clear();
					qY.clear();
					break;
				}
			}
		}
	}	//	End Knight Method
	
	public static void Unicorn() {
		while(!(qX.isEmpty() && qY.isEmpty())) {
			int curx = qX.poll();
			int cury = qY.poll();
			
			for(int i = 0; i < dx.length; i++) {
				int nx1 = curx + dx[i];
				int ny1 = cury + dy[i];
				
				if((nx1 < 0) || ((N - 1) < nx1) || (ny1 < 0) || ((N - 1) < ny1 
					|| (BrdStat[nx1][ny1] != 0)))	
					continue;
				//	Improve : BrdStat[nx1][ny1] != 0 부분이 생략되면, (방문했던 지점을 배제하지 않으면)
				//			  1) 제대로된 값이 나오지 않거나, (AnsN이 음수로 출력)
				//			  2) 시간 복잡도가 급격히 올라간다. (Time Out)
				//				 <가지치기의 중요성>
				
				BrdStat[nx1][ny1] = BrdStat[curx][cury] + 1;
				qX.add(nx1);
				qY.add(ny1);
				
				if((nx1 == tX) && (ny1 == tY)) {
					UCnt = BrdStat[nx1][ny1];
					qX.clear();
					qY.clear();
					break;
				}
				
				if((nx1 + dx[i] < 0) || ((N - 1) < nx1 + dx[i]) ||
				   (nx1 + dy[i] < 0) || ((N - 1) < ny1 + dy[i]) ||
				   (BrdStat[nx1 + dx[i]][ny1 + dy[i]] != 0))	continue;
				
				BrdStat[nx1 + dx[i]][ny1 + dy[i]] = BrdStat[curx][cury] + 1;
				qX.add(nx1 + dx[i]);
				qY.add(ny1 + dy[i]);
				
				if((((nx1 + dx[i]) == tX) && ((nx1 + dx[i]) == tY)))	{
					UCnt = BrdStat[nx1 + dx[i]][ny1 + dy[i]];
					qX.clear();
					qY.clear();
					break;
				}
				
				if((nx1 + (2 * dx[i]) < 0) || ((N - 1) < nx1 + (2 * dx[i])) ||
				   (nx1 + (2 * dy[i]) < 0) || ((N - 1) < ny1 + (2 * dy[i])) ||
				   (BrdStat[nx1 + (2 * dx[i])][ny1 + (2 * dy[i])] != 0))	continue;
				
				BrdStat[nx1 + (2 * dx[i])][ny1 + (2 * dy[i])] = BrdStat[curx][cury] + 1;
				qX.add(nx1 + (2 * dx[i]));
				qY.add(ny1 + (2 * dy[i]));
				
				if((((nx1 + (2 * dx[i])) == tX) && ((nx1 + (2 * dx[i])) == tY)))	{
					UCnt = BrdStat[nx1 + (2 * dx[i])][ny1 + (2 * dy[i])];
					qX.clear();
					qY.clear();
					break;
				}	
			}
		}
	}	//	End Unicorn Method
}	//	End Class