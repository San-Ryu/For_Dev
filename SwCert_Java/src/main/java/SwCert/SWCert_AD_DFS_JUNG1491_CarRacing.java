package SwCert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
[JUNG1491]자동차경주대회

[문제] 
전국 자동차 경주 대회가 매년 열리고 있다. 이 대회에서는 출발지점부터 도착지점까지 거리가 워낙 멀기 때문에 경주 도중에 각 자동차는 정비소를 방문하여 정비를 받아야 한다. 정비소들은 출발지점에서 도착지점으로 가는 길가에 있으며 ①번부터 차례로 번호가 붙어 있다.
이 대회에서는 참가하는 선수의 안전을 위하여 정비를 받지 않고 미리 정한 거리를 초과하여 갈 수 없도록 규칙을 정하였다. 그리고 정비소마다 정비하는데 걸리는 정비 시간이 서로 다를 수 있다.
정비소에서 정비하는데 걸리는 시간을 가장 적게 하려고 할 때 최소 총 정비시간을 구하는 프로그램을 작성하시오.
예를 들어, 아래 그림과 같이 정비소가 5개 있고, 한 번 정비를 받고 최대 140㎞를 갈 수 있는 경우를 생각해 보자. 출발지점에서 정비소 ①까지의 거리가 100㎞이고, 정비소 ①을 방문하여 정비할 때 걸리는 시간은 5분이다.
자동차가 출발지점에서 대회 규칙을 지키면서 정비소 ①, ③, ⑤를 차례대로 방문하여 도착지점까지 갈 수 있고, 정비소 ②, ④를 방문하여 갈 수도 있다.
정비소 ①, ③, ⑤를 방문하는 경우에는 16분(=5+4+7분)이 걸리는데,
이것은 정비소 ②, ④를 방문하여 걸리는 21분(=10+11분)보다 총 정비 시간이 적게 걸린다.

[입력]
입력 시 첫째 줄에는 정비를 받지 않고 갈 수 있는 최대 거리가 주어진다.
둘째 줄에는 정비소의 개수가 입력되는데 정비소 수는 50개 이하이다.
셋째 줄에는 인접한 정비소 사이의 거리가 차례로 주어진다.
넷째 줄에는 정비소 별 정비 시간이 차례로 주어진다.
모든 입력은 양의 정수이다.

[출력]
첫째 줄에 정비소에서 정비하는데 걸리는 총 정비 시간을 출력한다.
정비소를 전혀 방문하지 않아도 되는 경우에 총 정비 시간을 0으로 출력한다.
*/

public class SWCert_AD_DFS_JUNG1491_CarRacing {
//사이트 제출 시에는 반드시 Class명을 Main으로 지정해야함
//public class Main{
	  // 정비 받지 않고 갈수 있는 최대 거리, 정비소의 개수
      static int K, N;
      // 인접한 정비소 사이의 거리
      static int []L;
      // 정비소 별 정비 시간
      static int []T;
      // 결과
      static int sol = 0x7fffffff;      

  	   // [1] 함수 형태 및 파라미터 생성, pos(정비소번호), dist(pos까지 정비하지 않고 온 거리), cost(pos이전까지 정비한 비용)
       // 최소비용 구하기 = void
      static void DFS(int pos, int dist, int cost) {

    		// [4] 가지치기
    	   // pos까지 정비하지 않고 온 거리(dist)가 정비 받지 않고 갈수 있는 최대거리보다 크면 return
            if(dist > K) return;            

    		// [2] 종료 조건
            if(pos == N+1)  {// 위치가 배열의 마지막 위치까지 왔을때
                  if(cost < sol) sol = cost;
                  return;
            }
            
            // [4] 가지치기
            // pos이전까지 정비한 비용(cost) + pos까지의 거리가 전체비용보다 작으면 수행
            if(cost+T[pos] < sol) {
                // [3]재귀호출 1: 정비하는 경우(o), 정비를 하면 이전거리가 초기화됨
                  DFS(pos+1, L[pos+1], cost+T[pos]);
            }

            // [3]재귀호출 2: 정비하지 않는 경우(o), 정비를 하지 않으면 이전거리에 현재 거리가 추가됨
            DFS(pos+1, dist+L[pos+1], cost);
            
      }
 
      public static void main(String[] args) throws FileNotFoundException {

  	    System.setIn(new FileInputStream("test22.txt")); 
        Scanner sc = new Scanner(System.in);           

            // 입력
            K = sc.nextInt();
            N = sc.nextInt();
            L = new int [N+10];
            T = new int [N+10];
            
            for(int i=1; i<=N+1; i++) {
                  L[i] = sc.nextInt();
            }

            for(int i=1; i<=N; i++) {
                  T[i] = sc.nextInt();
            }            

            // DFS
            DFS(1, L[1], 0);            

            // 출력
            System.out.print(sol); 

            sc.close();
      }
}