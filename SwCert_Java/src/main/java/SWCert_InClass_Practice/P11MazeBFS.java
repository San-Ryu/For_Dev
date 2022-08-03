package SWCert_InClass_Practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P11MazeBFS {
	static int SIZE = 16;
	static int[][] map = new int[SIZE][SIZE];
	static int[][] visited; 

	static class Pos{
		int x, y;
		Pos(int a, int b){ x = a; y = b;}
	}
	
	static int[] dx = new int[]{ 0, 0, 1, -1 };
	static int[] dy = new int[]{ 1, -1, 0, 0 };	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	
		for (int tc = 1; tc <= 10; tc++)
		{			
			int N = sc.nextInt();
			
			int x = 0, y = 0, ex = 0, ey = 0;
			for (int i = 0; i < SIZE; i++)
			{
				String str = sc.next();
				for (int j = 0; j < SIZE; j++)
				{
					map[i][j] = str.charAt(j) - '0';
					
					if (map[i][j] == 2){ x = i; y = j; }
					if (map[i][j] == 3){ ex = i; ey = j; }					
				}
			}
			visited = new int[SIZE][SIZE]; 	
			Queue<Pos> Q = new LinkedList<Pos>();
			
			Q.add(new Pos(x, y));

			visited[x][y] = 1;

			while (!Q.isEmpty())
			{
				Pos p = Q.poll();

				for (int i = 0; i < 4; i++)
				{
					int tx = p.x + dx[i];
					int ty = p.y + dy[i];
					
					if (map[tx][ty] != 1 && visited[tx][ty] == 0)
					{
						Q.add(new Pos(tx, ty));
						visited[tx][ty] = 1;
					}
				}
			}
			System.out.println("#" + tc + " " + visited[ex][ey]);
		}
		sc.close();
	}
}
