/* ���� ����
���ڰ��� ���� ���� ���
Math. ���̺귯�� ���� ���� ���� ��� ����

[�Է� ����]
5
-1
-3
6
-10
10

[��� ����]
#1 1
#2 3
#3 6
#4 10
#5 10
*/
/*
1) ������ -1�� ���ϴ� ��� (Float ����)
2) ������ ���, for���� ���� 0���κ��� ������ �Ÿ��� Count
 */
package SWCert_Basic;

import java.util.Scanner;
import java.io.FileInputStream;

public class VE_ABS {
	static int A;
	
	static int tmp;
	public static void main(String arge[]) throws Exception{
		System.setIn(new FileInputStream("Input (VE_ABS).txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
		//	Init. & Ipt.
			tmp = 0;
			A = sc.nextInt();

		//	Init. & Ipt.
			
		//	Oper
			if(A < 0)	A *= -1;
			
			System.out.println("#" + tc + " " + A);
		//	Oper
		}	//	End Test Case
	}	//	End Main
}	//	End Class
