/*	<���ð�ȹ>
[����]
 �α��� ������ ���ߵǾ�, ���� �ұ������� ������ �ΰ� �ִ� ���� �ִ�.
�� ���󿡼��� �̸� �ذ��ϱ� ����, ���� �α��� �л��ų �� �ִ� �ŵ��ø� �Ǽ��Ϸ� �Ѵ�.

 �ŵ��ø� ���� ������ ���� ���̰� N�� ���簢�� �����̸�,
�� ������ ����, ���� ���̰� 1�� ��ȹ���� ���������ִ�.
(N�� �ڿ���, �ٵ�����)

 ���󿡼��� ������ ������ ���� ������ �����Ͽ�����, �� ���� ��ȹ���� ������ ������ ��ȹ�̴�.
����, �ŵ��� �������� ���� �������� �����ϱ� ���� ������ ���� ������ �����Ѵ�.
1) ������ �����ڸ� ��ȹ�� ��� ������ ����
2) ���� ��ȹ�� 1���� ����
3) ���� ��ȹ�� ���� ��ȹ�� �����¿� �� ��� �� �� �̻� �������ִٸ�,
	�� ��ȹ�� ���� ���̴� 1�̴�
4) ���� ��ȹ�� ���� ��ȹ�� �����¿� �� ��� �� ���� ���������� �ʴٸ�,
	�� ��ȹ�� ������ ���� �������� �����ȴ�.
	������ ���̴� �� ��ȹ�� �߽����� �����¿켱�� ��ġ�� ��� ������ ��ȹ�� �����̴�.
	(�߽��� �Ǵ� ��ȹ�� ���Եȴ�)

G  G  G  G  G  G  G  G 
G  G  G  B  G  G  G  G
G  G  G  B  B  B  G  G
G  B  B  B  B <B> B  G 
G  G  G  B (B) B  G  G
G  G  G  B  G  G  G  G
G  G  G  G  G  B  G  G
G  G  G  G  G  G  G  G

 N = 8�� ����� �����̴�.
(������ȹ : G / ���� ��ȹ : B)
(B) - ���� ���� : 1 (���� ����)
<B> - ���� ���� : 9 (������ B ����)

 �̴�� ��ȹ�� ��ȹ�� ��� ������ �������� ��,
�� �������� ���� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

[��������]
N�� 3 �̻� 20 ������ �ڿ���

[�Է�]
T���� Test Case�� �־�����.
�� Test Case�� �Ʒ��� ���� �������� �־�����.
ù�ٿ� N ���� �־�����.
�� ������ N �ٿ� ������ ��ȹ ������ �ش��ϴ� �ڷᰡ ���ٿ� ���྿ ���ʷ� �־�����.
���� ��ȹ�� G / �ǹ� ��ȹ�� B�� ǥ�õȴ�.

[���]
�� ���� #T�� �����ϰ�, ������ �ϳ� �� ����,
�ش� Test Case������ ��°��� ��Ÿ����.
 
[�Է� ����]
3
3
G G G
G B G
G G G
5
G G G G G
G B B G G
G B B B G
G B B B G
G G G G G
8
G G G G G G G G 
G G G B G G G G
G G G B B B G G
G B B B B B B G 
G G G B B B G G
G G G B G G G G
G G G G G B G G
G G G G G G G G 

[��� ����]
#1 1
#2 12
#3 39
*/
package SWCert_INT;

import java.util.Scanner;
import java.io.FileInputStream;

public class IM_CityPlanning {
	static int T, N;	//	T = Test Case, N = Length of Sides
	
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("D:\\Redan_Workspace\\SWCert_Src\\Input (CityPlanning).txt"));	//	Input File
		Scanner sc = new Scanner(System.in);
				
		T = sc.nextInt();	//	Ipt : Test Case
		for(int test_case = 1; test_case <= T; test_case++) {
		//	Case Start
			//	Ipt ( + Def. / Init.)
			int AnsN = 0;	//	Def. & Init. : AnsN (Sum Of Height)
			N = sc.nextInt();	//	Ipt : N
			
			char [][]map = new char [N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					String tmp = sc.next();	//	Ipt txt To tmp (Must String)
					map[i][j] = tmp.charAt(0);	// Ipt tmp To map[][] 
				}
			}
			//	Ipt
			
			// Get AnsN
			for(int i = 0; i <= (N-1); i++) {
				for(int j = 0; j <= (N-1); j++) {
					if(map[i][j] == 'B') {
						if(map[i - 1][j] == 'G' || map[i + 1][j] =='G'
						   || map[i][j - 1] == 'G' || map[i][j + 1] =='G') {	//	Close by G
							AnsN++;
						}
						else {	//	Not Close by G
							int cnt = 0;	//	Def. & Init. : cnt (Height Of Building)
							for(int k = 1; k < N; k++) {	//	Axis X (Horizontal)
								if(map[i][k] == 'B') {
									cnt++;
								}
							}
							for(int k = 1; k < N; k++) {	//	Axis Y (Vertical)
								if(map[k][j] == 'B') {
									cnt++;
								}
							}
							cnt--;	//	To Prevent Duplication of map[i][j] Height 
							AnsN+= cnt;	//	AnsN
						}
					}
				}
			}	//	Get AnsN
			
			//	Opt
			System.out.println("#" + test_case + " " + AnsN);
			//	Opt
			
		}	//	End Case
	}	//	End Main
}	//	End Class
