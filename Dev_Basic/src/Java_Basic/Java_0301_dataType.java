/*
 * ���ͳ�(literal) : �� ��ü�� ��(1,2,3,..'a','b','c'...,true, false)
 * ����(variable) : �ϳ��� ���� �����ϱ� ���� �޸� ����
 * ������ Ÿ��(data type) : ���� ������ �޸� ũ�⸦ ����
 * �ڹٿ��� �����ϴ� ������ Ÿ��
 * 1 �⺻ ������ Ÿ��(primitive data type)
 *   byte(1), short(2), int(4), long(8)=>����
 *   float(4), double(8) => �Ǽ�
 *   char(2) => ����
 *   boolean(1) => ��
 * 2 ���� ������ Ÿ�� (reference data type)
 *   �迭(array), Ŭ����(class), �������̽�(interface)
 *   
 *   �ý��ۿ��� �ν��ϴ� ������ Ÿ�� ũ��
 *   byte<short,char<int<long<float<double
 */
package Java_Basic;

public class Java_0301_dataType {

	//���� ���α׷��� �����Ҷ� ���� ���� ȣ��Ǵ� �޼ҵ� �̴�.
	public static void main(String[] args) {
		//1 ������ Ÿ������ �޸� ������ Ȯ���Ѵ�.
		//2 �޸� ������ �������� ������ �����Ѵ�.
		//3 �޸𸮿� ���� �Ҵ��Ѵ�.
		int data=3;
		
		System.out.println(data);
		
		double num=4.5;
		//ĳ���� Ÿ�Լ��� : ����� ����ȯ
		int x=(int)num;
		System.out.println(x);
		
		//ĳ���� Ÿ�� ���� : ������ ����ȯ
		long y=data;
		System.out.println(y);
		
		/*
		 * �����ڵ�
		 * 'A' => 65
		 * 'a' => 97
		 * 'o' => 48
		 */	
		
	}//end main()

}//end class