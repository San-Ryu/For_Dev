package Java_Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 속도 측면에서 BufferedReader를 더 선호하게 됨
 * 
 * Ex) 네 수
 * 
 */
public class Java03_Input_BufferedReader_01 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] inpLine = br.readLine().split(" "); // Main 함수에서 IOException을 입력해주지 않으면, 오류
		String a = inpLine[0] + inpLine[1];
		String b = inpLine[2] + inpLine[3];

		long ans = Long.valueOf(a) + Long.valueOf(b);

		System.out.println(ans); // 1차
	}
}
