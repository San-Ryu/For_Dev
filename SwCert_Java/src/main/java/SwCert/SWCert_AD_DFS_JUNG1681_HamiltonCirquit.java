package SwCert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
[JUNG 1681]해밀턴 순환회로

[문제]
문제를 잘 풀기로 소문난 도경이는 모든 올림피아드 대회에 참가하고 싶어 했다. 대회에 참가하여 상이란 상은 다 타고 싶은 마음이었지만, 한 가지 걸리는 것이 있었다.
문제는 올림피아드 대회가 모두 해외에서 열리는 관계로 비행기 값이 굉장히 많이 들어간다는 것이다.
결국에는 집으로 다시 돌아와야 하는데, 모든 대회에 1번씩만 참가하고 집으로 돌아오는 경비를 가장 최소화하고 싶다.
도경이는 이것을 해결하지 못하면, 대회에 참가하기가 어렵게 된다.
대회는 참가하기만 하면 언제든지 알고리즘 문제를 풀 수 있기 때문에 경기를 계산하는 것 이외의 사항은 고려하지 않아도 된다.

[입력]
첫 줄은 참가하는 대회의 수 N(1≤N≤12)을 입력 받는다. 이때, 출발지(집)는 1번으로 한다.
둘째 줄은 N*N 크기의 대회 개최지와 개최지를 이동하는 항공료(0≤항공료<100)가 나온다.
각 항공료는 한 칸의 공백으로 구분된다. 만약에 개최지에서 개최지로 이동할 수 있는 항공로가 없다면 항공료의 값을 0으로 표시한다.

[출력]
집에서 출발하여 전체 대회를 모두 참가하고 돌아올 때, 최소의 항공료를 출력한다.
*/
/* DFS 함수 설계 비법

0) Main 생성
  DFS(1,1,0);
 
1) 파라미터
   pos -> [방문할 도시의 순서] 사용할 숫자의 위치(index)
   s -> [출발 도시]
   cost -> [pos 이전까지의 비용]

2) 리턴 값
   [ void 사용 ] 모든 경우의 수 확인후 가장 비용이 적게드는 경우 확인
     
3) 종료 조건   
     if(pos == N) 마지막까지 왔으면,
      1) 다시 1로 돌아갈수 있는가, return;
      2) 총금액을 계산, sol 업데이트, return;

4) 가지치기
      1) 이미 방문했으면, visit[2,3,4,5] 필요
      2) 비행기가 없으면, (0)
      3) 넘어온 cost가 sol보다 크거나 같으면, cost >= sol
*/

public class SWCert_AD_DFS_JUNG1681_HamiltonCirquit {
//사이트 제출 시에는 반드시 Class명을 Main으로 지정해야함
//public class Main{
	// 참가하는 대회의 도시
	static int N;
	// 항공료 배열
	static int[][] node;
	// 경로 배열
	static int[] path;
	// 방문 체크 배열
	static int[] visit;
	// 최소비용 결과
	static int sol;
	
	// [1] 함수 형태 및 파라미터 생성
	static void DFS(int pos, int s, int cost){
		// [2] 종료조건
		if(pos == N){
			//  1) 다시 1로 돌아갈수 있는가, return;
			if(node[s][1] == 0) return;

		    //  2) 총금액을 계산, sol 업데이트, return;
			if(cost+node[s][1] < sol) {
				sol = cost+node[s][1];
				return;
			}
		}
		
		// [3] for문으로 재귀호출 [ 방문할 도시 2번부터 N번 도시까지 for문 ]
		for(int i = 2; i <= N; i++){
			
			// [4] 가지치기
			if(visit[i] == 1) continue; // 이미 방문했는지 체크, visit[i] 방문 체크 배열의 방문 내역 확인
			if(node[s][i] == 0) continue; // 비행기가 없으면, node[s][i] 해당 배열에 0 값 확인
			if(cost+node[s][i] >= sol) continue; // 넘어온 cost가 sol보다 크거나 같으면, cost >= sol
			
			  visit[i] = 1; // 해당 도시 방문 내역 추가, 도시 i를 방문했기 때문에 visit[i] 에 입력해야함
		      DFS(pos+1,i/* 방문하는 도시 = i */,cost+node[s][i]);
		      visit[i] = 0; // 방문 내역 제거
		      
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
