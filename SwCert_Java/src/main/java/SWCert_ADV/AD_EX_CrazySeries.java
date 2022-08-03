/*	미친수열
[문제]
다음과 같은 수열이 있다.
1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, ...
(숫자 K가 연달아 K번 나오는 수열).
정수 N이 주어졌을 떄, 해당 수열에서 N번쨰 나오는 숫자를 출력하는 프로그램을 작성하시오.

수열의 첫번쨰 원소는 1이다.

[입력]
입력은 한 줄에 정수 N이 들어온다.
N은 1 이상 1018 이하의 정수이다.

[출력]
수열에서의 N번째 원소를 출력한다.

[입력 예시]
5
4
10
11
12
1000

[출력 예시]
#1 3
#2 4
#3 5
#4 5
#5 45

 */
package SWCert_ADV;

import java.io.*;
import java.util.*;

public class AD_EX_CrazySeries {
	static int N;
	
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("Input (AD_EX_CrazySeries).txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
		//	Ipt.
			N = sc.nextInt();
			
			int Clone = N;
			int CLen = 1;
			
		//	Ipt.
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < CLen; j++) {
					Clone--;
					if(Clone == 0) break;
				}
				
				if(Clone == 0)	break;
				CLen++;
			}

		//	Opt.
			System.out.println("#" + tc + " " + CLen);
		//	Opt.			
		}	//	End Test Case
	}	//	End Main
}	//	End Class