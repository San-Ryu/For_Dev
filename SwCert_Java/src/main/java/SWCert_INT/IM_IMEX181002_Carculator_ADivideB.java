/*	���ڰ��� - ������
[����]
���ڰ����� �������� �����Ϸ� �Ѵ�.
A�� B�� ������ ��� �������� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

[���� ����]
A�� 10�ڸ��� �ڿ���
B�� 8�ڸ��� �ڿ���
(B�� A���� Ŭ �� ����)

[�Է�]
�Է��� ������ ���� �����Ǿ��ִ�.
ù��° �ٿ��� Test Case�� ���� T�� �־�����.
�� ���� T���� Test Case�� ���ʷ� �־�����.

�� Test Case�� �� �ٷ� �̷���� ������,
�� �� A�� B�� ������ ���̿� �ξ� ���ʴ�� �Էµȴ�. 

[���]
�� ���� #T�� ���۵ǰ� ������ �ϳ� �� ����,
Quotient�� Remainder��, ������ ���̿� �ξ� ���ʴ�� ����Ѵ�.
(T�� Test Case ��ȣ) 
(Quotient�� A�� B�� ���� ��)
(Remainder�� A�� B�� ���� ������)

[�Է� ����]
3
9999999999 12345
12535 5
9513574268 9562

[��� ����]
#1
#2
#3
*/
package SWCert_INT;

import java.util.*;
import java.io.*;

public class IM_IMEX181002_Carculator_ADivideB {
	static int A[] = new int[101];
	static int B;
	static int LA, L;
	static int Quotient[] = new int[101];
	static int Remainder;
	
	static int AA;
	
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("D:\\Redan_Workspace\\SWCert_Src\\Input (IM_IMEX181002_Carculator_ADivideB).txt"));
		Scanner sc = new Scanner(System.in);
		
		String buffer;
		
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			buffer = sc.next();
			LA = buffer.length();
			for(int i = 0; i < LA; i++) {
				A[i] = (int)(buffer.charAt(i) - '0');
				System.out.print(A[i]);
			}
			System.out.println();
			
			AA = 0;
			for(int i = (LA - 1); 0 <= i; i--) {
				AA+= A[i] * (int) Math.pow(10, LA - 1 - i);
			}
			System.out.println(AA);
			
			B = sc.nextInt();
			/*	�˰���
				�˰���
				�˰���	*/
			
			System.out.print("#" + test_case + " ");
			
			for(int i = 0; i < L; i++) {
				System.out.println(Quotient[i]);
			}

			System.out.println(" " + Remainder);
			
		}
	}
}
