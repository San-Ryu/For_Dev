package SWCert_InClass;

import java.io.*;
import java.util.*;

public class Day1_01_SetDemo {
	static int arr[] = {10, 20, 30};
	static int N;
	
	public static void main(String args[]) throws Exception{
		N = arr.length;
		
		for(int set = 0; set < (1 << N); set++) {
			System.out.print("{ ");
			for(int i = 0; i < N; i++) {
				if((set & (1 << i)) != 0) {
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println("}");
		}
	}	//	End Main
}	//	End Class