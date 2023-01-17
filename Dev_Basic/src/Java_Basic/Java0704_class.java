/*
 * ������(constructor)
 * 1 ��������� �ʱ�ȭ�ϱ� ���� �������� ����Ѵ�.(�ѹ��� ȣ��)
 * 2 Ŭ������� ����.
 * 3 Ŭ������ �Ѱ� �̻��� �����ڸ� ���´�.
 * 4 �����ڴ� ���ϰ��� ����.
 * 5 Ŭ������ �����ڰ� ���ǵǿ� ���������� JVM���� �⺻�����ڸ� �����Ѵ�.
 * 6 �⺻�����ڴ� Ŭ������ ���������ڸ� �״�� ����Ѵ�.
 */
package Java_Basic;

class HandPhone{
	//�������
	String name;
	String number;
	
	//�ڹٰ���ӽ�(JVM)���� �����ϴ� �⺻������
	//�����ڰ� ���ǵǿ� ���� ������ JVM���� �⺻�����ڸ� �����Ѵ�.
	HandPhone(){}
	
	HandPhone(String n, String b){
		name=n;
		number=b;
	}
	
	void prn() {
		System.out.printf("%s %s\n",name,number);
	}//end prn()
	
}//end class

public class Java0704_class {

	public static void main(String[] args) {
		HandPhone ph=new HandPhone();
		ph.name="ȫ�浿";
		ph.number="010-2542-5293";
		ph.prn();
		
		HandPhone pe=new HandPhone("�̿���", "010-5235-9223");
		pe.prn();
	}//end main()

}//end class