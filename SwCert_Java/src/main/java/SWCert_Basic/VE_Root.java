package SWCert_Basic;

import java.util.Scanner;
import java.io.FileInputStream;

public class VE_Root {
	static int T;
	static float A;
	
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("D:\\Redan_Workspace\\SWCert_Src\\Input (Root).txt"));
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			A = sc.nextFloat();
			String num = String.format("%.2f", Math.sqrt(A));
			System.out.println("#" + test_case + " " + Math.sqrt(A) + "\t" + num);
			// Math.sqrt() : 제곱근
			// Math.cbrt() : 세제곱근
			// Math.pow(A , B) : 첫번째 매개변수와 두번째 매개변수만큼의 제곱값
			// Math.scalb() : <첫번째 매개변수> * 2 ^ <매개변수>
			// Math.hypot() : (<첫번째 매개변수> ^ 2) + (<두번째 매개변수> ^ 2)
		}
	}
}
