/*	BOJ1000_A+B
[문제]
두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

[입력]
첫째 줄에 A와 B가 주어진다. (0 < A, B < 10)

[출력]
첫째 줄에 A+B를 출력한다.

[입력 예시]
1 2

[출력 예시]
3


 */
package SWCert_Basic;

import java.util.*;
import java.io.*;

public class VE_BOJ1000_APlusB {
	static int A, B;
	static int AnsN;
	
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("Input (APlusB).txt"));
		Scanner sc = new Scanner(System.in);
		
		A = sc.nextInt();
		B = sc.nextInt();
		AnsN = A + B;
		
		System.out.println(AnsN);
	}
}
