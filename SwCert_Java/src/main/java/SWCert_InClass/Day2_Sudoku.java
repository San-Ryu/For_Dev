/*

 */
package SWCert_InClass;

import java.io.*;
import java.util.*;

public class Day2_Sudoku {
	static int Map[][];
	static int AnsTF;
	
	static boolean Flag, Stat[];
	public static void Check(int N) {
		if((N == 9) && !Flag)	{
			AnsTF = 1;
			return;
		}
		
		Flag = false;
		
		//	행 체크
		Stat = new boolean[9];
		for(int i = 0; i < 9; i++) {
			if(Stat[Map[N][i] - 1])	{
				Flag = true;
				AnsTF = 0;
				break;
			}
			
			Stat[Map[N][i] - 1] = true; 
		}
		
		//	열 체크
		Stat = new boolean[9];
		for(int i = 0; i < 9; i++) {
			if(Stat[Map[i][N] - 1])	{
				Flag = true;
				AnsTF = 0;
				break;
			}
			
			Stat[Map[i][N] - 1] = true; 
		}
		
		//	재귀
		if(!Flag) {
			Check(N + 1);
		}
		
	}
	
	public static void Matrix(int X, int Y) {
		//	칸 체크
		Stat = new boolean[9];
		int sX = 3 * X;
		int eX = sX + 2;
		int sY = 3 * Y;
		int eY = sY + 2;
		for(int i = sX; i <= eX; i++) {
			for(int j = sY; j <= eY; j++) {
				if(Stat[Map[i][j] - 1])	{
					Flag = true;
					AnsTF = 0;
					return;
				}
				Stat[Map[i][j] - 1] = true; 
			}
		}
	}
	
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("Ipt (Sudoku).txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
		//	Ipt.
			AnsTF = 0;
			
			Map = new int[9][9];
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					Map[i][j] = sc.nextInt();
				}
			}
			
			
		//	Ipt.
			
			Check(0);
			if(!Flag)	{
				for(int i = 0; i < 3; i++) {
					for(int j = 0; j < 3; j++) {
						Matrix(i, j);
					}
				}
			}
			
		//	Opt.
//			for(int i = 0; i < 9; i++) {
//				int j = i;
//				System.out.print(Map[i][j] + " ");
//			}
			System.out.println("#" + tc + " " + AnsTF);
		//	Opt.
		}	//	End Test Case
	}	//	End Main
}	//	End Class
