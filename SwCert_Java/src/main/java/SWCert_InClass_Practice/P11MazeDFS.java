package SWCert_InClass_Practice;

import java.util.Scanner;

public class P11MazeDFS {
	static int SIZE = 16;
	static int[][] data = new int[SIZE][SIZE];
	
	static int[] dx = new int[]{ 0, 0, 1, -1 };
	static int[] dy = new int[]{ 1, -1, 0, 0 };	
	
	static int search(int x, int y)
	{
		if(data[x][y] == 3) return 1;
		if(data[x][y] == 1) return 0;
		if(x < 0 || y < 0 || x == SIZE || y == SIZE) return 0;
		
		data[x][y] = 1;
		
		for(int i = 0; i < 4; i++)
			if(search(x + dx[i], y + dy[i]) == 1) return 1;
		
		data[x][y] = 0;
		return 0;
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	
		for (int tc = 1; tc <= 10; tc++)
		{			
			int N = sc.nextInt();
			
			int x = 0, y = 0;
			for (int i = 0; i < SIZE; i++)
			{
				String str = sc.next();
				for (int j = 0; j < SIZE; j++)
				{
					data[i][j] = str.charAt(j) - '0';
					
					if (data[i][j] == 2){ x = i; y = j; }									
				}
			}			
			System.out.println("#" + tc + " " + search(x, y));
		}
		sc.close();
	}
}
