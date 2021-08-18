package SWCert_ADV;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/*
[JUNG1695] ���� ��ȣ���̱�

[����]
<�׸� 1>�� ���� ���簢�� ����� ������ �ִ�. 1�� ���� �ִ� ����, 0�� ���� ���� ���� ��Ÿ����.
ö���� �� ������ ������ ����� ������ ������ ������ �����ϰ�, ������ ��ȣ�� ���̷� �Ѵ�. ���⼭ ����Ǿ��ٴ� ���� � ���� �¿�, Ȥ�� �Ʒ����� �ٸ� ���� �ִ� ��츦 ���Ѵ�. �밢���� ���� �ִ� ���� ����� ���� �ƴϴ�. <�׸� 2>�� <�׸� 1>�� �������� ��ȣ�� ���� ���̴�.
������ �Է��Ͽ� �������� ����ϰ�, �� ������ ���ϴ� ���� ���� ������������ �����Ͽ� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

[�Է�]
ù ��° �ٿ��� ������ ũ�� N(���簢���̹Ƿ� ���ο� ������ ũ��� ������ 5��N��25)�� �Էµǰ�, �� ���� N�ٿ��� ���� N���� �ڷ�(0Ȥ�� 1)�� �Էµȴ�.

[���]
ù ��° �ٿ��� �� �������� ����Ͻÿ�. �׸��� �� ���� �� ���� ���� ������������ �����Ͽ� �� �ٿ� �ϳ��� ����Ͻÿ�.

[�Է� ����]
6
101100
101111
001001
100000
101110
101010
*/
public class SWCert_AD_BFS_Jung1695_DistrictNumbering {
//����Ʈ ���� �ÿ��� �ݵ�� Class���� Main���� �����ؾ���
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
	 	// �ܼ�����(��������)
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