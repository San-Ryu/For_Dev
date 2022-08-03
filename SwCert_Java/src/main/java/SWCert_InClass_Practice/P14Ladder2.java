package SWCert_InClass_Practice;

import java.util.Scanner;

public class P14Ladder2 {
	static int SIZE = 100;
	static int[][] data = new int[SIZE][SIZE];

	static int findShortest()	// 위에서 아래로
	{
		int cnt, min = 0xfffffff, ret = 0;
		for (int i = 0; i < SIZE; i++)
		{
			if (data[0][i] == 0) continue;
			int x = 0; 
			int y = i; 
			cnt = 0;
			
			while (x != SIZE - 1)
			{
				if (y + 1 < SIZE && data[x][y + 1] == 1)
				{
					while (y + 1 < SIZE && data[x][y + 1] == 1){
						y++; cnt++;
					}
					x++;
				}
				else if (y - 1 >= 0 && data[x][y - 1] == 1)
				{
					while (y - 1 >= 0 && data[x][y - 1] == 1){
						y--; cnt++;
					}
					x++;
				}
				else x++;
			}
			if(cnt < min) { min = cnt; ret = i;}
		}
		return ret;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++)
		{
			int caseNum = sc.nextInt();
			
			for (int i = 0; i < SIZE; i++){
				for (int j = 0; j < SIZE; j++){
					data[i][j] = sc.nextInt();
				}
			}
			
			System.out.println("#" + tc + " " + findShortest());
		}
		sc.close();
	}
}
