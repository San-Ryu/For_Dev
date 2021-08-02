package SwCert;
/*   탈옥
[문제]
상근이는 감옥에서 죄수 두 명을 탈옥시켜야 한다.
이 감옥은 1층짜리 건물이고, 상근이는 방금 평면도를 얻었다.

평면도에는 모든 벽과 문이 나타나있고, 탈옥시켜야 하는 죄수의 위치도 나타나 있다.
감옥은 무인 감옥으로 죄수 두 명이 감옥에 있는 유일한 사람이다.

문은 중앙 제어실에서만 열 수 있다.
상근이는 특별한 기술을 이용해 제어실을 통하지 않고 문을 열려고 한다.
하지만, 문을 열려면 시간이 매우 많이 걸린다.
두 죄수를 탈옥시키기 위해서 열어야 하는 문의 개수를 구하는 프로그램을 작성하시오.

[입력]
첫째 줄에 테스트 케이스의 개수가 주어진다. 테스트 케이스의 수는 100개를 넘지 않는다.

첫째 줄에는 평면도의 높이 h와 너비 w가 주어진다. (2 ≤ h, w ≤ 100)
다음 h개 줄에는 감옥의 평면도 정보가 주어지며, 빈 공간은 '.', 지나갈 수 없는 벽은 '*', 문은 '#', 죄수의 위치는 '$'이다.

상근이는 감옥 밖을 자유롭게 이동할 수 있고, 평면도에 표시된 죄수의 수는 항상 두 명이다.
각 죄수와 감옥의 바깥을 연결하는 경로가 항상 존재하는 경우만 입력으로 주어진다.

[출력]
각 테스트 케이스마다 두 죄수를 탈옥시키기 위해서 열어야 하는 문의 최솟값을 출력한다.

[입력 예시]
3
5 9
****#****
*..#.#..*
****.****
*$#.#.#$*
*********
5 11
*#*********
*$*...*...*
*$*.*.*.*.*
*...*...*.*
*********.*
9 9
*#**#**#*
*#**#**#*
*#**#**#*
*#**.**#*
*#*#.#*#*
*$##*##$*
*#*****#*
*.#.#.#.*
*********

[출력 예시]
#1 4
#2 0
#3 9
*/
import java.io.*;
import java.util.*;

public class SWCert_AD_BOJ9376_JailBreak {
//사이트 제출 시에는 반드시 Class명을 Main으로 지정해야함
//public class Main{
   static int N, M;
   static int Map[][];
   static int AnsN;
  
   static int Ans1, Ans2;
   static int Stat[][];
   static int dx[] = {-1, 0, 0, 1};
   static int dy[] = {0, -1, 1, 0};
  
   static Queue<Integer> qn;   //   죄수 번호
   static Queue<Integer> qx;   //   죄수의 X
   static Queue<Integer> qy;   //   죄수의 Y
   static Queue<Integer> qm;   //   죄수의 이동 횟수
   public static void main(String args[]) throws Exception{
      System.setIn(new FileInputStream(""));
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      StringTokenizer st = null;
     
      st = new StringTokenizer(br.readLine());
      int T = Integer.parseInt(st.nextToken());
      for(int tc = 0; tc <= T; tc++) {
      //   Ipt.
         AnsN = 0;
        
         st = new StringTokenizer(br.readLine());  
         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
        
         Map = new int[N][M];
         qx = new LinkedList<>();
         qy = new LinkedList<>();
         for(int i = 0; i < N; i++)   {
            st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();
            for(int j = 0; j < M; j++)   {
               Map[i][j] = tmp.charAt(j);
               if(Map[i][j] == '$') {
                  qx.add(i);
                  qy.add(j);
               }
            }
         }
      //   Ipt.
        
         qn.add(1);   //   죄수 1번
         qm.add(0);   //   죄수 개문 수
         qn.add(2);   //   죄수 2번
         qm.add(0);   //   죄수 개문 수
         while(!qx.isEmpty()) {
            int curn = qn.poll();
            int curx = qx.poll();
            int cury = qy.poll();
            int curm = qm.poll();
           
            for(int i = 0; i < 4; i++) {
               int nx = curx + dx[i];
               int ny = cury + dy[i];
              
               if(0 < nx || nx < (N - 1) || 0 < ny || ny < (M - 1)) {
                  //   이 부분을 바꾸는게 좋을 것 같다. *이거나 맵 밖이거나 방문한 이력이 있는 경우 Q 저장을 안하게 해서 끝내는게...
                  qn.add(curn);
                  qx.add(nx);
                  qy.add(ny);
                 
                  if(Map[nx][ny] == '.')   qm.add(curm);
                  else if(Map[nx][ny] == '#')   qm.add(curm + 1);
                 
                  if((curn == 1) && ())   Ans1 = curm + 1;
               }
            }
         }
        
      //   Opt.
         System.out.println("#" + tc + " " + AnsN);
      //   Opt.
      }   //   End Test Case
   }   //   End Main
}   //   End Class