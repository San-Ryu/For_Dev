package Java_Basic;

import java.io.IOException;
import java.math.BigInteger;

/*
 * BigInteger ±âº»
 */
public class Java_0401_BigInteger_01 {
	public static void main(String args[]) throws IOException {
		BigInteger a = new BigInteger("10000"); // BigIntegerÀÇ ¼±¾ð
		BigInteger b = new BigInteger("1000");
		BigInteger c = a.add(b);

		System.out.println("A = " + a);
		System.out.println("B = " + b);
		System.out.println("C = " + c);

		System.out.println("A + B = " + a.add(b)); // µ¡¼À
		System.out.println("A - B = " + a.subtract(b)); // »¡¼À
		System.out.println("A * B = " + a.multiply(b)); // °ö¼À
		System.out.println("A / B = " + a.divide(b)); // ³ª´°¼À
		System.out.println("A % B = " + a.remainder(b));// ³ª¸ÓÁö
		System.out.println("gcd(a, b) = " + a.gcd(b)); // ÃÖ´ë°ø¾à¼ö
		System.out.println("-1 * A = " + a.negate()); // À½¼öÈ­

		BigInteger d = new BigInteger("-1");
		System.out.println("-1 * D = " + d.negate()); // ¾ç¼öÈ­

		System.out.println("ZERO = " + BigInteger.ZERO);
		System.out.println("ONE = " + BigInteger.ONE);
		System.out.println("TEN = " + BigInteger.TEN);

		System.out.println("A^10 = " + a.pow(200)); // ½Â¿¬»ê ¸Þ¼­µå¿¡ Àû¿ë °¡´É

	}
}
