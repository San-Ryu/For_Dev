/*	�丶��_BOJ7576
[����]
ö���� �丶�� ���忡���� �丶�並 �����ϴ� ū â�� ������ �ִ�. 
�丶��� �Ʒ��� �׸��� ���� ���� ��� ������ ĭ�� �ϳ��� �־ â�� �����Ѵ�. 

â�� �����Ǵ� �丶��� �߿��� �� ���� �͵� ������, 
���� ���� ���� �丶��鵵 ���� �� �ִ�. 
���� �� �Ϸ簡 ������, ���� �丶����� ������ ���� �ִ� ���� ���� �丶����� ���� �丶���� ������ �޾� �Ͱ� �ȴ�. 
�ϳ��� �丶���� ������ ���� ����, ������, ��, �� �� ���⿡ �ִ� �丶�並 �ǹ��Ѵ�. 
�밢�� ���⿡ �ִ� �丶��鿡�Դ� ������ ���� ���ϸ�, �丶�䰡 ȥ�� ������ �ʹ� ���� ���ٰ� �����Ѵ�. 
ö���� â�� ������ �丶����� ��ĥ�� ������ �� �Ͱ� �Ǵ���, �� �ּ� �ϼ��� �˰� �;� �Ѵ�.

�丶�並 â�� �����ϴ� ���ڸ���� ���ڵ��� ũ��� ���� �丶���� ���� ���� �丶����� ������ �־����� ��, 
��ĥ�� ������ �丶����� ��� �ʹ���, �� �ּ� �ϼ��� ���ϴ� ���α׷��� �ۼ��϶�. 
��, ������ �Ϻ� ĭ���� �丶�䰡 ������� ���� ���� �ִ�.

[�Է�]
ù �ٿ��� ������ ũ�⸦ ��Ÿ���� �� ���� M,N�� �־�����. M�� ������ ���� ĭ�� ��, N �� ������ ���� ĭ�� ���� ��Ÿ����. ��, 2 �� M,N �� 1,000 �̴�. ��° �ٺ��ʹ� �ϳ��� ���ڿ� ����� �丶����� ������ �־�����. ��, ��° �ٺ��� N���� �ٿ��� ���ڿ� ��� �丶���� ������ �־�����. �ϳ��� �ٿ��� ���� �����ٿ� ����ִ� �丶���� ���°� M���� ������ �־�����. ���� 1�� ���� �丶��, ���� 0�� ���� ���� �丶��, ���� -1�� �丶�䰡 ������� ���� ĭ�� ��Ÿ����. 

[���]
�������� �丶�䰡 ��� ���� �������� �ּ� ��¥�� ����ؾ� �Ѵ�. ����, ����� ������ ��� �丶�䰡 �;��ִ� �����̸� 0�� ����ؾ� �ϰ�, �丶�䰡 ��� ������ ���ϴ� ��Ȳ�̸� -1�� ����ؾ� �Ѵ�.

[�Է� ����]
7
6 4
1 1 0 1 1 1
0 1 0 1 0 1
0 1 0 1 0 1
0 1 1 1 0 1
6 4
0 -1 0 0 0 0
-1 0 0 -1 0 0
0 0 -1 0 0 0
0 -1 0 -1 0 1
6 4
1 -1 0 0 0 0
0 -1 0 0 0 0
0 0 0 0 -1 0
0 0 0 0 -1 1
5 5
-1	 1	 0	 0	0
 0	-1	-1	-1	0
 0	-1	-1	-1	0
 0	-1	-1	-1	0
 0	0	 0	 0	0
2 2
1 -1
-1 1
6 6
0 0 0 0 0 0
0 0 0 0 0 0
0 0 -1 0 0 0
0 0 0 -1 0 0
0 0 0 0 0 0
0 0 0 0 0 0
3 3
1 -1 0
-1 -1 0
0 0 1

[��� ����]
#1 1
#2 -1
#3 6
#4 14
#5 0
#6 -1
#7 2
 */
/*
������ ������ ��찡 ���� �� ���� (���������θ� �Ǵ� �Ʒ������θ� ���)
�����¿� �������� ������ ���
�밢������ 8���� ������ ���

8�������� X, Y��ǥ�� ǥ���ϴ� ���
X - 1, Y - 1
X - 1, Y
X - 1, Y + 1 ��...
�� �ڵ尡 �ʹ� �����

x, y
(x, y + 1) -> ����ġ : (0 , 1)

static int x[] = {0, 1, 0, -1}
static int y[] = {1, 0, -1, 0}

�̸�	static int x[] = {0, 0, 1, -1}
	static int y[] = {1, -1, 0, 0}	���� �ܿ��� ����

static class Node{
	int x, y;
	public new(int x, int y){
		this.x = x;
		this.y = y;
	}
}

���� ����
if(curx < 1 || cury < 1 || N < curx || n < cury)	continue;

for(int k = 0; k < 4; k++){
int nx = curx + dx[i];
int ny = cury + dy[i];
}
 */

/*	�ؼ�
�Է°�
- T : Test Case
- M, N : M X N ��
- Box[][] : �丶�� ���� (���� ����)
- Ans : �����

�ʿ䰪
- ����迭 (�����¿�) 
  dx = {-1, 1, 0, 0}
  dy = {0, 0, -1, 1}
    �밢�� ���Խ�
  dx = {-1, -1, -1, 0, 0, 1, 1, 1}
  dy = {-1, 0, 1, -1, 1, -1, 0, 1}
  
����
- Ipt. & Init.
- BFS ����
    ������ �丶�� ��ġ�� Queue�� ����
- BFS �������� ���� : q.isEmpty() -> ���̻� Ž���� ���ڰ� ���� ���
  q�� ����� x, y�� ȣ�� �� Head�� ����
  -> ���Ž�� ���� ���� �ִ°�?
     Box���� ��ȿ�Ѱ�? (������ = 0)
     -> ���� ������ �����ϴ� ��ǥ�� ���� q�� �߰��� ��, �̵���ġ +1 (Ž�� ������ +1)
                  �Ҹ����� Pass & continue
 */
package SWCert_ADV;

import java.io.*;
import java.util.*;

public class AD_BFS_BOJ7576_Tomato {
	static int M, N;
	static int Box[][];
	static int Ans;
	
	static boolean Flag;
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	
	static class Point{
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("Input (AD_BFS_BOJ7576_Tomato).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= T; tc++) {
		//	Init. & Ipt.
			Ans = 0;
			Flag = false;
			
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			Box = new int[N][M];
			Queue<Point> q = new LinkedList<>();
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++) {
					Box[i][j] = Integer.parseInt(st.nextToken());
					if(Box[i][j] == 1)	q.add(new Point(i, j));
				}
			}
		//	Init. & Ipt.
			
		//	Oper.
			while(!q.isEmpty()) {
				int Curx = q.peek().x;
				int Cury = q.peek().y;
				q.poll();
				
				for(int i = 0; i < 4; i++) {
					int nx = Curx + dx[i];
					int ny = Cury + dy[i];
					
					if(nx < 0 || N <= nx || ny < 0 || M <= ny)	continue;
					
					if(Box[nx][ny] == 0) {
						q.add(new Point(nx, ny));
						Box[nx][ny] = Box[Curx][Cury] + 1;
					}
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					Ans = Math.max(Ans,  Box[i][j]);
					if(Box[i][j] == 0)	Flag = true;
				}
			}
			
			if(Flag)	Ans = -1;
			if(0 < Ans) Ans--;	//	�� ���� ���߱� ����.
		//	Oper.
			
		//	Opt.
			System.out.println("#" + tc + " " + Ans);
		//	Opt.
		}	//	End Test Case
	}	//	End Main
}	//	End Class