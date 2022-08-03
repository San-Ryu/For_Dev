package SWCert_ADV;

import java.io.*;
import java.util.*;

class AD_SWEX2805_Harvest{
	static int N;
	static int Map[][];
	static int AnsN;
	
	static boolean Flag;
	static int n;
	static int dX[] = {-1, 0, 0, 1};
	static int dY[] = {0, -1, 1, 0};
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= T; tc++) {
        //	Ipt.
			AnsN = 0;
			Flag = false;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			n = (N/2) + 1;
			
			Map = new int[N][N];
			for(int i = 0; i < N; i++)	{
				st = new StringTokenizer(br.readLine());
				String tmp = st.nextToken();
				for(int j = 0; j < N; j++) {
					Map[i][j] = (int) tmp.charAt(j) - '0';
				}
			}
		//	Ipt.
			Count(N, 0, 0);
            
        //	Opt.
			System.out.println("#" + tc + " " + AnsN);
        //	Opt.
		}
		br.close();
	}	//	End Main
	
	public static void Count(int Length, int k, int Deg) {
		if(k == N)	return;
		if(Deg == n - 1)	Flag = true;
		for(int i = (n - Deg - 1); i <= (n + Deg - 1); i++) AnsN += Map[k][i];
		if(Flag) Count(Length, k + 1, Deg - 1);
		else	Count(Length, k + 1, Deg + 1);
	}	//	End Count
}	//	End Class