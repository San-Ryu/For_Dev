package Java_Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * �ӵ� ���鿡�� BufferedReader�� �� ��ȣ�ϰ� ��
 * 
 * Ex) �� ��
 * 
 */
public class Java03_Input_BufferedReader_01 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] inpLine = br.readLine().split(" "); // Main �Լ����� IOException�� �Է������� ������, ����
		String a = inpLine[0] + inpLine[1];
		String b = inpLine[2] + inpLine[3];

		long ans = Long.valueOf(a) + Long.valueOf(b);

		System.out.println(ans); // 1��
	}
}
