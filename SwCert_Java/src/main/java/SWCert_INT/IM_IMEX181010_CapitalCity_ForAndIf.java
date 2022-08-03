/*	���� ��ġ ����
[����]
����� ��� ������ ������ �����ڸ� �̲��� �ִ�.
�����Ͽ� ���ο� ������ ��ô�ϱ� ����, ������ ��ġ�� �����Ϸ� �Ѵ�.

������ ��ġ�� ������ N x N ���簢�� ����̸�,
�� ��ȹ�� �Ը���, �ʿ�, ��, �� �� 4���� ������ �̷���� �ִ�.
1) �迭 �� �Ҹ����� 0, �ʿ��� 1, ���� 2, ���� 3���� ǥ���ȴ�.
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
4
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
3
1	2	3
3	2	1
2	1	3
7
1	3	2	0	1	3	0
0	2	1	1	3	0	2
1	0	0	1	2	2	3
3	2	1	1	0	3	1
1	2	3	0	0	0	1
1	3	2	3	1	3	0
3	2	3	2	1	3	0

[��� ����]
#1	7
#2	10
#3	9
#4	8
 */
package SWCert_INT;

import java.util.*;
import java.io.*;

public class IM_IMEX181010_CapitalCity_ForAndIf {
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
							if(Map[i - 1][j - 1] == 1	|| Map[i - 1][j] == 1	|| Map[i - 1][j + 1] == 1 
							|| Map[i][j - 1] == 1		|| Map[i][j] == 1		|| Map[i][j + 1] == 1 
							|| Map[i + 1][j - 1] == 1	|| Map[i + 1][j] == 1	|| Map[i + 1][j + 1] == 1 )	{	// �ʿ�	
								if(Map[i - 1][j - 1] == 2	|| Map[i - 1][j] == 2	|| Map[i - 1][j + 1] == 2 
								|| Map[i][j - 1] == 2		|| Map[i][j] == 2		|| Map[i][j + 1] == 2 
								|| Map[i + 1][j - 1] == 2	|| Map[i + 1][j] == 2	|| Map[i + 1][j + 1] == 2 )	{	//	��
									if(Map[i - 1][j - 1] == 3	|| Map[i - 1][j] == 3	|| Map[i - 1][j + 1] == 3 
									|| Map[i][j - 1] == 3		|| Map[i][j] == 3			|| Map[i][j + 1] == 3
									|| Map[i + 1][j - 1] == 3	|| Map[i + 1][j] == 3	|| Map[i + 1][j + 1] == 3 )	{	//	��
										Answer++;
									}
								}
							}
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
}	//	End Class