/*	탈출
[문제]
사악한 암흑의 군주 이민혁은 드디어 마법 구슬을 손에 넣었고, 
그 능력을 실험해보기 위해 근처의 티떱숲에 홍수를 일으키려고 한다. 

이 숲에는 고슴도치가 한 마리 살고 있다. 
고슴도치는 제일 친한 친구인 비버의 굴로 가능한 빨리 도망가 홍수를 피하려고 한다.

티떱숲의 지도는 R행 C열로 이루어져 있다. 
비어있는 곳은 '.'로 표시되어 있고, 
물이 차있는 지역은 '*', 
돌은 'X'로 표시되어 있다. 
비버의 굴은 'D'로, 
고슴도치의 위치는 'S'로 나타내어져 있다.

매 분마다 고슴도치는 현재 있는 칸과 인접한 네 칸 중 하나로 이동할 수 있다. (위, 아래, 오른쪽, 왼쪽)
물도 매 분마다 비어있는 칸으로 확장한다. 
물이 있는 칸과 인접해있는 비어있는 칸(적어도 한 변을 공유)은 물이 차게 된다. 
물과 고슴도치는 돌을 통과할 수 없다. 
또, 고슴도치는 물로 차있는 구역으로 이동할 수 없고, 
물도 비버의 소굴로 이동할 수 없다.

티떱숲의 지도가 주어졌을 때, 고슴도치가 안전하게 비버의 굴로 이동하기 위해 필요한 최소 시간을 구하는 프로그램을 작성하시오.

고슴도치는 물이 찰 예정인 칸으로 이동할 수 없다. 
즉, 다음 시간에 물이 찰 예정인 칸으로 고슴도치는 이동할 수 없다. 
이동할 수 있으면 고슴도치가 물에 빠지기 때문이다. 

[입력]
첫째 줄에 50보다 작거나 같은 자연수 R과 C가 주어진다.

다음 R개 줄에는 티떱숲의 지도가 주어지며, 문제에서 설명한 문자만 주어진다. 
'D'와 'S'는 하나씩만 주어진다.

[출력]
첫째 줄에 고슴도치가 비버의 굴로 이동할 수 있는 가장 빠른 시간을 출력한다. 만약, 안전하게 비버의 굴로 이동할 수 없다면, "KAKTUS"를 출력한다.

[입력 예시]
5
3 3
D.*
...
.S.
3 3
D.*
...
..S
3 6
D...*.
.X.X..
....S.
5 4
.D.*
....
..X.
S.*.
....
[출력 예시]
3
KAKTUS
6
4
KAKTUS

 */
package SWCert_ADV;

import java.io.*;
import java.util.*;

public class AD_BOJ3055_Escape {
	static int N, M;
	static char Map[][];
	static int AnsN;
	
	static boolean Flag;	//	도착 여부
	static boolean Stat[][];
	static int dx[] = {-1, 0, 0, 1};
	static int dy[] = {0, -1, 1, 0};
	
	static Queue<Integer> qs;
	static Queue<Integer> qwx;
	static Queue<Integer> qwy;
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("Input (AD_BOJ3055_Escape).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= T; tc++) {
		//	Ipt.
			AnsN = 0;
			Flag = false;
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			Map = new char[N][M];
			qs = new LinkedList<>();
			qwx = new LinkedList<>();
			qwy = new LinkedList<>();
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				String tmp = st.nextToken();
				
				for(int j = 0; j < M; j++) {
					if(tmp.charAt(j) == 'S') {
						qs.add(i);
						qs.add(j);
						qs.add(0);
						Map[i][j] = '.';
						continue;
					}
					
					else if(tmp.charAt(j) == '*') {
						qwx.add(i);
						qwy.add(j);
					}
					
					Map[i][j] = tmp.charAt(j);
					
				}
			}
			
			Stat = new boolean[N][M];
		//	Ipt.

			//	진행
			while(!qs.isEmpty()) {
			//	물 먼저 차오름
				int tmp = qwx.size();
				for(int i = 0; i < tmp; i++) {
					int cx = qwx.poll();
					int cy = qwy.poll();
					
					for(int j = 0; j < dx.length; j++) {
						int nx = cx + dx[i];
						int ny = cy + dy[i];
						
						if(nx < 0 || (N - 1) < nx || ny < 0 || (M - 1) < ny)	continue;
						if(Map[nx][ny] == 'X') continue;
						if(Map[nx][ny] == '.') {
							qwx.add(nx);
							qwy.add(ny);
							Map[nx][ny] = '*';
						}
					}
				}
				
			//	고슴도치의 이동
				int cx = qs.poll();
				int cy = qs.poll();
				int cm = qs.poll();
				
				for(int i = 0; i < dx.length; i++) {
					int nx = cx + dx[i];
					int ny = cy + dy[i];
					
					if(nx < 0 || (N - 1) < nx || ny < 0 || (M - 1) < ny)	continue;
					if(Map[nx][ny] == 'X') continue;
					
					if(Map[nx][ny] == '.' && !Stat[nx][ny]) {
						qs.add(nx);
						qs.add(ny);
						qs.add(cm + 1);
						Stat[nx][ny] = true;
					}
					else if(Map[nx][ny] == 'D') {
						if(AnsN == 0)	AnsN = cm + 1;
						else AnsN = Math.min(AnsN, cm + 1);
						Flag = true;
					}
				}
			}
			
		//	Opt.
			if(!Flag) {
				System.out.println("#" + tc + " " + "KAKTUS");
				continue;
			}
			
			System.out.println("#" + tc + " " + AnsN);
		//	Opt.
		}	//	End Test Case
	}	//	End Main
}	//	End Class