/*	ÃÖºó¼ö

 */
package SWCert_InClass;

import java.io.*;
import java.util.*;

public class Day1_MostFrequency {
	static int N;
	static int Mark[];
	static int AnsN;
	
	static int cnt[];
	static Queue<Pair> q;
	
	static class Pair{
		int Num, Freq;
		
		Pair(int Num, int Freq){
			this.Num = Num;
			this.Freq = Freq;
		}
	}
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("Ipt (MostFreq).txt"));
		Scanner sc = new Scanner(System.in);
		
		for(int T = sc.nextInt(); 0 < T; T--) {
		//	Ipt.
			AnsN = 0;
			N = sc.nextInt();
			
			cnt = new int [101];
			Mark = new int [1001];
			for(int i = 0; i < 1000; i++)	Mark[i] = sc.nextInt();

			Arrays.sort(Mark);
			
//			for(int i = 0; i < 1000; i++)	System.out.print(Mark[i] + " ");
//			System.out.println();
			
			for(int i = 0; i < 1000; i++)	cnt[Mark[i]]++;
			
			q = new LinkedList<>();
		//	Ipt.
			
			q.add(new Pair(0, cnt[0]));
			for(int i = 1; i < 99; i++) {
				if(q.peek().Freq <= cnt[i]) {
					q.add(new Pair(i, cnt[i]));
					q.poll();
				}
			}

			int tmp = q.size();
			AnsN = q.peek().Num;
			q.poll();
			for(int i = 0; i <= tmp; i++) {
				if(q.isEmpty())	break;
				
				if(AnsN < q.peek().Num) {
					AnsN = Math.max(AnsN, q.peek().Num);
					q.poll();
				}
			}
			
		//	Opt.
			System.out.println("#" + N + " " + AnsN);
		//	Opt.
		}	//	End Test Case
		
		sc.close();
		
	}	//	End Main
}	//	End Class