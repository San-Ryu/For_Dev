package SWCert_PRO;

import java.io.*;

public class Pro_B10844_DP_EasyStair_TD {
	static int N;
	static int dp[];
	static int p[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.valueOf(br.readLine());
		dp = new int[N + 1];
		p = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			p[i] = Integer.valueOf(br.readLine());
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= i; j++) {
				dp[i] = Math.max(p[j] + dp[i - j], dp[i]);
			}
		}
		
		System.out.println(dp[N]);
	}
}