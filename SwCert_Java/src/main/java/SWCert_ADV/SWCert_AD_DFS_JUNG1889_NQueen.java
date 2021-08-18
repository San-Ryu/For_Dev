package SWCert_ADV;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
[JUNG1889]N QUEEN

[문제]
체스에서 queen의 가로, 세로, 대각선 방향으로 어느 곳이나 한 번에 움직일 수 있다.
즉 다음과 같은 체스판에서 queen이 X라고 표시된 위치에서 있을 때, 그 다음 queen이 움직여 갈 수 있는 부분은 어둡게 칠해진 부분 중의 하나이다.
N*N 크기의 정방형 체스판이 주어졌다. 우리는 거기에 N개의 queen을 배치하려고 하는데, 모든 queen들은 서로 잡아먹을 수 없어야 한다.
그렇다면 queen들을 어떻게 배치해야만 할까? 가능한 모든 경우의 개수를 출력한다.

[입력]
Queen의 수 N(1≤N≤13)을 입력 받는다.

[출력]
N*N의 체스판에서 N개의 queen들이 서로 잡아먹지 않는 위치로 놓을 수 있는 방법의 수를 출력한다..
*/

public class SWCert_AD_DFS_JUNG1889_NQueen {
//사이트 제출 시에는 반드시 Class명을 Main으로 지정해야함
//public class Main{
	 // Queen의 수
	 static int N;
	 // 세로줄 체크용 배열
     static int []check_X;
     // 우상 대각선 체크 배열
     static int []check_XY1;
     // 좌상 대각선 체크 배열;
     static int []check_XY2;
     // 결과
     static int sol;     

	   // [1] 함수 형태 및 파라미터 생성, y(열 번호)
     static void DFS(int y) {
    	 
 		   // [2] 종료 조건
           if(y == N) {// 위치가 배열의 마지막 위치까지 왔을때
                 sol++; // 경우의 수 업데이트
           }

           // [3]재귀호출           
           for(int xx=0; xx<N; xx++) {

       	     	// [4] 가지치기
                 if(check_X[xx] == 1) continue;
                 if(check_XY1[y+xx] == 1) continue;
                 if(check_XY2[y-xx+N-1] == 1) continue;

                 // 전역변수 set
                 // 체크할 x좌표를 더하면 상단 체크 가능
                 check_X[xx] = 1;
                 // 현재 y좌표와 체크할 x좌표를 더하면 우상 대각선 체크 가능
                 check_XY1[y+xx] = 1;
                 // 현재 y좌표에서 체크할 x좌표를 뺴고 (퀸의수 - 1) 값을 더하면 좌상 대각선 체크 가능
                 check_XY2[y-xx+N-1] = 1;

                 DFS(y+1);

                 // 전역변수 복구
                 check_X[xx] = 0;
                 check_XY1[y+xx] = 0;
                 check_XY2[y-xx+N-1] = 0;
           }
     }     

     public static void main(String[] args) throws FileNotFoundException {

   	    System.setIn(new FileInputStream("test23.txt")); 
           Scanner sc = new Scanner(System.in);           

           // 입력
           N = sc.nextInt();
           check_X = new int [N+10];
           check_XY1 = new int [N*2+10];
           check_XY2 = new int [N*2+10];           

           // DFS
           DFS(0);           

           // 출력
           System.out.print(sol);

           sc.close();
     }
}