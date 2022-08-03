/* �ݻ��
[����]
�ſ��� �̿��� ������ �����Ϸ� �Ѵ�.
�ſ��� 2���� ���⸸�� ������, ��� �ſ��̴�.
���� 1 : /
���� 2 : \
(0, 0)���� ���������� ������ ���� ����� ��, ���簢�� ���� �� ������ ���� ������ �� ���� �ſ￡ �������� �ݻ�Ǵ��� �� ������ ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
�� ������ ������ 7�̴�.

[���� ����]
1. ���簢�� ���� ����� ���� �����Ǵ� 2���� N x N �迭�� N�� 5 �̻� 100 �����̴�.
2. (0, 0)���� �ſ��� ����.

[�Է�]
ù �ٿ��� Test Case�� �� ���� �־�����.
�� ���� �ٺ���, Test Case�� �־����µ�, �� Test Case�� N + 1 �ٷ� �����ȴ�.
�� Test Case�� ù° �ٿ��� N�� �־�����, ���� N �ٿ��� N x N �迭�� �־�����.
N x N �迭���� 0�� �ƹ��͵� ���� ������ ��Ÿ����, 1�� ���� 1�� �ſ�, 2�� ���� 2�� �ſ��� ��Ÿ����.

[���]
����� �� ���� "#T"�� �����ؾ��ϰ�, ������ �ϳ� �� ���� �������� �����ϴ� �ſ� ���� ����Ѵ�.
��, T�� Test Case ��ȣ�̴�.

[�Է� ����]
4
10
0 0 0 0 0 0 0 2 0 0
0 0 0 0 0 0 0 0 0 0 
0 0 0 0 1 2 0 0 0 1
0 0 0 0 0 0 0 0 0 0
0 0 0 0 1 0 0 1 0 0 
1 0 0 0 2 0 0 2 0 0 
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 2 0 0 0 0 1 0 0
0 0 0 0 0 0 0 0 0 0
5
0 2 0 0 0
0 0 0 0 0
0 2 0 1 0
2 0 0 1 0
0 2 0 0 0 
10
0 0 0 0 0 0 2 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 2 0 0 0 0 0 0
0 0 2 1 0 0 0 2 0 0
0 0 0 0 0 1 0 1 0 0
0 0 0 0 2 0 0 0 1 0
0 2 0 0 0 0 1 0 0 1
0 0 0 0 0 0 2 0 0 0
0 0 0 0 1 0 0 0 0 1 
0 0 2 0 0 0 0 0 0 1 
10
0 0 0 0 0 0 2 0 0 0 
0 0 0 0 0 0 0 2 0 1 
0 0 0 0 0 0 0 0 0 0
0 1 1 0 0 0 0 0 0 0
0 0 0 0 0 2 2 0 0 1
0 0 0 0 0 0 0 2 0 1 
0 0 0 2 1 0 2 0 2 0
0 0 0 0 0 1 0 0 0 0
0 0 0 0 0 0 0 0 0 1
0 1 0 0 0 0 0 0 0 0

[��� ����]
#1 7
#2 3
#3 3
#4 4
 */
package SWCert_INT;

import java.util.Scanner;
import java.io.FileInputStream;

public class IM_Reflector {
	static int T, N;
	static int pX, pY;
	static int Brd[][];
	static char Flag;
	static int AnsN;
	
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("D:\\Redan_Workspace\\SWCert_Src\\Input (Reflector).txt"));
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			AnsN = 0;
			
		//	Ipt
			Brd = new int[N + 2][N + 2];
			for(int i = 0; i <= (N + 1); i++) {
				if(i == 0) {
					for(int j = 0; j <= (N + 1); j++) {
						Brd[i][j] = 0;
						//	System.out.print(Brd[i][j] + " ");
					}
				}				
				else if(i == (N + 1)){
					for(int j = 0; j <= (N + 1); j++) {
						Brd[i][j] = 0;
						//	System.out.print(Brd[i][j] + " ");
					}
				}
				else {
					for(int j = 0; j <= (N + 1); j++) {
						if(j == 0) {
						Brd[i][j] = 0;
						//	System.out.print(Brd[i][j] + " ");
						}
						else if(j == (N + 1)) {
							Brd[i][j] = 0;
						//	System.out.print(Brd[i][j] + " ");
						}
						else {
							Brd[i][j] = sc.nextInt();
						//	System.out.print(Brd[i][j] + " ");
						}
					}
				}
				//	System.out.println();
			}

		pX = pY = 1;
		Flag = 'D';
		//	IPT
		
		//	Moving
		while(true) {
			if( 0 == pX || pX == (N + 1) || 0 == pY || pY == (N + 1)) {
				break;
			}
			if(Flag == 'W') {
				pY--;
				if(Brd[pY][pX] == 1) {
					Flag = 'D';
					AnsN++;
					continue;
				}
				else if(Brd[pY][pX] == 2) {
					Flag = 'A';
					AnsN++;
					continue;
				}
				else {
					continue;
				}
			}
			if(Flag == 'A') {
				pX--;
				if(Brd[pY][pX] == 1) {
					Flag = 'S';
					AnsN++;
					continue;
				}
				else if(Brd[pY][pX] == 2) {
					Flag = 'W';
					AnsN++;
					continue;
				}
				else {
					continue;
				}
			}
			if(Flag == 'S') {
				pY++;
				if(Brd[pY][pX] == 1) {
					Flag = 'A';
					AnsN++;
					continue;
				}
				else if(Brd[pY][pX] == 2) {
					Flag = 'D';
					AnsN++;
					continue;
				}
				else {
					continue;
				}
			}
			if(Flag == 'D') {
				pX++;
				if(Brd[pY][pX] == 1) {
					Flag = 'W';
					AnsN++;
					continue;
				}
				else if(Brd[pY][pX] == 2) {
					Flag = 'S';
					AnsN++;
					continue;
				}
				else {
					continue;
				}
			}
		}	//	End While
		
		System.out.println("#" + test_case + " " + AnsN);
		}	//	End Test Case
	}	//	End Main
}	//	End Class