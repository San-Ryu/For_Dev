package Etc;

import java.io.*;
import java.util.*;

public class Source_Coin{
	static int K;
	static int Change;
	static int AnsN;

	static boolean Flag;
	static ArrayList<Integer> Coin;
	static Queue<Integer> q;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		AnsN = 0;
		
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		
		Coin = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < K; i++){
			Coin.add(Integer.parseInt(st.nextToken()));
		}

		Collections.sort(Coin);
		Collections.reverse(Coin);
		
		st = new StringTokenizer(br.readLine());
		Change = Integer.parseInt(st.nextToken());
		
		q = new LinkedList<>();
		
		BTRK(0);
		
		while(!q.isEmpty()){
			int tmp = q.poll();
			AnsN = Math.min(AnsN, tmp);
		}
		System.out.print(AnsN);
	}
	
	public static void BTRK(int n){
		for(int i : Coin){
			if((Change - i) < 0) continue;
			if((Change - i) == 0) {
				AnsN++;
				q.add(AnsN);
				Flag = true;
				return;
			}
			if(0 < (Change - i)){
				Change-= i;
				AnsN++;
				BTRK(n + 1);
				if(Flag)	return;
				
				Change+= i;
				AnsN--;
			}
		}
	}
}