/*
 * [��������]
 * ����                         ���⿩��
 * Į�ǳ뷡                   ������
 * ��ο� ������ �Ÿ�     ���Ⱑ��
 */

/*[��ü�𵨸�]
 * ��ü�� Ư¡: å����, ���⿩��
 * ��ü�� ���: ���⿩�θ� ó���Ѵ�.
 */
package Java_Basic;

class Book{
	String title;
	boolean state;
	String process() {
		if(state)
			return "���Ⱑ��";
		else
			return "������";					
	}
}//end Book
public class Java0702_class {

	public static void main(String[] args) {
		Book bk=new Book();
		bk.title="Į�� �뷡";
		bk.state=false;
		
		System.out.printf("%s, %s\n", bk.title, bk.process());
		
		Book bs=new Book();
		bs.title="��ο� ������ �Ÿ�";
		bs.state=true;
		System.out.printf("%s, %s\n", bs.title, bs.process());
	}//end main()

}//end class