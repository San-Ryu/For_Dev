/*	Charls's Addition Exam
[����]
������ ���ϴ� ö���� ���ν�Ű�� ���� ��� �ڿ������� �ְ�,
�� �߿� �� ���� ���� ��� �� ���� K�� �� �� �ִ��� �˾ƺ���� ���״�.

ö�� ��Ӵϴ� �ڿ������� �������� �����ؼ� ���ε� �������� �ƴ��� �𸣰� �ִ�.
��Ӵϰ� ä���� �� �� �ְ� �־��� ������ ���� ã������.

[�Է�]
ù��° �ٿ� �׽�Ʈ ���̽��� ���� T�� �־�����.
�ι�° �ٺ��� �׽�Ʈ ���̽��� ������ T����ŭ �־�����.
(��, 1 <= T <= 10)

�׽�Ʈ ���̽��� ù �ٿ� �ڿ����� ���� N�� K�� �������� ���еǾ� �Էµȴ�.
���� �ٿ� N���� �ڿ��� di�� �������� ���еǾ� �Էµȴ�.
(��, 1 <= di <= 100,000�̸�, 5 <= N <= 20�̸�, 1 <= K <= 2,000,000�̴�.)

[���]
T�ٿ� ���� �� �׽�Ʈ ���̽� ���� �־��� �ڿ��� �� 
��� ���� K�� �Ǹ� Yes,
�ƴϸ� NO�� ����Ѵ�.

[�Է� ����]
7
10 10
10 2 2 2 2 2 1 1 1 1
10 10
2 2 2 2 2 1 1 1 1 1
5 19
1 2 4 7 10
5 25
1 2 4 7 10
3 10
3 3 4
20 200000
100 200 400 800 1600 3200 6400 12800 25600 51200 102400 204800 409600 819200 1638400 3276800 6553600 13107200 23214400 52428800
20 200000
100 200 819200 800 1600 3200 6400 12800 25600 51200 102400 204800 409600 400 1638400 3276800 6553600 13107200 23214400 52428800

[���� ����]
#1 Yes
#2 Yes
#3 Yes
#4 No
#5 Yes
#6 Yes
#7 Yes
 */
package SWCert_ADV;

import java.io.*;
import java.util.*;

public class AD_DFS_AdditionStudyForCharls {
	static long TimeStartPoint = 0;
	static long TimeEndPoint = 0;
	static long TimeResult = 0;
	
	static int N, K;	//	���� ���� N�� �� K
	static String AnsTF;	//	����� (���� ��ġ ����)

	static int Sum;
	static ArrayList<Integer> di;	//	�־��� N���� ��
	//	Improve : 1���� �迭�� �Է��� �޾Ƶ� ����� ������,
	//			  ArrayList�� ����Ͽ� ���� �ս��� K���� ū ���� ������ �� ����.
	static boolean Stat[];	//	��� ���� (�ߺ� ����� �����ϱ� ����)
	public static void main(String args[]) throws Exception{
		TimeStartPoint = System.currentTimeMillis();
		
		System.setIn(new FileInputStream("Input (AD_DFS_AdditionStudyForCharls.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= T; tc++) {
		//	Init. & Ipt
			AnsTF = "No";
			Sum = 0;
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			di = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp <= K) {	//	K���� ū ���� ���� ����ġŰ
					di.add(tmp);
				}
			}
			Stat = new boolean[di.size()];	//	�Էµ� ����ŭ �迭 ����
		//	Init. & Ipt
			
		//	Oper.
			DFS(0);
		//	Oper.
			
		//	Opt.
			System.out.println("#" + tc + " " + AnsTF);
		//	Opt.			
		}	//	End Test Case
		
		TimeEndPoint = System.currentTimeMillis();
		TimeResult = TimeEndPoint - TimeStartPoint;
		System.out.println(TimeResult + " [ms]");
		System.out.println(TimeResult/1000 + " [sec]");
	}	//	End Main Method
	
	public static void DFS(int n) {
		if(K < Sum)	return;	//	���� K���� ū ���, return�Ͽ� �ǵ��ư���
		
		else {	//	Sum < K, ���� K���� ���� ���
			if(n == N)	return;	//	���ڰ� ��� ���� ��� return
			
			for(int i = 0; i < di.size(); i++) {
				if(!Stat[i]) {	//	���ڰ� ������ ����
					Stat[i] = true;	//	���ڸ� ��� ó��
					Sum+= di.get(i);	//	�տ� ���� ���ڸ� ����
					
					if(Sum == K) {	//	���� K�� ������ ���
						AnsTF = "Yes";
						return;
					}
					
					DFS(n + 1);
					
					//	�ǵ�����
					Stat[i] = false;	//	���ڿ� ���� �̻�� ó��
					Sum-= di.get(i);	//	�տ� �������� ���� �ٽ� ����
				}
			}
		}
	}	//	End DFS Method
}	//	End Class