package SwCert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
[JUNG 1681]�ع��� ��ȯȸ��

[����]
������ �� Ǯ��� �ҹ��� �����̴� ��� �ø��ǾƵ� ��ȸ�� �����ϰ� �;� �ߴ�. ��ȸ�� �����Ͽ� ���̶� ���� �� Ÿ�� ���� �����̾�����, �� ���� �ɸ��� ���� �־���.
������ �ø��ǾƵ� ��ȸ�� ��� �ؿܿ��� ������ ����� ����� ���� ������ ���� ���ٴ� ���̴�.
�ᱹ���� ������ �ٽ� ���ƿ;� �ϴµ�, ��� ��ȸ�� 1������ �����ϰ� ������ ���ƿ��� ��� ���� �ּ�ȭ�ϰ� �ʹ�.
�����̴� �̰��� �ذ����� ���ϸ�, ��ȸ�� �����ϱⰡ ��ư� �ȴ�.
��ȸ�� �����ϱ⸸ �ϸ� �������� �˰��� ������ Ǯ �� �ֱ� ������ ��⸦ ����ϴ� �� �̿��� ������ ������� �ʾƵ� �ȴ�.

[�Է�]
ù ���� �����ϴ� ��ȸ�� �� N(1��N��12)�� �Է� �޴´�. �̶�, �����(��)�� 1������ �Ѵ�.
��° ���� N*N ũ���� ��ȸ �������� �������� �̵��ϴ� �װ���(0���װ���<100)�� ���´�.
�� �װ���� �� ĭ�� �������� ���еȴ�. ���࿡ ���������� �������� �̵��� �� �ִ� �װ��ΰ� ���ٸ� �װ����� ���� 0���� ǥ���Ѵ�.

[���]
������ ����Ͽ� ��ü ��ȸ�� ��� �����ϰ� ���ƿ� ��, �ּ��� �װ��Ḧ ����Ѵ�.
*/
/* DFS �Լ� ���� ���

0) Main ����
  DFS(1,1,0);
 
1) �Ķ����
   pos -> [�湮�� ������ ����] ����� ������ ��ġ(index)
   s -> [��� ����]
   cost -> [pos ���������� ���]

2) ���� ��
   [ void ��� ] ��� ����� �� Ȯ���� ���� ����� ���Ե�� ��� Ȯ��
     
3) ���� ����   
     if(pos == N) ���������� ������,
      1) �ٽ� 1�� ���ư��� �ִ°�, return;
      2) �ѱݾ��� ���, sol ������Ʈ, return;

4) ����ġ��
      1) �̹� �湮������, visit[2,3,4,5] �ʿ�
      2) ����Ⱑ ������, (0)
      3) �Ѿ�� cost�� sol���� ũ�ų� ������, cost >= sol
*/

public class SWCert_AD_DFS_JUNG1681_HamiltonCirquit {
//����Ʈ ���� �ÿ��� �ݵ�� Class���� Main���� �����ؾ���
//public class Main{
	// �����ϴ� ��ȸ�� ����
	static int N;
	// �װ��� �迭
	static int[][] node;
	// ��� �迭
	static int[] path;
	// �湮 üũ �迭
	static int[] visit;
	// �ּҺ�� ���
	static int sol;
	
	// [1] �Լ� ���� �� �Ķ���� ����
	static void DFS(int pos, int s, int cost){
		// [2] ��������
		if(pos == N){
			//  1) �ٽ� 1�� ���ư��� �ִ°�, return;
			if(node[s][1] == 0) return;

		    //  2) �ѱݾ��� ���, sol ������Ʈ, return;
			if(cost+node[s][1] < sol) {
				sol = cost+node[s][1];
				return;
			}
		}
		
		// [3] for������ ���ȣ�� [ �湮�� ���� 2������ N�� ���ñ��� for�� ]
		for(int i = 2; i <= N; i++){
			
			// [4] ����ġ��
			if(visit[i] == 1) continue; // �̹� �湮�ߴ��� üũ, visit[i] �湮 üũ �迭�� �湮 ���� Ȯ��
			if(node[s][i] == 0) continue; // ����Ⱑ ������, node[s][i] �ش� �迭�� 0 �� Ȯ��
			if(cost+node[s][i] >= sol) continue; // �Ѿ�� cost�� sol���� ũ�ų� ������, cost >= sol
			
			  visit[i] = 1; // �ش� ���� �湮 ���� �߰�, ���� i�� �湮�߱� ������ visit[i] �� �Է��ؾ���
		      DFS(pos+1,i/* �湮�ϴ� ���� = i */,cost+node[s][i]);
		      visit[i] = 0; // �湮 ���� ����
		      
			}
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		System.setIn(new FileInputStream("test21.txt")); 
		Scanner sc = new Scanner(System.in);
		
		  N = sc.nextInt();
		  node = new int[N+1][N+1];
		  path = new int[N+1];
		  visit = new int[N+1];
		  sol = 10000000;
		  
		  for (int i = 1; i <= N; i++) {
			  for (int j = 1; j <= N; j++) {
				node[i][j] = sc.nextInt();
			  }
		  }
		  
		  DFS(1,1,0);
		  
		  System.out.println(sol);
		  
	}
	
}
