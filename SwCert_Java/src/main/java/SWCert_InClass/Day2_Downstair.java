/*
10
5 1
9 3 2 3 2
6 3 1 7 5
3 4 8 9 9
2 3 7 7 7
7 6 5 5 8
3 2
1 2 1
2 1 2
1 2 1
5 2
9 3 2 3 2
6 3 1 7 5
3 4 8 9 9
2 3 7 7 7
7 6 5 5 8
4 4
8 3 9 5
4 6 8 5
8 1 5 1
4 9 5 5
4 1
6 6 1 7
3 6 6 1
2 4 2 4
7 1 3 4
5 5
18 18 1 8 18
17 7 2 7 2
17 8 7 4 3
17 9 6 5 16
18 10 17 13 18
6 4
12 3 12 10 2 2
13 7 13 3 11 6
2 2 6 5 13 9
1 12 5 4 10 5
11 10 12 8 2 6
13 13 7 4 11 7
7 3
16 10 14 14 15 14 14
15 7 12 2 6 4 9
10 4 11 4 6 1 1
16 4 1 1 13 9 14
3 12 16 14 8 13 9
3 4 17 15 12 15 1
6 6 13 6 6 17 12
8 5
2 3 4 5 4 3 2 1
3 4 5 6 5 4 3 2
4 5 6 7 6 5 4 3
5 6 7 8 7 6 5 4
6 7 8 9 8 7 6 5
5 6 7 8 7 6 5 4
4 5 6 7 6 5 4 3
3 4 5 6 5 4 3 2
8 2
5 20 15 11 1 17 10 14
1 1 11 16 1 14 7 5
17 2 3 4 5 13 19 20
6 18 5 16 6 7 8 5
10 4 5 4 9 2 10 16
2 7 16 5 8 9 10 11
12 19 18 8 7 11 15 12
1 20 18 17 16 15 14 13

 */
package SWCert_InClass;

import java.io.*;
import java.util.*;

public class Day2_Downstair {
	static int N, K;
	static int Map[][];
	static int AnsN;
	
	static int cnt;
	static int Stat[][];
	static boolean Downsize;	//	1Ãþ ³»·ÁºÃ³ª?

	static Queue<High> qHigh;
	static class High {
		int X, Y, Down;
		public High(int X, int Y, int Down) {
			this.X = X;
			this.Y = Y;
			this.Down = Down;
		}
	}
	
	static Queue<Down> qDown;
	static class Down {
		int X, Y, Down;
		public Down(int X, int Y, int Down) {
			this.X = X;
			this.Y = Y;
			this.Down = Down;
		}
	}
	
	static int dx[] = {-1, 0, 0, 1};
	static int dy[] = {0, -1, 1, 0};
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("Ipt (Downstair).txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
		//	Ipt.
			cnt = 0;
			
			N = sc.nextInt();
			K = sc.nextInt();
			
			qHigh = new LinkedList<>();
			
			Map = new int[N][N];
			Stat = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					Map[i][j] = sc.nextInt();
					if(Map[i][j] == 9)	{
						qHigh.add(new High(i, j, 1));
						Stat[i][j] = 1;
					}
				}
			}
			
		//	Ipt.
			
			while(!qHigh.isEmpty()) {
				int curx = qHigh.peek().X;
				int cury = qHigh.peek().Y;
				int curdown = qHigh.peek().Down;
				qHigh.poll();
				
				for(int i = 0; i < dx.length; i++) {
					int nx = curx + dx[i];
					int ny = cury + dy[i];
					int ndown = curdown;
					
					if(nx < 0 || (N - 1) < nx || ny < 0 || (N - 1) < ny)	continue;
					
					if((Map[nx][ny] < Map[curx][cury]) 
						&& (Stat[nx][ny] == 0)) {
						qDown.add(new Down(nx, ny, ndown));
						Stat[nx][ny] = Stat[curx][cury] + 1;
					}
					
					else if((Map[nx][ny] - 1 < Map[curx][cury]) 
							 && (Stat[nx][ny] == 0) 
							 && (ndown == 1)) {
						qDown.add(new Down(nx, ny, ndown - 1));
						Stat[nx][ny] = Stat[curx][cury] + 1;
					}
				}
			}

		//	Opt.
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.print(Map[i][j] + " ");
				}
				System.out.println();
			}
				
			System.out.println();

			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.print(Stat[i][j] + " ");
				}
				System.out.println();
			}
					
			System.out.println("#" + tc + " " + AnsN);
		//	Opt.
		}	//	End Test Case
	}	//	End Main
	
	public static void DFS() {
		
	}	//	End DFS
}	//	End Class

/*
public class Day2_Downstair {
static int N, K;
static int Map[][];
static int AnsN;

static int cnt;
static int Stat[][];
static boolean Downsize;	//	1Ãþ ³»·ÁºÃ³ª?

static Queue<High> qHigh;
static class High {
	int X, Y, Down;
	public High(int X, int Y, int Down) {
		this.X = X;
		this.Y = Y;
		this.Down = Down;
	}
}

static Queue<Down> qDown;
static class Down {
	int X, Y, Down;
	public Down(int X, int Y, int Down) {
		this.X = X;
		this.Y = Y;
		this.Down = Down;
	}
}

static int dx[] = {-1, 0, 0, 1};
static int dy[] = {0, -1, 1, 0};
public static void main(String args[]) throws Exception{
	System.setIn(new FileInputStream("Ipt (Downstair).txt"));
	Scanner sc = new Scanner(System.in);
	
	int T = sc.nextInt();
	for(int tc = 1; tc <= T; tc++) {
	//	Ipt.
		cnt = 0;
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		qHigh = new LinkedList<>();
		
		Map = new int[N][N];
		Stat = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				Map[i][j] = sc.nextInt();
				if(Map[i][j] == 9)	{
					qHigh.add(new High(i, j, 1));
					Stat[i][j] = 1;
				}
			}
		}
		
	//	Ipt.
		
		while(!(qHigh.isEmpty())){
			int hx = qHigh.peek().X;
			int hy = qHigh.peek().Y;
			int hdown = qHigh.peek().Down;
			qHigh.poll();
			
			for(int i = 0; i < dx.length; i++) {
				int nx = hx + dx[i];
				int ny = hy + dy[i];
				int ndown = hdown;
				
				if(nx < 0 || (N - 1) < nx || ny < 0 || (N - 1) < ny)	continue;
				
				if((Map[nx][ny] < Map[hx][hy]) && (Stat[nx][ny] == 0)) {
					qDown.add(new Down(nx, ny, ndown));
					Stat[nx][ny] = Stat[hx][hy] + 1;
				}
				
				else if((Map[nx][ny] - 1 < Map[hx][hy]) && (Stat[nx][ny] == 0) && (ndown == 1)) {
					qDown.add(new Down(nx, ny, ndown - 1));
					Stat[nx][ny] = Stat[hx][hy] + 1;
				}
			}
			
			while(!(qDown.isEmpty())) {
				int cx = qHigh.peek().X;
				int cy = qHigh.peek().Y;
				int cdown = qHigh.peek().Down;
				qHigh.poll();
				
				
				for(int i = 0; i < dx.length; i++) {
					int nx = cx + dx[i];
					int ny = cy + dy[i];
					int ndown = cdown;
					
					if(nx < 0 || (N - 1) < nx || ny < 0 || (N - 1) < ny)	continue;
					
					if((Map[nx][ny] < Map[cx][cy]) && (Stat[nx][ny] == 0)) {
						qDown.add(new Down(nx, ny, ndown));
						Stat[nx][ny] = Stat[cx][cy] + 1;
					}
					
					else if((Map[nx][ny] - 1 < Map[cx][cy]) && (Stat[nx][ny] == 0) && (ndown == 1)) {
						qDown.add(new Down(nx, ny, ndown - 1));
						Stat[nx][ny] = Stat[cx][cy] + 1;
					}
					
					AnsN = Math.max(AnsN, Stat[nx][ny]);
				}
			}
		}
		
	//	Opt.
		System.out.println("#" + tc + " " + AnsN);
	//	Opt.
	}	//	End Test Case
}	//	End Main
}	//	End Class
*/