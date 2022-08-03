/*	Charls's Addition Exam
[문제]
덧셈을 못하는 철수를 공부시키기 위해 몇개의 자연수들을 주고,
그 중에 몇 개의 수를 골라서 그 합이 K가 될 수 있는지 알아보라고 시켰다.

철수 어머니는 자연수들을 무작위로 선택해서 본인도 가능한지 아닌지 모르고 있다.
어머니가 채점을 할 수 있게 주어진 문제의 답을 찾아주자.

[입력]
첫번째 줄에 테스트 케이스의 개수 T가 주어진다.
두번째 줄부터 테스트 케이스의 내용이 T개만큼 주어진다.
(단, 1 <= T <= 10)

테스트 케이스의 첫 줄에 자연수의 개수 N과 K가 공백으로 구분되어 입력된다.
다음 줄에 N개의 자연수 di가 공백으로 구분되어 입력된다.
(단, 1 <= di <= 100,000이며, 5 <= N <= 20이며, 1 <= K <= 2,000,000이다.)

[출력]
T줄에 걸쳐 각 테스트 케이스 별로 주어진 자연수 중 
몇개의 합이 K가 되면 Yes,
아니면 NO를 출력한다.

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
3 10
3 3 4
20 200000
100 200 400 800 1600 3200 6400 12800 25600 51200 102400 204800 409600 819200 1638400 3276800 6553600 13107200 23214400 52428800
20 200000
100 200 819200 800 1600 3200 6400 12800 25600 51200 102400 204800 409600 400 1638400 3276800 6553600 13107200 23214400 52428800

[츌력 예시]
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
	
	static int N, K;	//	수의 개수 N과 합 K
	static String AnsTF;	//	결과값 (합의 일치 여부)

	static int Sum;
	static ArrayList<Integer> di;	//	주어진 N개의 수
	//	Improve : 1차원 배열로 입력을 받아도 상관이 없으나,
	//			  ArrayList를 사용하여 보다 손쉽게 K보다 큰 수를 배제할 수 있음.
	static boolean Stat[];	//	사용 여부 (중복 사용을 방지하기 위함)
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
				if(tmp <= K) {	//	K보다 큰 수에 대한 가지치키
					di.add(tmp);
				}
			}
			Stat = new boolean[di.size()];	//	입력된 수만큼 배열 생성
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
		if(K < Sum)	return;	//	합이 K보다 큰 경우, return하여 되돌아가기
		
		else {	//	Sum < K, 합이 K보다 작은 경우
			if(n == N)	return;	//	숫자가 모두 사용된 경우 return
			
			for(int i = 0; i < di.size(); i++) {
				if(!Stat[i]) {	//	숫자가 사용되지 않음
					Stat[i] = true;	//	숫자를 사용 처리
					Sum+= di.get(i);	//	합에 현재 숫자를 더함
					
					if(Sum == K) {	//	합이 K에 도달한 경우
						AnsTF = "Yes";
						return;
					}
					
					DFS(n + 1);
					
					//	되돌리기
					Stat[i] = false;	//	숫자에 대한 미사용 처리
					Sum-= di.get(i);	//	합에 더해졌던 수를 다시 차감
				}
			}
		}
	}	//	End DFS Method
}	//	End Class