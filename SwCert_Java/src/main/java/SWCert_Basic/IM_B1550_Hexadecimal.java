/* 16����
[����]
16���� ���� �Է¹޾Ƽ� 10������ ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

[�Է�]
�Է��� ������ ���� �����Ǿ��ִ�.
ù��° �ٿ��� Test Case�� ���� T�� �־�����.
�� ���� T���� Test Case�� ���ʴ�� �־�����.

Test Case�� ù° �ٿ��� 16���� ���� �־�����.

[���]
�� ���� #T�� ���۵ǰ� (T�� Test Case ��ȣ) ������ �ϳ� �� ����,
16���� N�� 10�������� ����Ѵ�.

[�Է� ����]
3
A
AB
ABC

[��� ����]
#1 10
#2 171
#3 2748
 */
package SWCert_Basic;

import java.io.*;
import java.util.*;

public class IM_B1550_Hexadecimal {
	static String N;	//	Number N
	static int Answer;	//	Answer
	
	static int Len, tmp[];
	
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream(""));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.next();
			Answer = 0;
			
			Len = N.length();
			tmp = new int[Len];
			for(int i = 0; i < Len; i++) {
				tmp[i] = (int) N.charAt(i);
				if(('0' <= tmp[i]) && tmp[i] <= '9') {
					tmp[i]-= '0';
				}
				else	tmp[i] = tmp[i] - 'A' + 10;
						
				Answer+= tmp[i] * (int) Math.pow(16, (Len - (i + 1)));
//				Answer+= tmp[i] * (int) (16 ^ (Len - (i + 1)));
			}
			
			System.out.println("#" + tc + " " + Answer);
		}	//	End Test Case
	}	//	End Main Method
}	//	End Class