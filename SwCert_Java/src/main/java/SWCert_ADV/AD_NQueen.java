/* NQueen
[����]
NQueen ������ ũ�Ⱑ N*N�� ü���� ���� N���� ���� ���� ������ �� ���� ���� �����̴�.
N�� �־����� ��, ������ ���� ����� ���� ���Ͻÿ�.

[�Է�]
ù° �ٿ� N�� �־�����.
(��, 1 <= N <= 15)

[���]
ù° �ٿ� �� N���� ���� ������ �� ���� ���� ����� ���� ����Ѵ�.

[�Է� ����]
8

[��� ����]
92
 */
package SWCert_ADV;

import java.util.Scanner;
import java.io.FileInputStream;

public class AD_NQueen {
	static int T, N;	//	Testcase T // ���� N
	static int[] sol = new int [N];	//	�ַ�� ���� �迭
	static int[] col = new int [N];	//	�� ������ ���� ��ġ ����
	static int AnsN;	//	����� ��
	
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("D:\\Redan_Workspace\\SWCert_Src\\Input (NQueen).txt"));
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			backtrack(0);
			System.out.println("#" + test_case + " " + AnsN);
		}
	}	//	End Main
	
	public static void backtrack(int row) {
		if(isSolution(row)) {	//	�ַ�� ó�� ������ �����ȴٸ�,
			processSolution();	//	�ַ�� ó��
			return;	//	�޼ҵ带 �����Ͽ� �ǵ����� ����
		}
		
		loop:for(int i = 0; i < N; i++) {
			if(col[i] == 1) {
				continue loop;
			}
			
			for(int j = 0; j < row; j++) {
				if(Math.abs(row - j) == Math.abs(i - sol[j])) {
					continue loop;
				}
			}
			
			sol[row] = i;	//	���� ��ġ�� �� ����
			col[i] = 1;	// �� ��ġ
			
			backtrack(row+1);	//	���� ������ ��� ȣ��
			col[i] = 0;	//	�� ��ġ ����
		}
	}	//	End Backtrack
	
	public static boolean isSolution(int row) {	//	�ַ�� ó���� ���� ���� ���� ���� �޼ҵ�
		return (row == N);
	}	//	End isSolution
	
	public static void processSolution() {	//	�ַ�� ó�� �޼ҵ�
		AnsN ++;
	}	//	End processSolution
	
}	//	End Class
