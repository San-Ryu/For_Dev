package SwCert;

import java.io.*;
import java.util.*;

/* ���� ����

[����]
������ ������ ���߹��� �����ִ�.
���߹��� ��ȭ���� ��ȭ�� �� ���� �ð� �ڿ� �����ϸ�, ��ȭ���� ���̴� ���߹����� �ٸ���.
���߹��� ������ ���, �� ���� �����¿쿡 �ִ� ���߹��� ��ȭ���� ���� ���̸�, �̴� ���� ���߷� �̾�����.

���� ������ ���������� ���߹��� ������ ���ο� �����ִ� ���,
������ ���� ��� ���߹��� ��ȭ���� ���� �پ�, ��� ���߹��� �����Ѵ�.

���߹� �����ڴ� �������� ��ź�� ���� ���̰�, ���� ������ ����Ű�� ������ �����ϰ� �ִ�.
���߹��� ���� ���̰� ����, �������� ��� ���߹��� ������ ������ �ɸ��� �ð��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

������ ���� ���� ����� ��,
1   0  (3)  4	-> �Ұ�ȣ ���߹� : ���� ���۽� ��ȭ�Ǵ� ���߹� 
0   0   2   4 
5   7   5   3 
7   2   3   8

3�ʰ� ���� ��������, ������ ���߹��� �����ϰ� �ǰ�,
4, 1 ������ ���߹� (4)��
3, 2 ������ ���߹� (2)�� ��ȭ���� ���� �ٴ´�.

1   0  (3) {4}	-> �Ұ�ȣ ���߹� : ���� ���۽� ��ȭ�Ǵ� ���߹�  
0   0  {2}  4 	-> �߰�ȣ ���߹� : ���� ���߹�
5   7   5   3 
7   2   3   8

2�� ������ �Ͼ ���� ������ ������ ����.

1   0  (3) {4}	-> �Ұ�ȣ ���߹� : ���� ���۽� ��ȭ�Ǵ� ���߹�  
0   0  {2} [4] 	-> �߰�ȣ ���߹� : 2�� ���߹�
5   7  [5]  3	-> ���ȣ ���߹� : 3�� ���߹� 
7   2   3   8

[�Է�]
T
N M MX MY Map[][]

[���]
#T AnsN
AnsN�� ���߿� �ɸ��� �� �ð�.

[�Է� ����]
5
4 1 1 3 1 0 3 4 0 0 2 4 5 7 5 3 7 2 3 8
4 2 1 1 3 3 1 0 2 3 0 0 4 5 6 7 8 9 10 11 12 13
4 1 1 1 10 0 1 2 0 0 3 4 5 6 7 8 9 10 11 12 
8 1 1 1 1 0 1 0 1 0 1 0 0 1 0 1 0 1 0 1 1 0 1 0 1 0 1 0 0 1 0 1 0 1 0 1 1 0 1 0 1 0 1 0 0 1 0 1 0 1 0 1 1 0 1 0 1 0 1 0 0 1 0 1 0 1 0 1
4 1 1 1 1 1 1 0 0 1 1 0 0 1 1 0 0 1 1 1 1 1
//�Ǵ�
5
4 1 1 3 1 0 3 4 0 0 2 4 5 7 5 3 7 2 3 8
4 2 1 1 3 3 1 0 2 3 0 0 4 5 6 7 8 9 10 11 12 13
4 1 1 1 10 0 1 2 0 0 3 4 5 6 7 8 9 10 11 12 
8 1 1 1 
1 0 1 0 1 0 1 0
0 1 0 1 0 1 0 1
1 0 1 0 1 0 1 0
0 1 0 1 0 1 0 1
1 0 1 0 1 0 1 0
0 1 0 1 0 1 0 1
1 0 1 0 1 0 1 0
0 1 0 1 0 1 0 1
4 1 1 1 1 1 1 0 0 1 1 0 0 1 1 0 0 1 1 1 1 1

[��� ����]
#1 23	//	�Ϲ����� ���
#2 42	//	2���� ���߹�, �ϳ��� ���� ������ ����Ŵ.
#3 22	//	1���� ���߹�, ���� ������ �Ͼ�� ����.
#4 20	//	1���� ���߹�, ���� ������ �Ͼ�� ����.
#5		//	One-Way
 */
public class SWCert_AD_EX181213_ChainExplosion {
//����Ʈ ���� �ÿ��� �ݵ�� Class���� Main���� �����ؾ���
//public class Main{
	static int N, M;	//	�迭�� �� �� N, ���� �������� ���� M
	// static int X[], Y[];	//	���� �������� X, Y	(������� �ʰ�, ArrayList�� ��ü��)
	static int Map[][];	//	�� ���� (��ġ�� ��ź�� ��ȭ��)
	static int AnsN;	//	�����
	
	static int Stat[][];	//	���� ������ ���� Visited
	static int SumTime, SumRemain;	//	���� ������ �ð�, ���� ���� ������ ���� ��ȭ(�� ���� ����)
	
	static int dx[] = {-1, 0, 0, 1};	//	���Ž�� �迭 X
	static int dy[] = {0, -1, 1, 0};	//	���Ž�� �迭 Y
	
	static ArrayList<Integer> arrx;	//	���� ������ ��ź�� X��ǥ
	static ArrayList<Integer> arry;	//	���� ������ ��ź�� X��ǥ
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("Input (AD_EX181213_ChainExplosion).txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
		//	Ipt.
			AnsN = 0;
			SumTime = 0;
			SumRemain = 0;
			
			N = sc.nextInt();
			M = sc.nextInt();
			
			Stat = new int[10][10];
			arrx = new ArrayList<>();
			arry = new ArrayList<>();
			//	Caution : ���������� (1, 1) ~ (N, N)�� ��ǥ�踦 �Է�������,
			//			  (0, 0) ~ (N - 1, N - 1) ��ǥ�谡 �ͼ��Ͽ� �����Ͽ� ����
			//			   ����, ���������� �迭�� Map[Y][X] ��ǥ�踦 ���������,
			//			  Map[X][Y] ��ǥ�谡 �ͼ��Ͽ� �����Ͽ� ����.
			for(int i = 0; i < M; i++) {
//				X[i] = sc.nextInt();
//				Y[i] = sc.nextInt();
				
				int tmpx = sc.nextInt() - 1;
				int tmpy = sc.nextInt() - 1;
				//	(N - 1) ��ǥ��� ��ȯ
				arrx.add(tmpx);
				arry.add(tmpy);
				Stat[tmpx][tmpy] = 1;
			}
			
			Map = new int[10][10];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					Map[i][j] = sc.nextInt();
					
					if(Stat[i][j] == 1) {
						Stat[i][j] = Map[i][j];
					}
					System.out.print(Map[i][j] + " ");
				}
				System.out.println();
			}
			
		//	Ipt.
			
			while(!(arrx.isEmpty() && arry.isEmpty())) {
				//	���� ���� ������ ���� ���� (���߹��� "����" ������ ���� �����߽��ϴ�.)
				for(int i = 0; i < M; i++) {
					for(int j = 1; j < M; j++) {
						if(Stat[arrx.get(i)][arry.get(i)] < Stat[arrx.get(j)][arry.get(j)]);
						int tmpx = arrx.get(i);
						int tmpy = arry.get(i);
						
						arrx.set(i, arrx.get(j));
						arry.set(i, arry.get(j));
						arrx.set(j, tmpx);
						arry.set(j, tmpy);
					}
				}
				//	���� ���� ������ ���� ����

				int tmp = arrx.size();
				for(int i = 0; i < tmp; i++) {
					//	���� ��ǥ �Է�
					int cx = arrx.get(i);
					arrx.remove(i);
					int cy = arry.get(i);
					arry.remove(i);
					
					//	ArrayList�� Element���� ���ϴ¸�ŭ�� ����ϱ� ����.
					i--;
					tmp--;
					
					for(int j = 0; j < dx.length; j++) {
						//	Ž�� ��ǥ �Է�
						int nx = cx + dx[j];
						int ny = cy + dy[j];
						
						//	�� ������ ����� ��� ����
						if(nx < 0 || (N - 1) < nx || ny < 0 || (N - 1) < ny)	continue;
						//	���߹��� ���� ��� ����
						if(Map[nx][ny] == 0)	continue;
						
						if(Stat[nx][ny] == 0) {	//	���� �湮�� ���
							Stat[nx][ny] = Stat[cx][cy] + Map[nx][ny];
							arrx.add(nx);
							arry.add(ny);
						}
						else if(Stat[nx][ny] != 0) {
							Stat[nx][ny] = Math.min(Stat[nx][ny], Stat[cx][cy] + Map[nx][ny]);
						}
					}
				}
				
//				for(int i = 0; i < N; i++) {
//					for(int j = 0; j < N; j++) {
//						System.out.print(Stat[i][j] + " ");
//					}
//					System.out.println();
//				}
//				System.out.println("==================");
				
			}	//	End Chain Explosion
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(Stat[i][j] != 0) {	//	������ ���߹�
						SumTime = Math.max(SumTime, Stat[i][j]);
					}
				}
			}	//	Calc. Chain Explosion
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if((Stat[i][j] == 0) && (Map[i][j] != 0)) {	//	�������� ���� ���߹�
						SumRemain = Math.max(SumRemain, Map[i][j]);
					}
				}
			}	//	Calc. Remain Explosive
			
			AnsN = SumTime + SumRemain;
			//	Calc. AnsN
			
		//	Opt.

//			for(int i = 0; i < N; i++) {
//				for(int j = 0; j < N; j++) {
//					System.out.print(Map[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println("=================="); 

//			for(int i = 0; i < N; i++) {
//				for(int j = 0; j < N; j++) {
//					System.out.print(Stat[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println("==================");

//			System.out.println(SumTime + " / " + SumRemain);
			System.out.println("#" + tc + " " + AnsN);
		//	Opt.
		}	//	End Test Case
	}	//	End Main
}	//	End Class