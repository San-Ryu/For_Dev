/*	철수의 덧셈 계산 
[문제]
덧셈을 못하는 철수를 공부시키기 위해 몇개의 자연수들을 주고,
그 주엥 몇개의 수를 골라서 그 합이 K가 될 수 있는지 알아보라고 시켰다.

철수 어머니는 자연수들을 무작위로 선택했기 때문에, 본인도 가능한지 모르고 있다.
어머니가 채점을 할 수 있도록 주어진 문제의 답을 찾아주자.

[입력]
첫번째 줄에 테스트케이스의 개수 T가 주어진다. (단, 1 <= T <= 10)
두번째 줄부터 테스트케이스의 내용이 T개만큼 주어진다.

테스트케이스의 첫 줄에 자연수의 개수 N과 K가 공백으로 구분되어 입력된다.
다음 줄에 N개의 자연수 di(1 <= di <= 100,000)가 공백으로 구분되어 입력된다.
(단,	5 <= N <= 20이며, 
	1 <= K <= 2,000,000이다.)
   
[출력]
T 줄에 걸쳐 각 테스트 케이스별로 주어진 자연수 중 몇개의 합이 K가 되면 "Yes"를, 아니면 "No"를 출력한다.

[입력 예시]
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

[출력 예시]
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
				if(tmp <= K) {	//	K보다 큰 수 가지치기
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
		if(K < Sum)	return;	//	중간합이 K보다 커진 경우, 되돌려야 하므로
		
		else {
			if(n == N)	return;	//	중간 합이 K보다 작은 경우 중, 숫자가 모두 사용된 경우
			
			for(int i = 0; i < di.size(); i ++) {
				if(!Stat[i]) {
					Stat[i] = true;
					Sum+= di.get(i);
					
					if(Sum == K) {	//	합이 K에 도달한 경우
						AnsTF = "Yes";
						return;
					}
					
					DFS(n + 1);	//	합이 K에 도달하지 못한 경우, 숫자를 더 추가
					Stat[i] = false;	//	위의 종료조건 중 하나를 충족하면, 되돌리기
					Sum-= di.get(i);
				}
			}
		}
	}	//	End DFS
}	//	End Class