package Java_Basic;

/* BigInteger ����
 * Int : 4 Byte
 * -2,147,483,648 ~ 2,147,483,647
 * 
 * Long : 8 Byte
 * -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807
 *
 * �� Type ��� ������ ������ ������ ������,
 * BigInteger�� ���ڿ� ���·� �̷����, ǥ���� �� �ִ� ������ ������ ���� ������ ����.
 *
 */

import java.io.IOException;
import java.math.BigInteger;

public class Java_0401_BigInteger_01 {
	public static void main(String args[]) throws IOException {
		// BigInteger�� ����
		BigInteger a = new BigInteger("10000");
		BigInteger b = new BigInteger("100");
		BigInteger c = a.add(b);

		// BigInteger ���� ��� (A, B, C)
		System.out.println("A = " + a);
		System.out.println("B = " + b);
		System.out.println("C = " + c);

		// BigInteger ���� ����
		System.out.println("A + B = " + a.add(b)); // ����
		System.out.println("A - B = " + a.subtract(b)); // ����
		System.out.println("A * B = " + a.multiply(b)); // ����
		System.out.println("A / B = " + a.divide(b)); // ������
		System.out.println("A % B = " + a.remainder(b));// ������
		System.out.println("gcd(a, b) = " + a.gcd(b)); // �ִ�����
		System.out.println("-1 * A = " + a.negate()); // ����ȭ
		BigInteger d = new BigInteger("-1"); // ���� ����
		System.out.println("D = " + d); // ���� ��� (D)
		System.out.println("-1 * D = " + d.negate()); // ���ȭ
		System.out.println("A^10 = " + a.pow(200)); // �¿��� �޼��忡 ���� ����
		
		// BigInteger�� ���� Ư�� ���� ���� ���� ���� (0, 1, 10)
		System.out.println("ZERO = " + BigInteger.ZERO);
		System.out.println("ONE = " + BigInteger.ONE);
		System.out.println("TEN = " + BigInteger.TEN);
	}
}
