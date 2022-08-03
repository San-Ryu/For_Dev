/*	BOJ2178 �̷� Ž��
[����]
N �� M ũ���� �迭�� ǥ���Ǵ� �̷ΰ� �ִ�.

1	0	1	1	1	1
1	0	1	0	1	0
1	0	1	0	1	1
1	1	1	0	1	1

�̷ο��� 1�� �̵��� �� �ִ� ĭ�� ��Ÿ����, 0�� �̵��� �� ���� ĭ�� ��Ÿ����. 
�̷��� �̷ΰ� �־����� ��, (1, 1)���� ����Ͽ� (N, M)�� ��ġ�� �̵��� �� ������ �ϴ� �ּ��� ĭ ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
���� �������� 15ĭ�� ������ (N, M)�� ��ġ�� �̵��� �� �ִ�. 

[���� ����]
ĭ�� �� ������ ���� ��ġ�� ���� ��ġ�� �����Ѵ�.

[�Է�]
ù° �ٿ� �� ���� N, M(2 �� N, M �� 100)�� �־�����. 
���� N���� �ٿ��� M���� ������ �̷ΰ� �־�����. 
������ ������ �پ �Է����� �־�����.

[���]
ù° �ٿ� ������ �ϴ� �ּ��� ĭ ���� ����Ѵ�. 
�׻� ������ġ�� �̵��� �� �ִ� ��츸 �Է����� �־�����.

[�Է� ����]
6
4 6
101111
101010
101011
111011
4 6
110110
110110
111111
111101
2 25
1011101110111011101110111
1110111011101110111011101
7 7
1011111
1110001
1000001
1000001
1000001
1000001
1111111
5 5
11100
10100
11111
00101
00111
5 5
11111
10001
10100
11100
01100

[��� ����]

 */
/*	�ؼ�
�Է°�
- T : TestCase
- N, M : N X M ��
- Maze[][] : �̷� ����
- Ans : �����

�ʿ䰪
- ����迭 (�����¿�) 
  dx = {-1, 1, 0, 0}
  dy = {0, 0, -1, 1}
    �밢�� ���Խ�
  dx = {-1, -1, -1, 0, 0, 1, 1, 1}
  dy = {-1, 0, 1, -1, 1, -1, 0, 1}
- Stat[][] : ������ ��� üũ�� ���� Stat �迭

����
- �� �Է� �� �ʱ�ȭ
- BFS�� ���� Queue ����
 */
package SWCert_ADV;

import java.io.*;
import java.util.*;

public class AD_BOJ2178_Maze {
	static int N, M;
	static int Ans;
	
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	static int Map[][];
	static boolean Stat[][];
	
	static class Point{
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}	
	}	//	End Class Point
	
	public static void main(String args[])	throws Exception{
		System.setIn(new FileInputStream("Input (AD_BOJ2178_Maze).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= T; tc++) {
		//	Init. & Ipt
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			Ans = 0;
			
			Map = new int[N][M];
			Stat = new boolean[N][M];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				String tmp = st.nextToken();
				for(int j = 0; j < M; j++) {
					Map[i][j] = (int) tmp.charAt(j) - '0';
					if(Map[i][j] == 0)	Stat[i][j] = true;
				}
			}
		//	Init. & Ipt
			
		//	Oper
			Queue<Point> q = new LinkedList<>();
			q.add(new Point(0, 0));
			while(!q.isEmpty()) {
				int curx = q.peek().x;
				int cury = q.peek().y;
				q.poll();
				for(int i = 0; i < 4; i++) {
					int nx = curx + dx[i];
					int ny = cury + dy[i];
					
					if(nx < 0 || N <= nx || ny < 0 || M <= ny)	continue;
					
					if(Map[nx][ny] != 0 && !Stat[nx][ny]) {
						q.add(new Point(nx, ny));
						Map[nx][ny] = Map[curx][cury] + 1;
						Ans = Math.max(Ans, Map[nx][ny]);
						Stat[nx][ny] = true;
					}
				}
			}
		//	Oper
			
		//	Opt
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					System.out.print(Map[i][j] + "\t");
				}
				System.out.println();
			}
			System.out.println();
			System.out.println("#" + tc + " " + Ans);
		//	Opt
		}	//	End Test Case
		
		br.close();
		
	}	//	End Method Main	
}	//	End Class Main