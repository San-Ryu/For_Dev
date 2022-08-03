/*	2xN 타일링
[문제]
2xN 직사각형을 2x1과 2x2 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.

[제약사항]
N은 1 이상 1000 이하의 자연수이다
(1 <= N <= 1000)

[입력]
 입력은 다음과 같이 구성되어있다.
첫번째 줄에는 Test Case의 개수 T가 주어진다.
그 다음 T개의 Test Case가 차례로 주어진다.

Test Case의 첫째 줄에는 N이 주어진다.

[출력]
 각 줄은 #T로 시작되고 (T는 Test case 번호) 공백을 하나 둔 다음,
2xN 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.
 
[입력 예시]
3
2
8
12

[출력 예시]
#1 3
#2 171
#3 2731
*/

/* 점화식 유도 (그림을 그려볼 것)
N = 1일 때, Answer = 1
N = 2일 때, Answer = 3
N = 3일 때, Answer = 5
N = 4일 때, Answer = 11
N = 5일 때, Answer = 21

21 = 11 + (5 * 2)
11 = 5 + (6 * 2)
5 = 3 + (1 * 2)

D[N] = D[N - 1] + (D[N - 2] * 2)
 */
// package SWCert_Completed_Professional;
package SWCert_PRO;

import java.io.FileInputStream;
import java.util.Scanner;

//public class Pro_B11727_DP_2NTile {
public class Main{
	static int N;
	static int Answer;

	static int D[];
	
	public static void main(String args[]) throws Exception{
//		System.setIn(new FileInputStream("D:\\Redan_Workspace\\SWCert_Src\\Input (Pro_B11727_2XNTile).txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			Answer = 0;
			N = sc.nextInt();

			D = new int[N + 1];
			D[0] = 0;	//	N = 0일 때
			D[1] = 1;	//	N = 1일 때
			D[2] = 3;	//	N = 2일 때
			if(3 <= N) {
				for(int i = 3; i <= N; i ++) {
					D[i] = D[i - 1] + (D[i - 2] * 2);
				}
			}
			
			Answer = D[N]%10007;
			
			System.out.println("#" + test_case + " " + Answer);
		}
	}
}
