/*	BOJ1000_A-B
[����]
�� ���� A�� B�� �Է¹��� ����, A-B�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

[�Է�]
ù° �ٿ� A�� B�� �־�����. (0 < A, B < 10)

[���]
ù° �ٿ� A-B�� ����Ѵ�.

[�Է� ����]
3 2

[��� ����]
1

*/
package SWCert_Basic;

import java.util.*;
import java.io.*;

public class VE_BOJ1001_AMinusB {
	static int A, B;
	static int AnsN;
	
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("Input (APlusB).txt"));
		Scanner sc = new Scanner(System.in);
		
		A = sc.nextInt();
		B = sc.nextInt();
		AnsN = A - B;
		
		System.out.println(AnsN);
	}
}