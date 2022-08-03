/*	해석
입력값 / 필요값

백트래킹 (시작정보)
- 종료조건 (시작정보 == 종료점?)
   Y : 출력 후 Return (되돌리기)
   N : 조건 (사용중이지 않은 경우)
       Y : Continue
       N : 사용 처리 / 값 대입 (배열 자리에)
		       재귀 호출 
		       미사용 처리
 */
package SWCert_ADV;

import java.util.Scanner;
import java.io.FileInputStream;

public class AD_BackTracking {
	
	static int N = 4;
	static int[] sol = new int [N];
	static int[] perm = new int [N];
	
	public static void main(String args[]) throws Exception {
		backtrack(0);
	}
	
	public static void backtrack(int n) {
		if(isSolution(n)) {
			processSolution();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(perm[i] == 0) {
				sol[n] = i + 1;
				perm[i] = 1;
				backtrack(n + 1);
				perm[i] = 0;
			}
		}
		
	}
	
	public static boolean isSolution(int n) {
		return (n == N);
	}
	
	public static void processSolution() {
		for(int i = 0; i < N; i++) {
			System.out.printf("%d", sol[i]);
		}
		System.out.println();
	}
}
