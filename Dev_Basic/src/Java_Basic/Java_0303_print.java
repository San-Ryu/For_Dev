package Java_Basic;

public class Java_0303_print {

	public static void main(String[] args) {
		/*
		 * printf("�������", ��1, ��2...)
		 * 
		 * ��±�ȣ
		 * %d:����
		 * %f:�Ǽ�
		 * %c:����
		 * %s:���ڿ�
		 * %b:��
		 * %% : %
		 *\ :Ű���忡�� �����ϴ� ���ڸ� ǥ���Ҷ�
		 */
       System.out.printf("%c %b %d\n", 'a', true, 10);
       
       System.out.printf("%.2f\n",4.59);
       System.out.printf("%.1f\n",4.54); //�ݿø�
       //5�� ���ڸ��� (�Ҽ�������)
       System.out.printf("%5.1f\n",4.54);
       //3%2=1
       System.out.printf("%d%%%d=%d\n",3,2,3%2);
       //����� ������ "�Ķ�"�Դϴ�
       System.out.printf("����� ������   \"%s\" �Դϴ�\n","�Ķ�");
       
	}//end main()

}//end class