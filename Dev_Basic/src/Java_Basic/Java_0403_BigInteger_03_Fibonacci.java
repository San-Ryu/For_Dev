package Java_Basic;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

/*
 * [����]
 * �Ǻ���ġ ���� 0�� 1�� �����Ѵ�.
 * 0��° �Ǻ���ġ ���� 0�̰�,
 * 1��° �Ǻ���ġ ���� 1�̴�.
 * �� ���� 2��°���ʹ� ���� �� �Ǻ���ġ ���� ���� ������ ������ �����ȴ�.
 * �̸� ��ȭ������ ǥ���ϸ�, 
 * F[n] = F[n-1] + F[n-2] (��, n >= 2)
 * �� �ȴ�.
 * 
 * n = 17�� �� �Ǻ���ġ ������ �����غ��� ������ ����
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597
 * 
 * n�� �־����� ��, n��° �Ǻ���ġ ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * [�Է�]
 * ù��° �ٿ� Testcase�� �־�����.
 * �ι�° �ٺ��� Testcase�ٸ�ŭ �Ǻ���ġ ������ n�� �־�����.
 * n�� 10000���� �۰ų� ���� �ڿ��� �Ǵ� 0�̴�.
 * 
 * [���]
 * ù��° �ٺ��� Testcase�ٸ�ŭ n��° �Ǻ���ġ ���� ����Ѵ�.
 * 
 * [�Է� ����]
 * 10
 * 
 * [��� ����]
 * 55
 * 
 * [����]
 * �Ǻ���ġ ������ n�� ������ ���� �ް��ϰ� �����ϴ� ���� �˾Ƶ־� �Ѵ�.
 * Ư��, n = 10000�� ���, int�� long�� ǥ�� �Ѱ踦 ����Ƿ�, 
 * BigInteger�� ����Ͽ� �ذ��� �� �ִ�.
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

			System.out.println("�Է°� : " + n);
			System.out.println("��°� : " + d[n]);
		}
		System.out.println("�Է� ����");
	}
}
