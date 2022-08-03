package SWCert_InClass_Practice;

import java.util.Scanner;

public class P04Sudoku {
	static int[][] map = new int[9][10];

	static boolean rowcheck(){

		boolean[][] visit = new boolean[9][10];
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				if (visit[i][map[i][j]]) 
					return false;
				visit[i][map[i][j]] = true;
			}
		}
		return true;
	}
	static boolean colcheck(){

		boolean[][] visit = new boolean[9][10];
		
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				if (visit[i][map[j][i]]) 
					return false;
				visit[i][map[j][i]] = true;
			}
		}
		return true;
	}
	static boolean rectcheck()
	{
		for (int r = 0; r < 9; r += 3)
		{
			for (int c = 0; c < 9; c += 3)
			{
				boolean[] visit = new boolean[10];
				for (int i = 0; i < 3; i++)
				{
					for (int j = 0; j < 3; j++)
					{
						if (visit[map[r + i][c + j]]) 
							return false;
						visit[map[r + i][c + j]] = true;
					}
				}
			}
		}
		return true;
	}
		
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++)
		{
			for (int i = 0; i < 9; i++)
			{
				for (int j = 0; j < 9; j++)
					map[i][j] = sc.nextInt();
			}

			if (rowcheck() && colcheck() && rectcheck())
				System.out.println("#" + tc + " 1");
			else System.out.println("#" + tc + " 0");
		}
		sc.close();
	}
}
