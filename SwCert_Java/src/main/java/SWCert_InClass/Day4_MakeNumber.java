/*	숫자 만들기

 */
package SWCert_InClass;

import java.io.*;
import java.util.*;

public class Day4_MakeNumber {
	static int N;	//	N = 본문 예제
	static int KOper[];	//	각 연산자의 갯수
	static ArrayList<Integer> Numbers;	//	수식에 사용되는 숫자 일람
	static int AnsN;	//	결과값 (최댓값과 최솟값의 차이)
	
	static int Max, Min;	//	 최댓값, 최솟값
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream(""));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
		//	Ipt.
			AnsN = Max = Min = 0;
			
			N = sc.nextInt();
			
			KOper = new int [N - 1];
			for(int i = 0; i < KOper.length; i++)	KOper[i] = sc.nextInt();
				
			Numbers = new ArrayList<>();
			for(int i = 0; i < N; i++)	Numbers.add(sc.nextInt());
		//	Ipt.
			
			
			
		//	Opt.
			
		//	Opt.
		}	//	End Test Case
	}	//	End Main
}	//	End Class