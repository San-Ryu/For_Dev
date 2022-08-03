/*	2xN Ÿ�ϸ�
[����]
2xN ���簢���� 2x1�� 2x2 Ÿ�Ϸ� ä��� ����� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

[�������]
N�� 1 �̻� 1000 ������ �ڿ����̴�
(1 <= N <= 1000)

[�Է�]
 �Է��� ������ ���� �����Ǿ��ִ�.
ù��° �ٿ��� Test Case�� ���� T�� �־�����.
�� ���� T���� Test Case�� ���ʷ� �־�����.

Test Case�� ù° �ٿ��� N�� �־�����.

[���]
 �� ���� #T�� ���۵ǰ� (T�� Test case ��ȣ) ������ �ϳ� �� ����,
2xN ũ���� ���簢���� ä��� ����� ���� 10,007�� ���� �������� ����Ѵ�.
 
[�Է� ����]
3
2
8
12

[��� ����]
#1 3
#2 171
#3 2731
*/

/* ��ȭ�� ���� (�׸��� �׷��� ��)
N = 1�� ��, Answer = 1
N = 2�� ��, Answer = 3
N = 3�� ��, Answer = 5
N = 4�� ��, Answer = 11
N = 5�� ��, Answer = 21

21 = 11 + (5 * 2)
11 = 5 + (6 * 2)
5 = 3 + (1 * 2)

D[N] = D[N - 1] + (D[N - 2] * 2)
 */
// package SWCert_Completed_Professional;
package SWCert_PRO;

import java.io.FileInputStream;
import java.util.Scanner;

//public class Pro_B11727_DP_2NTile {
public class Main{
	static int N;
	static int Answer;

	static int D[];
	
	public static void main(String args[]) throws Exception{
//		System.setIn(new FileInputStream("D:\\Redan_Workspace\\SWCert_Src\\Input (Pro_B11727_2XNTile).txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			Answer = 0;
			N = sc.nextInt();

			D = new int[N + 1];
			D[0] = 0;	//	N = 0�� ��
			D[1] = 1;	//	N = 1�� ��
			D[2] = 3;	//	N = 2�� ��
			if(3 <= N) {
				for(int i = 3; i <= N; i ++) {
					D[i] = D[i - 1] + (D[i - 2] * 2);
				}
			}
			
			Answer = D[N]%10007;
			
			System.out.println("#" + test_case + " " + Answer);
		}
	}
}
