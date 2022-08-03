package Java_Basic;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

/*
 * [문제]
 * A + B를 계산하시오.
 * 
 * [입력]
 * 첫번째 줄에 Testcase가 주어진다.
 * 두번째 줄부터, 수 A와 수 B가 공백을 사이에 두고 주어진다.
 * (단, 0 < A, B < 10^10000)
 * 
 * [출력]
 * 첫번째 줄부터 A와 B의 합이 출력된다.
 * 
 * [입력 예시]
 * 999999999999 1000000
 * 
 * [출력 예시]
 * 1000000999999
 * 
 * [참고]
 * Scanner의 nextBigInteger 메서드를 사용할 수 있다.
 * 
 * [입력]
 * 2
 * 999999999 100000
 * 999999999999 1
 * 
 * [출력]
 * 1000099999
 * 1000000000000
 */
public class Java04_BigInteger_04_BigInteger_A_Add_B {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			BigInteger a = sc.nextBigInteger();
			BigInteger b = sc.nextBigInteger();

			System.out.println("입력값 A : " + a);
			System.out.println("입력값 B : " + b);
			// System.out.println("출력값 : " + a + b); // 이렇게 쓰면, a와 b가 문자열처럼 붙어서 출력된다. (오답)
			System.out.println("출력값 : " + a.add(b));
		}
		System.out.println("입력 종료");
	}
}
