package Java_Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * BufferedReader의 경우,
 * Scanner와 같이 nextInt / nextDouble 등 입력 메서드가 다양하지 못함.
 * read() / readLine만 존재하므로 정수를 입력받을 경우, 파싱을 해줘야 함.
 * > StringTokenizer : 입력값을 Token으로 잘라야 할 때 필요
 * 
 * Ex) 더하기 3
 * 수 N개가 주어졌을 때, N개의 합을 구해야 함
 */
public class Java_0202_Input_BufferedReader_02 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	}
}
