package Java_Basic;

import java.util.Scanner;

/*
 * Input
 * Scanner
 * 
 * <�Է�>			<���> (�ǵ�)
 * 1			1
 * hi			hi
 * 
 * ������, sc.nextLine();
 * �κ��� ������ ���,
 * n�� �ش��ϴ� ������ �Է��ϰ��� ������ �� ��,
 * \n�� Str���� �ԷµǾ�,
 * 
 * <���>
 * 1\n
 * �� �ȴ�.
 * 
 * �׷��Ƿ� Str�� �Է¹ޱ� ���� sc.nextLine�� ����� ���,
 * sc.nextLine()�� �̸� �����Ͽ� ������ �̸� ó�����־�� �Ѵ�.
 */
public class Java02_Input_Scanner_02 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		// sc.nextLine();
		String str = sc.nextLine();

		System.out.println(n + "\n" + str);
	}
}
