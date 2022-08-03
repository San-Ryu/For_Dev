/*	촌수 계산 BOJ2644
[문제]
우리 나라는 가족 혹은 친척들 사이의 관계를 촌수라는 단위로 표현하는 독특한 문화를 가지고 있다.
이러한 촌수는 다음과 같은 방식으로 계산된다.

기본적으로 부모와 자식의 사이를 1촌으로 정의하고, 이로부터 사람들간의 촌수를 계산한다.
예를 들어, 
1) 나와 아버지, 아버지와 할아버지는 각각 1촌으로, 나와 할아버지는 2촌이 되고, 
2) 아버지 형제들과 할아버지는 1촌, 나와 아버지 형제들과의 관계는 3촌이 된다.

여러 사람들에 대한 부모 자식 관계가 주어졌을 때, 주어진 두 사람의 촌수를 계산하는 프로그램을 작성하시오.

[입력]
사람들은 1, 2, 3, ..., N (1 <= N <= 100)의 연속된 번호로 각각 표시된다.
입력 파일의 첫째 줄에는 전체 사람의 수 N이 주어지고,
둘째 줄에는 촌수를 계산해야하는 서로 다른 두 사람의 번호가 주어진다.
그리고 셋째 줄에는 부모 자식들간의 관계의 개수 M이 주어진다.
넷째 줄부터는 부모 자식간의 관계를 나타내느 두 번호 X, Y가 각 줄에 나온다.
이 때, 앞에 나오는 번호 X는 뒤에 나오는 정수 Y의 부모 번호를 나타낸다.

각 사람의 부모는 최대 한명만 주어진다.

[출력]
입력에서 요구한 두 사람의 촌수를 나타내는 정수를 출력한다.
어떤 경우에는 두 사람의 친척 관계가 전혀 없어 촌수를 계산할 수 없을 때가 있다.
그 때에는 -1을 출력한다.

[입력 예시]
1
9
7 3
7
1 2
1 3
2 7
2 8
2 9
4 5
4 6

[출력 예시]
3
 */
/*	촌수 계산
입력값 / 필요값
ArrList / Queue 선언
While 기준정보 입력, 방문 처리
	     탐색 (자기 배열 내 사람들)
	     조건 (찾던 사람인가?) Y : Break
	                  N : 탐색 지속 
		
*/		
package SWCert_ADV;

import java.io.*;
import java.util.*;

public class AD_BOJ2644_KinshipDegree {
	static int N;	//	총 사람의 명 수
	static int P1, P2;	//	탐색 대상 1, 2
	static int M;	//	관계의 개수
	static int AnsN;	//	결과 값 (촌수)
	
	static int Lineage[][];	//	관계 입력(간선)
	static int Stat[];	//	사람에 대한 탐색 여부 확인
	public static void main(String args[]) throws Exception{
	//	Init. & Ipt.
		System.setIn(new FileInputStream(""));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			P1 = sc.nextInt();
			P2 = sc.nextInt();
			
			M = sc.nextInt();
			Lineage = new int[M][2];
			for(int i = 0; i < M; i++) {
				for(int j = 0; j < 2; j++) {
					Lineage[i][j] = sc.nextInt();
				}
			}
	//	Init. & Ipt.
	//	Oper. & Opt.
	//	Oper. & Opt.
		}	//	End Test Case
	}	//	End Main
	
	public static void DFS(int n) {
	}	//	End DFS Method
}	//	End Class