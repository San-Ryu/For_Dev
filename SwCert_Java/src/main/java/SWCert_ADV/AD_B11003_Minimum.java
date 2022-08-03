/*	최솟값 찾기
[문제]
N개의 수 A(1), A(2), ..., A(N)과 L이 주어진다.
D(i) = A(i - L + 1) - A(i) 중의 최솟값이라고 할 때, D에 저장된 수를 출력하는 프로그램을 작성하시오.
이 떄, i <= 0인 A(i)는 무시하고 D를 구해야한다.

[입력]
첫쨰 줄에 N과 L이 주어진다. (1 <= L <= N <= 5,000,000)
둘째 줄에는 N개의 수 A(i)가 주어진다. (-10^9 <= A <= 10^9)

[출력]
첫째 줄에 D(i)를 공백으로 구분하여 순서대로 출력한다.

[입력 예시]
1
1 2 3
1 5 2 3 6 2 3 7 3 5 2 6

[출력 예시]
#1 1 1 1 2 2 2 2 2 3 3 2 2 
 */
package SWCert_ADV;

import java.io.*;
import java.util.*;

public class AD_B11003_Minimum {
	static int N, L;
	static ArrayList<Integer> Arr;
	static int Ans;
	
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("Input (AD_Minimum).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= T; tc++) {
		//	Init. & Ipt.
			Ans = 0;
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
					
			Arr = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
		//	Init. & Ipt.
		
		//	Oper. & Opt.
			System.out.println("#" + tc + " ");
			Oper(0);
		//	Oper. & Opt. 
		}	//	End Test Case
		
		br.close();

	}	//	End Main Method
	
	public static void Oper(int n) {
		if(N < n)	return;
		
		int tmp = (n - L + 1);
		
		for(int i = tmp; i <= (n - 1); i++)	{
			if(tmp < 0) continue;
			
		}
		
		System.out.print(Ans + " ");
		Oper(n + 1);
	}	//	End Oper Method
}	//	End Class