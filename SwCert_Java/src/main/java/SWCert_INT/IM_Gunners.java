/* ������
����/������ �׸� ĭ��� �̷���� �濡 �����̵��� �ִ�.
�� �����̵��� �ڽ��� ��ġ�κ��� ��, ��, ��, ���� ���� ���⸸ �� �� ������, (�밢���� �� �� ����)
�̵� �þ߿� ��ǥ���� ���� ��� ��ü���� ���� ��� ��ǥ���� ������.

�׷��� �� �濡�� ���� �����ϸ�, �����̵��� �� �ʸӷδ� �� �� ����.
����, ��ǥ�� �ʸ��� ��ǥ�� �Ǵ�, �ٸ� ������ �ʸ��� ��ǥ���� �� �� ����.

��� �� �� �̻��� �������� ��ǥ�� �Ǵ� ��ǥ���� �� ������ ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

[��������]
1) ���� ���� ĭ �� Ri�� ���� ĭ �� Rj�� ���� 20 ������ �ڿ����̴�.
2) �����̿� ��ǥ���� ��ĭ�� �ִ� �ϳ��� ������ �� ������, �����̿� ��ǥ���� ���� ĭ�� ���ÿ� ������ �� ����.
3) �������� �� G�� ��ǥ���� �� T�� 100�� ���� �ʴ´�.
4) �����̳����� ���� ��ǥ���� �� �� ����.

[�Է�]
�Է��� ������ ���� �����Ǿ��ִ�.
ù��° �ٿ��� Test Case�� ���� T�� �־�����.
�� ���� T���� Test Case�� ���ʷ� �־�����.

�� Test Case�� ������ ���� �����Ǿ��ִ�.
ù �ٿ� ���� ���� ĭ �� Ri, ���� ĭ �� Rj�� �������� ���еǾ� ���ʴ�� �־�����.
�� ���� Ri �ٿ� ���� ���� ������ ��Ÿ���� 2���� �迭�� �� ���� ���� ������� �־�����.
�� �ٴ� Rj���� ���� �������� ���еǾ� �����Ǹ�,
���� ����ִ� ĭ�� ��� 0, �����̰� �ִ� ��� G, 
      ��ǥ���� �ִ� ĭ�� T, ���� �ִ� ĭ�� W
�� �����ȴ�.

[���]
�� ���� #T�� ���۵ǰ� ������ �ϳ� �� ����,
��� �� �� �̻��� �������� ��ǥ�� �Ǵ� ��ǥ���� �� ������ ����Ѵ�.
(T�� Test Case ��ȣ) 

[�Է� ����]
3
5 7
T 0 T 0 G 0 G
0 W T W W W 0
T W G 0 T W T
0 0 0 T G W 0
0 0 T 0 0 W 0
2 10
T W 0 G 0 W 0 G 0 W
G 0 T W T 0 T W T 0
3 3
T G T
G T G
T G T

[��� ����]
#1 6
#2 2
#3 5
 */
package SWCert_INT;

import java.util.Scanner;
import java.io.FileInputStream;

public class IM_Gunners {
	static int T, Ri, Rj;
	static int AnsN;
	
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("D:\\Redan_Workspace\\SWCert_Src\\Input (Gunners).txt"));
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			AnsN = 0;
			Ri = sc.nextInt();
			Rj = sc.nextInt();
			
			char[][]room = new char[Ri][Rj];
			for(int i = 0; i <= (Ri - 1); i++) {
				for(int j = 0; j <= (Rj - 1); j++) {
					String tmp = sc.next();
					room[i][j] = tmp.charAt(0);

					if(room[i][j] == 'T') {	
						//	Gunner ��ġ (X ������)
						for(int k = 1; k < (Ri - i); k++) {
							if(room[i + k][j] == 'T' || room[i + k][j] == 'W') {
								break;
							}
							else if(room[i + k][j] == 'G') {
								AnsN++;
								break;
							}
						}
						
						//	Gunner ��ġ (X ������)
						for(int l = 1; l < i; l++) {	
							if(room[i - l][j] == 'T' || room[i - l][j] == 'W') {
								break;
							}
							else if(room[i - l][j] == 'G') {
								AnsN++;
								break;
							}
						}
						
						//	Gunner ��ġ (Y ������)
						for(int m = 1; m < (Rj - j); m++) {
							if(room[i][j + m] == 'T' || room[i][j + m] == 'W') {
								break;
							}
							else if(room[i][j + m] == 'G') {
								AnsN++;
								break;
							}
						}
						
						//	Gunner ��ġ (Y ������)
						for(int n = 1; n < j; n++) {
							if(room[i][j - n] == 'T' || room[i][j - n] == 'W') {
								break;
							}
							else if(room[i][j - n] == 'G') {
								AnsN++;
								break;
							}
						}
					}
				}
			}
			System.out.println("#" + test_case + " " + AnsN);
		}	//	End Test_Case
	}	//	End Main	
}	//	End Class