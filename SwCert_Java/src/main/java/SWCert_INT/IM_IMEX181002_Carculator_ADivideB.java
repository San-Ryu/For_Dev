/*	전자계산기 - 나눗셈
[문제]
전자계산기의 나눗셈을 구현하려 한다.
A를 B로 나누고 몫과 나머지를 구하는 프로그램을 작성하시오.

[제약 사항]
A는 10자리의 자연수
B는 8자리의 자연수
(B는 A보다 클 수 없음)

[입력]
입력은 다음과 같이 구성되어있다.
첫번째 줄에는 Test Case의 개수 T가 주어진다.
그 다음 T개의 Test Case가 차례로 주어진다.

각 Test Case는 한 줄로 이루어져 있으며,
두 수 A와 B가 공백을 사이에 두어 차례대로 입력된다. 

[출력]
각 줄은 #T로 시작되고 공백을 하나 둔 다음,
Quotient와 Remainder를, 공백을 사이에 두어 차례대로 출력한다.
(T는 Test Case 번호) 
(Quotient는 A를 B로 나눈 몫)
(Remainder는 A를 B로 나눈 나머지)

[입력 예시]
3
9999999999 12345
12535 5
9513574268 9562

[출력 예시]
#1
#2
#3
*/
package SWCert_INT;

import java.util.*;
import java.io.*;

public class IM_IMEX181002_Carculator_ADivideB {
	static int A[] = new int[101];
	static int B;
	static int LA, L;
	static int Quotient[] = new int[101];
	static int Remainder;
	
	static int AA;
	
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("D:\\Redan_Workspace\\SWCert_Src\\Input (IM_IMEX181002_Carculator_ADivideB).txt"));
		Scanner sc = new Scanner(System.in);
		
		String buffer;
		
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			buffer = sc.next();
			LA = buffer.length();
			for(int i = 0; i < LA; i++) {
				A[i] = (int)(buffer.charAt(i) - '0');
				System.out.print(A[i]);
			}
			System.out.println();
			
			AA = 0;
			for(int i = (LA - 1); 0 <= i; i--) {
				AA+= A[i] * (int) Math.pow(10, LA - 1 - i);
			}
			System.out.println(AA);
			
			B = sc.nextInt();
			/*	알고리즘
				알고리즘
				알고리즘	*/
			
			System.out.print("#" + test_case + " ");
			
			for(int i = 0; i < L; i++) {
				System.out.println(Quotient[i]);
			}

			System.out.println(" " + Remainder);
			
		}
	}
}
