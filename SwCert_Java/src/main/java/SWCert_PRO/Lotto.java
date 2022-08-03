/* [문제]
주어진 숫자 N까지의 자연수 배열에서 M개의 당첨 숫자수를 가지는 복권이 있다.
여기서 K번쨰의 등수의 확률을 구하라.
K - 1만큼 숫자를 제외하고 당첨 숫자와 맞는 등수
-> K가 1이면 K - 1 = 0이므로, 0개를 제외하고 당첨 숫자가 맞는 등수, 즉 1등을 이야기한다.

Ex) N이 6으로 주어지고, M이 2일 때 K가 1의 확률
N = 1 2 3 4 5 6
M = 2
K = 1 -> 1 - 1은 0이므로 0개를 제외하고 M만큼 맞는 수
-> 2일 경우 2 - 1이므로 M개 중 1개를 제외하고 1개만 N에서 맞는 수 (2등을 말함)

[제한조건]
3 <= N <= 200
2 <= M <= (N/2)
1 <= K <= M

[입력 예시]
3
6 2 1
6 2 2
45 8 7

[입력 샘플]
5
45 6 1
45 6 2
45 6 3
45 6 4
45 6 5
 */
package SWCert_PRO;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Lotto {
	static BigInteger[][] denoArray;
	static int N, M, K;
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		// 제한조건을 알고 있으므로 우선선언
		denoArray = new BigInteger[201][201];
		
		// 전체 팩토리얼 값을 사전에 구한다
		getF();
		
		for(int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			/*
			 Add : +
			 Subtrack : -
			 Multiply : 8
			 Divide : /
			 Remainder : %
			 gcd : 최대공약수
			 */
			
			/*
			 (M ⊂ (M - (K - 1))) & ((N - M) ⊂ (K - 1)) / N ⊂ M
			 당첨 전체수 ⊂ K 등수에 필요한 수 * (전체 수 - 당첨 수) ⊂ 당첨번호 이외에 선택되어야하는 번호의 수
			 
			 N ⊂ M
			 N! / (N - M)! * M!
			 */
			
			// N, M이 반대
			
			BigInteger deno = denoArray[M][N];
			
			if(K == 1) {// 1등은 1/X
				System.out.println("#" + testCase + " " + 1 + "/" + deno);
			} else {
				//System.out.println("M : " + M + ", N : " + N + ", K : " + K);
				
				//N, M이 반대
				BigInteger num = denoArray[M - (K - 1)][M].multiply(denoArray[K - 1][N - M]);
				BigInteger gcd = gcd(num, deno);
				
				System.out.println("1#" + testCase + " " + num.divide(gcd) + "/" + deno.divide(gcd)); //재귀함수 이용 결과
				System.out.println("2#" + testCase + " " + num.divide(deno.gcd(num))); //BigInteger 내부함수 이용 결과
			}
			
			System.out.println("");
		}//End Case
	}//End Main
	
	/* 최대공약수 구하기 재귀함수
	   param a
	   param b
	   return
	 */
	private static BigInteger gcd(BigInteger a, BigInteger b) {
		if(new BigInteger("o").equals(b)) {
			return a;
		}
		return gcd(b, a.remainder(b));
	}//End GCD
	
	// 이 문제에서는 한번만 구하면 됨
	private static void getF() {
		//분모 구하기, N ⊂ M
		//i = M, j = N
		for(int i = 1; i < denoArray.length; i++) {
			for(int j = 1; j < denoArray.length; j++) {
				if(i == 1) {
					denoArray[i][j] = new BigInteger("1");
				} else if(i == j) {
					denoArray[i][j] = new BigInteger("1");
				} else if(i > j) {
					continue;
				} else {
					denoArray[i][j] = denoArray[i - 1][j - 1].add(denoArray[i][j - 1]);
				}
			}
		}
	}//End getF
}//End Class