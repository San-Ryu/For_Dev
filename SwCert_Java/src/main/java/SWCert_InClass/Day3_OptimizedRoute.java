/*	사다리
*/
package SWCert_InClass;

import java.io.*;
import java.util.*;

public class Day3_OptimizedRoute {
	static int N;	//	고객 수
	static int sX, sY, tX, tY;	//	회사 X, Y / 집 X, Y
	static int Client[][];	//	고객 X, Y
	static int AnsN;	//	결과값 (최적 경로)
	
	static int tc, Sum;
	static boolean Stat[];
	static Queue<Integer> qSum;
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("Ipt (OptimizedRoute).txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();	//	10개의 TC
		for(tc = 1; tc <= T; tc++) {
		//	Ipt.
			AnsN = Sum = 0;
			N = sc.nextInt();
			
			sX = sc.nextInt();
			sX = sc.nextInt();
			tX = sc.nextInt();
			tY = sc.nextInt();
			
			Client = new int[N][2];
			for(int i = 0; i < N; i++) {
				Client[i][0] = sc.nextInt();
				Client[i][1] = sc.nextInt();
			}
			
			Stat = new boolean [N];
			qSum = new LinkedList<>();
		//	Ipt.
			
			Route(sX, sY, 0);
			
		//	Opt.
			AnsN = qSum.poll();
			System.out.println("#" + tc + " " + AnsN);
		//	Opt.
		}	//	End Test Case
	}	//	End Main Method
	
	public static void Route(int X, int Y, int Deg) {
		if(Deg == N)	{
			Sum += Math.abs(X - tX) + Math.abs(Y - tY);
			
			if(qSum.size() == 0)	qSum.add(Sum);
			
			if(Sum < qSum.peek()) {
				qSum.add(Sum);
				qSum.poll();
			}
			Sum -= Math.abs(X - tX) + Math.abs(Y - tY);
			
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!Stat[i]) {
				Stat[i] = true;
				Sum += (Math.abs(X - Client[i][0]) + Math.abs(Y - Client[i][1]));
				Route(Client[i][0], Client[i][1], Deg + 1);
				Stat[i] = false;
				Sum -= (Math.abs(X - Client[i][0]) + Math.abs(Y - Client[i][1]));
			}
		}
	}	//	End Route Method
}	//	End Class
