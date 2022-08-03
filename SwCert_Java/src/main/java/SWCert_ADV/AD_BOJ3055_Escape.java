/*	Ż��
[����]
����� ������ ���� �̹����� ���� ���� ������ �տ� �־���, 
�� �ɷ��� �����غ��� ���� ��ó�� Ƽ������ ȫ���� ����Ű���� �Ѵ�. 

�� ������ ����ġ�� �� ���� ��� �ִ�. 
����ġ�� ���� ģ�� ģ���� ����� ���� ������ ���� ������ ȫ���� ���Ϸ��� �Ѵ�.

Ƽ������ ������ R�� C���� �̷���� �ִ�. 
����ִ� ���� '.'�� ǥ�õǾ� �ְ�, 
���� ���ִ� ������ '*', 
���� 'X'�� ǥ�õǾ� �ִ�. 
����� ���� 'D'��, 
����ġ�� ��ġ�� 'S'�� ��Ÿ������ �ִ�.

�� �и��� ����ġ�� ���� �ִ� ĭ�� ������ �� ĭ �� �ϳ��� �̵��� �� �ִ�. (��, �Ʒ�, ������, ����)
���� �� �и��� ����ִ� ĭ���� Ȯ���Ѵ�. 
���� �ִ� ĭ�� �������ִ� ����ִ� ĭ(��� �� ���� ����)�� ���� ���� �ȴ�. 
���� ����ġ�� ���� ����� �� ����. 
��, ����ġ�� ���� ���ִ� �������� �̵��� �� ����, 
���� ����� �ұ��� �̵��� �� ����.

Ƽ������ ������ �־����� ��, ����ġ�� �����ϰ� ����� ���� �̵��ϱ� ���� �ʿ��� �ּ� �ð��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

����ġ�� ���� �� ������ ĭ���� �̵��� �� ����. 
��, ���� �ð��� ���� �� ������ ĭ���� ����ġ�� �̵��� �� ����. 
�̵��� �� ������ ����ġ�� ���� ������ �����̴�. 

[�Է�]
ù° �ٿ� 50���� �۰ų� ���� �ڿ��� R�� C�� �־�����.

���� R�� �ٿ��� Ƽ������ ������ �־�����, �������� ������ ���ڸ� �־�����. 
'D'�� 'S'�� �ϳ����� �־�����.

[���]
ù° �ٿ� ����ġ�� ����� ���� �̵��� �� �ִ� ���� ���� �ð��� ����Ѵ�. ����, �����ϰ� ����� ���� �̵��� �� ���ٸ�, "KAKTUS"�� ����Ѵ�.

[�Է� ����]
5
3 3
D.*
...
.S.
3 3
D.*
...
..S
3 6
D...*.
.X.X..
....S.
5 4
.D.*
....
..X.
S.*.
....
[��� ����]
3
KAKTUS
6
4
KAKTUS

 */
package SWCert_ADV;

import java.io.*;
import java.util.*;

public class AD_BOJ3055_Escape {
	static int N, M;
	static char Map[][];
	static int AnsN;
	
	static boolean Flag;	//	���� ����
	static boolean Stat[][];
	static int dx[] = {-1, 0, 0, 1};
	static int dy[] = {0, -1, 1, 0};
	
	static Queue<Integer> qs;
	static Queue<Integer> qwx;
	static Queue<Integer> qwy;
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("Input (AD_BOJ3055_Escape).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= T; tc++) {
		//	Ipt.
			AnsN = 0;
			Flag = false;
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			Map = new char[N][M];
			qs = new LinkedList<>();
			qwx = new LinkedList<>();
			qwy = new LinkedList<>();
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				String tmp = st.nextToken();
				
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

			//	����
			while(!qs.isEmpty()) {
			//	�� ���� ������
				int tmp = qwx.size();
				for(int i = 0; i < tmp; i++) {
					int cx = qwx.poll();
					int cy = qwy.poll();
					
					for(int j = 0; j < dx.length; j++) {
						int nx = cx + dx[i];
						int ny = cy + dy[i];
						
						if(nx < 0 || (N - 1) < nx || ny < 0 || (M - 1) < ny)	continue;
						if(Map[nx][ny] == 'X') continue;
						if(Map[nx][ny] == '.') {
							qwx.add(nx);
							qwy.add(ny);
							Map[nx][ny] = '*';
						}
					}
				}
				
			//	����ġ�� �̵�
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