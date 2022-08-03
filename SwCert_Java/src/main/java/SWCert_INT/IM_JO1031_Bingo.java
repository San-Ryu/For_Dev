/*	���� ����
[����]
���� ������ ������ ���� ������� �̷�������.
���� �Ʒ��� ���� 25���� ĭ���� �̷���� �����ǿ� 1���� 25������ �ڿ����� �� ĭ�� �ϳ��� ����.

11	12	2	24	10
16	1	13	3	25
6	20	5	21	17
19	4	8	14	9
22	15	7	23	18

������ ��ȸ�ڰ� �θ��� ���� ���ʷ� ����������.
���� ��� 5 10 7�� �ҷȴٸ�, �� �� ���� ���� �� �������� ����� ������ ����.

11	12	2	24	X
16	1	13	3	25
6	20	X	21	17
19	4	8	14	9
22	15	X	23	18

���ʷ� ���� �������ٰ� ���� ����/������ �Ǵ� �밢�� ���� �ִ� 5���� ��� ���� �������� ���,
�� �ٿ� ���� �ߴ´�.

11	12	X	24	X
X	1	X	X	25
6	20	X	21	X
19	X	X	14	9
X	15	X	23	18

�̷��� ���� �� �� �̻� �׾����� ���� "����"��� ��ġ�µ�,
���� ���� ��ġ�� ����� ������ ���ڰ� �ȴ�.

11	12	X	24	X
X	X	X	X	X
6	20	X	21	X
19	X	X	14	9
X	15	X	23	18

ö���� ģ����� ���� ������ �ϰ� �ִ�.
ö���� �����ǿ� �� ����� ��ȸ�ڰ� �θ��� ���� ������ �־��� ��,
��ȸ�ڰ� ���° ���� �θ� �� ö���� "����"�� ��ġ�� �Ǵ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

[�Է�]
ù° �ٺ��� �ټ�° �ٱ��� �����ǿ� ������ ���� ���� �� �����ٷκ��� ���ʴ�� �� �ٿ� �ټ����� ��ĭ�� ���̿� �ΰ� �־�����.
����° �ٺ��� ��° �ٱ��� ��ȸ�ڰ� �θ��� ���� ���ʴ�� �� �ٿ� �ټ����� ��ĭ�� ���̿� �ΰ� �־�����.
�����ǿ� ������ ���� ��ȸ�ڰ� �θ��� ���� ���� 1���� 25������ ���� �ѹ��� ���ȴ�.

[���]
ù° �ٿ� ��ȸ�ڰ� ���° ���� �θ� �� ö���� "����"�� ��ġ�� �Ǵ��� ����Ѵ�.

[�Է� ����]
11	12	2	24	10
16	1	13	3	25
6	20	5	21	17
19	4	8	14	9
22	15	7	23	18
5	10	7	16	2
4	22	8	17	13
3	18	1	6	25
12	19	23	14	21
11	24	9	20	15

[��� ����]
15
 */
package SWCert_INT;

import java.util.*;
import java.io.*;

public class IM_JO1031_Bingo {
	static int Player[][];
	static int MC[];
	static int Answer;
	
	static int N, tmp, cnt, BingoCnt;
	static int Num;
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("D:\\Redan_Workspace\\SWCert_Src\\Input (IM_JO1031_Bingo).txt"));
		Scanner sc = new Scanner(System.in);
		
		N = 5;
		tmp = cnt = BingoCnt = 0;
		Player = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				Player[i][j] = sc.nextInt();
			}
		}
		
		MC = new int[N * N];
		for(int i = 0; i < N * N; i++) {
			int Flag = 0;
			if(12 <= cnt) {
				Check();
				if(3 <= BingoCnt) {
					break;
				}
			}
			
			MC[i] = sc.nextInt();
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < N; k++) {
					if(MC[i] == Player[j][k]) {
						cnt++;
						Player[j][k] = 0;
						Flag = 1;
						break;
					}
				}
				if(Flag ==1) {
					break;
				}
			}
		}
		
		System.out.println(Answer);
		
		//	End Test Case
	}	//	End Main
	
	public static void Check() {
		BingoCnt = 0;
		for(int j = 0; j < N; j++) {
			tmp+= Player[j][j];
		}
		if(tmp ==0) {
			BingoCnt++;
		}
		tmp = 0;
		
		for(int j = 0; j < N; j++) {
			int k = N - j - 1;
			tmp+= Player[k][j];
		}
		if(tmp == 0) {
			BingoCnt++;
		}
		tmp = 0;
		
		for(int j = 0; j < N; j++) {
			for(int k = 0; k < N; k++) {
				tmp+= Player[k][j];
			}
			if(tmp == 0) {
				BingoCnt++;
			}
			tmp = 0;
		}
		
		for(int j = 0; j < N; j++) {
			for(int k = 0; k < N; k++) {
				tmp += Player[j][k];
			}
			if(tmp == 0) {
				BingoCnt++;
			}
			tmp = 0;
		}
		
		if(3 <= BingoCnt) {
			Answer = cnt;
		}
	}	//	End Check
}	//	End Class