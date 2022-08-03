package Java_Basic;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

/*
 * [문제]
 * A^B를 정확하게 계산하시오.
 * 
 * [입력]
 * 첫번째 줄에 Testcase가 주어진다.
 * 두번째 줄부터, 실수 A와 정수 B가 공백을 사이에 두고 주어진다.
 * (단, 0 < A < 100, 1 <= B <= 100
 *  A는 소수점 최대 9자리까지
 *  소수가 0으로 끝나는 경우는 없다.)
 * 
 * [출력]
 * 첫번째 줄부터 A의 B 제곱 값이 출력된다.
 * 
 * [입력 예시]
 * 3.141592 13
 * 
 * [출력 예시]
 * 2,903,669.4174153440472996217219716
 * 
 * [참고]
 * BigDecimal 데이터형과
 * Scanner의 nextBigDecimal 메서드를 사용할 수 있다.
 * (반드시 math.BigDecimal을 Import 해주도록 한다.)
 * 
 * [입력]
 * 3
 * 3.141592 13
 * 0.999999999 15
 * 1287.3284 25
 * 
 * [출력]
 * 2903669.417415344047299621721971613056687989755360292249562766128188187800590889254912
 * 0.999999985000000104999999545000001364999996997000005004999993565000006434999994995000003002999998635000000454999999895000000014999999999
 * 552374676605859623498000045157653195381430229713885500138841480045135728018813.3163307802990955840293022701997021874009871301412660458241391055955142283835377812505708476575514624
 */
public class Java04_BigInteger_05_BigDecimal_A_Add_B {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			BigDecimal a = sc.nextBigDecimal();
			int b = sc.nextInt();
			int temp = i + 1;
			
			System.out.println();
			System.out.println("TC = " + temp);
			System.out.println("입력값 A : " + a);
			System.out.println("입력값 B : " + b);
			
			// 4가지 경우를 비교해보자
			BigDecimal c = a.pow(b);
			System.out.println("Case A"); // BigDecimal
			System.out.println("형식 : " + c.getClass());
			System.out.println("출력값 : " + c);
			System.out.println("Case B"); // String
			System.out.println("형식 : " + c.toString().getClass());
			System.out.println("출력값 : " + c.toString());
			System.out.println("Case C"); // String
			System.out.println("형식 : " + c.toPlainString().getClass());
			System.out.println("출력값 : " + c.toPlainString());
			// 값은 동일할 수 있으나, 데이터는 달라진다			
		}
		System.out.println("입력 종료");
	}
}
