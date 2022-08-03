/* 절댓값 구현
전자계산기 상의 절댓값 기능
Math. 라이브러리 참조 없이 절댓값 기능 구현

[입력 예시]
5
-1
-3
6
-10
10

[출력 예시]
#1 1
#2 3
#3 6
#4 10
#5 10
*/
/*
1) 간단히 -1을 곱하는 방법 (Float 포함)
2) 정수의 경우, for문을 통해 0으로부터 떨어진 거리를 Count
 */
package SWCert_Basic;

import java.util.Scanner;
import java.io.FileInputStream;

public class VE_ABS {
	static int A;
	
	static int tmp;
	public static void main(String arge[]) throws Exception{
		System.setIn(new FileInputStream("Input (VE_ABS).txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
		//	Init. & Ipt.
			tmp = 0;
			A = sc.nextInt();

		//	Init. & Ipt.
			
		//	Oper
			if(A < 0)	A *= -1;
			
			System.out.println("#" + tc + " " + A);
		//	Oper
		}	//	End Test Case
	}	//	End Main
}	//	End Class
