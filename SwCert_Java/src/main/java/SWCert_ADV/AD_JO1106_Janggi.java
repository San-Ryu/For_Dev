/*	���_JO1106_CX3546(CodeEx)
[����]
N x M ����ǿ� �� �Ѱ��� �� �Ѱ��� �����ִ�.
���� �̵� ������ ������ ���ٰ� �� ��,
���� �ּ��� �̵� Ƚ���� ���� ������ �Ѵ�.

000000000
000000000
000101000
001000100
0000H0000
001000100
000101000
000000000
000000000
���� ���� ��� ���� �ּ� �̵� Ƚ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

[�������]
1) �ð� ���� : 1.0 [Sec]
2) �޸� ���� : 128 [MB]

[�Է�]
ù ���� ������� ���� ��(N)�� ���� ��(M)�� �޴´�.
��° ���� ���� �ִ� ��ġ�� ��(R), ��(C)�� ���� ���� �ִ� ��ġ�� ��(S), ��(K)�� ���� �Է� �޴´�.
��, ������� ���� ���� ���� ��ġ�� (1, 1)�̴�.
(��, 1<= N, M <= 100
 1 <= R <= N
 1 <= C <= M
 1 <= K <= M)

[���]
���� ���� ��� ���� �ּ� �̵� Ƚ���� ����Ѵ�.

[�Է� ����]
2
9 9
3 5 2 8 
9 9 
3 5 3 5 

[��� ����]
#1 2
#2 0
 */
/*
2D Array ������ ���� �ʰ� Ǯ� �� ������?
 */
package SWCert_ADV;

import java.io.*;
import java.util.*;

public class AD_JO1106_Janggi {
	static int N, M;	//	���� ũ��
	static int hx, hy;	//	Horse(��)�� ��ǥ
	static int tx, ty;	//	Target(��)�� ��ǥ
	static int Degree;	//	����� (������ Ƚ��)
	
	static int dx[] = {1, 2, 2, 1, -1, -2, -2, -1};	//	���� ������ (1-2-4-5-7-8-10-11)
	static int dy[] = {-2, -1, 1, 2, 2, 1, -1, -2};	//	(��� �������κ��� �ð����)
	
	static class Point{
		int x, y, Degree;	//	Axis X, Axis Y, Degree
		
		public Point(int x, int y, int Degree) {
			this.x = x;
			this.y = y;
			this.Degree = Degree;
		}
	}	//	End Class Point
	
	public static void main(String args[]) throws Exception{		
		System.setIn(new FileInputStream(""));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= T; tc++) {
		//	Init. & Ipt.
			Degree = 0;
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			hx = Integer.parseInt(st.nextToken());
			hy = Integer.parseInt(st.nextToken());
			tx = Integer.parseInt(st.nextToken());
			ty = Integer.parseInt(st.nextToken());
			
			Queue<Point> q = new LinkedList<>();
		//	Init. & Ipt.			
			
		//	Oper.
		//	Degree�� ��� ++�ؾ��ұ�?
			q.add(new Point(hx, hy, Degree));
			while(true) {
				int Curx = q.peek().x;
				int Cury = q.peek().y;
				int Degree = q.peek().Degree;
				q.poll();
				
				if(Curx == tx && Cury == ty)	break;
				
				for(int i = 0; i < 8; i++) {
					int nx = Curx + dx[i];
					int ny = Cury + dy[i];
					int nd = Degree + 1;
					
					if(nx < 1 || ny < 1 || N < nx || M < ny)	continue;
					
					q.add(new Point(nx, ny, nd));
					
					if(nx == tx && ny == ty)	break;	// While �������ǿ� �޾Ƶ� �ȴ�.
				}
			}
		//	Oper.
		//	Opt.
			System.out.println("#" + tc + " " + Degree);
		//	Opt.
		}	//	End Test Case
	}	//	End Main
}	//	End Class