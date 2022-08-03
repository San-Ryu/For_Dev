package SWCert_InClass_Practice;

import java.util.Scanner;

public class P14Ladder1 {
	static int SIZE = 100;
	static int[][] data = new int[SIZE][SIZE];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++)
		{
			int casenum = sc.nextInt();
			
			for (int i = 0; i < SIZE; i++){
				for (int j = 0; j < SIZE; j++){
					data[i][j] = sc.nextInt();
				}
			}
			int x = 0, y = 0;
			for (int i = 0; i < SIZE; i++)
			{
				if (data[SIZE - 1][i] == 2)
				{
					x = SIZE - 1; y = i; 
					break;
				}
			}

			while (x != 0)
			{
				if (y + 1 < SIZE && data[x][y + 1] == 1)
				{
					while (y + 1 < SIZE && data[x][y + 1] == 1)
						y++;
					x--;
				}
				else if (y - 1 >= 0 && data[x][y - 1] == 1)
				{
					while (y - 1 >= 0 && data[x][y - 1] == 1)
						y--;
					x--;
				}
				else x--;
			}
			System.out.println("#" + tc + " " + y);
		}
		sc.close();
	}
}
