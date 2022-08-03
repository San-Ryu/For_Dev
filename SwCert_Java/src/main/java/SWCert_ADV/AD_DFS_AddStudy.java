/*	ö���� ���� ��� 
[����]
������ ���ϴ� ö���� ���ν�Ű�� ���� ��� �ڿ������� �ְ�,
�� �ֿ� ��� ���� ��� �� ���� K�� �� �� �ִ��� �˾ƺ���� ���״�.

ö�� ��Ӵϴ� �ڿ������� �������� �����߱� ������, ���ε� �������� �𸣰� �ִ�.
��Ӵϰ� ä���� �� �� �ֵ��� �־��� ������ ���� ã������.

[�Է�]
ù��° �ٿ� �׽�Ʈ���̽��� ���� T�� �־�����. (��, 1 <= T <= 10)
�ι�° �ٺ��� �׽�Ʈ���̽��� ������ T����ŭ �־�����.

�׽�Ʈ���̽��� ù �ٿ� �ڿ����� ���� N�� K�� �������� ���еǾ� �Էµȴ�.
���� �ٿ� N���� �ڿ��� di(1 <= di <= 100,000)�� �������� ���еǾ� �Էµȴ�.
(��,	5 <= N <= 20�̸�, 
	1 <= K <= 2,000,000�̴�.)
   
[���]
T �ٿ� ���� �� �׽�Ʈ ���̽����� �־��� �ڿ��� �� ��� ���� K�� �Ǹ� "Yes"��, �ƴϸ� "No"�� ����Ѵ�.

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
20 200000
100 200 400 800 1600 3200 6400 12800 25600 51200 102400 204800 409600 819200 1638400 3276800 6553600 13107200 23214400 52428800
20 200000
100 200 819200 800 1600 3200 6400 12800 25600 51200 102400 204800 409600 400 1638400 3276800 6553600 13107200 23214400 52428800

[��� ����]
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

public class AD_DFS_AddStudy {
	static int N, K;
	static String AnsTF;
	
	static int Sum;
	static ArrayList<Integer> di;
	static boolean Stat[];
	
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream(""));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
		//	Init. & Ipt.
			Sum = 0;
			AnsTF = "No";
			
			N = sc.nextInt();
			K = sc.nextInt();
			
			di = new ArrayList<>();
			Stat = new boolean[N];
			for(int i = 0; i < N; i++) {
				int tmp = sc.nextInt();
				if(tmp <= K) {	//	K���� ū �� ����ġ��
					di.add(tmp);
				}
			}
		//	Init. & Ipt.
			
		//	Oper.
			DFS(0);
		//	Oper.
			
		//	Opt.
			System.out.println("#" + tc + " " + AnsTF);
		//	Opt.
		}	//	End TestCase
	}	//	End Main
	
	public static void DFS(int n) {
		if(K < Sum)	return;	//	�߰����� K���� Ŀ�� ���, �ǵ����� �ϹǷ�
		
		else {
			if(n == N)	return;	//	�߰� ���� K���� ���� ��� ��, ���ڰ� ��� ���� ���
			
			for(int i = 0; i < di.size(); i ++) {
				if(!Stat[i]) {
					Stat[i] = true;
					Sum+= di.get(i);
					
					if(Sum == K) {	//	���� K�� ������ ���
						AnsTF = "Yes";
						return;
					}
					
					DFS(n + 1);	//	���� K�� �������� ���� ���, ���ڸ� �� �߰�
					Stat[i] = false;	//	���� �������� �� �ϳ��� �����ϸ�, �ǵ�����
					Sum-= di.get(i);
				}
			}
		}
	}	//	End DFS
}	//	End Class