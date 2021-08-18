package SwCert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
[JUNG2765] �̼����� ��ȸ

[����]
�ظ��� ������ �ܲ��� �ø��ǾƵ忡�� ���� ������� �ִµ�, ���򿡴� �ܲ��̵��� ������ �ܷ�� ���̼����� ��ȸ���� �α⸦ ���� �ִ�. �� ��ȸ�� ��ȸ�ڰ� ����, �ʷ�, �Ķ����� �̷���� N �� N �ȼ��� �׸��� �����ָ� �� �׸��� ���Ե� ������ ���� ������ ��Ȯ�ϰ� ���ߴ� ���� ��ǥ�̴�. ������ ������ �� ����(��, ��, ��, ��) �� �� ���̶� ����Ǿ� ������ �ϳ��� �������� �����Ѵ�.
���� ���, �Ʒ� �׸��� ���� 2, 1, 1���� ������, �ʷϻ�, �Ķ��� ������ �־� �� 4���� ������ �ִ�.
����, �ܲ��̵��� ���� ������ ��õ���� ������ ������ ���ϻ����̶� �������� �ʷϻ��� �������� ���Ѵ�. ���� ��ȸ�ڴ� �Ϲ� ��ȸ�� ���ϻ��Ϳ� ��ȸ�� ���� ���� ��ȸ�� �����Ϸ��� �Ѵ�. ��ȸ�ڸ� ���� ������ ���� ���ϴ� ���α׷��� �ۼ��Ͽ���.

[�Է�]
ù ��° �ٿ��� �׸��� ũ�� N�� �־�����. (1 �� N �� 100)
�� ��° �ٺ��� N���� �ٿ��� �� �ȼ��� ������ 'R'(����), 'G'(�ʷ�), 'B'(�Ķ�) �� �ϳ��� �־�����.

[���]
�Ϲ� �ܲ��̿� ���ϻ��� �ܲ��̰� ���� ������ ���� ����Ѵ�.

[�Է� ����]
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
//����Ʈ ���� �ÿ��� �ݵ�� Class���� Main���� �����ؾ���
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