package Etc;

/*

6
2
1 10
1 20
2
2
2



empty
20 10
10 20
empty
*/
import java.io.*;
import java.util.*;

public class Source_QStk {
	static int N, Odr, Num;
	
	static Queue<Integer> q;
	static Stack<Integer> stk;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		q = new LinkedList<>();
		stk = new Stack<>();
		
		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			Odr = Integer.parseInt(st.nextToken());
			
			if(Odr == 1){
				Num = Integer.parseInt(st.nextToken());
				q.add(Num);
				stk.add(Num);
			}
			
			else if(Odr == 2){
				if(q.isEmpty() && stk.isEmpty())	System.out.println("empty");
				else	System.out.println(stk.pop() + " " + q.poll());
			}
		}
	}
}