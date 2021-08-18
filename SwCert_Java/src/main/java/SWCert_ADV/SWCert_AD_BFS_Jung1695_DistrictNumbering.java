package SWCert_ADV;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/*
[JUNG1695] 단지 번호붙이기

[문제]
<그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다.
철수는 이 지도를 가지고 연결된 집들의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다. 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 대각선상에 집이 있는 경우는 연결된 것이 아니다. <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다.
지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.

[입력]
첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.

[출력]
첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지 내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.

[입력 예시]
6
101100
101111
001001
100000
101110
101010
*/
public class SWCert_AD_BFS_Jung1695_DistrictNumbering {
//사이트 제출 시에는 반드시 Class명을 Main으로 지정해야함
//public class Main{
	static int N;
	static char[][] danji;
	static int[] Answer;
	static int region = 0;
	
	static class st{
		int y;
		int x;
		st(int a, int b) {
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
	
	static int BFS(int sY, int sX){
		
		In_Queue(sY,sX);
		int count = 1;
		danji[sY][sX] = '0';
		
		while(Wp > Rp){
			st out = Out_Queue();
			
			int dY[] = { 1, 0, 0, -1 };
			int dX[] = { 0, 1, -1, 0 };
			
			for (int k = 0; k < 4; k++) {
				int nY = out.y + dY[k];
				int nX = out.x + dX[k];
				
				if ( nY > N || nY < 1 || nX > N || nX < 1 ) continue;

				if(danji[nY][nX] == '0') continue;
								
				In_Queue(nY,nX);
				count++;
				danji[nY][nX] = '0';
			}
			
		}
		return count;		
	}
	
	public static void main(String args[]) throws FileNotFoundException{
		
	    System.setIn(new FileInputStream("test13.txt")); 
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		danji = new char[N+10][N+10];
		Queue = new st[(N*10)+(N*10)];
		Answer = new int[N*N];
		
		for (int i = 1 ; i <= N; i++) {
				danji[i] = ("\0"+sc.next()).toCharArray();
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(danji[i][j] == '0') continue;
				Answer[region] = BFS(i,j);
				region++;
			}
		}
	 	// 단순정렬(오름차순)
	 		for (int i = 0; i < region; i++) {
	 			for (int j = i+1; j < region; j++) {
	 				if(Answer[i] > Answer[j]){
	 					int temp = Answer[i];
	 					Answer[i] = Answer[j];
	 					Answer[j] = temp;
				}
			}	
		}	 		
		System.out.println(region);
		for (int i = 0; i < region; i++) {
			System.out.println(Answer[i]);		
		}
		
	}
}