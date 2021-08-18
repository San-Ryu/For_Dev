package SwCert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
[JUNG2765] 미술관람 대회

[문제]
해마다 열리는 꿀꿀이 올림피아드에는 여러 종목들이 있는데, 요즘에는 꿀꿀이들의 교양을 겨루는 ‘미술관람 대회’가 인기를 끌고 있다. 이 대회는 사회자가 빨강, 초록, 파랑으로 이루어진 N × N 픽셀의 그림을 보여주면 그 그림에 포함된 영역의 수를 빠르고 정확하게 맞추는 것이 목표이다. 동일한 색깔이 네 방향(상, 하, 좌, 우) 중 한 곳이라도 연결되어 있으면 하나의 영역으로 간주한다.
예를 들어, 아래 그림은 각각 2, 1, 1개의 빨간색, 초록색, 파란색 영역이 있어 총 4개의 영역이 있다.
한편, 꿀꿀이들의 절반 정도는 선천적인 유전자 때문에 적록색맹이라서 빨간색과 초록색을 구별하지 못한다. 따라서 사회자는 일반 대회와 적록색맹용 대회를 따로 만들어서 대회를 진행하려고 한다. 사회자를 도와 영역의 수를 구하는 프로그램을 작성하여라.

[입력]
첫 번째 줄에는 그림의 크기 N이 주어진다. (1 ≤ N ≤ 100)
두 번째 줄부터 N개의 줄에는 각 픽셀의 색깔이 'R'(빨강), 'G'(초록), 'B'(파랑) 중 하나로 주어진다.

[출력]
일반 꿀꿀이와 적록색맹 꿀꿀이가 보는 영역의 수를 출력한다.

[입력 예시]
15
BBBBBGGRRRGRGGG
BBBBBGGRRRGGGGG
GBBBBBBBRRGGGGG
GBBBBBBBBRGGGGG
GGBBBBBBBRRRRGG
RGBBBBBBBRRRRRG
RRRBBBBBBRRRRRG
GRRBBBBBBRRRRRR
GGGGGGBBBRRRRRG
RGGGGGBBBBBRRGG
RRGGGGBBBBBRRRR
GRRGGGBBBBBBBRR
BBBBGGGBBBBBBBB
BBBBGGGBBBBBBBB
GGGGGGGGBBBBBBB
*/
public class SWCert_AD_BFS_Jung2765_Exhibition {
//사이트 제출 시에는 반드시 Class명을 Main으로 지정해야함
//public class Main{
	static int N;
	static char[][] art;
	static char[][] visit;
	static int Answer;
	
	static class st{
		int y;
		int x;
		public st(int a, int b) {
			y = a;
			x = b;
		}
	}
	
	static st Queue[];
	static int Wp, Rp;
	
	static void In_Queue(int y, int x){
		Queue[Wp++] = new st(y, x);
	}
	
	static st Out_Queue(){
		return Queue[Rp++];
	}
	
	static int BFS(int sY, int sX, int color){
		Wp = 0;
		Rp = 0;
		In_Queue(sY,sX);
		visit[sY][sX] = '1';
		
		while(Wp > Rp){
			st out = Out_Queue();
			
			int dY[] = { 1, 0, 0, -1 };
			int dX[] = { 0, 1, -1, 0 };
			
			for (int k = 0; k < 4; k++) {
				int nY = out.y + dY[k];
				int nX = out.x + dX[k];
				
				if ( nY > N || nY < 1 || nX > N || nX < 1 ) continue;

				if(visit[nY][nX] == '1') continue;
				
				if(art[nY][nX] != color) continue;
								
				In_Queue(nY,nX);
				visit[nY][nX] = '1';
			}
			
		}
		return 0;
	}

	public static void main(String args[]) throws FileNotFoundException{
		
	    System.setIn(new FileInputStream("test14.txt")); 
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		art = new char[N*10][N*10];
		visit = new char[N*10][N*10];
		Queue = new st[(N*N)+(N*N)];
		
		for (int i = 1; i <= N; i++) {
			art[i] = ("\0"+sc.next()).toCharArray();
		}
		
		int count1 = 0;
		int count2 = 0;


		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(visit[i][j] == '1') continue;
					BFS(i,j,art[i][j]);
					count1++;
			}
		}


		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(art[i][j] == 'R'){
					art[i][j] = 'G';
				}
				visit[i][j] = '0';
			}
		}
				
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(visit[i][j] == '1') continue;
					BFS(i,j,art[i][j]);
					count2++;
			}
		}
		
		System.out.println(count1 +" "+ count2);
		
	}

}