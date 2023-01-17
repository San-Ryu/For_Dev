/*
 * draw()�޼ҵ带   [������]�� �����Ͽ� �����ϼ���.
 * 
 * [������]
 * &&&&&&&&&&
 * %%%%%%%%%%%%%%%%%%%%
 * %%%%%%%%%%%%%%%%%%%%
 * %%%%%%%%%%%%%%%%%%%%
 */
package Java_Basic;

class Box {
	private int width, height; // �ڽ��� �ʺ�� ����
	private char fillChar; // �ڽ��� �׸��� �� ����ϴ� ����

	public Box() { // �Ű� ���� ���� ������
		this(10, 1); // this() �̿�
	}

	public Box(int width, int height) { // �ʺ�� ������ 2 �Ű� ������ ���� ������
		this.width = width;
		this.height = height;
	}

	public void draw() { // �ڽ� �׸��� �޼ҵ�
		///////////// ���⿡�� �����ϼ���.
		for(int j=1;j<=height;j++){
			for(int i=1;i<=width;i++){
				System.out.print(fillChar);
			}
			System.out.println();
		}
	}// end draw()

	public void fill(char c) { // �ڽ��� �׸��µ� ����ϴ� ���� ����
		this.fillChar = c;
	}
}

public class Java0803_Ans03_class {

	public static void main(String[] args) {
		//���⸦  �����ϼ���.
		Box a = new Box(); // 10x1 �簢��
		Box b = new Box(20, 3); // 20x3 �簢��
		a.fill('&'); // box�� �׸� �� ����ϴ� ���� '&'
		b.fill('%'); // box�� �׸� �� ����ϴ� ���� '%'
		a.draw(); // �ڽ� �׸���
		b.draw(); // �ڽ� �׸���

	}//end main()

}//end class
