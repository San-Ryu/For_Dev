/*	���� ��Ī (�Ǹ�)
[����]
���� �� ��, ���� N���� ĭ���� �̷���� ǥ�� �ִ�.
ù° ���� �� ĭ���� ���� 1, 2, 3, ---, N�� �ڷʴ�� ����ְ�,
��° ���� �� ĭ���� 1 �̻� N ������ ������ ���Ƿ� ����ִ�.

ù° �ٿ��� ���ڸ� ������ ������, �� ���� �������� �̷�� ���հ�, 
���� �������� �ٷ� ���� ��° �ٿ� ����ִ� �������� �̷�� ������ ��ġ�Ѵ�.
�̷��� ������ ������Ű���� �������� �̵�, �ִ�� ���� �̴� ����� ã�� ���α׷��� �ۼ��Ͻÿ�.

���� ���, N = 7�� ��� �Ʒ��� ���� ǥ�� �־����ٰ� �������� ��, 
1 2 3 4 5 6 7
3 1 1 5 5 6 6
ù° �ٿ��� 1, 3, 5�� �̴� ���� �����̴�.
 - ù° ���� 1, 3, 5 �ؿ��� ���� 3, 1, 5�� ������, �� ������ ��ġ�Ѵ�.
       �� ��, ������ ũ��� 3�̴�.
 - ���� ù° �ٿ��� 1�� 3�� ���̸�, �̵� �ٷ� �ؿ��� ���� 3�� 1�� �����Ƿ� �� ������ ��ġ�Ѵ�.
      �׷���, �� ��쿡 ���� ������ ������ �ִ�ġ���� �����Ƿ� ���� �� �� ����.

[�Է�]
�Է��� ù° �ٿ��� N(1 <= N <= 100)�� ��Ÿ���� ���� �ϳ��� �־�����.
�� ���� �ٺ��ʹ� ǥ�� ��° �ٿ� ���� �������� ������� �� �ٿ� �ϳ��� �Էµȴ�.

[���]
ù° �ٿ� #T�� �����ϸ�,
��° �ٿ� ���� �������� ������ ����ϰ� ������ �ϳ� �� ����,
���� �������� ���� ������ ū ���� ������ ������ �ϳ��� �ξ� ����Ѵ�.

[�Է� ����]
6
7
3 1 1 5 5 6 6
7
3 4 1 2 5 4 6 
7
3 4 1 2 5 4 6
7
1 2 3 4 0 0 0
10
1 2 3 4 5 6 7 8 9 10
10
10 9 8 7 6 5 4 3 2 1

[��� ����]
#1
3 1 3 5
#2
5 1 2 3 4 5
#3
5 1 2 3 4 5
#4
4 1 2 3 4
 */

/*	10�� �ڸ��� �Ѿ�� ��Ʈ���� ��� ���������� �˾ƾ߸� ��
 *	if (10�� �ڸ��� �Ѿ��) /10/ ������ �����Ͽ� �ް�,
 *	��Ʈ������ ��� �� Ư�����ڸ� �����ϸ鼭 �޴� ����� ������ �� �� ����.
 *	���߿� �غ���
 */
package SWCert_INT;

import java.util.*;
import java.io.*;

public class IM_JO1459_NumberMatching{
	static int N;	//	�ִ� �ڸ���
	static int L1[], L2[];	// 1 ~ N������ ���� & �־����� ����
	static int Answer;
	
	static int SetN;	//	���� �ڸ���
	static int Flag[];	//	��� ����, ��ġ�Ǵ� ���
	static String Match;
	static int Case;	//	��ġ�Ǵ� ����� ��
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("D:\\Redan_Workspace\\SWCert_Src\\Input (IM_NumberMatching).txt"));
		Scanner sc= new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {	//	Test_case
		//	Ipt
			N = sc.nextInt();	//	�ڸ��� N
			
			//	1 2 3 4 5 6 7
			L2 = new int[N];
			for(int i = 0; i < N; i++) {
				L2[i] = i + 1;
			}
			
			//	3 1 1 5 4 6
			L1 = new int[N];
			for(int i = 0; i < N; i++) {
				L1[i] = sc.nextInt();
			}
			
			SetN = 0;
			Case = 0;
			Flag = new int[N];
		//	Ipt
			
		//	Oper
			//	1�� ��ġ
			Match = "";
			for(int i = 0; i < N; i++) {
				if(L1[i] == L2[i]) {
					Case++;
					Match+= L1[i];
					L1[i] = 0;
				}
			}
			
			//	�� ��ġ
			for(int i = 0; i < N; i++){
				for(int j = 0; j < N; j++) {
					if((L1[i] == L2[j]) && (L1[j] == L2[i])) {
						Case+= 2;
						Match+= L1[i];
						Match+= L1[j];
						L1[i] = L1[j] = 0;
					}
				}
			}
			
			// String���� Array�� ��ȯ
			L1 = new int[N];
			for(int i = 0; i < Match.length(); i++){
				L1[i] = (int) Match.charAt(i) - '0';	//	L1 ��Ȱ��
			}
			
			// Sorting
			for(int i = 0; i < N; i++){
				for(int j = 0; j < N; j++) {
					int tmp = 0;
					if(L1[i] < L1[j]) {
						tmp = L1[j];
						L1[j] = L1[i];
						L1[i] = tmp;
					}
				}
			}
			
			//	Except 0
			for(int i = 0; i < N; i++){
				for(int j =  i + 1; j < N; j++) {
					if(L1[i] == 0) {
						L1[i] = L1[j];
						L1[j] = 0;
					}	
				}
			}
		//	Oper
		
		//	Opt
			System.out.println("#" + test_case);
			System.out.print(Case + " ");
			for(int i = 0; i < Match.length(); i++) {
				System.out.print(L1[i] + " ");
			}
			System.out.println();
		//	Opt
			
		}	//	End Test_case
	}	//	End Main
}	//	End Class
