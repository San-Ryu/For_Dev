package Java_Basic;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

/*
 * [����]
 * A + B�� ����Ͻÿ�.
 * 
 * [�Է�]
 * ù��° �ٿ� Testcase�� �־�����.
 * �ι�° �ٺ���, �� A�� �� B�� ������ ���̿� �ΰ� �־�����.
 * (��, 0 < A, B < 10^10000)
 * 
 * [���]
 * ù��° �ٺ��� A�� B�� ���� ��µȴ�.
 * 
 * [�Է� ����]
 * 999999999999 1000000
 * 
 * [��� ����]
 * 1000000999999
 * 
 * [����]
 * Scanner�� nextBigInteger �޼��带 ����� �� �ִ�.
 * 
 * [�Է�]
 * 2
 * 999999999 100000
 * 999999999999 1
 * 
 * [���]
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

			System.out.println("�Է°� A : " + a);
			System.out.println("�Է°� B : " + b);
			// System.out.println("��°� : " + a + b); // �̷��� ����, a�� b�� ���ڿ�ó�� �پ ��µȴ�. (����)
			System.out.println("��°� : " + a.add(b));
		}
		System.out.println("�Է� ����");
	}
}
