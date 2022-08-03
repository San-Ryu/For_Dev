/*	진법 변환
[문제]
A진법의 수 N이 주어진다.
이 수를 10진법으로 바꿔 출력하는 프로그램을 작성하시오.

[제약사항]
10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다.
이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.
A : 10, B : 11, ..., F : 15, ..., Y : 34, Z : 35

또한, A는 2 이상 36 이하의 자연수이다.
(2 <= A <= 36)

A진법의 수 N을 10진법으로 바꾸면, 항상 10억보다 작거나 같다.

[입력]
입력은 다음과 같이 구성되어있다.
첫번쨰 줄에는 Test Case의 개수 T가 주어진다.
그 다음 T개의 Test Case가 차례로 주어진다.

Test Case의 첫째 줄에는 A와 N이 공백을 사이에 두고 주어진다.

[출력]
각 줄은 #T로 시작되고 (T는 Test Case 번호) 공백을 하나 둔 다음,
A진법 수 N을 10진법으로 출력한다.

[입력 예시]
5
36 ZZZZZ
2 10110
8 82532
10 11452
16 FFFFF

[출력 예시]
#1 60466175
#2 22
#3 34138
#4 11452
#5 1048575
 */
package SWCert_INT;

import java.io.*;
import java.util.*;

public class IM_Binary {
	static int A;	// 진법
	static String N;	// Number N
	static int Ans;	//	Answer
	
	static int Len;	//	Length Of Number
	static int tmp[];	//	Number N
	
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream(""));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
		//	Init. & Ipt
			Ans = 0;
			A = sc.nextInt();
			N = sc.next();
			
			Len = N.length();
		//	Init. & Ipt
			
		//	Oper.
			tmp = new int[Len];
			for(int i = 0; i < Len; i++) {
				tmp[i] = (int) N.charAt(i);
				if('0' <= tmp[i] && tmp[i] <= '9')	tmp[i] = tmp[i] - '0';
				else	tmp[i] = tmp[i] - 'A' + 10;
				Ans+= tmp[i] * (int) Math.pow(A, Len - (i + 1));
			}
		//	Oper.
			
		//	Opt.
			System.out.println("#" + tc + " " + Ans);
		//	Opt.
		}	//	End Test Case
	}	//	End Main Method
}	//	End Class