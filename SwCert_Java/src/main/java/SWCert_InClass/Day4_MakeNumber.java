/*	���� �����

 */
package SWCert_InClass;

import java.io.*;
import java.util.*;

public class Day4_MakeNumber {
	static int N;	//	N = ���� ����
	static int KOper[];	//	�� �������� ����
	static ArrayList<Integer> Numbers;	//	���Ŀ� ���Ǵ� ���� �϶�
	static int AnsN;	//	����� (�ִ񰪰� �ּڰ��� ����)
	
	static int Max, Min;	//	 �ִ�, �ּڰ�
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