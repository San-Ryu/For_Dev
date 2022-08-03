/* ��ǰ�� �Ϸù�ȣ
[����]
 �� ����ȸ�翡���� ��ǰ �Ϸù�ȣ�� ���� �κп� ���ĺ� �ҹ��ڷ� ������ ���ڿ��� �̿��ϰ� �ִ�.
�� ���ڿ��� ����� ������ �ǹ��ϱ� ������ ��ǰ�� ����� ������� ���� ������ ���ĺ��� �����Ͽ� ���̰� �ִ�.

���� a, b, c, d 4���� ���ĺ� �ҹ��ڸ� �̿��ϴ� ���,
ù��° ����� ��ǰ���� ������� abcd, abdc, acbd, acdb, adcb, --- , dabc, dacb, dbac, dbca, dcab, dcba�� ���ڿ��� ��ǰ�� �ٿ����� �ȴ�.
�� �� adbc�� 5��° ����� ��ǰ��, bdca�� 12��° ����� ��ǰ�� �ٿ����� ���ڿ��� �ȴ�.
�׸���, �� ��ǰ�� �Ϸù�ȣ ���̿��� 6���� ��ǰ�� ����Ǿ����� �� �� �ִ�.

�Ϸù�ȣ�� ���ڿ��� ���Ǵ� ���ĺ� ���� N�� �־�����, �ΰ��� ���ڿ��� �־��� ��,
�� �Ϸù�ȣ ���ڿ� ���̿� ��� ��ǰ�� ����Ǿ����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
(��, ���� ���ڿ��� �Է°����� ����¢ ������, N���� ���ĺ��� �̿��ϴ� ���, a���� ���ĺ� ������� N������ ���ĺ� �ҹ��ڸ� �̿��Ͽ� �Ϸù�ȣ ���ڿ��� ����� �ȴ�.
��, 6���� ���ĺ� �̿�� a, b, c, d, e, f �̿�)

[�Է�]
���� Test Case�� ���� T�� �־�����,
���� �ٺ��� T���� Test Case�� �־�����.
Test Case�� �� �ٷ� �����Ǹ�, ó�� �Ϸù�ȣ�� ���Ǵ� ���ĺ��� ������ �־�����.
(��, 4 <= N <= 18)
���� ������ ���̿� �ΰ� �� ���� �Ϸù�ȣ ���ڿ��� �������� ���еǾ� �־�����.

[���]
�� Test Case�� ���Ͽ�, #T�� ����ϰ�, ������ �ϳ� �� ����,
�� �Ϸù�ȣ ���̿� ����� ��ǰ�� ������ ����Ѵ�.
��°��� 32 Bit �������� ���� ���� �����Ƿ�, 64 Bit ������ ������ ����Ѵ�.

[�Է� ����]
4
4 adbc bdca
5 ebdac eadcb
6 ecfabd dfcaeb
9 dgceabhf fhagbcde

[��� ����]
#1 6
#2 4
#3 76
#4 10606
*/
package SWCert_ADV;

import java.util.Scanner;
import java.io.FileInputStream;

public class AD_SerialN {
	static int T, N;
	static String A, B;
	static int[] visited = new int[100];
	static long AnsN;
	
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("D:\\Redan_Workspace\\SWCert_Src\\Input (SerialN).txt"));
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			A = sc.next();
			B = sc.next();
			
			AnsN = Math.abs((getIndex(A) - getIndex(B)) - 1);
			
			System.out.println("#" + test_case + " " + AnsN);
			
		}
	}

	public static long getIndex(String Perm) {
		long result = 1;
		
		for(int i = 0; i < N; i++) {
			visited[i] = 0;
		}
		
		int tmp, cnt;
		for(int i = 0; i < N; i++) {
			tmp = (int)(Perm.charAt(i) - 'a');
			cnt = countLessThan(tmp);
			
			result += cnt * fact(N - i - 1);
			
			visited[tmp] = 1;
		}
		return result;
	}
	
	public static int countLessThan(int value) {
		int result = 0;
		
		for(int i = 0; i < value; i++) {
			if(visited[i] == 0) {
				result++;
			}
		}
		return result;
	}
	
	public static long fact(long value) {
		if(value == 0) {
			return 1;
		}
		return value * fact(value - 1);
	}
}
