/* 반사경
[문제]
거울을 이용한 게임을 제작하려 한다.
거울은 2가지 방향만을 가지며, 양면 거울이다.
방향 1 : /
방향 2 : \
(0, 0)에서 오른쪽으로 레이저 빔이 출발할 때, 정사각형 격자 관 밖으로 나갈 때까지 몇 개의 거울에 레이저가 반사되는지 그 개수를 출력하는 프로그램을 작성하시오.
위 예제의 정답은 7이다.

[제약 사항]
1. 정사각형 격자 모양의 관에 대응되는 2차원 N x N 배열의 N은 5 이상 100 이하이다.
2. (0, 0)에는 거울이 없다.

[입력]
첫 줄에는 Test Case의 총 수가 주어진다.
그 다음 줄부터, Test Case가 주어지는데, 각 Test Case는 N + 1 줄로 구성된다.
각 Test Case의 첫째 줄에는 N이 주어지고, 다음 N 줄에는 N x N 배열이 주어진다.
N x N 배열에서 0은 아무것도 없는 공간을 나타내며, 1은 방향 1의 거울, 2는 방향 2의 거울을 나타낸다.

[출력]
출력의 각 줄은 "#T"로 시작해야하고, 공백을 하나 둔 다음 레이저가 도달하는 거울 수를 출력한다.
단, T는 Test Case 번호이다.

[입력 예시]
4
10
0 0 0 0 0 0 0 2 0 0
0 0 0 0 0 0 0 0 0 0 
0 0 0 0 1 2 0 0 0 1
0 0 0 0 0 0 0 0 0 0
0 0 0 0 1 0 0 1 0 0 
1 0 0 0 2 0 0 2 0 0 
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 2 0 0 0 0 1 0 0
0 0 0 0 0 0 0 0 0 0
5
0 2 0 0 0
0 0 0 0 0
0 2 0 1 0
2 0 0 1 0
0 2 0 0 0 
10
0 0 0 0 0 0 2 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 2 0 0 0 0 0 0
0 0 2 1 0 0 0 2 0 0
0 0 0 0 0 1 0 1 0 0
0 0 0 0 2 0 0 0 1 0
0 2 0 0 0 0 1 0 0 1
0 0 0 0 0 0 2 0 0 0
0 0 0 0 1 0 0 0 0 1 
0 0 2 0 0 0 0 0 0 1 
10
0 0 0 0 0 0 2 0 0 0 
0 0 0 0 0 0 0 2 0 1 
0 0 0 0 0 0 0 0 0 0
0 1 1 0 0 0 0 0 0 0
0 0 0 0 0 2 2 0 0 1
0 0 0 0 0 0 0 2 0 1 
0 0 0 2 1 0 2 0 2 0
0 0 0 0 0 1 0 0 0 0
0 0 0 0 0 0 0 0 0 1
0 1 0 0 0 0 0 0 0 0

[출력 예시]
#1 7
#2 3
#3 3
#4 4
 */
package SWCert_INT;

import java.util.Scanner;
import java.io.FileInputStream;

public class IM_Reflector {
	static int T, N;
	static int pX, pY;
	static int Brd[][];
	static char Flag;
	static int AnsN;
	
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("D:\\Redan_Workspace\\SWCert_Src\\Input (Reflector).txt"));
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			AnsN = 0;
			
		//	Ipt
			Brd = new int[N + 2][N + 2];
			for(int i = 0; i <= (N + 1); i++) {
				if(i == 0) {
					for(int j = 0; j <= (N + 1); j++) {
						Brd[i][j] = 0;
						//	System.out.print(Brd[i][j] + " ");
					}
				}				
				else if(i == (N + 1)){
					for(int j = 0; j <= (N + 1); j++) {
						Brd[i][j] = 0;
						//	System.out.print(Brd[i][j] + " ");
					}
				}
				else {
					for(int j = 0; j <= (N + 1); j++) {
						if(j == 0) {
						Brd[i][j] = 0;
						//	System.out.print(Brd[i][j] + " ");
						}
						else if(j == (N + 1)) {
							Brd[i][j] = 0;
						//	System.out.print(Brd[i][j] + " ");
						}
						else {
							Brd[i][j] = sc.nextInt();
						//	System.out.print(Brd[i][j] + " ");
						}
					}
				}
				//	System.out.println();
			}

		pX = pY = 1;
		Flag = 'D';
		//	IPT
		
		//	Moving
		while(true) {
			if( 0 == pX || pX == (N + 1) || 0 == pY || pY == (N + 1)) {
				break;
			}
			if(Flag == 'W') {
				pY--;
				if(Brd[pY][pX] == 1) {
					Flag = 'D';
					AnsN++;
					continue;
				}
				else if(Brd[pY][pX] == 2) {
					Flag = 'A';
					AnsN++;
					continue;
				}
				else {
					continue;
				}
			}
			if(Flag == 'A') {
				pX--;
				if(Brd[pY][pX] == 1) {
					Flag = 'S';
					AnsN++;
					continue;
				}
				else if(Brd[pY][pX] == 2) {
					Flag = 'W';
					AnsN++;
					continue;
				}
				else {
					continue;
				}
			}
			if(Flag == 'S') {
				pY++;
				if(Brd[pY][pX] == 1) {
					Flag = 'A';
					AnsN++;
					continue;
				}
				else if(Brd[pY][pX] == 2) {
					Flag = 'D';
					AnsN++;
					continue;
				}
				else {
					continue;
				}
			}
			if(Flag == 'D') {
				pX++;
				if(Brd[pY][pX] == 1) {
					Flag = 'W';
					AnsN++;
					continue;
				}
				else if(Brd[pY][pX] == 2) {
					Flag = 'S';
					AnsN++;
					continue;
				}
				else {
					continue;
				}
			}
		}	//	End While
		
		System.out.println("#" + test_case + " " + AnsN);
		}	//	End Test Case
	}	//	End Main
}	//	End Class