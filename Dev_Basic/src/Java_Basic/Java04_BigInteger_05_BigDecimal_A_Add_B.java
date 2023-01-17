package Java_Basic;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

/*
 * [����]
 * A^B�� ��Ȯ�ϰ� ����Ͻÿ�.
 * 
 * [�Է�]
 * ù��° �ٿ� Testcase�� �־�����.
 * �ι�° �ٺ���, �Ǽ� A�� ���� B�� ������ ���̿� �ΰ� �־�����.
 * (��, 0 < A < 100, 1 <= B <= 100
 *  A�� �Ҽ��� �ִ� 9�ڸ�����
 *  �Ҽ��� 0���� ������ ���� ����.)
 * 
 * [���]
 * ù��° �ٺ��� A�� B ���� ���� ��µȴ�.
 * 
 * [�Է� ����]
 * 3.141592 13
 * 
 * [��� ����]
 * 2,903,669.4174153440472996217219716
 * 
 * [����]
 * BigDecimal ����������
 * Scanner�� nextBigDecimal �޼��带 ����� �� �ִ�.
 * (�ݵ�� math.BigDecimal�� Import ���ֵ��� �Ѵ�.)
 * 
 * [�Է�]
 * 3
 * 3.141592 13
 * 0.999999999 15
 * 1287.3284 25
 * 
 * [���]
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
			System.out.println("�Է°� A : " + a);
			System.out.println("�Է°� B : " + b);
			
			// 4���� ��츦 ���غ���
			BigDecimal c = a.pow(b);
			System.out.println("Case A"); // BigDecimal
			System.out.println("���� : " + c.getClass());
			System.out.println("��°� : " + c);
			System.out.println("Case B"); // String
			System.out.println("���� : " + c.toString().getClass());
			System.out.println("��°� : " + c.toString());
			System.out.println("Case C"); // String
			System.out.println("���� : " + c.toPlainString().getClass());
			System.out.println("��°� : " + c.toPlainString());
			// ���� ������ �� ������, �����ʹ� �޶�����			
		}
		System.out.println("�Է� ����");
	}
}
