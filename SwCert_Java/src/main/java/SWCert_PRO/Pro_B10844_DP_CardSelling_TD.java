package SWCert_PRO;

import java.io.*;

public class Pro_B10844_DP_CardSelling_TD {
	static final int mod = 1000000000;
	static int d[][];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.valueOf(br.readLine());
		d = new int[N + 1][10];
		
		int Answer = 0;
		for(int i = 0; i < 10; i++) {
			Answer += go(N, i);
		}
		
		System.out.println(Answer);
	}
	
		static int go(int n, int i) {
			if(n == 1) {
				if(i == 0) {
					return 0;
				}
				return 1;
			}
			if(d[n][i] > 0) {
				return d[n][i];
			}
			
			if(i == 0) {
				d[n][i] = go(n - 1, 1) % mod;
			}
			else if(i == 9) {
				d[n][i] = go(n - 1, 8) % mod;
			}
			else {
				d[n][i] = (go(n - 1, i - 1) % mod + go(n - 1, i + 1) % mod) % mod;
			}
			return d[n][i];
		}
	}