package SwCert;
/*   Ż��
[����]
����̴� �������� �˼� �� ���� Ż�����Ѿ� �Ѵ�.
�� ������ 1��¥�� �ǹ��̰�, ����̴� ��� ��鵵�� �����.

��鵵���� ��� ���� ���� ��Ÿ���ְ�, Ż�����Ѿ� �ϴ� �˼��� ��ġ�� ��Ÿ�� �ִ�.
������ ���� �������� �˼� �� ���� ������ �ִ� ������ ����̴�.

���� �߾� ����ǿ����� �� �� �ִ�.
����̴� Ư���� ����� �̿��� ������� ������ �ʰ� ���� ������ �Ѵ�.
������, ���� ������ �ð��� �ſ� ���� �ɸ���.
�� �˼��� Ż����Ű�� ���ؼ� ����� �ϴ� ���� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

[�Է�]
ù° �ٿ� �׽�Ʈ ���̽��� ������ �־�����. �׽�Ʈ ���̽��� ���� 100���� ���� �ʴ´�.

ù° �ٿ��� ��鵵�� ���� h�� �ʺ� w�� �־�����. (2 �� h, w �� 100)
���� h�� �ٿ��� ������ ��鵵 ������ �־�����, �� ������ '.', ������ �� ���� ���� '*', ���� '#', �˼��� ��ġ�� '$'�̴�.

����̴� ���� ���� �����Ӱ� �̵��� �� �ְ�, ��鵵�� ǥ�õ� �˼��� ���� �׻� �� ���̴�.
�� �˼��� ������ �ٱ��� �����ϴ� ��ΰ� �׻� �����ϴ� ��츸 �Է����� �־�����.

[���]
�� �׽�Ʈ ���̽����� �� �˼��� Ż����Ű�� ���ؼ� ����� �ϴ� ���� �ּڰ��� ����Ѵ�.

[�Է� ����]
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

[��� ����]
#1 4
#2 0
#3 9
*/
import java.io.*;
import java.util.*;

public class SWCert_AD_BOJ9376_JailBreak {
//����Ʈ ���� �ÿ��� �ݵ�� Class���� Main���� �����ؾ���
//public class Main{
   static int N, M;
   static int Map[][];
   static int AnsN;
  
   static int Ans1, Ans2;
   static int Stat[][];
   static int dx[] = {-1, 0, 0, 1};
   static int dy[] = {0, -1, 1, 0};
  
   static Queue<Integer> qn;   //   �˼� ��ȣ
   static Queue<Integer> qx;   //   �˼��� X
   static Queue<Integer> qy;   //   �˼��� Y
   static Queue<Integer> qm;   //   �˼��� �̵� Ƚ��
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
        
         qn.add(1);   //   �˼� 1��
         qm.add(0);   //   �˼� ���� ��
         qn.add(2);   //   �˼� 2��
         qm.add(0);   //   �˼� ���� ��
         while(!qx.isEmpty()) {
            int curn = qn.poll();
            int curx = qx.poll();
            int cury = qy.poll();
            int curm = qm.poll();
           
            for(int i = 0; i < 4; i++) {
               int nx = curx + dx[i];
               int ny = cury + dy[i];
              
               if(0 < nx || nx < (N - 1) || 0 < ny || ny < (M - 1)) {
                  //   �� �κ��� �ٲٴ°� ���� �� ����. *�̰ų� �� ���̰ų� �湮�� �̷��� �ִ� ��� Q ������ ���ϰ� �ؼ� �����°�...
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