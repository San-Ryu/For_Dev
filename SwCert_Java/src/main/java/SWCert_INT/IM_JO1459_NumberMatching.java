/*	숫자 매칭 (의명)
[문제]
세로 두 줄, 가로 N개의 칸으로 이루어진 표가 있다.
첫째 줄의 각 칸에는 정수 1, 2, 3, ---, N이 자례대로 들어있고,
둘째 줄의 각 칸에는 1 이상 N 이하의 정수가 임의로 들어있다.

첫째 줄에서 숫자를 적절히 뽑으면, 그 뽑힌 정수들이 이루는 집합과, 
뽑힌 정수들의 바로 밑의 둘째 줄에 들어있는 정수들이 이루는 집합이 일치한다.
이러한 조건을 만족시키도록 정수들을 뽑되, 최대로 많이 뽑는 방법을 찾는 프로그램을 작성하시오.

예를 들어, N = 7인 경우 아래와 같이 표가 주어졌다고 가정했을 때, 
1 2 3 4 5 6 7
3 1 1 5 5 6 6
첫째 줄에서 1, 3, 5를 뽑는 것이 정답이다.
 - 첫째 줄의 1, 3, 5 밑에는 각각 3, 1, 5가 있으며, 두 집합은 일치한다.
       이 때, 집합의 크기는 3이다.
 - 만약 첫째 줄에서 1과 3을 뽑이면, 이들 바로 밑에는 정수 3과 1이 있으므로 두 집합이 일치한다.
      그러나, 이 경우에 뽑힌 정소의 개수가 최대치보다 작으므로 답이 될 수 없다.

[입력]
입력의 첫째 줄에는 N(1 <= N <= 100)을 나타내는 정수 하나가 주어진다.
그 다음 줄부터는 표의 둘째 줄에 들어가는 정수들이 순서대로 한 줄에 하나씩 입력된다.

[출력]
첫째 줄에 #T로 시작하며,
둘째 줄에 뽑힌 정수들의 개수를 출력하고 공백을 하나 둔 다음,
뽑힌 정수들을 작은 수부터 큰 수의 순서로 공백을 하나씩 두어 출력한다.

[입력 예시]
6
7
3 1 1 5 5 6 6
7
3 4 1 2 5 4 6 
7
3 4 1 2 5 4 6
7
1 2 3 4 0 0 0
10
1 2 3 4 5 6 7 8 9 10
10
10 9 8 7 6 5 4 3 2 1

[출력 예시]
#1
3 1 3 5
#2
5 1 2 3 4 5
#3
5 1 2 3 4 5
#4
4 1 2 3 4
 */

/*	10의 자리로 넘어가면 스트링에 어떻게 받을건지를 알아야만 함
 *	if (10의 자리를 넘어가면) /10/ 등으로 구분하여 받고,
 *	스트링에서 찢어낼 때 특수문자를 제거하면서 받는 방법도 가능은 할 것 같다.
 *	나중에 해보자
 */
package SWCert_INT;

import java.util.*;
import java.io.*;

public class IM_JO1459_NumberMatching{
	static int N;	//	최대 자릿수
	static int L1[], L2[];	// 1 ~ N까지의 수열 & 주어지는 수열
	static int Answer;
	
	static int SetN;	//	기준 자릿수
	static int Flag[];	//	사용 여부, 매치되는 경우
	static String Match;
	static int Case;	//	매치되는 경우의 수
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("D:\\Redan_Workspace\\SWCert_Src\\Input (IM_NumberMatching).txt"));
		Scanner sc= new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {	//	Test_case
		//	Ipt
			N = sc.nextInt();	//	자릿수 N
			
			//	1 2 3 4 5 6 7
			L2 = new int[N];
			for(int i = 0; i < N; i++) {
				L2[i] = i + 1;
			}
			
			//	3 1 1 5 4 6
			L1 = new int[N];
			for(int i = 0; i < N; i++) {
				L1[i] = sc.nextInt();
			}
			
			SetN = 0;
			Case = 0;
			Flag = new int[N];
		//	Ipt
			
		//	Oper
			//	1개 일치
			Match = "";
			for(int i = 0; i < N; i++) {
				if(L1[i] == L2[i]) {
					Case++;
					Match+= L1[i];
					L1[i] = 0;
				}
			}
			
			//	쌍 일치
			for(int i = 0; i < N; i++){
				for(int j = 0; j < N; j++) {
					if((L1[i] == L2[j]) && (L1[j] == L2[i])) {
						Case+= 2;
						Match+= L1[i];
						Match+= L1[j];
						L1[i] = L1[j] = 0;
					}
				}
			}
			
			// String에서 Array로 전환
			L1 = new int[N];
			for(int i = 0; i < Match.length(); i++){
				L1[i] = (int) Match.charAt(i) - '0';	//	L1 재활용
			}
			
			// Sorting
			for(int i = 0; i < N; i++){
				for(int j = 0; j < N; j++) {
					int tmp = 0;
					if(L1[i] < L1[j]) {
						tmp = L1[j];
						L1[j] = L1[i];
						L1[i] = tmp;
					}
				}
			}
			
			//	Except 0
			for(int i = 0; i < N; i++){
				for(int j =  i + 1; j < N; j++) {
					if(L1[i] == 0) {
						L1[i] = L1[j];
						L1[j] = 0;
					}	
				}
			}
		//	Oper
		
		//	Opt
			System.out.println("#" + test_case);
			System.out.print(Case + " ");
			for(int i = 0; i < Match.length(); i++) {
				System.out.print(L1[i] + " ");
			}
			System.out.println();
		//	Opt
			
		}	//	End Test_case
	}	//	End Main
}	//	End Class
