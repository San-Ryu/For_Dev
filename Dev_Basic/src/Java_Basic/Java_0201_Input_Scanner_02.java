package Java_Basic;

import java.util.Scanner;

/*
 * Input
 * Scanner
 * 
 * <�Է�1 (sc.nextLine()���� ���� ó�� ���� ���)>			
 * 1	hi
 * 
 * <�Է�2 (sc.nextLine()���� ���� ó�� ���� ���)>
 * 1
 * hi
 * 		
 * <���> (�ǵ�)
 * 1
 * hi		 	
 * 
 * ������, sc.nextLine();
 * �κ��� ������ ���,
 * n�� �ش��ϴ� ������ �Է��ϰ��� ������ �� ��,
 * \n�� Str���� �ԷµǾ�,
 * 
 * <���>
 * 1\n
 * [���ڿ�]
 * 
 * �׷��Ƿ� Str�� �Է¹ޱ� ���� sc.nextLine�� ����� ���,
 * sc.nextLine()�� �̸� �����Ͽ� ������ �̸� ó�����־�� �Ѵ�.
 */
public class Java_0201_Input_Scanner_02 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		sc.nextLine(); // �ش� �κп� ����, �Է°��� �޶����� �Ѵ�.
		String str = sc.nextLine();

		System.out.println(n + "\n" + str);
	}
}
