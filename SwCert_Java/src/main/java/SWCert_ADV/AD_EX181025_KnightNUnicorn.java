/*	�����ܰ� ����Ʈ
[����]
����Ʈ�� �̵��ϸ� ���� ���� ��ǥ�� �̵��Ͽ� ���� ���� �� �ִ�.
(K - ����Ʈ, 0 - ��ĭ, 1 - ����Ʈ�� �̵�)
0000000
0010100
0100010
000K000
0100010
0010100
0000000
<����Ʈ�� �̵�>
����Ʈ�� ���������� ���׷��̵��ϸ�, ���� �������� �������� �̵��� �����ϴ�.

0000000
0000000
0000000
0000010
0001000
0K00000
0000000
����Ʈ�� �̵��ϸ� 2�� �̵��Ͽ� ���� ���� �� ������,
���׷��̵�� �������� �̵��ϸ� �׸��� ���� 1�� �̵��Ͽ� ���� ���� �� �ִ�.

����Ʈ�� �̵��Ͽ� ���� ��� �ͺ��� �������� �̵��Ͽ� ���� ��°� �� �� �� �����̴� ������ ���϶�.
(������ �̵��� ����Ʈ �̵��� ���̸� ���Ͻÿ�.)

[�Է�]
�׽�Ʈ ���̽�
ü���� ũ�� / ������ �� / ������ �� / �� �� / �� ��

[���]
������ �̵� ���� ����Ʈ �̵� ���� ����

[�Է� ����]
4
3 3 3 1 3
5 2 5 4 1
3 3 3 3 1
7 3 1 6 7

[��� ����]
#1 0
#2 1
#3 0
#4 2
 */

/*
������ �̵� Method / ����Ʈ �̵� Method�� ���� �����ϴ� ��
�� Method�� �������� ���� ����ϴ� ��
 */
package SWCert_ADV;

import java.io.*;
import java.util.*;

public class AD_EX181025_KnightNUnicorn {
	static int N;	//	ü���� �� ���� ����
	static int X, Y;	//	Knight & Unicorn Axis X, Y
	static int tX, tY;	//	Pawn Axis X, Y
	static int Board[][];	//	������ ����
	static int AnsN;	//	Result (�̵� ����)
	
	static int KCnt, UCnt;
	static int dx[] = {1, 2, 2, 1, -1, -2, -2, -1};	//	1, 2, 4, 5, 7, 8, 10, 11
	static int dy[] = {-2, -1, 1, 2, 2, 1, -1, -2};
	
	static int BrdStat[][];
	static Queue<Integer> qX;	//	��ǥ�� X ������ ���� Queue
	static Queue<Integer> qY;	//	��ǥ�� Y ������ ���� Queue
	
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("Input (AD_EX181025_KnightNUnicorn).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= T; tc++) {
		//	Init.
			AnsN = KCnt = UCnt = 0;
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			X = Integer.parseInt(st.nextToken()) - 1;
			Y = Integer.parseInt(st.nextToken()) - 1;
			tX = Integer.parseInt(st.nextToken()) - 1;
			tY = Integer.parseInt(st.nextToken()) - 1;
		//	Init.
			
		//	Oper.
			qX = new LinkedList<>();	//	Declaration
			qY = new LinkedList<>();
			
			qX.add(X);	//	Init. X
			qY.add(Y);	//	Init. Y
			
			BrdStat = new int[N][N];	//	Init.
			Knight();
			
			qX.add(X);	//	Init. X
			qY.add(Y);	//	Init. Y
			BrdStat = new int[N][N];	//	Init.
			Unicorn();
			
			AnsN = KCnt - UCnt;
		//	Oper.
			
		//	Opt.
			System.out.println("#" + tc + " " + AnsN);
		//	Opt.
		}	//	End Test Case
	}	//	End Main Method
	
	public static void Knight(){
		while(!(qX.isEmpty() && qY.isEmpty())) {
			int curx = qX.poll();
			int cury = qY.poll();
			
			for(int i = 0; i < dx.length; i++) {
				int nx = curx + dx[i];
				int ny = cury + dy[i];
				
				if((nx < 0) || ((N - 1) < nx) || (ny < 0) || ((N - 1) < ny 
					|| (BrdStat[nx][ny] != 0)))	
					continue;
				
				BrdStat[nx][ny] = BrdStat[curx][cury] + 1;
				qX.add(nx);
				qY.add(ny);
				
				if(nx == tX && ny == tY) {
					KCnt = BrdStat[nx][ny];
					qX.clear();
					qY.clear();
					break;
				}
			}
		}
	}	//	End Knight Method
	
	public static void Unicorn() {
		while(!(qX.isEmpty() && qY.isEmpty())) {
			int curx = qX.poll();
			int cury = qY.poll();
			
			for(int i = 0; i < dx.length; i++) {
				int nx1 = curx + dx[i];
				int ny1 = cury + dy[i];
				
				if((nx1 < 0) || ((N - 1) < nx1) || (ny1 < 0) || ((N - 1) < ny1 
					|| (BrdStat[nx1][ny1] != 0)))	
					continue;
				//	Improve : BrdStat[nx1][ny1] != 0 �κ��� �����Ǹ�, (�湮�ߴ� ������ �������� ������)
				//			  1) ����ε� ���� ������ �ʰų�, (AnsN�� ������ ���)
				//			  2) �ð� ���⵵�� �ް��� �ö󰣴�. (Time Out)
				//				 <����ġ���� �߿伺>
				
				BrdStat[nx1][ny1] = BrdStat[curx][cury] + 1;
				qX.add(nx1);
				qY.add(ny1);
				
				if((nx1 == tX) && (ny1 == tY)) {
					UCnt = BrdStat[nx1][ny1];
					qX.clear();
					qY.clear();
					break;
				}
				
				if((nx1 + dx[i] < 0) || ((N - 1) < nx1 + dx[i]) ||
				   (nx1 + dy[i] < 0) || ((N - 1) < ny1 + dy[i]) ||
				   (BrdStat[nx1 + dx[i]][ny1 + dy[i]] != 0))	continue;
				
				BrdStat[nx1 + dx[i]][ny1 + dy[i]] = BrdStat[curx][cury] + 1;
				qX.add(nx1 + dx[i]);
				qY.add(ny1 + dy[i]);
				
				if((((nx1 + dx[i]) == tX) && ((nx1 + dx[i]) == tY)))	{
					UCnt = BrdStat[nx1 + dx[i]][ny1 + dy[i]];
					qX.clear();
					qY.clear();
					break;
				}
				
				if((nx1 + (2 * dx[i]) < 0) || ((N - 1) < nx1 + (2 * dx[i])) ||
				   (nx1 + (2 * dy[i]) < 0) || ((N - 1) < ny1 + (2 * dy[i])) ||
				   (BrdStat[nx1 + (2 * dx[i])][ny1 + (2 * dy[i])] != 0))	continue;
				
				BrdStat[nx1 + (2 * dx[i])][ny1 + (2 * dy[i])] = BrdStat[curx][cury] + 1;
				qX.add(nx1 + (2 * dx[i]));
				qY.add(ny1 + (2 * dy[i]));
				
				if((((nx1 + (2 * dx[i])) == tX) && ((nx1 + (2 * dx[i])) == tY)))	{
					UCnt = BrdStat[nx1 + (2 * dx[i])][ny1 + (2 * dy[i])];
					qX.clear();
					qY.clear();
					break;
				}	
			}
		}
	}	//	End Unicorn Method
}	//	End Class