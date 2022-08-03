/*	스택, 큐
[문제]
이 문제에서는 스택과 큐를 직접 구현해 본다. 
동시에 스택과 큐를 구현해야 하며 다음의 두 가지 명령이 있다.

1. 어떤 정수 a를 입력받아 스택의 top에 넣고 또한 큐의 rear에도 넣는다.
2. 스택의 top에서 정수를 제거한 다음 그 정수를 출력하고 
     큐의 front에서도 정수를 제거한 다음 그 정수를 출력한다.

[제한 조건]
1) 시간 제한 7.0 Sec
2) 메모리 제한 256 MB

[입력]
첫번째 줄에는 명령의 개수 N(1 <= N <= 100,000)이 주어진다.

다음 N개의 줄에는 명령을 하는 순서대로 명령이 주어진다. 
한 줄에 하나의 명령이 주어지며 "1 a"의 형식으로 주어지는 경우,
1번 명령을 정수 a(-10^9 ≤ a ≤ 10^9)로 하는 것이고, 

"2"의 형식으로 주어지면 것은 2번 명령을 수행하는 것이다.

[출력]
2번 명령을 할 때마다 각 줄에 순서대로 스택에서 뽑은 수와 큐에서 뽑은 수를 공백 하나로 구분하여 출력한다. 
만약 스택과 큐가 비어있을 경우 문자열 "empty"(따옴표 제외)를 출력한다.

[입력 예시]
6
2
1 10
1 20
2
2
2

[출력 예시]
empty
20 10
10 20
empty
*/
package SWCert_ADV;

import java.io.*;
import java.util.*;

//	koitp 제출시 Class명
//	public class source{
public class AD_Edu181031_QStk {
	static int N, Odr, Num;
	
	static Queue<Integer> q;
	static Stack<Integer> stk;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		q = new LinkedList<>();
		stk = new Stack<>();
		
		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			Odr = Integer.parseInt(st.nextToken());
			
			if(Odr == 1){
				Num = Integer.parseInt(st.nextToken());
				q.add(Num);
				stk.add(Num);
			}
			
			else if(Odr == 2){
				if(q.isEmpty() && stk.isEmpty())	System.out.println("empty");
				else	System.out.println(stk.pop() + " " + q.poll());
			}
		}
	}
}