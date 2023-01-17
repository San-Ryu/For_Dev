package Java_Basic;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

/*
 * [문제]
 * 피보나치 수는 0과 1로 시작한다.
 * 0번째 피보나치 수는 0이고,
 * 1번째 피보나치 수는 1이다.
 * 그 다음 2번째부터는 앞의 두 피보나치 수의 합이 수열의 항으로 구성된다.
 * 이를 점화식으로 표현하면, 
 * F[n] = F[n-1] + F[n-2] (단, n >= 2)
 * 가 된다.
 * 
 * n = 17일 때 피보나치 수열을 나열해보면 다음과 같다
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597
 * 
 * n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.
 * 
 * [입력]
 * 첫번째 줄에 Testcase가 주어진다.
 * 두번째 줄부터 Testcase줄만큼 피보나치 수열의 n이 주어진다.
 * n은 10000보다 작거나 같은 자연수 또는 0이다.
 * 
 * [출력]
 * 첫번째 줄부터 Testcase줄만큼 n번째 피보나치 수를 출력한다.
 * 
 * [입력 예시]
 * 10
 * 
 * [출력 예시]
 * 55
 * 
 * [참고]
 * 피보나치 수열은 n의 증가에 따라 급격하게 증가하는 것을 알아둬야 한다.
 * 특히, n = 10000인 경우, int나 long의 표현 한계를 벗어나므로, 
 * BigInteger를 사용하여 해결할 수 있다.
 */
public class Java_0403_BigInteger_03_Fibonacci {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();

			BigInteger[] d = new BigInteger[Math.max(n + 1, 2)];
			d[0] = BigInteger.ZERO;
			d[1] = BigInteger.ONE;

			for (int j = 2; j <= n; j++) {
				d[j] = d[j - 1].add(d[j - 2]);
			}

			System.out.println("입력값 : " + n);
			System.out.println("출력값 : " + d[n]);
		}
		System.out.println("입력 종료");
	}
}
