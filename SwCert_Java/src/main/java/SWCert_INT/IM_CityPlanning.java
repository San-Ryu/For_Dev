/*	<도시계획>
[문제]
 인구가 수도에 편중되어, 심한 불균형으로 몸살을 앓고 있는 나라가 있다.
이 나라에서는 이를 해결하기 위해, 수도 인구를 분산시킬 수 있는 신도시를 건설하려 한다.

 신도시를 세울 부지는 변의 길이가 N인 정사각형 형태이며,
이 부지는 가로, 세로 길이가 1인 구획으로 나뉘어져있다.
(N은 자연수, 바둑판형)

 나라에서는 부지에 빌딩을 세울 부지를 경정하였으며, 그 외의 구획들은 녹지로 조성할 계획이다.
또한, 신도시 빌딩들의 녹지 조망권을 보장하기 위해 다음과 같은 법안을 마련한다.
1) 부지의 가장자리 구획은 모두 녹지로 조성
2) 빌딩 구획당 1개의 빌딩
3) 빌딩 구획이 녹지 구획과 상하좌우 중 적어도 한 곳 이상 인접해있다면,
	그 구획의 빌딩 높이는 1이다
4) 빌딩 구획이 녹지 구획과 상하좌우 중 어느 한 곳도 인접해있지 않다면,
	그 구획의 빌딩은 고층 빌딩으로 구성된다.
	빌딩의 높이는 그 구획을 중심으로 상하좌우선상에 위치한 모든 빌딩의 구획의 개수이다.
	(중심이 되는 구획도 포함된다)

G  G  G  G  G  G  G  G 
G  G  G  B  G  G  G  G
G  G  G  B  B  B  G  G
G  B  B  B  B <B> B  G 
G  G  G  B (B) B  G  G
G  G  G  B  G  G  G  G
G  G  G  G  G  B  G  G
G  G  G  G  G  G  G  G

 N = 8일 경우의 부지이다.
(녹지구획 : G / 빌딩 구획 : B)
(B) - 빌딩 높이 : 1 (녹지 인접)
<B> - 빌딩 높이 : 9 (선상의 B 개수)

 이대로 계획된 구획의 모든 빌딩이 세워졌을 때,
그 빌딩들의 높이 합을 구하는 프로그램을 작성하시오.

[제약조건]
N은 3 이상 20 이하의 자연수

[입력]
T개의 Test Case가 주어진다.
각 Test Case는 아래와 같은 형식으로 주어진다.
첫줄에 N 값이 주어진다.
그 다음에 N 줄에 부지의 구획 정보에 해당하는 자료가 한줄에 한행씩 차례로 주어진다.
녹지 구획은 G / 건물 구획은 B로 표시된다.

[출력]
각 줄은 #T로 시작하고, 공백을 하나 둔 다음,
해당 Test Case에서의 출력값을 나타낸다.
 
[입력 예시]
3
3
G G G
G B G
G G G
5
G G G G G
G B B G G
G B B B G
G B B B G
G G G G G
8
G G G G G G G G 
G G G B G G G G
G G G B B B G G
G B B B B B B G 
G G G B B B G G
G G G B G G G G
G G G G G B G G
G G G G G G G G 

[출력 예시]
#1 1
#2 12
#3 39
*/
package SWCert_INT;

import java.util.Scanner;
import java.io.FileInputStream;

public class IM_CityPlanning {
	static int T, N;	//	T = Test Case, N = Length of Sides
	
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("D:\\Redan_Workspace\\SWCert_Src\\Input (CityPlanning).txt"));	//	Input File
		Scanner sc = new Scanner(System.in);
				
		T = sc.nextInt();	//	Ipt : Test Case
		for(int test_case = 1; test_case <= T; test_case++) {
		//	Case Start
			//	Ipt ( + Def. / Init.)
			int AnsN = 0;	//	Def. & Init. : AnsN (Sum Of Height)
			N = sc.nextInt();	//	Ipt : N
			
			char [][]map = new char [N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					String tmp = sc.next();	//	Ipt txt To tmp (Must String)
					map[i][j] = tmp.charAt(0);	// Ipt tmp To map[][] 
				}
			}
			//	Ipt
			
			// Get AnsN
			for(int i = 0; i <= (N-1); i++) {
				for(int j = 0; j <= (N-1); j++) {
					if(map[i][j] == 'B') {
						if(map[i - 1][j] == 'G' || map[i + 1][j] =='G'
						   || map[i][j - 1] == 'G' || map[i][j + 1] =='G') {	//	Close by G
							AnsN++;
						}
						else {	//	Not Close by G
							int cnt = 0;	//	Def. & Init. : cnt (Height Of Building)
							for(int k = 1; k < N; k++) {	//	Axis X (Horizontal)
								if(map[i][k] == 'B') {
									cnt++;
								}
							}
							for(int k = 1; k < N; k++) {	//	Axis Y (Vertical)
								if(map[k][j] == 'B') {
									cnt++;
								}
							}
							cnt--;	//	To Prevent Duplication of map[i][j] Height 
							AnsN+= cnt;	//	AnsN
						}
					}
				}
			}	//	Get AnsN
			
			//	Opt
			System.out.println("#" + test_case + " " + AnsN);
			//	Opt
			
		}	//	End Case
	}	//	End Main
}	//	End Class
