package Java_Basic;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

/*
 * BigInteger는 Scanner와 함께 사용 가능하다.
 */
public class Java04_BigInteger_02_Scanner {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);

		// compareTo 대소비교
		BigInteger a = sc.nextBigInteger(); // BigInteger의 선언
		BigInteger b = sc.nextBigInteger();
		int c = a.compareTo(b);

		if (c < 0) {
			System.out.println("<");
		} else if (c == 0) {
			System.out.println("==");
		} else {
			System.out.println(">");
		}
		System.out.println("compareTo = " + c);

		// equals 등차비교
		a = sc.nextBigInteger(); // BigInteger의 선언
		b = sc.nextBigInteger();
		boolean d = a.equals(b);

		if (d) {
			System.out.println("==");
		} else {
			System.out.println("!=");
		}
		System.out.println("equals = " + d);
	}
}
