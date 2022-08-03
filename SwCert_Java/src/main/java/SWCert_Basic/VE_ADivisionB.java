/* A/B를 출력

[입력 예시]
5
1 2
2 0
5 6
30 5
25 10
 */
package SWCert_Basic;

import java.io.*;
import java.util.*;

public class VE_ADivisionB {
	static float A, B;
	static String AnsN;
	
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream(""));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			A = sc.nextFloat();
			B = sc.nextFloat();
			
			if((A == 0) || (B == 0)) {
				System.out.println("#" + tc + "Err : By Zero");
				continue;
			}
			
			else {
				AnsN = String.format("%.2f", Division(A, B));
				System.out.println("#" + tc + " " + AnsN);
			}
		}	//	End Test Case
	}	//	End Main
	
	public static float Division(float a, float b) {
		return a/b;
	}	//	End Division
}	//	End Class