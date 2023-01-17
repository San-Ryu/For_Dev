package Java_Basic;

import java.io.IOException;
import java.math.BigInteger;

/*
 * BigInteger �⺻
 */
public class Java_0401_BigInteger_01 {
	public static void main(String args[]) throws IOException {
		BigInteger a = new BigInteger("10000"); // BigInteger�� ����
		BigInteger b = new BigInteger("1000");
		BigInteger c = a.add(b);

		System.out.println("A = " + a);
		System.out.println("B = " + b);
		System.out.println("C = " + c);

		System.out.println("A + B = " + a.add(b)); // ����
		System.out.println("A - B = " + a.subtract(b)); // ����
		System.out.println("A * B = " + a.multiply(b)); // ����
		System.out.println("A / B = " + a.divide(b)); // ������
		System.out.println("A % B = " + a.remainder(b));// ������
		System.out.println("gcd(a, b) = " + a.gcd(b)); // �ִ�����
		System.out.println("-1 * A = " + a.negate()); // ����ȭ

		BigInteger d = new BigInteger("-1");
		System.out.println("-1 * D = " + d.negate()); // ���ȭ

		System.out.println("ZERO = " + BigInteger.ZERO);
		System.out.println("ONE = " + BigInteger.ONE);
		System.out.println("TEN = " + BigInteger.TEN);

		System.out.println("A^10 = " + a.pow(200)); // �¿��� �޼��忡 ���� ����

	}
}
