/*	��������
 
[����]
 ����� �ձ��� ���� �ʴ� ������ Ž���ϴ� Ž����� ���̽�ķ������ ���� ������ ��û�ؿ���.
������ ���ڸ� �︮���Ϳ� �Ŵ޾� �����ϸ�, ���� ������ ����߷��ִ� ������� ����ȴ�.
Ž����� ���̽�ķ���� �����̸� �︮���Ͱ� �� ���̽�ķ�� ���ο� ���ڸ� �������־�߸� ������ �����Ѵ�.
���̽�ķ�� �ֺ��� ������ ���� ���ڸ� ķ�� �ۿ� �����ϴ� ���, ���輺 ������ ���ڸ� ������ �� �� ���� ������ �����Ѵ�. (������ ���� �� ����.)
���ڰ� ���̽� ķ���� ���(�� ��)�� ��Ȯ�� ���ϵ� ���, ���� �������� �����ȴ�.

���̽�ķ���� ��ġ�� XY ��ǥ���� ��ǥ�� �־�����. �������� �̷���� ���̽�ķ���� �߽� ��ǥ�� (Cx, Cy)�̸�, �������� R�� �־�����.

���� �������� (Sx, Sy)�� �־����� ��, ���� ���� ���θ� �Ǵ��ϴ� ���α׷��� �ۼ��Ͻÿ�.

[��������]
Cx, Cy, Sx, Sy�� ��� -10,000 �̻� 10,000 ������ �����̴�.
R�� 1000 ������ �ڿ����̴�.
<�׸� ����>

[�Է�]
10���� Test Case�� �־�����.
�� Test Case�� �� �ٷ� �����ȴ�
ù �ٿ��� Cx, Cy, R ���� ���ʷ� �־�����,
�ι�° �ٿ��� Sx, Sy ���� �־�����

[���]
�� ���� #T�� �����ϰ�, ������ �ϳ� �� ����,
�ش� Test Case���� ���� ���� ���� ���θ� 1 (����) / 0 (����)�� ����Ѵ�.

[�Է� ����]
3
5 6 3
7 8 
-3 5 8 
100 100
10 1 13
15 13

[��� ����]
#1 1
#2 0
#3 1
*/
package SWCert_INT;

import java.util.Scanner;
import java.io.FileInputStream;

public class SWCert_INT_Airdrop {
//����Ʈ ���� �ÿ��� �ݵ�� Class���� Main���� �����ؾ���
//public class Main{
	static int T;
	static int Cx, Cy, R, Sx, Sy;
	static int AnsN;
	
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("D:\\WS_Eclipse\\SwCert_Java\\src\\main\\java\\SWCert_INT\\Input (IM_Airdrop).txt"));
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			Cx = sc.nextInt();
			Cy = sc.nextInt();
			R = sc.nextInt();
			Sx = sc.nextInt();
			Sy = sc.nextInt();
			AnsN = 0;
			
			if((Sx - Cx) * (Sx - Cx) + (Sy - Cy) * (Sy - Cy) <= R * R) {
				AnsN = 1;
			}
			else {
				AnsN = 0;
			}
			
			System.out.println("#" + test_case + " " + AnsN);
		}
	}
}