package SWCert_ADV;

import java.util.*;
import java.io.*;

public class AD_DFS_Basis_YourDFS {
	static int N;
	static int Rand[];
	static int Answer;
	
	static int Table[];
	static int Stat[];
	static int EA[];
	public static void main(String args[]) throws Exception{
		Random rand = new Random();
		
		N = 100;
		
		Rand = new int [N];
		for(int i = 0; i < N; i++) {
			Rand[i] = rand.nextInt(100);
		}
		
		Table = new int [N];
		Stat = new int [N];
		EA = new int [N];
		
		DFS(100);

		for(int i = 0; i < 100; i++) {
			System.out.println(i + ") " + Table[i] + " : " + EA[i + 1]);
		}
		
	}
	
	public static void DFS(int n) {
		for(int i = 1; i <= 100; i++) {
			if(Stat[i] == 0) {
				Stat[i] = 1;
				Table[i] = Rand[i];
				
			}
		}
	}
}
