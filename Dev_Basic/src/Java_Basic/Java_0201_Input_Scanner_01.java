package Java_Basic;

import java.util.Scanner;

/*
 * Input
 * Scanner
 */
public class Java_0201_Input_Scanner_01 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int a = 0;
		int b = 0;

		a = sc.nextInt();
		b = sc.nextInt();

		int Ans = a + b;

		System.out.println("Println Ans : " + Ans);

		System.out.printf("Printf Ans : %d", Ans);

		System.out.print("Print Ans : " + Ans);
	}
}
