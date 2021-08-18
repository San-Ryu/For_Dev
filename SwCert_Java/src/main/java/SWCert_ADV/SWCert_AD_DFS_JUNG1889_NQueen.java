package SWCert_ADV;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
[JUNG1889]N QUEEN

[����]
ü������ queen�� ����, ����, �밢�� �������� ��� ���̳� �� ���� ������ �� �ִ�.
�� ������ ���� ü���ǿ��� queen�� X��� ǥ�õ� ��ġ���� ���� ��, �� ���� queen�� ������ �� �� �ִ� �κ��� ��Ӱ� ĥ���� �κ� ���� �ϳ��̴�.
N*N ũ���� ������ ü������ �־�����. �츮�� �ű⿡ N���� queen�� ��ġ�Ϸ��� �ϴµ�, ��� queen���� ���� ��Ƹ��� �� ����� �Ѵ�.
�׷��ٸ� queen���� ��� ��ġ�ؾ߸� �ұ�? ������ ��� ����� ������ ����Ѵ�.

[�Է�]
Queen�� �� N(1��N��13)�� �Է� �޴´�.

[���]
N*N�� ü���ǿ��� N���� queen���� ���� ��Ƹ��� �ʴ� ��ġ�� ���� �� �ִ� ����� ���� ����Ѵ�..
*/

public class SWCert_AD_DFS_JUNG1889_NQueen {
//����Ʈ ���� �ÿ��� �ݵ�� Class���� Main���� �����ؾ���
//public class Main{
	 // Queen�� ��
	 static int N;
	 // ������ üũ�� �迭
     static int []check_X;
     // ��� �밢�� üũ �迭
     static int []check_XY1;
     // �»� �밢�� üũ �迭;
     static int []check_XY2;
     // ���
     static int sol;     

	   // [1] �Լ� ���� �� �Ķ���� ����, y(�� ��ȣ)
     static void DFS(int y) {
    	 
 		   // [2] ���� ����
           if(y == N) {// ��ġ�� �迭�� ������ ��ġ���� ������
                 sol++; // ����� �� ������Ʈ
           }

           // [3]���ȣ��           
           for(int xx=0; xx<N; xx++) {

       	     	// [4] ����ġ��
                 if(check_X[xx] == 1) continue;
                 if(check_XY1[y+xx] == 1) continue;
                 if(check_XY2[y-xx+N-1] == 1) continue;

                 // �������� set
                 // üũ�� x��ǥ�� ���ϸ� ��� üũ ����
                 check_X[xx] = 1;
                 // ���� y��ǥ�� üũ�� x��ǥ�� ���ϸ� ��� �밢�� üũ ����
                 check_XY1[y+xx] = 1;
                 // ���� y��ǥ���� üũ�� x��ǥ�� ���� (���Ǽ� - 1) ���� ���ϸ� �»� �밢�� üũ ����
                 check_XY2[y-xx+N-1] = 1;

                 DFS(y+1);

                 // �������� ����
                 check_X[xx] = 0;
                 check_XY1[y+xx] = 0;
                 check_XY2[y-xx+N-1] = 0;
           }
     }     

     public static void main(String[] args) throws FileNotFoundException {

   	    System.setIn(new FileInputStream("test23.txt")); 
           Scanner sc = new Scanner(System.in);           

           // �Է�
           N = sc.nextInt();
           check_X = new int [N+10];
           check_XY1 = new int [N*2+10];
           check_XY2 = new int [N*2+10];           

           // DFS
           DFS(0);           

           // ���
           System.out.print(sol);

           sc.close();
     }
}