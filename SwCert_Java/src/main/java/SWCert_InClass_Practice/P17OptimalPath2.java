package SWCert_InClass_Practice;

import java.util.Scanner;

public class P17OptimalPath2 {
	static int min;
	static int[] x = new int[12];
	static int[] y = new int[12];
	static int[] order = new int[12];
	static int[][] G = new int[12][12];// 좌표간 거리
	static int N;
	
	static int ABS(int a){ return a > 0 ? a : -a; }
	
	static void calcdist()
	{	//무향이므로 반만 나눠서 계산 후 반반 같이 적어준다 
		for (int i = 0; i <= N; i++){
			for (int j = i + 1; j <= N + 1; j++){
				G[i][j] = ABS(x[i] - x[j]) + ABS(y[i] - y[j]);
				G[j][i] = G[i][j];
			}
		}
	}
	
	static void findPath(int k, int n, int dist, int visit)
	{
		if (dist >= min) return;
		if (k == n + 1){ // 단말노드에 도착, 모든 선택이 이루어짐.
			
			dist += G[order[n]][order[n + 1]];			
			if (dist < min) min = dist;		
			
			return;
		}
		//1부터 N까지 
		for (int i = 1; i <= n; i++)
		{
			if ((visit & (1 << i)) != 0) continue;
			order[k] = i; //k번째 순서에 i방문
			                             //이전방문정점
			findPath(k + 1, n, dist + G[order[k - 1]][i], visit | (1 << i));
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++)
		{
			N = sc.nextInt();
			x[0] = sc.nextInt();//회사
			y[0] =  sc.nextInt();
			x[N + 1] =  sc.nextInt(); //집
			y[N + 1] = sc.nextInt();
			
			order[0] = 0;  order[N + 1] = N + 1; // 고정
		
			for (int i = 1; i <= N; i++)
			{
				x[i] =  sc.nextInt();
				y[i] =  sc.nextInt();
			}		
			calcdist();
		
			min = 0xffffff;
			findPath(1, N, 0, 0);
		
			System.out.println("#" + tc + " " + min);
		}
		sc.close();
	}
}
