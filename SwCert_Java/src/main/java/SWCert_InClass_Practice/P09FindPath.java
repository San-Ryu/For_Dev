package SWCert_InClass_Practice;

import java.util.Scanner;

public class P09FindPath {
	static int[] visited = new int[100];
	// 배열로 인접 리스트를 흉내냄. 인접정점 최대 2개
	static int[] arr1 = new int[100];
	static int[] arr2 = new int[100];
	
	static int path(int v)
	{
		if (v == 99) return 1;
		visited[v] = 1;
		
		if (arr1[v] != -1 && visited[arr1[v]] == 0)
			if (path(arr1[v]) != 0) return 1;

		if (arr2[v] != -1 && visited[arr2[v]] == 0)
			if (path(arr2[v]) != 0) return 1;

		return 0;
	}


	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++)
		{
			int n = sc.nextInt();
			int len = sc.nextInt();;
			
			for (int i = 0; i < 100; i++)
			{
				visited[i] = 0;
				arr1[i] = arr2[i] = -1;
			}

			for (int i = 0; i < len; i++)
			{
				int u = sc.nextInt();
				int v = sc.nextInt();
				
				if (arr1[u] == -1)
					arr1[u] = v;
				else
					arr2[u] = v;
			}		
			System.out.println("#" + tc + " " + path(0));
		}			
		sc.close();
	}

}
