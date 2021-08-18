package SWCert_ETC;

import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static char Map[][];
	static int AnsN;
	
	static boolean Flag;	//	�룄李� �뿬遺�
	static boolean Stat[][];
	static int dx[] = {-1, 0, 0, 1};
	static int dy[] = {0, -1, 1, 0};
	
	static Queue<Integer> qs;
	static Queue<Integer> qwx;
	static Queue<Integer> qwy;
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
		//	Ipt.
			AnsN = 0;
			Flag = false;

			N = sc.nextInt();
			M = sc.nextInt();
			
			Map = new char[N][M];
			qs = new LinkedList<>();
			qwx = new LinkedList<>();
			qwy = new LinkedList<>();
			for(int i = 0; i < N; i++) {
				String tmp = sc.next();
				
				for(int j = 0; j < M; j++) {
					if(tmp.charAt(j) == 'S') {
						qs.add(i);
						qs.add(j);
						qs.add(0);
						Map[i][j] = '.';
						continue;
					}
					
					else if(tmp.charAt(j) == '*') {
						qwx.add(i);
						qwy.add(j);
					}
					
					Map[i][j] = tmp.charAt(j);
					
				}
			}
			
			Stat = new boolean[N][M];
		//	Ipt.

			//	吏꾪뻾
			while(!qs.isEmpty()) {
			//	臾� 癒쇱� 李⑥삤由�
				int tmp = qwx.size();
				for(int i = 0; i < tmp; i++) {
					int cx = qwx.poll();
					int cy = qwy.poll();
					
					for(int j = 0; j < dx.length; j++) {
						int nx = cx + dx[j];
						int ny = cy + dy[j];
						
						if(nx < 0 || (N - 1) < nx || ny < 0 || (M - 1) < ny)	continue;
						if(Map[nx][ny] == 'X') continue;
						if(Map[nx][ny] == '.') {
							qwx.add(nx);
							qwy.add(ny);
							Map[nx][ny] = '*';
						}
					}
				}
				
			//	怨좎뒾�룄移섏쓽 �씠�룞
				int cx = qs.poll();
				int cy = qs.poll();
				int cm = qs.poll();
				
				for(int i = 0; i < dx.length; i++) {
					int nx = cx + dx[i];
					int ny = cy + dy[i];
					
					if(nx < 0 || (N - 1) < nx || ny < 0 || (M - 1) < ny)	continue;
					if(Map[nx][ny] == 'X') continue;
					
					if(Map[nx][ny] == '.' && !Stat[nx][ny]) {
						qs.add(nx);
						qs.add(ny);
						qs.add(cm + 1);
						Stat[nx][ny] = true;
					}
					else if(Map[nx][ny] == 'D') {
						if(AnsN == 0)	AnsN = cm + 1;
						else AnsN = Math.min(AnsN, cm + 1);
						Flag = true;
					}
				}
			}
			
		//	Opt.
			if(!Flag) {
				System.out.println("#" + tc + " " + "KAKTUS");
				continue;
			}
			
			System.out.println("#" + tc + " " + AnsN);

		//	Opt.
		}	//	End Test Case
	}	//	End Main
}	//	End Class