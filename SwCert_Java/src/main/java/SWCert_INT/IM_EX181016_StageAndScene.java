/*	무대와 장면
[문제]
각 무대마다 장면이 있다.
무대는 N개이고, 장면은 M개이다.
무대마다 매칭되는 장면이 있다.
매칭되지 않았으면 무대를 교체해야한다.

교체되는 시간과 장면이 진행되는 시간의 총합을 구하라.

N 1 2 3 4 5 6 7 8 9 10
M 3 1 5 2 4 1 2 3 4 5

Ex)
N	1 2 3 4 5 6 7 8 9 10
M	3 1 5 2 4 1 2 3 4 5
->	1 5 2 4 1 2 3 4 5 3
->	5 2 4 1 2 3 4 5 3 1
->	2 4 1 2 3 4 5 3 1 5

맨 앞의 장면이 무대와 맞지 않으면 맨 뒤로 보내고,
한칸씩 앞으로 당겨 무대와 장면이 일치하는지 확인.

[입력]
테스트 케이스
무대 크기 / 장면 크기 / 장면을 찾는데 소요되는 시간 / 장면을 진행하는 시간
무대에 쓰이는 장면
장면의 위치

[입력 예시]
2
5 3 2 10
1 2 3 1 2
3 2 1
5 3 2 10
3 2 2 1 3
2 3 1

[출력 예시]
#테스트케이스 총 걸린 시간
#1 70
#2 62
 */

/*
큐를 이용해 수를 순차적으로 받아오고, 순서를 바꾸는 것까지는 완료하였다. 
이 부분은 굳이 큐를 쓰지 않아도 될 것 같다.

다만, 큐를 활용하여 Scene을 넘기는 부분에서 편리성을 찾을 수 있을 것 같음.
해당 오전중에 해보면 좋을 듯
 */
package SWCert_INT;

import java.io.*;
import java.util.*;

public class IM_EX181016_StageAndScene {
	static int N, M, Trans, Play;
	static int Stage[], Scene[] = new int[1001];
	static int Ans;
	
	public static void main(String args[]) throws Exception{
  System.setIn(new FileInputStream("D:\\Redan_Workspace\\SWCert_Src\\Input (IM_EX181016_StageAndScene).txt"));
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st = null;
  
  st = new StringTokenizer(br.readLine());
  int T = Integer.parseInt(st.nextToken());
  for(int tc = 1; tc <= T; tc++) {
  //	Ipt
  st = new StringTokenizer(br.readLine());
  N = Integer.parseInt(st.nextToken());
  M = Integer.parseInt(st.nextToken());
  Trans = Integer.parseInt(st.nextToken());
  Play = Integer.parseInt(st.nextToken());
  Ans = 0;
  
  Stage = new int[N];
  st = new StringTokenizer(br.readLine());
  for(int i = 0; i < N; i++) {
  Stage[i] = Integer.parseInt(st.nextToken());
  }
  
  Queue<Integer> q = new LinkedList<>();
  st = new StringTokenizer(br.readLine());
  for(int i = 0; i < M; i++) {
  int tmp = Integer.parseInt(st.nextToken());
  q.add(tmp);
  }
  //	Ipt
  
  //	Oper
  int tmp;
  int Stage2[] = new int[N];
  for(int i = 0; i < M; i++) {
  Stage2[q.peek() - 1] = i + 1;
  q.poll();
  q.add(Stage2[q.peek()]);
  }
  
  for(int i = 1; i <= N; i++) {
  if(Scene[i] == Stage2[1]) {
  Ans+= Play;
  }
  else {
  while(Scene[i] == Stage2[1]) {
  tmp = Stage2[1];
  for(int j = 0; j < M; j++) {
  Stage2[j] = Stage2[j + 1];
  }
  Stage2[M - 1] = tmp;
  Ans+= Trans;
  
  if(Scene[i] == Stage[1]) {
  Ans+= Play;
  break;
  }
  }
  }
  }
  //	Oper
  
  //	Opt
  System.out.println(q.toString());
  for(int i = 0; i < M; i++) {
  System.out.print(Stage2[i]);
  }
  System.out.println();
  System.out.println("#" + tc + " " + Ans);
  //	Opt
  }	//	End Test Case
	}	//	End Main
}	//	End Class
