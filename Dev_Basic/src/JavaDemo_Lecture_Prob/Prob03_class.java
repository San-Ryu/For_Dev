/*
 * draw()�޼ҵ带   [������]�� �����Ͽ� �����ϼ���.
 * 
 * [������]
 * &&&&&&&&&&
 * %%%%%%%%%%%%%%%%%%%%
 * %%%%%%%%%%%%%%%%%%%%
 * %%%%%%%%%%%%%%%%%%%%
 */
package JavaDemo_Lecture_Prob;

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
		
		

	}// end draw()

	public void fill(char c) { 
		// �ڽ��� �׸��µ� ����ϴ� ���� ����
		this.fillChar = c;
		
	}//end fill( )
}//end class

public class Prob03_class {

	public static void main(String[] args) {
		//���⸦  �����ϼ���.
		

	}//end main()

}//end class
