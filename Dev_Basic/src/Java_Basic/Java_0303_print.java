package Java_Basic;

public class Java_0303_print {

	public static void main(String[] args) {
		/*
		 * printf("�������", ��1, ��2...)
		 * 
		 * ������ (��±�ȣ)
		 * %d:����
		 * %f:�Ǽ�
		 * %c:����
		 * %s:���ڿ�
		 * %b:��
		 * %% : %
		 *\ :Ű���忡�� �����ϴ� ���ڸ� ǥ���Ҷ�
		 */
		// �����ڰ� ������, �ڿ� ������ �������൵ �ݿ����� ����.
		System.out.printf("Ex01) ���� ���\n", 'a', true, 10);
		// �����ڰ� �־�� �ش� ������ ���忡 ��µ�
		System.out.printf("%c %b %d\n", 'a', true, 10);
		
		// �Ҽ��� ���
		System.out.printf("Ex02) float ��� \n");
		System.out.printf("%.2f\n",4.59);
		// �ڸ����� �� ������ �ݿø� �ݿ���
		System.out.printf("%.1f\n",4.59);
		System.out.printf("%.1f\n",4.54);
		// 5�� ���ڸ��� (�Ҽ�������)
		System.out.printf("%.4f\n",4.54554);
		// %[��ü ����].[�Ҽ��� �ڸ���]
		// 1) [��ü ����] �κ��� �ش� ������ �� ���̸� ��Ÿ��
		// 2) [�Ҽ��� �ڸ���] �κ��� �Ҽ����� �ڸ����� ��Ÿ��
		// 3) �׷��� [�Ҽ��� �ڸ���]�� �� ū ���, �ش� ���̸� ����. 
		// Padding(ä���� ����)�� 0���� �����Ǿ�� �ϸ�, �ٸ� ����(���� ����)�� ������ UnknownFormatConversionException �߻�
		System.out.printf("%06.03f\n",4.54); // 04.540
//		System.out.printf("%06.0100f\n",4.54); // 4.5400000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
//		System.out.printf("%06.20f\n",4.54); // 4.54000000000000000000
//		System.out.printf("%06.A3f\n",4.54); // UnknownFormatConversionException
		
		// 3 % 2 = 1
		System.out.printf("%d %% %d = %d\n",3,2,3%2);
		
		// ����� ������ "�Ķ�"�Դϴ�
		System.out.printf("����� ������ \"%s\" �Դϴ�\n","�Ķ�");
       
	}//end main()

}//end class