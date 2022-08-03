package SWCert_ADV;

import java.io.*;
import java.util.*;

public class AD_DFS_Basis {
	static int S, E;
	
	public static void main(String args[]) throws Exception{
		S = 0;
		E = 5;
		
		DFS(S);
	}	//	End Main Method
	
	public static void DFS(int n) {
		if(n == E) {
			System.out.print(n + " ");
			return;
		}
		
		System.out.print(n + " ");
		n++;
		DFS(n);
		n--;
		System.out.print(n + " ");
		
	}	//	ENd DFS Method
}	//	End Class
