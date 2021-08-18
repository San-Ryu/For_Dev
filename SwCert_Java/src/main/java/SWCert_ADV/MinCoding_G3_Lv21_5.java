package SWCert_ADV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

/*링크 : mir.,mincoding.co.kr/problem/G3LV21_5_
*/

public class MinCoding_G3_Lv21_5{
//사이트 제출 시에는 반드시 Class명을 Main으로 지정해야함
//public class Main{
	static char map[][];
	static int visit[][];
	static int dy[] = {1, -1, 0, 0};
	static int dx[] = {0, 0, -1, 1};
	static ArrayDeque<Point> q;
	static int ans;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[4][3];
		visit = new int[4][3];

		q = new ArrayDeque<>();
		for(int i = 0; i < 4; i++){
			String str = br.readLine();
			for(int j = 0; j < 3; j++){
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'A') {
					q.add(new Point(i, j));
					visit[i][j] = 1;
				}
			}
		}
		ans = 0;
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int i = 0; i < 4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				
				if(ny < 0 || nx < 0 || ny >= 4 || nx >= 3)
					continue;
				if(visit[ny][nx] > 0)
					continue;
				if(map[ny][nx] == 'B') {
					visit[ny][nx] = visit[p.y][p.x] + 1;
					ans = visit[ny][nx];
					break;
				}
				q.add(new Point(ny, nx));
				visit[ny][nx] = visit[p.y][p.x] + 1 ;
			}
		}
		
		System.out.println(ans - 1);
	}				
	
	static class Point{
		int y, x;
		
		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}