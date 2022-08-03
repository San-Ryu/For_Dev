package SWCert_InClass_Practice;

import java.util.Scanner;

public class P18MakeNumber {
	static int MAXN = 12;
	static int N;
	static int[] op = new int[4];	
	static int[] num = new int[MAXN];
	static int[] order = new int[MAXN];
	static int min, max;

	static int calc()
	{
		int ret = num[0];
		for (int i = 0; i <= N - 2; i++)
		{
			switch (order[i]){
			case 0:
				ret = ret + num[i + 1];
				break;
			case 1:
				ret = ret - num[i + 1];
				break;
			case 2:
				ret = ret * num[i + 1];
				break;
			case 3:
				ret = ret / num[i + 1];
				break;
			}
		}
		return ret;
	}
	static void makeExp(int k)
	{
		if (k == N - 1) {
			int ret = calc();
			min = Math.min(ret, min);
			max = Math.max(ret, max);
			return;
		}
		for (int i = 0; i < 4; i++)
		{
			if (op[i] == 0) continue;
			op[i]--;
			order[k] = i;
			makeExp(k + 1);
			op[i]++;
		}
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++)
		{
			N = sc.nextInt();

			op[0] = sc.nextInt(); 
			op[1] = sc.nextInt();
			op[2] = sc.nextInt(); 
			op[3] = sc.nextInt();
			
			for (int i = 0; i < N; i++)
				num[i] = sc.nextInt();

			min = 0xffffff;
			max = -0xffffff;
			makeExp(0);
			System.out.printf("#%d %d\n", tc, max - min);
		}
		sc.close();
	}

}
