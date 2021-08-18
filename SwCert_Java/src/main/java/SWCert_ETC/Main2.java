package SWCert_ETC;

import java.io.*;
import java.util.*;

public class Main2 {
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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
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
					Stat[nx][ny] = true;
				}
			}
		}
        
        Ans = Map[N - 1][M - 1];
	//	Oper
		
	//	Opt
		System.out.println(Ans);
	//	Opt
	
	br.close();
		
	}	//	End Method Main	
}	//	End Class Main