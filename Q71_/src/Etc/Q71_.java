package Etc;
  
import java.io.*;
import java.util.*;

public class Q71_ {
	static int V, E;
	
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("c:\\temp\\q71.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String strLine = "";
		while((strLine = br.readLine()) != null) {
			int intA = 0;
			int intB = 0;
			int ansN = 0;
			
			String[] arrLine = strLine.split(" ");
			intA = Integer.parseInt(arrLine[0]);
			intB = Integer.parseInt(arrLine[2]);
			
			
			switch (arrLine[1]) {
				case "+":
					ansN = intA + intB;
					break;
				case "-":
					ansN = intA - intB;
					break;
				case "*":
					ansN = intA * intB;
					break;
				case "/":
					ansN = intA / intB;
					break;
				default:
					break;
			}
			System.out.println(strLine + " = " + ansN);
		}
	}
}