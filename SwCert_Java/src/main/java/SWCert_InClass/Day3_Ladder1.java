/*	사다리
*/
package SWCert_InClass;

import java.io.*;
import java.util.*;

public class Day3_Ladder1 {
	static int Map[][];
	static int AnsN;
	
	static int X, Y, Flag;
	static ArrayList<Integer> SArr;
	
	static int dY[] = {-1, 1};
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("Ipt (Ladder).txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = 10;	//	10개의 TC
		for(int tc = 1; tc <= T; tc++) {
		//	Ipt.
			tc = sc.nextInt();
			AnsN = Flag = 0;
			
			int N = 100;	//	N은 100으로 고정
			
			Map = new int[N][N];
			SArr = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					Map[i][j] = sc.nextInt();
					
					if((i == 0) && (Map[i][j] == 1))	SArr.add(j);	//	출발점의 X좌표 저장
					if((i == 99) && (Map[i][j] == 2))	Flag = SArr.indexOf(j);		//	지정된 도착점의 X좌표
				}
			}
		//	Ipt.
			System.out.println(SArr);
			System.out.println(Flag);
			
			
			int Y = 99;
			while(0 < Y) {
				int X = SArr.get(Flag);
				if(X == 0) {
					if(Map[X + 1][Y] == 0)	Y--;
					else if(Map[X + 1][Y] == 1) {
						Y--;
						Flag++;
					}
				}
				
				else if(X == SArr.size()) {
					if(Map[X - 1][Y] == 0)	Y--;
					else if(Map[X - 1][Y] == 1) {
						Y--;
						Flag--;
					}
					
				}
				
				else if(0 < X || X < SArr.size()) {
					if((Map[X - 1][Y] == 0) && (Map[X + 1][Y] == 0))	Y--;
					
					else if(Map[X - 1][Y] == 1) {
						Flag--;
						Y--;
					}
					
					else if(Map[X + 1][Y] == 1) {
						Flag++;
						Y--;
					}
				}
			}
			
		//	Opt.
			AnsN = SArr.get(Flag);
			System.out.println("#" + tc + " " + AnsN);
		//	Opt.
		}	//	End Test Case
	}	//	End Main
}	//	End Class
