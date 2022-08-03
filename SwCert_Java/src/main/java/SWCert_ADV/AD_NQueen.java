/* NQueen
[문제]
NQueen 문제는 크기가 N*N안 체스판 위에 N개의 퀸을 서로 공격할 수 없게 놓는 문제이다.
N이 주어졌을 때, 퀸ㅇ르 놓는 방법의 수를 구하시오.

[입력]
첫째 줄에 N이 주어진다.
(단, 1 <= N <= 15)

[출력]
첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.

[입력 예시]
8

[출력 예시]
92
 */
package SWCert_ADV;

import java.util.Scanner;
import java.io.FileInputStream;

public class AD_NQueen {
	static int T, N;	//	Testcase T // 변수 N
	static int[] sol = new int [N];	//	솔루션 저장 배열
	static int[] col = new int [N];	//	각 열에서 퀸의 배치 여부
	static int AnsN;	//	경우의 수
	
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("D:\\Redan_Workspace\\SWCert_Src\\Input (NQueen).txt"));
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			backtrack(0);
			System.out.println("#" + test_case + " " + AnsN);
		}
	}	//	End Main
	
	public static void backtrack(int row) {
		if(isSolution(row)) {	//	솔루션 처리 조건이 충족된다면,
			processSolution();	//	솔루션 처리
			return;	//	메소드를 종료하여 되돌리기 실행
		}
		
		loop:for(int i = 0; i < N; i++) {
			if(col[i] == 1) {
				continue loop;
			}
			
			for(int j = 0; j < row; j++) {
				if(Math.abs(row - j) == Math.abs(i - sol[j])) {
					continue loop;
				}
			}
			
			sol[row] = i;	//	퀸을 배치한 열 저장
			col[i] = 1;	// 퀸 배치
			
			backtrack(row+1);	//	다음 행으로 재귀 호출
			col[i] = 0;	//	퀸 배치 하제
		}
	}	//	End Backtrack
	
	public static boolean isSolution(int row) {	//	솔루션 처리에 대한 조건 결정 여부 메소드
		return (row == N);
	}	//	End isSolution
	
	public static void processSolution() {	//	솔루션 처리 메소드
		AnsN ++;
	}	//	End processSolution
	
}	//	End Class
