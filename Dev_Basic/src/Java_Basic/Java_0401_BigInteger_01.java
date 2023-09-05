package Java_Basic;

/* BigInteger 개요
 * Int : 4 Byte
 * -2,147,483,648 ~ 2,147,483,647
 * 
 * Long : 8 Byte
 * -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807
 *
 * 두 Type 모두 유한한 범위를 가지고 있으나,
 * BigInteger는 문자열 형태로 이루어져, 표현할 수 있는 숫자의 범위에 대한 제한이 없음.
 *
 */

import java.io.IOException;
import java.math.BigInteger;

public class Java_0401_BigInteger_01 {
	public static void main(String args[]) throws IOException {
		// BigInteger의 선언
		BigInteger a = new BigInteger("10000");
		BigInteger b = new BigInteger("100");
		BigInteger c = a.add(b);

		// BigInteger 변수 명시 (A, B, C)
		System.out.println("A = " + a);
		System.out.println("B = " + b);
		System.out.println("C = " + c);

		// BigInteger 관련 연산
		System.out.println("A + B = " + a.add(b)); // 덧셈
		System.out.println("A - B = " + a.subtract(b)); // 빨셈
		System.out.println("A * B = " + a.multiply(b)); // 곱셈
		System.out.println("A / B = " + a.divide(b)); // 나눗셈
		System.out.println("A % B = " + a.remainder(b));// 나머지
		System.out.println("gcd(a, b) = " + a.gcd(b)); // 최대공약수
		System.out.println("-1 * A = " + a.negate()); // 음수화
		BigInteger d = new BigInteger("-1"); // 음수 선언
		System.out.println("D = " + d); // 변수 명시 (D)
		System.out.println("-1 * D = " + d.negate()); // 양수화
		System.out.println("A^10 = " + a.pow(200)); // 승연산 메서드에 적용 가능
		
		// BigInteger를 통해 특정 값에 대한 변수 선언 (0, 1, 10)
		System.out.println("ZERO = " + BigInteger.ZERO);
		System.out.println("ONE = " + BigInteger.ONE);
		System.out.println("TEN = " + BigInteger.TEN);
	}
}
