/*
 * ���� : �ϳ��� ���� �����ϱ� ���� �޸� ����
 * �迭
 *   1. ���� ������ Ÿ���� ���� ������ �ϳ��� �������� �ٷ�� ���̴�.
 *   2. ���� ���� ��(������)�� �ٷ� �� �����ϴ�.
 *   3. �迭�� �� ��Ҵ� �������̴�.
 */
package Java_Basic;

public class Java0601_array {

	public static void main(String[] args) {
		int num[] =new int[3];
		num[0]=10;
		num[1]=20;
		num[2]=30;
		
		//length : �迭�� ũ��
		for(int i=0; i<num.length;i++) {
			System.out.println(num[i]);
		}	

	}//end main()

}//end class