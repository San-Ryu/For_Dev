/*	���� ��ġ ����
[����]
����� ��� ������ ������ �����ڸ� �̲��� �ִ�.
�����Ͽ� ���ο� ������ ��ô�ϱ� ����, ������ ��ġ�� �����Ϸ� �Ѵ�.

������ ��ġ�� ������ N x N ���簢�� ����̸�,
�� ��ȹ�� �Ը���, �ʿ�, ��, �� �� 4���� ������ �̷���� �ִ�.
1) ������ �Ҹ��� �Ǵ� �Ҹ����� ������ ������ ��ġ�� �� ����.
2) ������ �ʿ�, �� ���� �ش��ϴ� 3���� ������ ��ġ�� �� �ִ�.
3) ���� �ֺ����� �ʿ�, ��, ���� �ش��ϴ� 3���� ������ ��� �� ���� �־�� �Ѵ�.

[���� ����]
������ ũ�⸦ ǥ���� N ���� 1 �̻� 100 ������ �����̴�.

[�Է�]
ù �ٿ��� Test Case�� ���� T�� �Էµȴ�.
�� Test Case�� ù �ٿ��� ������ ũ�⸦ ǥ���� N ���� �־�����,
�̾� N x N�� ������ �ش��ϴ� ���� �Էµȴ�.

[���]
�� ���� #T�� ���۵ǰ� ������ �ϳ� �� ����,
������ ������ �� �ִ� ������ ���� Answer�� ����Ѵ�.
(T�� Test Case ��ȣ) 

[�Է� ����]
2
5
1	3	2	0	1
2	1	3	2	2
0	3	3	2	1
3	2	1	1	3
0	1	0	1	2
5
1	1	1	1	1
2	2	2	2	2
3	3	3	3	3
2	2	2	2	2
1	1	1	1	1

[��� ����]
#1	
#2	10
 */
package SWCert_INT;

import java.util.*;
import java.io.*;

public class IM_IMEX181010_CapitalCity_BackTracking {
	static int N;
	static int Map[][];
	static int Answer;
	
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("D:\\Redan_Workspace\\SWCert_Src\\Input (IM_IMEX181010_CapitalCity).txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			//	Init.
			Answer = 0;
		//	Init.
			
		//	Ipt
			N = sc.nextInt();
			
			Map = new int[N + 2][N + 2];
			for(int i = 0; i < (N + 2); i++) {
				for(int j = 0; j < (N + 2); j++) {
					Map[i][j] = 4;
				}
			}
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					Map[i][j] = sc.nextInt();
				}
			}
		//	Ipt
			
		//	Oper
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(Map[i][j] != 0) {	//	���� ������ �Ҹ����� ��� ����
						if(Map[i - 1][j - 1] != 0	&& Map[i - 1][j] != 0	&& Map[i - 1][j + 1] != 0 
						&& Map[i][j - 1] != 0		 						&& Map[i][j + 1] != 0 
						&& Map[i + 1][j - 1] != 0	&& Map[i + 1][j] != 0	&& Map[i + 1][j + 1] != 0 ) {	//	�ֺ��� �Ҹ����� �ִ� ��� ����
							Check(i, j, 1);
						}
					}
				}
			}
		//	Oper
			
		//	Opt
			for(int i = 0; i < (N + 2); i++) {
				for(int j = 0; j < (N + 2); j++) {
					System.out.print(Map[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			System.out.println("#" + test_case + " " + Answer);
		//	Opt
		}	//	End Case
	}	//	End Main
	
	public static void Check(int i, int j, int n) {
		if(n == 4) {
			Answer++;
			return;
		}
		
		if(Map[i - 1][j - 1] == n	|| Map[i - 1][j] == n	|| Map[i - 1][j + 1] == n 
		|| Map[i][j - 1] == n		|| Map[i][j] == n		|| Map[i][j + 1] == n 
		|| Map[i + 1][j - 1] == n	|| Map[i + 1][j] == n	|| Map[i + 1][j + 1] == n)	{
			Check(i, j, n + 1);
			return;
		}
	}	//	End Check
}	//	End Class