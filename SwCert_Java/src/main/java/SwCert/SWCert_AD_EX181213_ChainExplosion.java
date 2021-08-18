package SwCert;

import java.io.*;
import java.util.*;

/* 연쇄 폭발

[문제]
연구실 곳곳에 폭발물이 퍼져있다.
폭발물은 도화선에 점화된 후 일정 시간 뒤에 폭발하며, 도화선의 길이는 폭발물마다 다르다.
폭발물이 폭발할 경우, 맵 기준 상하좌우에 있는 폭발물의 도화선에 불을 붙이며, 이는 연쇄 폭발로 이어진다.

연쇄 폭발이 끝났음에도 폭발물이 연구실 내부에 남아있는 경우,
연구실 내의 모든 폭발물의 도화선에 불이 붙어, 모든 폭발물이 폭발한다.

폭발물 연구자는 일정량의 폭탄에 불을 붙이고, 연쇄 폭발을 일으키는 실험을 진행하고 있다.
폭발물에 불을 붙이고 나서, 연구실의 모든 폭발물이 폭발할 때까지 걸리는 시간을 출력하는 프로그램을 작성하시오.

다음과 같은 예를 들었을 때,
1   0  (3)  4	-> 소괄호 폭발물 : 실험 시작시 점화되는 폭발물 
0   0   2   4 
5   7   5   3 
7   2   3   8

3초가 지난 시점에서, 지정된 폭발물이 폭발하게 되고,
4, 1 지점의 폭발물 (4)와
3, 2 지점의 폭발물 (2)의 도화선에 불이 붙는다.

1   0  (3) {4}	-> 소괄호 폭발물 : 실험 시작시 점화되는 폭발물  
0   0  {2}  4 	-> 중괄호 폭발물 : 연쇄 폭발물
5   7   5   3 
7   2   3   8

2차 폭발이 일어난 후의 폭발은 다음과 같다.

1   0  (3) {4}	-> 소괄호 폭발물 : 실험 시작시 점화되는 폭발물  
0   0  {2} [4] 	-> 중괄호 폭발물 : 2차 폭발물
5   7  [5]  3	-> 대괄호 폭발물 : 3차 폭발물 
7   2   3   8

[입력]
T
N M MX MY Map[][]

[출력]
#T AnsN
AnsN은 폭발에 걸리는 총 시간.

[입력 예시]
5
4 1 1 3 1 0 3 4 0 0 2 4 5 7 5 3 7 2 3 8
4 2 1 1 3 3 1 0 2 3 0 0 4 5 6 7 8 9 10 11 12 13
4 1 1 1 10 0 1 2 0 0 3 4 5 6 7 8 9 10 11 12 
8 1 1 1 1 0 1 0 1 0 1 0 0 1 0 1 0 1 0 1 1 0 1 0 1 0 1 0 0 1 0 1 0 1 0 1 1 0 1 0 1 0 1 0 0 1 0 1 0 1 0 1 1 0 1 0 1 0 1 0 0 1 0 1 0 1 0 1
4 1 1 1 1 1 1 0 0 1 1 0 0 1 1 0 0 1 1 1 1 1
//또는
5
4 1 1 3 1 0 3 4 0 0 2 4 5 7 5 3 7 2 3 8
4 2 1 1 3 3 1 0 2 3 0 0 4 5 6 7 8 9 10 11 12 13
4 1 1 1 10 0 1 2 0 0 3 4 5 6 7 8 9 10 11 12 
8 1 1 1 
1 0 1 0 1 0 1 0
0 1 0 1 0 1 0 1
1 0 1 0 1 0 1 0
0 1 0 1 0 1 0 1
1 0 1 0 1 0 1 0
0 1 0 1 0 1 0 1
1 0 1 0 1 0 1 0
0 1 0 1 0 1 0 1
4 1 1 1 1 1 1 0 0 1 1 0 0 1 1 0 0 1 1 1 1 1

[출력 예시]
#1 23	//	일반적인 경우
#2 42	//	2개의 폭발물, 하나만 연쇄 폭발을 일으킴.
#3 22	//	1개의 폭발물, 연쇄 폭발이 일어나지 않음.
#4 20	//	1개의 폭발물, 연쇄 폭발이 일어나지 않음.
#5		//	One-Way
 */
public class SWCert_AD_EX181213_ChainExplosion {
//사이트 제출 시에는 반드시 Class명을 Main으로 지정해야함
//public class Main{
	static int N, M;	//	배열의 한 변 N, 폭발 시작점의 개수 M
	// static int X[], Y[];	//	폭발 시작점의 X, Y	(사용하지 않고, ArrayList로 대체함)
	static int Map[][];	//	맵 정보 (배치된 폭탄의 도화선)
	static int AnsN;	//	결과값
	
	static int Stat[][];	//	폭발 시점을 위한 Visited
	static int SumTime, SumRemain;	//	연쇄 폭발의 시간, 연쇄 폭발 이후의 일제 점화(및 폭발 종료)
	
	static int dx[] = {-1, 0, 0, 1};	//	사방탐색 배열 X
	static int dy[] = {0, -1, 1, 0};	//	사방탐색 배열 Y
	
	static ArrayList<Integer> arrx;	//	폭발 예정인 폭탄의 X좌표
	static ArrayList<Integer> arry;	//	폭발 예정인 폭탄의 X좌표
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("Input (AD_EX181213_ChainExplosion).txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
		//	Ipt.
			AnsN = 0;
			SumTime = 0;
			SumRemain = 0;
			
			N = sc.nextInt();
			M = sc.nextInt();
			
			Stat = new int[10][10];
			arrx = new ArrayList<>();
			arry = new ArrayList<>();
			//	Caution : 문제에서는 (1, 1) ~ (N, N)의 좌표계를 입력했으나,
			//			  (0, 0) ~ (N - 1, N - 1) 좌표계가 익숙하여 변경하여 사용됨
			//			   또한, 문제에서는 배열상 Map[Y][X] 좌표계를 사용했으나,
			//			  Map[X][Y] 좌표계가 익숙하여 변경하여 사용됨.
			for(int i = 0; i < M; i++) {
//				X[i] = sc.nextInt();
//				Y[i] = sc.nextInt();
				
				int tmpx = sc.nextInt() - 1;
				int tmpy = sc.nextInt() - 1;
				//	(N - 1) 좌표계로 변환
				arrx.add(tmpx);
				arry.add(tmpy);
				Stat[tmpx][tmpy] = 1;
			}
			
			Map = new int[10][10];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					Map[i][j] = sc.nextInt();
					
					if(Stat[i][j] == 1) {
						Stat[i][j] = Map[i][j];
					}
					System.out.print(Map[i][j] + " ");
				}
				System.out.println();
			}
			
		//	Ipt.
			
			while(!(arrx.isEmpty() && arry.isEmpty())) {
				//	폭발 종료 시점에 따라 정렬 (폭발물이 "터질" 시점에 따라 정렬했습니다.)
				for(int i = 0; i < M; i++) {
					for(int j = 1; j < M; j++) {
						if(Stat[arrx.get(i)][arry.get(i)] < Stat[arrx.get(j)][arry.get(j)]);
						int tmpx = arrx.get(i);
						int tmpy = arry.get(i);
						
						arrx.set(i, arrx.get(j));
						arry.set(i, arry.get(j));
						arrx.set(j, tmpx);
						arry.set(j, tmpy);
					}
				}
				//	폭발 종료 시점에 따라 정렬

				int tmp = arrx.size();
				for(int i = 0; i < tmp; i++) {
					//	기준 좌표 입력
					int cx = arrx.get(i);
					arrx.remove(i);
					int cy = arry.get(i);
					arry.remove(i);
					
					//	ArrayList의 Element들을 원하는만큼만 사용하기 위함.
					i--;
					tmp--;
					
					for(int j = 0; j < dx.length; j++) {
						//	탐색 좌표 입력
						int nx = cx + dx[j];
						int ny = cy + dy[j];
						
						//	맵 밖으로 벗어나는 경우 제외
						if(nx < 0 || (N - 1) < nx || ny < 0 || (N - 1) < ny)	continue;
						//	폭발물이 없는 경우 제외
						if(Map[nx][ny] == 0)	continue;
						
						if(Stat[nx][ny] == 0) {	//	최초 방문인 경우
							Stat[nx][ny] = Stat[cx][cy] + Map[nx][ny];
							arrx.add(nx);
							arry.add(ny);
						}
						else if(Stat[nx][ny] != 0) {
							Stat[nx][ny] = Math.min(Stat[nx][ny], Stat[cx][cy] + Map[nx][ny]);
						}
					}
				}
				
//				for(int i = 0; i < N; i++) {
//					for(int j = 0; j < N; j++) {
//						System.out.print(Stat[i][j] + " ");
//					}
//					System.out.println();
//				}
//				System.out.println("==================");
				
			}	//	End Chain Explosion
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(Stat[i][j] != 0) {	//	폭발한 폭발물
						SumTime = Math.max(SumTime, Stat[i][j]);
					}
				}
			}	//	Calc. Chain Explosion
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if((Stat[i][j] == 0) && (Map[i][j] != 0)) {	//	폭발하지 않은 폭발물
						SumRemain = Math.max(SumRemain, Map[i][j]);
					}
				}
			}	//	Calc. Remain Explosive
			
			AnsN = SumTime + SumRemain;
			//	Calc. AnsN
			
		//	Opt.

//			for(int i = 0; i < N; i++) {
//				for(int j = 0; j < N; j++) {
//					System.out.print(Map[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println("=================="); 

//			for(int i = 0; i < N; i++) {
//				for(int j = 0; j < N; j++) {
//					System.out.print(Stat[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println("==================");

//			System.out.println(SumTime + " / " + SumRemain);
			System.out.println("#" + tc + " " + AnsN);
		//	Opt.
		}	//	End Test Case
	}	//	End Main
}	//	End Class