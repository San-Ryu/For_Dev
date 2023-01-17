package Java_Basic;

import java.util.Scanner;

/*
 * Input
 * Scanner
 * 
 * <입력1 (sc.nextLine()으로 개행 처리 안할 경우)>			
 * 1	hi
 * 
 * <입력2 (sc.nextLine()으로 개행 처리 해준 경우)>
 * 1
 * hi
 * 		
 * <출력> (의도)
 * 1
 * hi		 	
 * 
 * 하지만, sc.nextLine();
 * 부분이 누락될 경우,
 * n에 해당하는 정수를 입력하고나서 개행을 할 때,
 * \n이 Str으로 입력되어,
 * 
 * <출력>
 * 1\n
 * [문자열]
 * 
 * 그러므로 Str을 입력받기 위해 sc.nextLine을 사용할 경우,
 * sc.nextLine()을 미리 팁력하여 개행을 미리 처리해주어야 한다.
 */
public class Java_0201_Input_Scanner_02 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		sc.nextLine(); // 해당 부분에 따라, 입력값이 달라져야 한다.
		String str = sc.nextLine();

		System.out.println(n + "\n" + str);
	}
}
