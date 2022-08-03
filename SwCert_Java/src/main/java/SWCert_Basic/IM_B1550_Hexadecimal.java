/* 16진수
[문제]
16진수 수를 입력받아서 10진수로 출력하는 프로그램을 작성하시오.

[입력]
입력은 다음과 같이 구성되어있다.
첫번째 줄에는 Test Case의 개수 T가 주어진다.
그 다음 T개의 Test Case가 차례대로 주어진다.

Test Case의 첫째 줄에는 16진수 수가 주어진다.

[출력]
각 줄은 #T로 시작되고 (T는 Test Case 번호) 공백을 하나 둔 다음,
16진수 N을 10진법으로 출력한다.

[입력 예시]
3
A
AB
ABC

[출력 예시]
#1 10
#2 171
#3 2748
 */
package SWCert_Basic;

import java.io.*;
import java.util.*;

public class IM_B1550_Hexadecimal {
	static String N;	//	Number N
	static int Answer;	//	Answer
	
	static int Len, tmp[];
	
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream(""));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.next();
			Answer = 0;
			
			Len = N.length();
			tmp = new int[Len];
			for(int i = 0; i < Len; i++) {
				tmp[i] = (int) N.charAt(i);
				if(('0' <= tmp[i]) && tmp[i] <= '9') {
					tmp[i]-= '0';
				}
				else	tmp[i] = tmp[i] - 'A' + 10;
						
				Answer+= tmp[i] * (int) Math.pow(16, (Len - (i + 1)));
//				Answer+= tmp[i] * (int) (16 ^ (Len - (i + 1)));
			}
			
			System.out.println("#" + tc + " " + Answer);
		}	//	End Test Case
	}	//	End Main Method
}	//	End Class