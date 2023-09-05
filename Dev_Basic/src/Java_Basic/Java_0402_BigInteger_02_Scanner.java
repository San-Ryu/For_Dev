package Java_Basic;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

/*
 * BigInteger�� Scanner�� �Բ� ��� �����ϴ�.
 */
public class Java_0402_BigInteger_02_Scanner {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);

		// compareTo ��Һ�
		BigInteger a = sc.nextBigInteger(); // BigInteger�� ����
		BigInteger b = sc.nextBigInteger();
		System.out.println(a);
		System.out.println(b);
		
		int c = a.compareTo(b);

		if (c < 0) {
			System.out.println("a < b");
		} else if (c == 0) {
			System.out.println("a == b");
		} else {
			System.out.println("a > b");
		}
		System.out.println("compareTo = " + c);

		// equals ������
		a = sc.nextBigInteger(); // BigInteger�� ����
		b = sc.nextBigInteger();
		boolean d = a.equals(b);

		if (d) {
			System.out.println("a == b");
		} else {
			System.out.println("a != b");
		}
		System.out.println("equals = " + d);
	}
}
