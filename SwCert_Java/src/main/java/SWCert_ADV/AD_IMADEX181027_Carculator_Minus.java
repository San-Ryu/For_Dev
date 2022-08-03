package SWCert_ADV;

import java.io.*;
import java.util.*;

public class AD_IMADEX181027_Carculator_Minus {
	static String A, B;
	static String AnsN;
	
	static boolean PMA, PMB;
	static ArrayDeque<Integer> AA;
	static ArrayDeque<Integer> BB;
	static ArrayDeque<Integer> Res;
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("Input (AD_IMADEX181027_Carculator_Minus).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= T; tc++) {
		//	Init. & Ipt.
			AnsN = "0";
			
			st = new StringTokenizer(br.readLine());
			A = st.nextToken();
			B = st.nextToken();
			
			if(A.charAt(0) == '-')	PMA = true;
			if(B.charAt(0) == '-')	PMB = true;
			
			AA = new ArrayDeque<>();
			for(int i = (A.length() - 1); 0 <= i; i--) {
				if(A.charAt(i) == '-')	continue;
				AA.add((int) A.charAt(i) - '0');
			}
			
			BB = new ArrayDeque<>();
			for(int i = (B.length() - 1); 0 <= i; i--) {
				if(B.charAt(i) == '-')	continue;
				BB.add((int) B.charAt(i) - '0');
			}
		//	Init. & Ipt.
			
		//	Oper
			if(PMA == PMB) {
				if(PMA) {	//	둘 다 음수
				}
				
				else if(!PMA) {	//	둘 다 양수
					
				}
			}
			
			if(PMA != PMB) {
				if(PMA) {	//	A가 음수
					
				}
				
				else if(PMB) {	//	B가 음수
					
				}
			}
		//	Oper
			
		//	Opt.
			System.out.println("#" + tc + " " + AnsN);
			System.out.println(PMA + " " + A + " " + AA.toString());
			System.out.println(PMB + " " + B + " " + BB.toString());
		//	Opt.			
		}	//	End Test Case
	}	//	End Main Method
}	//	End Class