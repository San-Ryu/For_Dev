/* 총잡이
가로/세로의 네모 칸들로 이루어진 방에 총잡이들이 있다.
이 총잡이들은 자신의 위치로부터 상, 하, 좌, 우의 직선 방향만 볼 수 있으며, (대각선은 볼 수 없음)
이들 시야에 목표물이 보일 경우 지체없이 총을 쏘아 목표물을 맞힌다.

그런데 이 방에는 벽이 존재하며, 총잡이들은 벽 너머로는 볼 수 없다.
또한, 목표물 너머의 목표물 또는, 다른 총잡이 너머의 목표물을 볼 수 없다.

적어도 한 명 이상의 총잡이의 목표가 되는 목표물의 총 개수를 출력하는 프로그램을 작성하시오.

[제한조건]
1) 방의 세로 칸 수 Ri와 가로 칸 수 Rj는 각각 20 이하의 자연수이다.
2) 총잡이와 목표물은 한칸에 최대 하나만 존재할 수 있으며, 총잡이와 목표물은 같은 칸에 동시에 존재할 수 없다.
3) 총잡이의 수 G와 목표물의 수 T는 100을 넘지 않는다.
4) 총잡이끼리는 서로 목표물이 될 수 없다.

[입력]
입력은 다음과 같이 구성되어있다.
첫번째 줄에는 Test Case의 개수 T가 주어진다.
그 다음 T개의 Test Case가 차례로 주어진다.

각 Test Case는 다음과 같이 구성되어있다.
첫 줄에 방의 세로 칸 수 Ri, 가로 칸 수 Rj가 공백으로 구분되어 차례대로 주어진다.
그 다음 Ri 줄에 걸쳐 방의 지도를 나타내는 2차원 배열의 각 행의 값이 순서대로 주어진다.
각 줄당 Rj개의 값이 공백으로 구분되어 나열되며,
값은 비어있는 칸의 경우 0, 총잡이가 있는 경우 G, 
      목표물이 있는 칸은 T, 벽이 있는 칸은 W
로 구성된다.

[출력]
각 줄은 #T로 시작되고 공백을 하나 둔 다음,
적어도 한 명 이상의 총잡이의 목표가 되는 목표물의 총 개수를 출력한다.
(T는 Test Case 번호) 

[입력 예시]
3
5 7
T 0 T 0 G 0 G
0 W T W W W 0
T W G 0 T W T
0 0 0 T G W 0
0 0 T 0 0 W 0
2 10
T W 0 G 0 W 0 G 0 W
G 0 T W T 0 T W T 0
3 3
T G T
G T G
T G T

[출력 예시]
#1 6
#2 2
#3 5
 */
package SWCert_INT;

import java.util.Scanner;
import java.io.FileInputStream;

public class IM_Gunners {
	static int T, Ri, Rj;
	static int AnsN;
	
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("D:\\Redan_Workspace\\SWCert_Src\\Input (Gunners).txt"));
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			AnsN = 0;
			Ri = sc.nextInt();
			Rj = sc.nextInt();
			
			char[][]room = new char[Ri][Rj];
			for(int i = 0; i <= (Ri - 1); i++) {
				for(int j = 0; j <= (Rj - 1); j++) {
					String tmp = sc.next();
					room[i][j] = tmp.charAt(0);

					if(room[i][j] == 'T') {	
						//	Gunner 위치 (X 정방향)
						for(int k = 1; k < (Ri - i); k++) {
							if(room[i + k][j] == 'T' || room[i + k][j] == 'W') {
								break;
							}
							else if(room[i + k][j] == 'G') {
								AnsN++;
								break;
							}
						}
						
						//	Gunner 위치 (X 역방향)
						for(int l = 1; l < i; l++) {	
							if(room[i - l][j] == 'T' || room[i - l][j] == 'W') {
								break;
							}
							else if(room[i - l][j] == 'G') {
								AnsN++;
								break;
							}
						}
						
						//	Gunner 위치 (Y 정방향)
						for(int m = 1; m < (Rj - j); m++) {
							if(room[i][j + m] == 'T' || room[i][j + m] == 'W') {
								break;
							}
							else if(room[i][j + m] == 'G') {
								AnsN++;
								break;
							}
						}
						
						//	Gunner 위치 (Y 역방향)
						for(int n = 1; n < j; n++) {
							if(room[i][j - n] == 'T' || room[i][j - n] == 'W') {
								break;
							}
							else if(room[i][j - n] == 'G') {
								AnsN++;
								break;
							}
						}
					}
				}
			}
			System.out.println("#" + test_case + " " + AnsN);
		}	//	End Test_Case
	}	//	End Main	
}	//	End Class