/*
10 1238099084
16 4100112380990844
26 12380990844100112380990844
42 123809908444100112380990844100112380990844
55 1238099084441001123809908441001321238099084432180990844
60 123809908444100145351123809908441001321238099084432180990844
71 12380990844410013218099084441001123809908441001321238099084432180990844
99 123809908444100180990844410013211238099084410013212380990844123809908441238099084410013232180990844
82 1238099084441001410011238099084412380990844100132123809908441238099084432180990844
58 0899809812380990844100132123809908441238099084432180990844
 */
package SWCert_InClass;

import java.io.*;
import java.util.*;

public class Day2_Password {
	static int N;
	static String Pass, Pass2;
	static String Answer;
	
	static int tmp;
	static Deque<Integer> dq;
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("Ipt (Password).txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		for(int tc = 1; tc <= 10; tc++) {
		//	Ipt.
			Answer = "";
			tmp = 0;
			
			N = sc.nextInt();
			Pass = sc.nextLine();
			
			dq = new LinkedList<>();
			for(int i = 0; i < N; i++) {
				dq.add((int) Pass.charAt(i + 1) - '0');
			}
		//	Ipt.
			
			for(int i = 0; i < N; i++) {
				if(i == 0)	dq.add(dq.poll());
				
				else{
					SubString();
					dq.add(dq.poll());
				}
				System.out.println(dq.toString());
			}
			
		//	Opt.
			tmp = dq.size();
			for(int i = 0; i < tmp; i++) {
				Answer += dq.pollFirst();
			}
			System.out.println("#" + tc + " " + Answer);
		//	Opt.
		}	//	End Test Case
	}	//	End Main
	
	public static void SubString() {
		if(dq.peekFirst() != dq.peekLast())	return;
		
		else if(dq.peekFirst() == dq.peekLast())	{
			dq.pollFirst();
			dq.pollLast();
			N -= 2;
		}
		
	}
}	//	End Class