/*	����� ���
[����]
�� ���븶�� ����� �ִ�.
����� N���̰�, ����� M���̴�.
���븶�� ��Ī�Ǵ� ����� �ִ�.
��Ī���� �ʾ����� ���븦 ��ü�ؾ��Ѵ�.

��ü�Ǵ� �ð��� ����� ����Ǵ� �ð��� ������ ���϶�.

N 1 2 3 4 5 6 7 8 9 10
M 3 1 5 2 4 1 2 3 4 5

Ex)
N	1 2 3 4 5 6 7 8 9 10
M	3 1 5 2 4 1 2 3 4 5
->	1 5 2 4 1 2 3 4 5 3
->	5 2 4 1 2 3 4 5 3 1
->	2 4 1 2 3 4 5 3 1 5

�� ���� ����� ����� ���� ������ �� �ڷ� ������,
��ĭ�� ������ ��� ����� ����� ��ġ�ϴ��� Ȯ��.

[�Է�]
�׽�Ʈ ���̽�
���� ũ�� / ��� ũ�� / ����� ã�µ� �ҿ�Ǵ� �ð� / ����� �����ϴ� �ð�
���뿡 ���̴� ���
����� ��ġ

[�Է� ����]
2
5 3 2 10
1 2 3 1 2
3 2 1
5 3 2 10
3 2 2 1 3
2 3 1

[��� ����]
#�׽�Ʈ���̽� �� �ɸ� �ð�
#1 70
#2 62
 */

/*
ť�� �̿��� ���� ���������� �޾ƿ���, ������ �ٲٴ� �ͱ����� �Ϸ��Ͽ���. 
�� �κ��� ���� ť�� ���� �ʾƵ� �� �� ����.

�ٸ�, ť�� Ȱ���Ͽ� Scene�� �ѱ�� �κп��� ������ ã�� �� ���� �� ����.
�ش� �����߿� �غ��� ���� ��
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
