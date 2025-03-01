/* [백준] 2225 합분해
[문제]
0부터 N까지의 정수 K개를 더해서 그 합이 N이 되는 경우의 수를 구하는 프로그램을 작성하시오.
덧셈의 순서가 바뀐 경우는 다른 경우로 센다. (1 + 2와 2 + 1은 서로 다른 경우)
또한, 한개의 수를 여러번 쓸 수도 있다.

[입력]
첫째 줄에 두 정수 
N(1 <= N <= 200),
K(1 <= K <= 200)
가 주어진다.

[출력]
첫쨰 줄에 답을 1,000,000,000으로 나눈 나머지를 출력한다.

[입력 예시]
1
20 2

[출력 예시]
21
 */
package SWCert_PRO;

import java.io.*;
import java.util.*;

public class Prg_Pro_B2225_SumDiv {
	static int T;	//Test Case
	static int N, K;	//합 N, 정수의 개수 K
	
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream(""));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= T; tc++) {
		//Ipt.
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			
		}
	}//End Main
}//End Class