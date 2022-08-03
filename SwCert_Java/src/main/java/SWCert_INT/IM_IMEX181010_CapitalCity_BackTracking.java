/*	수도 위치 선정
[문제]
당신은 고대 문명의 마지막 생존자를 이끌고 있다.
정착하여 새로운 문명을 개척하기 위해, 수도의 위치를 선정하려 한다.

수도가 위치할 지역은 N x N 정사각형 모양이며,
각 구획은 붊모지, 초원, 산, 물 등 4가지 종류로 이루어져 있다.
1) 수도는 불모지 또는 불모지에 인접한 지역에 위치할 수 없다.
2) 수도는 초원, 산 물에 해당하는 3가지 지역에 위치할 수 있다.
3) 수도 주변에는 초원, 산, 물에 해당하는 3가지 지역이 적어도 한 곳씩 있어야 한다.

[제약 사항]
지역의 크기를 표현할 N 값은 1 이상 100 이하의 정수이다.

[입력]
첫 줄에는 Test Case의 개수 T가 입력된다.
각 Test Case의 첫 줄에는 지역의 크기를 표현할 N 값이 주어지고,
이어 N x N의 지도에 해당하는 값이 입력된다.

[출력]
각 줄은 #T로 시작되고 공백을 하나 둔 다음,
수도로 선정될 수 있는 지역의 수인 Answer를 출력한다.
(T는 Test Case 번호) 

[입력 예시]
2
5
1	3	2	0	1
2	1	3	2	2
0	3	3	2	1
3	2	1	1	3
0	1	0	1	2
5
1	1	1	1	1
2	2	2	2	2
3	3	3	3	3
2	2	2	2	2
1	1	1	1	1

[출력 예시]
#1	
#2	10
 */
package SWCert_INT;

import java.util.*;
import java.io.*;

public class IM_IMEX181010_CapitalCity_BackTracking {
	static int N;
	static int Map[][];
	static int Answer;
	
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("D:\\Redan_Workspace\\SWCert_Src\\Input (IM_IMEX181010_CapitalCity).txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			//	Init.
			Answer = 0;
		//	Init.
			
		//	Ipt
			N = sc.nextInt();
			
			Map = new int[N + 2][N + 2];
			for(int i = 0; i < (N + 2); i++) {
				for(int j = 0; j < (N + 2); j++) {
					Map[i][j] = 4;
				}
			}
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					Map[i][j] = sc.nextInt();
				}
			}
		//	Ipt
			
		//	Oper
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(Map[i][j] != 0) {	//	수도 지역이 불모지인 경우 제외
						if(Map[i - 1][j - 1] != 0	&& Map[i - 1][j] != 0	&& Map[i - 1][j + 1] != 0 
						&& Map[i][j - 1] != 0		 						&& Map[i][j + 1] != 0 
						&& Map[i + 1][j - 1] != 0	&& Map[i + 1][j] != 0	&& Map[i + 1][j + 1] != 0 ) {	//	주변에 불모지가 있는 경우 제외
							Check(i, j, 1);
						}
					}
				}
			}
		//	Oper
			
		//	Opt
			for(int i = 0; i < (N + 2); i++) {
				for(int j = 0; j < (N + 2); j++) {
					System.out.print(Map[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			System.out.println("#" + test_case + " " + Answer);
		//	Opt
		}	//	End Case
	}	//	End Main
	
	public static void Check(int i, int j, int n) {
		if(n == 4) {
			Answer++;
			return;
		}
		
		if(Map[i - 1][j - 1] == n	|| Map[i - 1][j] == n	|| Map[i - 1][j + 1] == n 
		|| Map[i][j - 1] == n		|| Map[i][j] == n		|| Map[i][j + 1] == n 
		|| Map[i + 1][j - 1] == n	|| Map[i + 1][j] == n	|| Map[i + 1][j + 1] == n)	{
			Check(i, j, n + 1);
			return;
		}
	}	//	End Check
}	//	End Class