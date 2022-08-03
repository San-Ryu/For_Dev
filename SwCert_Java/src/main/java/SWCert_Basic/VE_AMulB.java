/*	A와 B의 곱값을 출력
10
1 3 
2 3
4 0
11 21
-80 20
12 -8
32 24
-1 -1
-30 55
1 1
*/
package SWCert_Basic;

import java.io.*;
import java.util.*;

public class VE_AMulB {
	static int A, B;
	static int AnsN;
	
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream(""));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
		//	Init. & Ipt.
			A = sc.nextInt();
			B = sc.nextInt();
		//	Init. & Ipt.
			
		//	Oper. & Opt.
			System.out.println(Mul(A, B));
		//	Oper. & Opt.
		}	//	End Test Case
	}	//	End Main
	
	public static int Mul(int a, int b) {
		return (a * b);
	}
}	//	End Class