/*������ �������� 10, ������ �������� 2�� �Ѵ�.
 * 
 * [������]
 * �ڹ������� ������ 314.0
 * �ڹٵ����� ������ 12.56
 */
package Java_Basic;

class Circle {
	int radius; // ���� �������� �����ϴ� ��� ����
	String name; // ���� �̸��� �����ϴ� ��� ����

	public double getArea() { // ��� �޼ҵ�
		return 3.14 * radius * radius;
	}
}// end class////////////////////////

public class Java0801_Ans01_class {

	public static void main(String[] args) {
		// ���⸦ �����ϼ���.////////////////////
		Circle ca = new Circle();
		ca.name = "�ڹ�����";
		ca.radius = 10;
		Circle cb = new Circle();
		cb.name = "�ڹٵ���";
		cb.radius = 2;

		System.out.println(ca.name + "�� ������ " + ca.getArea());
		System.out.println(cb.name + "�� ������ " + cb.getArea());
	}// end main()

}// end class
